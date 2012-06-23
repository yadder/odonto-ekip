package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_face")
public class Face implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_face")
	private long idFace;
	
	@Column(name="nome_face", nullable=false, unique=true, length=30)
	private String nomeFace;
	
	public Face() {
	}
	
	public Face(int codigo, String nome){
		this.idFace = codigo;
		this.nomeFace = nome;
	}
	
	public Face(String nome){
		this.nomeFace = nome;
	}

	public long getIdFace() {
		return idFace;
	}

	public void setIdFace(long idFace) {
		this.idFace = idFace;
	}

	public String getNomeFace() {
		return nomeFace;
	}

	public void setNomeFace(String nomeFace) {
		this.nomeFace = nomeFace;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "ID: "+ idFace + " Nome: " +nomeFace;
	}
}
