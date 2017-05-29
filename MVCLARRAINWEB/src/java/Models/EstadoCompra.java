/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author P_Silva
 */
@Entity
@Table(name = "ESTADO_COMPRA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoCompra.findAll", query = "SELECT e FROM EstadoCompra e"),
    @NamedQuery(name = "EstadoCompra.findByIdEstadoCompra", query = "SELECT e FROM EstadoCompra e WHERE e.idEstadoCompra = :idEstadoCompra"),
    @NamedQuery(name = "EstadoCompra.findByDescripcion", query = "SELECT e FROM EstadoCompra e WHERE e.descripcion = :descripcion")})
public class EstadoCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ESTADO_COMPRA")
    private BigDecimal idEstadoCompra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(mappedBy = "idEstadoCompra")
    private Collection<CorreoEstado> correoEstadoCollection;
    @OneToMany(mappedBy = "idEstadoCompra")
    private Collection<Compra> compraCollection;

    public EstadoCompra() {
    }

    public EstadoCompra(BigDecimal idEstadoCompra) {
        this.idEstadoCompra = idEstadoCompra;
    }

    public EstadoCompra(BigDecimal idEstadoCompra, String descripcion) {
        this.idEstadoCompra = idEstadoCompra;
        this.descripcion = descripcion;
    }

    public BigDecimal getIdEstadoCompra() {
        return idEstadoCompra;
    }

    public void setIdEstadoCompra(BigDecimal idEstadoCompra) {
        this.idEstadoCompra = idEstadoCompra;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<CorreoEstado> getCorreoEstadoCollection() {
        return correoEstadoCollection;
    }

    public void setCorreoEstadoCollection(Collection<CorreoEstado> correoEstadoCollection) {
        this.correoEstadoCollection = correoEstadoCollection;
    }

    @XmlTransient
    public Collection<Compra> getCompraCollection() {
        return compraCollection;
    }

    public void setCompraCollection(Collection<Compra> compraCollection) {
        this.compraCollection = compraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoCompra != null ? idEstadoCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoCompra)) {
            return false;
        }
        EstadoCompra other = (EstadoCompra) object;
        if ((this.idEstadoCompra == null && other.idEstadoCompra != null) || (this.idEstadoCompra != null && !this.idEstadoCompra.equals(other.idEstadoCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.EstadoCompra[ idEstadoCompra=" + idEstadoCompra + " ]";
    }
    
}
