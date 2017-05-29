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
@Table(name = "CLIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByIdCliente", query = "SELECT c FROM Cliente c WHERE c.idCliente = :idCliente")
    , @NamedQuery(name = "Cliente.findByNombreCliente", query = "SELECT c FROM Cliente c WHERE c.nombreCliente = :nombreCliente")
    , @NamedQuery(name = "Cliente.findByAppCliente", query = "SELECT c FROM Cliente c WHERE c.appCliente = :appCliente")
    , @NamedQuery(name = "Cliente.findByApmCliente", query = "SELECT c FROM Cliente c WHERE c.apmCliente = :apmCliente")
    , @NamedQuery(name = "Cliente.findByRutCliente", query = "SELECT c FROM Cliente c WHERE c.rutCliente = :rutCliente")
    , @NamedQuery(name = "Cliente.findByCorreoCliente", query = "SELECT c FROM Cliente c WHERE c.correoCliente = :correoCliente")
    , @NamedQuery(name = "Cliente.findByDireccionCliente", query = "SELECT c FROM Cliente c WHERE c.direccionCliente = :direccionCliente")
    , @NamedQuery(name = "Cliente.findByTelefono", query = "SELECT c FROM Cliente c WHERE c.telefono = :telefono")
    , @NamedQuery(name = "Cliente.findByCodigoPostal", query = "SELECT c FROM Cliente c WHERE c.codigoPostal = :codigoPostal")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CLIENTE")
    private BigDecimal idCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "NOMBRE_CLIENTE")
    private String nombreCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "APP_CLIENTE")
    private String appCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "APM_CLIENTE")
    private String apmCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "RUT_CLIENTE")
    private String rutCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "CORREO_CLIENTE")
    private String correoCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "DIRECCION_CLIENTE")
    private String direccionCliente;
    @Size(max = 15)
    @Column(name = "TELEFONO")
    private String telefono;
    @Size(max = 56)
    @Column(name = "CODIGO_POSTAL")
    private String codigoPostal;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario idUsuario;
    @OneToMany(mappedBy = "idCliente")
    private List<Compra> compraList;
    @OneToMany(mappedBy = "idCliente")
    private List<Pedido> pedidoList;

    public Cliente() {
    }

    public Cliente(BigDecimal idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(BigDecimal idCliente, String nombreCliente, String appCliente, String apmCliente, String rutCliente, String correoCliente, String direccionCliente) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.appCliente = appCliente;
        this.apmCliente = apmCliente;
        this.rutCliente = rutCliente;
        this.correoCliente = correoCliente;
        this.direccionCliente = direccionCliente;
    }

    public BigDecimal getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(BigDecimal idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getAppCliente() {
        return appCliente;
    }

    public void setAppCliente(String appCliente) {
        this.appCliente = appCliente;
    }

    public String getApmCliente() {
        return apmCliente;
    }

    public void setApmCliente(String apmCliente) {
        this.apmCliente = apmCliente;
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public List<Compra> getCompraList() {
        return compraList;
    }

    public void setCompraList(List<Compra> compraList) {
        this.compraList = compraList;
    }

    @XmlTransient
    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Cliente[ idCliente=" + idCliente + " ]";
    }
    
}
