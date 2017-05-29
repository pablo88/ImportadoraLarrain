/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
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
 * @author P_Silva
 */
@Entity
@Table(name = "PRODUCTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByIdProducto", query = "SELECT p FROM Producto p WHERE p.idProducto = :idProducto"),
    @NamedQuery(name = "Producto.findByNombreProducto", query = "SELECT p FROM Producto p WHERE p.nombreProducto = :nombreProducto"),
    @NamedQuery(name = "Producto.findByOnlineProducto", query = "SELECT p FROM Producto p WHERE p.onlineProducto = :onlineProducto"),
    @NamedQuery(name = "Producto.findByStockProducto", query = "SELECT p FROM Producto p WHERE p.stockProducto = :stockProducto"),
    @NamedQuery(name = "Producto.findByPrecioProducto", query = "SELECT p FROM Producto p WHERE p.precioProducto = :precioProducto"),
    @NamedQuery(name = "Producto.findByImagenProducto", query = "SELECT p FROM Producto p WHERE p.imagenProducto = :imagenProducto")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PRODUCTO")
    private BigDecimal idProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "NOMBRE_PRODUCTO")
    private String nombreProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ONLINE_PRODUCTO")
    private BigInteger onlineProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STOCK_PRODUCTO")
    private BigInteger stockProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIO_PRODUCTO")
    private BigInteger precioProducto;
    @Size(max = 1500)
    @Column(name = "IMAGEN_PRODUCTO")
    private String imagenProducto;
    @OneToMany(mappedBy = "idProducto")
    private Collection<ProdCompra> prodCompraCollection;
    @OneToMany(mappedBy = "idProducto")
    private Collection<ProdPedProv> prodPedProvCollection;
    @JoinColumn(name = "ID_LOCACION_DE_PRODUCTO", referencedColumnName = "ID_LOCACION_DE_PRODUCTO")
    @ManyToOne
    private LocacionDeProducto idLocacionDeProducto;
    @JoinColumn(name = "ID_TIPO_PRODUCTO", referencedColumnName = "ID_TIPO_PRODUCTO")
    @ManyToOne
    private TipoProducto idTipoProducto;
    @OneToMany(mappedBy = "idProducto")
    private Collection<ProductoPedido> productoPedidoCollection;
    @OneToMany(mappedBy = "idProducto")
    private Collection<ProductoRegBodeg> productoRegBodegCollection;

    public Producto() {
    }

    public Producto(BigDecimal idProducto) {
        this.idProducto = idProducto;
    }

    public Producto(BigDecimal idProducto, String nombreProducto, BigInteger onlineProducto, BigInteger stockProducto, BigInteger precioProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.onlineProducto = onlineProducto;
        this.stockProducto = stockProducto;
        this.precioProducto = precioProducto;
    }

    public BigDecimal getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(BigDecimal idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public BigInteger getOnlineProducto() {
        return onlineProducto;
    }

    public void setOnlineProducto(BigInteger onlineProducto) {
        this.onlineProducto = onlineProducto;
    }

    public BigInteger getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(BigInteger stockProducto) {
        this.stockProducto = stockProducto;
    }

    public BigInteger getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(BigInteger precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getImagenProducto() {
        return imagenProducto;
    }

    public void setImagenProducto(String imagenProducto) {
        this.imagenProducto = imagenProducto;
    }

    @XmlTransient
    public Collection<ProdCompra> getProdCompraCollection() {
        return prodCompraCollection;
    }

    public void setProdCompraCollection(Collection<ProdCompra> prodCompraCollection) {
        this.prodCompraCollection = prodCompraCollection;
    }

    @XmlTransient
    public Collection<ProdPedProv> getProdPedProvCollection() {
        return prodPedProvCollection;
    }

    public void setProdPedProvCollection(Collection<ProdPedProv> prodPedProvCollection) {
        this.prodPedProvCollection = prodPedProvCollection;
    }

    public LocacionDeProducto getIdLocacionDeProducto() {
        return idLocacionDeProducto;
    }

    public void setIdLocacionDeProducto(LocacionDeProducto idLocacionDeProducto) {
        this.idLocacionDeProducto = idLocacionDeProducto;
    }

    public TipoProducto getIdTipoProducto() {
        return idTipoProducto;
    }

    public void setIdTipoProducto(TipoProducto idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }

    @XmlTransient
    public Collection<ProductoPedido> getProductoPedidoCollection() {
        return productoPedidoCollection;
    }

    public void setProductoPedidoCollection(Collection<ProductoPedido> productoPedidoCollection) {
        this.productoPedidoCollection = productoPedidoCollection;
    }

    @XmlTransient
    public Collection<ProductoRegBodeg> getProductoRegBodegCollection() {
        return productoRegBodegCollection;
    }

    public void setProductoRegBodegCollection(Collection<ProductoRegBodeg> productoRegBodegCollection) {
        this.productoRegBodegCollection = productoRegBodegCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Producto[ idProducto=" + idProducto + " ]";
    }
    
}
