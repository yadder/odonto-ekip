package persistencia;

import java.util.ArrayList;
import java.util.List;

import modelo.Convenio;
import modelo.Procedimento;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;

public class DaoProcedimento {

	private Session session = null;
	private Transaction transaction = null;
	
	public void cadastrarProcedimento(Procedimento procedimento) throws Exception, Exception{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.persist(procedimento);
			transaction.commit();
			session.flush();
			session.close();
	}

	public void alterarProcedimento(Procedimento procedimento) throws Exception{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(procedimento);
			transaction.commit();
			session.flush();
			session.close();
	}
	
	public void excluirProcedimento(Procedimento procedimento) throws Exception{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(procedimento);
			transaction.commit();
			session.flush();
			session.close();
	}

	public Procedimento pesquisarProcedimentoPorDescricao(Procedimento procedimento) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(Procedimento.class).add(Restrictions.eq("descricaoProcedimento",procedimento.getDescricaoProcedimento()));
		Procedimento p = (Procedimento)cr.uniqueResult();
		session.flush();
		session.close();
		return p;
	}
	
	public Procedimento pesquisarProcedimentoPorId(Procedimento procedimento) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(Procedimento.class).add(Restrictions.eq("idProcedimento",procedimento.getIdProcedimento()));
		Procedimento p = (Procedimento)cr.uniqueResult();
		session.flush();
		session.close();
		return p;
	}
	
	public List<Procedimento> pesquisarProcedimentoPorConvenio(Convenio convenio) throws Exception{
		List<Procedimento> lista = null;
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(Procedimento.class).add(Restrictions.eq("convenio",convenio));
		lista = (ArrayList)cr.list();
		session.flush();
		session.close();
		return lista;
	}

	public List<Procedimento> pesquisarTodosProcedimento() throws Exception{
		List<Procedimento> lista = null;
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(Procedimento.class);
		lista = (ArrayList)cr.list();
		session.flush();
		session.close();
		return lista;
	}

}
