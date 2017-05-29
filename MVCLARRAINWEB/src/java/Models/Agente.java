/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author P_Silva
 */
@Entity
@Table(name = "AGENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agente.findAll", query = "SELECT a FROM Agente a"),
    @NamedQuery(name = "Agente.findByIdAgente", query = "SELECT a FROM Agente a WHERE a.idAgente = :idAgente"),
    @NamedQuery(name = "Agente.findByNombreAgente", query = "SELECT a FROM Agente a WHERE a.nombreAgente = :nombreAgente"),
    @NamedQuery(name = "Agente.findByCorreoAgente", query = "SELECT a FROM Agente a WHERE a.correoAgente = :correoAgente")})
public class Agente implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_AGENTE")
    private BigDecimal idAgente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "NOMBRE_AGENTE")
    private String nombreAgente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "CORREO_AGENTE")
    private String correoAgente;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario idUsuario;

    public Agente() {
    }

    public Agente(BigDecimal idAgente) {
        this.idAgente = idAgente;
    }

    public Agente(BigDecimal idAgente, String nombreAgente, String correoAgente) {
        this.idAgente = idAgente;
        this.nombreAgente = nombreAgente;
        this.correoAgente = correoAgente;
    }

    public BigDecimal getIdAgente() {
        return idAgente;
    }

    public void setIdAgente(BigDecimal idAgente) {
        this.idAgente = idAgente;
    }

    public String getNombreAgente() {
        return nombreAgente;
    }

    public void setNombreAgente(String nombreAgente) {
        this.nombreAgente = nombreAgente;
    }

    public String getCorreoAgente() {
        return correoAgente;
    }

    public void setCorreoAgente(String correoAgente) {
        this.correoAgente = correoAgente;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAgente != null ? idAgente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agente)) {
            return false;
        }
        Agente other = (Agente) object;
        if ((this.idAgente == null && other.idAgente != null) || (this.idAgente != null && !this.idAgente.equals(other.idAgente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Agente[ idAgente=" + idAgente + " ]";
    }
    
}
