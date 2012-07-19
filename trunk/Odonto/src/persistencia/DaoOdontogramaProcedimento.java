package persistencia;

import java.util.ArrayList;
import java.util.List;

import modelo.Odontograma;
import modelo.OdontogramaProcedimento;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;

public class DaoOdontogramaProcedimento {

	private Session session = null;
	private Transaction transaction = null;
	
	public void cadastrarOdontogramaProcedimento(OdontogramaProcedimento odontogramaProcedimento) throws Exception{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.persist(odontogramaProcedimento);
			transaction.commit();
			session.flush();
			session.close();
	}

	public void alterarOdontogramaProcedimento(OdontogramaProcedimento odontogramaProcedimento) throws Exception{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(odontogramaProcedimento);
			transaction.commit();
			session.flush();
			session.close();
	}

	public void excluirOdontogramaProcedimento(OdontogramaProcedimento odontogramaProcedimento) throws Exception{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(odontogramaProcedimento);
			transaction.commit();
			session.flush();
			session.close();
	}

	public OdontogramaProcedimento pesquisarOdontogramaProcedimentoPorId(long idOdontogramaProcedimento) throws Exception{
		OdontogramaProcedimento o = null;
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(OdontogramaProcedimento.class).add(Restrictions.eq("idOdontogramaProcedimeto", idOdontogramaProcedimento));
		o = (OdontogramaProcedimento)cr.uniqueResult();
		session.flush();
		session.close();
		return o;
	}
	
	public List<OdontogramaProcedimento> pesquisarOdontogramaProcedimentoPorOdontograma(Odontograma odontograma) throws Exception{
		List<OdontogramaProcedimento> lista = null;
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(OdontogramaProcedimento.class).add(Restrictions.eq("odontograma", odontograma));
		lista = (ArrayList)cr.list();
		session.flush();
		session.close();
		return lista;
	}

	public List<OdontogramaProcedimento> pesquisarTodosOdontogramaProcedimento() throws Exception{
		List<OdontogramaProcedimento> lista = null;
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(OdontogramaProcedimento.class);
		lista = (ArrayList)cr.list();
		session.flush();
		session.close();
		return lista;
	}

}
