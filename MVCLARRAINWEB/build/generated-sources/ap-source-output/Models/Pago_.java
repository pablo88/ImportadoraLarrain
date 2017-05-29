package Models;

import Models.Boleta;
import Models.TipoPago;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-28T22:48:11")
@StaticMetamodel(Pago.class)
public class Pago_ { 

    public static volatile SingularAttribute<Pago, BigInteger> monto;
    public static volatile SingularAttribute<Pago, TipoPago> idTipoPago;
    public static volatile SingularAttribute<Pago, BigDecimal> idPago;
    public static volatile SingularAttribute<Pago, Boleta> idBoleta;
    public static volatile SingularAttribute<Pago, BigInteger> cuotas;
    public static volatile SingularAttribute<Pago, BigInteger> cantCuotas;

}