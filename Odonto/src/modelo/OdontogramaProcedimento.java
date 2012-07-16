package modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "tb_odontograma_procedimento")
public class OdontogramaProcedimento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_odontograma_procedimeto", nullable = false)
    private long idOdontogramaProcedimeto;
    @Column(name = "status_procedimento", nullable = false, length = 20)
    private String statusProcedimento;
    @Column(name = "status_autorizacao", nullable = false, length = 20)
    private String statusAutorizacao;
    @JoinColumn(name = "id_elemento", referencedColumnName = "id_elemento", nullable = false)
    @ManyToOne(optional = false)
    private Elemento idElemento;
    @JoinColumn(name = "id_face", referencedColumnName = "id_face", nullable = false)
    @ManyToOne(optional = false)
    private Face idFace;
    @JoinColumn(name = "id_procedimento", referencedColumnName = "id_procedimento", nullable = false)
    @ManyToOne(optional = false)
    private Procedimento idProcedimento;
    @JoinColumn(name = "id_odontograma", referencedColumnName = "id_odontograma", nullable = false)
    @ManyToOne(optional = false)
    private Odontograma idOdontograma;
    @Column(name = "data_execucao_procedimento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataExecucaoProcedimento;

    public OdontogramaProcedimento() {
    }

    public long getIdOdontogramaProcedimeto() {
        return idOdontogramaProcedimeto;
    }

    public void setIdOdontogramaProcedimeto(long idOdontogramaProcedimeto) {
        this.idOdontogramaProcedimeto = idOdontogramaProcedimeto;
    }

    public Elemento getIdElemento() {
        return idElemento;
    }

    public void setIdElemento(Elemento idElemento) {
        this.idElemento = idElemento;
    }

    public Face getIdFace() {
        return idFace;
    }

    public void setIdFace(Face idFace) {
        this.idFace = idFace;
    }

    public Procedimento getIdProcedimento() {
        return idProcedimento;
    }

    public void setIdProcedimento(Procedimento idProcedimento) {
        this.idProcedimento = idProcedimento;
    }

    public Odontograma getIdOdontograma() {
        return idOdontograma;
    }

    public void setIdOdontograma(Odontograma idOdontograma) {
        this.idOdontograma = idOdontograma;
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
	
	public Date getDataExecucaoProcedimento() {
		return dataExecucaoProcedimento;
	}

	public void setDataExecucaoProcedimento(Date dataExecucaoProcedimento) {
		this.dataExecucaoProcedimento = dataExecucaoProcedimento;
	}

	public String getStatusAutorizacao() {
		return statusAutorizacao;
	}

	public void setStatusAutorizacao(String statusAutorizacao) {
		this.statusAutorizacao = statusAutorizacao;
	}

	@Override
    public String toString() {
        return "odonto.OdontogramaProcedimento[ idOdontogramaProcedimeto=" + idOdontogramaProcedimeto + " ]";
    }
    
}
