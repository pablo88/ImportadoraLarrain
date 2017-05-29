package Models;

import Models.Comuna;
import Models.RegistroBodega;
import Models.ReporteDeVentas;
import Models.Supervisor;
import Models.Vendedor;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-28T22:48:11")
@StaticMetamodel(Sucursal.class)
public class Sucursal_ { 

    public static volatile SingularAttribute<Sucursal, BigDecimal> idSucursal;
    public static volatile ListAttribute<Sucursal, Vendedor> vendedorList;
    public static volatile ListAttribute<Sucursal, Supervisor> supervisorList;
    public static volatile SingularAttribute<Sucursal, String> nombreSucursal;
    public static volatile SingularAttribute<Sucursal, String> direccion;
    public static volatile ListAttribute<Sucursal, ReporteDeVentas> reporteDeVentasList;
    public static volatile SingularAttribute<Sucursal, Comuna> idComuna;
    public static volatile ListAttribute<Sucursal, RegistroBodega> registroBodegaList;

}