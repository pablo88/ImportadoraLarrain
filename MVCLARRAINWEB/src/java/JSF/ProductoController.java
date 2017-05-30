package JSF;

import Models.Producto;
import JSF.util.JsfUtil;
import JSF.util.PaginationHelper;
import SessionBeans.ProductoFacade;
import SessionBeans.TipoProductoFacade;
import Models.TipoProducto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("productoController")
@SessionScoped
public class ProductoController implements Serializable {

    private Producto current;
    private TipoProducto current1;
    private DataModel items = null;
    @EJB
    private SessionBeans.ProductoFacade ejbFacade;
    @EJB
    private SessionBeans.TipoProductoFacade ejbFacadeTP;
    private PaginationHelper pagination;
    private int selectedItemIndex;
    private List<Producto> productos;

    public ProductoController() {
    }

    public Producto getSelected() {
        if (current == null) {
            current = new Producto();
            selectedItemIndex = -1;
        }
        return current;
    }

    public TipoProducto getSelected1() {
        if (current1 == null) {
            current1 = new TipoProducto();
            selectedItemIndex = -1;
        }
        return current1;
    }

    private ProductoFacade getFacade() {
        return ejbFacade;
    }
    
    @PostConstruct
    private void init() {
        productos=ejbFacade.findAll();
    }
    
    public List<Producto> getProductos()
    {
        return productos;
    }
}
