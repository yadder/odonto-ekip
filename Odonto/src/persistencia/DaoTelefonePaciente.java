package persistencia;

import java.util.ArrayList;
import java.util.List;

import modelo.TelefonePaciente;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class DaoTelefonePaciente {

	private Session session = null;
	private Transaction transaction = null;
	
	public boolean cadastrarTelefonePaciente(TelefonePaciente telefonePaciente) {
		boolean retorno = false;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.persist(telefonePaciente);
			transaction.commit();
			retorno = true;
		}catch(Exception e){
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return retorno;
	}

	public boolean alterarTelefonePaciente(TelefonePaciente telefonePaciente) {
		boolean retorno = false;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(telefonePaciente);
			transaction.commit();
			retorno = true;
		}catch(Exception e){
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return retorno;
	}

	public boolean excluirTelefonePaciente(TelefonePaciente telefonePaciente) {
		boolean retorno = false;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(telefonePaciente);
			transaction.commit();
			retorno = true;
		}catch(Exception e){
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return retorno;
	}

	public TelefonePaciente pesquisarTelefonePaciente(TelefonePaciente telefonePaciente) {
		TelefonePaciente e = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			e = (TelefonePaciente)session.get(TelefonePaciente.class, telefonePaciente.getIdTelefone());
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally{
			session.close();
		}
		return e;
	}

	public List<TelefonePaciente> pesquisarTodosTelefonePaciente() {
		ArrayList lista = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cr = session.createCriteria(TelefonePaciente.class);
			lista = (ArrayList)cr.list();
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally{
			session.close();
			return lista;
		}
		
	}

}
