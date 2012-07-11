package persistencia;

import java.util.ArrayList;
import java.util.List;

import modelo.Acesso;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;

public class DaoAcesso {

	private Session session = null;
	private Transaction transaction = null;
	
	public void cadastrarAcesso(Acesso acesso) throws HibernateException{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.persist(acesso);
		transaction.commit();
		session.flush();
		session.close();
	}

	public void alterarAcesso(Acesso acesso) throws HibernateException{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(acesso);
		transaction.commit();
		session.flush();
		session.close();
	}

	public void excluirAcesso(Acesso acesso) throws HibernateException{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(acesso);
		transaction.commit();
		session.flush();
		session.close();
	}

	public Acesso pesquisarAcessoPorNome(String nome) throws HibernateException{
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(Acesso.class).add(Restrictions.eq("descricaoAcesso", nome));
		Acesso a = (Acesso)cr.uniqueResult();
		session.flush();
		session.close();
		return a;
	}

	public List<Acesso> pesquisarTodosAcesso() throws HibernateException{
		List<Acesso> lista = null;
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(Acesso.class);
		lista = (ArrayList)cr.list();
		session.flush();
		session.close();
		return lista;
	}

}
