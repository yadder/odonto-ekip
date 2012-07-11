package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Fornecedor;
import persistencia.DaoFornecedor;

public class ServletFornecedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String mensagem = null;   
    public ServletFornecedor() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String btn = (String)request.getParameter("btn");
		HttpSession objetoSessao = request.getSession();

		if (btn.equals("Voltar")){
			objetoSessao.removeAttribute("fornecedor");
			RequestDispatcher disp = request.getRequestDispatcher("principal.jsp");
			disp.forward(request, response);
			
		}else if (btn.equals("Cadastrar")){
			String nomeFornecedor = (String) request.getParameter("nomeFornecedor");
			String nomeVendedor = (String) request.getParameter("nomeVendedor");
			String emailVendedor = (String) request.getParameter("emailVendedor");
			String siteFornecedor = (String) request.getParameter("siteFornecedor");
			String cnpjFornecedor = (String) request.getParameter("cnpjFornecedor");
			String logradouroFornecedor = (String) request.getParameter("logradouroFornecedor");
			String numeroLogradouroFornecedor = (String) request.getParameter("numeroLogradouroFornecedor");
			String complementoLogradouroFornecedor = (String) request.getParameter("complementoLogradouroFornecedor");
			String bairroFornecedor = (String) request.getParameter("bairroFornecedor");
			String cidadeFornecedor = (String) request.getParameter("cidadeFornecedor");
			String estadoFornecedor = (String) request.getParameter("estadoFornecedor");
			String cepFornecedor = (String) request.getParameter("cepFornecedor");
			String ddd1Fornecedor = (String) request.getParameter("ddd1Fornecedor");
			String telefone1Fornecedor = (String) request.getParameter("telefone1Fornecedor");
			String ddd2Fornecedor = (String) request.getParameter("ddd2Fornecedor");
			String telefone2Fornecedor = (String) request.getParameter("telefone2Fornecedor");
			Fornecedor fornecedor = new Fornecedor(nomeFornecedor,nomeVendedor,emailVendedor,siteFornecedor,cnpjFornecedor,
					logradouroFornecedor,numeroLogradouroFornecedor,complementoLogradouroFornecedor,bairroFornecedor,
					cidadeFornecedor,estadoFornecedor,cepFornecedor,ddd1Fornecedor,telefone1Fornecedor,ddd2Fornecedor,
					telefone2Fornecedor);
			objetoSessao.setAttribute("fornecedor", fornecedor);
			if (validaCampos(nomeFornecedor, cnpjFornecedor, nomeVendedor, emailVendedor)){				
				fornecedor = new Fornecedor(nomeFornecedor,nomeVendedor,emailVendedor,siteFornecedor,cnpjFornecedor,
						logradouroFornecedor,numeroLogradouroFornecedor,complementoLogradouroFornecedor,bairroFornecedor,
						cidadeFornecedor,estadoFornecedor,cepFornecedor,ddd1Fornecedor,telefone1Fornecedor,ddd2Fornecedor,
						telefone2Fornecedor);
				DaoFornecedor dao = new DaoFornecedor();
				dao.cadastrarFornecedor(fornecedor);
				mensagem = "Fornecedor cadastrado com sucesso!";
				objetoSessao.removeAttribute("fornecedor");
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("fornecedor.jsp");
				disp.forward(request, response);
			}else{
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("fornecedor.jsp");
				disp.forward(request, response);
			}
		}else if (btn.equals("Pesquisar")){
			
			String nomeFornecedor = (String) request.getParameter("nomeFornecedor");
			Fornecedor fornecedor = new Fornecedor(nomeFornecedor);
			DaoFornecedor dao = new DaoFornecedor();
			fornecedor = dao.pesquisarFornecedorPorNome(nomeFornecedor);
			if (fornecedor != null){
				mensagem = "Fornecedor encontrado.";
				request.setAttribute("msg", mensagem);
				objetoSessao.setAttribute("fornecedor", fornecedor);
				RequestDispatcher disp = request.getRequestDispatcher("fornecedor_alterar.jsp");
				disp.forward(request, response);
			}else{
				mensagem = "Fornecedor não encontrado.";
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("fornecedor.jsp");
				disp.forward(request, response);
			}
		}else if(btn.equals("Excluir")){

				Fornecedor fornecedor = new Fornecedor();
				fornecedor = (Fornecedor)objetoSessao.getAttribute("fornecedor");
				DaoFornecedor dao = new DaoFornecedor();
				boolean result = dao.excluirFornecedor(fornecedor);
				if (result){
					mensagem = "Fornecedor excluído com sucesso.";
					request.setAttribute("msg", mensagem);
					objetoSessao.removeAttribute("fornecedor");
					RequestDispatcher disp = request.getRequestDispatcher("fornecedor.jsp");
					disp.forward(request, response);
				}else{
					mensagem = "Ocorreu algum erro ao excluir o fornecedor.";
					request.setAttribute("msg", mensagem);
					RequestDispatcher disp = request.getRequestDispatcher("fornecedor.jsp");
					disp.forward(request, response);
				}
		}else if(btn.equals("Alterar")){
			String nomeFornecedor = (String) request.getParameter("nomeFornecedor");
			String nomeVendedor = (String) request.getParameter("nomeVendedor");
			String emailVendedor = (String) request.getParameter("emailVendedor");
			String siteFornecedor = (String) request.getParameter("siteFornecedor");
			String cnpjFornecedor = (String) request.getParameter("cnpjFornecedor");
			String logradouroFornecedor = (String) request.getParameter("logradouroFornecedor");
			String numeroLogradouroFornecedor = (String) request.getParameter("numeroLogradouroFornecedor");
			String complementoLogradouroFornecedor = (String) request.getParameter("complementoLogradouroFornecedor");
			String bairroFornecedor = (String) request.getParameter("bairroFornecedor");
			String cidadeFornecedor = (String) request.getParameter("cidadeFornecedor");
			String estadoFornecedor = (String) request.getParameter("estadoFornecedor");
			String cepFornecedor = (String) request.getParameter("cepFornecedor");
			String ddd1Fornecedor = (String) request.getParameter("ddd1Fornecedor");
			String telefone1Fornecedor = (String) request.getParameter("telefone1Fornecedor");
			String ddd2Fornecedor = (String) request.getParameter("ddd2Fornecedor");
			String telefone2Fornecedor = (String) request.getParameter("telefone2Fornecedor");
			if (validaCampos(nomeFornecedor, cnpjFornecedor, nomeVendedor, emailVendedor)){	
				Fornecedor fornecedor = new Fornecedor();
				fornecedor = (Fornecedor)objetoSessao.getAttribute("fornecedor");
				fornecedor.setNomeFornecedor(nomeFornecedor);
				fornecedor.setNomeVendedor(nomeVendedor);
				fornecedor.setEmailVendedor(emailVendedor);
				fornecedor.setSiteFornecedor(siteFornecedor);
				fornecedor.setCnpjFornecedor(cnpjFornecedor);
				fornecedor.setLogradouroFornecedor(logradouroFornecedor);
				fornecedor.setNumeroLogradouroFornecedor(numeroLogradouroFornecedor);
				fornecedor.setComplementoLogradouroFornecedor(complementoLogradouroFornecedor);
				fornecedor.setBairroFornecedor(bairroFornecedor);
				fornecedor.setCidadeFornecedor(cidadeFornecedor);
				fornecedor.setEstadoFornecedor(estadoFornecedor);
				fornecedor.setCepFornecedor(cepFornecedor);
				fornecedor.setDdd1Fornecedor(ddd1Fornecedor);
				fornecedor.setTelefone1Fornecedor(telefone1Fornecedor);
				fornecedor.setDdd2Fornecedor(ddd2Fornecedor);
				fornecedor.setTelefone2Fornecedor(telefone2Fornecedor);
				
				DaoFornecedor dao = new DaoFornecedor();
				boolean result = dao.alterarFornecedor(fornecedor);
				if (result){
					mensagem = "Fornecedor alterado com sucesso.";
					request.setAttribute("msg", mensagem);
					objetoSessao.removeAttribute("fornecedor");
					RequestDispatcher disp = request.getRequestDispatcher("fornecedor.jsp");
					disp.forward(request, response);
				}else{
					mensagem = "Ocorreu algum erro ao alterar o fornecedor.";
					request.setAttribute("msg", mensagem);
					RequestDispatcher disp = request.getRequestDispatcher("fornecedor.jsp");
					disp.forward(request, response);
				}
			}else{
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("fornecedor_alterar.jsp");
				disp.forward(request, response);
			}
		}
	
	}
	
	public boolean validaCampos(String nomeFornecedor, String cnpjFornecedor, String nomeVendedor, String emailVendedor){
		boolean result = false;
		if ((nomeFornecedor == null) || (nomeFornecedor.equals("") || (nomeFornecedor.length()<3))){
			mensagem = "Preencha o nome do fornecedor corretamente.";
		}else if ((nomeVendedor == null) || (nomeVendedor.equals("") || (nomeVendedor.length()<5))){
			mensagem = "Preencha o nome do vendedor corretamente.";
		}else if ((emailVendedor == null) || (emailVendedor.equals("") || (emailVendedor.length()<5))){
			mensagem = "Preencha o email do vendedor corretamente.";
		}else if ((cnpjFornecedor == null) || (cnpjFornecedor.equals("") || (cnpjFornecedor.length()<18))){
			mensagem = "Preencha o CNPJ do fornecedor corretamente.";
		}else{
			result = true;
		}
		return result;
	}

}
