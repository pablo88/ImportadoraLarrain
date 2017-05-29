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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
 * @author P_Silva
 */
@Entity
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuario.findByCorreo", query = "SELECT u FROM Usuario u WHERE u.correo = :correo"),
    @NamedQuery(name = "Usuario.findByActiva", query = "SELECT u FROM Usuario u WHERE u.activa = :activa"),
    @NamedQuery(name = "Usuario.findByKeyActivacion", query = "SELECT u FROM Usuario u WHERE u.keyActivacion = :keyActivacion")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_USUARIO")
    private BigDecimal idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "CORREO")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "PASS")
    private String pass;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACTIVA")
    private BigInteger activa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "KEY_ACTIVACION")
    private String keyActivacion;
    @OneToMany(mappedBy = "idUsuario")
    private Collection<Administrador> administradorCollection;
    @OneToMany(mappedBy = "idUsuario")
    private Collection<Vendedor> vendedorCollection;
    @OneToMany(mappedBy = "idUsuario")
    private Collection<Cliente> clienteCollection;
    @OneToMany(mappedBy = "idUsuario")
    private Collection<Proveedores> proveedoresCollection;
    @OneToMany(mappedBy = "idUsuario")
    private Collection<EncargadoBodega> encargadoBodegaCollection;
    @OneToMany(mappedBy = "idUsuario")
    private Collection<Supervisor> supervisorCollection;
    @OneToMany(mappedBy = "idUsuario")
    private Collection<Agente> agenteCollection;

    public Usuario() {
    }

    public Usuario(BigDecimal idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(BigDecimal idUsuario, String correo, String pass, BigInteger activa, String keyActivacion) {
        this.idUsuario = idUsuario;
        this.correo = correo;
        this.pass = pass;
        this.activa = activa;
        this.keyActivacion = keyActivacion;
    }

    public BigDecimal getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(BigDecimal idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public BigInteger getActiva() {
        return activa;
    }

    public void setActiva(BigInteger activa) {
        this.activa = activa;
    }

    public String getKeyActivacion() {
        return keyActivacion;
    }

    public void setKeyActivacion(String keyActivacion) {
        this.keyActivacion = keyActivacion;
    }

    @XmlTransient
    public Collection<Administrador> getAdministradorCollection() {
        return administradorCollection;
    }

    public void setAdministradorCollection(Collection<Administrador> administradorCollection) {
        this.administradorCollection = administradorCollection;
    }

    @XmlTransient
    public Collection<Vendedor> getVendedorCollection() {
        return vendedorCollection;
    }

    public void setVendedorCollection(Collection<Vendedor> vendedorCollection) {
        this.vendedorCollection = vendedorCollection;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    @XmlTransient
    public Collection<Proveedores> getProveedoresCollection() {
        return proveedoresCollection;
    }

    public void setProveedoresCollection(Collection<Proveedores> proveedoresCollection) {
        this.proveedoresCollection = proveedoresCollection;
    }

    @XmlTransient
    public Collection<EncargadoBodega> getEncargadoBodegaCollection() {
        return encargadoBodegaCollection;
    }

    public void setEncargadoBodegaCollection(Collection<EncargadoBodega> encargadoBodegaCollection) {
        this.encargadoBodegaCollection = encargadoBodegaCollection;
    }

    @XmlTransient
    public Collection<Supervisor> getSupervisorCollection() {
        return supervisorCollection;
    }

    public void setSupervisorCollection(Collection<Supervisor> supervisorCollection) {
        this.supervisorCollection = supervisorCollection;
    }

    @XmlTransient
    public Collection<Agente> getAgenteCollection() {
        return agenteCollection;
    }

    public void setAgenteCollection(Collection<Agente> agenteCollection) {
        this.agenteCollection = agenteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
