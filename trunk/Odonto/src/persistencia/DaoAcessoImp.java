package persistencia;

import java.util.ArrayList;
import java.util.List;

import modelo.Acesso;
import modelo.Elemento;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;

public class DaoAcessoImp implements DaoAcesso {

	private Session session = null;
	private Transaction transaction = null;
	
	@Override
	public boolean cadastrarAcesso(Acesso acesso) {
		boolean retorno = false;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.persist(acesso);
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

	@Override
	public boolean alterarAcesso(Acesso acesso) {
		boolean retorno = false;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(acesso);
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

	@Override
	public boolean excluirAcesso(Acesso acesso) {
		boolean retorno = false;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(acesso);
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

	@Override
	public Acesso pesquisarAcessoPorNome(String nome) {
		Acesso a = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cr = session.createCriteria(Acesso.class).add(Restrictions.eq("descricaoAcesso", nome));
			a = (Acesso) cr.uniqueResult();
		}catch (HibernateException ex){
			ex.printStackTrace();
		}finally{
			session.flush();
			session.close();
		}
		return a;
	}

	@Override
	public List<Acesso> pesquisarTodosAcesso() {
		List<Acesso> lista = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cr = session.createCriteria(Acesso.class);
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
