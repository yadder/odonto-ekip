package persistencia;

import java.util.ArrayList;
import java.util.List;

import modelo.Convenio;
import modelo.Procedimento;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class DaoProcedimento {

	private SessionFactory fabrica;
	private Session session = null;
	private Transaction transaction = null;
	
	public DaoProcedimento(){
		fabrica = Fabrica.obtemFabrica();
		session = fabrica.openSession();
		transaction = session.beginTransaction();
	}	
	
	public void doRollBack() {
		transaction.rollback();
		closeSession();
	}
	
	public void closeSession(){
		session.flush();
		session.close();
	}
	
	public void cadastrarProcedimento(Procedimento procedimento) throws Exception, Exception{
			session.persist(procedimento);
			transaction.commit();
			closeSession();
	}

	public void alterarProcedimento(Procedimento procedimento) throws Exception{
			session.update(procedimento);
			transaction.commit();
			closeSession();
	}
	
	public void excluirProcedimento(Procedimento procedimento) throws Exception{
			session.delete(procedimento);
			transaction.commit();
			closeSession();
	}

	public Procedimento pesquisarProcedimentoPorDescricao(Procedimento procedimento) throws Exception{
		Criteria cr = session.createCriteria(Procedimento.class).add(Restrictions.eq("descricaoProcedimento",procedimento.getDescricaoProcedimento()));
		Procedimento p = (Procedimento)cr.uniqueResult();
		closeSession();
		return p;
	}
	
	public Procedimento pesquisarProcedimentoPorDescricaoEConvenio(Procedimento procedimento) throws Exception{
		Criteria cr = session.createCriteria(Procedimento.class).add(Restrictions.eq("descricaoProcedimento",procedimento.getDescricaoProcedimento())).add(Restrictions.eq("convenio",procedimento.getConvenio()));
		Procedimento p = (Procedimento)cr.uniqueResult();
		closeSession();
		return p;
	}
	
	
	public Procedimento pesquisarProcedimentoPorId(Procedimento procedimento) throws Exception{
		Criteria cr = session.createCriteria(Procedimento.class).add(Restrictions.eq("idProcedimento",procedimento.getIdProcedimento()));
		Procedimento p = (Procedimento)cr.uniqueResult();
		closeSession();
		return p;
	}
	
	public List<Procedimento> pesquisarProcedimentoPorConvenio(Convenio convenio) throws Exception{
		List<Procedimento> lista = null;
		Criteria cr = session.createCriteria(Procedimento.class).add(Restrictions.eq("convenio",convenio));
		lista = (ArrayList)cr.list();
		closeSession();
		return lista;
	}

	public List<Procedimento> pesquisarTodosProcedimento() throws Exception{
		List<Procedimento> lista = null;
		Criteria cr = session.createCriteria(Procedimento.class);
		lista = (ArrayList)cr.list();
		closeSession();
		return lista;
	}
}
