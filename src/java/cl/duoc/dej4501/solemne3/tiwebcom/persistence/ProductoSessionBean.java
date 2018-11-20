/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej4501.solemne3.tiwebcom.persistence;

import cl.duoc.dej4501.solemne3.tiwebcom.entity.Producto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author adolf
 */
@Stateless
public class ProductoSessionBean {

   
     @PersistenceContext
    private EntityManager em;
    
     public List<Producto> getAllProductos(){
       return em.createNamedQuery("Producto.findAll",Producto.class)
               .getResultList();
    }
    
    
    public Producto getProductoById(int id){
        return em.find(Producto.class, id );
    }
    
     
    public int findmaXiD (){
        int maxId = 0; 
        try {
            
            maxId = (int)  em.createQuery("SELECT MAX(p.id) FROM Producto p") 
                    .getSingleResult();  
        } catch (Exception e) {
        }
        return maxId;
        
    }
    
     public void guardarProducto (Producto producto) throws ControllerException{
                 em.persist(producto);
        
     }

    
}
