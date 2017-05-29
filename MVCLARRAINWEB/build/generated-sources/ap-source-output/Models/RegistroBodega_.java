package Models;

import Models.Despacho;
import Models.EncargadoBodega;
import Models.ProductoRegBodeg;
import Models.Sucursal;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-29T05:52:11")
@StaticMetamodel(RegistroBodega.class)
public class RegistroBodega_ { 

    public static volatile SingularAttribute<RegistroBodega, Sucursal> idSucursal;
    public static volatile CollectionAttribute<RegistroBodega, Despacho> despachoCollection;
    public static volatile SingularAttribute<RegistroBodega, EncargadoBodega> idEncargadoBodega;
    public static volatile SingularAttribute<RegistroBodega, BigDecimal> idRegistroBodega;
    public static volatile SingularAttribute<RegistroBodega, Date> fechaSalida;
    public static volatile SingularAttribute<RegistroBodega, Date> fechaEntrada;
    public static volatile CollectionAttribute<RegistroBodega, ProductoRegBodeg> productoRegBodegCollection;

}