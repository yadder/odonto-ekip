package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "tb_procedimento")
public class Procedimento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_procedimento", nullable = false)
    private long idProcedimento;
    @Column(name = "codigo_procedimento", nullable = false, length=100)
    private String codigoProcedimento;
    @Column(name = "descricao_procedimento", nullable = false, length = 100)
    private String descricaoProcedimento;
    @Column(name = "valor_procedimento", nullable = false)
    private double valorProcedimento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProcedimento")
    private List<OdontogramaProcedimento> odontogramaProcedimentoList;
    @JoinColumn(name = "id_convenio", referencedColumnName = "id_convenio", nullable = false)
    @ManyToOne(optional = false)
    private Convenio convenio;

    public Procedimento() {
    }
    
    public Procedimento (String descricaoProcedimento){
    	this.descricaoProcedimento = descricaoProcedimento;
    }

    public Procedimento(String descricaoProcedimento, double valorProcedimento, Convenio convenio) {
        this.descricaoProcedimento = descricaoProcedimento;
        this.valorProcedimento = valorProcedimento;
        this.convenio = convenio;
    }

    public long getIdProcedimento() {
        return idProcedimento;
    }

    public void setIdProcedimento(long idProcedimento) {
        this.idProcedimento = idProcedimento;
    }

    public String getDescricaoProcedimento() {
        return descricaoProcedimento;
    }

    public void setDescricaoProcedimento(String descricaoProcedimento) {
        this.descricaoProcedimento = descricaoProcedimento;
    }

    public double getValorProcedimento() {
        return valorProcedimento;
    }

    public void setValorProcedimento(double valorProcedimento) {
        this.valorProcedimento = valorProcedimento;
    }

    @XmlTransient
    public List<OdontogramaProcedimento> getOdontogramaProcedimentoList() {
        return odontogramaProcedimentoList;
    }

    public void setOdontogramaProcedimentoList(List<OdontogramaProcedimento> odontogramaProcedimentoList) {
        this.odontogramaProcedimentoList = odontogramaProcedimentoList;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }
    
    public String getCodigoProcedimento() {
		return codigoProcedimento;
	}

	public void setCodigoProcedimento(String codigoProcedimento) {
		this.codigoProcedimento = codigoProcedimento;
	}

	@Override
    public String toString() {
        return descricaoProcedimento;
    }
    
}
