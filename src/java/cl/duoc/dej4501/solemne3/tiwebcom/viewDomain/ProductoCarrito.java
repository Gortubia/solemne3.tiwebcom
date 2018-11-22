/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej4501.solemne3.tiwebcom.viewDomain;

/**
 *
 * @author adolf
 */
public class ProductoCarrito {
    
    private int idproducto;
    private int cantidadProducto;
    private int subTotalCarrito; 

    public ProductoCarrito() {
    }

    public ProductoCarrito(int idproducto, int cantidadProducto, int subTotalCarrito) {
        this.idproducto = idproducto;
        this.cantidadProducto = cantidadProducto;
        this.subTotalCarrito = subTotalCarrito;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public int getSubTotalCarrito() {
        return subTotalCarrito;
    }

    public void setSubTotalCarrito(int subTotalCarrito) {
        this.subTotalCarrito = subTotalCarrito;
    }
    
    
    
}
