package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class REMOVER_HibernateUtil {

	private static final SessionFactory sessionFactory;
	
	static {
		try{
			sessionFactory = new AnnotationConfiguration().configure("util/hibernate.cfg.xml").buildSessionFactory();
		}catch (Throwable ex){
			System.out.println("Erro na criação da sessão: "+ ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
