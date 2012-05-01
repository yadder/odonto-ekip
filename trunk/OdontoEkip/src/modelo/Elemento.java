package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="elemento")
public class Elemento {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer codigoElemento;
	@Column(name="nomeElemento", length=2)
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
