package Models;

import Models.Producto;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-29T05:52:11")
@StaticMetamodel(TipoProducto.class)
public class TipoProducto_ { 

    public static volatile SingularAttribute<TipoProducto, String> descripcion;
    public static volatile CollectionAttribute<TipoProducto, Producto> productoCollection;
    public static volatile SingularAttribute<TipoProducto, BigDecimal> idTipoProducto;

}