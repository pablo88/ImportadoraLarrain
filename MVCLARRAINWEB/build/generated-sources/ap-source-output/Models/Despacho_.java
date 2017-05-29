package Models;

import Models.ProdCompra;
import Models.ProductoPedido;
import Models.RegistroBodega;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-29T05:52:11")
@StaticMetamodel(Despacho.class)
public class Despacho_ { 

    public static volatile SingularAttribute<Despacho, ProductoPedido> idProductoPedido;
    public static volatile SingularAttribute<Despacho, ProdCompra> idProductosCompra;
    public static volatile SingularAttribute<Despacho, BigDecimal> idDespacho;
    public static volatile SingularAttribute<Despacho, RegistroBodega> idRegistroBodega;
    public static volatile SingularAttribute<Despacho, Date> fechaDespacho;

}