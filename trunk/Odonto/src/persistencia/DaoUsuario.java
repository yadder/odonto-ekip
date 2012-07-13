package persistencia;

import java.util.ArrayList;
import java.util.List;

import modelo.Usuario;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;

public class DaoUsuario {

	private Session session = null;
	private Transaction transaction = null;
	
	public void cadastrarUsuario(Usuario usuario) throws Exception{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.persist(usuario);
			transaction.commit();
			session.flush();
			session.close();
	}

	public void alterarUsuario(Usuario usuario) throws Exception{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(usuario);
			transaction.commit();
			session.flush();
			session.close();
	}

	public void excluirUsuario(Usuario usuario) throws Exception{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(usuario);
			transaction.commit();
			session.flush();
			session.close();
	}

	public Usuario pesquisarUsuarioPorCpf(Usuario usuario) throws Exception{
		Usuario u = null;
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(Usuario.class).add(Restrictions.eq("cpfUsuario", usuario.getCpfUsuario()));
		u = (Usuario) cr.uniqueResult();
		session.flush();
		session.close();
		return u;
	}
	
	public Usuario pesquisarUsuarioPorNome(Usuario usuario) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(Usuario.class).add(Restrictions.eq("nomeUsuario", usuario.getNomeUsuario()));
		Usuario u = (Usuario)cr.uniqueResult();
		session.flush();
		session.close();
		return u;
	}

	public List<Usuario> pesquisarTodosUsuario() throws Exception{
		List<Usuario> lista = null;
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(Usuario.class);
		lista = (ArrayList)cr.list();
		session.flush();
		session.close();
		return lista;
	}

}
