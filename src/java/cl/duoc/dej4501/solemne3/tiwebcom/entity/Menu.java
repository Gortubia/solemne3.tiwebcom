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
 * SELECT * FROM menu WHERE id_perfil=? ORDER BY padre_menu
 * @author adolf 
 */
@Entity
@Table(catalog = "bdtiwebcom", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m")
    , @NamedQuery(name = "Menu.findByIdPerfil", query = "SELECT m FROM Menu m WHERE m.idCodigo.idPerfil = :idCodigo ORDER BY m.padreMenu")
    , @NamedQuery(name = "Menu.findByIdMenu", query = "SELECT m FROM Menu m WHERE m.idMenu = :idMenu")
    , @NamedQuery(name = "Menu.findByNombreMenu", query = "SELECT m FROM Menu m WHERE m.nombreMenu = :nombreMenu")
    , @NamedQuery(name = "Menu.findByPadreMenu", query = "SELECT m FROM Menu m WHERE m.padreMenu = :padreMenu")
    , @NamedQuery(name = "Menu.findByDestinoMenu", query = "SELECT m FROM Menu m WHERE m.destinoMenu = :destinoMenu")})
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_menu")
    private Integer idMenu;
    @Size(max = 50)
    @Column(name = "nombre_menu")
    private String nombreMenu;
    @Column(name = "padre_menu")
    private Integer padreMenu;
    @Size(max = 250)
    @Column(name = "destino_menu")
    private String destinoMenu;
    @JoinColumn(name = "id_codigo", referencedColumnName = "id_perfil")
    @ManyToOne
    private Perfil idCodigo;

    public Menu() {
    }

    public Menu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public String getNombreMenu() {
        return nombreMenu;
    }

    public void setNombreMenu(String nombreMenu) {
        this.nombreMenu = nombreMenu;
    }

    public Integer getPadreMenu() {
        return padreMenu;
    }

    public void setPadreMenu(Integer padreMenu) {
        this.padreMenu = padreMenu;
    }

    public String getDestinoMenu() {
        return destinoMenu;
    }

    public void setDestinoMenu(String destinoMenu) {
        this.destinoMenu = destinoMenu;
    }

    public Perfil getIdCodigo() {
        return idCodigo;
    }

    public void setIdCodigo(Perfil idCodigo) {
        this.idCodigo = idCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMenu != null ? idMenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.idMenu == null && other.idMenu != null) || (this.idMenu != null && !this.idMenu.equals(other.idMenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.duoc.dej4501.solemne3.tiwebcom.entity.Menu[ idMenu=" + idMenu + " ]";
    }
    
}
