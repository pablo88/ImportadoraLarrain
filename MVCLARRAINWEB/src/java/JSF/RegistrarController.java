/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSF;

import JSF.util.JsfUtil;
import Models.Cliente;
import Models.Usuario;
import SessionBeans.ClienteFacade;
import SessionBeans.UsuarioFacade;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author P_Silva
 */
@Named("registrarController")
@SessionScoped
public class RegistrarController implements Serializable {

    @EJB
    private SessionBeans.ClienteFacade ejbFacade;
    @EJB
    private SessionBeans.UsuarioFacade ejbFacade1;
    private Cliente current;
    private Usuario current1;
    private int selectedItemIndex;
    private int selectedItemIndex1;
    private String alerta;
    @ManagedProperty("#{param.key}")
    private String key;
    
    public String getKey()
    {
        return key;
    }
    public void setKey(String llave)
    {
        key=llave;
    }
    public String getAlerta() {
        return alerta;
    }

    public Cliente getSelected() {
        if (current == null) {
            current = new Cliente();
            selectedItemIndex = -1;
        }
        return current;
    }

    public Usuario getSelected1() {
        if (current1 == null) {
            current1 = new Usuario();
            selectedItemIndex1 = -1;
        }
        return current1;
    }

    private ClienteFacade getFacade() {
        return ejbFacade;
    }

    private UsuarioFacade getFacade1() {
        return ejbFacade1;
    }

    public String crearCliente() {
        try {
            current.setIdCliente(BigDecimal.ZERO);
            getFacade().create(current);
            if (crearUsuario(current)) {
                if (enviarMail(current1)) {
                    alerta = "<script>alert('Cuenta creada exitosamente');</script>";
                    return "registrar";
                } else {
                    alerta = "<script>alert('Cuenta creada ,pero no se pudo enviar el correo');</script>";
                    return "registrar";
                }
            } else {
                getFacade().remove(current);
                alerta = "<script>alert('Error al crear usuario.');</script>";
                return "registrar";
            }
        } catch (Exception e) {
            return null;
        }
    }

    private boolean crearUsuario(Cliente cliente) {
        try {
            for (Cliente cli : getFacade().findAll()) {
                if (cli.getCorreoCliente().compareToIgnoreCase(cliente.getCorreoCliente()) == 0) {
                    current1.setIdUsuario(cli.getIdCliente());
                    break;
                }
            }
            current1.setKeyActivacion(crearRandom());
            current1.setCorreo(cliente.getCorreoCliente());
            current1.setActiva(BigInteger.ZERO);
            getFacade1().create(current1);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean enviarMail(Usuario usu) {
        Properties props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.starttls,enable", "true");
        props.setProperty("mail.smtp.starttls.enable", "true");
        Session session = Session.getInstance(props, null);
        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom("importadora1@gmail.com");
            msg.setRecipients(Message.RecipientType.TO, usu.getCorreo());
            msg.setSubject("Activacion de Cuenta Importadora Larrain");
            msg.setSentDate(new Date());
            msg.setText("Active la cuenta en el siguiente link \n"
                    + "http://localhost:7001/MVCLARRAINWEB/faces/login/activacion.xhtml?key=" + usu.getKeyActivacion());
            Transport.send(msg, "importadoralarrain1@gmail.com", "importadoraLarrain2017");
            return true;
        } catch (MessagingException mex) {
            return false;
        }
    }

    private String crearRandom() {
        int passwordSize = 20;
        char[] chars = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < passwordSize; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String output = sb.toString();
        return output;
    }

    public boolean activarCuenta() {
        for (Usuario usu : getFacade1().findAll()) {
            if (usu.getKeyActivacion().compareTo(key)==0) 
            {
                usu.setKeyActivacion(" ");
                usu.setActiva(BigInteger.ONE);
                ejbFacade1.edit(usu);
                return true;
            }
        }
        return false;
    }
}
