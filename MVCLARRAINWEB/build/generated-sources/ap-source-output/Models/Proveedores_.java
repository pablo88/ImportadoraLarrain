package Models;

import Models.PedidoAProveedor;
import Models.Usuario;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-28T22:48:11")
@StaticMetamodel(Proveedores.class)
public class Proveedores_ { 

    public static volatile SingularAttribute<Proveedores, String> nombreProveedor;
    public static volatile SingularAttribute<Proveedores, BigDecimal> idProveedor;
    public static volatile SingularAttribute<Proveedores, Usuario> idUsuario;
    public static volatile ListAttribute<Proveedores, PedidoAProveedor> pedidoAProveedorList;
    public static volatile SingularAttribute<Proveedores, String> correoProveedor;

}