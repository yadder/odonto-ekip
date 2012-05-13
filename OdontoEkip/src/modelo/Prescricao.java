package modelo;

public class Prescricao {

	private Integer codigoPrescricao;
	private String  observacao;
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
