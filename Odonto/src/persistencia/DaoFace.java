package persistencia;

import java.util.ArrayList;
import java.util.List;

import modelo.Face;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;

public class DaoFace {

	private Session session = null;
	private Transaction transaction = null;
	
	public void cadastrarFace(Face face) throws Exception{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.persist(face);
			transaction.commit();
			session.flush();
			session.close();
	}

	public void alterarFace(Face face) throws Exception{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(face);
			transaction.commit();
			session.flush();
			session.close();
	}

	public void excluirFace(Face face) throws Exception{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(face);
			transaction.commit();
			session.flush();
			session.close();
	}

	public Face pesquisarFacePorNome(Face face) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(Face.class).add(Restrictions.eq("nomeFace", face.getNomeFace()));
		Face f = (Face) cr.uniqueResult();
		session.flush();
		session.close();
		return f;
	}

	public List<Face> pesquisarTodosFace() throws Exception{
		List<Face> lista = null;
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(Face.class);
		lista = (ArrayList)cr.list();
		session.flush();
		session.close();
		return lista;
	}
}
