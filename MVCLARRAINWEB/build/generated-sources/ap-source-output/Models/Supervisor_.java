package Models;

import Models.PedidoAProveedor;
import Models.Sucursal;
import Models.Usuario;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-28T22:48:11")
@StaticMetamodel(Supervisor.class)
public class Supervisor_ { 

    public static volatile SingularAttribute<Supervisor, String> apmSupervisor;
    public static volatile SingularAttribute<Supervisor, Sucursal> idSucursal;
    public static volatile SingularAttribute<Supervisor, String> nombreSupervisor;
    public static volatile SingularAttribute<Supervisor, Usuario> idUsuario;
    public static volatile ListAttribute<Supervisor, PedidoAProveedor> pedidoAProveedorList;
    public static volatile SingularAttribute<Supervisor, BigDecimal> idSupervisor;
    public static volatile SingularAttribute<Supervisor, String> appSupervisor;
    public static volatile SingularAttribute<Supervisor, String> correoSupervisor;

}