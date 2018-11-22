/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej4501.solemne3.tiwebcom.persistence;


import cl.duoc.dej4501.solemne3.tiwebcom.entity.Sucursal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author adolf
 */
@Stateless
public class SucursalSessionBean {

         @PersistenceContext
    private EntityManager em;
    
    public List<Sucursal> getAllSucursal(){
       return em.createNamedQuery("Sucursal.findAll",Sucursal.class)
               .getResultList();
    }
    
    
    public Sucursal getSucursalById(int id){
        return em.find(Sucursal.class, id );
    }
    
     public void guardarSucursal (Sucursal sucursal) throws ControllerException{
                 em.persist(sucursal);
        
     }

}
