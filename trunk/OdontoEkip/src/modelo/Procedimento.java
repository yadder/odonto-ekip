package modelo;

public class Procedimento {

	private Integer idProcedimento;
	private String codigoProcedimento;	
	private String descricaoProcedimento;
	private Double valorProcedimento;

	public Integer getIdProcedimento() {
		return idProcedimento;
	}	

	public String getCodigoProcedimento() {
		return codigoProcedimento;
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

	public Procedimento(String codigoProcedimento,
			String descricaoProcedimento, Double valorProcedimento) {
		this.setCodigoProcedimento(codigoProcedimento);
		this.descricaoProcedimento = descricaoProcedimento;
		this.valorProcedimento = valorProcedimento;
	}

	public void setCodigoProcedimento(String codigoProcedimento) {
		this.codigoProcedimento = codigoProcedimento;
	}
	
	
}
