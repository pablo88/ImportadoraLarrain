package Models;

import Models.BoletaProdCompra;
import Models.Compra;
import Models.Despacho;
import Models.Producto;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-29T05:52:11")
@StaticMetamodel(ProdCompra.class)
public class ProdCompra_ { 

    public static volatile SingularAttribute<ProdCompra, BigInteger> total;
    public static volatile CollectionAttribute<ProdCompra, Despacho> despachoCollection;
    public static volatile CollectionAttribute<ProdCompra, BoletaProdCompra> boletaProdCompraCollection;
    public static volatile SingularAttribute<ProdCompra, BigDecimal> idProductosCompra;
    public static volatile SingularAttribute<ProdCompra, Compra> idCompra;
    public static volatile SingularAttribute<ProdCompra, BigInteger> cantidad;
    public static volatile SingularAttribute<ProdCompra, Producto> idProducto;

}