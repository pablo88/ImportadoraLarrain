/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Home
 */
@Entity
@Table(name = "SUPERVISOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Supervisor.findAll", query = "SELECT s FROM Supervisor s")
    , @NamedQuery(name = "Supervisor.findByIdSupervisor", query = "SELECT s FROM Supervisor s WHERE s.idSupervisor = :idSupervisor")
    , @NamedQuery(name = "Supervisor.findByNombreSupervisor", query = "SELECT s FROM Supervisor s WHERE s.nombreSupervisor = :nombreSupervisor")
    , @NamedQuery(name = "Supervisor.findByAppSupervisor", query = "SELECT s FROM Supervisor s WHERE s.appSupervisor = :appSupervisor")
    , @NamedQuery(name = "Supervisor.findByApmSupervisor", query = "SELECT s FROM Supervisor s WHERE s.apmSupervisor = :apmSupervisor")
    , @NamedQuery(name = "Supervisor.findByCorreoSupervisor", query = "SELECT s FROM Supervisor s WHERE s.correoSupervisor = :correoSupervisor")})
public class Supervisor implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SUPERVISOR")
    private BigDecimal idSupervisor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "NOMBRE_SUPERVISOR")
    private String nombreSupervisor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "APP_SUPERVISOR")
    private String appSupervisor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "APM_SUPERVISOR")
    private String apmSupervisor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "CORREO_SUPERVISOR")
    private String correoSupervisor;
    @OneToMany(mappedBy = "idSupervisor")
    private List<PedidoAProveedor> pedidoAProveedorList;
    @JoinColumn(name = "ID_SUCURSAL", referencedColumnName = "ID_SUCURSAL")
    @ManyToOne(optional = false)
    private Sucursal idSucursal;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario idUsuario;

    public Supervisor() {
    }

    public Supervisor(BigDecimal idSupervisor) {
        this.idSupervisor = idSupervisor;
    }

    public Supervisor(BigDecimal idSupervisor, String nombreSupervisor, String appSupervisor, String apmSupervisor, String correoSupervisor) {
        this.idSupervisor = idSupervisor;
        this.nombreSupervisor = nombreSupervisor;
        this.appSupervisor = appSupervisor;
        this.apmSupervisor = apmSupervisor;
        this.correoSupervisor = correoSupervisor;
    }

    public BigDecimal getIdSupervisor() {
        return idSupervisor;
    }

    public void setIdSupervisor(BigDecimal idSupervisor) {
        this.idSupervisor = idSupervisor;
    }

    public String getNombreSupervisor() {
        return nombreSupervisor;
    }

    public void setNombreSupervisor(String nombreSupervisor) {
        this.nombreSupervisor = nombreSupervisor;
    }

    public String getAppSupervisor() {
        return appSupervisor;
    }

    public void setAppSupervisor(String appSupervisor) {
        this.appSupervisor = appSupervisor;
    }

    public String getApmSupervisor() {
        return apmSupervisor;
    }

    public void setApmSupervisor(String apmSupervisor) {
        this.apmSupervisor = apmSupervisor;
    }

    public String getCorreoSupervisor() {
        return correoSupervisor;
    }

    public void setCorreoSupervisor(String correoSupervisor) {
        this.correoSupervisor = correoSupervisor;
    }

    @XmlTransient
    public List<PedidoAProveedor> getPedidoAProveedorList() {
        return pedidoAProveedorList;
    }

    public void setPedidoAProveedorList(List<PedidoAProveedor> pedidoAProveedorList) {
        this.pedidoAProveedorList = pedidoAProveedorList;
    }

    public Sucursal getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Sucursal idSucursal) {
        this.idSucursal = idSucursal;
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
        hash += (idSupervisor != null ? idSupervisor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Supervisor)) {
            return false;
        }
        Supervisor other = (Supervisor) object;
        if ((this.idSupervisor == null && other.idSupervisor != null) || (this.idSupervisor != null && !this.idSupervisor.equals(other.idSupervisor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Supervisor[ idSupervisor=" + idSupervisor + " ]";
    }
    
}
