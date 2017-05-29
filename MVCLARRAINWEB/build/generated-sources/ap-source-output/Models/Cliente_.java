package Models;

import Models.Compra;
import Models.Pedido;
import Models.Usuario;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-29T05:52:11")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, String> correoCliente;
    public static volatile SingularAttribute<Cliente, String> codigoPostal;
    public static volatile CollectionAttribute<Cliente, Compra> compraCollection;
    public static volatile SingularAttribute<Cliente, BigDecimal> idCliente;
    public static volatile SingularAttribute<Cliente, String> nombreCliente;
    public static volatile SingularAttribute<Cliente, String> apmCliente;
    public static volatile SingularAttribute<Cliente, String> appCliente;
    public static volatile SingularAttribute<Cliente, Usuario> idUsuario;
    public static volatile SingularAttribute<Cliente, String> direccionCliente;
    public static volatile CollectionAttribute<Cliente, Pedido> pedidoCollection;
    public static volatile SingularAttribute<Cliente, String> telefono;
    public static volatile SingularAttribute<Cliente, String> rutCliente;

}