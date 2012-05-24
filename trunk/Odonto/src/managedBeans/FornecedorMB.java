package managedBeans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;

import modelo.Fornecedor;
import persistencia.DaoFornecedor;
import persistencia.DaoFornecedorImp;

public class FornecedorMB {

	private DaoFornecedor dao = new DaoFornecedorImp();
	private Fornecedor fornecedor;
	private ListDataModel fornecedores; 
	
	public FornecedorMB(){
		fornecedor = new Fornecedor();
		fornecedores = resgatarFornecedores();
	}
	
	private ListDataModel resgatarFornecedores(){
		return new ListDataModel(dao.pesquisarTodosFornecedor());
	}
	
	public Integer getSizeFornecedors(){
		return this.fornecedores.getRowCount();
	}
	
	public ListDataModel getFornecedors(){
		return this.fornecedores;
	}
	
	public String adicionarFornecedor(){
		this.limparFornecedor();
		return null;
	}
	
	public String alterarFornecedor(){
		return null;
	}
	
	public String salvarFornecedor(){
		if(fornecedor.getCodigoFornecedor() == 0){
			dao.cadastrarFornecedor(fornecedor);
		}else{
			dao.alterarFornecedor(fornecedor);
		}
		fornecedores = resgatarFornecedores();
		this.mostraMensagem(fornecedor.getNomeFornecedor() + " foi salvo!");
		fornecedor = new Fornecedor();
		return null;
	}
	
	public String excluirFornecedor(){
		this.mostraMensagem(fornecedor.getNomeFornecedor() + " foi excluído!");
		dao.excluirFornecedor(fornecedor);
		fornecedor = new Fornecedor();
		fornecedores = resgatarFornecedores();
		return null;
	}
	
	public String cancelarCadastroFornecedor(){
		return null;
	}
	
	private void limparFornecedor(){
		fornecedor = new Fornecedor();
	}
	
	public void mostraMensagem(String mensagem){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(mensagem));
	}
	
	public Fornecedor getFornecedor(){
		return fornecedor;
	}
	
	public void setFornecedor(Fornecedor fornecedor){
		this.fornecedor = fornecedor;
	}	
}