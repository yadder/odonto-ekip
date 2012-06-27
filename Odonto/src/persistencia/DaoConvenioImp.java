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

public class DaoConvenioImp implements DaoConvenio {

	private Session session = null;
	private Transaction transaction = null;
	
	public boolean cadastrarConvenio(Convenio convenio) {
		boolean retorno = false;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.persist(convenio);
			transaction.commit();
			retorno = true;
		}catch(HibernateException e){
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return retorno;
	}

	public boolean alterarConvenio(Convenio convenio) {
		boolean retorno = false;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(convenio);
			transaction.commit();
			retorno = true;
		}catch(HibernateException e){
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return retorno;
	}

	public boolean excluirConvenio(Convenio convenio) {
		boolean retorno = false;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(convenio);
			transaction.commit();
			retorno = true;
		}catch(HibernateException e){
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return retorno;
	}

	public Convenio pesquisarConvenio(Convenio convenio) {
		Convenio e = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			e = (Convenio)session.get(Convenio.class, convenio.getIdConvenio());
		} catch (HibernateException ex) {
			ex.printStackTrace();
		}finally{
			session.close();
		}
		return e;
	}
	
	public Convenio pesquisarConvenioPorNome(String nome){
		Convenio c = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cr = session.createCriteria(Convenio.class).add(Restrictions.eq("nomeConvenio", nome));
			c = (Convenio) cr.uniqueResult();
		}catch (HibernateException e){
			e.printStackTrace();
		}finally{
			session.flush();
			session.close();
		}
		return c;
	}

	public List<Convenio> pesquisarTodosConvenio() {
		ArrayList lista = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cr = session.createCriteria(Convenio.class);
			lista = (ArrayList)cr.list();
		} catch (HibernateException e) {
			e.printStackTrace();
			
		}finally{
			session.close();
			return lista;
		}
		
	}
	

}
