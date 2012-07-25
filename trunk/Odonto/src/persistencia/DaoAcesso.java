package persistencia;

import java.util.ArrayList;
import java.util.List;

import modelo.Acesso;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class DaoAcesso {

	private SessionFactory fabrica;
	private Session session = null;
	private Transaction transaction = null;
	
	public DaoAcesso(){
		fabrica = Fabrica.obtemFabrica();
		session = fabrica.openSession();
		transaction = session.beginTransaction();
	}	
	
	public void cadastrarAcesso(Acesso acesso) throws Exception{
		session.persist(acesso);
		transaction.commit();
		session.flush();
		session.close();
	}

	public void alterarAcesso(Acesso acesso) throws Exception{
		session.update(acesso);
		transaction.commit();
		session.flush();
		session.close();
	}

	public void excluirAcesso(Acesso acesso) throws Exception{
		session.delete(acesso);
		transaction.commit();
		session.flush();
		session.close();
	}

	public Acesso pesquisarAcessoPorNome(Acesso acesso) throws Exception{
		Criteria cr = session.createCriteria(Acesso.class).add(Restrictions.eq("descricaoAcesso", acesso.getDescricaoAcesso()));
		Acesso a = (Acesso)cr.uniqueResult();
		session.flush();
		session.close();
		return a;
	}

	public List<Acesso> pesquisarTodosAcesso() throws Exception{
		List<Acesso> lista = null;
		Criteria cr = session.createCriteria(Acesso.class);
		lista = (ArrayList)cr.list();
		session.flush();
		session.close();
		return lista;
	}

}
