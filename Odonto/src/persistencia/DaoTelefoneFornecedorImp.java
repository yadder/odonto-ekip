package persistencia;

import java.util.ArrayList;
import java.util.List;
import modelo.TelefoneFornecedor;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class DaoTelefoneFornecedorImp implements DaoTelefoneFornecedor {

	private Session session = null;
	private Transaction transaction = null;
	
	public boolean cadastrarTelefoneFornecedor(TelefoneFornecedor telefoneFornecedor) {
		boolean retorno = false;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.persist(telefoneFornecedor);
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

	public boolean alterarTelefoneFornecedor(TelefoneFornecedor telefoneFornecedor) {
		boolean retorno = false;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(telefoneFornecedor);
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

	public boolean excluirTelefoneFornecedor(TelefoneFornecedor telefoneFornecedor) {
		boolean retorno = false;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(telefoneFornecedor);
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

	public TelefoneFornecedor pesquisarTelefoneFornecedor(TelefoneFornecedor telefoneFornecedor) {
		TelefoneFornecedor e = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			e = (TelefoneFornecedor)session.get(TelefoneFornecedor.class, telefoneFornecedor.getCodigoTelefone());
		} catch (HibernateException ex) {
			ex.printStackTrace();
		}finally{
			session.close();
		}
		return e;
	}

	public List<TelefoneFornecedor> pesquisarTodosTelefoneFornecedor() {
		ArrayList lista = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cr = session.createCriteria(TelefoneFornecedor.class);
			lista = (ArrayList)cr.list();
		} catch (HibernateException e) {
			e.printStackTrace();
			
		}finally{
			session.close();
			return lista;
		}
		
	}

}
