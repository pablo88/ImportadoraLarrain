package Models;

import Models.Boleta;
import Models.ProdCompra;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-29T05:52:11")
@StaticMetamodel(BoletaProdCompra.class)
public class BoletaProdCompra_ { 

    public static volatile SingularAttribute<BoletaProdCompra, ProdCompra> idProductosCompra;
    public static volatile SingularAttribute<BoletaProdCompra, Boleta> idBoleta;
    public static volatile SingularAttribute<BoletaProdCompra, BigDecimal> idBoletaCompra;

}