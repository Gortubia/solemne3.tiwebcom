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
@Table(name = "regiones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Regiones.findAll", query = "SELECT r FROM Regiones r")
    , @NamedQuery(name = "Regiones.findByRegionId", query = "SELECT r FROM Regiones r WHERE r.regionId = :regionId")
    , @NamedQuery(name = "Regiones.findByRegionNombre", query = "SELECT r FROM Regiones r WHERE r.regionNombre = :regionNombre")
    , @NamedQuery(name = "Regiones.findByRegionOrdinal", query = "SELECT r FROM Regiones r WHERE r.regionOrdinal = :regionOrdinal")})
public class Regiones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "region_id")
    private Integer regionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "region_nombre")
    private String regionNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "region_ordinal")
    private String regionOrdinal;

    public Regiones() {
    }

    public Regiones(Integer regionId) {
        this.regionId = regionId;
    }

    public Regiones(Integer regionId, String regionNombre, String regionOrdinal) {
        this.regionId = regionId;
        this.regionNombre = regionNombre;
        this.regionOrdinal = regionOrdinal;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getRegionNombre() {
        return regionNombre;
    }

    public void setRegionNombre(String regionNombre) {
        this.regionNombre = regionNombre;
    }

    public String getRegionOrdinal() {
        return regionOrdinal;
    }

    public void setRegionOrdinal(String regionOrdinal) {
        this.regionOrdinal = regionOrdinal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (regionId != null ? regionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Regiones)) {
            return false;
        }
        Regiones other = (Regiones) object;
        if ((this.regionId == null && other.regionId != null) || (this.regionId != null && !this.regionId.equals(other.regionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.duoc.dej4501.solemne3.tiwebcom.entity.Regiones[ regionId=" + regionId + " ]";
    }
    
}
