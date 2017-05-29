package Models;

import Models.PedidoAProveedor;
import Models.Producto;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-29T05:52:11")
@StaticMetamodel(ProdPedProv.class)
public class ProdPedProv_ { 

    public static volatile SingularAttribute<ProdPedProv, BigInteger> total;
    public static volatile SingularAttribute<ProdPedProv, BigDecimal> idProdPedProv;
    public static volatile SingularAttribute<ProdPedProv, PedidoAProveedor> idPedidoProv;
    public static volatile SingularAttribute<ProdPedProv, BigInteger> cantidad;
    public static volatile SingularAttribute<ProdPedProv, Producto> idProducto;

}