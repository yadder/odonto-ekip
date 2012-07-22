package persistencia;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import modelo.Consulta;
import modelo.Odontograma;
import modelo.Paciente;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;

public class DaoOdontograma {

	private Session session = null;
	private Transaction transaction = null;
	
	public void cadastrarOdontograma(Odontograma odontograma) throws Exception{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.persist(odontograma);
			transaction.commit();
			session.flush();
			session.close();
	}

	public void alterarOdontograma(Odontograma odontograma) throws Exception{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(odontograma);
			transaction.commit();
			session.flush();
			session.close();
	}

	public void excluirOdontograma(Odontograma odontograma) throws Exception{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(odontograma);
			transaction.commit();
			session.flush();
			session.close();
	}

	public Odontograma pesquisarOdontogramaPorPacienteEmAndamento(Paciente paciente) throws Exception{
		Odontograma o = null;
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(Odontograma.class).add(Restrictions.eq("paciente", paciente)).add(Restrictions.eq("statusOdontograma", "EM ANDAMENTO"));
		o = (Odontograma)cr.uniqueResult();
		session.flush();
		session.close();
		return o;
	}
	
	public List<Odontograma> pesquisarTodosOdontograma() throws Exception{
		List<Odontograma> lista = null;
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(Odontograma.class);
		lista = (ArrayList)cr.list();
		session.flush();
		session.close();
		return lista;
	}
	
	public List<Odontograma> pesquisarTodosOdontogramaFinalizadoDataIniDataFim(Date dataini,Date datafim, String status ) throws Exception{
		List<Odontograma> lista = null;
		session = HibernateUtil.getSessionFactory().openSession();
		//Criteria cr = session.createCriteria(Consulta.class).add(Restrictions.between(Data, dataini, datafim)eq("dataConsulta", data));
		Criteria cr = session.createCriteria(Odontograma.class).add(Restrictions.between("dataFimOdontograma", dataini,datafim)).add(Restrictions.eq("statusOdontograma", "FINALIZADO"));
		lista = (ArrayList)cr.list();
		session.flush();
		session.close();
		return lista;
	}
	
	
	
}
