package persistencia;

import java.util.ArrayList;
import java.util.List;

import modelo.InqueritoOdontologico;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class DaoInqueritoOdontologico {

	private Session session = null;
	private Transaction transaction = null;
	
	public void cadastrarInqueritoOdontologico(InqueritoOdontologico inqueritoOdontologico) throws Exception{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.persist(inqueritoOdontologico);
			transaction.commit();
			session.flush();
			session.close();
	}

	public void alterarInqueritoOdontologico(InqueritoOdontologico inqueritoOdontologico) throws Exception{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(inqueritoOdontologico);
			transaction.commit();
			session.flush();
			session.close();
	}

	public void excluirInqueritoOdontologico(InqueritoOdontologico inqueritoOdontologico) throws Exception{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(inqueritoOdontologico);
			transaction.commit();
			session.flush();
			session.close();
	}

	public List<InqueritoOdontologico> pesquisarTodosInqueritoOdontologico() throws Exception{
		List<InqueritoOdontologico> lista = null;
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(InqueritoOdontologico.class);
		lista = (ArrayList)cr.list();
		session.flush();
		session.close();
		return lista;
	}

}
