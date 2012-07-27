package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_usuario_acesso")
public class UsuarioAcesso implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario_acesso", nullable = false)
    private long idUsuarioAcesso;
        
    @ManyToOne(fetch=FetchType.EAGER)
	private Usuario usuario;

    @ManyToOne(fetch=FetchType.EAGER)
	private Acesso acesso;

	public long getIdUsuarioAcesso() {
		return idUsuarioAcesso;
	}

	public void setIdUsuarioAcesso(long idUsuarioAcesso) {
		this.idUsuarioAcesso = idUsuarioAcesso;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Acesso getAcesso() {
		return acesso;
	}

	public void setAcesso(Acesso acesso) {
		this.acesso = acesso;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    

}
