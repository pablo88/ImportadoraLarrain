package Models;

import Models.Sucursal;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-28T22:48:11")
@StaticMetamodel(Comuna.class)
public class Comuna_ { 

    public static volatile ListAttribute<Comuna, Sucursal> sucursalList;
    public static volatile SingularAttribute<Comuna, String> nombreComuna;
    public static volatile SingularAttribute<Comuna, BigDecimal> idComuna;

}