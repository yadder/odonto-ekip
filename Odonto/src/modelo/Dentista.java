package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "tb_dentista")
@PrimaryKeyJoinColumn(name="codigoUsuario") 
public class Dentista extends Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "cro_dentista", nullable = false, length = 30, unique = true)
    private String croDentista;
    
    public Dentista() {

	}

	public String getCroDentista() {
		return croDentista;
	}

	public void setCroDentista(String croDentista) {
		this.croDentista = croDentista;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
	
        
}
