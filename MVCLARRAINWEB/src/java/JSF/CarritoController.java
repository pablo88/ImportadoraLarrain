/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSF;

import Models.Boleta;
import Models.BoletaProdCompra;
import Models.Cliente;
import Models.Compra;
import Models.EstadoCompra;
import Models.ProdCompra;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import Models.Producto;
import Models.Usuario;
import SessionBeans.BoletaFacade;
import SessionBeans.BoletaProdCompraFacade;
import SessionBeans.ClienteFacade;
import SessionBeans.CompraFacade;
import SessionBeans.EstadoCompraFacade;
import SessionBeans.PedidoFacade;
import SessionBeans.ProdCompraFacade;
import SessionBeans.ProductoFacade;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import sun.java2d.pipe.SpanShapeRenderer;

/**
 *
 * @author Home
 */
@Named("carritoController")
@SessionScoped
public class CarritoController implements Serializable {

    @EJB
    private PedidoFacade pedidofacade;
    @EJB
    private ProductoFacade pfacade;
    @EJB
    private ClienteFacade clienteFacade_;
    @EJB
    private CompraFacade compraFacade_;
    @EJB
    private EstadoCompraFacade estadoCompraFacade_;
    @EJB
    private ProdCompraFacade productoCompraFac_;
    @EJB
    private BoletaFacade boletaFacade_;
    @EJB
    private BoletaProdCompraFacade boletaprodCompraFac_;
    @EJB
    private ProductoFacade productoFacade;
    /**
     * Atributos utiles para el controlador Carrito
     */
    @Inject
    private ProductoController productoController;
    @Inject
    private UsuarioController usuarioController;
    private Usuario usuario_ = new Usuario();
    private Cliente cliente_ = new Cliente();
    private Compra compra_ = new Compra();
    private Boleta boleta_ = new Boleta();
    private BoletaProdCompra bolProdComp_ = new BoletaProdCompra();
    private ProdCompra prodCompra_ = new ProdCompra();
    private ArrayList<Producto> carrito = new ArrayList<Producto>();
    private String id;
    private Producto productoSelecionado;
    private BigDecimal idProductoSeleccionado;
    private BigDecimal totalCompra = BigDecimal.valueOf(0);
    private String alerta = "";
    private int cantidad = 1;
    private String correo_;
    private ArrayList<Integer> cantidades= new ArrayList<>();
    private boolean compStock = false;

    public boolean getCompStock() {
        return compStock;
    }

    public void setCompStock(boolean compStock) {
        this.compStock = compStock;
    }

    public void clear() {
        alerta = null;
    }

    @PostConstruct
    public void init() {
        alerta = "";
    }

    public CarritoController() {
        alerta = "";
    }

    public String quitardelCarrito(BigDecimal idProducto) {
        setIdProductoSeleccionado(idProducto);
        for (Producto producto : carrito) {
            if (producto.getIdProducto() == idProducto) {
                carrito.remove(producto);
                break;
            }
        }
        return "carrito.xhtml?faces-redirect=true";
    }

//metodos
    public String comprar() {
        FacesContext context = FacesContext.getCurrentInstance();
        correo_ = context.getExternalContext().getSessionMap().get("sesion").toString();
        usuario_ = usuarioController.buscarUsuarioParaBoleta(correo_);
        cliente_ = clienteFacade_.find(usuario_.getIdUsuario());
        DateFormat dt = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date_ = new Date();
        int i = 0;
        
        for (Integer cantidade : cantidades) {
            if ((carrito.get(i).getStockProducto().compareTo(new BigInteger("" + cantidade)) == 1) || (carrito.get(i).getStockProducto().compareTo(new BigInteger("" + cantidade)) == 0)) {
                compra_.setFechaCompra(new Date(dt.format(date_)));
                compra_.setIdCliente(cliente_);
                compra_.setIdCompra(BigDecimal.ONE);
                if(carrito.get(i).getOnlineProducto().compareTo(BigInteger.ZERO)==0){
                    compra_.setIdEstadoCompra(estadoCompraFacade_.find(new BigDecimal(2)));
                }
                else
                {
                    compra_.setIdEstadoCompra(estadoCompraFacade_.find(new BigDecimal(0)));
                }
                compraFacade_.create(compra_);

                prodCompra_.setIdProductosCompra(BigDecimal.ZERO);
                prodCompra_.setIdCompra(compraFacade_.findAll().get(compraFacade_.findAll().size() - 1));
                prodCompra_.setIdProducto(carrito.get(i));
                prodCompra_.setCantidad(new BigInteger(cantidade.toString()));
                prodCompra_.setTotal(carrito.get(i).getPrecioProducto().multiply(BigInteger.valueOf(cantidade)));
                productoCompraFac_.create(prodCompra_);

                boleta_.setFechaBoleta(new Date(dt.format(date_)));
                boleta_.setIdBoleta(BigDecimal.ZERO);
                boleta_.setMonto(new BigInteger(totalCompra.toString()));
                boleta_.setNumeroBoletaFiscal(new BigInteger(crearRandom()));
                boletaFacade_.create(boleta_);
                
               
                
                bolProdComp_.setIdBoleta(boletaFacade_.findAll().get(boletaFacade_.findAll().size() - 1));
                context = FacesContext.getCurrentInstance();
                context.getExternalContext().getSessionMap().put("boleta", bolProdComp_.getIdBoleta().getIdBoleta().toPlainString());
                bolProdComp_.setIdBoletaCompra(BigDecimal.ZERO);
                for (ProdCompra pc : productoCompraFac_.findAll()) {
                    if (pc.getIdCompra().toString().compareToIgnoreCase(prodCompra_.getIdCompra().toString()) == 0) {
                        bolProdComp_.setIdProductosCompra(pc);
                    }
                }
                boletaprodCompraFac_.create(bolProdComp_);
                carrito.get(i).setStockProducto(carrito.get(i).getStockProducto().subtract(new BigInteger("" + cantidade)));
                productoFacade.edit(carrito.get(i));
                i++;
                alerta = "<script></script>";
            } else {
                alerta = "<script>alert('Su pedido supera nuestro stock');</script>";
                return "carrito.xhtml?faces-redirect=true";
            }
        }
        return "pago.xhtml?faces-redirect=true";
    }

    private String crearRandom() {
        int passwordSize = 15;
        char[] chars = "0123456789".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < passwordSize; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String output = sb.toString();
        return output;
    }

    public void agregarAlCarrito(BigDecimal idProducto) {
        PagoController pago = new PagoController();
        pago.setAlerta(null);
        setIdProductoSeleccionado(idProducto);
        Producto p = buscarProductoCarrito(getIdProductoSeleccionado());
        if (p != null && Integer.valueOf(p.getStockProducto().toString()) > 0) {
            setTotalCompra(getTotalCompra().add(new BigDecimal(p.getPrecioProducto().doubleValue())));
        } else {
            setProductoSelecionado(productoController.buscarProductoParaElCarrito(getIdProductoSeleccionado()));
            if (Integer.valueOf(getProductoSelecionado().getStockProducto().toString()) > 0) {
                getCarrito().add(getProductoSelecionado());
                setTotalCompra(getTotalCompra().add(new BigDecimal(getProductoSelecionado().getPrecioProducto().doubleValue())));
                alerta = "<script>confirmar = confirm('Producto añadido.\\n¿Desea finalizar su compra?');\n"
                        + "if (confirmar)\n"
                        + "{\n"
                        + "window.open(\"http://localhost:7001/MVCLARRAINWEB/faces/menusCliente/carrito.xhtml\",'_self');\n"
                        + "}</script>";
            }
            if (Integer.valueOf(getProductoSelecionado().getStockProducto().toString()) < 1) {
                alerta = "<script>alert('No hay Stock');</script>";
            }
        }
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

    /* public void cotizar() {
        BigDecimal total = BigDecimal.valueOf(0);
        int i = 0;
        for (Producto prod : carrito) {
            total = total.add(new BigDecimal(prod.getPrecioProducto().multiply(BigInteger.valueOf(cantidades.get(i)))));
            i++;
        }
        this.totalCompra = total;
        return;
        //return "carrito.xhtml?faces-redirect=true";
    }*/
    /**
     * @return the cantidades
     */
    public List<Integer> getCantidades() {
        cantidades = new ArrayList<>();
        return cantidades;
    }

    /**
     * @param cantidades the cantidades to set
     */
    public void setCantidades(ArrayList <Integer> cantidades) {
        this.cantidades = cantidades;
    }

    /**
     * @return the correo_
     */
    public String getCorreo_() {
        return correo_;
    }

    /**
     * @param correo_ the correo_ to set
     */
    public void setCorreo_(String correo_) {
        this.correo_ = correo_;
    }

}
