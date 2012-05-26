package modelo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "tb_telefone_fornecedor")
public class TelefoneFornecedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_telefone", nullable = false)
    private long codigoTelefone;
    @Column(name = "ddd_telefone_fornecedor", nullable = false, length = 2)
    private String dddTelefoneFornecedor;
    @Column(name = "telefone_fornecedor", nullable = false, length = 9)
    private String telefoneFornecedor;
    @JoinColumn(name = "codigo_fornecedor", referencedColumnName = "codigo_fornecedor", nullable = false)
    @ManyToOne(optional = false)
    private Fornecedor codigoFornecedor;

    public TelefoneFornecedor() {
    }

    public TelefoneFornecedor(long codigoTelefone) {
        this.codigoTelefone = codigoTelefone;
    }

    public TelefoneFornecedor(long codigoTelefone, String dddTelefoneFornecedor, String telefoneFornecedor) {
        this.codigoTelefone = codigoTelefone;
        this.dddTelefoneFornecedor = dddTelefoneFornecedor;
        this.telefoneFornecedor = telefoneFornecedor;
    }

    public long getCodigoTelefone() {
        return codigoTelefone;
    }

    public void setCodigoTelefone(long codigoTelefone) {
        this.codigoTelefone = codigoTelefone;
    }

    public String getDddTelefoneFornecedor() {
        return dddTelefoneFornecedor;
    }

    public void setDddTelefoneFornecedor(String dddTelefoneFornecedor) {
        this.dddTelefoneFornecedor = dddTelefoneFornecedor;
    }

    public String getTelefoneFornecedor() {
        return telefoneFornecedor;
    }

    public void setTelefoneFornecedor(String telefoneFornecedor) {
        this.telefoneFornecedor = telefoneFornecedor;
    }

    public Fornecedor getCodigoFornecedor() {
        return codigoFornecedor;
    }

    public void setCodigoFornecedor(Fornecedor codigoFornecedor) {
        this.codigoFornecedor = codigoFornecedor;
    }

    @Override
    public String toString() {
        return "odonto.TelefoneFornecedor[ codigoTelefone=" + codigoTelefone + " ]";
    }
    
}
