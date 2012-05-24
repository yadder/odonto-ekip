package teste;

import java.util.List;

import modelo.Face;
import persistencia.DaoFace;
import persistencia.DaoFaceImp;

public class Teste {

	public static void main(String[] args) {

		DaoFace df = new DaoFaceImp();
		Face face = new Face();
		
		face.setNomeFace("frente");
		
		if(df.cadastrarFace(face)){
			System.out.println("Face cadastrada");
		}else{
			System.out.println("Cadastro da face falhou");
		}
		
		List<Face> faces = df.pesquisarTodosFace();
		if (faces != null){
			for(Face f : faces){
				System.out.println("---------- InsereFace: Codigo: "+ f.getCodigoFace() + " Nome: "+ f.getNomeFace());
			}	
		}else{
			System.out.println("Faces vieram NULL da consulta");
		}
		
			
			
	
		
	}

}
