package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pagamento")
public class Pagamento {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer codigoPagamento;
	@Column(name="numeroParcela")
	private Integer numeroParcela;
	@Column(name="valorParcela")
	private Double valorParcela;
	@Column(name="statusPagamento")
	private String statusPagamento;

	public Integer getCodigoPagamento() {
		return codigoPagamento;
	}

	public void setCodigoPagamento(Integer codigoPagamento) {
		this.codigoPagamento = codigoPagamento;
	}

	public Integer getNumeroParcela() {
		return numeroParcela;
	}

	public void setNumeroParcela(Integer numeroParcela) {
		this.numeroParcela = numeroParcela;
	}

	public Double getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(Double valorParcela) {
		this.valorParcela = valorParcela;
	}

	public String getStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(String statusPagamento) {
		this.statusPagamento = statusPagamento;
	}
	
	public Pagamento() {
		// TODO Auto-generated constructor stub
	}

	public Pagamento(Integer codigoPagamento, Integer numeroParcela,
			Double valorParcela, String statusPagamento) {
		this.codigoPagamento = codigoPagamento;
		this.numeroParcela = numeroParcela;
		this.valorParcela = valorParcela;
		this.statusPagamento = statusPagamento;
	}
	
	
}
