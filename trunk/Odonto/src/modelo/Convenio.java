package modelo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="tb_convenio")
public class Convenio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_convenio", nullable = false)
    private long idConvenio;
    @Column(name = "nome_convenio", nullable = false, length = 50, unique=true)
    private String nomeConvenio;

    public Convenio(){
    	
    }
    public Convenio(String nomeConvenio) {
    	this.nomeConvenio = nomeConvenio;
    }

    public long getIdConvenio() {
        return idConvenio;
    }

    public void setIdConvenio(long idConvenio) {
        this.idConvenio = idConvenio;
    }

    public String getNomeConvenio() {
        return nomeConvenio;
    }

    public void setNomeConvenio(String nomeConvenio) {
        this.nomeConvenio = nomeConvenio;
    }
    
    @Override
    public String toString() {
       	return nomeConvenio;
    }
  
}
