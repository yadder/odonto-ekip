package modelo;

import java.io.Serializable;
import javax.persistence.*;

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

    @ManyToOne(fetch=FetchType.EAGER)
	private Odontograma odontograma;
    
	@ManyToOne(fetch=FetchType.EAGER)
    private Dentista dentista;    
    
    public Prescricao() {
    	
    }
    
    public Odontograma getOdontograma() {
		return odontograma;
	}

	public void setOdontograma(Odontograma odontograma) {
		this.odontograma = odontograma;
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

    @Override
    public String toString() {
        return "odonto.Prescricao[ idPrescricao=" + idPrescricao + " ]";
    }
   
}
