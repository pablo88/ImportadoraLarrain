package Models;

import Models.Boleta;
import Models.ProductoPedido;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-29T05:52:11")
@StaticMetamodel(BoletaProdpedido.class)
public class BoletaProdpedido_ { 

    public static volatile SingularAttribute<BoletaProdpedido, ProductoPedido> idProductoPedido;
    public static volatile SingularAttribute<BoletaProdpedido, Boleta> idBoleta;
    public static volatile SingularAttribute<BoletaProdpedido, BigDecimal> idBoletaProdpedido;

}