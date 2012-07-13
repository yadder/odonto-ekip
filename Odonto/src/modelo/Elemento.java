package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="tb_elemento")
public class Elemento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_elemento", nullable = false)
    private long idElemento;    
	@Column(name="nome_elemento", nullable=false, unique=true, length=2)
    private String nomeElemento;

    public Elemento() {
    }
    
    public Elemento (String nomeElemento){
    	this.nomeElemento = nomeElemento;
    }
    public Elemento(long idElemento) {
        this.idElemento = idElemento;
    }

    public Elemento(long idElemento, String nomeElemento) {
        this.idElemento = idElemento;
        this.nomeElemento = nomeElemento;
    }

    public long getIdElemento() {
        return idElemento;
    }

    public void setIdElemento(long idElemento) {
        this.idElemento = idElemento;
    }

    public String getNomeElemento() {
        return nomeElemento;
    }

    public void setNomeElemento(String nomeElemento) {
        this.nomeElemento = nomeElemento;
    }
}


