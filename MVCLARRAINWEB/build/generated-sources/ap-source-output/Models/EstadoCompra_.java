package Models;

import Models.Compra;
import Models.CorreoEstado;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-29T05:52:11")
@StaticMetamodel(EstadoCompra.class)
public class EstadoCompra_ { 

    public static volatile SingularAttribute<EstadoCompra, String> descripcion;
    public static volatile CollectionAttribute<EstadoCompra, Compra> compraCollection;
    public static volatile CollectionAttribute<EstadoCompra, CorreoEstado> correoEstadoCollection;
    public static volatile SingularAttribute<EstadoCompra, BigDecimal> idEstadoCompra;

}