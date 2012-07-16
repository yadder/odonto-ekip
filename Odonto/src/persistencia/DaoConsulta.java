package persistencia;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import modelo.Consulta;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import util.ConfiguraAtributo;
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
	
	public static void main(String[] args) {
		try{
			ConfiguraAtributo ca = new ConfiguraAtributo();
			DaoConsulta dao = new DaoConsulta();
			List<Consulta> lista = new ArrayList<Consulta>();
			Date data = ca.dataStringParaDataSql("28/07/2012");
			lista = dao.pesquisarTodosConsultaData(data);
			if (lista.size()>0){
				for (Consulta consulta : lista) {
					System.out.println(consulta.getDataConsulta());
				}
			}else{
				System.out.println("Nenhuma consulta encontrada");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}


