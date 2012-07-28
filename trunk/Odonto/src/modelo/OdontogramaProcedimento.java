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
    @Column(name = "id_odontograma_procedimento", nullable = false)
    private long idOdontogramaProcedimento;
    @Column(name = "status_procedimento", nullable = false, length = 20)
    private String statusProcedimento;
    @Column(name = "status_autorizacao", nullable = false, length = 20)
    private String statusAutorizacao;
    
    @ManyToOne(fetch=FetchType.EAGER)
	private Elemento elemento;
    
    @ManyToOne(fetch=FetchType.EAGER)
	private Face face;
    
    @ManyToOne(fetch=FetchType.EAGER)
	private Odontograma odontograma;
    
    @ManyToOne(fetch=FetchType.EAGER)
	private Procedimento procedimento;
    
    @Column(name = "data_execucao_procedimento")
    @Temporal(TemporalType.DATE)
    private Date dataExecucaoProcedimento;

    
    public OdontogramaProcedimento() {
    }

    public long getIdOdontogramaProcedimento() {
        return idOdontogramaProcedimento;
    }

    public void setIdOdontogramaProcedimento(long idOdontogramaProcedimento) {
        this.idOdontogramaProcedimento = idOdontogramaProcedimento;
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

	public Elemento getElemento() {
		return elemento;
	}

	public void setElemento(Elemento elemento) {
		this.elemento = elemento;
	}

	public Face getFace() {
		return face;
	}

	public void setFace(Face face) {
		this.face = face;
	}

	public Odontograma getOdontograma() {
		return odontograma;
	}

	public void setOdontograma(Odontograma odontograma) {
		this.odontograma = odontograma;
	}

	public Procedimento getProcedimento() {
		return procedimento;
	}

	public void setProcedimento(Procedimento procedimento) {
		this.procedimento = procedimento;
	}

	@Override
	public String toString() {
		return ""+idOdontogramaProcedimento;
	}
    
}
