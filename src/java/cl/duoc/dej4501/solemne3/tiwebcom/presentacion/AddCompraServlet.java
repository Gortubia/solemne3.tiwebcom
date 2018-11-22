/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej4501.solemne3.tiwebcom.presentacion;

import cl.duoc.dej4501.solemne3.tiwebcom.entity.Boleta;
import cl.duoc.dej4501.solemne3.tiwebcom.entity.Cliente;
import cl.duoc.dej4501.solemne3.tiwebcom.entity.DetBoleta;
import cl.duoc.dej4501.solemne3.tiwebcom.entity.Producto;
import cl.duoc.dej4501.solemne3.tiwebcom.entity.Sucursal;
import cl.duoc.dej4501.solemne3.tiwebcom.persistence.BoletaSessionBean;
import cl.duoc.dej4501.solemne3.tiwebcom.persistence.DetBoletaSessionBean;
import cl.duoc.dej4501.solemne3.tiwebcom.persistence.ProductoSessionBean; 
import cl.duoc.dej4501.solemne3.tiwebcom.viewDomain.CarritoCompra;
import cl.duoc.dej4501.solemne3.tiwebcom.viewDomain.ProductoCarrito;
import java.io.IOException; 
import java.time.Instant;
import java.util.Date; 
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
@WebServlet(name = "AddCompraServlet", urlPatterns = {"/addCompraServlet","/guardaBoleta"})
public class AddCompraServlet extends HttpServlet {

     @EJB
     private BoletaSessionBean boletaSB;
     @EJB
     private ProductoSessionBean productoSB;
     @EJB
     private DetBoletaSessionBean detBoletaSB;
     private CarritoCompra carritoCompra;
             
     

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

        String msgError = "";
        boolean flag = true;
        HttpSession sesion = request.getSession();
        Boleta boleta = new Boleta();
        int idCliente = 0;
        int idSucursal = 0; 
        Date fecha = null;
        int idBoleta =(boletaSB.findmaXiD()) + 1;
        
         try {
               carritoCompra = (CarritoCompra)request.getSession().getAttribute("carritoCompra");
               
        } catch (Exception e) {
            System.out.println("\n error"+e);
        }
          
        try {
              fecha = Date.from(Instant.now());
        } catch (Exception e) {
            System.out.println("\n Problemas con la transformacion de la fecha"+e);
        }
        
        if (validacion(request)) {
            msgError += "\n Faltan datos de ingreso en el formulario.";
            sesion.setAttribute("msgError", msgError);
        } else {
            try {
                idCliente = Integer.parseInt(request.getParameter("txtIdCliente"));
                

            } catch (Exception ex) {
                msgError += "\nCliente no corresponde" + ex;
                flag = false;
            }
            try {
                idSucursal = Integer.parseInt(request.getParameter("ddlSucursal"));
                
            } catch (Exception ex) {
                msgError += "\nSucursal no corresponde" + ex;
                flag = false;
            }

            if (flag) {

                Cliente cliente = new Cliente();
                cliente.setIdCliente(idCliente);
                Sucursal sucursal = new Sucursal();
                sucursal.setId(idSucursal);
                boleta.setIdBoleta(idBoleta); 
                boleta.setIdCliente(cliente);
                boleta.setIdSucursal(sucursal);
                boleta.setFecha(fecha);
                boleta.setTotal((long)carritoCompra.getTotalCarrito());

                try {
                    this.boletaSB.guardarBoleta(boleta);
                    addDetalleBoleta(request, idBoleta);
                    request.getSession().setAttribute("msgError", "compra realizada");
                    
                    response.sendRedirect("home.jsp");
                } catch (Exception e) {
                    request.getSession().setAttribute("msgError", "Error al grabar información");
                    response.sendRedirect("ventaProd.jsp");
                }
            }
        }
        
    }

    private boolean validacion(HttpServletRequest request) 
                    throws ServletException, IOException{
        try {
            if(request.getParameter("txtIdCliente").isEmpty() ){
                return true;
            }
        } catch (Exception e) {
            System.out.println("error"+e);
        }
        try {
            if(request.getParameter("ddlSucursal").isEmpty() ){
                return true;
            }
        } catch (Exception e) {
            System.out.println("error"+e);
        } 
        return false;            
        }
     
    private boolean addDetalleBoleta(HttpServletRequest request, int idBoleta) {
         
        Boleta boleta = new Boleta();
        boleta.setIdBoleta(idBoleta);
        carritoCompra = (CarritoCompra)request.getSession().getAttribute("carritoCompra");
        
         
            for (ProductoCarrito productoCarrito1 : carritoCompra.getListadoProducosCarrito()) {
                DetBoleta detalleB = new DetBoleta();
               Producto producto = productoSB.getProductoById(productoCarrito1.getIdproducto());
                int idDetBoleta =(detBoletaSB.findmaXiD()) + 1;
              
                detalleB.setIdDetBoleta(idDetBoleta);
                detalleB.setIdBoleta(boleta);
                detalleB.setIdProducto(producto);
                detalleB.setCantidad((long)productoCarrito1.getCantidadProducto());
                detalleB.setSubTotal(productoCarrito1.getSubTotalCarrito());
             
            try {
                    this.detBoletaSB.guardarDetBoleta(detalleB);
                } catch (Exception e) {
                    request.getSession().setAttribute("msgError", "Error al grabar información"+e);
                }   
            }
        
        return true;
            
        }
}
