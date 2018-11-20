/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej4501.solemne3.tiwebcom.persistence;

import cl.duoc.dej4501.solemne3.tiwebcom.entity.Provincias; 
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author adolf
 */
@Stateless
public class ProvinciasSessionBean {

      @PersistenceContext
    private EntityManager em;
    
    public List<Provincias> getAllProvincias(){
       return em.createNamedQuery("Provincias.findAll",Provincias.class)
               .getResultList();
    }
    
    
    public Provincias getProvinciasById(int id){
        return em.find(Provincias.class, id );
    }
}
