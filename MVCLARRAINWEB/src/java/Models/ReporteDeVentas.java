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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Home
 */
@Entity
@Table(name = "REPORTE_DE_VENTAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReporteDeVentas.findAll", query = "SELECT r FROM ReporteDeVentas r")
    , @NamedQuery(name = "ReporteDeVentas.findByIdReporteDeVentas", query = "SELECT r FROM ReporteDeVentas r WHERE r.idReporteDeVentas = :idReporteDeVentas")
    , @NamedQuery(name = "ReporteDeVentas.findByFecReporte", query = "SELECT r FROM ReporteDeVentas r WHERE r.fecReporte = :fecReporte")
    , @NamedQuery(name = "ReporteDeVentas.findByDescripcion", query = "SELECT r FROM ReporteDeVentas r WHERE r.descripcion = :descripcion")})
public class ReporteDeVentas implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_REPORTE_DE_VENTAS")
    private BigDecimal idReporteDeVentas;
    @Column(name = "FEC_REPORTE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecReporte;
    @Size(max = 128)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinColumn(name = "ID_SUCURSAL", referencedColumnName = "ID_SUCURSAL")
    @ManyToOne
    private Sucursal idSucursal;

    public ReporteDeVentas() {
    }

    public ReporteDeVentas(BigDecimal idReporteDeVentas) {
        this.idReporteDeVentas = idReporteDeVentas;
    }

    public BigDecimal getIdReporteDeVentas() {
        return idReporteDeVentas;
    }

    public void setIdReporteDeVentas(BigDecimal idReporteDeVentas) {
        this.idReporteDeVentas = idReporteDeVentas;
    }

    public Date getFecReporte() {
        return fecReporte;
    }

    public void setFecReporte(Date fecReporte) {
        this.fecReporte = fecReporte;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Sucursal getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Sucursal idSucursal) {
        this.idSucursal = idSucursal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReporteDeVentas != null ? idReporteDeVentas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReporteDeVentas)) {
            return false;
        }
        ReporteDeVentas other = (ReporteDeVentas) object;
        if ((this.idReporteDeVentas == null && other.idReporteDeVentas != null) || (this.idReporteDeVentas != null && !this.idReporteDeVentas.equals(other.idReporteDeVentas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.ReporteDeVentas[ idReporteDeVentas=" + idReporteDeVentas + " ]";
    }
    
}
