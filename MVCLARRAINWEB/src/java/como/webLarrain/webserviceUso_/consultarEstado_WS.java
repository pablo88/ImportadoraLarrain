/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package como.webLarrain.webserviceUso_;

import Models.Cliente;
import Models.Compra;
import SessionBeans.CompraFacade;
import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author P_Silva
 */
@WebService(serviceName = "consultarEstado_WS")
@Stateless()
public class consultarEstado_WS {

    @EJB
    private CompraFacade comF;

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "consultarEstadoCompra")
    public String consultarEstadoCompra(@WebParam(name = "id") BigDecimal id_compra, @WebParam(name = "cli") BigDecimal id_cli) {
        String estado="";
        for (Compra compra : comF.findAll()) {
            if((compra.getIdCliente().getIdCliente().compareTo(id_cli)==0)&&(compra.getIdCompra().compareTo(id_compra)==0)){
                estado=""+compra.getIdEstadoCompra().getDescripcion();
            }
        }
        return estado;
    }
}
