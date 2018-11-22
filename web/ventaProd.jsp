<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        
      <!--Import materialize.css-->
     <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
      <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/css/materialize.min.css"/>
      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/> 
        <title>Venta</title>
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

        <jsp:include page="./cargaSucursal" flush="true"></jsp:include>
        <jsp:include page="./getAllProductos" flush="true"></jsp:include>
        <jsp:useBean id="producto" class="cl.duoc.dej4501.solemne3.tiwebcom.entity.Producto"></jsp:useBean>
        <jsp:useBean id="carritoCompra" class="cl.duoc.dej4501.solemne3.tiwebcom.viewDomain.CarritoCompra"></jsp:useBean>
        <jsp:useBean id="productoCarrito" class="cl.duoc.dej4501.solemne3.tiwebcom.viewDomain.ProductoCarrito"></jsp:useBean>
        <jsp:useBean id="sucursal" class="cl.duoc.dej4501.solemne3.tiwebcom.entity.Sucursal"></jsp:useBean>
        

        <c:if test="${sessionScope.usuarioConectado == null}">
            <c:redirect url="login.jsp"></c:redirect></c:if>

        <c:if test="${sessionScope.listaProd !=null}"> 
            <div class="container"> 
                <!-- Example DataTables Card-->
                <div class="card mb-3">
                    <div class="card-header">
                        <i class="fa fa-user"></i> Listado de productos a la venta</div>
                    <div class="card-body">
                         
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0"> 
                                <thead>
                                    <tr> <th>Codigo</th> 
                                        <th>Producto</th>
                                        <th>Precio</th>
                                    </tr>
                                </thead>

                                <tbody>
                                    <c:forEach items="${sessionScope.listaProd}" var="producto">
                                        <tr>
                                            <td> <c:out value="${producto.id}"></c:out> </td>
                                            <td> <c:out value="${producto.nombreProducto}"></c:out> </td>
                                            <td> <c:out value="${producto.precio}"></c:out> </td>  </tr>
                                        </c:forEach> 
                                </tbody>
                            </table>


                            <form class="form-signin center-align" name="frmAdd" method="POST" action="./procesaCompraServlet">

                                <div class="row center-align">

                                    <div class="input-field col s3"> 
                                        <input  id="txtNombre" name="txtCodigo" type="number" class="validate" required="true"> 
                                        <label class="center-align" for="txtUsuario">Codigo a vender</label>

                                    </div>
                                    <div class="input-field col s3"> 
                                        <input id="txtPrecio" name="txtUnidades" type="number" class="validate" required="true"> 
                                        <label class="center-align" for="frPrecio">cantidad</label>

                                    </div>
                                </div> 
                                <div class="row center-align">
                                    <button class="btn waves-effect waves-light" type="submit" name="action">Agregar</button>
                                </div>
                            </form> 
                        </div>
                    </div>
                    <div class="card-footer small text-muted"> Listado de productos</div>
                </div>
            </div>  

        </c:if>

        <c:if test="${sessionScope.carritoCompra !=null}">
            <form class="form-signin center-align" name="frmGuardaBoleta" method="POST" action="./guardaBoleta">
                <div class="container"> 
                    <!-- Example DataTables Card-->
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fa fa-user"></i> Listado de productos para compra</div>
                        <div class="card-body">
                            <div  class="dropdown-item"> 
                                <input type="button" class="btn btn-primary" name="btnCancelar" value="Cancelar"  onclick="window.location.href = 'home.jsp'">  
                            </div>
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr> <th>codigo</th> 
                                            <th>Cantidad</th> 
                                            <th>sub-total</th>  
                                            <td colspan="1">Acciones</td> 
                                        </tr> 
                                        <tr>
                                            <th>Total</th>
                                            <td colspan="1">Acciones</td> 
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${sessionScope.carritoCompra.listadoProducosCarrito}" var="productoCarrito">
                                            <tr>
                                                <td><c:out value="${productoCarrito.idproducto}"></c:out> </td>  
                                                <td><c:out value="${productoCarrito.cantidadProducto}"></c:out> </td>
                                                <td><c:out value="${productoCarrito.subTotalCarrito}"></c:out> </td>

                                                <c:url value="./procesaCompraServlet" var="eliminar">
                                                    <c:param name="codigo" value="${productoCarrito.idproducto}"></c:param>
                                                </c:url>
                                                <td><input type="button" class="btn-small btn-danger" name="btnEliminar" value="Eliminar" onclick="window.location.href = '${eliminar}'"> </td>
                                            </tr>
                                        </c:forEach> 
                                        


                                        </tbody>
                                    </table> 

                                    <div class="row">
                                        <form class="col s12">
                                            <div class="row">
                                                <div class="input-field col s3">
                                                    <i class="material-icons prefix tiny">attach_money</i>
                                                    <input id="icon_prefix" type="text" value="<c:out value="${sessionScope.carritoCompra.totalCarrito}"></c:out>" >
                                                    <label for="icon_prefix">Total</label>
                                                </div>
                                                <div class="input-field col s3">

                                                    <label class="center-align" for="frSucursal"></label>
                                                    <select class="center-align form-control" name="ddlSucursal" id="ddlSucursal" required="true">
                                                        <option value="">Seleccione Sucursal</option>
                                                    <c:forEach items="${sessionScope.listaSucursal}" var="sucursal">
                                                        <option value="${sucursal.id}"><c:out value="${sucursal.descripcion}"></c:out></option>
                                                    </c:forEach>
                                                </select> 
                                            </div>
                                    </form>
                                </div> 
                                                        <input class="input-field col s3" id="txtIdCliente" name="txtIdCliente" type="text" hidden="true" value="${usuarioConectado.idUsuario}" > 
 
                            </div>  
                            <div class="row center-align">
                                <button class="btn waves-effect waves-light" type="submit" name="action">Comprar</button>
                            </div>
                        </div>
                    </div>
                    <div class="card-footer small text-muted"> Listado de carrito</div>
                </div>
                </div>  
            </form>
        </c:if>

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