/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej4501.solemne3.tiwebcom.persistence;

import cl.duoc.dej4501.solemne3.tiwebcom.entity.Comunas; 
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author adolf
 */
@Stateless
public class ComunasSessionBean {

    
      @PersistenceContext
    private EntityManager em;
    
    public List<Comunas> getAllComunas(){
       return em.createNamedQuery("Comunas.findAll",Comunas.class)
               .getResultList();
    }
    
    
    public Comunas getComunasById(int id){
        return em.find(Comunas.class, id );
    }
}
