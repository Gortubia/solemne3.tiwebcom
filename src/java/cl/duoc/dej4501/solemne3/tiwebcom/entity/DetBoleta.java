/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej4501.solemne3.tiwebcom.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adolf
 */
@Entity
@Table(name = "det_boleta", catalog = "bdtiwebcom", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetBoleta.findAll", query = "SELECT d FROM DetBoleta d")
    , @NamedQuery(name = "DetBoleta.findByIdDetBoleta", query = "SELECT d FROM DetBoleta d WHERE d.idDetBoleta = :idDetBoleta")
    , @NamedQuery(name = "DetBoleta.findByCantidad", query = "SELECT d FROM DetBoleta d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "DetBoleta.findBySubTotal", query = "SELECT d FROM DetBoleta d WHERE d.subTotal = :subTotal")})
public class DetBoleta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_det_boleta")
    private Integer idDetBoleta;
    private Long cantidad;
    @Column(name = "sub_total")
    private Integer subTotal;
    @JoinColumn(name = "id_boleta", referencedColumnName = "id_boleta")
    @ManyToOne
    private Boleta idBoleta;
    @JoinColumn(name = "id_producto", referencedColumnName = "id")
    @ManyToOne
    private Producto idProducto;

    public DetBoleta() {
    }

    public DetBoleta(Integer idDetBoleta) {
        this.idDetBoleta = idDetBoleta;
    }

    public Integer getIdDetBoleta() {
        return idDetBoleta;
    }

    public void setIdDetBoleta(Integer idDetBoleta) {
        this.idDetBoleta = idDetBoleta;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Integer subTotal) {
        this.subTotal = subTotal;
    }

    public Boleta getIdBoleta() {
        return idBoleta;
    }

    public void setIdBoleta(Boleta idBoleta) {
        this.idBoleta = idBoleta;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetBoleta != null ? idDetBoleta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetBoleta)) {
            return false;
        }
        DetBoleta other = (DetBoleta) object;
        if ((this.idDetBoleta == null && other.idDetBoleta != null) || (this.idDetBoleta != null && !this.idDetBoleta.equals(other.idDetBoleta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.duoc.dej4501.solemne3.tiwebcom.entity.DetBoleta[ idDetBoleta=" + idDetBoleta + " ]";
    }
    
}
