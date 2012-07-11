package persistencia;

import java.util.ArrayList;
import java.util.List;

import modelo.Paciente;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;

public class DaoPaciente {

	private Session session = null;
	private Transaction transaction = null;
	
	public void cadastrarPaciente(Paciente paciente) throws HibernateException{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.persist(paciente);
		transaction.commit();
		session.flush();
		session.close();
	}

	public void alterarPaciente(Paciente paciente) throws HibernateException{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(paciente);
		transaction.commit();
		session.flush();
		session.close();
	}

	public void excluirPaciente(Paciente paciente) throws HibernateException{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(paciente);
		transaction.commit();
		session.flush();
		session.close();
	}
	
	public Paciente pesquisarPacientePorNome(String nome) throws HibernateException{
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(Paciente.class).add(Restrictions.eq("nomeUsuario", nome));
		Paciente p = (Paciente)cr.uniqueResult();
		session.flush();
		session.close();
		return p;
	}

	public List<Paciente> pesquisarTodosPaciente() throws HibernateException{
		ArrayList<Paciente> lista = null;
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(Paciente.class);
		lista = (ArrayList)cr.list();
		session.flush();
		session.close();
		return lista;
	}
}
