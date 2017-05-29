package Models;

import Models.Producto;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-28T22:48:11")
@StaticMetamodel(LocacionDeProducto.class)
public class LocacionDeProducto_ { 

    public static volatile SingularAttribute<LocacionDeProducto, String> descripcion;
    public static volatile SingularAttribute<LocacionDeProducto, BigDecimal> idLocacionDeProducto;
    public static volatile ListAttribute<LocacionDeProducto, Producto> productoList;

}