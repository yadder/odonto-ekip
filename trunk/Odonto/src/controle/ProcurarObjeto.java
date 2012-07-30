package controle;

import java.util.ArrayList;
import java.util.List;

import modelo.Consulta;
import modelo.Convenio;
import modelo.Dentista;
import modelo.Elemento;
import modelo.Face;
import modelo.Odontograma;
import modelo.OdontogramaProcedimento;
import modelo.Paciente;
import modelo.Pagamento;
import modelo.Procedimento;
import persistencia.DaoConsulta;
import persistencia.DaoConvenio;
import persistencia.DaoDentista;
import persistencia.DaoElemento;
import persistencia.DaoFace;
import persistencia.DaoOdontograma;
import persistencia.DaoOdontogramaProcedimento;
import persistencia.DaoPaciente;
import persistencia.DaoPagamento;
import persistencia.DaoProcedimento;

public class ProcurarObjeto {
	
	public Paciente getPaciente(String nome){
		try{
			Paciente paciente = new Paciente();
			paciente.setNomeUsuario(nome);
			DaoPaciente daoPaciente = new DaoPaciente();
			paciente = daoPaciente.pesquisarPacientePorNome(paciente);
			if (paciente!=null){
				return paciente;
			}else{
				return null;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	public Paciente getPacientePorId(long id){
		try{
			Paciente paciente = new Paciente();
			paciente.setIdUsuario(id);
			DaoPaciente daoPaciente = new DaoPaciente();
			paciente = daoPaciente.pesquisarPacientePorId(paciente);
			if (paciente!=null){
				return paciente;
			}else{
				return null;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	public Odontograma getOdontogramaEmAndamento(Paciente paciente){
		try{
			DaoOdontograma daoOdontograma = new DaoOdontograma();
			Odontograma odontograma = new Odontograma();
			odontograma = daoOdontograma.pesquisarOdontogramaPorPacienteEmAndamento(paciente);
			if (odontograma!=null){
				return odontograma;
			}else{
				return null;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	public Dentista getDentista(String nome){
		try{
			Dentista dentista = new Dentista();
			dentista.setNomeUsuario(nome);
			DaoDentista daoDentista = new DaoDentista();
			dentista = daoDentista.pesquisarDentistaPorNome(dentista);
			if (dentista!=null){
				return dentista;
			}else{
				return null;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	public Dentista getDentistaPorId(long id){
		try{
			Dentista dentista = new Dentista();
			dentista.setIdUsuario(id);
			DaoDentista daoDentista = new DaoDentista();
			dentista = daoDentista.pesquisarDentistaPorId(dentista);
			if (dentista!=null){
				return dentista;
			}else{
				return null;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	public List<Dentista> getListaDentista(){
		try{
			List<Dentista> listaDentista = new ArrayList<Dentista>();
			DaoDentista daoDentista = new DaoDentista();
			listaDentista = daoDentista.pesquisarTodosDentista();
			if (listaDentista.isEmpty()){
				return null;
			}else{
				return listaDentista;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	public List<Face> getListaFaces(){
		try{
			List<Face> listaFace = new ArrayList<Face>();
			DaoFace daoFace = new DaoFace();
			listaFace = daoFace.pesquisarTodosFace();
			if (listaFace.isEmpty()){
				return null;
			}else{
				return listaFace;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Procedimento> getListaProcedimentosPorConvenio(Convenio convenio){
		try{
			List<Procedimento> listaProcedimento = new ArrayList<Procedimento>();
			DaoProcedimento daoProcedimento = new DaoProcedimento();
			listaProcedimento = daoProcedimento.pesquisarProcedimentoPorConvenio(convenio);
			if (listaProcedimento.isEmpty()){
				return null;
			}else{
				return listaProcedimento;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	public Elemento getElemento(String nome){
		try{
			Elemento elemento = new Elemento();
			DaoElemento daoElemento = new DaoElemento();
			elemento.setNomeElemento(nome);
			elemento = daoElemento.pesquisarElementoPorNome(elemento);
			if (elemento!= null){
				return elemento;		
			}else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Face getFace(String nome){
		try{
			Face face = new Face();
			DaoFace daoFace = new DaoFace();
			face.setNomeFace(nome);
			face = daoFace.pesquisarFacePorNome(face);
			if (face!=null){
				return face;
			}else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Procedimento getProcedimentoPorNomeEConvenio(String nome, Convenio convenio){
		try{
			Procedimento procedimento = new Procedimento();
			DaoProcedimento daoProcedimento = new DaoProcedimento();
			procedimento.setDescricaoProcedimento(nome);
			procedimento.setConvenio(convenio);
			procedimento = daoProcedimento.pesquisarProcedimentoPorDescricaoEConvenio(procedimento);
			if (procedimento != null){
				return procedimento;
			}else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Consulta getConsultaPorId(long id){
		try{
			Consulta consulta = new Consulta();
			DaoConsulta daoConsulta = new DaoConsulta();
			consulta = daoConsulta.pesquisarConsultaPorId(id);
			if (consulta != null){
				return consulta;
			}else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public OdontogramaProcedimento getOdontogramaProcedimentoPorId(long id){
		try{
			OdontogramaProcedimento odontogramaProcedimento = new OdontogramaProcedimento();
			DaoOdontogramaProcedimento daoOdontogramaProcedimento = new DaoOdontogramaProcedimento();
			odontogramaProcedimento = daoOdontogramaProcedimento.pesquisarOdontogramaProcedimentoPorId(id);
			if (odontogramaProcedimento != null){
				return odontogramaProcedimento;
			}else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Pagamento> getPagamentoPorOdontograma(Odontograma odontograma){
		try{
			List<Pagamento> listaPagamento = new ArrayList<Pagamento>();
			DaoPagamento daoPagamento = new DaoPagamento();
			listaPagamento = daoPagamento.pesquisarPagamentoPorOdontograma(odontograma);
			if (listaPagamento.isEmpty()){
				return null;
			}else{
				return listaPagamento;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Pagamento> getPagamentoPendentePorPaciente(Paciente paciente){
		try{
			List<Pagamento> listaPagamento = new ArrayList<Pagamento>();
			DaoPagamento daoPagamento = new DaoPagamento();
			listaPagamento = daoPagamento.pesquisarPagamentoPendentePorPaciente(paciente);
			if (listaPagamento.isEmpty()){
				return null;
			}else{
				return listaPagamento;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<OdontogramaProcedimento> getOdontogramaProcedimentoPendentePorOdontograma(Odontograma odontograma){
		try{
			List<OdontogramaProcedimento> lista = new ArrayList<OdontogramaProcedimento>();
			DaoOdontogramaProcedimento daoOdontogramaProcedimento = new DaoOdontogramaProcedimento();
			lista = daoOdontogramaProcedimento.pesquisarOdontogramaProcedimentoPendentePorOdontograma(odontograma);
			if (lista.isEmpty()){
				return null;
			}else{
				return lista;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<OdontogramaProcedimento> getOdontogramaProcedimentoPendente(){
		try{
			List<OdontogramaProcedimento> lista = new ArrayList<OdontogramaProcedimento>();
			DaoOdontogramaProcedimento daoOdontogramaProcedimento = new DaoOdontogramaProcedimento();
			lista = daoOdontogramaProcedimento.pesquisarOdontogramaProcedimentoPendente();
			if (lista.isEmpty()){
				return null;
			}else{
				return lista;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Pagamento getPagamentoPorId(long id){
		try{
			Pagamento pagamento = new Pagamento();
			DaoPagamento daoPagamento = new DaoPagamento();
			pagamento = daoPagamento.pesquisarPagamentoPorId(id);
			if (pagamento!= null){
				return pagamento;
			}else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Convenio getConvenioPorNome(String nome){
		try{
			Convenio convenio = new Convenio();
			convenio.setNomeConvenio(nome);
			DaoConvenio daoConvenio = new DaoConvenio();
			convenio = daoConvenio.pesquisarConvenioPorNome(convenio);
			if (convenio!= null){
				return convenio;
			}else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	
}
