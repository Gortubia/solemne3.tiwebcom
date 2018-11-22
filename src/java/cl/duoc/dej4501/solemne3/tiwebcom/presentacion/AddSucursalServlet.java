/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej4501.solemne3.tiwebcom.presentacion;

import cl.duoc.dej4501.solemne3.tiwebcom.entity.Sucursal;
import cl.duoc.dej4501.solemne3.tiwebcom.persistence.SucursalSessionBean;
import java.io.IOException; 
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
@WebServlet(name = "AddSucursalServlet", urlPatterns = {"/addSucursalServlet"})
public class AddSucursalServlet extends HttpServlet {

   @EJB
   private SucursalSessionBean sucursalSB;

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
        Sucursal sucursal = new Sucursal();
         
        
        String descripcion = request.getParameter("txtDescripcion");
        String direccion = request.getParameter("txtDireccion");
        String telefono = request.getParameter("txtTelefono");
        int cod_comuna = Integer.parseInt(request.getParameter("ddlComuna"));
        //int idSucursal =(sucursalSB.findmaXiD()) + 1;
        
        
        sucursal.setDescripcion(descripcion); 
        sucursal.setDireccion(direccion); 
        sucursal.setTelefono(telefono); 
        sucursal.setCodComuna(cod_comuna);
        
        try {
             this.sucursalSB.guardarSucursal(sucursal);
             request.getSession().setAttribute("msgError", "Sucursal creada"); 
             response.sendRedirect("./sucursal/listSucursal.jsp");
        } catch (Exception e) {
            request.getSession().setAttribute("msgError", "Error al grabar información");
           response.sendRedirect("./sucursal/addSucursal.jsp");
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
