package persistencia;

import java.util.ArrayList;
import java.util.List;
import modelo.Prescricao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class DaoPrescricao {

	private Session session = null;
	private Transaction transaction = null;
	
	public boolean cadastrarPrescricao(Prescricao prescricao) {
		boolean retorno = false;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.persist(prescricao);
			transaction.commit();
			retorno = true;
		}catch(HibernateException e){
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.flush();
			session.close();
		}
		return retorno;
	}

	public boolean alterarPrescricao(Prescricao prescricao) {
		boolean retorno = false;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(prescricao);
			transaction.commit();
			retorno = true;
		}catch(HibernateException e){
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.flush();
			session.close();
		}
		return retorno;
	}

	public boolean excluirPrescricao(Prescricao prescricao) {
		boolean retorno = false;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(prescricao);
			transaction.commit();
			retorno = true;
		}catch(HibernateException e){
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.flush();
			session.close();
		}
		return retorno;
	}

	public Prescricao pesquisarPrescricao(Prescricao prescricao) {
		Prescricao e = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			e = (Prescricao)session.get(Prescricao.class, prescricao.getIdPrescricao());
		} catch (HibernateException ex) {
			ex.printStackTrace();
		}finally{
			session.flush();
			session.close();
		}
		return e;
	}

	public List<Prescricao> pesquisarTodosPrescricao() {
		List<Prescricao> lista = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cr = session.createCriteria(Prescricao.class);
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
