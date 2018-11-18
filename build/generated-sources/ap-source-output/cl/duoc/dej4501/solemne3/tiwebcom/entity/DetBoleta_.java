package cl.duoc.dej4501.solemne3.tiwebcom.entity;

import cl.duoc.dej4501.solemne3.tiwebcom.entity.Boleta;
import cl.duoc.dej4501.solemne3.tiwebcom.entity.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-11T17:52:34")
@StaticMetamodel(DetBoleta.class)
public class DetBoleta_ { 

    public static volatile SingularAttribute<DetBoleta, Long> precio;
    public static volatile SingularAttribute<DetBoleta, Boleta> idBoleta;
    public static volatile SingularAttribute<DetBoleta, Integer> idDetBoleta;
    public static volatile SingularAttribute<DetBoleta, Long> cantidad;
    public static volatile SingularAttribute<DetBoleta, Long> subTotal;
    public static volatile SingularAttribute<DetBoleta, Producto> idProducto;

}