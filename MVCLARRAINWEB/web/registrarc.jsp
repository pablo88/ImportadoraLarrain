<%-- 
    Document   : registrarc
    Created on : 20-05-2017, 5:46:51
    Author     : P_Silva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:if test="${sessionScope.sesion != null}">
    <script type="text/javascript">
        alert('Sesion iniciada\nNo se puede registrar.');
        window.location.href = "index.jsp";
    </script>
</c:if>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
        <link rel="stylesheet" type="text/css" href="css/estilos.css" />
        <title>JSP Page</title>
    </head>
    <body>
        <div class="col-md-12">
        <div class="titulo encabezado">
        <h1>Registrar Cliente</h1>
        </div>
        <div class="contenedor formulario registrar col-md-2 col-md-offset-5">
            <form method="post" action="registrarc.htm">
            <label><strong>Nombre</strong></label>
            <input id="nombre" name="nombre" />
            <label><strong>Rut</strong></label>
            <input id="rut" name="rut" />
            <label><strong>Apellido Paterno</strong></label>
            <input id="app" name="app" />
            <label><strong>Apellido Materno</strong></label>
            <input id="apm" name="apm" />
            <label><strong>Correo</strong></label>
            <input id="correo" name="correo" />
            <label><strong>Direccion</strong></label>
            <input id="direccion" name="direccion" />
            <label><strong>Telefono</strong></label>
            <input id="telefono" name="telefono" />
            <label><strong>Codigo Postal</strong></label>
            <input id="codigo" name="codigo" />
            <label><strong>Contraseña</strong></label>
            <input id="pass" name="pass" />
            <label><strong>Repetir Contraseña</strong></label>
            <input id="pass1" name="pass1" />
            <input class="btn-registrar btn btn-success" type="submit" value="Registrar">
            </form>
        </div>
        </div>
    </body>
</html>
