/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej4501.solemne3.tiwebcom.persistence;

import cl.duoc.dej4501.solemne3.tiwebcom.entity.Perfil;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author adolf
 */
@Stateless
public class PerfilSessionBean {

      @PersistenceContext
    private EntityManager em;
    
    public List<Perfil> getAllPerfil(){
       return em.createNamedQuery("Perfil.findAll",Perfil.class)
               .getResultList();
    }
    
    
    public Perfil getPerfilById(int id){
        return em.find(Perfil.class, id );
    }

}
