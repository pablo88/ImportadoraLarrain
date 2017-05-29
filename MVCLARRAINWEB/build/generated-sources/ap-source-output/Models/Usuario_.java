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
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-29T05:52:11")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> keyActivacion;
    public static volatile CollectionAttribute<Usuario, Administrador> administradorCollection;
    public static volatile SingularAttribute<Usuario, String> pass;
    public static volatile CollectionAttribute<Usuario, Agente> agenteCollection;
    public static volatile CollectionAttribute<Usuario, Proveedores> proveedoresCollection;
    public static volatile SingularAttribute<Usuario, BigDecimal> idUsuario;
    public static volatile SingularAttribute<Usuario, String> correo;
    public static volatile CollectionAttribute<Usuario, EncargadoBodega> encargadoBodegaCollection;
    public static volatile CollectionAttribute<Usuario, Supervisor> supervisorCollection;
    public static volatile SingularAttribute<Usuario, BigInteger> activa;
    public static volatile CollectionAttribute<Usuario, Vendedor> vendedorCollection;
    public static volatile CollectionAttribute<Usuario, Cliente> clienteCollection;

}