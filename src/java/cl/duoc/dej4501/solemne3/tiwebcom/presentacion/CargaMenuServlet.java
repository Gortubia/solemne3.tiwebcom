/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej4501.solemne3.tiwebcom.presentacion;

import cl.duoc.dej4501.solemne3.tiwebcom.entity.Usuario;
import cl.duoc.dej4501.solemne3.tiwebcom.persistence.MenuSessionBean;
import java.io.IOException; 
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author adolf
 */
@WebServlet(name = "CargaMenuServlet", urlPatterns = {"/cargaMenuServlet","/menu"})
public class CargaMenuServlet extends HttpServlet {

    @EJB
    private MenuSessionBean menuSB;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Usuario objUsuarioConectado = (Usuario) request.getSession().getAttribute("usuarioConectado");        
        List listadoMenu =  menuSB.cargarMenuPorPerfil(objUsuarioConectado.getCodigoPerfil().getIdPerfil());
        request.setAttribute("listadoMenu", listadoMenu);       
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

     

}
