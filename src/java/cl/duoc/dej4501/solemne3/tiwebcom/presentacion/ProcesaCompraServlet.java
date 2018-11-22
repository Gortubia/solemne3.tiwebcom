/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej4501.solemne3.tiwebcom.presentacion;

import cl.duoc.dej4501.solemne3.tiwebcom.entity.Producto;
import cl.duoc.dej4501.solemne3.tiwebcom.persistence.ProductoSessionBean;
import cl.duoc.dej4501.solemne3.tiwebcom.viewDomain.CarritoCompra;
import cl.duoc.dej4501.solemne3.tiwebcom.viewDomain.ProductoCarrito;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
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
@WebServlet(name = "ProcesaCompraServlet", urlPatterns = {"/procesaCompraServlet"})
public class ProcesaCompraServlet extends HttpServlet {
    
    @EJB
    private ProductoSessionBean productoSB;
    private CarritoCompra carritoCompra = new CarritoCompra();

    
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
        
         int codigoborrar = 0;
         
        
        try {
            codigoborrar = Integer.parseInt(request.getParameter("codigo"));
        } catch (Exception e) {
            System.out.println("datos para carro");
            codigoborrar = -1;
        }
        
        if(codigoborrar == -1)
        {
            response.sendRedirect("ventaProd.jsp"); 
        }else{
            carritoCompra = (CarritoCompra)request.getSession().getAttribute("carritoCompra"); 
            
            for (ProductoCarrito productoCarrito1 : carritoCompra.getListadoProducosCarrito()) {
                if(productoCarrito1.getIdproducto()==codigoborrar){
                    try {
                         carritoCompra.setTotalCarrito(carritoCompra.getTotalCarrito() - productoCarrito1.getSubTotalCarrito());
                         if(carritoCompra.getListadoProducosCarrito().remove(productoCarrito1))
                              {
                                 request.getSession().setAttribute("carritoCompra", carritoCompra);
                                 response.sendRedirect("ventaProd.jsp");  
                               }
                    } catch (Exception e) {
                        System.out.println("error"+e);
                    }
                    
                     
                }
            }
            
           
        }
        response.sendRedirect("ventaProd.jsp");
         
        
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
        
        
        ProductoCarrito productoCarrito;
        String msgError = "";
        int cantidad = 0;
        int codigo = 0;
        int subTotal = 0;
        int total = 0;

        boolean flag = true;
        HttpSession sesion = request.getSession();

        if (validacion(request)) {
            msgError += "\n faltan datos de ingreso en el formulario.";
            sesion.setAttribute("msgError", msgError);
        } else {
            try {
                cantidad = Integer.parseInt(request.getParameter("txtUnidades"));
            } catch (Exception ex) {
                msgError += "\nUnidades no corresponde" + ex;
                flag = false;
            }
            try {
                codigo = Integer.parseInt(request.getParameter("txtCodigo"));
            } catch (Exception ex) {
                msgError += "\nCodigo no corresponde" + ex;
                flag = false;
            }
            try {
                subTotal = calculoSubTotal(cantidad,codigo);
                total = calculoTotal(request, subTotal);
            } catch (Exception ex) {
                msgError += "\nerror" + ex;
                flag = false;
            }

            if (flag) {
                
                productoCarrito = new ProductoCarrito(codigo,cantidad,subTotal);
                List <ProductoCarrito> listProdCarrito = new LinkedList<>();
                listProdCarrito.add(productoCarrito);
                

                if (request.getSession().getAttribute("carritoCompra") == null) {
                     carritoCompra = new CarritoCompra();
                     carritoCompra.setTotalCarrito(total);
                     carritoCompra.setListadoProducosCarrito(listProdCarrito);
                    request.getSession().setAttribute("carritoCompra", carritoCompra);
                } else {
                    boolean flag2 = true;
                   CarritoCompra requestcarritoCompra = (CarritoCompra) request.getSession().getAttribute("carritoCompra");
                    /**
                     *
                     * @author adolf // verificamos si ya se encuentra el articulo en la lista para sumarle 
                     * la cantidad de articulos y el subTotal
                     */
                    int cantidadAsumar = 0;
                    int subTotalAsumar = 0;
                    for (ProductoCarrito productoCarrito1 : requestcarritoCompra.getListadoProducosCarrito()) {
                        if (productoCarrito1.getIdproducto() == codigo) {
                            cantidadAsumar = productoCarrito1.getCantidadProducto() + cantidad;
                            subTotalAsumar = productoCarrito1.getSubTotalCarrito() + subTotal;
                            productoCarrito1.setCantidadProducto(cantidadAsumar);
                            productoCarrito1.setSubTotalCarrito(subTotalAsumar);
                            requestcarritoCompra.setTotalCarrito(total + subTotal);
                            flag2 = false;
                            request.getSession().setAttribute("carritoCompra", carritoCompra);
                        }
                    }
                    if(flag2){
                     List<ProductoCarrito> requestProductoscarrito = requestcarritoCompra.getListadoProducosCarrito();
                    requestProductoscarrito.add(productoCarrito);
                    requestcarritoCompra.setListadoProducosCarrito(requestProductoscarrito);
                    requestcarritoCompra.setTotalCarrito(total + subTotal);
                    request.getSession().setAttribute("carritoCompra", carritoCompra);
                    }
                    
                   
                    
                }

            }
        }
        response.sendRedirect("ventaProd.jsp");

    }

    private boolean validacion(HttpServletRequest request) {
        return request.getParameter("txtUnidades").isEmpty()
                || request.getParameter("txtCodigo").isEmpty() ;

    }
    private int calculoSubTotal(int cantidad, int idProducto) {
        int subTotal = 0; 
        Producto producto = productoSB.getProductoById(idProducto);
         
        try {
                  subTotal = producto.getPrecio() * cantidad ; 
        } catch (Exception e) {
            System.out.println("error"+e);
        }
          
           return subTotal;   
        }
    private int calculoTotal(HttpServletRequest request, int subTotal) {
        int total = 0;
        try {
            
            if (request.getSession().getAttribute("carritoCompra") == null) { 
                total = subTotal;
            }else{
                 carritoCompra = (CarritoCompra)request.getSession().getAttribute("carritoCompra");
                for (ProductoCarrito productoCarrito1 : carritoCompra.getListadoProducosCarrito()) { 
                 total = total + (productoCarrito1.getSubTotalCarrito());
                } 
            } 
        } catch (Exception e) {
            System.out.println("error"+e);
        }
          return total;
            
        }
}
