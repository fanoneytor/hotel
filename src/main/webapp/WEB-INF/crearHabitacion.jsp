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
            <h1>CREAR HABITACION</h1>
            <div>
                <a href="/habitaciones/" class="btn btn-danger">Volver</a>
            </div>
        </header>
		<form:form action="/habitaciones/crear" method="POST" modelAttribute="habitacion">
		    <div class="form-group">
                <form:label path="Numero_habitacion">Numero Habitacion</form:label>
                <form:input path="Numero_habitacion" class="form-control"></form:input>
                <form:errors path="Numero_habitacion" class="text-primary"></form:errors>
            </div>

           <div class="form-group">
               <form:label path="Tipo_habitacion">Tipo Habitacion</form:label>
                   <form:select path="Tipo_habitacion" class="form-control">
                       <option value="" disabled selected>Seleccione un Tipo</option>
                       <form:option value="Individual">Individual</form:option>
                       <form:option value="Doble">Doble</form:option>
                       <form:option value="Suite">Suite</form:option>
                   </form:select>
                <form:errors path="Tipo_habitacion" class="text-danger"></form:errors>
           </div>

			<div class="form-group">
               <form:label path="Precio">Precio</form:label>
               <form:input path="Precio" class="form-control"></form:input>
               <form:errors path="Precio" class="text-primary"></form:errors>
           </div>

           <form:hidden path="Estado" value="Disponible"></form:hidden>
			<input type="submit" value="Guardar" class="btn btn-success"/>

		</form:form>

	</div>
</body>
</html>