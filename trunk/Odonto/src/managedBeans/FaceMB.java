package managedBeans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;

import modelo.Face;
import persistencia.DaoFace;
import persistencia.DaoFaceImp;

public class FaceMB {

	private DaoFace dao = new DaoFaceImp();
	private Face face;
	private ListDataModel faces; 
	
	public FaceMB(){
		face = new Face();
		faces = resgatarFaces();
	}
	
	private ListDataModel resgatarFaces(){
		return new ListDataModel(dao.pesquisarTodosFace());
	}
	
	public Integer getSizeFaces(){
		return this.faces.getRowCount();
	}
	
	public ListDataModel getFaces(){
		return this.faces;
	}
	
	public String adicionarFace(){
		this.limparFace();
		return null;
	}
	
	public String alterarFace(){
		return null;
	}
	
	public String salvarFace(){
		if ((face.getNomeFace().equals(""))||(face.getNomeFace()==null)||(face.getNomeFace().length()<3)){
			this.mostraMensagem("Erro: Nome de face inválido");
			return null;
		}
		else if(face.getCodigoFace() == 0){
			dao.cadastrarFace(face);
		}else{
			dao.alterarFace(face);
		}
		faces = resgatarFaces();
		this.mostraMensagem(face.getNomeFace() + " foi salvo!");
		face = new Face();
		return null;
	}
	
	public String excluirFace(){
		this.mostraMensagem(face.getNomeFace() + " foi excluído!");
		dao.excluirFace(face);
		face = new Face();
		faces = resgatarFaces();
		return null;
	}
	
	public String cancelarCadastroFace(){
		return null;
	}
	
	private void limparFace(){
		face = new Face();
	}
	
	public void mostraMensagem(String mensagem){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(mensagem));
	}
	
	public Face getFace(){
		return face;
	}
	
	public void setFace(Face face){
		this.face = face;
	}	
}