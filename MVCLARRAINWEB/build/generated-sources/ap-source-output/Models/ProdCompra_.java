package Models;

import Models.BoletaProdCompra;
import Models.Compra;
import Models.Despacho;
import Models.Producto;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-28T22:48:11")
@StaticMetamodel(ProdCompra.class)
public class ProdCompra_ { 

    public static volatile ListAttribute<ProdCompra, BoletaProdCompra> boletaProdCompraList;
    public static volatile SingularAttribute<ProdCompra, BigInteger> total;
    public static volatile SingularAttribute<ProdCompra, BigDecimal> idProductosCompra;
    public static volatile ListAttribute<ProdCompra, Despacho> despachoList;
    public static volatile SingularAttribute<ProdCompra, Compra> idCompra;
    public static volatile SingularAttribute<ProdCompra, BigInteger> cantidad;
    public static volatile SingularAttribute<ProdCompra, Producto> idProducto;

}