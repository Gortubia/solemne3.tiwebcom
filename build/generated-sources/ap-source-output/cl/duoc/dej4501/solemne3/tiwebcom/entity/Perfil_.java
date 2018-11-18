package cl.duoc.dej4501.solemne3.tiwebcom.entity;

import cl.duoc.dej4501.solemne3.tiwebcom.entity.Cliente;
import cl.duoc.dej4501.solemne3.tiwebcom.entity.Menu;
import cl.duoc.dej4501.solemne3.tiwebcom.entity.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-11T17:52:34")
@StaticMetamodel(Perfil.class)
public class Perfil_ { 

    public static volatile ListAttribute<Perfil, Cliente> clienteList;
    public static volatile ListAttribute<Perfil, Menu> menuList;
    public static volatile ListAttribute<Perfil, Usuario> usuarioList;
    public static volatile SingularAttribute<Perfil, Integer> idPerfil;
    public static volatile SingularAttribute<Perfil, String> nombrePerfil;

}