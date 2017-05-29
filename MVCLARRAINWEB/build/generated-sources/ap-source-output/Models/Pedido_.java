package Models;

import Models.Cliente;
import Models.ProductoPedido;
import Models.Vendedor;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-29T05:52:11")
@StaticMetamodel(Pedido.class)
public class Pedido_ { 

    public static volatile SingularAttribute<Pedido, Cliente> idCliente;
    public static volatile SingularAttribute<Pedido, Vendedor> idVendedor;
    public static volatile SingularAttribute<Pedido, Date> fechaPedido;
    public static volatile CollectionAttribute<Pedido, ProductoPedido> productoPedidoCollection;
    public static volatile SingularAttribute<Pedido, BigDecimal> idPedido;

}