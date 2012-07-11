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
	
	public void cadastrarPrescricao(Prescricao prescricao) throws HibernateException{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.persist(prescricao);
			transaction.commit();
			session.flush();
			session.close();
	}

	public void alterarPrescricao(Prescricao prescricao) throws HibernateException{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(prescricao);
			transaction.commit();
			session.flush();
			session.close();
	}

	public void excluirPrescricao(Prescricao prescricao) throws HibernateException{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(prescricao);
			transaction.commit();
			session.flush();
			session.close();
	}

	public List<Prescricao> pesquisarTodosPrescricao() throws HibernateException{
		List<Prescricao> lista = null;
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(Prescricao.class);
		lista = (ArrayList)cr.list();
		session.flush();
		session.close();
		return lista;
	}

}
