/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej4501.solemne3.tiwebcom.viewDomain;

import java.util.List;

/**
 *
 * @author adolf
 */
public class CarritoCompra {
     
    private int totalCarrito;
    private List<ProductoCarrito> listadoProducosCarrito;

    public CarritoCompra() {
    }

    public CarritoCompra(int totalCarrito, List<ProductoCarrito> listadoProducosCarrito) {
        this.totalCarrito = totalCarrito;
        this.listadoProducosCarrito = listadoProducosCarrito;
    }

    public int getTotalCarrito() {
        return totalCarrito;
    }

    public void setTotalCarrito(int totalCarrito) {
        this.totalCarrito = totalCarrito;
    }

    public List<ProductoCarrito> getListadoProducosCarrito() {
        return listadoProducosCarrito;
    }

    public void setListadoProducosCarrito(List<ProductoCarrito> listadoProducosCarrito) {
        this.listadoProducosCarrito = listadoProducosCarrito;
    }
    
    
    
}
