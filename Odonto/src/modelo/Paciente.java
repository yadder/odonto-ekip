package modelo;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;


@Entity
@Table(name = "tb_paciente")
@PrimaryKeyJoinColumn(name="id_usuario")
public class Paciente extends Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "responsavel_paciente", length = 50)
    private String responsavelPaciente;
    @Column(name = "logradouro_paciente", length = 100)
    private String logradouroPaciente;
    @Column(name = "numero_logradouro_paciente")
    private String numeroLogradouroPaciente;
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
    @Column(name = "ddd1_paciente", length = 10)
    private String ddd1Paciente;
    @Column(name = "telefone1_paciente", length = 10)
    private String telefone1Paciente;
    @Column(name = "ddd2_paciente", length = 10)
    private String ddd2Paciente;
    @Column(name = "telefone2_paciente", length = 10)
    private String telefone2Paciente;
    
    @ManyToOne(fetch=FetchType.EAGER)
	private Convenio convenio;
    
    public Paciente() {
    }
    
    
    
    public Paciente(String nomeUsuario) {
		super(nomeUsuario);
	}



	public Paciente(String nomeUsuario, String senhaUsuario,
			String perfilUsuario, String rgUsuario, String cpfUsuario,
			String sexoUsuario, Date dataNascimentoUsuario,
			String responsavelPaciente, String logradouroPaciente,
			String numeroLogradouroPaciente,
			String complementoLogradouroPaciente, String bairroPaciente,
			String cidadePaciente, String estadoPaciente, String cepPaciente,
			String ddd1Paciente, String telefone1Paciente, String ddd2Paciente,
			String telefone2Paciente, Convenio convenio) {
		super(nomeUsuario, senhaUsuario, perfilUsuario, rgUsuario, cpfUsuario,
				sexoUsuario, dataNascimentoUsuario);
		this.responsavelPaciente = responsavelPaciente;
		this.logradouroPaciente = logradouroPaciente;
		this.numeroLogradouroPaciente = numeroLogradouroPaciente;
		this.complementoLogradouroPaciente = complementoLogradouroPaciente;
		this.bairroPaciente = bairroPaciente;
		this.cidadePaciente = cidadePaciente;
		this.estadoPaciente = estadoPaciente;
		this.cepPaciente = cepPaciente;
		this.ddd1Paciente = ddd1Paciente;
		this.telefone1Paciente = telefone1Paciente;
		this.ddd2Paciente = ddd2Paciente;
		this.telefone2Paciente = telefone2Paciente;
		this.convenio = convenio;
	}

	public String getDdd1Paciente() {
		return ddd1Paciente;
	}

	public void setDdd1Paciente(String ddd1Paciente) {
		this.ddd1Paciente = ddd1Paciente;
	}

	public String getTelefone1Paciente() {
		return telefone1Paciente;
	}

	public void setTelefone1Paciente(String telefone1Paciente) {
		this.telefone1Paciente = telefone1Paciente;
	}

	public String getDdd2Paciente() {
		return ddd2Paciente;
	}

	public void setDdd2Paciente(String ddd2Paciente) {
		this.ddd2Paciente = ddd2Paciente;
	}

	public String getTelefone2Paciente() {
		return telefone2Paciente;
	}

	public void setTelefone2Paciente(String telefone2Paciente) {
		this.telefone2Paciente = telefone2Paciente;
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

    public String getNumeroLogradouroPaciente() {
        return numeroLogradouroPaciente;
    }

    public void setNumeroLogradouroPaciente(String numeroLogradouroPaciente) {
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
