package persistencia;

import java.util.ArrayList;
import java.util.List;
import modelo.Disponibilidade;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class DaoDisponibilidadeImp implements DaoDisponibilidade {

	private Session session = null;
	private Transaction transaction = null;
	
	public boolean cadastrarDisponibilidade(Disponibilidade disponibilidade) {
		boolean retorno = false;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.persist(disponibilidade);
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

	public boolean alterarDisponibilidade(Disponibilidade disponibilidade) {
		boolean retorno = false;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(disponibilidade);
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

	public boolean excluirDisponibilidade(Disponibilidade disponibilidade) {
		boolean retorno = false;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(disponibilidade);
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

	public Disponibilidade pesquisarDisponibilidade(Disponibilidade disponibilidade) {
		Disponibilidade e = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			e = (Disponibilidade)session.get(Disponibilidade.class, disponibilidade.getCodigoDisponibilidade());
		} catch (HibernateException ex) {
			ex.printStackTrace();
		}finally{
			session.close();
		}
		return e;
	}

	public List<Disponibilidade> pesquisarTodosDisponibilidade() {
		ArrayList lista = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cr = session.createCriteria(Disponibilidade.class);
			lista = (ArrayList)cr.list();
		} catch (HibernateException e) {
			e.printStackTrace();
			
		}finally{
			session.close();
			return lista;
		}
		
	}

}
