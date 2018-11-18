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
@Table(name = "provincias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Provincias.findAll", query = "SELECT p FROM Provincias p")
    , @NamedQuery(name = "Provincias.findByProvinciaId", query = "SELECT p FROM Provincias p WHERE p.provinciaId = :provinciaId")
    , @NamedQuery(name = "Provincias.findByProvinciaNombre", query = "SELECT p FROM Provincias p WHERE p.provinciaNombre = :provinciaNombre")
    , @NamedQuery(name = "Provincias.findByRegionId", query = "SELECT p FROM Provincias p WHERE p.regionId = :regionId")})
public class Provincias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "provincia_id")
    private Integer provinciaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "provincia_nombre")
    private String provinciaNombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "region_id")
    private int regionId;

    public Provincias() {
    }

    public Provincias(Integer provinciaId) {
        this.provinciaId = provinciaId;
    }

    public Provincias(Integer provinciaId, String provinciaNombre, int regionId) {
        this.provinciaId = provinciaId;
        this.provinciaNombre = provinciaNombre;
        this.regionId = regionId;
    }

    public Integer getProvinciaId() {
        return provinciaId;
    }

    public void setProvinciaId(Integer provinciaId) {
        this.provinciaId = provinciaId;
    }

    public String getProvinciaNombre() {
        return provinciaNombre;
    }

    public void setProvinciaNombre(String provinciaNombre) {
        this.provinciaNombre = provinciaNombre;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (provinciaId != null ? provinciaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Provincias)) {
            return false;
        }
        Provincias other = (Provincias) object;
        if ((this.provinciaId == null && other.provinciaId != null) || (this.provinciaId != null && !this.provinciaId.equals(other.provinciaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.duoc.dej4501.solemne3.tiwebcom.entity.Provincias[ provinciaId=" + provinciaId + " ]";
    }
    
}
