package persistencia;

import java.util.ArrayList;
import java.util.List;

import modelo.Usuario;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;

public class DaoUsuario {

	private Session session = null;
	private Transaction transaction = null;
	
	public void cadastrarUsuario(Usuario usuario) throws HibernateException{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.persist(usuario);
			transaction.commit();
			session.flush();
			session.close();
	}

	public void alterarUsuario(Usuario usuario) throws HibernateException{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(usuario);
			transaction.commit();
			session.flush();
			session.close();
	}

	public void excluirUsuario(Usuario usuario) throws HibernateException{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(usuario);
			transaction.commit();
			session.flush();
			session.close();
	}

	public Usuario pesquisarUsuarioPorCpf(String cpf) throws HibernateException{
		Usuario u = null;
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(Usuario.class).add(Restrictions.eq("cpfUsuario", cpf));
		u = (Usuario) cr.uniqueResult();
		session.flush();
		session.close();
		return u;
	}
	
	public Usuario pesquisarUsuarioPorNome(String nome) throws HibernateException{
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(Usuario.class).add(Restrictions.eq("nomeUsuario", nome));
		Usuario u = (Usuario)cr.uniqueResult();
		session.flush();
		session.close();
		return u;
	}

	public List<Usuario> pesquisarTodosUsuario() throws HibernateException{
		List<Usuario> lista = null;
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(Usuario.class);
		lista = (ArrayList)cr.list();
		session.flush();
		session.close();
		return lista;
	}

}
