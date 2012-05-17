package modelo_hibernate;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Windows
 */
@Entity
@Table(name = "tb_inquerito_odontologico", catalog = "odonto", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InqueritoOdontologico.findAll", query = "SELECT i FROM InqueritoOdontologico i"),
    @NamedQuery(name = "InqueritoOdontologico.findByCodigoInqueritoOdontologico", query = "SELECT i FROM InqueritoOdontologico i WHERE i.codigoInqueritoOdontologico = :codigoInqueritoOdontologico"),
    @NamedQuery(name = "InqueritoOdontologico.findByTratamentoMedico", query = "SELECT i FROM InqueritoOdontologico i WHERE i.tratamentoMedico = :tratamentoMedico"),
    @NamedQuery(name = "InqueritoOdontologico.findByUsandoMedicacao", query = "SELECT i FROM InqueritoOdontologico i WHERE i.usandoMedicacao = :usandoMedicacao"),
    @NamedQuery(name = "InqueritoOdontologico.findByAlergia", query = "SELECT i FROM InqueritoOdontologico i WHERE i.alergia = :alergia"),
    @NamedQuery(name = "InqueritoOdontologico.findByAnemia", query = "SELECT i FROM InqueritoOdontologico i WHERE i.anemia = :anemia"),
    @NamedQuery(name = "InqueritoOdontologico.findByFumante", query = "SELECT i FROM InqueritoOdontologico i WHERE i.fumante = :fumante"),
    @NamedQuery(name = "InqueritoOdontologico.findByHepatite", query = "SELECT i FROM InqueritoOdontologico i WHERE i.hepatite = :hepatite"),
    @NamedQuery(name = "InqueritoOdontologico.findByAlcoolista", query = "SELECT i FROM InqueritoOdontologico i WHERE i.alcoolista = :alcoolista"),
    @NamedQuery(name = "InqueritoOdontologico.findBySifilis", query = "SELECT i FROM InqueritoOdontologico i WHERE i.sifilis = :sifilis"),
    @NamedQuery(name = "InqueritoOdontologico.findByHerpesAfta", query = "SELECT i FROM InqueritoOdontologico i WHERE i.herpesAfta = :herpesAfta"),
    @NamedQuery(name = "InqueritoOdontologico.findByHiv", query = "SELECT i FROM InqueritoOdontologico i WHERE i.hiv = :hiv"),
    @NamedQuery(name = "InqueritoOdontologico.findByGravidez", query = "SELECT i FROM InqueritoOdontologico i WHERE i.gravidez = :gravidez"),
    @NamedQuery(name = "InqueritoOdontologico.findByTuberculose", query = "SELECT i FROM InqueritoOdontologico i WHERE i.tuberculose = :tuberculose"),
    @NamedQuery(name = "InqueritoOdontologico.findByDiabetes", query = "SELECT i FROM InqueritoOdontologico i WHERE i.diabetes = :diabetes"),
    @NamedQuery(name = "InqueritoOdontologico.findByAsma", query = "SELECT i FROM InqueritoOdontologico i WHERE i.asma = :asma"),
    @NamedQuery(name = "InqueritoOdontologico.findByCardiaco", query = "SELECT i FROM InqueritoOdontologico i WHERE i.cardiaco = :cardiaco"),
    @NamedQuery(name = "InqueritoOdontologico.findByDataUltimoAtendimento", query = "SELECT i FROM InqueritoOdontologico i WHERE i.dataUltimoAtendimento = :dataUltimoAtendimento"),
    @NamedQuery(name = "InqueritoOdontologico.findByConcluiuTratamento", query = "SELECT i FROM InqueritoOdontologico i WHERE i.concluiuTratamento = :concluiuTratamento"),
    @NamedQuery(name = "InqueritoOdontologico.findByExperienciaNegativaTratamento", query = "SELECT i FROM InqueritoOdontologico i WHERE i.experienciaNegativaTratamento = :experienciaNegativaTratamento"),
    @NamedQuery(name = "InqueritoOdontologico.findByRoerUnhas", query = "SELECT i FROM InqueritoOdontologico i WHERE i.roerUnhas = :roerUnhas"),
    @NamedQuery(name = "InqueritoOdontologico.findByRespirarPelaBoca", query = "SELECT i FROM InqueritoOdontologico i WHERE i.respirarPelaBoca = :respirarPelaBoca"),
    @NamedQuery(name = "InqueritoOdontologico.findByMorderObjetos", query = "SELECT i FROM InqueritoOdontologico i WHERE i.morderObjetos = :morderObjetos"),
    @NamedQuery(name = "InqueritoOdontologico.findByRangerOsDentes", query = "SELECT i FROM InqueritoOdontologico i WHERE i.rangerOsDentes = :rangerOsDentes"),
    @NamedQuery(name = "InqueritoOdontologico.findByChuparDedoChupeta", query = "SELECT i FROM InqueritoOdontologico i WHERE i.chuparDedoChupeta = :chuparDedoChupeta"),
    @NamedQuery(name = "InqueritoOdontologico.findByOutros", query = "SELECT i FROM InqueritoOdontologico i WHERE i.outros = :outros"),
    @NamedQuery(name = "InqueritoOdontologico.findByFioFitaDental", query = "SELECT i FROM InqueritoOdontologico i WHERE i.fioFitaDental = :fioFitaDental"),
    @NamedQuery(name = "InqueritoOdontologico.findByPalito", query = "SELECT i FROM InqueritoOdontologico i WHERE i.palito = :palito"),
    @NamedQuery(name = "InqueritoOdontologico.findByUnitufoBitufo", query = "SELECT i FROM InqueritoOdontologico i WHERE i.unitufoBitufo = :unitufoBitufo"),
    @NamedQuery(name = "InqueritoOdontologico.findByTipoEscova", query = "SELECT i FROM InqueritoOdontologico i WHERE i.tipoEscova = :tipoEscova"),
    @NamedQuery(name = "InqueritoOdontologico.findByInterdental", query = "SELECT i FROM InqueritoOdontologico i WHERE i.interdental = :interdental"),
    @NamedQuery(name = "InqueritoOdontologico.findByCremeDental", query = "SELECT i FROM InqueritoOdontologico i WHERE i.cremeDental = :cremeDental"),
    @NamedQuery(name = "InqueritoOdontologico.findByIngereAlimentosEntreRefeicoes", query = "SELECT i FROM InqueritoOdontologico i WHERE i.ingereAlimentosEntreRefeicoes = :ingereAlimentosEntreRefeicoes")})
public class InqueritoOdontologico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_inquerito_odontologico", nullable = false)
    private Integer codigoInqueritoOdontologico;
    @Basic(optional = false)
    @Column(name = "tratamento_medico", nullable = false, length = 1)
    private String tratamentoMedico;
    @Basic(optional = false)
    @Column(name = "usando_medicacao", nullable = false, length = 1)
    private String usandoMedicacao;
    @Basic(optional = false)
    @Column(name = "alergia", nullable = false, length = 1)
    private String alergia;
    @Basic(optional = false)
    @Column(name = "anemia", nullable = false, length = 1)
    private String anemia;
    @Basic(optional = false)
    @Column(name = "fumante", nullable = false, length = 1)
    private String fumante;
    @Basic(optional = false)
    @Column(name = "hepatite", nullable = false, length = 1)
    private String hepatite;
    @Basic(optional = false)
    @Column(name = "alcoolista", nullable = false, length = 1)
    private String alcoolista;
    @Basic(optional = false)
    @Column(name = "sifilis", nullable = false, length = 1)
    private String sifilis;
    @Basic(optional = false)
    @Column(name = "herpes_afta", nullable = false, length = 1)
    private String herpesAfta;
    @Basic(optional = false)
    @Column(name = "hiv", nullable = false, length = 1)
    private String hiv;
    @Basic(optional = false)
    @Column(name = "gravidez", nullable = false, length = 1)
    private String gravidez;
    @Basic(optional = false)
    @Column(name = "tuberculose", nullable = false, length = 1)
    private String tuberculose;
    @Basic(optional = false)
    @Column(name = "diabetes", nullable = false, length = 1)
    private String diabetes;
    @Basic(optional = false)
    @Column(name = "asma", nullable = false, length = 1)
    private String asma;
    @Basic(optional = false)
    @Column(name = "cardiaco", nullable = false, length = 1)
    private String cardiaco;
    @Basic(optional = false)
    @Column(name = "data_ultimo_atendimento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataUltimoAtendimento;
    @Basic(optional = false)
    @Column(name = "concluiu_tratamento", nullable = false, length = 1)
    private String concluiuTratamento;
    @Basic(optional = false)
    @Column(name = "experiencia_negativa_tratamento", nullable = false, length = 1)
    private String experienciaNegativaTratamento;
    @Basic(optional = false)
    @Column(name = "roer_unhas", nullable = false, length = 1)
    private String roerUnhas;
    @Basic(optional = false)
    @Column(name = "respirar_pela_boca", nullable = false, length = 1)
    private String respirarPelaBoca;
    @Basic(optional = false)
    @Column(name = "morder_objetos", nullable = false, length = 1)
    private String morderObjetos;
    @Basic(optional = false)
    @Column(name = "ranger_os_dentes", nullable = false, length = 1)
    private String rangerOsDentes;
    @Basic(optional = false)
    @Column(name = "chupar_dedo_chupeta", nullable = false, length = 1)
    private String chuparDedoChupeta;
    @Column(name = "outros", length = 255)
    private String outros;
    @Basic(optional = false)
    @Column(name = "fio_fita_dental", nullable = false, length = 1)
    private String fioFitaDental;
    @Basic(optional = false)
    @Column(name = "palito", nullable = false, length = 1)
    private String palito;
    @Basic(optional = false)
    @Column(name = "unitufo_bitufo", nullable = false, length = 7)
    private String unitufoBitufo;
    @Basic(optional = false)
    @Column(name = "tipo_escova", nullable = false, length = 5)
    private String tipoEscova;
    @Basic(optional = false)
    @Column(name = "interdental", nullable = false, length = 1)
    private String interdental;
    @Basic(optional = false)
    @Column(name = "creme_dental", nullable = false, length = 1)
    private String cremeDental;
    @Basic(optional = false)
    @Column(name = "ingere_alimentos_entre_refeicoes", nullable = false, length = 1)
    private String ingereAlimentosEntreRefeicoes;
    @JoinColumn(name = "codigo_paciente", referencedColumnName = "codigo_paciente", nullable = false)
    @ManyToOne(optional = false)
    private Paciente codigoPaciente;

    public InqueritoOdontologico() {
    }

    public InqueritoOdontologico(Integer codigoInqueritoOdontologico) {
        this.codigoInqueritoOdontologico = codigoInqueritoOdontologico;
    }

    public InqueritoOdontologico(Integer codigoInqueritoOdontologico, String tratamentoMedico, String usandoMedicacao, String alergia, String anemia, String fumante, String hepatite, String alcoolista, String sifilis, String herpesAfta, String hiv, String gravidez, String tuberculose, String diabetes, String asma, String cardiaco, Date dataUltimoAtendimento, String concluiuTratamento, String experienciaNegativaTratamento, String roerUnhas, String respirarPelaBoca, String morderObjetos, String rangerOsDentes, String chuparDedoChupeta, String fioFitaDental, String palito, String unitufoBitufo, String tipoEscova, String interdental, String cremeDental, String ingereAlimentosEntreRefeicoes) {
        this.codigoInqueritoOdontologico = codigoInqueritoOdontologico;
        this.tratamentoMedico = tratamentoMedico;
        this.usandoMedicacao = usandoMedicacao;
        this.alergia = alergia;
        this.anemia = anemia;
        this.fumante = fumante;
        this.hepatite = hepatite;
        this.alcoolista = alcoolista;
        this.sifilis = sifilis;
        this.herpesAfta = herpesAfta;
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
        this.chuparDedoChupeta = chuparDedoChupeta;
        this.fioFitaDental = fioFitaDental;
        this.palito = palito;
        this.unitufoBitufo = unitufoBitufo;
        this.tipoEscova = tipoEscova;
        this.interdental = interdental;
        this.cremeDental = cremeDental;
        this.ingereAlimentosEntreRefeicoes = ingereAlimentosEntreRefeicoes;
    }

    public Integer getCodigoInqueritoOdontologico() {
        return codigoInqueritoOdontologico;
    }

    public void setCodigoInqueritoOdontologico(Integer codigoInqueritoOdontologico) {
        this.codigoInqueritoOdontologico = codigoInqueritoOdontologico;
    }

    public String getTratamentoMedico() {
        return tratamentoMedico;
    }

    public void setTratamentoMedico(String tratamentoMedico) {
        this.tratamentoMedico = tratamentoMedico;
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

    public String getHerpesAfta() {
        return herpesAfta;
    }

    public void setHerpesAfta(String herpesAfta) {
        this.herpesAfta = herpesAfta;
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

    public void setExperienciaNegativaTratamento(String experienciaNegativaTratamento) {
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

    public String getChuparDedoChupeta() {
        return chuparDedoChupeta;
    }

    public void setChuparDedoChupeta(String chuparDedoChupeta) {
        this.chuparDedoChupeta = chuparDedoChupeta;
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

    public String getTipoEscova() {
        return tipoEscova;
    }

    public void setTipoEscova(String tipoEscova) {
        this.tipoEscova = tipoEscova;
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

    public void setIngereAlimentosEntreRefeicoes(String ingereAlimentosEntreRefeicoes) {
        this.ingereAlimentosEntreRefeicoes = ingereAlimentosEntreRefeicoes;
    }

    public Paciente getCodigoPaciente() {
        return codigoPaciente;
    }

    public void setCodigoPaciente(Paciente codigoPaciente) {
        this.codigoPaciente = codigoPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoInqueritoOdontologico != null ? codigoInqueritoOdontologico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InqueritoOdontologico)) {
            return false;
        }
        InqueritoOdontologico other = (InqueritoOdontologico) object;
        if ((this.codigoInqueritoOdontologico == null && other.codigoInqueritoOdontologico != null) || (this.codigoInqueritoOdontologico != null && !this.codigoInqueritoOdontologico.equals(other.codigoInqueritoOdontologico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "odonto.InqueritoOdontologico[ codigoInqueritoOdontologico=" + codigoInqueritoOdontologico + " ]";
    }
    
}
