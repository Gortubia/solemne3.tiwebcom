<%-- 
    Document   : addAcount
    Created on : 17-nov-2018, 19:49:35
    Author     : adolf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <!--Import materialize.css-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/css/materialize.min.css"/>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Cuenta</title>
        <link rel="icon" href="img/logo.ico">
    </head>
    <body>
        <nav class="indigo " role="navigation">
            <div class="col m8 s8 offset-m2 offset-s2 center">
            <h4>Crear cuenta en tiwebcom.</h4>
            </div>
            <c:if test="${sessionScope.msgError != null}"> 
                <div class="alert alert-success toast center" role="alert"  >
                    <c:if test="${sessionScope.msgError!=null}"> 
                        <fieldset><legend>Mensajes</legend>
                            <c:out value="${sessionScope.msgError}"></c:out>
                            <c:remove var="msgError"></c:remove>
                            </fieldset> 
                    </c:if>
                </div>
            </c:if> 
        </nav>
        <div class="container">  
                <div class="parallax"><img src="img/comics/1.png"></div>
                <div class="row"><br>
                    <div class="col m8 s8 offset-m2 offset-s2 center">
                        <h4 class="truncate bg-card-user">
                            <img src="img/logo.png" width="100" height="100" class="circle responsive-img">
                            <div class="row">
                                
                                <form  class="col s12" name="frmaddCliente" method="POST" action="./addCliente">

                                    <div class="row">
                                        <div class="input-field col s6">
                                            <input  id="txtNombre" name="txtNombre" type="text" class="validate">
                                            <label for="txtNombre">Nombre</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <input id="txtApellido" name="txtApellido" type="text" class="validate">
                                            <label for="txtApellido">Apellido</label>
                                        </div>
                                    </div>
                                     <div class="row">
                                        <div class="input-field col s6">
                                            <input  id="txtUsuario" type="text" class="validate">
                                            <label for="txtUsuario">Usuario</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <input id="password" type="password" class="validate">
                                            <label for="password">Password</label>
                                        </div>
                                    </div>
                                     
                                    <div class="row">
                                        <div class="input-field col s12">
                                            <input id="email" type="email" class="validate">
                                            <label for="email">Email</label>
                                        </div>
                                    </div>
                                   
                                    <div class="row">
                                        <button class="btn waves-effect waves-light" type="submit" name="action">Crear cuenta</button>
                                    </div>
                                </form>
                            </div>
                        </h4>
                    </div>
                </div>
            
        </div>
 
    
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
    <script src="mySpxript.js"></script>
</body>
</html>
