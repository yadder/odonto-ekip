package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="tb_acesso")
public class Acesso implements Serializable {
    
	private static final long serialVersionUID = 1L;
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_acesso")
    private long idAcesso;
    
	@Column(name="descricao_acesso", nullable=false, unique=true)
    private String descricaoAcesso;

    public Acesso() {
    }
    
    public Acesso (String descricaoAcesso){
    	this.descricaoAcesso = descricaoAcesso;
    }
    
    public long getIdAcesso() {
        return idAcesso;
    }

    public void setIdAcesso(Integer idAcesso) {
        this.idAcesso = idAcesso;
    }

    public String getDescricaoAcesso() {
        return descricaoAcesso;
    }

    public void setDescricaoAcesso(String descricaoAcesso) {
        this.descricaoAcesso = descricaoAcesso;
    }
    
    @Override
    public String toString() {
    	return descricaoAcesso;
    }
}


