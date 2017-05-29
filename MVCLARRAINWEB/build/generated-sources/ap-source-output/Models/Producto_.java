package Models;

import Models.LocacionDeProducto;
import Models.ProdCompra;
import Models.ProdPedProv;
import Models.ProductoPedido;
import Models.ProductoRegBodeg;
import Models.TipoProducto;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-28T22:48:11")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, LocacionDeProducto> idLocacionDeProducto;
    public static volatile SingularAttribute<Producto, BigInteger> onlineProducto;
    public static volatile ListAttribute<Producto, ProductoRegBodeg> productoRegBodegList;
    public static volatile ListAttribute<Producto, ProductoPedido> productoPedidoList;
    public static volatile SingularAttribute<Producto, BigDecimal> idProducto;
    public static volatile ListAttribute<Producto, ProdPedProv> prodPedProvList;
    public static volatile SingularAttribute<Producto, BigInteger> precioProducto;
    public static volatile ListAttribute<Producto, ProdCompra> prodCompraList;
    public static volatile SingularAttribute<Producto, BigInteger> stockProducto;
    public static volatile SingularAttribute<Producto, TipoProducto> idTipoProducto;
    public static volatile SingularAttribute<Producto, String> nombreProducto;

}