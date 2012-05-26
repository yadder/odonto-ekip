package persistencia;

import java.util.ArrayList;
import java.util.List;
import modelo.Pagamento;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

	public Pagamento pesquisarPagamento(Pagamento pagamento) {
		Pagamento e = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			e = (Pagamento)session.get(Pagamento.class, pagamento.getCodigoPagamento());
		} catch (HibernateException ex) {
			ex.printStackTrace();
		}finally{
			session.close();
		}
		return e;
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
