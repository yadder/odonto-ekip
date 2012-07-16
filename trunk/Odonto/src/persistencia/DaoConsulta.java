package persistencia;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import modelo.Consulta;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

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
		Criteria cr = session.createCriteria(Consulta.class).add((Restrictions.eq("statusConsulta", "AGENDADA"))).addOrder(Order.asc("dataConsulta"));
		lista = (ArrayList)cr.list();
		session.flush();
		session.close();
		return lista;
	}
	
	public List<Consulta> pesquisarTodosConsultaData(Date data) throws Exception{
		List<Consulta> lista = null;
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(Consulta.class).add((Restrictions.eq("dataConsulta", data)));
		lista = (ArrayList)cr.list();
		session.flush();
		session.close();
		return lista;
	}
	
	public static void main(String[] args) {
		try{
			DaoConsulta dao = new DaoConsulta();
			List<Consulta> lista = new ArrayList<Consulta>();
			lista = dao.pesquisarTodosConsultaAgendada();
			for (Consulta consulta : lista) {
				System.out.println(consulta);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}


