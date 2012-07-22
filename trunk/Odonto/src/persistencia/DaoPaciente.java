package persistencia;

import java.util.ArrayList;
import java.util.List;

import modelo.Paciente;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;

public class DaoPaciente {

	private Session session = null;
	private Transaction transaction = null;
	
	public void cadastrarPaciente(Paciente paciente) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.persist(paciente);
		transaction.commit();
		session.flush();
		session.close();
	}

	public void alterarPaciente(Paciente paciente) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(paciente);
		transaction.commit();
		session.flush();
		session.close();
	}

	public void excluirPaciente(Paciente paciente) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(paciente);
		transaction.commit();
		session.flush();
		session.close();
	}
	
	public Paciente pesquisarPacientePorNome(Paciente paciente) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(Paciente.class).add(Restrictions.eq("nomeUsuario", paciente.getNomeUsuario()));
		Paciente p = (Paciente)cr.uniqueResult();
		session.flush();
		session.close();
		return p;
	}

	public Paciente pesquisarPacientePorId(Paciente paciente) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(Paciente.class).add(Restrictions.eq("idUsuario", paciente.getIdUsuario()));
		Paciente p = (Paciente)cr.uniqueResult();
		session.flush();
		session.close();
		return p;
	}
	
	public List<Paciente> pesquisarTodosPaciente() throws Exception{
		ArrayList<Paciente> lista = null;
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(Paciente.class);
		lista = (ArrayList)cr.list();
		session.flush();
		session.close();
		return lista;
	}
}
