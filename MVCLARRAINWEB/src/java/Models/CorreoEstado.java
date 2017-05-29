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
 * @author P_Silva
 */
@Entity
@Table(name = "CORREO_ESTADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CorreoEstado.findAll", query = "SELECT c FROM CorreoEstado c"),
    @NamedQuery(name = "CorreoEstado.findByIdCorreoEstado", query = "SELECT c FROM CorreoEstado c WHERE c.idCorreoEstado = :idCorreoEstado"),
    @NamedQuery(name = "CorreoEstado.findByChile", query = "SELECT c FROM CorreoEstado c WHERE c.chile = :chile"),
    @NamedQuery(name = "CorreoEstado.findByBodega", query = "SELECT c FROM CorreoEstado c WHERE c.bodega = :bodega"),
    @NamedQuery(name = "CorreoEstado.findByDespachado", query = "SELECT c FROM CorreoEstado c WHERE c.despachado = :despachado")})
public class CorreoEstado implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CORREO_ESTADO")
    private BigDecimal idCorreoEstado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CHILE")
    private BigInteger chile;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BODEGA")
    private BigInteger bodega;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DESPACHADO")
    private BigInteger despachado;
    @JoinColumn(name = "ID_ESTADO_COMPRA", referencedColumnName = "ID_ESTADO_COMPRA")
    @ManyToOne
    private EstadoCompra idEstadoCompra;

    public CorreoEstado() {
    }

    public CorreoEstado(BigDecimal idCorreoEstado) {
        this.idCorreoEstado = idCorreoEstado;
    }

    public CorreoEstado(BigDecimal idCorreoEstado, BigInteger chile, BigInteger bodega, BigInteger despachado) {
        this.idCorreoEstado = idCorreoEstado;
        this.chile = chile;
        this.bodega = bodega;
        this.despachado = despachado;
    }

    public BigDecimal getIdCorreoEstado() {
        return idCorreoEstado;
    }

    public void setIdCorreoEstado(BigDecimal idCorreoEstado) {
        this.idCorreoEstado = idCorreoEstado;
    }

    public BigInteger getChile() {
        return chile;
    }

    public void setChile(BigInteger chile) {
        this.chile = chile;
    }

    public BigInteger getBodega() {
        return bodega;
    }

    public void setBodega(BigInteger bodega) {
        this.bodega = bodega;
    }

    public BigInteger getDespachado() {
        return despachado;
    }

    public void setDespachado(BigInteger despachado) {
        this.despachado = despachado;
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
        hash += (idCorreoEstado != null ? idCorreoEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CorreoEstado)) {
            return false;
        }
        CorreoEstado other = (CorreoEstado) object;
        if ((this.idCorreoEstado == null && other.idCorreoEstado != null) || (this.idCorreoEstado != null && !this.idCorreoEstado.equals(other.idCorreoEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.CorreoEstado[ idCorreoEstado=" + idCorreoEstado + " ]";
    }
    
}
