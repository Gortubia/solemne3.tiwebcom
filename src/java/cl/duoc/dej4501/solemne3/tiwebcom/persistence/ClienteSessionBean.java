/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej4501.solemne3.tiwebcom.persistence;

import cl.duoc.dej4501.solemne3.tiwebcom.entity.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author adolf
 */
@Stateless
public class ClienteSessionBean {

  
    
    @PersistenceContext
    private EntityManager em;
    
    public boolean findByLoginUsuario(String rut){
        boolean cli = false;
        
        try {
            List<Cliente> listaCliente = em.createNamedQuery("Usuario.Cliente.findByRut", Cliente.class)
                   .setParameter("rut", rut) 
                    .getResultList();
            if(!listaCliente.isEmpty()){
                cli = true;
            }
                   
        } catch (Exception e) {
        }
        return cli;
    }
}
