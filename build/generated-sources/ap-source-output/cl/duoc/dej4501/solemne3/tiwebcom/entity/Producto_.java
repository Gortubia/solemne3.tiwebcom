package cl.duoc.dej4501.solemne3.tiwebcom.entity;

import cl.duoc.dej4501.solemne3.tiwebcom.entity.DetBoleta;
import cl.duoc.dej4501.solemne3.tiwebcom.entity.DetProducto;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-11T17:52:34")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, String> descripcion;
    public static volatile ListAttribute<Producto, DetBoleta> detBoletaList;
    public static volatile ListAttribute<Producto, DetProducto> detProductoList;
    public static volatile SingularAttribute<Producto, Integer> id;
    public static volatile SingularAttribute<Producto, Long> stock;
    public static volatile SingularAttribute<Producto, String> nombre;

}