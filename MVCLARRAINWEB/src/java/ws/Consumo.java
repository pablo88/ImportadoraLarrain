/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

/**
 *
 * @author P_Silva
 */
public class Consumo {

    public static String consultarEstadoCompra(java.math.BigDecimal id, java.math.BigDecimal cli) {
        WebServiceConsumo.ConsultarEstadoWS_Service service = new WebServiceConsumo.ConsultarEstadoWS_Service();
        WebServiceConsumo.ConsultarEstadoWS port = service.getConsultarEstadoWSPort();
        return port.consultarEstadoCompra(id, cli);
    }

    
}
