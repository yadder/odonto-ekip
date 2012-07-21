package persistencia;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import modelo.Consulta;
import modelo.Paciente;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import controle.ConfiguraAtributo;

import util.HibernateUtil;

public class DaoConsulta {

	private Session session = null;
	private Transaction transaction = null;
	
	public void cadastrarConsulta(Consulta consulta) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.persist(consulta);
		transaction.commit();
		session.flush();
		session.close();
	}

	public void alterarConsulta(Consulta consulta) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(consulta);
		transaction.commit();
		session.flush();
		session.close();
	}

	public void excluirConsulta(Consulta consulta) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(consulta);
		transaction.commit();
		session.flush();
		session.close();
	}

	public Consulta pesquisarConsultaPorId(long id) throws Exception{
		Consulta c = new Consulta();
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(Consulta.class).add(Restrictions.eq("idConsulta",id));
		c = (Consulta)cr.uniqueResult();
		session.flush();
		session.close();
		return c;
	}
	
	public List<Consulta> pesquisarTodosConsulta() throws Exception{
		List<Consulta> lista = null;
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(Consulta.class);
		lista = (ArrayList)cr.list();
		session.flush();
		session.close();
		return lista;
	}
	
	public List<Consulta> pesquisarTodosConsultaAgendada() throws Exception{
		List<Consulta> lista = null;
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(Consulta.class).add(Restrictions.eq("statusConsulta", "AGENDADA")).addOrder(Order.asc("dataConsulta"));
		lista = (ArrayList)cr.list();
		session.flush();
		session.close();
		return lista;
	}
	
	public List<Consulta> pesquisarTodosConsultaData(Date data) throws Exception{
		List<Consulta> lista = null;
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(Consulta.class).add(Restrictions.eq("dataConsulta", data));
		lista = (ArrayList)cr.list();
		session.flush();
		session.close();
		return lista;
	}
	
	public List<Consulta> pesquisarTodosConsultaDataIniDataFim(Date dataini,Date datafim ) throws Exception{
		List<Consulta> lista = null;
		session = HibernateUtil.getSessionFactory().openSession();
		//Criteria cr = session.createCriteria(Consulta.class).add(Restrictions.between(Data, dataini, datafim)eq("dataConsulta", data));
		Criteria cr = session.createCriteria(Consulta.class).add(Restrictions.between("dataConsulta", dataini,datafim));
		lista = (ArrayList)cr.list();
		session.flush();
		session.close();
		return lista;
	}
	
	public List<Consulta> pesquisarTodosConsultaStatusDataIniDataFim(Date dataini,Date datafim, String status ) throws Exception{
		List<Consulta> lista = null;
		session = HibernateUtil.getSessionFactory().openSession();
		//Criteria cr = session.createCriteria(Consulta.class).add(Restrictions.between(Data, dataini, datafim)eq("dataConsulta", data));
		Criteria cr = session.createCriteria(Consulta.class).add(Restrictions.between("dataConsulta", dataini,datafim)).add(Restrictions.eq("statusConsulta", status));
		lista = (ArrayList)cr.list();
		session.flush();
		session.close();
		return lista;
	}
	
	
	public List<Consulta> pesquisarConsultaPorPaciente(Paciente paciente) throws Exception{
		List<Consulta> lista = null;
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(Consulta.class).add(Restrictions.eq("paciente", paciente));
		lista = (ArrayList)cr.list();
		session.flush();
		session.close();
		return lista;
	}	
}


