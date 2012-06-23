package modelo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "tb_telefone_fornecedor")
public class TelefoneFornecedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_telefone", nullable = false)
    private long idTelefone;
    @Column(name = "ddd_telefone_fornecedor", nullable = false, length = 2)
    private String dddTelefoneFornecedor;
    @Column(name = "telefone_fornecedor", nullable = false, length = 9)
    private String telefoneFornecedor;
    @JoinColumn(name = "id_fornecedor", referencedColumnName = "id_fornecedor", nullable = false)
    @ManyToOne(optional = false)
    private Fornecedor idFornecedor;

    public TelefoneFornecedor() {
    }

    public TelefoneFornecedor(long idTelefone) {
        this.idTelefone = idTelefone;
    }

    public TelefoneFornecedor(long idTelefone, String dddTelefoneFornecedor, String telefoneFornecedor) {
        this.idTelefone = idTelefone;
        this.dddTelefoneFornecedor = dddTelefoneFornecedor;
        this.telefoneFornecedor = telefoneFornecedor;
    }

    public long getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(long idTelefone) {
        this.idTelefone = idTelefone;
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

    public Fornecedor getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Fornecedor idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    @Override
    public String toString() {
        return "odonto.TelefoneFornecedor[ idTelefone=" + idTelefone + " ]";
    }
    
}
