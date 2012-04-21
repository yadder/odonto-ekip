package modelo;

public class Dentista extends Usuario {

	private Integer croDentista;

	public Integer getCroDentista() {
		return croDentista;
	}

	public void setCroDentista(Integer croDentista) {
		this.croDentista = croDentista;
	}
	
	public Dentista() {

	}

	public Dentista(Integer croDentista) {
		super();
		this.croDentista = croDentista;
	}

	
	
}
