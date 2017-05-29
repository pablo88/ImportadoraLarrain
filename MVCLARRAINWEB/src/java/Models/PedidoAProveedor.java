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
@Table(name = "PEDIDO_A_PROVEEDOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PedidoAProveedor.findAll", query = "SELECT p FROM PedidoAProveedor p"),
    @NamedQuery(name = "PedidoAProveedor.findByIdPedidoProv", query = "SELECT p FROM PedidoAProveedor p WHERE p.idPedidoProv = :idPedidoProv"),
    @NamedQuery(name = "PedidoAProveedor.findByFechaPedido", query = "SELECT p FROM PedidoAProveedor p WHERE p.fechaPedido = :fechaPedido")})
public class PedidoAProveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PEDIDO_PROV")
    private BigDecimal idPedidoProv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_PEDIDO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPedido;
    @JoinColumn(name = "ID_PROVEEDOR", referencedColumnName = "ID_PROVEEDOR")
    @ManyToOne
    private Proveedores idProveedor;
    @JoinColumn(name = "ID_SUPERVISOR", referencedColumnName = "ID_SUPERVISOR")
    @ManyToOne
    private Supervisor idSupervisor;
    @OneToMany(mappedBy = "idPedidoProv")
    private Collection<ProdPedProv> prodPedProvCollection;

    public PedidoAProveedor() {
    }

    public PedidoAProveedor(BigDecimal idPedidoProv) {
        this.idPedidoProv = idPedidoProv;
    }

    public PedidoAProveedor(BigDecimal idPedidoProv, Date fechaPedido) {
        this.idPedidoProv = idPedidoProv;
        this.fechaPedido = fechaPedido;
    }

    public BigDecimal getIdPedidoProv() {
        return idPedidoProv;
    }

    public void setIdPedidoProv(BigDecimal idPedidoProv) {
        this.idPedidoProv = idPedidoProv;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Proveedores getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedores idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Supervisor getIdSupervisor() {
        return idSupervisor;
    }

    public void setIdSupervisor(Supervisor idSupervisor) {
        this.idSupervisor = idSupervisor;
    }

    @XmlTransient
    public Collection<ProdPedProv> getProdPedProvCollection() {
        return prodPedProvCollection;
    }

    public void setProdPedProvCollection(Collection<ProdPedProv> prodPedProvCollection) {
        this.prodPedProvCollection = prodPedProvCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPedidoProv != null ? idPedidoProv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PedidoAProveedor)) {
            return false;
        }
        PedidoAProveedor other = (PedidoAProveedor) object;
        if ((this.idPedidoProv == null && other.idPedidoProv != null) || (this.idPedidoProv != null && !this.idPedidoProv.equals(other.idPedidoProv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.PedidoAProveedor[ idPedidoProv=" + idPedidoProv + " ]";
    }
    
}
