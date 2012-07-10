package persistencia;

import java.util.ArrayList;
import java.util.List;
import modelo.Procedimento;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

public class DaoProcedimentoImp implements DaoProcedimento {

	private Session session = null;
	private Transaction transaction = null;
	
	public boolean cadastrarProcedimento(Procedimento procedimento) {
		boolean retorno = false;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.persist(procedimento);
			transaction.commit();
			retorno = true;
		}catch(HibernateException e){
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.flush();
			session.close();
		}
		return retorno;
	}

	public boolean alterarProcedimento(Procedimento procedimento) {
		boolean retorno = false;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(procedimento);
			transaction.commit();
			retorno = true;
		}catch(HibernateException e){
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.flush();
			session.close();
		}
		return retorno;
	}
	
	public boolean excluirProcedimento(Procedimento procedimento) {
		boolean retorno = false;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(procedimento);
			transaction.commit();
			retorno = true;
		}catch(HibernateException e){
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.flush();
			session.close();
		}
		return retorno;
	}

	public Procedimento pesquisarProcedimentoPorDescricao(String nome) {
		Procedimento p = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cr = session.createCriteria(Procedimento.class).add(Restrictions.eq("descricaoProcedimento",nome));
			p = (Procedimento)cr.uniqueResult();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		}finally{
			session.flush();
			session.close();
		}
		return p;
	}

	public List<Procedimento> pesquisarTodosProcedimento() {
		ArrayList lista = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cr = session.createCriteria(Procedimento.class);
			lista = (ArrayList)cr.list();
		} catch (HibernateException e) {
			e.printStackTrace();
			
		}finally{
			session.flush();
			session.close();
		}
		return lista;
	}

}
