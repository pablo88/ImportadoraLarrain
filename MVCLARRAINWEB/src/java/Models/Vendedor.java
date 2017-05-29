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
@Table(name = "VENDEDOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendedor.findAll", query = "SELECT v FROM Vendedor v")
    , @NamedQuery(name = "Vendedor.findByIdVendedor", query = "SELECT v FROM Vendedor v WHERE v.idVendedor = :idVendedor")
    , @NamedQuery(name = "Vendedor.findByNombreVendedor", query = "SELECT v FROM Vendedor v WHERE v.nombreVendedor = :nombreVendedor")
    , @NamedQuery(name = "Vendedor.findByAppVendedor", query = "SELECT v FROM Vendedor v WHERE v.appVendedor = :appVendedor")
    , @NamedQuery(name = "Vendedor.findByApmVendedor", query = "SELECT v FROM Vendedor v WHERE v.apmVendedor = :apmVendedor")
    , @NamedQuery(name = "Vendedor.findByCorreoVendedor", query = "SELECT v FROM Vendedor v WHERE v.correoVendedor = :correoVendedor")})
public class Vendedor implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_VENDEDOR")
    private BigDecimal idVendedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "NOMBRE_VENDEDOR")
    private String nombreVendedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "APP_VENDEDOR")
    private String appVendedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "APM_VENDEDOR")
    private String apmVendedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 125)
    @Column(name = "CORREO_VENDEDOR")
    private String correoVendedor;
    @JoinColumn(name = "ID_SUCURSAL", referencedColumnName = "ID_SUCURSAL")
    @ManyToOne(optional = false)
    private Sucursal idSucursal;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario idUsuario;
    @OneToMany(mappedBy = "idVendedor")
    private List<Pedido> pedidoList;

    public Vendedor() {
    }

    public Vendedor(BigDecimal idVendedor) {
        this.idVendedor = idVendedor;
    }

    public Vendedor(BigDecimal idVendedor, String nombreVendedor, String appVendedor, String apmVendedor, String correoVendedor) {
        this.idVendedor = idVendedor;
        this.nombreVendedor = nombreVendedor;
        this.appVendedor = appVendedor;
        this.apmVendedor = apmVendedor;
        this.correoVendedor = correoVendedor;
    }

    public BigDecimal getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(BigDecimal idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public String getAppVendedor() {
        return appVendedor;
    }

    public void setAppVendedor(String appVendedor) {
        this.appVendedor = appVendedor;
    }

    public String getApmVendedor() {
        return apmVendedor;
    }

    public void setApmVendedor(String apmVendedor) {
        this.apmVendedor = apmVendedor;
    }

    public String getCorreoVendedor() {
        return correoVendedor;
    }

    public void setCorreoVendedor(String correoVendedor) {
        this.correoVendedor = correoVendedor;
    }

    public Sucursal getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Sucursal idSucursal) {
        this.idSucursal = idSucursal;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
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
        hash += (idVendedor != null ? idVendedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendedor)) {
            return false;
        }
        Vendedor other = (Vendedor) object;
        if ((this.idVendedor == null && other.idVendedor != null) || (this.idVendedor != null && !this.idVendedor.equals(other.idVendedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Vendedor[ idVendedor=" + idVendedor + " ]";
    }
    
}
