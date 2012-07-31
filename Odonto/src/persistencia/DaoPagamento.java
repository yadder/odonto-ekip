package persistencia;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import modelo.Odontograma;
import modelo.Paciente;
import modelo.Pagamento;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class DaoPagamento {

	private SessionFactory fabrica;
	private Session session = null;
	private Transaction transaction = null;
	
	public DaoPagamento(){
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
	
	public void cadastrarPagamento(Pagamento pagamento) throws Exception{
			session.persist(pagamento);
			transaction.commit();
			closeSession();
	}

	public void alterarPagamento(Pagamento pagamento) throws Exception{
			session.update(pagamento);
			transaction.commit();
			closeSession();
	}

	public void excluirPagamento(Pagamento pagamento) throws Exception{
			session.delete(pagamento);
			transaction.commit();
			closeSession();
	}

	public List<Pagamento> pesquisarPagamentoPorOdontograma(Odontograma odontograma) throws Exception{
		List<Pagamento> lista = null;
		Criteria cr = session.createCriteria(Pagamento.class).add(Restrictions.eq("odontograma",odontograma));
		lista = (ArrayList)cr.list();
		closeSession();
		return lista;
	}
	
	public List<Pagamento> pesquisarPagamentoPendentePorPaciente(Paciente paciente) throws Exception{
		List<Pagamento> lista = null;
		Criteria cr = session.createCriteria(Pagamento.class).add(Restrictions.eq("paciente",paciente)).add(Restrictions.eq("statusPagamento","PENDENTE"));
		lista = (ArrayList)cr.list();
		closeSession();
		return lista;
	}
	
	public List<Pagamento> pesquisarTodosPagamentoStatusDataIniDataFim(Date dataini,Date datafim, String status ) throws Exception{
		List<Pagamento> lista = null;
		Criteria cr = session.createCriteria(Pagamento.class).add(Restrictions.between("dataVencimento", dataini,datafim)).add(Restrictions.eq("statusPagamento", status));
		lista = (ArrayList)cr.list();
		closeSession();
		return lista;
	}
	
	
	public Pagamento pesquisarPagamentoPorId(long id) throws Exception{
		Pagamento p = null;
		Criteria cr = session.createCriteria(Pagamento.class).add(Restrictions.eq("idPagamento",id));
		p = (Pagamento)cr.uniqueResult();
		closeSession();
		return p;
	}
	
	public List<Pagamento> pesquisarTodosPagamento() throws Exception{
		List<Pagamento> lista = null;
		Criteria cr = session.createCriteria(Pagamento.class);
		lista = (ArrayList)cr.list();
		closeSession();
		return lista;
	}
	
	public List<Pagamento> pesquisarPagamentoPendente(java.util.Date data) throws Exception{
		List<Pagamento> lista = null;
		Criteria cr = session.createCriteria(Pagamento.class).add(Restrictions.eq("statusPagamento", "PENDENTE")).add(Restrictions.le("dataVencimento", data));
		lista = (ArrayList)cr.list();
		closeSession();
		return lista;
	}

}
