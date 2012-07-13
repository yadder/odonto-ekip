package persistencia;

import java.util.ArrayList;
import java.util.List;

import modelo.Odontograma;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class DaoOdontograma {

	private Session session = null;
	private Transaction transaction = null;
	
	public void cadastrarOdontograma(Odontograma odontograma) throws Exception{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.persist(odontograma);
			transaction.commit();
			session.flush();
			session.close();
	}

	public void alterarOdontograma(Odontograma odontograma) throws Exception{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(odontograma);
			transaction.commit();
			session.flush();
			session.close();
	}

	public void excluirOdontograma(Odontograma odontograma) throws Exception{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(odontograma);
			transaction.commit();
			session.flush();
			session.close();
	}

	public List<Odontograma> pesquisarTodosOdontograma() throws Exception{
		List<Odontograma> lista = null;
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(Odontograma.class);
		lista = (ArrayList)cr.list();
		session.flush();
		session.close();
		return lista;
	}
}
