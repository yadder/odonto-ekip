package modelo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="tb_convenio")
public class Convenio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_convenio", nullable = false)
    private long codigoConvenio;
    @Column(name = "nome_convenio", nullable = false, length = 50, unique=true)
    private String nomeConvenio;

    public Convenio(){
    	
    }
    public Convenio(long codigoConvenio, String nomeConvenio) {
        this.codigoConvenio = codigoConvenio;
    	this.nomeConvenio = nomeConvenio;
    }

    public long getCodigoConvenio() {
        return codigoConvenio;
    }

    public void setCodigoConvenio(long codigoConvenio) {
        this.codigoConvenio = codigoConvenio;
    }

    public String getNomeConvenio() {
        return nomeConvenio;
    }

    public void setNomeConvenio(String nomeConvenio) {
        this.nomeConvenio = nomeConvenio;
    }
  
}
