package modelo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "tb_odontograma_procedimento")
public class OdontogramaProcedimento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_odontograma_procedimeto", nullable = false)
    private long codigoOdontogramaProcedimeto;
    @Column(name = "status_procedimento", nullable = false, length = 20)
    private String statusProcedimento;
    @JoinColumn(name = "codigo_elemento", referencedColumnName = "codigo_elemento", nullable = false)
    @ManyToOne(optional = false)
    private Elemento codigoElemento;
    @JoinColumn(name = "codigo_face", referencedColumnName = "codigo_face", nullable = false)
    @ManyToOne(optional = false)
    private Face codigoFace;
    @JoinColumn(name = "codigo_procedimento", referencedColumnName = "codigo_procedimento", nullable = false)
    @ManyToOne(optional = false)
    private Procedimento codigoProcedimento;
    @JoinColumn(name = "codigo_odontograma", referencedColumnName = "codigo_odontograma", nullable = false)
    @ManyToOne(optional = false)
    private Odontograma codigoOdontograma;

    public OdontogramaProcedimento() {
    }

    public OdontogramaProcedimento(long codigoOdontogramaProcedimeto) {
        this.codigoOdontogramaProcedimeto = codigoOdontogramaProcedimeto;
    }

    public long getCodigoOdontogramaProcedimeto() {
        return codigoOdontogramaProcedimeto;
    }

    public void setCodigoOdontogramaProcedimeto(long codigoOdontogramaProcedimeto) {
        this.codigoOdontogramaProcedimeto = codigoOdontogramaProcedimeto;
    }

    public Elemento getCodigoElemento() {
        return codigoElemento;
    }

    public void setCodigoElemento(Elemento codigoElemento) {
        this.codigoElemento = codigoElemento;
    }

    public Face getCodigoFace() {
        return codigoFace;
    }

    public void setCodigoFace(Face codigoFace) {
        this.codigoFace = codigoFace;
    }

    public Procedimento getCodigoProcedimento() {
        return codigoProcedimento;
    }

    public void setCodigoProcedimento(Procedimento codigoProcedimento) {
        this.codigoProcedimento = codigoProcedimento;
    }

    public Odontograma getCodigoOdontograma() {
        return codigoOdontograma;
    }

    public void setCodigoOdontograma(Odontograma codigoOdontograma) {
        this.codigoOdontograma = codigoOdontograma;
    }
    
    
    public String getStatusProcedimento() {
		return statusProcedimento;
	}

	public void setStatusProcedimento(String statusProcedimento) {
		this.statusProcedimento = statusProcedimento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
    public String toString() {
        return "odonto.OdontogramaProcedimento[ codigoOdontogramaProcedimeto=" + codigoOdontogramaProcedimeto + " ]";
    }
    
}
