package modelo;

public class Pagamento {

	private Integer codigoPagamento;
	private Integer numeroParcela;
	private Double valorParcela;
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
