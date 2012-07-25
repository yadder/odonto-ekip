package persistencia;

import java.util.ArrayList;
import java.util.List;

import modelo.Face;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class DaoFace {

	private SessionFactory fabrica;
	private Session session = null;
	private Transaction transaction = null;
	
	public DaoFace(){
		fabrica = Fabrica.obtemFabrica();
		session = fabrica.openSession();
		transaction = session.beginTransaction();
	}	
	
	public void cadastrarFace(Face face) throws Exception{
			session.persist(face);
			transaction.commit();
			session.flush();
			session.close();
	}

	public void alterarFace(Face face) throws Exception{
			session.update(face);
			transaction.commit();
			session.flush();
			session.close();
	}

	public void excluirFace(Face face) throws Exception{
			session.delete(face);
			transaction.commit();
			session.flush();
			session.close();
	}

	public Face pesquisarFacePorNome(Face face) throws Exception{
		Criteria cr = session.createCriteria(Face.class).add(Restrictions.eq("nomeFace", face.getNomeFace()));
		Face f = (Face) cr.uniqueResult();
		session.flush();
		session.close();
		return f;
	}

	public List<Face> pesquisarTodosFace() throws Exception{
		List<Face> lista = null;
		Criteria cr = session.createCriteria(Face.class);
		lista = (ArrayList)cr.list();
		session.flush();
		session.close();
		return lista;
	}
}
