package Models;

import Models.Pedido;
import Models.Sucursal;
import Models.Usuario;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-29T05:52:11")
@StaticMetamodel(Vendedor.class)
public class Vendedor_ { 

    public static volatile SingularAttribute<Vendedor, String> nombreVendedor;
    public static volatile SingularAttribute<Vendedor, String> correoVendedor;
    public static volatile SingularAttribute<Vendedor, Sucursal> idSucursal;
    public static volatile SingularAttribute<Vendedor, String> appVendedor;
    public static volatile SingularAttribute<Vendedor, Usuario> idUsuario;
    public static volatile SingularAttribute<Vendedor, BigDecimal> idVendedor;
    public static volatile SingularAttribute<Vendedor, String> apmVendedor;
    public static volatile CollectionAttribute<Vendedor, Pedido> pedidoCollection;

}