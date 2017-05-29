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
@Table(name = "REGISTRO_BODEGA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegistroBodega.findAll", query = "SELECT r FROM RegistroBodega r"),
    @NamedQuery(name = "RegistroBodega.findByIdRegistroBodega", query = "SELECT r FROM RegistroBodega r WHERE r.idRegistroBodega = :idRegistroBodega"),
    @NamedQuery(name = "RegistroBodega.findByFechaSalida", query = "SELECT r FROM RegistroBodega r WHERE r.fechaSalida = :fechaSalida"),
    @NamedQuery(name = "RegistroBodega.findByFechaEntrada", query = "SELECT r FROM RegistroBodega r WHERE r.fechaEntrada = :fechaEntrada")})
public class RegistroBodega implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_REGISTRO_BODEGA")
    private BigDecimal idRegistroBodega;
    @Column(name = "FECHA_SALIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSalida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_ENTRADA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEntrada;
    @OneToMany(mappedBy = "idRegistroBodega")
    private Collection<Despacho> despachoCollection;
    @JoinColumn(name = "ID_ENCARGADO_BODEGA", referencedColumnName = "ID_ENCARGADO_BODEGA")
    @ManyToOne
    private EncargadoBodega idEncargadoBodega;
    @JoinColumn(name = "ID_SUCURSAL", referencedColumnName = "ID_SUCURSAL")
    @ManyToOne(optional = false)
    private Sucursal idSucursal;
    @OneToMany(mappedBy = "idRegistroBodega")
    private Collection<ProductoRegBodeg> productoRegBodegCollection;

    public RegistroBodega() {
    }

    public RegistroBodega(BigDecimal idRegistroBodega) {
        this.idRegistroBodega = idRegistroBodega;
    }

    public RegistroBodega(BigDecimal idRegistroBodega, Date fechaEntrada) {
        this.idRegistroBodega = idRegistroBodega;
        this.fechaEntrada = fechaEntrada;
    }

    public BigDecimal getIdRegistroBodega() {
        return idRegistroBodega;
    }

    public void setIdRegistroBodega(BigDecimal idRegistroBodega) {
        this.idRegistroBodega = idRegistroBodega;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    @XmlTransient
    public Collection<Despacho> getDespachoCollection() {
        return despachoCollection;
    }

    public void setDespachoCollection(Collection<Despacho> despachoCollection) {
        this.despachoCollection = despachoCollection;
    }

    public EncargadoBodega getIdEncargadoBodega() {
        return idEncargadoBodega;
    }

    public void setIdEncargadoBodega(EncargadoBodega idEncargadoBodega) {
        this.idEncargadoBodega = idEncargadoBodega;
    }

    public Sucursal getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Sucursal idSucursal) {
        this.idSucursal = idSucursal;
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
        hash += (idRegistroBodega != null ? idRegistroBodega.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistroBodega)) {
            return false;
        }
        RegistroBodega other = (RegistroBodega) object;
        if ((this.idRegistroBodega == null && other.idRegistroBodega != null) || (this.idRegistroBodega != null && !this.idRegistroBodega.equals(other.idRegistroBodega))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.RegistroBodega[ idRegistroBodega=" + idRegistroBodega + " ]";
    }
    
}
