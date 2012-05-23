package teste;

import java.util.List;

import modelo.Face;
import persistencia.DaoFace;
import persistencia.DaoFaceImp;

public class Teste {

	public static void main(String[] args) {

		DaoFace df = new DaoFaceImp();
		Face face = new Face();
		
		face.setNomeFace("verso");
		
		if(df.insereFace(face)){
			System.out.println("Face cadastrada");
		}else{
			System.out.println("Cadastro da face falhou");
		}
		
		List<Face> faces = df.procurarTodosFace();
		if (faces != null){
			for(Face f : faces){
				System.out.println("---------- InsereFace: Codigo: "+ face.getCodigoFace() + " Nome: "+ face.getNomeFace());
			}	
		}else{
			System.out.println("Faces vieram NULL da consulta");
		}
		
			
			
	
		
	}

}
