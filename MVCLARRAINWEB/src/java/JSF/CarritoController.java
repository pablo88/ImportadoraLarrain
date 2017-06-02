/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSF;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import Models.Producto;
import SessionBeans.PedidoFacade;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author Home
 */
@Named("carritoController")
@SessionScoped
public class CarritoController implements Serializable{
     @EJB
    private PedidoFacade pedidofacade;
    /**
     * Atributos utiles para el controlador Carrito
     */
    @Inject
    private ProductoController productoController;
    @Inject
    private UsuarioController usuarioController;
    private ArrayList<Producto> carrito = new ArrayList<Producto>();
    private String id ;
    private Producto productoSelecionado;
    private BigDecimal idProductoSeleccionado;
    private double totalCompra = 0.0;
    
     public CarritoController() {
    }
     
     //metodos
    public String agregarAlCarrito(BigDecimal idProducto) {
        setIdProductoSeleccionado(idProducto);
        Producto p = buscarProductoCarrito(getIdProductoSeleccionado());
        if (p != null && Integer.valueOf(p.getStockProducto().toString()) > 0 ) {
            totalCompra+=p.getPrecioProducto().doubleValue();
        } else {
                setProductoSelecionado(productoController.buscarProductoParaElCarrito(getIdProductoSeleccionado()));
                if(Integer.valueOf(getProductoSelecionado().getStockProducto().toString())>0){
                    getCarrito().add(getProductoSelecionado());
                    totalCompra+=getProductoSelecionado().getPrecioProducto().doubleValue();
                }                  
        }        
        return "carritoactual";
    }
     private Producto buscarProductoCarrito(BigDecimal idProducto) {
        Producto p = null;
        for (Producto prod : getCarrito()) {
            if (prod.getIdProducto() == idProducto) {
                p = prod;
                break;
            }
        }
        return p;
    }

    /**
     * @return the productoSelecionado
     */
    public Producto getProductoSelecionado() {
        return productoSelecionado;
    }

    /**
     * @param productoSelecionado the productoSelecionado to set
     */
    public void setProductoSelecionado(Producto productoSelecionado) {
        this.productoSelecionado = productoSelecionado;
    }

    /**
     * @return the idProductoSeleccionado
     */
    public BigDecimal getIdProductoSeleccionado() {
        return idProductoSeleccionado;
    }

    /**
     * @param idProductoSeleccionado the idProductoSeleccionado to set
     */
    public void setIdProductoSeleccionado(BigDecimal idProductoSeleccionado) {
        this.idProductoSeleccionado = idProductoSeleccionado;
    }

    /**
     * @return the carrito
     */
    public ArrayList<Producto> getCarrito() {
        return carrito;
    }

    /**
     * @param carrito the carrito to set
     */
    public void setCarrito(ArrayList<Producto> carrito) {
        this.carrito = carrito;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

 
    
    
    
}
