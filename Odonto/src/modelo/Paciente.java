package modelo;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name = "tb_paciente")
@PrimaryKeyJoinColumn(name="codigoUsuario")
public class Paciente extends Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "responsavel_paciente", length = 50)
    private String responsavelPaciente;
    @Column(name = "logradouro_paciente", length = 100)
    private String logradouroPaciente;
    @Column(name = "numero_logradouro_paciente")
    private Integer numeroLogradouroPaciente;
    @Column(name = "complemento_logradouro_paciente", length = 50)
    private String complementoLogradouroPaciente;
    @Column(name = "bairro_paciente", length = 30)
    private String bairroPaciente;
    @Column(name = "cidade_paciente", length = 30)
    private String cidadePaciente;
    @Column(name = "estado_paciente", length = 30)
    private String estadoPaciente;
    @Column(name = "cep_paciente", length = 10)
    private String cepPaciente;
    
    @ManyToOne(fetch=FetchType.EAGER)
	private Convenio convenio;
    
    public Paciente() {
    }
    
    public Convenio getConvenio() {
		return convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getResponsavelPaciente() {
        return responsavelPaciente;
    }

    public void setResponsavelPaciente(String responsavelPaciente) {
        this.responsavelPaciente = responsavelPaciente;
    }

    public String getLogradouroPaciente() {
        return logradouroPaciente;
    }

    public void setLogradouroPaciente(String logradouroPaciente) {
        this.logradouroPaciente = logradouroPaciente;
    }

    public Integer getNumeroLogradouroPaciente() {
        return numeroLogradouroPaciente;
    }

    public void setNumeroLogradouroPaciente(Integer numeroLogradouroPaciente) {
        this.numeroLogradouroPaciente = numeroLogradouroPaciente;
    }

    public String getComplementoLogradouroPaciente() {
        return complementoLogradouroPaciente;
    }

    public void setComplementoLogradouroPaciente(String complementoLogradouroPaciente) {
        this.complementoLogradouroPaciente = complementoLogradouroPaciente;
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
   
}
