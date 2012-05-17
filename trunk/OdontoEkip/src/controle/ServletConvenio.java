package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo_hibernate.Convenio;
import persistencia.DaoConvenio;

public class ServletConvenio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletConvenio() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String botao = request.getParameter("botao");
		String nomeConvenio = (String)request.getParameter("nomeConvenio");
		
		if (botao.toString().equals("Sair")){
			response.sendRedirect("principal.jsp");
		}
		else{
			if (nomeConvenio.equals("") || (nomeConvenio == null)){
				request.setAttribute("msg","Preencha o nome do convênio!");
				request.getRequestDispatcher("cadastroConvenio.jsp").forward(request,response);
			}
			else{
				if (botao.toString().equals("Gravar")){		
					try{
						Convenio c = new Convenio(
							null,
							(String)request.getParameter("nomeConvenio")
						);
						DaoConvenio daoConvenio = new DaoConvenio();
						try {
							daoConvenio.gravar(c);
							request.setAttribute("msg","Convênio cadastrado com sucesso!");
							request.getRequestDispatcher("cadastroConvenio.jsp").forward(request,response);
						} catch (Exception e) {
							request.setAttribute("msg","Erro ao cadastrar! "+ e.getMessage());
							request.getRequestDispatcher("cadastroConvenio.jsp").forward(request,response);
						}
					}catch(Exception e){
						request.setAttribute("msg","Erro ao cadastrar! "+ e.getMessage());
						request.getRequestDispatcher("cadastroConvenio.jsp").forward(request,response);
					}
				}
				
				if (botao.toString().equals("Cancelar")){
					response.sendRedirect("cadastroConvenio.jsp");
				}
				
				if (botao.toString().equals("Excluir")){
					Convenio c = new Convenio();
					c.setCodigoConvenio(1);
					c.setNomeConvenio("itau");
					try{
						DaoConvenio daoConvenio = new DaoConvenio();
						daoConvenio.excluir(c);
						request.setAttribute("msg","Convênio excluído com sucesso!");
						request.getRequestDispatcher("cadastroConvenio.jsp").forward(request,response);
					}catch(Exception e){
						request.setAttribute("msg","Erro ao excluir! "+ e.getMessage());
						request.getRequestDispatcher("cadastroConvenio.jsp").forward(request,response);
					}
				}
				
				if (botao.toString().equals("Pesquisar")){
					Convenio c = new Convenio();
					c.setNomeConvenio(nomeConvenio);
					try{
						DaoConvenio daof = new DaoConvenio();
						c = daof.consultar(c);
						if (c != null){							
							request.setAttribute("codigoConvenio", (String.valueOf(c.getCodigoConvenio())));
							request.setAttribute("nomeConvenio", c.getNomeConvenio());
							
							request.setAttribute("msg","Encontrei:"+c.getCodigoConvenio()+" "+c.getNomeConvenio());
							request.getRequestDispatcher("cadastroConvenio.jsp").forward(request,response);
						}
						else{
							request.setAttribute("msg","Convênio não encontrado!");
							request.getRequestDispatcher("cadastroConvenio.jsp").forward(request,response);
							c = new Convenio();  // pois no IF perdeu a referencia do objeto Convenio
						}
					}
					catch (Exception ex){
						ex.printStackTrace();
					}
				}
				
			}
		}
		
	}

}
