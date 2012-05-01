package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="face")
public class Face {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer codigoFace;
	@Column(name="nomeFace", length=50)
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
