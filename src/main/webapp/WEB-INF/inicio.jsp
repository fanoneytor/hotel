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
			<h1>RESERVAS</h1>
			<div>
                <a href="/colaboradorInicio" class="btn btn-success">Colaboradores</a>
				<a href="/clientes/" class="btn btn-success">Clientes</a>
				<a href="/habitaciones/" class="btn btn-success">Habitaciones</a>
				<a href="/logout" class="btn btn-danger">Salir</a>
			</div>
		</header>
		<div class="row">
			<div class="row justify-content-center">
				<div class="col-6">
				    <a href="/reservas/nuevaReserva" class="btn btn-primary">Crear Reserva</a>
					<table class="table table-hover">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Fecha inicio</th>
                                <th>Fecha fin</th>
                                <th>Estado</th>
                                <th>Habitaciones reservadas</th>
                                <th>Cliente</th>
                                <th>Pago</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach items="${reservas}" var="p">
                                <tr>
                                    <td>${p.id_reserva}</td>
                                    <td>${p.fecha_inicio}</td>
                                    <td>${p.fecha_fin}</td>
                                    <td>${p.estado}</td>
                                    <td>
                                        <c:forEach items="${p.id_habitaciones}" var="h">
                                            ${h.numero_habitacion}
                                        </c:forEach>
                                    </td>
                                    <td>${p.cliente.nombre}</td>
                                    <td>Pago</td>
                                    <td>
                                        <a href="/reservas/modificar/${p.id_reserva}" class="btn btn-success">Modificar</a>
                                        <a href="/reservas/eliminar/${p.id_reserva}" class="btn btn-danger">Eliminar</a>
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