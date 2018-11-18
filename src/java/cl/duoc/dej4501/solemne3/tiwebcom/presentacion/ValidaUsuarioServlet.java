/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej4501.solemne3.tiwebcom.presentacion;

import cl.duoc.dej4501.solemne3.tiwebcom.entity.Usuario;
import cl.duoc.dej4501.solemne3.tiwebcom.persistence.UsuarioSessionBean;
import java.io.IOException; 
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author adolf
 */
@WebServlet(name = "ValidaUsuarioServlet", urlPatterns = {"/validaUsuarioServlet"})
public class ValidaUsuarioServlet extends HttpServlet {

    @EJB
    private UsuarioSessionBean usuarioSB;
    

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
        HttpSession sesion = request.getSession(); 
        String login = request.getParameter("txtLogin");
        String pass = request.getParameter("txtPass");

        Usuario usuarioConectado = usuarioSB.buscaUsuario(login, pass);
        if (usuarioConectado != null) {
            sesion.setAttribute("usuarioConectado", usuarioConectado);
            response.sendRedirect("home.jsp");
        } else {
            sesion.setAttribute("msgError", "Usuario No Existe");
            response.sendRedirect("login.jsp");
        }
    }

    

}
