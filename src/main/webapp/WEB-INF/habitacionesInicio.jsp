<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard Green Facets</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<header class="d-flex justify-content-between aling-items-center">
			<h3>Usuari@ ${userSession.nombre}</h3>
			<h1>HABITACIONES</h1>
			<div>
				<a href="/inicio" class="btn btn-danger">Volver</a>
			</div>
		</header>
		<div class="row">
			<div class="row justify-content-center">
				<div class="col-6">
				    <a href="/habitaciones/nuevaHabitacion" class="btn btn-primary">Crear Habitacion</a>
					<table class="table table-hover">
                        <thead>
                            <tr>
                                <th>Numero Habitacion</th>
                                <th>ID Reserva</th>
                                <th>Estado</th>
                                <th>Tipo Habitacion</th>
                                <th>Precio</th>
                                <th>ID reserva</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach items="${habitaciones}" var="h">
                                <tr>
                                    <td>${h.numero_habitacion}</td>
                                    <td>${h.numero_reserva.id_reserva}</td>
                                    <td>${h.estado}</td>
                                    <td>${h.tipo_habitacion}</td>
                                    <td>${h.precio}</td>
                                    <td>
                                        <a href="/habitaciones/modificar/${h.id_habitacion}" class="btn btn-success">Modificar</a>
                                        <a href="/habitaciones/eliminar/${h.id_habitacion}" class="btn btn-danger">Eliminar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
				</div>
		 	</div>
		</div>
	</div>
</body>
</html>