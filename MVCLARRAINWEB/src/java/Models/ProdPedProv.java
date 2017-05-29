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
@Table(name = "PROD_PED_PROV")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProdPedProv.findAll", query = "SELECT p FROM ProdPedProv p")
    , @NamedQuery(name = "ProdPedProv.findByIdProdPedProv", query = "SELECT p FROM ProdPedProv p WHERE p.idProdPedProv = :idProdPedProv")
    , @NamedQuery(name = "ProdPedProv.findByCantidad", query = "SELECT p FROM ProdPedProv p WHERE p.cantidad = :cantidad")
    , @NamedQuery(name = "ProdPedProv.findByTotal", query = "SELECT p FROM ProdPedProv p WHERE p.total = :total")})
public class ProdPedProv implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PROD_PED_PROV")
    private BigDecimal idProdPedProv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTAL")
    private BigInteger total;
    @JoinColumn(name = "ID_PEDIDO_PROV", referencedColumnName = "ID_PEDIDO_PROV")
    @ManyToOne
    private PedidoAProveedor idPedidoProv;
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")
    @ManyToOne
    private Producto idProducto;

    public ProdPedProv() {
    }

    public ProdPedProv(BigDecimal idProdPedProv) {
        this.idProdPedProv = idProdPedProv;
    }

    public ProdPedProv(BigDecimal idProdPedProv, BigInteger cantidad, BigInteger total) {
        this.idProdPedProv = idProdPedProv;
        this.cantidad = cantidad;
        this.total = total;
    }

    public BigDecimal getIdProdPedProv() {
        return idProdPedProv;
    }

    public void setIdProdPedProv(BigDecimal idProdPedProv) {
        this.idProdPedProv = idProdPedProv;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public BigInteger getTotal() {
        return total;
    }

    public void setTotal(BigInteger total) {
        this.total = total;
    }

    public PedidoAProveedor getIdPedidoProv() {
        return idPedidoProv;
    }

    public void setIdPedidoProv(PedidoAProveedor idPedidoProv) {
        this.idPedidoProv = idPedidoProv;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProdPedProv != null ? idProdPedProv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProdPedProv)) {
            return false;
        }
        ProdPedProv other = (ProdPedProv) object;
        if ((this.idProdPedProv == null && other.idProdPedProv != null) || (this.idProdPedProv != null && !this.idProdPedProv.equals(other.idProdPedProv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.ProdPedProv[ idProdPedProv=" + idProdPedProv + " ]";
    }
    
}
