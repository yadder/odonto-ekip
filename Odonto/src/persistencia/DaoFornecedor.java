package persistencia;

import java.util.ArrayList;
import java.util.List;

import modelo.Fornecedor;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class DaoFornecedor {

	private SessionFactory fabrica;
	private Session session = null;
	private Transaction transaction = null;
	
	public DaoFornecedor(){
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
	
	public void cadastrarFornecedor(Fornecedor fornecedor) throws Exception{
		session.persist(fornecedor);
		transaction.commit();
		closeSession();
	}

	public void alterarFornecedor(Fornecedor fornecedor) throws Exception{
		session.update(fornecedor);
		transaction.commit();
		closeSession();
	}

	public void excluirFornecedor(Fornecedor fornecedor) throws Exception{
		session.delete(fornecedor);
		transaction.commit();
		closeSession();
	}

	public Fornecedor pesquisarFornecedorPorNome(Fornecedor fornecedor) throws Exception{
		Criteria cr = session.createCriteria(Fornecedor.class).add(Restrictions.eq("nomeFornecedor", fornecedor.getNomeFornecedor()));
		Fornecedor f = (Fornecedor)cr.uniqueResult();
		closeSession();
		return f;
	}

	public List<Fornecedor> pesquisarTodosFornecedor() throws Exception{
		List<Fornecedor> lista = null;
		Criteria cr = session.createCriteria(Fornecedor.class);
		lista = (ArrayList)cr.list();
		closeSession();
		return lista;
	}
}
