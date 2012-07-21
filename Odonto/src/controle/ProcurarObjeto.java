package controle;

import persistencia.DaoPaciente;
import modelo.Paciente;

public class ProcurarObjeto {
	
	public Paciente getPaciente(String nome){
		try{
			Paciente paciente = new Paciente();
			paciente.setNomeUsuario(nome);
			DaoPaciente daoPaciente = new DaoPaciente();
			paciente = daoPaciente.pesquisarPacientePorNome(paciente);
			return paciente;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	
	
}
