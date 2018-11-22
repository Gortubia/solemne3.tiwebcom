<%-- 
    Document   : listausuarios
    Created on : 18-nov-2018, 22:47:26
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
        <title>Sucursal</title>
        <link rel="icon" href="img/logo.ico">
    </head>
    <body>
    <c:if test="${sessionScope.usuarioConectado == null}">
    <c:redirect url="login.jsp"></c:redirect></c:if>
    <jsp:include page="/cargaSucursal" flush="true"></jsp:include>   
    <jsp:useBean   id="sucursal" class="cl.duoc.dej4501.solemne3.tiwebcom.entity.Sucursal" scope="page" ></jsp:useBean>
        <nav class="indigo " role="navigation"> 
            <div class="col m8 s8 offset-m2 offset-s2 center">
            <h4>Sucursales de la tienda</h4>
            
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
        <div class=" container "> 
            
        <div class="container"> 
        <!-- Example DataTables Card-->
          <div class="card mb-3">
            <div class="card-header">
              <i class="fa fa-user"></i> Listado de Sucursales</div>
            <div class="card-body">
                <div  class="dropdown-item">
                    <a class="waves-effect waves-light btn right-aling" href="../home.jsp"><i class="material-icons left">navigate_before</i>Volver</a>
                    <input type="button" class="btn btn-primary" name="btnAgregar" value="Agregar Sucursal"  onclick="window.location.href = 'addSucursal.jsp'">  
                </div>
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">

                  <thead>
                    <tr> <th>Id</th> 
                         <th>Descripcion</th>
                         <th>Direccion</th>
                         <th>Telefono</th>
                         <th>Cod Comuna</th>
                         <td colspan="2">Acciones</td> 
                    </tr>
                  </thead>

                  <tbody>
                   <c:forEach items="${sessionScope.listaSucursal}" var="sucursal">
                            <tr>
                                <td><c:out value="${sucursal.id}"></c:out> </td>  
                                <td><c:out value="${sucursal.descripcion}"></c:out> </td>  
                                <td><c:out value="${sucursal.direccion}"></c:out> </td>   
                                <td><c:out value="${sucursal.telefono}"></c:out> </td>   
                                <td><c:out value="${sucursal.codComuna}"></c:out> </td>   
                                <c:url value="./editarPerfil" var="editar">
                                    <c:param name="codigo" value="${producto.id}"></c:param>
                                </c:url>
                                    <td><input type="button" class=" btn-warning btn-small" name="btnEditar" value="Editar" onclick="window.location.href = '${editar}'"> </td>
                            
                                <c:url value="./eliminarPerfil" var="eliminar">
                                    <c:param name="codigo" value="${producto.id}"></c:param>
                                </c:url>
                                <td><input type="button" class="btn-small btn-danger" name="btnEliminar" value="Eliminar" onclick="window.location.href = '${eliminar}'"> </td>
                            
                            </tr>
                        </c:forEach> 
                    </tbody>
                </table>
                  
              </div>
            </div>
            <div class="card-footer small text-muted"> Listado de Sucursales</div>
          </div>
         </div>  

        </div>
 
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
    <script src="mySpxript.js"></script>
    

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
 