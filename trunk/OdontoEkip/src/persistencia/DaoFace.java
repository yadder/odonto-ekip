package persistencia;
import java.util.ArrayList;
import java.util.List;

import modelo_hibernate.Face;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class DaoFace {
	Transaction transaction;
	Session session;
	Query query;
	
	public void gravar(Face f) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(f);
		transaction.commit();
		session.flush();
		session.close();
	}

	public void alterar(Face f) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(f);
		transaction.commit();
		session.flush();
		session.close();
	}
	
	public void excluir(Face f) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(f);
		transaction.commit();
		session.flush();
		session.close();
	}
	
	public Face consultar(Face f) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();			//nomeFace refere-se ao atributo da classe
		Criteria cr = session.createCriteria(Face.class).add(Restrictions.eq("nomeFace", f.getNomeFace()));
		f = (Face)cr.uniqueResult();
		session.flush();
		session.close();
		return f;
	}
	
	public ArrayList consultarTodos() throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(Face.class);
		ArrayList lista = (ArrayList)cr.list();		
		session.flush();
		session.close();
		return lista;
	}
	
}
