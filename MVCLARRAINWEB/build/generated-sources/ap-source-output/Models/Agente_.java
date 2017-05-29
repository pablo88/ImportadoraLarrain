package Models;

import Models.Usuario;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-28T22:48:11")
@StaticMetamodel(Agente.class)
public class Agente_ { 

    public static volatile SingularAttribute<Agente, Usuario> idUsuario;
    public static volatile SingularAttribute<Agente, BigDecimal> idAgente;
    public static volatile SingularAttribute<Agente, String> correoAgente;
    public static volatile SingularAttribute<Agente, String> nombreAgente;

}