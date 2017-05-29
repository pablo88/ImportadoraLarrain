package Models;

import Models.EstadoCompra;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-28T22:48:11")
@StaticMetamodel(CorreoEstado.class)
public class CorreoEstado_ { 

    public static volatile SingularAttribute<CorreoEstado, BigDecimal> idCorreoEstado;
    public static volatile SingularAttribute<CorreoEstado, EstadoCompra> idEstadoCompra;
    public static volatile SingularAttribute<CorreoEstado, BigInteger> chile;
    public static volatile SingularAttribute<CorreoEstado, BigInteger> bodega;
    public static volatile SingularAttribute<CorreoEstado, BigInteger> despachado;

}