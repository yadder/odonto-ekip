package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import persistencia.DaoInqueritoOdontologico;

import modelo.InqueritoOdontologico;
import modelo.Paciente;

public class ServletInquerito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletInquerito() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String btn = (String)request.getParameter("btn");
		HttpSession objetoSessao = request.getSession();
		ConfiguraAtributo ca = new ConfiguraAtributo();
		ProcurarObjeto po = new ProcurarObjeto();
		InqueritoOdontologico inquerito = new InqueritoOdontologico();
		
		if (btn.equals("Voltar")){
			objetoSessao.removeAttribute("inquerito");
			objetoSessao.removeAttribute("paciente");
			ca.sendRedirect(request, response, null, null, "principal.jsp");
		}else if(btn.equals("Pesquisar paciente")){
			Paciente paciente = new Paciente();
			paciente = po.getPaciente((String)request.getParameter("nomePaciente"));
			if (paciente!=null){
				objetoSessao.setAttribute("paciente", paciente);
				ca.sendRedirect(request, response, "Paciente encontrado(a).", null, "inqueritoSaude.jsp");
			}else{
				ca.sendRedirect(request, response, null, "Paciente não encontrado(a).", "pesquisar_paciente_inquerito.jsp");
			}
		}else if (btn.equals("Próximo")){
			if (validaCampos1(request, response)){
				inquerito = preencheObjeto1(request, response, inquerito);
				inquerito.setPaciente((Paciente)objetoSessao.getAttribute("paciente"));
				objetoSessao.setAttribute("inquerito", inquerito);
				ca.sendRedirect(request, response, null, null, "inqueritoOdontologico.jsp");
			}else{
				ca.sendRedirect(request, response, null, "Todos os campos devem ser preenchidos.", "inqueritoSaude.jsp");
			}
		}else if(btn.equals("Cadastrar")){
			if (validaCampos2(request, response)){
				inquerito = (InqueritoOdontologico)objetoSessao.getAttribute("inquerito");
				inquerito = preencheObjeto2(request, response, inquerito);
				DaoInqueritoOdontologico daoInquerito = new DaoInqueritoOdontologico();
				try{
					daoInquerito.cadastrarInqueritoOdontologico(inquerito);
					objetoSessao.removeAttribute("inquerito");
					objetoSessao.removeAttribute("paciente");
					ca.sendRedirect(request, response, "Inquérito odontológico cadastrado com sucesso!", null, "principal.jsp");
				}catch (Exception e) {
					ca.sendRedirect(request, response, null, "Erro ao gravar inquérito odontológico. "+e.getMessage(), "inqueritoOdontologico.jsp");
				}
			}else{
				ca.sendRedirect(request, response, null, "Todos os campos devem ser preenchidos.", "inqueritoOdontologico.jsp");
			}
		}
	}
	
	public InqueritoOdontologico preencheObjeto1(HttpServletRequest request, HttpServletResponse response, InqueritoOdontologico inquerito) throws ServletException, IOException{
		if (request.getParameter("tratamento").equals("S")){
			inquerito.setTratamentoMedico((String)request.getParameter("qualtratamento"));
		}else{
			inquerito.setTratamentoMedico((String)request.getParameter("tratamento"));
		}
		if (request.getParameter("medicacao").equals("S")){
			inquerito.setUsandoMedicacao((String)request.getParameter("qualmedicacao"));
		}else{
			inquerito.setUsandoMedicacao((String)request.getParameter("medicacao"));
		}
		if (request.getParameter("alergia").equals("S")){
			inquerito.setAlergia((String)request.getParameter("qualalergia"));
		}else{
			inquerito.setAlergia((String)request.getParameter("alergia"));
		}		
		inquerito.setAnemia((String)request.getParameter("anemia"));
		inquerito.setFumante((String)request.getParameter("fumante"));
		inquerito.setHepatite((String)request.getParameter("hepatite"));
		inquerito.setAlcoolista((String)request.getParameter("alcoolista"));
		inquerito.setSifilis((String)request.getParameter("sifilis"));
		inquerito.setHerpesAfta((String)request.getParameter("herpes_aftas"));
		inquerito.setHiv((String)request.getParameter("hiv"));
		inquerito.setGravidez((String)request.getParameter("gravidez"));
		inquerito.setTuberculose((String)request.getParameter("tuberculose"));
		inquerito.setDiabetes((String)request.getParameter("diabetes"));
		inquerito.setAsma((String)request.getParameter("asma"));
		inquerito.setCardiaco((String)request.getParameter("cardiaco"));	
		return inquerito;
	}
	
	public InqueritoOdontologico preencheObjeto2(HttpServletRequest request, HttpServletResponse response, InqueritoOdontologico inquerito) throws ServletException, IOException{
		ConfiguraAtributo ca = new ConfiguraAtributo();
		inquerito.setDataUltimoAtendimento(ca.dataStringParaDataSql((String)request.getParameter("dtUltimoAtendimento")));
		inquerito.setConcluiuTratamento((String)request.getParameter("tratamento"));
		inquerito.setExperienciaNegativaTratamento((String)request.getParameter("experienciaNegativa"));
		inquerito.setRoerUnhas((String)request.getParameter("roerUnhas"));
		inquerito.setRespirarPelaBoca((String)request.getParameter("respirarPelaBoca"));
		inquerito.setMorderObjetos((String)request.getParameter("morderObjetos"));
		inquerito.setRangerOsDentes((String)request.getParameter("rangerOsDentes"));
		inquerito.setChuparDedoChupeta((String)request.getParameter("chuparDedoOuChupeta"));
		inquerito.setOutros((String)request.getParameter("outros"));
		inquerito.setFioFitaDental((String)request.getParameter("fioFitaDental"));
		inquerito.setPalito((String)request.getParameter("palito"));
		inquerito.setUnitufoBitufo((String)request.getParameter("unitufoBitufo"));
		inquerito.setTipoEscova((String)request.getParameter("escovaMaciaMediaDura"));
		inquerito.setInterdental((String)request.getParameter("interdental"));
		inquerito.setCremeDental((String)request.getParameter("cremedental"));
		inquerito.setIngereAlimentosEntreRefeicoes((String)request.getParameter("ingereAlimentosBebidasRefeicoes"));
		return inquerito;
	}
	
	public boolean validaCampos1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		if (((String)request.getParameter("tratamento") == null)){
			return false;
		}else if (((String)request.getParameter("medicacao") == null)){
			return false;
		}else if (((String)request.getParameter("alergia") == null)){
			return false;
		}else if (((String)request.getParameter("anemia")) == null){
			return false;
		}else if (((String)request.getParameter("fumante")) == null){
			return false;
		}else if (((String)request.getParameter("hepatite")) == null){
			return false;
		}else if (((String)request.getParameter("alcoolista")) == null){
			return false;
		}else if (((String)request.getParameter("sifilis")) == null){
			return false;
		}else if (((String)request.getParameter("herpes_aftas")) == null){
			return false;
		}else if (((String)request.getParameter("hiv")) == null){
			return false;
		}else if (((String)request.getParameter("gravidez")) == null){
			return false;
		}else if (((String)request.getParameter("tuberculose")) == null){
			return false;
		}else if (((String)request.getParameter("diabetes")) == null){
			return false;
		}else if (((String)request.getParameter("asma")) == null){
			return false;
		}else if (((String)request.getParameter("cardiaco")) == null){
			return false;
		}else{
			return true;
		}
	}
	
	public boolean validaCampos2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		if (((String)request.getParameter("dtUltimoAtendimento")) == null){
			return false;
		}else if (((String)request.getParameter("tratamento")) == null){
			return false;
		}else if (((String)request.getParameter("ingereAlimentosBebidasRefeicoes")) == null){
			return false;
		}else{
			return true;
		}
	}
}
