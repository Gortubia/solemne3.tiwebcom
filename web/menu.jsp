<%-- 
    Document   : menu
    Created on : 11-nov-2018, 18:43:07
    Author     : adolf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        
     <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
      <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/css/materialize.min.css"/>
      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/> 
        <title></title>
        <link rel="icon" href="img/logo.ico">
    <style type="text/css">
  	header,
	main,
	footer {
	  padding-left: 240px;
	}

	body {
	  background-color: white;
	}

	@media only screen and (max-width: 992px) {
	  header,
	  main,
	  footer {
	    padding-left: 0;
	  }
	}

	#credits li,
	#credits li a {
	  color: white;
	}

	#credits li a {
	  font-weight: bold;
	}

	.footer-copyright .container,
	.footer-copyright .container a {
	  color: #BCC2E2;
	}

	.fab-tip {
	  position: fixed;
	  right: 85px;
	  padding: 0px 0.5rem;
	  text-align: right;
	  background-color: #323232;
	  border-radius: 2px;
	  color: #FFF;
	  width: auto;
	}
  </style>
        
    </head>
    <body>   
        
        <c:if test="${sessionScope.usuarioConectado == null}">
        <c:redirect url="login.jsp"></c:redirect></c:if>
        
        <jsp:include page="/menu" flush="true"/>
        <jsp:useBean id="usuarioConectado" class="cl.duoc.dej4501.solemne3.tiwebcom.entity.Usuario" scope="session"/>
        <jsp:useBean id="objMenuPadre" class="cl.duoc.dej4501.solemne3.tiwebcom.entity.Menu" scope="page"></jsp:useBean>
        <jsp:useBean id="objMenuHijo" class="cl.duoc.dej4501.solemne3.tiwebcom.entity.Menu" scope="page"></jsp:useBean> 

            <ul id="slide-out" class="side-nav fixed z-depth-2">
                <li class="center no-padding">
                    <div class="indigo darken-2 white-text" style="height: 180px;">
                        <div class="row">
                            <img style="margin-top: 5%;" width="100" height="100" src="img/logo.png" class="circle responsive-img" />
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
                        <p style="margin-top: -13%;">
                            Tenda web cómics
                        </p>
                    </div>
                </div>
            </li>
            <li id="dash_dashboard"><a class="waves-effect" href="index.jsp"><b>Tiwebcom Inicio</b></a></li>
            <ul class="collapsible" data-collapsible="acordion">
                <c:forEach items="${listadoMenu}" var="objMenuPadre">                     
                    <c:if test="${objMenuPadre.padreMenu==0}">
                        <li id="dash_users">
                            <div id="dash_users_header" class="collapsible-header waves-effect"><b> <c:out value="${objMenuPadre.nombreMenu }"></c:out>  </b></div>
                                <div id="dash_users_body" class="collapsible-body">
                                    <ul>
                                    <c:forEach items="${listadoMenu}" var="objMenuHijo"> 
                                        <c:if test="${objMenuHijo.idMenu!=0 && objMenuPadre.idMenu==objMenuHijo.padreMenu}"> 

                                            <li id="users_seller">
                                                <a class="nav-link text-uppercase text-expanded" href="<c:out value="${objMenuHijo.destinoMenu}"/>"><c:out value="${objMenuHijo.nombreMenu}"></c:out></a>
                                                </li>
                                        </c:if>
                                    </c:forEach> 
                                </ul>
                            </div>
                        </li>
                    </c:if>
                </c:forEach>
            </ul>
        </ul>

        <header>
            <ul class="dropdown-content" id="user_dropdown">
                <li class="nav-item px-lg-44">
                    <c:if test="${sessionScope.usuarioConectado == null}">
                        <a class="nav-link text-uppercase text-expanded" href="login.jsp">Ingresar</a> 
                    </c:if>
                    <c:if test="${sessionScope.usuarioConectado != null}"> 
                        <a class="nav-link text-uppercase text-expanded" href="./cerrarSesion">Salir</a> 

                    </c:if>    
                </li> 
            </ul>

            <nav class="indigo" role="navigation">
                <div class="nav-wrapper">
                    <a data-activates="slide-out" class="button-collapse show-on-large" href="#!"><img style="margin-top: 17px; margin-left: 5px;" src="img/tiwebgif.gif" /></a>

                    <ul class="right hide-on-med-and-down">
                        <li>
                            <a class='right dropdown-button' href='' data-activates='user_dropdown'><i class=' material-icons'>account_circle</i></a>
                        </li>
                    </ul>

                    <a href="#" data-activates="slide-out" class="button-collapse"><i class="mdi-navigation-menu"></i></a>
                </div>
            </nav>

            <nav>
                <div class="nav-wrapper indigo darken-2">
                    <a style="margin-left: 20px;" class="breadcrumb" href="#!">Usuario : <c:out value="${usuarioConectado.loginUsuario}"/></a>
                    <div style="margin-right: 20px;" id="timestamp" class="right"></div>
                </div>
            </nav>
        </header>
         
                    
       

    </body>
</html>
