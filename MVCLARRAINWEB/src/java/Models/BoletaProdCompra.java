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
 * @author P_Silva
 */
@Entity
@Table(name = "BOLETA_PROD_COMPRA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BoletaProdCompra.findAll", query = "SELECT b FROM BoletaProdCompra b"),
    @NamedQuery(name = "BoletaProdCompra.findByIdBoletaCompra", query = "SELECT b FROM BoletaProdCompra b WHERE b.idBoletaCompra = :idBoletaCompra")})
public class BoletaProdCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_BOLETA_COMPRA")
    private BigDecimal idBoletaCompra;
    @JoinColumn(name = "ID_BOLETA", referencedColumnName = "ID_BOLETA")
    @ManyToOne
    private Boleta idBoleta;
    @JoinColumn(name = "ID_PRODUCTOS_COMPRA", referencedColumnName = "ID_PRODUCTOS_COMPRA")
    @ManyToOne
    private ProdCompra idProductosCompra;

    public BoletaProdCompra() {
    }

    public BoletaProdCompra(BigDecimal idBoletaCompra) {
        this.idBoletaCompra = idBoletaCompra;
    }

    public BigDecimal getIdBoletaCompra() {
        return idBoletaCompra;
    }

    public void setIdBoletaCompra(BigDecimal idBoletaCompra) {
        this.idBoletaCompra = idBoletaCompra;
    }

    public Boleta getIdBoleta() {
        return idBoleta;
    }

    public void setIdBoleta(Boleta idBoleta) {
        this.idBoleta = idBoleta;
    }

    public ProdCompra getIdProductosCompra() {
        return idProductosCompra;
    }

    public void setIdProductosCompra(ProdCompra idProductosCompra) {
        this.idProductosCompra = idProductosCompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBoletaCompra != null ? idBoletaCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BoletaProdCompra)) {
            return false;
        }
        BoletaProdCompra other = (BoletaProdCompra) object;
        if ((this.idBoletaCompra == null && other.idBoletaCompra != null) || (this.idBoletaCompra != null && !this.idBoletaCompra.equals(other.idBoletaCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.BoletaProdCompra[ idBoletaCompra=" + idBoletaCompra + " ]";
    }
    
}
