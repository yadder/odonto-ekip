package modelo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "tb_pagamento", catalog = "odonto", schema = "")
public class Pagamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_pagamento", nullable = false)
    private long codigoPagamento;
    @Column(name = "numero_parcela", nullable = false)
    private int numeroParcela;
    @Column(name = "valor_parcela", nullable = false)
    private double valorParcela;
    @Column(name = "status_pagamento", nullable = false, length = 20)
    private String statusPagamento;
    @JoinColumn(name = "codigo_odontograma", referencedColumnName = "codigo_odontograma", nullable = false)
    @ManyToOne(optional = false)
    private Odontograma codigoOdontograma;

    public Pagamento() {
    }

    public Pagamento(long codigoPagamento) {
        this.codigoPagamento = codigoPagamento;
    }

    public Pagamento(long codigoPagamento, int numeroParcela, double valorParcela, String statusPagamento) {
        this.codigoPagamento = codigoPagamento;
        this.numeroParcela = numeroParcela;
        this.valorParcela = valorParcela;
        this.statusPagamento = statusPagamento;
    }

    public long getCodigoPagamento() {
        return codigoPagamento;
    }

    public void setCodigoPagamento(long codigoPagamento) {
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
    public String toString() {
        return "odonto.Pagamento[ codigoPagamento=" + codigoPagamento + " ]";
    }
    
}
