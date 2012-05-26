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
    @JoinColumn(name = "codigo_odontograma", referencedColumnName = "codigo_odontograma", nullable = false)
    @ManyToOne(optional = false)
    private Odontograma codigoOdontograma;
    @JoinColumn(name = "codigo_dentista", referencedColumnName = "codigo_dentista", nullable = false)
    @ManyToOne(optional = false)
    private Dentista codigoDentista;

    public Prescricao() {
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

    public Odontograma getCodigoOdontograma() {
        return codigoOdontograma;
    }

    public void setCodigoOdontograma(Odontograma codigoOdontograma) {
        this.codigoOdontograma = codigoOdontograma;
    }

    public Dentista getCodigoDentista() {
        return codigoDentista;
    }

    public void setCodigoDentista(Dentista codigoDentista) {
        this.codigoDentista = codigoDentista;
    }

    @Override
    public String toString() {
        return "odonto.Prescricao[ codigoPrescricao=" + codigoPrescricao + " ]";
    }
    
}
