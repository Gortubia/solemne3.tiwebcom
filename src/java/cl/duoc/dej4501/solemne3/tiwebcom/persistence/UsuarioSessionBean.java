/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej4501.solemne3.tiwebcom.persistence;

import cl.duoc.dej4501.solemne3.tiwebcom.entity.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author adolf
 */
@Stateless
public class UsuarioSessionBean {
    
    @PersistenceContext
    private EntityManager em;
    
    public Usuario buscaUsuario (String loginUsuario, String passUsuario){
        Usuario usuario = null;
        
        try {
            List<Usuario> listausuario = em.createNamedQuery("Usuario.validador", Usuario.class)
                   .setParameter("loginUsuario", loginUsuario)
                    .setParameter("passUsuario", passUsuario)
                    .getResultList();
            if(!listausuario.isEmpty()){
                usuario = listausuario.get(0);
            }
                   
        } catch (Exception e) {
        }
        return usuario;
        
    }

   
    
}
