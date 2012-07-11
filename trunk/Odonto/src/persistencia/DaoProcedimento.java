package persistencia;

import java.util.ArrayList;
import java.util.List;
import modelo.Procedimento;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

public class DaoProcedimento {

	private Session session = null;
	private Transaction transaction = null;
	
	public void cadastrarProcedimento(Procedimento procedimento) throws HibernateException{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.persist(procedimento);
			transaction.commit();
			session.flush();
			session.close();
	}

	public void alterarProcedimento(Procedimento procedimento) throws HibernateException{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(procedimento);
			transaction.commit();
			session.flush();
			session.close();
	}
	
	public void excluirProcedimento(Procedimento procedimento) throws HibernateException{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(procedimento);
			transaction.commit();
			session.flush();
			session.close();
	}

	public Procedimento pesquisarProcedimentoPorDescricao(String nome) throws HibernateException{
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(Procedimento.class).add(Restrictions.eq("descricaoProcedimento",nome));
		Procedimento p = (Procedimento)cr.uniqueResult();
		session.flush();
		session.close();
		return p;
	}

	public List<Procedimento> pesquisarTodosProcedimento() throws HibernateException{
		List<Procedimento> lista = null;
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(Procedimento.class);
		lista = (ArrayList)cr.list();
		session.flush();
		session.close();
		return lista;
	}

}
