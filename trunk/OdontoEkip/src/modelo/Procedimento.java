package modelo;

public class Procedimento {

	private Integer codigoProcedimento;
	
	private String descricaoProcedimento;
	
	private Double valorProcedimento;

	public Integer getCodigoProcedimento() {
		return codigoProcedimento;
	}

	public void setCodigoProcedimento(Integer codigoProcedimento) {
		this.codigoProcedimento = codigoProcedimento;
	}

	public String getDescricaoProcedimento() {
		return descricaoProcedimento;
	}

	public void setDescricaoProcedimento(String descricaoProcedimento) {
		this.descricaoProcedimento = descricaoProcedimento;
	}

	public Double getValorProcedimento() {
		return valorProcedimento;
	}

	public void setValorProcedimento(Double valorProcedimento) {
		this.valorProcedimento = valorProcedimento;
	}
	
	public Procedimento() {
		// TODO Auto-generated constructor stub
	}

	public Procedimento(Integer codigoProcedimento,
			String descricaoProcedimento, Double valorProcedimento) {
		this.codigoProcedimento = codigoProcedimento;
		this.descricaoProcedimento = descricaoProcedimento;
		this.valorProcedimento = valorProcedimento;
	}
	
	
}
