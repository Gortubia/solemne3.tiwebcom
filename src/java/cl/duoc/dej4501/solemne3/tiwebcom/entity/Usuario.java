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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    ,@NamedQuery(name = "Usuario.validador", query = "SELECT u FROM Usuario u WHERE u.loginUsuario = :loginUsuario AND u.passUsuario = :passUsuario")
    , @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario")
    , @NamedQuery(name = "Usuario.findByLoginUsuario", query = "SELECT u FROM Usuario u WHERE u.loginUsuario = :loginUsuario")
    , @NamedQuery(name = "Usuario.findByPassUsuario", query = "SELECT u FROM Usuario u WHERE u.passUsuario = :passUsuario")
    , @NamedQuery(name = "Usuario.findByNombreUsuario", query = "SELECT u FROM Usuario u WHERE u.nombreUsuario = :nombreUsuario")
    , @NamedQuery(name = "Usuario.findByApellidoUsuario", query = "SELECT u FROM Usuario u WHERE u.apellidoUsuario = :apellidoUsuario")
    , @NamedQuery(name = "Usuario.findByCorreoUsuario", query = "SELECT u FROM Usuario u WHERE u.correoUsuario = :correoUsuario")
    , @NamedQuery(name = "Usuario.findByFechaNacimientousuario", query = "SELECT u FROM Usuario u WHERE u.fechaNacimientousuario = :fechaNacimientousuario")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Size(max = 15)
    @Column(name = "login_usuario")
    private String loginUsuario;
    @Size(max = 10)
    @Column(name = "pass_usuario")
    private String passUsuario;
    @Size(max = 15)
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @Size(max = 25)
    @Column(name = "apellido_usuario")
    private String apellidoUsuario;
    @Size(max = 50)
    @Column(name = "correo_usuario")
    private String correoUsuario;
    @Column(name = "fechaNacimiento_usuario")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimientousuario;
    @JoinColumn(name = "codigo_perfil", referencedColumnName = "id_perfil")
    @ManyToOne
    private Perfil codigoPerfil;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    public String getPassUsuario() {
        return passUsuario;
    }

    public void setPassUsuario(String passUsuario) {
        this.passUsuario = passUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public Date getFechaNacimientousuario() {
        return fechaNacimientousuario;
    }

    public void setFechaNacimientousuario(Date fechaNacimientousuario) {
        this.fechaNacimientousuario = fechaNacimientousuario;
    }

    public Perfil getCodigoPerfil() {
        return codigoPerfil;
    }

    public void setCodigoPerfil(Perfil codigoPerfil) {
        this.codigoPerfil = codigoPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.duoc.dej4501.solemne3.tiwebcom.entity.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
