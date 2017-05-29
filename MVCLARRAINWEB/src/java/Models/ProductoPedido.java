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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Home
 */
@Entity
@Table(name = "PRODUCTO_PEDIDO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoPedido.findAll", query = "SELECT p FROM ProductoPedido p")
    , @NamedQuery(name = "ProductoPedido.findByIdProductoPedido", query = "SELECT p FROM ProductoPedido p WHERE p.idProductoPedido = :idProductoPedido")
    , @NamedQuery(name = "ProductoPedido.findByCantidad2", query = "SELECT p FROM ProductoPedido p WHERE p.cantidad2 = :cantidad2")
    , @NamedQuery(name = "ProductoPedido.findByTotal", query = "SELECT p FROM ProductoPedido p WHERE p.total = :total")})
public class ProductoPedido implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PRODUCTO_PEDIDO")
    private BigDecimal idProductoPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD2")
    private BigInteger cantidad2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTAL")
    private BigInteger total;
    @OneToMany(mappedBy = "idProductoPedido")
    private List<Despacho> despachoList;
    @OneToMany(mappedBy = "idProductoPedido")
    private List<BoletaProdpedido> boletaProdpedidoList;
    @JoinColumn(name = "ID_PEDIDO", referencedColumnName = "ID_PEDIDO")
    @ManyToOne
    private Pedido idPedido;
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")
    @ManyToOne
    private Producto idProducto;

    public ProductoPedido() {
    }

    public ProductoPedido(BigDecimal idProductoPedido) {
        this.idProductoPedido = idProductoPedido;
    }

    public ProductoPedido(BigDecimal idProductoPedido, BigInteger cantidad2, BigInteger total) {
        this.idProductoPedido = idProductoPedido;
        this.cantidad2 = cantidad2;
        this.total = total;
    }

    public BigDecimal getIdProductoPedido() {
        return idProductoPedido;
    }

    public void setIdProductoPedido(BigDecimal idProductoPedido) {
        this.idProductoPedido = idProductoPedido;
    }

    public BigInteger getCantidad2() {
        return cantidad2;
    }

    public void setCantidad2(BigInteger cantidad2) {
        this.cantidad2 = cantidad2;
    }

    public BigInteger getTotal() {
        return total;
    }

    public void setTotal(BigInteger total) {
        this.total = total;
    }

    @XmlTransient
    public List<Despacho> getDespachoList() {
        return despachoList;
    }

    public void setDespachoList(List<Despacho> despachoList) {
        this.despachoList = despachoList;
    }

    @XmlTransient
    public List<BoletaProdpedido> getBoletaProdpedidoList() {
        return boletaProdpedidoList;
    }

    public void setBoletaProdpedidoList(List<BoletaProdpedido> boletaProdpedidoList) {
        this.boletaProdpedidoList = boletaProdpedidoList;
    }

    public Pedido getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Pedido idPedido) {
        this.idPedido = idPedido;
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
        hash += (idProductoPedido != null ? idProductoPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoPedido)) {
            return false;
        }
        ProductoPedido other = (ProductoPedido) object;
        if ((this.idProductoPedido == null && other.idProductoPedido != null) || (this.idProductoPedido != null && !this.idProductoPedido.equals(other.idProductoPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.ProductoPedido[ idProductoPedido=" + idProductoPedido + " ]";
    }
    
}
