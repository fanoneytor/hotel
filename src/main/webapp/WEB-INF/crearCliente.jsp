<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nueva Reserva</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
	    <header class="d-flex justify-content-between aling-items-center">
            <h3>Usuari@ ${userSession.nombre}</h3>
            <h1>Crear Cliente</h1>
            <div>
                <a href="/clientes/" class="btn btn-danger">Volver</a>
            </div>
        </header>
		<form:form action="/clientes/crear" method="POST" modelAttribute="cliente">
		    <div class="form-group">
                <form:label path="Nombre">Nombre</form:label>
                <form:input path="Nombre" class="form-control"></form:input>
                <form:errors path="Nombre" class="text-primary"></form:errors>
            </div>

           <div class="form-group">
               <form:label path="Apellido">Apellido</form:label>
               <form:input path="Apellido" class="form-control"></form:input>
               <form:errors path="Apellido" class="text-primary"></form:errors>
           </div>

			<div class="form-group">
               <form:label path="Direccion">Direccion</form:label>
               <form:input path="Direccion" class="form-control"></form:input>
               <form:errors path="Direccion" class="text-primary"></form:errors>
           </div>

			<div class="form-group">
               <form:label path="Telefono">Telefono</form:label>
               <form:input path="Telefono" class="form-control"></form:input>
               <form:errors path="Telefono" class="text-primary"></form:errors>
           </div>

           <div class="form-group">
              <form:label path="Correo">Correo</form:label>
              <form:input path="Correo" class="form-control"></form:input>
              <form:errors path="Correo" class="text-primary"></form:errors>
          </div>

			<input type="submit" value="Guardar" class="btn btn-success"/>

		</form:form>

	</div>
</body>
</html>