package util;

import modelo.Face;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class GerarTabelas {

	public static void main(String[] args) {
		AnnotationConfiguration conf = new AnnotationConfiguration().configure("util/hibernate.cfg.xml");
		conf.addAnnotatedClass(Face.class);
		
		SchemaExport sE = new SchemaExport(conf);
		sE.create(true, true);

		System.out.println("Tabela: " + Face.class.getName() + " foi criada com êxito.");
	}

}
