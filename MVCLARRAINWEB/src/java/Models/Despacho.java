/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author P_Silva
 */
@Entity
@Table(name = "DESPACHO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Despacho.findAll", query = "SELECT d FROM Despacho d"),
    @NamedQuery(name = "Despacho.findByIdDespacho", query = "SELECT d FROM Despacho d WHERE d.idDespacho = :idDespacho"),
    @NamedQuery(name = "Despacho.findByFechaDespacho", query = "SELECT d FROM Despacho d WHERE d.fechaDespacho = :fechaDespacho")})
public class Despacho implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DESPACHO")
    private BigDecimal idDespacho;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_DESPACHO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDespacho;
    @JoinColumn(name = "ID_PRODUCTOS_COMPRA", referencedColumnName = "ID_PRODUCTOS_COMPRA")
    @ManyToOne
    private ProdCompra idProductosCompra;
    @JoinColumn(name = "ID_PRODUCTO_PEDIDO", referencedColumnName = "ID_PRODUCTO_PEDIDO")
    @ManyToOne
    private ProductoPedido idProductoPedido;
    @JoinColumn(name = "ID_REGISTRO_BODEGA", referencedColumnName = "ID_REGISTRO_BODEGA")
    @ManyToOne
    private RegistroBodega idRegistroBodega;

    public Despacho() {
    }

    public Despacho(BigDecimal idDespacho) {
        this.idDespacho = idDespacho;
    }

    public Despacho(BigDecimal idDespacho, Date fechaDespacho) {
        this.idDespacho = idDespacho;
        this.fechaDespacho = fechaDespacho;
    }

    public BigDecimal getIdDespacho() {
        return idDespacho;
    }

    public void setIdDespacho(BigDecimal idDespacho) {
        this.idDespacho = idDespacho;
    }

    public Date getFechaDespacho() {
        return fechaDespacho;
    }

    public void setFechaDespacho(Date fechaDespacho) {
        this.fechaDespacho = fechaDespacho;
    }

    public ProdCompra getIdProductosCompra() {
        return idProductosCompra;
    }

    public void setIdProductosCompra(ProdCompra idProductosCompra) {
        this.idProductosCompra = idProductosCompra;
    }

    public ProductoPedido getIdProductoPedido() {
        return idProductoPedido;
    }

    public void setIdProductoPedido(ProductoPedido idProductoPedido) {
        this.idProductoPedido = idProductoPedido;
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
        hash += (idDespacho != null ? idDespacho.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Despacho)) {
            return false;
        }
        Despacho other = (Despacho) object;
        if ((this.idDespacho == null && other.idDespacho != null) || (this.idDespacho != null && !this.idDespacho.equals(other.idDespacho))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Despacho[ idDespacho=" + idDespacho + " ]";
    }
    
}
