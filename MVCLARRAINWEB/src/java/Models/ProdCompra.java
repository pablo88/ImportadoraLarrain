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
@Table(name = "PROD_COMPRA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProdCompra.findAll", query = "SELECT p FROM ProdCompra p")
    , @NamedQuery(name = "ProdCompra.findByIdProductosCompra", query = "SELECT p FROM ProdCompra p WHERE p.idProductosCompra = :idProductosCompra")
    , @NamedQuery(name = "ProdCompra.findByCantidad", query = "SELECT p FROM ProdCompra p WHERE p.cantidad = :cantidad")
    , @NamedQuery(name = "ProdCompra.findByTotal", query = "SELECT p FROM ProdCompra p WHERE p.total = :total")})
public class ProdCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PRODUCTOS_COMPRA")
    private BigDecimal idProductosCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTAL")
    private BigInteger total;
    @OneToMany(mappedBy = "idProductosCompra")
    private List<Despacho> despachoList;
    @OneToMany(mappedBy = "idProductosCompra")
    private List<BoletaProdCompra> boletaProdCompraList;
    @JoinColumn(name = "ID_COMPRA", referencedColumnName = "ID_COMPRA")
    @ManyToOne
    private Compra idCompra;
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")
    @ManyToOne
    private Producto idProducto;

    public ProdCompra() {
    }

    public ProdCompra(BigDecimal idProductosCompra) {
        this.idProductosCompra = idProductosCompra;
    }

    public ProdCompra(BigDecimal idProductosCompra, BigInteger cantidad, BigInteger total) {
        this.idProductosCompra = idProductosCompra;
        this.cantidad = cantidad;
        this.total = total;
    }

    public BigDecimal getIdProductosCompra() {
        return idProductosCompra;
    }

    public void setIdProductosCompra(BigDecimal idProductosCompra) {
        this.idProductosCompra = idProductosCompra;
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

    @XmlTransient
    public List<Despacho> getDespachoList() {
        return despachoList;
    }

    public void setDespachoList(List<Despacho> despachoList) {
        this.despachoList = despachoList;
    }

    @XmlTransient
    public List<BoletaProdCompra> getBoletaProdCompraList() {
        return boletaProdCompraList;
    }

    public void setBoletaProdCompraList(List<BoletaProdCompra> boletaProdCompraList) {
        this.boletaProdCompraList = boletaProdCompraList;
    }

    public Compra getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Compra idCompra) {
        this.idCompra = idCompra;
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
        hash += (idProductosCompra != null ? idProductosCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProdCompra)) {
            return false;
        }
        ProdCompra other = (ProdCompra) object;
        if ((this.idProductosCompra == null && other.idProductosCompra != null) || (this.idProductosCompra != null && !this.idProductosCompra.equals(other.idProductosCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.ProdCompra[ idProductosCompra=" + idProductosCompra + " ]";
    }
    
}
