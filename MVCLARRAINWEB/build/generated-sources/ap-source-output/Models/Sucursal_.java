package Models;

import Models.Comuna;
import Models.RegistroBodega;
import Models.ReporteDeVentas;
import Models.Supervisor;
import Models.Vendedor;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-29T05:52:11")
@StaticMetamodel(Sucursal.class)
public class Sucursal_ { 

    public static volatile SingularAttribute<Sucursal, BigDecimal> idSucursal;
    public static volatile CollectionAttribute<Sucursal, RegistroBodega> registroBodegaCollection;
    public static volatile SingularAttribute<Sucursal, String> nombreSucursal;
    public static volatile SingularAttribute<Sucursal, String> direccion;
    public static volatile CollectionAttribute<Sucursal, ReporteDeVentas> reporteDeVentasCollection;
    public static volatile SingularAttribute<Sucursal, Comuna> idComuna;
    public static volatile CollectionAttribute<Sucursal, Supervisor> supervisorCollection;
    public static volatile CollectionAttribute<Sucursal, Vendedor> vendedorCollection;

}