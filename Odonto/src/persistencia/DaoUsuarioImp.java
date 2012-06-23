package persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Face;
import modelo.Usuario;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;

public class DaoUsuarioImp implements DaoUsuario {

	private Session session = null;
	private Transaction transaction = null;
	
	public boolean cadastrarUsuario(Usuario usuario) {
		boolean retorno = false;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.persist(usuario);
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

	public boolean alterarUsuario(Usuario usuario) {
		boolean retorno = false;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(usuario);
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

	public boolean excluirUsuario(Usuario usuario) {
		boolean retorno = false;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(usuario);
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

	public Usuario pesquisarUsuarioPorCpf(String cpf){
		Usuario u = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cr = session.createCriteria(Usuario.class).add(Restrictions.eq("cpfUsuario", cpf));
			u = (Usuario) cr.uniqueResult();
		}catch (HibernateException e){
			e.printStackTrace();
		}finally{
			session.flush();
			session.close();
		}
		return u;
	}
	
	public Usuario pesquisarUsuarioPorNome(String nome){
		Usuario usuario = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cr = session.createCriteria(Usuario.class).add(Restrictions.eq("nomeUsuario", nome));
			usuario = (Usuario)cr.uniqueResult();
		}catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			session.flush();
			session.close();
		}
		return usuario;
	}

	public List<Usuario> pesquisarTodosUsuario() {
		ArrayList lista = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cr = session.createCriteria(Usuario.class);
			lista = (ArrayList)cr.list();
		} catch (HibernateException e) {
			e.printStackTrace();
			
		}finally{
			session.close();
			return lista;
		}
		
	}

}
