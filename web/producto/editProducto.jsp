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
        <title>Agregar Producto</title>
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
        <jsp:useBean   id="producto" class="cl.duoc.dej4501.solemne3.tiwebcom.entity.Producto" scope="page" ></jsp:useBean>
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
                        <i class="fa fa-user"></i>Agregar Productos al sistema</div>
                    <div class="card-body"> 
                        <form  class="col s12" name="frmAddProducto" method="POST" action="../addProductoServlet">

                            <div class="row">

                                <div class="input-field col s6"> 
                                    <input  id="txtNombre" name="txtNombre" type="text" class="validate" required="true"> 
                                    <label class="center-align" for="txtUsuario">Nombre producto*</label>

                                </div>
                                <div class="input-field col s6"> 
                                    <input id="txtPrecio" name="txtPrecio" type="number" class="validate" required="true"> 
                                    <label class="center-align" for="frPrecio">Precio *</label>

                                </div>
                            </div>

                            <div class="row">
                                <div class="input-field col s6"> 
                                    <input  id="txtDescripcion" name="txtDescripcion" type="text" class="validate">
                                    <label class="center-align" for="frmDesc">Categoria</label>
                                </div>
                                <div class="input-field col s6"> 
                                    <input id="txtStock" name="txtStock" type="number" class="validate">
                                    <label class="center-align" for="frmStock">Stock</label>
                                </div>
                            </div>
                             
                            
                            <div class="row center-align">
                                <label for="msg">* (Obligatorio)</label>
                                
                            </div>
                            <div class="row center-align">
                                <button class="btn waves-effect waves-light" type="submit" name="action">Crear</button>
                            </div>
                        </form>
                    </div>
                    <div class="card-footer small text-muted center-align"> Agregar Producto</div>    
                </div>
            </div>  
 
    </body>
</html>