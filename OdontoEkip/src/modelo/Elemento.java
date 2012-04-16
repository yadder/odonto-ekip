package modelo;

public class Elemento {

	private Integer codigoElemento;
	
	private String nomeElemento;

	public Integer getCodigoElemento() {
		return codigoElemento;
	}

	public void setCodigoElemento(Integer codigoElemento) {
		this.codigoElemento = codigoElemento;
	}

	public String getNomeElemento() {
		return nomeElemento;
	}

	public void setNomeElemento(String nomeElemento) {
		this.nomeElemento = nomeElemento;
	}

	public Elemento(Integer codigoElemento, String nomeElemento) {
		this.codigoElemento = codigoElemento;
		this.nomeElemento = nomeElemento;
	}
	
	public Elemento() {
		
	}
	
}
