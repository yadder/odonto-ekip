package persistencia;

import java.util.ArrayList;
import java.util.List;

import modelo.Convenio;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;

public class DaoConvenio {

	private Session session = null;
	private Transaction transaction = null;
	
	public void cadastrarConvenio(Convenio convenio) throws HibernateException{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.persist(convenio);
		transaction.commit();
		session.flush();
		session.close();
	}

	public void alterarConvenio(Convenio convenio) throws HibernateException{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(convenio);
		transaction.commit();
		session.flush();
		session.close();
	}

	public void excluirConvenio(Convenio convenio) throws HibernateException{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(convenio);
		transaction.commit();
		session.flush();
		session.close();
	}

	public Convenio pesquisarConvenioPorNome(String nome) throws HibernateException{
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(Convenio.class).add(Restrictions.eq("nomeConvenio", nome));
		Convenio c = (Convenio) cr.uniqueResult();
		session.flush();
		session.close();
		return c;
	}

	public List<Convenio> pesquisarTodosConvenio() throws HibernateException{
		List<Convenio> lista = null;
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(Convenio.class);
		lista = (ArrayList)cr.list();
		session.flush();
		session.close();
		return lista;
	}
	

}
