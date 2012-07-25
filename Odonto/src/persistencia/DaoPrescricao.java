package persistencia;

import java.util.ArrayList;
import java.util.List;

import modelo.Prescricao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DaoPrescricao {

	private SessionFactory fabrica;
	private Session session = null;
	private Transaction transaction = null;
	
	public DaoPrescricao(){
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
	
	public void cadastrarPrescricao(Prescricao prescricao) throws Exception{
			session.persist(prescricao);
			transaction.commit();
			closeSession();
	}

	public void alterarPrescricao(Prescricao prescricao) throws Exception{
			session.update(prescricao);
			transaction.commit();
			closeSession();
	}

	public void excluirPrescricao(Prescricao prescricao) throws Exception{
			session.delete(prescricao);
			transaction.commit();
			closeSession();
	}

	public List<Prescricao> pesquisarTodosPrescricao() throws Exception{
		List<Prescricao> lista = null;
		Criteria cr = session.createCriteria(Prescricao.class);
		lista = (ArrayList)cr.list();
		closeSession();
		return lista;
	}

}
