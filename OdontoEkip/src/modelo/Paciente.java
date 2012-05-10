package modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="paciente")
@PrimaryKeyJoinColumn(name="codigoPaciente")
public class Paciente extends Usuario{

	@Column(name="responsavelPaciente", length=50)
	private String responsavelPaciente;
	@Column(name="statusPaciente", nullable=false)
	private String statusPaciente;
	@Column(name="logradouroPaciente", length=100)
	private String logradrouroPaciente;
	@Column(name="numeroPaciente",length=10)
	private Integer numeroPaciente;
	@Column(name="complementoPaciente",length=50)
	private String complementoPaciente;
	@Column(name="bairroPaciente",length=50)
	private String bairroPaciente;
	@Column(name="cidadePaciente",length=100)
	private String cidadePaciente;
	@Column(name="estadoPaciente",length=2)
	private String estadoPaciente;
	@Column(name="cepPaciente", length=9)
	private String cepPaciente;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codigoConvenio")
	private Convenio convenio;	
	
	@OneToMany(mappedBy="paciente", fetch=FetchType.EAGER)
	private List<TelefonePaciente> telefonePaciente;

	@OneToMany(mappedBy="paciente", fetch=FetchType.EAGER)
	private List<InqueritoOdontologico> inqueritoOdontologico;
	
	
	public List<InqueritoOdontologico> getInqueritoOdontologico() {
		return inqueritoOdontologico;
	}

	public void setInqueritoOdontologico(
			List<InqueritoOdontologico> inqueritoOdontologico) {
		this.inqueritoOdontologico = inqueritoOdontologico;
	}

	public Convenio getConvenio() {
		return convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}

	public List<TelefonePaciente> getTelefonePaciente() {
		return telefonePaciente;
	}

	public void setTelefonePaciente(List<TelefonePaciente> telefonePaciente) {
		this.telefonePaciente = telefonePaciente;
	}

	public String getResponsavelPaciente() {
		return responsavelPaciente;
	}

	public void setResponsavelPaciente(String responsavelPaciente) {
		this.responsavelPaciente = responsavelPaciente;
	}

	public String getStatusPaciente() {
		return statusPaciente;
	}

	public void setStatusPaciente(String statusPaciente) {
		this.statusPaciente = statusPaciente;
	}

	public String getLogradrouroPaciente() {
		return logradrouroPaciente;
	}

	public void setLogradrouroPaciente(String logradrouroPaciente) {
		this.logradrouroPaciente = logradrouroPaciente;
	}

	public Integer getNumeroPaciente() {
		return numeroPaciente;
	}

	public void setNumeroPaciente(Integer numeroPaciente) {
		this.numeroPaciente = numeroPaciente;
	}

	public String getComplementoPaciente() {
		return complementoPaciente;
	}

	public void setComplementoPaciente(String complementoPaciente) {
		this.complementoPaciente = complementoPaciente;
	}

	public String getBairroPaciente() {
		return bairroPaciente;
	}

	public void setBairroPaciente(String bairroPaciente) {
		this.bairroPaciente = bairroPaciente;
	}

	public String getCidadePaciente() {
		return cidadePaciente;
	}

	public void setCidadePaciente(String cidadePaciente) {
		this.cidadePaciente = cidadePaciente;
	}

	public String getEstadoPaciente() {
		return estadoPaciente;
	}

	public void setEstadoPaciente(String estadoPaciente) {
		this.estadoPaciente = estadoPaciente;
	}

	public String getCepPaciente() {
		return cepPaciente;
	}

	public void setCepPaciente(String cepPaciente) {
		this.cepPaciente = cepPaciente;
	}
	
	public Paciente() {
	
	}

	
	
}
