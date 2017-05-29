package Models;

import Models.ProdPedProv;
import Models.Proveedores;
import Models.Supervisor;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-28T22:48:11")
@StaticMetamodel(PedidoAProveedor.class)
public class PedidoAProveedor_ { 

    public static volatile SingularAttribute<PedidoAProveedor, Proveedores> idProveedor;
    public static volatile SingularAttribute<PedidoAProveedor, BigDecimal> idPedidoProv;
    public static volatile SingularAttribute<PedidoAProveedor, Supervisor> idSupervisor;
    public static volatile SingularAttribute<PedidoAProveedor, Date> fechaPedido;
    public static volatile ListAttribute<PedidoAProveedor, ProdPedProv> prodPedProvList;

}