/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "BOLETA_PRODPEDIDO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BoletaProdpedido.findAll", query = "SELECT b FROM BoletaProdpedido b")
    , @NamedQuery(name = "BoletaProdpedido.findByIdBoletaProdpedido", query = "SELECT b FROM BoletaProdpedido b WHERE b.idBoletaProdpedido = :idBoletaProdpedido")})
public class BoletaProdpedido implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_BOLETA_PRODPEDIDO")
    private BigDecimal idBoletaProdpedido;
    @JoinColumn(name = "ID_BOLETA", referencedColumnName = "ID_BOLETA")
    @ManyToOne
    private Boleta idBoleta;
    @JoinColumn(name = "ID_PRODUCTO_PEDIDO", referencedColumnName = "ID_PRODUCTO_PEDIDO")
    @ManyToOne
    private ProductoPedido idProductoPedido;

    public BoletaProdpedido() {
    }

    public BoletaProdpedido(BigDecimal idBoletaProdpedido) {
        this.idBoletaProdpedido = idBoletaProdpedido;
    }

    public BigDecimal getIdBoletaProdpedido() {
        return idBoletaProdpedido;
    }

    public void setIdBoletaProdpedido(BigDecimal idBoletaProdpedido) {
        this.idBoletaProdpedido = idBoletaProdpedido;
    }

    public Boleta getIdBoleta() {
        return idBoleta;
    }

    public void setIdBoleta(Boleta idBoleta) {
        this.idBoleta = idBoleta;
    }

    public ProductoPedido getIdProductoPedido() {
        return idProductoPedido;
    }

    public void setIdProductoPedido(ProductoPedido idProductoPedido) {
        this.idProductoPedido = idProductoPedido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBoletaProdpedido != null ? idBoletaProdpedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BoletaProdpedido)) {
            return false;
        }
        BoletaProdpedido other = (BoletaProdpedido) object;
        if ((this.idBoletaProdpedido == null && other.idBoletaProdpedido != null) || (this.idBoletaProdpedido != null && !this.idBoletaProdpedido.equals(other.idBoletaProdpedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.BoletaProdpedido[ idBoletaProdpedido=" + idBoletaProdpedido + " ]";
    }
    
}
