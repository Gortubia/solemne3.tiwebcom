/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej4501.solemne3.tiwebcom.persistence;

import cl.duoc.dej4501.solemne3.tiwebcom.entity.Boleta;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author adolf
 */
@Stateless
public class BoletaSessionBean {

     @PersistenceContext
    private EntityManager em;
    
     public List<Boleta> getAllBoletas(){
       return em.createNamedQuery("Boleta.findAll",Boleta.class)
               .getResultList();
    }
    
    
    public Boleta getBoletaById(int id){
        return em.find(Boleta.class, id );
    }
    
     
     
    
     public void guardarBoleta (Boleta boleta) throws ControllerException{
                 em.persist(boleta);
        
     }
     
      public int findmaXiD (){
        int maxId = 0; 
        try {
            
            maxId = (int)  em.createQuery("SELECT MAX(b.idBoleta) FROM Boleta b") 
                    .getSingleResult();  
        } catch (Exception e) {
        }
        return maxId;
        
    }

   
}
