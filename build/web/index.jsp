<%-- 
    Document   : index
    Created on : 11-nov-2018, 16:37:40
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
      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/> 
        <title>Index</title>
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
      <li id="dash_users">
        <div id="dash_users_header" class="collapsible-header waves-effect"><b>Usuarios</b></div>
        <div id="dash_users_body" class="collapsible-body">
          <ul>
            <li id="users_seller">
              <a class="waves-effect" style="text-decoration: none;" href="login.jsp">Ingresar</a>
            </li>
              <li id="users_seller">
              <a class="waves-effect" style="text-decoration: none;" href="addAcount.jsp">Crear cuenta</a>
            </li>  
          </ul>
        </div>
      </li>

       
 

       
    </ul>
  </ul>

  <header>
    <ul class="dropdown-content" id="user_dropdown">
      <li class="nav-item px-lg-44">
          <c:if test="${sessionScope.usuarioConectado == null}">
             <a class="nav-link text-uppercase text-expanded" href="login.jsp">Ingresar</a> 
             <a class="nav-link text-uppercase text-expanded" href="addAcount.jsp">Crear Cuenta</a> 
          </c:if>
           <c:if test="${sessionScope.usuarioConectado != null}"> 
              <c:redirect url="home.jsp"></c:redirect>
            
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
        <a style="margin-left: 20px;" class="breadcrumb" href="#!">Los mejores comics</a>
        <div style="margin-right: 20px;" id="timestamp" class="right"></div>
      </div>
    </nav>
  </header>

  <main>
    <div class="row">
      <div class="col s6">
        <div style="padding: 35px;" align="center" class="card">
          <div class="row">
            <div class="left card-title">
              <b>Comics</b>
            </div>
          </div>

          <div class="row">
            <a href="#!">
              <div style="padding: 30px;" class="  col s5 waves-effect">
                <img width="150" height="200" src="img/comics/1.png"   />
                <span class="indigo-text text-lighten-1"><h5>Marvel</h5></span>
              </div>
            </a>
            <div class="col s1">&nbsp;</div>
            <div class="col s1">&nbsp;</div>

            <a href="#!">
              <div style="padding: 30px;" class="  col s5 waves-effect">
                <img width="150" height="200" src="img/comics/2.jpg"   />
                <span class="indigo-text text-lighten-1"><h5>Customer</h5></span>
              </div>
            </a>
          </div>
        </div>
      </div>

      <div class="col s6">
        <div style="padding: 35px;" align="center" class="card">
          <div class="row">
            <div class="left card-title">
              <b>Ver Tiendas</b>
            </div>
          </div>
          <div class="row">
            <a href="#!">
              <div style="padding: 30px;" class="col s5 waves-effect">
                <img width="150" height="200" src="img/tienda.jpg"   />
                <span class="indigo-text text-lighten-1"><h5>Tiendas</h5></span>
              </div>
            </a> 
            <div class="col s1">&nbsp;</div>
            <div class="col s1">&nbsp;</div> 
          </div>
        </div>
      </div>
    </div>

    <div class="row">
      <div class="col s6">
        <div style="padding: 35px;" align="center" class="card">
          <div class="row">
            <div class="left card-title">
              <b>Brand Management</b>
            </div>
          </div>

          <div class="row">
            <a href="#!">
              <div style="padding: 30px;" class="grey lighten-3 col s5 waves-effect">
                <i class="indigo-text text-lighten-1 large material-icons">local_offer</i>
                <span class="indigo-text text-lighten-1"><h5>Brand</h5></span>
              </div>
            </a>

            <div class="col s1">&nbsp;</div>
            <div class="col s1">&nbsp;</div>

            <a href="#!">
              <div style="padding: 30px;" class="grey lighten-3 col s5 waves-effect">
                <i class="indigo-text text-lighten-1 large material-icons">loyalty</i>
                <span class="indigo-text text-lighten-1"><h5>Sub Brand</h5></span>
              </div>
            </a>
          </div>
        </div>
      </div>

      <div class="col s6">
        <div style="padding: 35px;" align="center" class="card">
          <div class="row">
            <div class="left card-title">
              <b>Category Management</b>
            </div>
          </div>
          <div class="row">
            <a href="#!">
              <div style="padding: 30px;" class="grey lighten-3 col s5 waves-effect">
                <i class="indigo-text text-lighten-1 large material-icons">view_list</i>
                <span class="indigo-text text-lighten-1"><h5>Category</h5></span>
              </div>
            </a>
            <div class="col s1">&nbsp;</div>
            <div class="col s1">&nbsp;</div>

            <a href="#!">
              <div style="padding: 30px;" class="grey lighten-3 col s5 waves-effect">
                <i class="indigo-text text-lighten-1 large material-icons">view_list</i>
                <span class="truncate indigo-text text-lighten-1"><h5>Sub Category</h5></span>
              </div>
            </a>
          </div>
        </div>
      </div>
    </div>

     
  </main>

  <footer class="indigo page-footer">
     
    <div class="footer-copyright">
      <div class="container center-align">
        <span>Made By <a style='font-weight: bold;'  target="_blank">GOAL</a></span>
      </div>
    </div>
  </footer>
    
  
  <script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>  
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/js/materialize.min.js"></script>

  
  <script type="text/javascript">
  	$(document).ready(function() {
  		$('.button-collapse').sideNav();
		$('.collapsible').collapsible();
		$('select').material_select();
                $(".dropdown-trigger").dropdown();
  	});
  </script>


</body>
</html>
