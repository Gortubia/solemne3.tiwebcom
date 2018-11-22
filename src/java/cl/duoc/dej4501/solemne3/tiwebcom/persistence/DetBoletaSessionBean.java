/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej4501.solemne3.tiwebcom.persistence;

import cl.duoc.dej4501.solemne3.tiwebcom.entity.DetBoleta;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author adolf
 */
@Stateless
public class DetBoletaSessionBean {

    @PersistenceContext
    private EntityManager em;
    
     public List<DetBoleta> getAllDetBoletas(){
       return em.createNamedQuery("DetBoleta.findAll",DetBoleta.class)
               .getResultList();
    }
    
    
    public DetBoleta getDetBoletaById(int id){
        return em.find(DetBoleta.class, id );
    }
    
     
     
    
     public void guardarDetBoleta (DetBoleta detBoleta) throws ControllerException{
                 em.persist(detBoleta);
        
     }
     
      public int findmaXiD (){
        int maxId = 0; 
        try {
            
            maxId = (int)  em.createQuery("SELECT MAX(d.idDetBoleta) FROM DetBoleta d") 
                    .getSingleResult();  
        } catch (Exception e) {
        }
        return maxId;
        
    }
}
