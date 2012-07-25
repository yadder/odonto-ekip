package persistencia;

import java.util.ArrayList;
import java.util.List;

import modelo.Dentista;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class DaoDentista {

	private SessionFactory fabrica;
	private Session session = null;
	private Transaction transaction = null;
	
	public DaoDentista(){
		fabrica = Fabrica.obtemFabrica();
		session = fabrica.openSession();
		transaction = session.beginTransaction();
	}	
	
	public void cadastrarDentista(Dentista dentista) throws Exception{
		session.persist(dentista);
		transaction.commit();
		session.flush();
		session.close();
	}

	public void alterarDentista(Dentista dentista) throws Exception{
		session.update(dentista);
		transaction.commit();
		session.flush();
		session.close();
	}

	public void excluirDentista(Dentista dentista) throws Exception{
		session.delete(dentista);
		transaction.commit();
		session.flush();
		session.close();
	}

	public Dentista pesquisarDentistaPorNome(Dentista dentista) throws Exception{
		Criteria cr = session.createCriteria(Dentista.class).add(Restrictions.eq("nomeUsuario", dentista.getNomeUsuario()));
		Dentista d = (Dentista)cr.uniqueResult();
		session.flush();
		session.close();
		return d;
	}
	
	public Dentista pesquisarDentistaPorId(Dentista dentista) throws Exception{
		Criteria cr = session.createCriteria(Dentista.class).add(Restrictions.eq("idUsuario", dentista.getIdUsuario()));
		Dentista d = (Dentista)cr.uniqueResult();
		session.flush();
		session.close();
		return d;
	}

	public List<Dentista> pesquisarTodosDentista() throws Exception{
		List<Dentista> lista = null;
		Criteria cr = session.createCriteria(Dentista.class);
		lista = (ArrayList)cr.list();
		session.flush();
		session.close();
		return lista;
	}
}
