package cl.duoc.dej4501.solemne3.tiwebcom.entity;

import cl.duoc.dej4501.solemne3.tiwebcom.entity.Boleta;
import cl.duoc.dej4501.solemne3.tiwebcom.entity.Perfil;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-11T17:52:34")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, String> rut;
    public static volatile SingularAttribute<Cliente, Integer> idCliente;
    public static volatile SingularAttribute<Cliente, Perfil> idPerfil;
    public static volatile SingularAttribute<Cliente, String> direccion;
    public static volatile ListAttribute<Cliente, Boleta> boletaList;

}