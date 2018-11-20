package cl.duoc.dej4501.solemne3.tiwebcom.entity;

import cl.duoc.dej4501.solemne3.tiwebcom.entity.Cliente;
import cl.duoc.dej4501.solemne3.tiwebcom.entity.DetBoleta;
import cl.duoc.dej4501.solemne3.tiwebcom.entity.Sucursal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-19T17:01:46")
@StaticMetamodel(Boleta.class)
public class Boleta_ { 

    public static volatile SingularAttribute<Boleta, Sucursal> idSucursal;
    public static volatile SingularAttribute<Boleta, Date> fecha;
    public static volatile SingularAttribute<Boleta, Long> total;
    public static volatile SingularAttribute<Boleta, Cliente> idCliente;
    public static volatile ListAttribute<Boleta, DetBoleta> detBoletaList;
    public static volatile SingularAttribute<Boleta, Integer> idBoleta;

}