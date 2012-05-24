package persistencia;

import java.util.ArrayList;
import java.util.List;
import modelo.Fornecedor;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class DaoFornecedorImp implements DaoFornecedor {

	private Session session = null;
	private Transaction transaction = null;
	
	public boolean cadastrarFornecedor(Fornecedor fornecedor) {
		boolean retorno = false;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.persist(fornecedor);
			transaction.commit();
			retorno = true;
		}catch(HibernateException e){
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return retorno;
	}

	public boolean alterarFornecedor(Fornecedor fornecedor) {
		boolean retorno = false;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(fornecedor);
			transaction.commit();
			retorno = true;
		}catch(HibernateException e){
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return retorno;
	}

	public boolean excluirFornecedor(Fornecedor fornecedor) {
		boolean retorno = false;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(fornecedor);
			transaction.commit();
			retorno = true;
		}catch(HibernateException e){
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return retorno;
	}

	public Fornecedor pesquisarFornecedor(Fornecedor fornecedor) {
		Fornecedor e = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			e = (Fornecedor)session.get(Fornecedor.class, fornecedor.getCodigoFornecedor());
		} catch (HibernateException ex) {
			ex.printStackTrace();
		}finally{
			session.close();
		}
		return e;
	}

	public List<Fornecedor> pesquisarTodosFornecedor() {
		ArrayList lista = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cr = session.createCriteria(Fornecedor.class);
			lista = (ArrayList)cr.list();
		} catch (HibernateException e) {
			e.printStackTrace();
			
		}finally{
			session.close();
			return lista;
		}
		
	}

}
