package persistencia;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import modelo.Odontograma;
import modelo.Paciente;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class DaoOdontograma {

	private SessionFactory fabrica;
	private Session session = null;
	private Transaction transaction = null;
	
	public DaoOdontograma(){
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
	
	public void cadastrarOdontograma(Odontograma odontograma) throws Exception{
		session.persist(odontograma);
		transaction.commit();
		closeSession();
	}

	public void alterarOdontograma(Odontograma odontograma) throws Exception{
		session.update(odontograma);
		transaction.commit();
		closeSession();
	}

	public void excluirOdontograma(Odontograma odontograma) throws Exception{
		session.delete(odontograma);
		transaction.commit();
		closeSession();
	}

	public Odontograma pesquisarOdontogramaPorPacienteEmAndamento(Paciente paciente) throws Exception{
		Odontograma o = null;
		Criteria cr = session.createCriteria(Odontograma.class).add(Restrictions.eq("paciente", paciente)).add(Restrictions.eq("statusOdontograma", "EM ANDAMENTO"));
		o = (Odontograma)cr.uniqueResult();
		closeSession();
		return o;
	}
	
	public List<Odontograma> pesquisarTodosOdontograma() throws Exception{
		List<Odontograma> lista = null;
		Criteria cr = session.createCriteria(Odontograma.class);
		lista = (ArrayList)cr.list();
		closeSession();
		return lista;
	}
	
	public List<Odontograma> pesquisarTodosOdontogramaFinalizadoDataIniDataFim(Date dataini,Date datafim) throws Exception{
		List<Odontograma> lista = null;
		Criteria cr = session.createCriteria(Odontograma.class).add(Restrictions.between("dataFimOdontograma", dataini,datafim)).add(Restrictions.eq("statusOdontograma", "FINALIZADO"));
		lista = (ArrayList)cr.list();
		closeSession();
		return lista;
	}	
}
