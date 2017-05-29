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
@Table(name = "LOCACION_DE_PRODUCTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LocacionDeProducto.findAll", query = "SELECT l FROM LocacionDeProducto l"),
    @NamedQuery(name = "LocacionDeProducto.findByIdLocacionDeProducto", query = "SELECT l FROM LocacionDeProducto l WHERE l.idLocacionDeProducto = :idLocacionDeProducto"),
    @NamedQuery(name = "LocacionDeProducto.findByDescripcion", query = "SELECT l FROM LocacionDeProducto l WHERE l.descripcion = :descripcion")})
public class LocacionDeProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_LOCACION_DE_PRODUCTO")
    private BigDecimal idLocacionDeProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(mappedBy = "idLocacionDeProducto")
    private Collection<Producto> productoCollection;

    public LocacionDeProducto() {
    }

    public LocacionDeProducto(BigDecimal idLocacionDeProducto) {
        this.idLocacionDeProducto = idLocacionDeProducto;
    }

    public LocacionDeProducto(BigDecimal idLocacionDeProducto, String descripcion) {
        this.idLocacionDeProducto = idLocacionDeProducto;
        this.descripcion = descripcion;
    }

    public BigDecimal getIdLocacionDeProducto() {
        return idLocacionDeProducto;
    }

    public void setIdLocacionDeProducto(BigDecimal idLocacionDeProducto) {
        this.idLocacionDeProducto = idLocacionDeProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Producto> getProductoCollection() {
        return productoCollection;
    }

    public void setProductoCollection(Collection<Producto> productoCollection) {
        this.productoCollection = productoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLocacionDeProducto != null ? idLocacionDeProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LocacionDeProducto)) {
            return false;
        }
        LocacionDeProducto other = (LocacionDeProducto) object;
        if ((this.idLocacionDeProducto == null && other.idLocacionDeProducto != null) || (this.idLocacionDeProducto != null && !this.idLocacionDeProducto.equals(other.idLocacionDeProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.LocacionDeProducto[ idLocacionDeProducto=" + idLocacionDeProducto + " ]";
    }
    
}
