package persistencia;

import java.util.ArrayList;
import java.util.List;

import modelo.Fornecedor;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;

public class DaoFornecedor {

	private Session session = null;
	private Transaction transaction = null;
	
	public void cadastrarFornecedor(Fornecedor fornecedor) throws Exception{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.persist(fornecedor);
			transaction.commit();
			session.flush();
			session.close();
	}

	public void alterarFornecedor(Fornecedor fornecedor) throws Exception{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(fornecedor);
			transaction.commit();
			session.flush();
			session.close();
	}

	public void excluirFornecedor(Fornecedor fornecedor) throws Exception{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(fornecedor);
			transaction.commit();
			session.flush();
			session.close();
	}

	public Fornecedor pesquisarFornecedorPorNome(String nomeFornecedor) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(Fornecedor.class).add(Restrictions.eq("nomeFornecedor", nomeFornecedor));
		Fornecedor f = (Fornecedor)cr.uniqueResult();
		return f;
	}

	public List<Fornecedor> pesquisarTodosFornecedor() throws Exception{
		List<Fornecedor> lista = null;
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(Fornecedor.class);
		lista = (ArrayList)cr.list();
		session.flush();
		session.close();
		return lista;
	}
}
