/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "PRODUCTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findByIdProducto", query = "SELECT p FROM Producto p WHERE p.idProducto = :idProducto")
    , @NamedQuery(name = "Producto.findByNombreProducto", query = "SELECT p FROM Producto p WHERE p.nombreProducto = :nombreProducto")
    , @NamedQuery(name = "Producto.findByOnlineProducto", query = "SELECT p FROM Producto p WHERE p.onlineProducto = :onlineProducto")
    , @NamedQuery(name = "Producto.findByStockProducto", query = "SELECT p FROM Producto p WHERE p.stockProducto = :stockProducto")
    , @NamedQuery(name = "Producto.findByPrecioProducto", query = "SELECT p FROM Producto p WHERE p.precioProducto = :precioProducto")})
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
    @OneToMany(mappedBy = "idProducto")
    private List<ProdCompra> prodCompraList;
    @OneToMany(mappedBy = "idProducto")
    private List<ProdPedProv> prodPedProvList;
    @JoinColumn(name = "ID_LOCACION_DE_PRODUCTO", referencedColumnName = "ID_LOCACION_DE_PRODUCTO")
    @ManyToOne
    private LocacionDeProducto idLocacionDeProducto;
    @JoinColumn(name = "ID_TIPO_PRODUCTO", referencedColumnName = "ID_TIPO_PRODUCTO")
    @ManyToOne
    private TipoProducto idTipoProducto;
    @OneToMany(mappedBy = "idProducto")
    private List<ProductoPedido> productoPedidoList;
    @OneToMany(mappedBy = "idProducto")
    private List<ProductoRegBodeg> productoRegBodegList;

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

    @XmlTransient
    public List<ProdCompra> getProdCompraList() {
        return prodCompraList;
    }

    public void setProdCompraList(List<ProdCompra> prodCompraList) {
        this.prodCompraList = prodCompraList;
    }

    @XmlTransient
    public List<ProdPedProv> getProdPedProvList() {
        return prodPedProvList;
    }

    public void setProdPedProvList(List<ProdPedProv> prodPedProvList) {
        this.prodPedProvList = prodPedProvList;
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
    public List<ProductoPedido> getProductoPedidoList() {
        return productoPedidoList;
    }

    public void setProductoPedidoList(List<ProductoPedido> productoPedidoList) {
        this.productoPedidoList = productoPedidoList;
    }

    @XmlTransient
    public List<ProductoRegBodeg> getProductoRegBodegList() {
        return productoRegBodegList;
    }

    public void setProductoRegBodegList(List<ProductoRegBodeg> productoRegBodegList) {
        this.productoRegBodegList = productoRegBodegList;
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
