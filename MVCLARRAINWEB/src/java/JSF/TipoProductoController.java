package JSF;

import Models.TipoProducto;
import JSF.util.JsfUtil;
import JSF.util.PaginationHelper;
import JSF.util.RepeatPaginator;
import Models.Producto;
import SessionBeans.TipoProductoFacade;

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

@Named("tipoProductoController")
@SessionScoped
public class TipoProductoController implements Serializable {

    private TipoProducto current;
    private DataModel items = null;
    @EJB
    private SessionBeans.TipoProductoFacade ejbFacade;
    @EJB
    private SessionBeans.ProductoFacade ejbFacade1;
    private PaginationHelper pagination;
    private int selectedItemIndex;
    private String[] selectedProd;
    private List<TipoProducto> tipos;
    private List<Producto> productos = new ArrayList<>();
    private String alerta;
    private RepeatPaginator paginator;
    
    public String getAlerta()
    {
        return alerta;
    }
    
    public RepeatPaginator getPaginator() {
        return paginator;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    @PostConstruct
    private void init() {
        tipos = ejbFacade.findAll();
    }

    public List<TipoProducto> getTipos() {
        return tipos;
    }

    public String[] getSelectedProd() {
        return selectedProd;
    }

    public void setSelectedProd(String[] selectedProd) {
        this.selectedProd = selectedProd;
    }

    public String listaProductos() {
        productos.clear();
        for (String id : getSelectedProd()) {
            for (Producto prod : ejbFacade1.findAll()) {
                String ids = prod.getIdTipoProducto().toString().replaceAll("[^0-9]", "").trim();
                if (id.compareTo(ids) == 0) {
                    productos.add(prod);
                    alerta="";
                }
            }
        }
        if(productos.isEmpty())
        {
            alerta="<script>alert('No hay productos de ese tipo,actualmente.');</script>";
        }
        paginator = new RepeatPaginator(productos);
        return "/menusCliente/inicioC.xhtml?faces-redirect=true";
    }

    public TipoProductoController() {
    }

    public TipoProducto getSelected() {
        if (current == null) {
            current = new TipoProducto();
            selectedItemIndex = -1;
        }
        return current;
    }

    private TipoProductoFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (TipoProducto) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new TipoProducto();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("TipoProductoCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (TipoProducto) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("TipoProductoUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (TipoProducto) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("TipoProductoDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public TipoProducto getTipoProducto(java.math.BigDecimal id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = TipoProducto.class)
    public static class TipoProductoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TipoProductoController controller = (TipoProductoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tipoProductoController");
            return controller.getTipoProducto(getKey(value));
        }

        java.math.BigDecimal getKey(String value) {
            java.math.BigDecimal key;
            key = new java.math.BigDecimal(value);
            return key;
        }

        String getStringKey(java.math.BigDecimal value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof TipoProducto) {
                TipoProducto o = (TipoProducto) object;
                return getStringKey(o.getIdTipoProducto());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + TipoProducto.class.getName());
            }
        }

    }

    public List<TipoProducto> obtenerTProducto() {
        List<TipoProducto> tipos = ejbFacade.findAll();
        return tipos;
    }

}
