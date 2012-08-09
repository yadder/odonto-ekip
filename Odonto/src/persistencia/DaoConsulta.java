package persistencia;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import modelo.Consulta;
import modelo.Paciente;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class DaoConsulta {

	private SessionFactory fabrica;
	private Session session = null;
	private Transaction transaction = null;
	
	public DaoConsulta(){
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
	
	public void cadastrarConsulta(Consulta consulta) throws Exception{
		session.persist(consulta);
		transaction.commit();
		closeSession();
	}

	public void alterarConsulta(Consulta consulta) throws Exception{
		session.update(consulta);
		transaction.commit();
		closeSession();
	}

	public void excluirConsulta(Consulta consulta) throws Exception{
		session.delete(consulta);
		transaction.commit();
		closeSession();
	}

	public Consulta pesquisarConsultaPorId(long id) throws Exception{
		Consulta c = new Consulta();
		Criteria cr = session.createCriteria(Consulta.class).add(Restrictions.eq("idConsulta",id));
		c = (Consulta)cr.uniqueResult();
		closeSession();
		return c;
	}
	
	public List<Consulta> pesquisarTodosConsulta() throws Exception{
		List<Consulta> lista = null;
		Criteria cr = session.createCriteria(Consulta.class);
		lista = (ArrayList)cr.list();
		closeSession();
		return lista;
	}
	
	public List<Consulta> pesquisarTodosConsultaAgendada() throws Exception{
		List<Consulta> lista = null;
		Criteria cr = session.createCriteria(Consulta.class).add(Restrictions.eq("statusConsulta", "AGENDADA")).addOrder(Order.asc("dataConsulta"));
		lista = (ArrayList)cr.list();
		closeSession();
		return lista;
	}
	
	public List<Consulta> pesquisarTodosConsultaData(Date data) throws Exception{
		List<Consulta> lista = null;
		Criteria cr = session.createCriteria(Consulta.class).add(Restrictions.eq("dataConsulta", data));
		lista = (ArrayList)cr.list();
		closeSession();
		return lista;
	}
	
	public List<Consulta> pesquisarTodosConsultaDataIniDataFim(Date dataini,Date datafim ) throws Exception{
		List<Consulta> lista = null;
		//Criteria cr = session.createCriteria(Consulta.class).add(Restrictions.between(Data, dataini, datafim)eq("dataConsulta", data));
		Criteria cr = session.createCriteria(Consulta.class).add(Restrictions.between("dataConsulta", dataini,datafim));
		lista = (ArrayList)cr.list();
		closeSession();
		return lista;
	}
	
	public List<Consulta> pesquisarTodosConsultaStatusDataIniDataFim(Date dataini,Date datafim, String status ) throws Exception{
		List<Consulta> lista = null;
		Criteria cr = session.createCriteria(Consulta.class).add(Restrictions.between("dataConsulta", dataini,datafim)).add(Restrictions.eq("statusConsulta", status));
		lista = (ArrayList)cr.list();
		closeSession();
		return lista;
	}
	
	
	public List<Consulta> pesquisarConsultaPorPaciente(Paciente paciente) throws Exception{
		List<Consulta> lista = null;
		Criteria cr = session.createCriteria(Consulta.class).add(Restrictions.eq("paciente", paciente));
		lista = (ArrayList)cr.list();
		closeSession();
		return lista;
	}
	
	public Consulta pesquisarConsultaPorAgendamento(Consulta consulta) throws Exception{
		Consulta con = null;
		Criteria cr = session.createCriteria(Consulta.class).add(Restrictions.eq("dataConsulta", consulta.getDataConsulta()))
															.add(Restrictions.eq("horaConsulta",consulta.getHoraConsulta()))
															.add(Restrictions.eq("dentista", consulta.getDentista()))
															.add(Restrictions.eq("statusConsulta", "AGENDADA"));
		con = (Consulta)cr.uniqueResult(); 	
		closeSession();
		return con;	
	}
}


