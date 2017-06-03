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
public class CarritoController implements Serializable {

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
    private String id;
    private Producto productoSelecionado;
    private BigDecimal idProductoSeleccionado;
    private BigDecimal totalCompra = BigDecimal.valueOf(0);
    private String alerta = null;
    private int cantidad = 1;
    private List<Integer> cantidades = new ArrayList<>();

    public void clear()
    {
        alerta=null;
    }
    public CarritoController() {
        alerta = null;
    }
    
    public String quitardelCarrito(BigDecimal idProducto)
    {
        setIdProductoSeleccionado(idProducto);
        for (Producto producto : carrito) {
            if(producto.getIdProducto() == idProducto)
            {
                carrito.remove(producto);
                break;
            }
        }
        cotizar();
        return "carrito.xhtml?faces-redirect=true";
    }
    //metodos
    public void agregarAlCarrito(BigDecimal idProducto) {
        alerta = null;
        setIdProductoSeleccionado(idProducto);
        Producto p = buscarProductoCarrito(getIdProductoSeleccionado());
        if (p != null && Integer.valueOf(p.getStockProducto().toString()) > 0) {
            setTotalCompra(getTotalCompra().add(new BigDecimal(p.getPrecioProducto().doubleValue())));
        } else {
            setProductoSelecionado(productoController.buscarProductoParaElCarrito(getIdProductoSeleccionado()));
            if (Integer.valueOf(getProductoSelecionado().getStockProducto().toString()) > 0) {
                getCarrito().add(getProductoSelecionado());
                setTotalCompra(getTotalCompra().add(new BigDecimal(getProductoSelecionado().getPrecioProducto().doubleValue())));
            } else {
                alerta = "<script>confirm('No hay stock.');</script>";
                return;
            }
        }
        alerta = "<script>confirmar=confirm('Producto añadido.\\n¿Desea finalizar su compra?');\n"
                + "if(confirmar)\n"
                + "window.location.href = \"../menusCliente/carrito.xhtml\";</script>";
        return;
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

    /**
     * @return the alerta
     */
    public String getAlerta() {
        return alerta;
    }

    /**
     * @param alerta the alerta to set
     */
    public void setAlerta(String alerta) {
        this.alerta = alerta;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.getCantidades().add(cantidad);
        cantidad = 0;
    }

    /**
     * @return the totalCompra
     */
    public BigDecimal getTotalCompra() {
        return totalCompra;
    }

    /**
     * @param totalCompra the totalCompra to set
     */
    public void setTotalCompra(BigDecimal totalCompra) {
        this.totalCompra = totalCompra;
    }

    public String cotizar() {
        BigDecimal total = BigDecimal.valueOf(0);
        int i = 0;
        for (Producto prod : carrito) {
            total = total.add(new BigDecimal(prod.getPrecioProducto().multiply(BigInteger.valueOf(cantidades.get(i)))));
            i++;
        }
        this.totalCompra = total;
        cantidades.clear();
        return "carrito.xhtml?faces-redirect=true";
    }

    /**
     * @return the cantidades
     */
    public List<Integer> getCantidades() {
        return cantidades;
    }

    /**
     * @param cantidades the cantidades to set
     */
    public void setCantidades(List<Integer> cantidades) {
        this.cantidades = cantidades;
    }

}
