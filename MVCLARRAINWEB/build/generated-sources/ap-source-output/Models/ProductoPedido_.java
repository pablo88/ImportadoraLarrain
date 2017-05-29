package Models;

import Models.BoletaProdpedido;
import Models.Despacho;
import Models.Pedido;
import Models.Producto;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-28T22:48:11")
@StaticMetamodel(ProductoPedido.class)
public class ProductoPedido_ { 

    public static volatile SingularAttribute<ProductoPedido, BigInteger> total;
    public static volatile SingularAttribute<ProductoPedido, BigDecimal> idProductoPedido;
    public static volatile ListAttribute<ProductoPedido, BoletaProdpedido> boletaProdpedidoList;
    public static volatile ListAttribute<ProductoPedido, Despacho> despachoList;
    public static volatile SingularAttribute<ProductoPedido, Producto> idProducto;
    public static volatile SingularAttribute<ProductoPedido, Pedido> idPedido;
    public static volatile SingularAttribute<ProductoPedido, BigInteger> cantidad2;

}