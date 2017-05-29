package Models;

import Models.PedidoAProveedor;
import Models.Usuario;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-29T05:52:11")
@StaticMetamodel(Proveedores.class)
public class Proveedores_ { 

    public static volatile SingularAttribute<Proveedores, String> nombreProveedor;
    public static volatile SingularAttribute<Proveedores, BigDecimal> idProveedor;
    public static volatile SingularAttribute<Proveedores, Usuario> idUsuario;
    public static volatile SingularAttribute<Proveedores, String> correoProveedor;
    public static volatile CollectionAttribute<Proveedores, PedidoAProveedor> pedidoAProveedorCollection;

}