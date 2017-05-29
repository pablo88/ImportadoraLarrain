package Models;

import Models.Sucursal;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-29T05:52:11")
@StaticMetamodel(Comuna.class)
public class Comuna_ { 

    public static volatile CollectionAttribute<Comuna, Sucursal> sucursalCollection;
    public static volatile SingularAttribute<Comuna, String> nombreComuna;
    public static volatile SingularAttribute<Comuna, BigDecimal> idComuna;

}