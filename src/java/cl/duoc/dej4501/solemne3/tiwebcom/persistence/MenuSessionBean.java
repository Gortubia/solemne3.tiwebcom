/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej4501.solemne3.tiwebcom.persistence;

import cl.duoc.dej4501.solemne3.tiwebcom.entity.Menu; 
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author adolf
 */
@Stateless
public class MenuSessionBean {

    @PersistenceContext
    private EntityManager em;
    
     public List<Menu> getAllMenu(){
       return em.createNamedQuery("Menu.findAll",Menu.class)
               .getResultList();
    }
    
    public List<Menu> cargarMenuPorPerfil(int codUsuario){
        List<Menu> listaMenu = null;
        try {
            
            listaMenu =(List<Menu>)em.createNamedQuery("Menu.findByIdPerfil",Menu.class)
                .setParameter("idCodigo", codUsuario)
                .getResultList();
            if(!listaMenu.isEmpty()){
                return listaMenu;
            }
                    
            
        } catch (Exception e ) {
            System.out.println(e+"error al cargar menu");
        }
        return listaMenu;
    }
 
    
    
}
