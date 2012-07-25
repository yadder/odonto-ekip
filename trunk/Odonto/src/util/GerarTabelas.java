package util;

import modelo.Acesso;
import modelo.Consulta;
import modelo.Convenio;
import modelo.Dentista;
import modelo.Elemento;
import modelo.Face;
import modelo.Fornecedor;
import modelo.InqueritoOdontologico;
import modelo.Odontograma;
import modelo.OdontogramaProcedimento;
import modelo.Paciente;
import modelo.Pagamento;
import modelo.Prescricao;
import modelo.Procedimento;
import modelo.Usuario;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class GerarTabelas {

	public static void main(String[] args) {
		try{
			AnnotationConfiguration conf = new AnnotationConfiguration().configure("util/hibernate.cfg.xml");
			conf.addAnnotatedClass(Usuario.class);
			conf.addAnnotatedClass(Consulta.class);
			conf.addAnnotatedClass(Convenio.class);
			conf.addAnnotatedClass(Dentista.class);
			conf.addAnnotatedClass(Elemento.class);
			conf.addAnnotatedClass(Face.class);
			conf.addAnnotatedClass(Fornecedor.class);
			conf.addAnnotatedClass(InqueritoOdontologico.class);
			conf.addAnnotatedClass(Odontograma.class);
			conf.addAnnotatedClass(OdontogramaProcedimento.class);
			conf.addAnnotatedClass(Paciente.class);
			conf.addAnnotatedClass(Pagamento.class);
			conf.addAnnotatedClass(Prescricao.class);
			conf.addAnnotatedClass(Procedimento.class);
			conf.addAnnotatedClass(Acesso.class);
			
			SchemaExport se = new SchemaExport(conf);
			se.create(true, true);
			System.out.println("Tabelas criadas com êxito.");
			
		}catch(Exception e){
			System.out.println("Erro ao criar as tabelas: "+ e.getMessage());
		}
		
	}

}
