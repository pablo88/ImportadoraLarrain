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
@Table(name = "ENCARGADO_BODEGA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EncargadoBodega.findAll", query = "SELECT e FROM EncargadoBodega e")
    , @NamedQuery(name = "EncargadoBodega.findByIdEncargadoBodega", query = "SELECT e FROM EncargadoBodega e WHERE e.idEncargadoBodega = :idEncargadoBodega")
    , @NamedQuery(name = "EncargadoBodega.findByNombreEncargadoBodega", query = "SELECT e FROM EncargadoBodega e WHERE e.nombreEncargadoBodega = :nombreEncargadoBodega")
    , @NamedQuery(name = "EncargadoBodega.findByAppEncargadoBodega", query = "SELECT e FROM EncargadoBodega e WHERE e.appEncargadoBodega = :appEncargadoBodega")
    , @NamedQuery(name = "EncargadoBodega.findByApmEncargadoBodega", query = "SELECT e FROM EncargadoBodega e WHERE e.apmEncargadoBodega = :apmEncargadoBodega")
    , @NamedQuery(name = "EncargadoBodega.findByCorreoEncargadoBodega", query = "SELECT e FROM EncargadoBodega e WHERE e.correoEncargadoBodega = :correoEncargadoBodega")})
public class EncargadoBodega implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ENCARGADO_BODEGA")
    private BigDecimal idEncargadoBodega;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "NOMBRE_ENCARGADO_BODEGA")
    private String nombreEncargadoBodega;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "APP_ENCARGADO_BODEGA")
    private String appEncargadoBodega;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "APM_ENCARGADO_BODEGA")
    private String apmEncargadoBodega;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 125)
    @Column(name = "CORREO_ENCARGADO_BODEGA")
    private String correoEncargadoBodega;
    @OneToMany(mappedBy = "idEncargadoBodega")
    private List<RegistroBodega> registroBodegaList;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario idUsuario;

    public EncargadoBodega() {
    }

    public EncargadoBodega(BigDecimal idEncargadoBodega) {
        this.idEncargadoBodega = idEncargadoBodega;
    }

    public EncargadoBodega(BigDecimal idEncargadoBodega, String nombreEncargadoBodega, String appEncargadoBodega, String apmEncargadoBodega, String correoEncargadoBodega) {
        this.idEncargadoBodega = idEncargadoBodega;
        this.nombreEncargadoBodega = nombreEncargadoBodega;
        this.appEncargadoBodega = appEncargadoBodega;
        this.apmEncargadoBodega = apmEncargadoBodega;
        this.correoEncargadoBodega = correoEncargadoBodega;
    }

    public BigDecimal getIdEncargadoBodega() {
        return idEncargadoBodega;
    }

    public void setIdEncargadoBodega(BigDecimal idEncargadoBodega) {
        this.idEncargadoBodega = idEncargadoBodega;
    }

    public String getNombreEncargadoBodega() {
        return nombreEncargadoBodega;
    }

    public void setNombreEncargadoBodega(String nombreEncargadoBodega) {
        this.nombreEncargadoBodega = nombreEncargadoBodega;
    }

    public String getAppEncargadoBodega() {
        return appEncargadoBodega;
    }

    public void setAppEncargadoBodega(String appEncargadoBodega) {
        this.appEncargadoBodega = appEncargadoBodega;
    }

    public String getApmEncargadoBodega() {
        return apmEncargadoBodega;
    }

    public void setApmEncargadoBodega(String apmEncargadoBodega) {
        this.apmEncargadoBodega = apmEncargadoBodega;
    }

    public String getCorreoEncargadoBodega() {
        return correoEncargadoBodega;
    }

    public void setCorreoEncargadoBodega(String correoEncargadoBodega) {
        this.correoEncargadoBodega = correoEncargadoBodega;
    }

    @XmlTransient
    public List<RegistroBodega> getRegistroBodegaList() {
        return registroBodegaList;
    }

    public void setRegistroBodegaList(List<RegistroBodega> registroBodegaList) {
        this.registroBodegaList = registroBodegaList;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEncargadoBodega != null ? idEncargadoBodega.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EncargadoBodega)) {
            return false;
        }
        EncargadoBodega other = (EncargadoBodega) object;
        if ((this.idEncargadoBodega == null && other.idEncargadoBodega != null) || (this.idEncargadoBodega != null && !this.idEncargadoBodega.equals(other.idEncargadoBodega))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.EncargadoBodega[ idEncargadoBodega=" + idEncargadoBodega + " ]";
    }
    
}
