package JSF;

import Models.Compra;
import JSF.util.JsfUtil;
import JSF.util.PaginationHelper;
import JSF.util.RepeatPaginator;
import Models.Boleta;
import Models.BoletaProdCompra;
import Models.Cliente;
import Models.ProdCompra;
import Models.Producto;
import SessionBeans.CompraFacade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
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

@Named("compraController")
@SessionScoped
public class CompraController implements Serializable {

    private Compra current;
    private RepeatPaginator paginator;
    private DataModel items = null;
    @EJB
    private SessionBeans.CompraFacade ejbFacade;
    @EJB
    private SessionBeans.ClienteFacade cliF;
    @EJB
    private SessionBeans.ProdCompraFacade prodCF;
    @EJB
    private SessionBeans.BoletaProdCompraFacade bolPCF;
    @EJB
    private SessionBeans.BoletaFacade bolF;
    @EJB
    private SessionBeans.ProductoFacade prodf;
    private PaginationHelper pagination;
    private int selectedItemIndex;
    private String correo = null;

    public CompraController() {
    }

    public RepeatPaginator getPaginator() {
        return paginator;
    }

    public Compra getSelected() {
        if (current == null) {
            current = new Compra();
            selectedItemIndex = -1;
        }
        return current;
    }

    private CompraFacade getFacade() {
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
        current = (Compra) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Compra();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("CompraCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Compra) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("CompraUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Compra) getItems().getRowData();
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("CompraDeleted"));
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

    public Compra getCompra(java.math.BigDecimal id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Compra.class)
    public static class CompraControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CompraController controller = (CompraController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "compraController");
            return controller.getCompra(getKey(value));
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
            if (object instanceof Compra) {
                Compra o = (Compra) object;
                return getStringKey(o.getIdCompra());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Compra.class.getName());
            }
        }

    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }


    public ArrayList<ArrayList<String>> listaCompras() {
        ArrayList<ArrayList<String>> mc = new ArrayList<ArrayList<String>>();

        BigDecimal idC = BigDecimal.ZERO;
        Compra compra = new Compra();
        Boleta boleta = new Boleta();
        ArrayList<ProdCompra> prodcompra = new ArrayList<>();
        ArrayList<Producto> producto = new ArrayList<>();
        for (Cliente cli : cliF.findAll()) {
            if (cli.getCorreoCliente().compareToIgnoreCase(correo) == 0) {
                idC = cli.getIdCliente();
                break;
            }
        }
        for (Compra com : ejbFacade.findAll()) {
            ArrayList<String> datos = new ArrayList<String>();
            if (com.getIdCliente().equals(cliF.find(idC))) {
                compra = com;
                for (ProdCompra pc : prodCF.findAll()) {
                    if (pc.getIdCompra().equals(compra)) {
                        datos.add(pc.getCantidad().toString());
                        datos.add(pc.getTotal().toString());
                        producto.add(pc.getIdProducto());
                        prodcompra.add(pc);
                    }
                }

                for (ProdCompra pc : prodcompra) {
                    if (pc.getIdCompra().equals(ejbFacade.find(compra.getIdCompra()))) {
                        datos.add(pc.getIdProducto().getNombreProducto());
                    }
                }
            }
            mc.add(datos);
        }
        /*
        for (Producto p : prodf.findAll()) {

            datos.add(p.getNombreProducto());
            datos.add(p.getPrecioProducto().toString());
            mc.add(datos);
        }*/
        return mc;
    }

}
