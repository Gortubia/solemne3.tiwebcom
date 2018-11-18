/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej4501.solemne3.tiwebcom.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author adolf
 */
@Entity
@Table(name = "boleta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Boleta.findAll", query = "SELECT b FROM Boleta b")
    , @NamedQuery(name = "Boleta.findByIdBoleta", query = "SELECT b FROM Boleta b WHERE b.idBoleta = :idBoleta")
    , @NamedQuery(name = "Boleta.findByFecha", query = "SELECT b FROM Boleta b WHERE b.fecha = :fecha")
    , @NamedQuery(name = "Boleta.findByTotal", query = "SELECT b FROM Boleta b WHERE b.total = :total")})
public class Boleta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_boleta")
    private Integer idBoleta;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "total")
    private Long total;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne
    private Cliente idCliente;
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id")
    @ManyToOne
    private Sucursal idSucursal;
    @OneToMany(mappedBy = "idBoleta")
    private List<DetBoleta> detBoletaList;

    public Boleta() {
    }

    public Boleta(Integer idBoleta) {
        this.idBoleta = idBoleta;
    }

    public Integer getIdBoleta() {
        return idBoleta;
    }

    public void setIdBoleta(Integer idBoleta) {
        this.idBoleta = idBoleta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Sucursal getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Sucursal idSucursal) {
        this.idSucursal = idSucursal;
    }

    @XmlTransient
    public List<DetBoleta> getDetBoletaList() {
        return detBoletaList;
    }

    public void setDetBoletaList(List<DetBoleta> detBoletaList) {
        this.detBoletaList = detBoletaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBoleta != null ? idBoleta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Boleta)) {
            return false;
        }
        Boleta other = (Boleta) object;
        if ((this.idBoleta == null && other.idBoleta != null) || (this.idBoleta != null && !this.idBoleta.equals(other.idBoleta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.duoc.dej4501.solemne3.tiwebcom.entity.Boleta[ idBoleta=" + idBoleta + " ]";
    }
    
}
