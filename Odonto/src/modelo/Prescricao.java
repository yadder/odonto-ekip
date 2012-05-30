package modelo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "tb_prescricao")
public class Prescricao implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_prescricao", nullable = false)
    private long codigoPrescricao;
    
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

	public Prescricao(long codigoPrescricao) {
        this.codigoPrescricao = codigoPrescricao;
    }

    public Prescricao(long codigoPrescricao, String observacao) {
        this.codigoPrescricao = codigoPrescricao;
        this.observacao = observacao;
    }

    public long getCodigoPrescricao() {
        return codigoPrescricao;
    }

    public void setCodigoPrescricao(long codigoPrescricao) {
        this.codigoPrescricao = codigoPrescricao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public String toString() {
        return "odonto.Prescricao[ codigoPrescricao=" + codigoPrescricao + " ]";
    }
   
}
