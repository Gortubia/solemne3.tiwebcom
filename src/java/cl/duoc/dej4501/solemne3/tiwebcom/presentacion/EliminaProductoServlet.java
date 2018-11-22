/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej4501.solemne3.tiwebcom.presentacion;

import cl.duoc.dej4501.solemne3.tiwebcom.persistence.ProductoSessionBean;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "EliminaProductoServlet", urlPatterns = {"/eliminaProductoServlet","eliminarProducto"})
public class EliminaProductoServlet extends HttpServlet {

     @EJB
     private ProductoSessionBean productoSB;
     

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
        int id = 0;
        try {
             id = Integer.parseInt(request.getParameter("codigo"));
        } catch (NumberFormatException e) {
            System.out.println("error"+e);
        }

        try {
            this.productoSB.deleteProducto(id);
            request.getSession().setAttribute("msgError","informacion eliminada");
             response.sendRedirect("producto/listProducto.jsp");
        
        } catch (Exception e) {
        request.getSession().setAttribute("msgError","informacion NO eliminada");
        response.sendRedirect("producto/listProducto.jsp.jsp");
        
        }
        
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
