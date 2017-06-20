/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSF;

import Models.Administrador;
import Models.Usuario;
import SessionBeans.UsuarioFacade;
import java.io.Serializable;
import java.math.BigInteger;
import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author P_Silva
 */
@ManagedBean
@Named("loginController")
@SessionScoped
public class LoginController implements Serializable {

    @EJB
    private SessionBeans.UsuarioFacade ejbFacade;
    @EJB
    private SessionBeans.AdministradorFacade ejbFacade2;
    private Usuario current;
    private Administrador current2;
    private int selectedItemIndex;
    private String alerta = null;
    private boolean erroractiva = false;
    private boolean errorpass = false;
    private boolean errororreo = false;
    private FacesContext context;

    public String getAlerta() {
        return alerta;
    }

    public Usuario getSelected() {
        if (current == null) {
            current = new Usuario();
            selectedItemIndex = -1;
        }
        return current;
    }

    private UsuarioFacade getFacade() {
        return ejbFacade;
    }


    public String autenticarUsuario() {
        boolean erroractiva = false;
        boolean errorcorreo = false;
        boolean errorpass = false;
        boolean autenticar = false;
        context = FacesContext.getCurrentInstance();
        for (Usuario usu : getFacade().findAll()) {
            if (current.getCorreo().compareToIgnoreCase(usu.getCorreo()) == 0) {
                if (current.getPass().compareTo(usu.getPass()) == 0) {
                    if (usu.getActiva() == BigInteger.ONE) {
                        autenticar = true;
                        erroractiva = false;
                        errorcorreo = false;
                        errorpass = false;
                        break;
                    } else {
                        erroractiva = true;
                    }
                } else {
                    errorpass = true;
                }
            } else {
                errorcorreo = true;
            }
        }
        if (erroractiva) {
            alerta = "<script>alert('La cuenta no esta activa.');</script>";
            return "index";
        }
        if (errorpass) {
            alerta = "<script>alert('Contraseña incorrecta.');</script>";
            return "index";
        }
        if (errorcorreo) {
            alerta = "<script>alert('El correo no existe.');</script>";
            return "index";
        }
        if (autenticar) {
            context.getExternalContext().getSessionMap().put("sesion", current.getCorreo());
            return "/menusCliente/inicioC?faces-redirect=true";
        }
        return null;
    }

    public String cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/login/index?faces-redirect=true";

    }

    public String cerrarAdmin() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/login/indexAdmin?faces-redirect=true";
    }

    public String autenticarAdmin() {
        boolean erroractiva = false;
        boolean errorcorreo = false;
        boolean errorpass = false;
        boolean autenticar = false;
        context = FacesContext.getCurrentInstance();
        for (Usuario usu : getFacade().findAll()) {
            if (current.getCorreo().compareToIgnoreCase(usu.getCorreo()) == 0) {
                if (current.getPass().compareTo(usu.getPass()) == 0) {
                    if (usu.getActiva() == BigInteger.ONE) {
                        autenticar = true;
                        erroractiva = false;
                        errorcorreo = false;
                        errorpass = false;
                        break;
                    } else {
                        erroractiva = true;
                    }
                } else {
                    errorpass = true;
                }
            } else {
                errorcorreo = true;
            }
        }
        if (erroractiva) {
            alerta = "<script>alert('La cuenta no esta activa.');</script>";
            return "index";
        }
        if (errorpass) {
            alerta = "<script>alert('Contraseña incorrecta.');</script>";
            return "index";
        }
        if (errorcorreo) {
            alerta = "<script>alert('El correo no existe.');</script>";
            return "index";
        }
        if (autenticar) {
            context.getExternalContext().getSessionMap().put("sesionAdmin", current.getCorreo());
            return "/menusAdmin/inicioAdmin?faces-redirect=true";
        }
        return null;
    }

    /**
     * @return the ejbFacade2
     */
    public SessionBeans.AdministradorFacade getEjbFacade2() {
        return ejbFacade2;
    }

}
