package persistencia;

import java.util.ArrayList;
import java.util.List;

import modelo.OdontogramaProcedimento;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class DaoOdontogramaProcedimento {

	private Session session = null;
	private Transaction transaction = null;
	
	public boolean cadastrarOdontogramaProcedimento(OdontogramaProcedimento odontogramaProcedimento) {
		boolean retorno = false;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.persist(odontogramaProcedimento);
			transaction.commit();
			retorno = true;
		}catch(HibernateException e){
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.flush();
			session.close();
		}
		return retorno;
	}

	public boolean alterarOdontogramaProcedimento(OdontogramaProcedimento odontogramaProcedimento) {
		boolean retorno = false;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(odontogramaProcedimento);
			transaction.commit();
			retorno = true;
		}catch(HibernateException e){
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.flush();
			session.close();
		}
		return retorno;
	}

	public boolean excluirOdontogramaProcedimento(OdontogramaProcedimento odontogramaProcedimento) {
		boolean retorno = false;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(odontogramaProcedimento);
			transaction.commit();
			retorno = true;
		}catch(HibernateException e){
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.flush();
			session.close();
		}
		return retorno;
	}

	public OdontogramaProcedimento pesquisarOdontogramaProcedimento(OdontogramaProcedimento odontogramaProcedimento) {
		OdontogramaProcedimento e = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			e = (OdontogramaProcedimento)session.get(OdontogramaProcedimento.class, odontogramaProcedimento.getIdOdontogramaProcedimeto());
		} catch (HibernateException ex) {
			ex.printStackTrace();
		}finally{
			session.flush();
			session.close();
		}
		return e;
	}

	public List<OdontogramaProcedimento> pesquisarTodosOdontogramaProcedimento() {
		List<OdontogramaProcedimento> lista = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cr = session.createCriteria(OdontogramaProcedimento.class);
			lista = (ArrayList)cr.list();
		} catch (HibernateException e) {
			e.printStackTrace();
			
		}finally{
			session.flush();
			session.close();
		}
		return lista;
	}

}
