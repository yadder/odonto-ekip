package modelo;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "tb_dentista")
@PrimaryKeyJoinColumn(name="id_usuario") 
public class Dentista extends Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "cro_dentista", nullable = false, length = 30, unique = true)
    private String croDentista;
    
    public Dentista() {

	}
    
	public Dentista(String nomeUsuario) {
		super(nomeUsuario);
	}

	public Dentista(String nomeUsuario, String senhaUsuario, String perfilUsuario, String rgUsuario,
			String cpfUsuario, String sexoUsuario, Date dataNascimentoUsuario,
			String croDentista) {
		super(nomeUsuario, senhaUsuario, perfilUsuario, rgUsuario, cpfUsuario, sexoUsuario,
				dataNascimentoUsuario);
		this.croDentista = croDentista;
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

	@Override
	public String toString() {
		return getNomeUsuario();
	}
    
    
	
        
}
