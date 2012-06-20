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
    @Column(name="codigo_elemento")
    private long codigoElemento;
    
	@Column(name="nome_elemento", nullable=false, unique=true, length=2)
    private String nomeElemento;

    public Elemento() {
    }
    
    public Elemento (String nomeElemento){
    	this.nomeElemento = nomeElemento;
    }
    public Elemento(long codigoElemento) {
        this.codigoElemento = codigoElemento;
    }

    public Elemento(long codigoElemento, String nomeElemento) {
        this.codigoElemento = codigoElemento;
        this.nomeElemento = nomeElemento;
    }

    public long getCodigoElemento() {
        return codigoElemento;
    }

    public void setCodigoElemento(Integer codigoElemento) {
        this.codigoElemento = codigoElemento;
    }

    public String getNomeElemento() {
        return nomeElemento;
    }

    public void setNomeElemento(String nomeElemento) {
        this.nomeElemento = nomeElemento;
    }


}


