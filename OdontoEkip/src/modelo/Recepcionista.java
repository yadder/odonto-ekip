package modelo;

import java.util.Date;

public class Recepcionista extends Usuario {

	private String rgRecepcionista;
	
	private String cpfRecepcionista;
	
	private Date dataNascimento;
	
	private String sexoRecepcionista;

	public String getRgRecepcionista() {
		return rgRecepcionista;
	}

	public void setRgRecepcionista(String rgRecepcionista) {
		this.rgRecepcionista = rgRecepcionista;
	}

	public String getCpfRecepcionista() {
		return cpfRecepcionista;
	}

	public void setCpfRecepcionista(String cpfRecepcionista) {
		this.cpfRecepcionista = cpfRecepcionista;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexoRecepcionista() {
		return sexoRecepcionista;
	}

	public void setSexoRecepcionista(String sexoRecepcionista) {
		this.sexoRecepcionista = sexoRecepcionista;
	}
	
	public Recepcionista() {
		// TODO Auto-generated constructor stub
	}

	public Recepcionista(String rgRecepcionista, String cpfRecepcionista,
			Date dataNascimento, String sexoRecepcionista) {
		this.rgRecepcionista = rgRecepcionista;
		this.cpfRecepcionista = cpfRecepcionista;
		this.dataNascimento = dataNascimento;
		this.sexoRecepcionista = sexoRecepcionista;
	}
	
	
}
