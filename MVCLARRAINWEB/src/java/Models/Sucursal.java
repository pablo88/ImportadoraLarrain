/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Home
 */
@Entity
@Table(name = "SUCURSAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sucursal.findAll", query = "SELECT s FROM Sucursal s")
    , @NamedQuery(name = "Sucursal.findByIdSucursal", query = "SELECT s FROM Sucursal s WHERE s.idSucursal = :idSucursal")
    , @NamedQuery(name = "Sucursal.findByNombreSucursal", query = "SELECT s FROM Sucursal s WHERE s.nombreSucursal = :nombreSucursal")
    , @NamedQuery(name = "Sucursal.findByDireccion", query = "SELECT s FROM Sucursal s WHERE s.direccion = :direccion")})
public class Sucursal implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SUCURSAL")
    private BigDecimal idSucursal;
    @Size(max = 128)
    @Column(name = "NOMBRE_SUCURSAL")
    private String nombreSucursal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "DIRECCION")
    private String direccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSucursal")
    private List<RegistroBodega> registroBodegaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSucursal")
    private List<Vendedor> vendedorList;
    @OneToMany(mappedBy = "idSucursal")
    private List<ReporteDeVentas> reporteDeVentasList;
    @JoinColumn(name = "ID_COMUNA", referencedColumnName = "ID_COMUNA")
    @ManyToOne(optional = false)
    private Comuna idComuna;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSucursal")
    private List<Supervisor> supervisorList;

    public Sucursal() {
    }

    public Sucursal(BigDecimal idSucursal) {
        this.idSucursal = idSucursal;
    }

    public Sucursal(BigDecimal idSucursal, String direccion) {
        this.idSucursal = idSucursal;
        this.direccion = direccion;
    }

    public BigDecimal getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(BigDecimal idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @XmlTransient
    public List<RegistroBodega> getRegistroBodegaList() {
        return registroBodegaList;
    }

    public void setRegistroBodegaList(List<RegistroBodega> registroBodegaList) {
        this.registroBodegaList = registroBodegaList;
    }

    @XmlTransient
    public List<Vendedor> getVendedorList() {
        return vendedorList;
    }

    public void setVendedorList(List<Vendedor> vendedorList) {
        this.vendedorList = vendedorList;
    }

    @XmlTransient
    public List<ReporteDeVentas> getReporteDeVentasList() {
        return reporteDeVentasList;
    }

    public void setReporteDeVentasList(List<ReporteDeVentas> reporteDeVentasList) {
        this.reporteDeVentasList = reporteDeVentasList;
    }

    public Comuna getIdComuna() {
        return idComuna;
    }

    public void setIdComuna(Comuna idComuna) {
        this.idComuna = idComuna;
    }

    @XmlTransient
    public List<Supervisor> getSupervisorList() {
        return supervisorList;
    }

    public void setSupervisorList(List<Supervisor> supervisorList) {
        this.supervisorList = supervisorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSucursal != null ? idSucursal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sucursal)) {
            return false;
        }
        Sucursal other = (Sucursal) object;
        if ((this.idSucursal == null && other.idSucursal != null) || (this.idSucursal != null && !this.idSucursal.equals(other.idSucursal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Sucursal[ idSucursal=" + idSucursal + " ]";
    }
    
}
