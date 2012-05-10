package modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="inqueritoOdontologico")
public class InqueritoOdontologico {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer codigoInqueritoOdontologico;
	@Column(name="tratamentoOdontologico", columnDefinition="enum ('s','n')",nullable=false)
	private String tratamentoOdontologico;
	@Column(name="usandoMedicacao", columnDefinition="enum ('s','n')",nullable=false)
	private String usandoMedicacao;
	@Column(name="alergia", columnDefinition="enum ('s','n')",nullable=false)
	private String alergia;
	@Column(name="anemia", columnDefinition="enum ('s','n')",nullable=false)
	private String anemia;
	@Column(name="fumante", columnDefinition="enum ('s','n')",nullable=false)
	private String fumante;
	@Column(name="hepatite", columnDefinition="enum ('s','n')",nullable=false)
	private String hepatite;
	@Column(name="alcoolista", columnDefinition="enum ('s','n')",nullable=false)
	private String alcoolista;
	@Column(name="sifilis", columnDefinition="enum ('s','n')",nullable=false)
	private String sifilis;
	@Column(name="herpesAfitas", columnDefinition="enum ('s','n')",nullable=false)
	private String herpesAfitas;
	@Column(name="hiv", columnDefinition="enum ('s','n')",nullable=false)
	private String hiv;
	@Column(name="gravidez", columnDefinition="enum ('s','n')",nullable=false)
	private String gravidez;
	@Column(name="tuberculose", columnDefinition="enum ('s','n')",nullable=false)
	private String tuberculose;
	@Column(name="diabetes", columnDefinition="enum ('s','n')",nullable=false)
	private String diabetes;
	@Column(name="asma", columnDefinition="enum ('s','n')",nullable=false)
	private String asma;
	@Column(name="cardiaco", columnDefinition="enum ('s','n')",nullable=false)
	private String cardiaco;
	@Column(name="dataUltimoAtendimento")
	@Temporal(TemporalType.DATE)
	private Date dataUltimoAtendimento;
	@Column(name="concluiuTratamento", columnDefinition="enum ('s','n')",nullable=false)
	private String concluiuTratamento;
	@Column(name="experienciaNegativaTratamento", length=100)
	private String experienciaNegativaTratamento;
	@Column(name="roerUnhas", columnDefinition="enum ('s','n')",nullable=false)
	private String roerUnhas;
	@Column(name="respiraPelaBoca", columnDefinition="enum ('s','n')",nullable=false)
	private String respirarPelaBoca;
	@Column(name="morderObjetos", columnDefinition="enum ('s','n')",nullable=false)
	private String morderObjetos;
	@Column(name="rangerOsDentes", columnDefinition="enum ('s','n')",nullable=false)
	private String rangerOsDentes;
	@Column(name="chuparDedoOuChupeta", columnDefinition="enum ('s','n')",nullable=false)
	private String chuparDedoOuChupeta;
	@Column(name="outros", length=100)
	private String outros;
	@Column(name="fioFitaDental", columnDefinition="enum ('s','n')",nullable=false)
	private String fioFitaDental;
	@Column(name="palito", columnDefinition="enum ('s','n')",nullable=false)
	private String palito;
	@Column(name="unitufoBitufo", columnDefinition="enum ('s','n')",nullable=false)
	private String unitufoBitufo;
	@Column(name="escovaMaciaMediaDura", columnDefinition="enum ('macia','media','dura')",nullable=false)
	private String escovaMaciaMediaDura;
	@Column(name="interdental", columnDefinition="enum ('s','n')",nullable=false)
	private String interdental;
	@Column(name="cremeDental", columnDefinition="enum ('s','n')",nullable=false)
	private String cremeDental;
	@Column(name="ingereAlimentosEntreRefeicoes", columnDefinition="enum ('s','n')",nullable=false)
	private String ingereAlimentosEntreRefeicoes;
	
	@ManyToOne	
    @JoinColumn(name="codigoPaciente")
	private Paciente paciente;
	
	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Integer getCodigoInqueritoOdontologico() {
		return codigoInqueritoOdontologico;
	}

	public void setCodigoInqueritoOdontologico(Integer codigoInqueritoOdontologico) {
		this.codigoInqueritoOdontologico = codigoInqueritoOdontologico;
	}

	public String getTratamentoOdontologico() {
		return tratamentoOdontologico;
	}

	public void setTratamentoOdontologico(String tratamentoOdontologico) {
		this.tratamentoOdontologico = tratamentoOdontologico;
	}

	public String getUsandoMedicacao() {
		return usandoMedicacao;
	}

	public void setUsandoMedicacao(String usandoMedicacao) {
		this.usandoMedicacao = usandoMedicacao;
	}

	public String getAlergia() {
		return alergia;
	}

	public void setAlergia(String alergia) {
		this.alergia = alergia;
	}

	public String getAnemia() {
		return anemia;
	}

	public void setAnemia(String anemia) {
		this.anemia = anemia;
	}

	public String getFumante() {
		return fumante;
	}

	public void setFumante(String fumante) {
		this.fumante = fumante;
	}

	public String getHepatite() {
		return hepatite;
	}

	public void setHepatite(String hepatite) {
		this.hepatite = hepatite;
	}

	public String getAlcoolista() {
		return alcoolista;
	}

	public void setAlcoolista(String alcoolista) {
		this.alcoolista = alcoolista;
	}

	public String getSifilis() {
		return sifilis;
	}

	public void setSifilis(String sifilis) {
		this.sifilis = sifilis;
	}

	public String getHerpesAfitas() {
		return herpesAfitas;
	}

	public void setHerpesAfitas(String herpesAfitas) {
		this.herpesAfitas = herpesAfitas;
	}

	public String getHiv() {
		return hiv;
	}

	public void setHiv(String hiv) {
		this.hiv = hiv;
	}

	public String getGravidez() {
		return gravidez;
	}

	public void setGravidez(String gravidez) {
		this.gravidez = gravidez;
	}

	public String getTuberculose() {
		return tuberculose;
	}

	public void setTuberculose(String tuberculose) {
		this.tuberculose = tuberculose;
	}

	public String getDiabetes() {
		return diabetes;
	}

	public void setDiabetes(String diabetes) {
		this.diabetes = diabetes;
	}

	public String getAsma() {
		return asma;
	}

	public void setAsma(String asma) {
		this.asma = asma;
	}

	public String getCardiaco() {
		return cardiaco;
	}

	public void setCardiaco(String cardiaco) {
		this.cardiaco = cardiaco;
	}

	public Date getDataUltimoAtendimento() {
		return dataUltimoAtendimento;
	}

	public void setDataUltimoAtendimento(Date dataUltimoAtendimento) {
		this.dataUltimoAtendimento = dataUltimoAtendimento;
	}

	public String getConcluiuTratamento() {
		return concluiuTratamento;
	}

	public void setConcluiuTratamento(String concluiuTratamento) {
		this.concluiuTratamento = concluiuTratamento;
	}

	public String getExperienciaNegativaTratamento() {
		return experienciaNegativaTratamento;
	}

	public void setExperienciaNegativaTratamento(
			String experienciaNegativaTratamento) {
		this.experienciaNegativaTratamento = experienciaNegativaTratamento;
	}

	public String getRoerUnhas() {
		return roerUnhas;
	}

	public void setRoerUnhas(String roerUnhas) {
		this.roerUnhas = roerUnhas;
	}

	public String getRespirarPelaBoca() {
		return respirarPelaBoca;
	}

	public void setRespirarPelaBoca(String respirarPelaBoca) {
		this.respirarPelaBoca = respirarPelaBoca;
	}

	public String getMorderObjetos() {
		return morderObjetos;
	}

	public void setMorderObjetos(String morderObjetos) {
		this.morderObjetos = morderObjetos;
	}

	public String getRangerOsDentes() {
		return rangerOsDentes;
	}

	public void setRangerOsDentes(String rangerOsDentes) {
		this.rangerOsDentes = rangerOsDentes;
	}

	public String getChuparDedoOuChupeta() {
		return chuparDedoOuChupeta;
	}

	public void setChuparDedoOuChupeta(String chuparDedoOuChupeta) {
		this.chuparDedoOuChupeta = chuparDedoOuChupeta;
	}

	public String getOutros() {
		return outros;
	}

	public void setOutros(String outros) {
		this.outros = outros;
	}

	public String getFioFitaDental() {
		return fioFitaDental;
	}

	public void setFioFitaDental(String fioFitaDental) {
		this.fioFitaDental = fioFitaDental;
	}

	public String getPalito() {
		return palito;
	}

	public void setPalito(String palito) {
		this.palito = palito;
	}

	public String getUnitufoBitufo() {
		return unitufoBitufo;
	}

	public void setUnitufoBitufo(String unitufoBitufo) {
		this.unitufoBitufo = unitufoBitufo;
	}

	public String getEscovaMaciaMediaDura() {
		return escovaMaciaMediaDura;
	}

	public void setEscovaMaciaMediaDura(String escovaMaciaMediaDura) {
		this.escovaMaciaMediaDura = escovaMaciaMediaDura;
	}

	public String getInterdental() {
		return interdental;
	}

	public void setInterdental(String interdental) {
		this.interdental = interdental;
	}

	public String getCremeDental() {
		return cremeDental;
	}

	public void setCremeDental(String cremeDental) {
		this.cremeDental = cremeDental;
	}

	public String getIngereAlimentosEntreRefeicoes() {
		return ingereAlimentosEntreRefeicoes;
	}

	public void setIngereAlimentosEntreRefeicoes(
			String ingereAlimentosEntreRefeicoes) {
		this.ingereAlimentosEntreRefeicoes = ingereAlimentosEntreRefeicoes;
	}
	
	public InqueritoOdontologico() {
		// TODO Auto-generated constructor stub
	}

	public InqueritoOdontologico(Integer codigoInqueritoOdontologico,
			String tratamentoOdontologico, String usandoMedicacao,
			String alergia, String anemia, String fumante, String hepatite,
			String alcoolista, String sifilis, String herpesAfitas, String hiv,
			String gravidez, String tuberculose, String diabetes, String asma,
			String cardiaco, Date dataUltimoAtendimento,
			String concluiuTratamento, String experienciaNegativaTratamento,
			String roerUnhas, String respirarPelaBoca, String morderObjetos,
			String rangerOsDentes, String chuparDedoOuChupeta, String outros,
			String fioFitaDental, String palito, String unitufoBitufo,
			String escovaMaciaMediaDura, String interdental,
			String cremeDental, String ingereAlimentosEntreRefeicoes,
			Paciente paciente) {
		super();
		this.codigoInqueritoOdontologico = codigoInqueritoOdontologico;
		this.tratamentoOdontologico = tratamentoOdontologico;
		this.usandoMedicacao = usandoMedicacao;
		this.alergia = alergia;
		this.anemia = anemia;
		this.fumante = fumante;
		this.hepatite = hepatite;
		this.alcoolista = alcoolista;
		this.sifilis = sifilis;
		this.herpesAfitas = herpesAfitas;
		this.hiv = hiv;
		this.gravidez = gravidez;
		this.tuberculose = tuberculose;
		this.diabetes = diabetes;
		this.asma = asma;
		this.cardiaco = cardiaco;
		this.dataUltimoAtendimento = dataUltimoAtendimento;
		this.concluiuTratamento = concluiuTratamento;
		this.experienciaNegativaTratamento = experienciaNegativaTratamento;
		this.roerUnhas = roerUnhas;
		this.respirarPelaBoca = respirarPelaBoca;
		this.morderObjetos = morderObjetos;
		this.rangerOsDentes = rangerOsDentes;
		this.chuparDedoOuChupeta = chuparDedoOuChupeta;
		this.outros = outros;
		this.fioFitaDental = fioFitaDental;
		this.palito = palito;
		this.unitufoBitufo = unitufoBitufo;
		this.escovaMaciaMediaDura = escovaMaciaMediaDura;
		this.interdental = interdental;
		this.cremeDental = cremeDental;
		this.ingereAlimentosEntreRefeicoes = ingereAlimentosEntreRefeicoes;
		this.paciente = paciente;
	}


	
}
