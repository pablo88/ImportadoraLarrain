package Models;

import Models.BoletaProdCompra;
import Models.BoletaProdpedido;
import Models.Pago;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-29T05:52:11")
@StaticMetamodel(Boleta.class)
public class Boleta_ { 

    public static volatile SingularAttribute<Boleta, BigInteger> monto;
    public static volatile CollectionAttribute<Boleta, BoletaProdCompra> boletaProdCompraCollection;
    public static volatile SingularAttribute<Boleta, Date> fechaBoleta;
    public static volatile SingularAttribute<Boleta, BigInteger> numeroBoletaFiscal;
    public static volatile SingularAttribute<Boleta, BigDecimal> idBoleta;
    public static volatile CollectionAttribute<Boleta, BoletaProdpedido> boletaProdpedidoCollection;
    public static volatile CollectionAttribute<Boleta, Pago> pagoCollection;

}