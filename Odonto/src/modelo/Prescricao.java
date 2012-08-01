package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_prescricao")
public class Prescricao implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prescricao", nullable = false)
    private long idPrescricao;
    
    @Column(name = "observacao", nullable = false, length = 255)
    private String observacao;
    
    @Column(name = "tipo_prescricao", nullable = false, length = 15)
    private String tipoPrescricao;

    @ManyToOne(fetch=FetchType.EAGER)
	private Paciente paciente;
    
	@ManyToOne(fetch=FetchType.EAGER)
    private Dentista dentista;    
    
    public Prescricao() {
    	
    }
    
    public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Dentista getDentista() {
		return dentista;
	}

	public void setDentista(Dentista dentista) {
		this.dentista = dentista;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Prescricao(long idPrescricao) {
        this.idPrescricao = idPrescricao;
    }

    public Prescricao(long idPrescricao, String observacao) {
        this.idPrescricao = idPrescricao;
        this.observacao = observacao;
    }

    public long getIdPrescricao() {
        return idPrescricao;
    }

    public void setIdPrescricao(long idPrescricao) {
        this.idPrescricao = idPrescricao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    public String getTipoPrescricao() {
		return tipoPrescricao;
	}

	public void setTipoPrescricao(String tipoPrescricao) {
		this.tipoPrescricao = tipoPrescricao;
	}
	
	@Override
	public String toString() {
	
		return observacao;
		
	}
}
