package persistencia;

import java.util.ArrayList;
import java.util.List;

import modelo.Elemento;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;

public class DaoElemento {

	private Session session = null;
	private Transaction transaction = null;
	
	public boolean cadastrarElemento(Elemento elemento) {
		boolean retorno = false;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.persist(elemento);
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

	public boolean alterarElemento(Elemento elemento) {
		boolean retorno = false;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(elemento);
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

	public boolean excluirElemento(Elemento elemento) {
		boolean retorno = false;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(elemento);
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

	public Elemento pesquisarElementoPorNome(String nome){
		Elemento e = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cr = session.createCriteria(Elemento.class).add(Restrictions.eq("nomeElemento", nome));
			e = (Elemento) cr.uniqueResult();
		}catch (HibernateException ex){
			ex.printStackTrace();
		}finally{
			session.flush();
			session.close();
		}
		return e;
	}

	public List<Elemento> pesquisarTodosElemento() {
		List<Elemento> lista = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cr = session.createCriteria(Elemento.class);
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
