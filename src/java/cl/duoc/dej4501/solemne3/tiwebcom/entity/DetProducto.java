/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej4501.solemne3.tiwebcom.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adolf
 */
@Entity
@Table(name = "det_producto", catalog = "bdtiwebcom", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetProducto.findAll", query = "SELECT d FROM DetProducto d")
    , @NamedQuery(name = "DetProducto.findByIdDetProducto", query = "SELECT d FROM DetProducto d WHERE d.idDetProducto = :idDetProducto")
    , @NamedQuery(name = "DetProducto.findByEditorial", query = "SELECT d FROM DetProducto d WHERE d.editorial = :editorial")
    , @NamedQuery(name = "DetProducto.findByAutor", query = "SELECT d FROM DetProducto d WHERE d.autor = :autor")
    , @NamedQuery(name = "DetProducto.findByFechaPublicacion", query = "SELECT d FROM DetProducto d WHERE d.fechaPublicacion = :fechaPublicacion")
    , @NamedQuery(name = "DetProducto.findByNEdicion", query = "SELECT d FROM DetProducto d WHERE d.nEdicion = :nEdicion")
    , @NamedQuery(name = "DetProducto.findByPaginas", query = "SELECT d FROM DetProducto d WHERE d.paginas = :paginas")
    , @NamedQuery(name = "DetProducto.findByBorrado", query = "SELECT d FROM DetProducto d WHERE d.borrado = :borrado")})
public class DetProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_det_producto")
    private Integer idDetProducto;
    @Size(max = 100)
    private String editorial;
    @Size(max = 100)
    private String autor;
    @Column(name = "fecha_publicacion")
    @Temporal(TemporalType.DATE)
    private Date fechaPublicacion;
    @Column(name = "n_edicion")
    private Integer nEdicion;
    private Integer paginas;
    private Integer borrado;
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

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Integer getNEdicion() {
        return nEdicion;
    }

    public void setNEdicion(Integer nEdicion) {
        this.nEdicion = nEdicion;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    public Integer getBorrado() {
        return borrado;
    }

    public void setBorrado(Integer borrado) {
        this.borrado = borrado;
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
