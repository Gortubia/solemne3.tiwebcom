<%-- 
    Document   : login
    Created on : 11-nov-2018, 16:50:47
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
        <title>Login</title>
        <link rel="icon" href="img/logo.ico">
    </head>
    <body>
        <nav class="indigo " role="navigation"> 
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
            <div class="parallax-container logueo">
                <div class="parallax"><img src="img/logo.png"></div>
                <div class="row"><br>
                    <div class="col m8 s8 offset-m2 offset-s2 center">
                        <h4 class="truncate bg-card-user"> 
                            <img src="img/logo.png" width="100" height="100" class="circle responsive-img">
                            <div class="row login">
                                <h4>Ingreso a tiwebcom.</h4> 
                                <form  class="center-align col m8 s8 offset-m2 offset-s2" name="frmLogin" method="POST" action="./validaUsuarioServlet">

                                    <div class="row">
                                        <div class="input-field col m12 s6">
                                            <i class="material-icons iconis prefix">account_box</i>
                                            <input id="icon_prefix" name="txtLogin" type="text" class="validate" required="true">
                                            <label for="icon_prefix">Nombre o Email</label>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="input-field col m12 s6">
                                            <i class="material-icons iconis prefix">enhanced_encryption</i>
                                            <input id="password" name="txtPass" type="password" class="validate" required="true">
                                            <label for="password">Contraseña</label>
                                        </div>
                                    </div>
                                    
                                    <div class="row">
                                        <button class="btn waves-effect waves-light btn" type="submit" name="action">Iniciar sesión!</button>
                                    </div> 
                                    <div class="row">
                                        <a class="waves-effect waves-light btn" href="addAcount.jsp"><i class="material-icons left">account_circle</i>Crear cuenta</a>
                                    </div> 
                                </form>
                            </div>
                        </h4>
                    </div>
                </div>
            </div>
        </div>
 
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
    <script src="mySpxript.js"></script>
</body>
</html>
