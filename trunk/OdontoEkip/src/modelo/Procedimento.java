package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="procedimento")
public class Procedimento {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private Integer idProcedimento;
	@Column(name="codigoProcedimento",length=50)
	private String codigoProcedimento;	
	@Column(name="descricaoProcdimento", length=50)	
	private String descricaoProcedimento;
	@Column(name="valorProcedimento")
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
