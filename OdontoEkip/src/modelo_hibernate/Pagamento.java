package modelo_hibernate;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Windows
 */
@Entity
@Table(name = "tb_pagamento", catalog = "odonto", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pagamento.findAll", query = "SELECT p FROM Pagamento p"),
    @NamedQuery(name = "Pagamento.findByCodigoPagamento", query = "SELECT p FROM Pagamento p WHERE p.codigoPagamento = :codigoPagamento"),
    @NamedQuery(name = "Pagamento.findByNumeroParcela", query = "SELECT p FROM Pagamento p WHERE p.numeroParcela = :numeroParcela"),
    @NamedQuery(name = "Pagamento.findByValorParcela", query = "SELECT p FROM Pagamento p WHERE p.valorParcela = :valorParcela"),
    @NamedQuery(name = "Pagamento.findByStatusPagamento", query = "SELECT p FROM Pagamento p WHERE p.statusPagamento = :statusPagamento")})
public class Pagamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_pagamento", nullable = false)
    private Integer codigoPagamento;
    @Basic(optional = false)
    @Column(name = "numero_parcela", nullable = false)
    private int numeroParcela;
    @Basic(optional = false)
    @Column(name = "valor_parcela", nullable = false)
    private double valorParcela;
    @Basic(optional = false)
    @Column(name = "status_pagamento", nullable = false, length = 20)
    private String statusPagamento;
    @JoinColumn(name = "codigo_odontograma", referencedColumnName = "codigo_odontograma", nullable = false)
    @ManyToOne(optional = false)
    private Odontograma codigoOdontograma;

    public Pagamento() {
    }

    public Pagamento(Integer codigoPagamento) {
        this.codigoPagamento = codigoPagamento;
    }

    public Pagamento(Integer codigoPagamento, int numeroParcela, double valorParcela, String statusPagamento) {
        this.codigoPagamento = codigoPagamento;
        this.numeroParcela = numeroParcela;
        this.valorParcela = valorParcela;
        this.statusPagamento = statusPagamento;
    }

    public Integer getCodigoPagamento() {
        return codigoPagamento;
    }

    public void setCodigoPagamento(Integer codigoPagamento) {
        this.codigoPagamento = codigoPagamento;
    }

    public int getNumeroParcela() {
        return numeroParcela;
    }

    public void setNumeroParcela(int numeroParcela) {
        this.numeroParcela = numeroParcela;
    }

    public double getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(double valorParcela) {
        this.valorParcela = valorParcela;
    }

    public String getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(String statusPagamento) {
        this.statusPagamento = statusPagamento;
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
        hash += (codigoPagamento != null ? codigoPagamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagamento)) {
            return false;
        }
        Pagamento other = (Pagamento) object;
        if ((this.codigoPagamento == null && other.codigoPagamento != null) || (this.codigoPagamento != null && !this.codigoPagamento.equals(other.codigoPagamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "odonto.Pagamento[ codigoPagamento=" + codigoPagamento + " ]";
    }
    
}
