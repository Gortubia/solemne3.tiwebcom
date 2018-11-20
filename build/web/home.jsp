<%-- 
    Document   : home
    Created on : 11-nov-2018, 17:44:44
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
        <title>Home</title>
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
   <jsp:include page="menu.jsp"></jsp:include>

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
      <div class="container">
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