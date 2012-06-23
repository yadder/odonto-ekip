package persistencia;

import java.util.ArrayList;
import java.util.List;
import modelo.InqueritoOdontologico;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class DaoInqueritoOdontologicoImp implements DaoInqueritoOdontologico {

	private Session session = null;
	private Transaction transaction = null;
	
	public boolean cadastrarInqueritoOdontologico(InqueritoOdontologico inqueritoOdontologico) {
		boolean retorno = false;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.persist(inqueritoOdontologico);
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

	public boolean alterarInqueritoOdontologico(InqueritoOdontologico inqueritoOdontologico) {
		boolean retorno = false;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(inqueritoOdontologico);
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

	public boolean excluirInqueritoOdontologico(InqueritoOdontologico inqueritoOdontologico) {
		boolean retorno = false;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(inqueritoOdontologico);
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

	public InqueritoOdontologico pesquisarInqueritoOdontologico(InqueritoOdontologico inqueritoOdontologico) {
		InqueritoOdontologico e = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			e = (InqueritoOdontologico)session.get(InqueritoOdontologico.class, inqueritoOdontologico.getIdInqueritoOdontologico());
		} catch (HibernateException ex) {
			ex.printStackTrace();
		}finally{
			session.close();
		}
		return e;
	}

	public List<InqueritoOdontologico> pesquisarTodosInqueritoOdontologico() {
		ArrayList lista = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cr = session.createCriteria(InqueritoOdontologico.class);
			lista = (ArrayList)cr.list();
		} catch (HibernateException e) {
			e.printStackTrace();
			
		}finally{
			session.close();
			return lista;
		}
		
	}

}
