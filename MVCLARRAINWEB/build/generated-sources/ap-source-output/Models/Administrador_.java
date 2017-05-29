package Models;

import Models.Usuario;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-29T05:52:11")
@StaticMetamodel(Administrador.class)
public class Administrador_ { 

    public static volatile SingularAttribute<Administrador, String> nombreAdmin;
    public static volatile SingularAttribute<Administrador, BigDecimal> idAdmin;
    public static volatile SingularAttribute<Administrador, String> correoAdmin;
    public static volatile SingularAttribute<Administrador, Usuario> idUsuario;

}