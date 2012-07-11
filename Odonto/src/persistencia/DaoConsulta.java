package persistencia;

import java.util.ArrayList;
import java.util.List;
import modelo.Consulta;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class DaoConsulta {

	private Session session = null;
	private Transaction transaction = null;
	
	public void cadastrarConsulta(Consulta consulta) throws HibernateException{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.persist(consulta);
		transaction.commit();
		session.flush();
		session.close();
	}

	public void alterarConsulta(Consulta consulta) throws HibernateException{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(consulta);
		transaction.commit();
		session.flush();
		session.close();
	}

	public void excluirConsulta(Consulta consulta) throws HibernateException{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(consulta);
		transaction.commit();
		session.flush();
		session.close();
	}

	public List<Consulta> pesquisarTodosConsulta() throws HibernateException{
		List<Consulta> lista = null;
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(Consulta.class);
		lista = (ArrayList)cr.list();
		session.flush();
		session.close();
		return lista;
	}
}
