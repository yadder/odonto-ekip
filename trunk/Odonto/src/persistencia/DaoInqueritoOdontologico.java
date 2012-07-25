package persistencia;

import java.util.ArrayList;
import java.util.List;

import modelo.InqueritoOdontologico;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DaoInqueritoOdontologico {

	private SessionFactory fabrica;
	private Session session = null;
	private Transaction transaction = null;
	
	public DaoInqueritoOdontologico(){
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
	
	public void cadastrarInqueritoOdontologico(InqueritoOdontologico inqueritoOdontologico) throws Exception{
		session.persist(inqueritoOdontologico);
		transaction.commit();
		closeSession();
	}

	public void alterarInqueritoOdontologico(InqueritoOdontologico inqueritoOdontologico) throws Exception{
		session.update(inqueritoOdontologico);
		transaction.commit();
		closeSession();
	}

	public void excluirInqueritoOdontologico(InqueritoOdontologico inqueritoOdontologico) throws Exception{
		session.delete(inqueritoOdontologico);
		transaction.commit();
		closeSession();
	}

	public List<InqueritoOdontologico> pesquisarTodosInqueritoOdontologico() throws Exception{
		List<InqueritoOdontologico> lista = null;
		Criteria cr = session.createCriteria(InqueritoOdontologico.class);
		lista = (ArrayList)cr.list();
		closeSession();
		return lista;
	}
}
