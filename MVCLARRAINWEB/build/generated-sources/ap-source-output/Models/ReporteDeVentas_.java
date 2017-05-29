package Models;

import Models.Sucursal;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-29T05:52:11")
@StaticMetamodel(ReporteDeVentas.class)
public class ReporteDeVentas_ { 

    public static volatile SingularAttribute<ReporteDeVentas, String> descripcion;
    public static volatile SingularAttribute<ReporteDeVentas, Sucursal> idSucursal;
    public static volatile SingularAttribute<ReporteDeVentas, Date> fecReporte;
    public static volatile SingularAttribute<ReporteDeVentas, BigDecimal> idReporteDeVentas;

}