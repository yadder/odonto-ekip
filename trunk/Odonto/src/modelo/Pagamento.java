package modelo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "tb_pagamento", catalog = "odonto", schema = "")
public class Pagamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pagamento", nullable = false)
    private long idPagamento;
    @Column(name = "numero_parcela", nullable = false)
    private int numeroParcela;
    @Column(name = "valor_parcela", nullable = false)
    private double valorParcela;
    @Column(name = "status_pagamento", nullable = false, length = 20)
    private String statusPagamento;
    @ManyToOne(fetch=FetchType.EAGER)
	private Odontograma odontograma;

    public Pagamento() {
    }

    public Pagamento(long idPagamento) {
        this.idPagamento = idPagamento;
    }

    public Pagamento(long idPagamento, int numeroParcela, double valorParcela, String statusPagamento) {
        this.idPagamento = idPagamento;
        this.numeroParcela = numeroParcela;
        this.valorParcela = valorParcela;
        this.statusPagamento = statusPagamento;
    }

    public long getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(long idPagamento) {
        this.idPagamento = idPagamento;
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

    public Odontograma getOdontograma() {
		return odontograma;
	}

	public void setOdontograma(Odontograma odontograma) {
		this.odontograma = odontograma;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
    public String toString() {
        return "odonto.Pagamento[ idPagamento=" + idPagamento + " ]";
    }
    
}
