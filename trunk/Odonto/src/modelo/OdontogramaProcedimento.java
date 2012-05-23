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
    @Basic(optional = false)
    @Column(name = "codigo_odontograma_procedimeto", nullable = false)
    private Integer codigoOdontogramaProcedimeto;
    @Basic(optional = false)
    @Column(name = "status_pagamento", nullable = false, length = 20)
    private String statusPagamento;
    @Column(name = "data_pagamento")
    @Temporal(TemporalType.DATE)
    private Date dataPagamento;
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

    public OdontogramaProcedimento(Integer codigoOdontogramaProcedimeto) {
        this.codigoOdontogramaProcedimeto = codigoOdontogramaProcedimeto;
    }

    public OdontogramaProcedimento(Integer codigoOdontogramaProcedimeto, String statusPagamento) {
        this.codigoOdontogramaProcedimeto = codigoOdontogramaProcedimeto;
        this.statusPagamento = statusPagamento;
    }

    public Integer getCodigoOdontogramaProcedimeto() {
        return codigoOdontogramaProcedimeto;
    }

    public void setCodigoOdontogramaProcedimeto(Integer codigoOdontogramaProcedimeto) {
        this.codigoOdontogramaProcedimeto = codigoOdontogramaProcedimeto;
    }

    public String getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(String statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoOdontogramaProcedimeto != null ? codigoOdontogramaProcedimeto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OdontogramaProcedimento)) {
            return false;
        }
        OdontogramaProcedimento other = (OdontogramaProcedimento) object;
        if ((this.codigoOdontogramaProcedimeto == null && other.codigoOdontogramaProcedimeto != null) || (this.codigoOdontogramaProcedimeto != null && !this.codigoOdontogramaProcedimeto.equals(other.codigoOdontogramaProcedimeto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "odonto.OdontogramaProcedimento[ codigoOdontogramaProcedimeto=" + codigoOdontogramaProcedimeto + " ]";
    }
    
}
