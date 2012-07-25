package persistencia;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Fabrica {
	
	private static SessionFactory fabrica; 	
	
	private Fabrica(){   
		fabrica = new AnnotationConfiguration().configure("util/hibernate.cfg.xml").buildSessionFactory();
	}
	
	public static SessionFactory obtemFabrica(){
		if (fabrica == null){
			new Fabrica();
		}
		return fabrica;
	}
}