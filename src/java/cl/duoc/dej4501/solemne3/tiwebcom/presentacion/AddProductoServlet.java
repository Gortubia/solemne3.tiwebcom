/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej4501.solemne3.tiwebcom.presentacion;

import cl.duoc.dej4501.solemne3.tiwebcom.entity.Producto;
import cl.duoc.dej4501.solemne3.tiwebcom.persistence.ProductoSessionBean;
import java.io.IOException; 
import java.util.List;
import javax.ejb.EJB;
import javax.persistence.EnumType;
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
@WebServlet(name = "AddProductoServlet", urlPatterns = {"/addProductoServlet","/cargaProductos"})
public class AddProductoServlet extends HttpServlet {

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
         
         HttpSession sesion = request.getSession();
        List<Producto> listaProductos = this.productoSB.getAllProductos();
        sesion.setAttribute("listaProductos", listaProductos);
        response.sendRedirect("./producto/listProducto.jsp");
        
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
        
         Producto prod = new Producto();
         String dir =  request.getContextPath();
         
        String nombre = request.getParameter("txtNombre");
        int precio = Integer.parseInt(request.getParameter("txtPrecio"));
        String categoria = request.getParameter("txtDescripcion");
        int stock = Integer.parseInt(request.getParameter("txtStock"));
        int idProd =(productoSB.findmaXiD()) + 1;
        
         
        prod.setId(idProd); 
        prod.setNombreProducto(nombre);
        prod.setPrecio(precio); 
        prod.setCategoria(categoria); 
        prod.setStock(stock);
        
        
        try {
             this.productoSB.guardarProducto(prod);
                 request.getSession().setAttribute("msgError", "Producto registrado"); 
             response.sendRedirect("./producto/listProducto.jsp");
        } catch (Exception e) {
            request.getSession().setAttribute("msgError", "Error al grabar información");
           response.sendRedirect("./producto/addProducto.jsp");
        }
        
        
        
    }

     

}
