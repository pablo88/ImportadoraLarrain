package Models;

import Models.Producto;
import Models.RegistroBodega;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-29T05:52:11")
@StaticMetamodel(ProductoRegBodeg.class)
public class ProductoRegBodeg_ { 

    public static volatile SingularAttribute<ProductoRegBodeg, RegistroBodega> idRegistroBodega;
    public static volatile SingularAttribute<ProductoRegBodeg, BigDecimal> idProductoRegBodeg;
    public static volatile SingularAttribute<ProductoRegBodeg, BigInteger> cantidad;
    public static volatile SingularAttribute<ProductoRegBodeg, Producto> idProducto;

}