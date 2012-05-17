package persistencia;
import java.util.ArrayList;
import modelo_hibernate.Convenio;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class DaoConvenio {
	Transaction transaction;
	Session session;
	Query query;
	
	public void gravar(Convenio c) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(c);
		transaction.commit();
		session.flush();
		session.close();
	}

	public void alterar(Convenio c) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(c);
		transaction.commit();
		session.flush();
		session.close();
	}
	
	public void excluir(Convenio c) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(c);
		transaction.commit();
		session.flush();
		session.close();
	}
	
	public Convenio consultar(Convenio c) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();			//nomeConvenio refere-se ao atributo da classe
		Criteria cr = session.createCriteria(Convenio.class).add(Restrictions.eq("nomeConvenio", c.getNomeConvenio()));
		c = (Convenio)cr.uniqueResult();
		session.flush();
		session.close();
		return c;
	}
	
	public ArrayList consultarTodos() throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(Convenio.class);
		ArrayList lista = (ArrayList)cr.list();		
		session.flush();
		session.close();
		return lista;
	}
	
}
