/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej4501.solemne3.tiwebcom.persistence;

import cl.duoc.dej4501.solemne3.tiwebcom.entity.Regiones;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author adolf
 */
@Stateless
public class RegionesSessionBean {

      @PersistenceContext
    private EntityManager em;
    
    public List<Regiones> getAllRegiones(){
       return em.createNamedQuery("Regiones.findAll",Regiones.class)
               .getResultList();
    }
    
    
    public Regiones getRegionesById(int id){
        return em.find(Regiones.class, id );
    }

}
