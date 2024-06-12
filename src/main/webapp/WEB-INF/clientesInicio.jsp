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
			<h1>CLIENTES</h1>
			<div>
				<a href="/inicio" class="btn btn-danger">Volver</a>
			</div>
		</header>
		<div class="row">
			<div class="row justify-content-center">
				<div class="col-6">
				    <a href="/clientes/nuevoCliente" class="btn btn-primary">Crear Cliente</a>
					<table class="table table-hover">
                        <thead>
                            <tr>
                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>Direccion</th>
                                <th>Telefono</th>
                                <th>Correo</th>
                                <th>Reserva</th>
                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach items="${clientes}" var="c">
                                <tr>
                                    <td>${c.nombre}</td>
                                    <td>${c.apellido}</td>
                                    <td>${c.direccion}</td>
                                    <td>${c.telefono}</td>
                                    <td>${c.correo}</td>
                                    <td>Quemado</td>
                                    <td>
                                        <a href="/clientes/modificar/${c.id_cliente}" class="btn btn-success">Modificar</a>
                                        <a href="/clientes/eliminar/${c.id_cliente}" class="btn btn-danger">Eliminar</a>
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