package Models;

import Models.RegistroBodega;
import Models.Usuario;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-28T22:48:11")
@StaticMetamodel(EncargadoBodega.class)
public class EncargadoBodega_ { 

    public static volatile SingularAttribute<EncargadoBodega, String> nombreEncargadoBodega;
    public static volatile SingularAttribute<EncargadoBodega, BigDecimal> idEncargadoBodega;
    public static volatile SingularAttribute<EncargadoBodega, Usuario> idUsuario;
    public static volatile SingularAttribute<EncargadoBodega, String> correoEncargadoBodega;
    public static volatile SingularAttribute<EncargadoBodega, String> appEncargadoBodega;
    public static volatile ListAttribute<EncargadoBodega, RegistroBodega> registroBodegaList;
    public static volatile SingularAttribute<EncargadoBodega, String> apmEncargadoBodega;

}