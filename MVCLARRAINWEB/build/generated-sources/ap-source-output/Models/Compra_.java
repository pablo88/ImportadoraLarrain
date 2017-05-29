package Models;

import Models.Cliente;
import Models.EstadoCompra;
import Models.ProdCompra;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-29T05:52:11")
@StaticMetamodel(Compra.class)
public class Compra_ { 

    public static volatile SingularAttribute<Compra, Date> fechaCompra;
    public static volatile SingularAttribute<Compra, Cliente> idCliente;
    public static volatile CollectionAttribute<Compra, ProdCompra> prodCompraCollection;
    public static volatile SingularAttribute<Compra, BigDecimal> idCompra;
    public static volatile SingularAttribute<Compra, EstadoCompra> idEstadoCompra;

}