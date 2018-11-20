package cl.duoc.dej4501.solemne3.tiwebcom.entity;

import cl.duoc.dej4501.solemne3.tiwebcom.entity.Boleta;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-19T17:01:46")
@StaticMetamodel(Sucursal.class)
public class Sucursal_ { 

    public static volatile SingularAttribute<Sucursal, String> descripcion;
    public static volatile SingularAttribute<Sucursal, Integer> codComuna;
    public static volatile SingularAttribute<Sucursal, String> direccion;
    public static volatile SingularAttribute<Sucursal, Integer> id;
    public static volatile ListAttribute<Sucursal, Boleta> boletaList;
    public static volatile SingularAttribute<Sucursal, String> telefono;

}