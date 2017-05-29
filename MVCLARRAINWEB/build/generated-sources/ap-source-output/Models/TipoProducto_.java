package Models;

import Models.Producto;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-28T22:48:11")
@StaticMetamodel(TipoProducto.class)
public class TipoProducto_ { 

    public static volatile SingularAttribute<TipoProducto, String> descripcion;
    public static volatile ListAttribute<TipoProducto, Producto> productoList;
    public static volatile SingularAttribute<TipoProducto, BigDecimal> idTipoProducto;

}