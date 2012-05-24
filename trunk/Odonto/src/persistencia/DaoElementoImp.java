package persistencia;

import java.util.ArrayList;
import java.util.List;
import modelo.Elemento;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class DaoElementoImp implements DaoElemento {

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
			session.close();
		}
		return retorno;
	}

	public Elemento pesquisarElemento(Elemento elemento) {
		Elemento e = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			e = (Elemento)session.get(Elemento.class, elemento.getCodigoElemento());
		} catch (HibernateException ex) {
			ex.printStackTrace();
		}finally{
			session.close();
		}
		return e;
	}

	public List<Elemento> pesquisarTodosElemento() {
		ArrayList  lista = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cr = session.createCriteria(Elemento.class);
			lista = (ArrayList)cr.list();
		} catch (HibernateException e) {
			e.printStackTrace();
			
		}finally{
			session.close();
			return lista;
		}
		
	}

}
