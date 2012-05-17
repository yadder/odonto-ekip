package modelo_hibernate;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Windows
 */
@Entity
@Table(name = "tb_disponibilidade", catalog = "odonto", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Disponibilidade.findAll", query = "SELECT d FROM Disponibilidade d"),
    @NamedQuery(name = "Disponibilidade.findByCodigoDisponibilidade", query = "SELECT d FROM Disponibilidade d WHERE d.codigoDisponibilidade = :codigoDisponibilidade"),
    @NamedQuery(name = "Disponibilidade.findByDiaSemana", query = "SELECT d FROM Disponibilidade d WHERE d.diaSemana = :diaSemana"),
    @NamedQuery(name = "Disponibilidade.findByHoraInicio", query = "SELECT d FROM Disponibilidade d WHERE d.horaInicio = :horaInicio"),
    @NamedQuery(name = "Disponibilidade.findByHoraFim", query = "SELECT d FROM Disponibilidade d WHERE d.horaFim = :horaFim")})
public class Disponibilidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_disponibilidade", nullable = false)
    private Integer codigoDisponibilidade;
    @Basic(optional = false)
    @Column(name = "dia_semana", nullable = false, length = 20)
    private String diaSemana;
    @Basic(optional = false)
    @Column(name = "hora_inicio", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horaInicio;
    @Basic(optional = false)
    @Column(name = "hora_fim", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horaFim;
    @JoinColumn(name = "codigo_dentista", referencedColumnName = "codigo_dentista", nullable = false)
    @ManyToOne(optional = false)
    private Dentista codigoDentista;

    public Disponibilidade() {
    }

    public Disponibilidade(Integer codigoDisponibilidade) {
        this.codigoDisponibilidade = codigoDisponibilidade;
    }

    public Disponibilidade(Integer codigoDisponibilidade, String diaSemana, Date horaInicio, Date horaFim) {
        this.codigoDisponibilidade = codigoDisponibilidade;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }

    public Integer getCodigoDisponibilidade() {
        return codigoDisponibilidade;
    }

    public void setCodigoDisponibilidade(Integer codigoDisponibilidade) {
        this.codigoDisponibilidade = codigoDisponibilidade;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(Date horaFim) {
        this.horaFim = horaFim;
    }

    public Dentista getCodigoDentista() {
        return codigoDentista;
    }

    public void setCodigoDentista(Dentista codigoDentista) {
        this.codigoDentista = codigoDentista;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoDisponibilidade != null ? codigoDisponibilidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disponibilidade)) {
            return false;
        }
        Disponibilidade other = (Disponibilidade) object;
        if ((this.codigoDisponibilidade == null && other.codigoDisponibilidade != null) || (this.codigoDisponibilidade != null && !this.codigoDisponibilidade.equals(other.codigoDisponibilidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "odonto.Disponibilidade[ codigoDisponibilidade=" + codigoDisponibilidade + " ]";
    }
    
}
