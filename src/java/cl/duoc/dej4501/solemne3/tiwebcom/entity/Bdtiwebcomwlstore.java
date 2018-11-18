/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej4501.solemne3.tiwebcom.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adolf
 */
@Entity
@Table(catalog = "bdtiwebcom", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bdtiwebcomwlstore.findAll", query = "SELECT b FROM Bdtiwebcomwlstore b")
    , @NamedQuery(name = "Bdtiwebcomwlstore.findById", query = "SELECT b FROM Bdtiwebcomwlstore b WHERE b.id = :id")
    , @NamedQuery(name = "Bdtiwebcomwlstore.findByType", query = "SELECT b FROM Bdtiwebcomwlstore b WHERE b.type = :type")
    , @NamedQuery(name = "Bdtiwebcomwlstore.findByHandle", query = "SELECT b FROM Bdtiwebcomwlstore b WHERE b.handle = :handle")})
public class Bdtiwebcomwlstore implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer id;
    @Basic(optional = false)
    @NotNull
    private int type;
    @Basic(optional = false)
    @NotNull
    private int handle;
    @Basic(optional = false)
    @NotNull
    @Lob
    private byte[] record;

    public Bdtiwebcomwlstore() {
    }

    public Bdtiwebcomwlstore(Integer id) {
        this.id = id;
    }

    public Bdtiwebcomwlstore(Integer id, int type, int handle, byte[] record) {
        this.id = id;
        this.type = type;
        this.handle = handle;
        this.record = record;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getHandle() {
        return handle;
    }

    public void setHandle(int handle) {
        this.handle = handle;
    }

    public byte[] getRecord() {
        return record;
    }

    public void setRecord(byte[] record) {
        this.record = record;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bdtiwebcomwlstore)) {
            return false;
        }
        Bdtiwebcomwlstore other = (Bdtiwebcomwlstore) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.duoc.dej4501.solemne3.tiwebcom.entity.Bdtiwebcomwlstore[ id=" + id + " ]";
    }
    
}
