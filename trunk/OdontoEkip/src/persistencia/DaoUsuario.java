package persistencia;

import java.util.ArrayList;

import modelo.Dentista;
import modelo.Paciente;
import modelo.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class DaoUsuario {

	private SessionFactory fabrica;
	
	public DaoUsuario() {
		fabrica = new AnnotationConfiguration().addAnnotatedClass(Usuario.class).addAnnotatedClass(Paciente.class).addAnnotatedClass(Dentista.class).buildSessionFactory();
	}
	public void cadastrar(Usuario u) throws Exception{
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		sessao.save(u);
		transacao.commit();
		sessao.flush();
		sessao.close();
	}
	
	public void alterar(Usuario u) throws Exception{
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		sessao.update(u);
		transacao.commit();
		sessao.flush();
		sessao.close();
	}
	
	public void deletar(Usuario u) throws Exception{
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		sessao.delete(u);
		transacao.commit();
		sessao.flush();
		sessao.close();
	}
	
	public Usuario consultarUsuario(Usuario u)throws Exception{
		Session sessao = fabrica.openSession();
		Query q = sessao.createQuery("from modelo.Usuario where loginUsuario=:A");
		q.setString("A", u.getLoginUsuario());
		ArrayList lista = (ArrayList)q.list();
		if (lista.size() == 0){
			return null;
		} else{
			return (Usuario)lista.get(0);
		}
	}
	
	public ArrayList consultarTodos() throws Exception{
		Session sessao = fabrica.openSession();
		Query q = sessao.createQuery("from modelo.Usuario");
		ArrayList lista = (ArrayList)q.list();
		sessao.flush();
		sessao.close();
		return lista;
	}
	
	
}
