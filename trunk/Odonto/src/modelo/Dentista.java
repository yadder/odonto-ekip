package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "tb_dentista")
@PrimaryKeyJoinColumn(name="codigoUsuario") 
public class Dentista extends Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "cro_dentista", nullable = false, length = 30)
    private String croDentista;
    @Column(name = "codigo_dentista", nullable = false)
    private Integer codigoDentista;
    @JoinColumn(name = "codigo_dentista", referencedColumnName = "codigo_usuario", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoDentista")
    private List<Prescricao> prescricaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoDentista")
    private List<Odontograma> odontogramaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoDentista")
    private List<Consulta> consultaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoDentista")
    private List<Disponibilidade> disponibilidadeList;

    public Dentista() {
        
    }

    public Dentista(Integer codigoUsuario, String nomeUsuario, String loginUsuario, String senhaUsuario, String perfilUsuario, String cpfUsuario, String sexoUsuario) {
        super(codigoUsuario, nomeUsuario, loginUsuario, senhaUsuario, perfilUsuario, cpfUsuario, sexoUsuario);
    }    
    
    public String getCroDentista() {
        return croDentista;
    }

    public void setCroDentista(String croDentista) {
        this.croDentista = croDentista;
    }

    public Integer getCodigoDentista() {
        return codigoDentista;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @XmlTransient
    public List<Prescricao> getPrescricaoList() {
        return prescricaoList;
    }

    public void setPrescricaoList(List<Prescricao> prescricaoList) {
        this.prescricaoList = prescricaoList;
    }

    @XmlTransient
    public List<Odontograma> getOdontogramaList() {
        return odontogramaList;
    }

    public void setOdontogramaList(List<Odontograma> odontogramaList) {
        this.odontogramaList = odontogramaList;
    }

    @XmlTransient
    public List<Consulta> getConsultaList() {
        return consultaList;
    }

    public void setConsultaList(List<Consulta> consultaList) {
        this.consultaList = consultaList;
    }

    @XmlTransient
    public List<Disponibilidade> getDisponibilidadeList() {
        return disponibilidadeList;
    }

    public void setDisponibilidadeList(List<Disponibilidade> disponibilidadeList) {
        this.disponibilidadeList = disponibilidadeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoDentista != null ? codigoDentista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dentista)) {
            return false;
        }
        Dentista other = (Dentista) object;
        if ((this.codigoDentista == null && other.codigoDentista != null) || (this.codigoDentista != null && !this.codigoDentista.equals(other.codigoDentista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "odonto.Dentista[ codigoDentista=" + codigoDentista + " ]";
    }
    
}
