/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author P_Silva
 */
@Entity
@Table(name = "COMPRA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compra.findAll", query = "SELECT c FROM Compra c"),
    @NamedQuery(name = "Compra.findByIdCompra", query = "SELECT c FROM Compra c WHERE c.idCompra = :idCompra"),
    @NamedQuery(name = "Compra.findByFechaCompra", query = "SELECT c FROM Compra c WHERE c.fechaCompra = :fechaCompra"),
    @NamedQuery(name = "Compra.allDatosCompra", query = "select C.idCompra,C.idCliente,C.fechaCompra,PC.idProducto,PC.cantidad,PC.total from Compra C join FETCH C.prodCompraCollection PC "
            + "where C.idCliente= :idCliente")})

public class Compra implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_COMPRA")
    private BigDecimal idCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_COMPRA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCompra;
    @OneToMany(mappedBy = "idCompra")
    private Collection<ProdCompra> prodCompraCollection;
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE")
    @ManyToOne
    private Cliente idCliente;
    @JoinColumn(name = "ID_ESTADO_COMPRA", referencedColumnName = "ID_ESTADO_COMPRA")
    @ManyToOne
    private EstadoCompra idEstadoCompra;

    public Compra() {
    }

    public Compra(BigDecimal idCompra) {
        this.idCompra = idCompra;
    }

    public Compra(BigDecimal idCompra, Date fechaCompra) {
        this.idCompra = idCompra;
        this.fechaCompra = fechaCompra;
    }

    public Compra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public BigDecimal getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(BigDecimal idCompra) {
        this.idCompra = idCompra;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    @XmlTransient
    public Collection<ProdCompra> getProdCompraCollection() {
        return prodCompraCollection;
    }

    public void setProdCompraCollection(Collection<ProdCompra> prodCompraCollection) {
        this.prodCompraCollection = prodCompraCollection;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public EstadoCompra getIdEstadoCompra() {
        return idEstadoCompra;
    }

    public void setIdEstadoCompra(EstadoCompra idEstadoCompra) {
        this.idEstadoCompra = idEstadoCompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompra != null ? idCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        if ((this.idCompra == null && other.idCompra != null) || (this.idCompra != null && !this.idCompra.equals(other.idCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Compra[ idCompra=" + idCompra + " ]";
    }

}
