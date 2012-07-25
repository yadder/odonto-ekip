package persistencia;

import java.util.ArrayList;
import java.util.List;

import modelo.Elemento;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class DaoElemento {

	private SessionFactory fabrica;
	private Session session = null;
	private Transaction transaction = null;
	
	public DaoElemento(){
		fabrica = Fabrica.obtemFabrica();
		session = fabrica.openSession();
		transaction = session.beginTransaction();
	}	
	
	public void cadastrarElemento(Elemento elemento) throws Exception{
		session.persist(elemento);
		transaction.commit();
		session.flush();
		session.close();
	}

	public void alterarElemento(Elemento elemento) throws Exception{
		session.update(elemento);
		transaction.commit();
		session.flush();
		session.close();
	}

	public void excluirElemento(Elemento elemento) throws Exception{
		session.delete(elemento);
		transaction.commit();
		session.flush();
		session.close();
	}

	public Elemento pesquisarElementoPorNome(Elemento elemento) throws Exception{
		Criteria cr = session.createCriteria(Elemento.class).add(Restrictions.eq("nomeElemento", elemento.getNomeElemento()));
		Elemento e = (Elemento) cr.uniqueResult();
		session.flush();
		session.close();
		return e;
	}

	public List<Elemento> pesquisarTodosElemento() throws Exception{
		List<Elemento> lista = null;
		Criteria cr = session.createCriteria(Elemento.class);
		lista = (ArrayList)cr.list();
		session.flush();
		session.close();
		return lista;
	}

}
