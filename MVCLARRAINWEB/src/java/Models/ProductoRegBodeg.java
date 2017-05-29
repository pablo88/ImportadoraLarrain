/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Home
 */
@Entity
@Table(name = "PRODUCTO_REG_BODEG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoRegBodeg.findAll", query = "SELECT p FROM ProductoRegBodeg p")
    , @NamedQuery(name = "ProductoRegBodeg.findByIdProductoRegBodeg", query = "SELECT p FROM ProductoRegBodeg p WHERE p.idProductoRegBodeg = :idProductoRegBodeg")
    , @NamedQuery(name = "ProductoRegBodeg.findByCantidad", query = "SELECT p FROM ProductoRegBodeg p WHERE p.cantidad = :cantidad")})
public class ProductoRegBodeg implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PRODUCTO_REG_BODEG")
    private BigDecimal idProductoRegBodeg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")
    @ManyToOne
    private Producto idProducto;
    @JoinColumn(name = "ID_REGISTRO_BODEGA", referencedColumnName = "ID_REGISTRO_BODEGA")
    @ManyToOne
    private RegistroBodega idRegistroBodega;

    public ProductoRegBodeg() {
    }

    public ProductoRegBodeg(BigDecimal idProductoRegBodeg) {
        this.idProductoRegBodeg = idProductoRegBodeg;
    }

    public ProductoRegBodeg(BigDecimal idProductoRegBodeg, BigInteger cantidad) {
        this.idProductoRegBodeg = idProductoRegBodeg;
        this.cantidad = cantidad;
    }

    public BigDecimal getIdProductoRegBodeg() {
        return idProductoRegBodeg;
    }

    public void setIdProductoRegBodeg(BigDecimal idProductoRegBodeg) {
        this.idProductoRegBodeg = idProductoRegBodeg;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public RegistroBodega getIdRegistroBodega() {
        return idRegistroBodega;
    }

    public void setIdRegistroBodega(RegistroBodega idRegistroBodega) {
        this.idRegistroBodega = idRegistroBodega;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProductoRegBodeg != null ? idProductoRegBodeg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoRegBodeg)) {
            return false;
        }
        ProductoRegBodeg other = (ProductoRegBodeg) object;
        if ((this.idProductoRegBodeg == null && other.idProductoRegBodeg != null) || (this.idProductoRegBodeg != null && !this.idProductoRegBodeg.equals(other.idProductoRegBodeg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.ProductoRegBodeg[ idProductoRegBodeg=" + idProductoRegBodeg + " ]";
    }
    
}
