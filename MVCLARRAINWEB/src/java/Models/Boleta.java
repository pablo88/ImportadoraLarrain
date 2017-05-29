/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "BOLETA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Boleta.findAll", query = "SELECT b FROM Boleta b"),
    @NamedQuery(name = "Boleta.findByIdBoleta", query = "SELECT b FROM Boleta b WHERE b.idBoleta = :idBoleta"),
    @NamedQuery(name = "Boleta.findByFechaBoleta", query = "SELECT b FROM Boleta b WHERE b.fechaBoleta = :fechaBoleta"),
    @NamedQuery(name = "Boleta.findByMonto", query = "SELECT b FROM Boleta b WHERE b.monto = :monto"),
    @NamedQuery(name = "Boleta.findByNumeroBoletaFiscal", query = "SELECT b FROM Boleta b WHERE b.numeroBoletaFiscal = :numeroBoletaFiscal")})
public class Boleta implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_BOLETA")
    private BigDecimal idBoleta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_BOLETA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaBoleta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MONTO")
    private BigInteger monto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMERO_BOLETA_FISCAL")
    private BigInteger numeroBoletaFiscal;
    @OneToMany(mappedBy = "idBoleta")
    private Collection<BoletaProdCompra> boletaProdCompraCollection;
    @OneToMany(mappedBy = "idBoleta")
    private Collection<BoletaProdpedido> boletaProdpedidoCollection;
    @OneToMany(mappedBy = "idBoleta")
    private Collection<Pago> pagoCollection;

    public Boleta() {
    }

    public Boleta(BigDecimal idBoleta) {
        this.idBoleta = idBoleta;
    }

    public Boleta(BigDecimal idBoleta, Date fechaBoleta, BigInteger monto, BigInteger numeroBoletaFiscal) {
        this.idBoleta = idBoleta;
        this.fechaBoleta = fechaBoleta;
        this.monto = monto;
        this.numeroBoletaFiscal = numeroBoletaFiscal;
    }

    public BigDecimal getIdBoleta() {
        return idBoleta;
    }

    public void setIdBoleta(BigDecimal idBoleta) {
        this.idBoleta = idBoleta;
    }

    public Date getFechaBoleta() {
        return fechaBoleta;
    }

    public void setFechaBoleta(Date fechaBoleta) {
        this.fechaBoleta = fechaBoleta;
    }

    public BigInteger getMonto() {
        return monto;
    }

    public void setMonto(BigInteger monto) {
        this.monto = monto;
    }

    public BigInteger getNumeroBoletaFiscal() {
        return numeroBoletaFiscal;
    }

    public void setNumeroBoletaFiscal(BigInteger numeroBoletaFiscal) {
        this.numeroBoletaFiscal = numeroBoletaFiscal;
    }

    @XmlTransient
    public Collection<BoletaProdCompra> getBoletaProdCompraCollection() {
        return boletaProdCompraCollection;
    }

    public void setBoletaProdCompraCollection(Collection<BoletaProdCompra> boletaProdCompraCollection) {
        this.boletaProdCompraCollection = boletaProdCompraCollection;
    }

    @XmlTransient
    public Collection<BoletaProdpedido> getBoletaProdpedidoCollection() {
        return boletaProdpedidoCollection;
    }

    public void setBoletaProdpedidoCollection(Collection<BoletaProdpedido> boletaProdpedidoCollection) {
        this.boletaProdpedidoCollection = boletaProdpedidoCollection;
    }

    @XmlTransient
    public Collection<Pago> getPagoCollection() {
        return pagoCollection;
    }

    public void setPagoCollection(Collection<Pago> pagoCollection) {
        this.pagoCollection = pagoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBoleta != null ? idBoleta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Boleta)) {
            return false;
        }
        Boleta other = (Boleta) object;
        if ((this.idBoleta == null && other.idBoleta != null) || (this.idBoleta != null && !this.idBoleta.equals(other.idBoleta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Boleta[ idBoleta=" + idBoleta + " ]";
    }
    
}
