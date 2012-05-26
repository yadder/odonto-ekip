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
    @Column(name = "codigo_procedimento", nullable = false)
    private long codigoProcedimento;
    @Column(name = "descricao_procedimento", nullable = false, length = 50)
    private String descricaoProcedimento;
    @Column(name = "valor_procedimento", nullable = false)
    private double valorProcedimento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoProcedimento")
    private List<OdontogramaProcedimento> odontogramaProcedimentoList;
    @JoinColumn(name = "codigo_convenio", referencedColumnName = "codigo_convenio", nullable = false)
    @ManyToOne(optional = false)
    private Convenio codigoConvenio;

    public Procedimento() {
    }

    public Procedimento(long codigoProcedimento) {
        this.codigoProcedimento = codigoProcedimento;
    }

    public Procedimento(long codigoProcedimento, String descricaoProcedimento, double valorProcedimento) {
        this.codigoProcedimento = codigoProcedimento;
        this.descricaoProcedimento = descricaoProcedimento;
        this.valorProcedimento = valorProcedimento;
    }

    public long getCodigoProcedimento() {
        return codigoProcedimento;
    }

    public void setCodigoProcedimento(long codigoProcedimento) {
        this.codigoProcedimento = codigoProcedimento;
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

    public Convenio getCodigoConvenio() {
        return codigoConvenio;
    }

    public void setCodigoConvenio(Convenio codigoConvenio) {
        this.codigoConvenio = codigoConvenio;
    }

    @Override
    public String toString() {
        return "odonto.Procedimento[ codigoProcedimento=" + codigoProcedimento + " ]";
    }
    
}
