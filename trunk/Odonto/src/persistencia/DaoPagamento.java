package persistencia;

import java.util.ArrayList;
import java.util.List;

import modelo.Odontograma;
import modelo.Paciente;
import modelo.Pagamento;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;

public class DaoPagamento {

	private Session session = null;
	private Transaction transaction = null;
	
	public void cadastrarPagamento(Pagamento pagamento) throws Exception{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.persist(pagamento);
			transaction.commit();
			session.flush();
			session.close();
	}

	public void alterarPagamento(Pagamento pagamento) throws Exception{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(pagamento);
			transaction.commit();
			session.flush();
			session.close();
	}

	public void excluirPagamento(Pagamento pagamento) throws Exception{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(pagamento);
			transaction.commit();
			session.flush();
			session.close();
	}

	public List<Pagamento> pesquisarPagamentoPorOdontograma(Odontograma odontograma) throws Exception{
		List<Pagamento> lista = null;
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(Pagamento.class).add(Restrictions.eq("odontograma",odontograma));
		lista = (ArrayList)cr.list();
		session.flush();
		session.close();
		return lista;
	}
	
	public List<Pagamento> pesquisarTodosPagamento() throws Exception{
		List<Pagamento> lista = null;
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(Pagamento.class);
		lista = (ArrayList)cr.list();
		session.flush();
		session.close();
		return lista;
	}

}
