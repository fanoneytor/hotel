<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            <h1>Nueva Reserva</h1>
            <div>
                <a href="/inicio" class="btn btn-danger">Volver</a>
            </div>
        </header>
		<form:form action="/reservas/crear" method="POST" modelAttribute="reserva">
		    <div class="form-group">
                <form:label path="Fecha_inicio">Fecha Inicio</form:label>
                <form:input path="Fecha_inicio" type="date" class="form-control"></form:input>
                <form:errors path="Fecha_inicio" class="text-primary"></form:errors>
            </div>

            <div class="form-group">
                <form:label path="Fecha_fin">Fecha Fin</form:label>
                <form:input path="Fecha_fin" type="date" class="form-control"></form:input>
                <form:errors path="Fecha_fin" class="text-danger"></form:errors>
            </div>

			<div class="form-group">
                <form:label path="Estado">Estado</form:label>
                <form:select path="Estado" class="form-control">
                    <option value="" disabled selected>Seleccione un Estado</option>
                    <form:option value="Confirmada">Confirmada</form:option>
                    <form:option value="Pendiente">Pendiente</form:option>
                    <form:option value="Cancelada">Cancelada</form:option>
                </form:select>
                <form:errors path="Estado" class="text-danger"></form:errors>
            </div>

			<div class="form-group">
                <form:label path="Id_habitaciones">Habitaciones</form:label>
                <div class="form-check">
                    <c:forEach items="${habitaciones}" var="h">
                        <input type="checkbox" id="cliente_${h.id_habitacion}" name="habitacion" value="${c.id_cliente}" class="form-check-input">
                        <label for="habitacion_${h.id_habitacion}" class="form-check-label">${h.numero_habitacion} ${h.tipo_habitacion}</label><br>
                    </c:forEach>
                </div>
                <form:errors path="Id_habitaciones" class="text-danger"></form:errors>
            </div>

			<div class="form-group">
                <form:label path="Cliente">Cliente</form:label>
                <form:select path="Cliente" class="form-control">
                    <option value="" disabled selected>Seleccione un Cliente</option>
                    <c:forEach items="${clientes}" var="c">
                        <form:option value="${c.id_cliente}">${c.nombre} ${c.apellido}</form:option>
                    </c:forEach>
                </form:select>
                <form:errors path="Cliente" class="text-danger"></form:errors>
            </div>
			<input type="submit" value="Guardar" class="btn btn-success"/>

		</form:form>

	</div>
</body>
</html>