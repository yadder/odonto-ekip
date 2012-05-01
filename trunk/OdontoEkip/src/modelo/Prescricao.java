package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Prescricao")

public class Prescricao {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer codigoPrescricao;
	@Column
	private String  observacao;
	
	@ManyToOne	
    @JoinColumn(name="codigoDentista")
	private Dentista dentista;

	public Dentista getDentista() {
		return dentista;
	}

	public void setDentista(Dentista dentista) {
		this.dentista = dentista;
	}

	public Integer getCodigoPrescricao() {
		return codigoPrescricao;
	}

	public void setCodigoPrescricao(Integer codigoPrescricao) {
		this.codigoPrescricao = codigoPrescricao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public Prescricao() {
		// TODO Auto-generated constructor stub
	}

	public Prescricao(Integer codigoPrescricao, String observacao,
			Dentista dentista) {
		super();
		this.codigoPrescricao = codigoPrescricao;
		this.observacao = observacao;
		this.dentista = dentista;
	}

	
	
}
