package Models;

import Models.Administrador;
import Models.Agente;
import Models.Cliente;
import Models.EncargadoBodega;
import Models.Proveedores;
import Models.Supervisor;
import Models.Vendedor;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-28T22:48:11")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile ListAttribute<Usuario, Cliente> clienteList;
    public static volatile ListAttribute<Usuario, EncargadoBodega> encargadoBodegaList;
    public static volatile ListAttribute<Usuario, Administrador> administradorList;
    public static volatile ListAttribute<Usuario, Vendedor> vendedorList;
    public static volatile ListAttribute<Usuario, Proveedores> proveedoresList;
    public static volatile ListAttribute<Usuario, Supervisor> supervisorList;
    public static volatile SingularAttribute<Usuario, String> pass;
    public static volatile SingularAttribute<Usuario, BigDecimal> idUsuario;
    public static volatile SingularAttribute<Usuario, String> correo;
    public static volatile ListAttribute<Usuario, Agente> agenteList;
    public static volatile SingularAttribute<Usuario, BigInteger> activa;

}