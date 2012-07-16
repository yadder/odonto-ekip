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
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String btn = (String)request.getParameter("btn");
		HttpSession objetoSessao = request.getSession();
		Fornecedor fornecedor = new Fornecedor();

		if (btn.equals("Voltar")){
			objetoSessao.removeAttribute("fornecedor");
			RequestDispatcher disp = request.getRequestDispatcher("principal.jsp");
			disp.forward(request, response);
			
		}else if (btn.equals("Cadastrar")){
			fornecedor = preencheObjeto(request, response);
			objetoSessao.setAttribute("fornecedor",fornecedor);
			if (validaCampos(fornecedor)){				
				try{
					DaoFornecedor daoFornecedor = new DaoFornecedor();
					daoFornecedor.cadastrarFornecedor(fornecedor);
					mensagem = "Fornecedor cadastrado com sucesso!";
					objetoSessao.removeAttribute("fornecedor");
					request.setAttribute("msg", mensagem);
					RequestDispatcher disp = request.getRequestDispatcher("fornecedor.jsp");
					disp.forward(request, response);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}else{
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("fornecedor.jsp");
				disp.forward(request, response);
			}
		}else if (btn.equals("Pesquisar")){
			fornecedor = preencheObjeto(request, response);
			if (fornecedor.getNomeFornecedor()!=null){
				try{
					DaoFornecedor dao = new DaoFornecedor();
					fornecedor = dao.pesquisarFornecedorPorNome(fornecedor);
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
				}catch (Exception e) {
					e.printStackTrace();
				}
			}else{
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("fornecedor.jsp");
				disp.forward(request, response);
			}
		}else if(btn.equals("Excluir")){
			try{
				fornecedor = (Fornecedor)objetoSessao.getAttribute("fornecedor");
				DaoFornecedor dao = new DaoFornecedor();
				dao.excluirFornecedor(fornecedor);
				mensagem = "Fornecedor excluído com sucesso.";
				request.setAttribute("msg", mensagem);
				objetoSessao.removeAttribute("fornecedor");
				RequestDispatcher disp = request.getRequestDispatcher("fornecedor.jsp");
				disp.forward(request, response);
			}catch (Exception e) {
				mensagem = "Ocorreu algum erro ao excluir o fornecedor.";
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("fornecedor.jsp");
				disp.forward(request, response);
				e.printStackTrace();
			}
		}else if(btn.equals("Alterar")){
			fornecedor = preencheObjeto(request, response);
			fornecedor.setIdFornecedor(((Fornecedor)objetoSessao.getAttribute("fornecedor")).getIdFornecedor());
			if (validaCampos(fornecedor)){	
				try{					
					DaoFornecedor dao = new DaoFornecedor();
					dao.alterarFornecedor(fornecedor);
					mensagem = "Fornecedor alterado com sucesso.";
					request.setAttribute("msg", mensagem);
					objetoSessao.removeAttribute("fornecedor");
					RequestDispatcher disp = request.getRequestDispatcher("fornecedor.jsp");
					disp.forward(request, response);
				}catch (Exception e) {
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
	
	public Fornecedor preencheObjeto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNomeFornecedor((String)request.getParameter("nomeFornecedor"));
		fornecedor.setNomeVendedor((String) request.getParameter("nomeVendedor"));
		fornecedor.setEmailVendedor((String) request.getParameter("emailVendedor"));
		fornecedor.setSiteFornecedor((String) request.getParameter("siteFornecedor"));
		fornecedor.setCnpjFornecedor((String) request.getParameter("cnpjFornecedor"));
		fornecedor.setLogradouroFornecedor((String) request.getParameter("logradouroFornecedor"));
		fornecedor.setNumeroLogradouroFornecedor((String) request.getParameter("numeroLogradouroFornecedor"));
		fornecedor.setComplementoLogradouroFornecedor((String) request.getParameter("complementoLogradouroFornecedor"));
		fornecedor.setBairroFornecedor((String) request.getParameter("bairroFornecedor"));
		fornecedor.setCidadeFornecedor((String) request.getParameter("cidadeFornecedor"));
		fornecedor.setEstadoFornecedor((String) request.getParameter("estadoFornecedor"));
		fornecedor.setCepFornecedor((String) request.getParameter("cepFornecedor"));
		fornecedor.setDdd1Fornecedor((String) request.getParameter("ddd1Fornecedor"));
		fornecedor.setTelefone1Fornecedor((String) request.getParameter("telefone1Fornecedor"));
		fornecedor.setDdd2Fornecedor((String) request.getParameter("ddd2Fornecedor"));
		fornecedor.setTelefone2Fornecedor((String) request.getParameter("telefone2Fornecedor"));		
		return fornecedor;		
	}
	
	public boolean validaCampos(Fornecedor fornecedor){
		boolean result = false;
		if ((fornecedor.getNomeFornecedor() == null) || (fornecedor.getNomeFornecedor().equals("") || (fornecedor.getNomeFornecedor().length()<3))){
			mensagem = "Preencha o nome do fornecedor corretamente.";
		}else if ((fornecedor.getNomeVendedor() == null) || (fornecedor.getNomeVendedor().equals("") || (fornecedor.getNomeVendedor().length()<5))){
			mensagem = "Preencha o nome do vendedor corretamente.";
		}else if ((fornecedor.getEmailVendedor() == null) || (fornecedor.getEmailVendedor().equals("") || (fornecedor.getEmailVendedor().length()<5))){
			mensagem = "Preencha o email do vendedor corretamente.";
		}else if ((fornecedor.getCnpjFornecedor() == null) || (fornecedor.getCnpjFornecedor().equals("") || (fornecedor.getCnpjFornecedor().length()<18))){
			mensagem = "Preencha o CNPJ do fornecedor corretamente.";
		}else{
			result = true;
		}
		return result;
	}

}
