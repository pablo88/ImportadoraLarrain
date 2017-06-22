/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import javax.ejb.Stateless;
import javax.jws.WebService;
import webservice.ConsultarEstadoWS_Service;
import webservice.ConsultarEstadoWS;

/**
 *
 * @author P_Silva
 */
@WebService(serviceName = "consultarEstado_WS", portName = "consultarEstado_WSPort", endpointInterface = "webservice.ConsultarEstadoWS", targetNamespace = "http://WebService/", wsdlLocation = "WEB-INF/wsdl/consultarEstadoCompra_WS/localhost_7001/consultarEstado_WS/consultarEstado_WS.wsdl")
@Stateless
public class consultarEstadoCompra_WS {

    public java.lang.String consultarEstadoCompra(java.math.BigDecimal id, webservice.Cliente cli) {

        ConsultarEstadoWS_Service service = new ConsultarEstadoWS_Service();
        ConsultarEstadoWS puerto = service.getConsultarEstadoWSPort();
        return puerto.consultarEstadoCompra(id, cli);
    }

}
