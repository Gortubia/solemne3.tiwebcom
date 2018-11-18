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
@Table(name = "comunas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comunas.findAll", query = "SELECT c FROM Comunas c")
    , @NamedQuery(name = "Comunas.findByComunaId", query = "SELECT c FROM Comunas c WHERE c.comunaId = :comunaId")
    , @NamedQuery(name = "Comunas.findByComunaNombre", query = "SELECT c FROM Comunas c WHERE c.comunaNombre = :comunaNombre")
    , @NamedQuery(name = "Comunas.findByProvinciaId", query = "SELECT c FROM Comunas c WHERE c.provinciaId = :provinciaId")})
public class Comunas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "comuna_id")
    private Integer comunaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "comuna_nombre")
    private String comunaNombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "provincia_id")
    private int provinciaId;

    public Comunas() {
    }

    public Comunas(Integer comunaId) {
        this.comunaId = comunaId;
    }

    public Comunas(Integer comunaId, String comunaNombre, int provinciaId) {
        this.comunaId = comunaId;
        this.comunaNombre = comunaNombre;
        this.provinciaId = provinciaId;
    }

    public Integer getComunaId() {
        return comunaId;
    }

    public void setComunaId(Integer comunaId) {
        this.comunaId = comunaId;
    }

    public String getComunaNombre() {
        return comunaNombre;
    }

    public void setComunaNombre(String comunaNombre) {
        this.comunaNombre = comunaNombre;
    }

    public int getProvinciaId() {
        return provinciaId;
    }

    public void setProvinciaId(int provinciaId) {
        this.provinciaId = provinciaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comunaId != null ? comunaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comunas)) {
            return false;
        }
        Comunas other = (Comunas) object;
        if ((this.comunaId == null && other.comunaId != null) || (this.comunaId != null && !this.comunaId.equals(other.comunaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.duoc.dej4501.solemne3.tiwebcom.entity.Comunas[ comunaId=" + comunaId + " ]";
    }
    
}
