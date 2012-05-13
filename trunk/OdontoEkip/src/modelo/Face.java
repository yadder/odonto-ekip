package modelo;

public class Face {

	private Integer codigoFace;
	private String nomeFace;

	public Integer getCodigoFace() {
		return codigoFace;
	}

	public void setCodigoFace(Integer codigoFace) {
		this.codigoFace = codigoFace;
	}

	public String getNomeFace() {
		return nomeFace;
	}

	public void setNomeFace(String nomeFace) {
		this.nomeFace = nomeFace;
	}
	
	public Face() {
		
	}

	public Face(Integer codigoFace, String nomeFace) {
		this.codigoFace = codigoFace;
		this.nomeFace = nomeFace;
	}
	
	

	
}
