package Models;

import Models.Pago;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-28T22:48:11")
@StaticMetamodel(TipoPago.class)
public class TipoPago_ { 

    public static volatile SingularAttribute<TipoPago, String> descripcion;
    public static volatile SingularAttribute<TipoPago, BigDecimal> idTipoPago;
    public static volatile ListAttribute<TipoPago, Pago> pagoList;

}