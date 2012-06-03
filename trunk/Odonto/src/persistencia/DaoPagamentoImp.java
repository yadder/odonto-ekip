package persistencia;

import java.util.ArrayList;
import java.util.List;
import modelo.Paciente;
import modelo.Pagamento;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;

public class DaoPagamentoImp implements DaoPagamento {

	private Session session = null;
	private Transaction transaction = null;
	
	public boolean cadastrarPagamento(Pagamento pagamento) {
		boolean retorno = false;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.persist(pagamento);
			transaction.commit();
			retorno = true;
		}catch(HibernateException e){
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return retorno;
	}

	public boolean alterarPagamento(Pagamento pagamento) {
		boolean retorno = false;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(pagamento);
			transaction.commit();
			retorno = true;
		}catch(HibernateException e){
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return retorno;
	}

	public boolean excluirPagamento(Pagamento pagamento) {
		boolean retorno = false;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(pagamento);
			transaction.commit();
			retorno = true;
		}catch(HibernateException e){
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return retorno;
	}

	public ArrayList<Pagamento> pesquisarPagamentoPaciente(Paciente paciente) {
		List lista = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cr = session.createCriteria(Pagamento.class).createCriteria("paciente").add(Restrictions.eq("codigo_pagamento",paciente.getCodigoUsuario()));
			lista = (List)cr.list();
		}catch(HibernateException e){
			session.close();
		}
		return (ArrayList)lista;
	}
	
	public List<Pagamento> pesquisarTodosPagamento() {
		ArrayList lista = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cr = session.createCriteria(Pagamento.class);
			lista = (ArrayList)cr.list();
		} catch (HibernateException e) {
			e.printStackTrace();
			
		}finally{
			session.close();
			return lista;
		}
		
	}

}
