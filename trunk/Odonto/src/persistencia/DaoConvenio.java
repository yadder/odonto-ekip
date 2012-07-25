package persistencia;

import java.util.ArrayList;
import java.util.List;

import modelo.Convenio;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class DaoConvenio {

	private SessionFactory fabrica;
	private Session session = null;
	private Transaction transaction = null;
	
	public DaoConvenio(){
		fabrica = Fabrica.obtemFabrica();
		session = fabrica.openSession();
		transaction = session.beginTransaction();
	}	
	
	public void cadastrarConvenio(Convenio convenio) throws Exception{
		session.persist(convenio);
		transaction.commit();
		session.flush();
		session.close();
	}

	public void alterarConvenio(Convenio convenio) throws Exception{
		session.update(convenio);
		transaction.commit();
		session.flush();
		session.close();
	}

	public void excluirConvenio(Convenio convenio) throws Exception{
		session.delete(convenio);
		transaction.commit();
		session.flush();
		session.close();
	}

	public Convenio pesquisarConvenioPorNome(Convenio convenio) throws Exception{
		Criteria cr = session.createCriteria(Convenio.class).add(Restrictions.eq("nomeConvenio", convenio.getNomeConvenio()));
		Convenio c = (Convenio) cr.uniqueResult();
		session.flush();
		session.close();
		return c;
	}

	public List<Convenio> pesquisarTodosConvenio() throws Exception{
		List<Convenio> lista = null;
		Criteria cr = session.createCriteria(Convenio.class);
		lista = (ArrayList)cr.list();
		session.flush();
		session.close();
		return lista;
	}
	

}
