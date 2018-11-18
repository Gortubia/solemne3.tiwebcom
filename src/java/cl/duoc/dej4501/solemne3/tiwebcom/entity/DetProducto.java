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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adolf
 */
@Entity
@Table(name = "det_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetProducto.findAll", query = "SELECT d FROM DetProducto d")
    , @NamedQuery(name = "DetProducto.findByIdDetProducto", query = "SELECT d FROM DetProducto d WHERE d.idDetProducto = :idDetProducto")
    , @NamedQuery(name = "DetProducto.findByDescripcion", query = "SELECT d FROM DetProducto d WHERE d.descripcion = :descripcion")
    , @NamedQuery(name = "DetProducto.findByDetalleProducto", query = "SELECT d FROM DetProducto d WHERE d.detalleProducto = :detalleProducto")})
public class DetProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_det_producto")
    private Integer idDetProducto;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 100)
    @Column(name = "detalleProducto")
    private String detalleProducto;
    @JoinColumn(name = "id_producto", referencedColumnName = "id")
    @ManyToOne
    private Producto idProducto;

    public DetProducto() {
    }

    public DetProducto(Integer idDetProducto) {
        this.idDetProducto = idDetProducto;
    }

    public Integer getIdDetProducto() {
        return idDetProducto;
    }

    public void setIdDetProducto(Integer idDetProducto) {
        this.idDetProducto = idDetProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDetalleProducto() {
        return detalleProducto;
    }

    public void setDetalleProducto(String detalleProducto) {
        this.detalleProducto = detalleProducto;
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
        hash += (idDetProducto != null ? idDetProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetProducto)) {
            return false;
        }
        DetProducto other = (DetProducto) object;
        if ((this.idDetProducto == null && other.idDetProducto != null) || (this.idDetProducto != null && !this.idDetProducto.equals(other.idDetProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.duoc.dej4501.solemne3.tiwebcom.entity.DetProducto[ idDetProducto=" + idDetProducto + " ]";
    }
    
}
