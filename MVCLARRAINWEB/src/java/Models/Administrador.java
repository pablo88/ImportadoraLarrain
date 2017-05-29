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
@Table(name = "ADMINISTRADOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrador.findAll", query = "SELECT a FROM Administrador a"),
    @NamedQuery(name = "Administrador.findByIdAdmin", query = "SELECT a FROM Administrador a WHERE a.idAdmin = :idAdmin"),
    @NamedQuery(name = "Administrador.findByCorreoAdmin", query = "SELECT a FROM Administrador a WHERE a.correoAdmin = :correoAdmin"),
    @NamedQuery(name = "Administrador.findByNombreAdmin", query = "SELECT a FROM Administrador a WHERE a.nombreAdmin = :nombreAdmin")})
public class Administrador implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ADMIN")
    private BigDecimal idAdmin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 125)
    @Column(name = "CORREO_ADMIN")
    private String correoAdmin;
    @Size(max = 125)
    @Column(name = "NOMBRE_ADMIN")
    private String nombreAdmin;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario idUsuario;

    public Administrador() {
    }

    public Administrador(BigDecimal idAdmin) {
        this.idAdmin = idAdmin;
    }

    public Administrador(BigDecimal idAdmin, String correoAdmin) {
        this.idAdmin = idAdmin;
        this.correoAdmin = correoAdmin;
    }

    public BigDecimal getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(BigDecimal idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getCorreoAdmin() {
        return correoAdmin;
    }

    public void setCorreoAdmin(String correoAdmin) {
        this.correoAdmin = correoAdmin;
    }

    public String getNombreAdmin() {
        return nombreAdmin;
    }

    public void setNombreAdmin(String nombreAdmin) {
        this.nombreAdmin = nombreAdmin;
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
        hash += (idAdmin != null ? idAdmin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrador)) {
            return false;
        }
        Administrador other = (Administrador) object;
        if ((this.idAdmin == null && other.idAdmin != null) || (this.idAdmin != null && !this.idAdmin.equals(other.idAdmin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Administrador[ idAdmin=" + idAdmin + " ]";
    }
    
}
