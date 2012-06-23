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
    @Column(name = "descricao_procedimento", nullable = false, length = 50)
    private String descricaoProcedimento;
    @Column(name = "valor_procedimento", nullable = false)
    private double valorProcedimento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProcedimento")
    private List<OdontogramaProcedimento> odontogramaProcedimentoList;
    @JoinColumn(name = "id_convenio", referencedColumnName = "id_convenio", nullable = false)
    @ManyToOne(optional = false)
    private Convenio idConvenio;

    public Procedimento() {
    }

    public Procedimento(long idProcedimento) {
        this.idProcedimento = idProcedimento;
    }

    public Procedimento(long idProcedimento, String descricaoProcedimento, double valorProcedimento) {
        this.idProcedimento = idProcedimento;
        this.descricaoProcedimento = descricaoProcedimento;
        this.valorProcedimento = valorProcedimento;
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

    public Convenio getIdConvenio() {
        return idConvenio;
    }

    public void setIdConvenio(Convenio idConvenio) {
        this.idConvenio = idConvenio;
    }

    @Override
    public String toString() {
        return "odonto.Procedimento[ idProcedimento=" + idProcedimento + " ]";
    }
    
}
