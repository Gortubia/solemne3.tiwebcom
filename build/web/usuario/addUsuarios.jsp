<%-- 
    Document   : addUsuarios
    Created on : 18-nov-2018, 22:47:36
    Author     : adolf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <!--Import materialize.css-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/css/materialize.min.css"/>
        <title>Agregar Usuario</title>
        <link rel="icon" href="img/logo.ico">

          <script type = "text/javascript"
         src = "https://code.jquery.com/jquery-2.1.1.min.js"></script>           
      <script src = "https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/js/materialize.min.js">
      </script> 
      
      <script>
         $(document).ready(function() {
            $('select').material_select();
         });
      </script>

    </head>
    <body>
        <c:if test="${sessionScope.usuarioConectado == null}">
        <c:redirect url="login.jsp"></c:redirect></c:if>
        <jsp:useBean   id="perfil" class="cl.duoc.dej4501.solemne3.tiwebcom.entity.Perfil" scope="page" ></jsp:useBean>
        <jsp:include page="../getPerfiles" flush="true"></jsp:include>  
         
            <nav class="indigo " role="navigation"> 
                <div class="col m8 s8 offset-m2 offset-s2 center">
                    <h4>Mantenedor Usuarios</h4>
                </div>
            <c:if test="${sessionScope.msgError != null}"> 
                <div class="center-align toast " displayLength="300" role=""  >
                    <c:if test="${sessionScope.msgError!=null}"> 
                        <fieldset><legend>Mensajes</legend>
                            <c:out value="${sessionScope.msgError}"></c:out>
                            <c:remove var="msgError"></c:remove>
                            </fieldset>

                    </c:if>
                </div> 
            </c:if>
        </nav>
        <div class=" container"> 
                <!-- Example DataTables Card-->
                <div class="card  mb-3">
                    <div class="card-header">
                        <i class="fa fa-user"></i>Agregar Usuarios al sistema</div>
                    <div class="card-body"> 
                        <form  class="col s12" name="frmaddCliente" method="POST" action="../addUsuarioUserServlet">

                            <div class="row">

                                <div class="input-field col s6"> 
                                    <input  id="txtUsuario" name="txtUsuario" type="text" class="validate" required="true"> 
                                    <label class="center-align" for="txtUsuario">Usuario *</label>

                                </div>
                                <div class="input-field col s6"> 
                                    <input id="password" name="txtpassword" type="password" class="validate" required="true"> 
                                    <label class="center-align" for="password">Contraseña *</label>

                                </div>
                            </div>

                            <div class="row">
                                <div class="input-field col s6"> 
                                    <input  id="txtNombre" name="txtNombre" type="text" class="validate">
                                    <label class="center-align" for="txtNombre">Nombre</label>
                                </div>
                                <div class="input-field col s6"> 
                                    <input id="txtApellido" name="txtApellido" type="text" class="validate">
                                    <label class="center-align" for="txtApellido">Apellido</label>
                                </div>
                            </div>
                            <div class="row">
                            <div class="input-field col s6">                               
                              <div class="form-row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label class="center-align" for="frPerfil"></label>
                                            <select class="center-align form-control" name="ddlPerfil" id="ddlPerfil" required="">
                                                <option value="-1">Seleione perfil usuario</option>
                                                <c:forEach items="${sessionScope.listaPerfil}" var="perfil">
                                                    <option value="${perfil.idPerfil}"><c:out value="${perfil.nombrePerfil}"></c:out></option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        </div>
                                  </div>
                            </div>
            
                                
                                <div class="input-field col s6"> 
                                    <input  id="txtFeNacimiento" name="txtFecha" type="date" class="validate">
                                    <label class="center-align" for="txtFeNacimiento">Fecha Nacimiento</label>
                                </div>


                            </div> 
                            <div class="row">
                                <div class="input-field col s12"> 
                                    <input id="txtemail" name="txtemail" type="email" class="validate">
                                    <label class="center-align" for="txtemail">Email</label>
                                </div>
                            </div>
                            <div class="row center-align">
                                <label for="msg">* (Obligatorio)</label>
                                
                            </div>
                            <div class="row center-align">
                                <button class="btn waves-effect waves-light" type="submit" name="action">Crear cuenta</button>
                            </div>
                        </form>
                    </div>
                    <div class="card-footer small text-muted center-align"> Agregar Usuarios</div>    
                </div>
            </div>  
 
    </body>
</html>