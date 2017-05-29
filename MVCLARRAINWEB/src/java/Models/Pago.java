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
 * @author Home
 */
@Entity
@Table(name = "PAGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pago.findAll", query = "SELECT p FROM Pago p")
    , @NamedQuery(name = "Pago.findByIdPago", query = "SELECT p FROM Pago p WHERE p.idPago = :idPago")
    , @NamedQuery(name = "Pago.findByMonto", query = "SELECT p FROM Pago p WHERE p.monto = :monto")
    , @NamedQuery(name = "Pago.findByCuotas", query = "SELECT p FROM Pago p WHERE p.cuotas = :cuotas")
    , @NamedQuery(name = "Pago.findByCantCuotas", query = "SELECT p FROM Pago p WHERE p.cantCuotas = :cantCuotas")})
public class Pago implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PAGO")
    private BigDecimal idPago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MONTO")
    private BigInteger monto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CUOTAS")
    private BigInteger cuotas;
    @Column(name = "CANT_CUOTAS")
    private BigInteger cantCuotas;
    @JoinColumn(name = "ID_BOLETA", referencedColumnName = "ID_BOLETA")
    @ManyToOne
    private Boleta idBoleta;
    @JoinColumn(name = "ID_TIPO_PAGO", referencedColumnName = "ID_TIPO_PAGO")
    @ManyToOne(optional = false)
    private TipoPago idTipoPago;

    public Pago() {
    }

    public Pago(BigDecimal idPago) {
        this.idPago = idPago;
    }

    public Pago(BigDecimal idPago, BigInteger monto, BigInteger cuotas) {
        this.idPago = idPago;
        this.monto = monto;
        this.cuotas = cuotas;
    }

    public BigDecimal getIdPago() {
        return idPago;
    }

    public void setIdPago(BigDecimal idPago) {
        this.idPago = idPago;
    }

    public BigInteger getMonto() {
        return monto;
    }

    public void setMonto(BigInteger monto) {
        this.monto = monto;
    }

    public BigInteger getCuotas() {
        return cuotas;
    }

    public void setCuotas(BigInteger cuotas) {
        this.cuotas = cuotas;
    }

    public BigInteger getCantCuotas() {
        return cantCuotas;
    }

    public void setCantCuotas(BigInteger cantCuotas) {
        this.cantCuotas = cantCuotas;
    }

    public Boleta getIdBoleta() {
        return idBoleta;
    }

    public void setIdBoleta(Boleta idBoleta) {
        this.idBoleta = idBoleta;
    }

    public TipoPago getIdTipoPago() {
        return idTipoPago;
    }

    public void setIdTipoPago(TipoPago idTipoPago) {
        this.idTipoPago = idTipoPago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPago != null ? idPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pago)) {
            return false;
        }
        Pago other = (Pago) object;
        if ((this.idPago == null && other.idPago != null) || (this.idPago != null && !this.idPago.equals(other.idPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Pago[ idPago=" + idPago + " ]";
    }
    
}
