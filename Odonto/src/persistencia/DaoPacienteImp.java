package persistencia;

import java.util.ArrayList;
import java.util.List;
import modelo.Paciente;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;

public class DaoPacienteImp implements DaoPaciente {

	private Session session = null;
	private Transaction transaction = null;
	
	public boolean cadastrarPaciente(Paciente paciente) {
		boolean retorno = false;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.persist(paciente);
			transaction.commit();
			retorno = true;
		}catch(HibernateException e){
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		System.out.println("Paciente cadastrado com sucesso!");
		return retorno;
	}

	public boolean alterarPaciente(Paciente paciente) {
		boolean retorno = false;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(paciente);
			transaction.commit();
			retorno = true;
		}catch(HibernateException e){
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		System.out.println("Paciente alterado com sucesso!");
		return retorno;
	}

	public boolean excluirPaciente(Paciente paciente) {
		boolean retorno = false;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(paciente);
			transaction.commit();
			retorno = true;
		}catch(HibernateException e){
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		System.out.println("Paciente excluído com sucesso!");
		return retorno;
	}
	
	public Paciente pesquisarPacientePorNome(String nome){
		Paciente p = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cr = session.createCriteria(Paciente.class).add(Restrictions.eq("nomeUsuario", nome));
			p = (Paciente)cr.uniqueResult();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.flush();
			session.close();
		}
		return p;
	}

	public List<Paciente> pesquisarTodosPaciente() {
		ArrayList<Paciente> lista = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cr = session.createCriteria(Paciente.class);
			lista = (ArrayList)cr.list();
		} catch (HibernateException e) {
			e.printStackTrace();
			
		}finally{
			session.flush();
			session.close();
		}
		return lista;
	}
}
