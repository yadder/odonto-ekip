package persistencia;

import java.util.ArrayList;
import java.util.List;

import modelo.Paciente;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class DaoPaciente {

	private SessionFactory fabrica;
	private Session session = null;
	private Transaction transaction = null;
	
	public DaoPaciente(){
		fabrica = Fabrica.obtemFabrica();
		session = fabrica.openSession();
		transaction = session.beginTransaction();
	}	
	
	public void doRollBack() {
		transaction.rollback();
		closeSession();
	}
	
	public void closeSession(){
		session.flush();
		session.close();
	}
	
	public void cadastrarPaciente(Paciente paciente) throws Exception{
		session.persist(paciente);
		transaction.commit();
		closeSession();
	}

	public void alterarPaciente(Paciente paciente) throws Exception{
		session.update(paciente);
		transaction.commit();
		closeSession();
	}

	public void excluirPaciente(Paciente paciente) throws Exception{
		session.delete(paciente);
		transaction.commit();
		closeSession();
	}
	
	public Paciente pesquisarPacientePorNome(Paciente paciente) throws Exception{
		Criteria cr = session.createCriteria(Paciente.class).add(Restrictions.eq("nomeUsuario", paciente.getNomeUsuario()));
		Paciente p = (Paciente)cr.uniqueResult();
		closeSession();
		return p;
	}

	public Paciente pesquisarPacientePorId(Paciente paciente) throws Exception{
		Criteria cr = session.createCriteria(Paciente.class).add(Restrictions.eq("idUsuario", paciente.getIdUsuario()));
		Paciente p = (Paciente)cr.uniqueResult();
		closeSession();
		return p;
	}
	
	public List<Paciente> pesquisarTodosPaciente() throws Exception{
		ArrayList<Paciente> lista = null;
		Criteria cr = session.createCriteria(Paciente.class);
		lista = (ArrayList)cr.list();
		closeSession();
		return lista;
	}
}
