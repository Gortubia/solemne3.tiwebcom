/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej4501.solemne3.tiwebcom.presentacion;

import cl.duoc.dej4501.solemne3.tiwebcom.entity.Usuario;
import cl.duoc.dej4501.solemne3.tiwebcom.persistence.UsuarioSessionBean;
import java.io.IOException; 
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
@WebServlet(name = "AddUsuarioUserServlet", urlPatterns = {"/addUsuarioUserServlet","/cargaUsuarios"})
public class AddUsuarioUserServlet extends HttpServlet {

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
        
        HttpSession sesion = request.getSession();
        List<Usuario> listaUsuarios = this.usuarioSB.getAllUsuarios();
        sesion.setAttribute("listaUsuarios", listaUsuarios);
        response.sendRedirect("./usuario/mantenedorUsuarios.jsp");
        
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
        
         Usuario usuarioCli = new Usuario();
         
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-DD");
        String usuario = request.getParameter("txtUsuario");
        String password = request.getParameter("txtpassword");
        String nombre = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");
        String correo = request.getParameter("txtemail");
        int codigoPerfil = Integer.parseInt(request.getParameter("ddlPerfil"));
        int idUser =(usuarioSB.findmaXiD()) + 1;
        
        Date fecha = null;
        try {
            if(!request.getParameter("txtFecha").isEmpty()){
                 fecha = sm.parse(request.getParameter("txtFecha"));
            } 
        } catch (Exception e) {
            System.out.println("problemas con la transformacion de la fecha");
        }
       
        usuarioCli.setIdUsuario(idUser); 
        usuarioCli.setNombreUsuario(nombre); 
        usuarioCli.setApellidoUsuario(apellido); 
        usuarioCli.setLoginUsuario(usuario);
        usuarioCli.setPassUsuario(password);
        usuarioCli.setCorreoUsuario(correo);
        usuarioCli.setFechaNacimientousuario(fecha);
        usuarioCli.setCodigoPerfil(codigoPerfil);
        
        try {
             this.usuarioSB.guardarUsuario(usuarioCli);
             request.getSession().setAttribute("msgError", "Usuario registrado"); 
             response.sendRedirect("home.jsp");
        } catch (Exception e) {
            request.getSession().setAttribute("msgError", "Error al grabar información");
           response.sendRedirect("./usuario/addUsuarios.jsp");
        }
       
         
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
