<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
	    <header class="d-flex justify-content-between aling-items-center">
            <h3>Usuari@ ${userSession.nombre}</h3>
            <h1>CREAR COLABORADOR</h1>
            <div>
                <a href="/colaboradorInicio" class="btn btn-danger">Volver</a>
            </div>
        </header>
            <form:form action="/registrar" method="post" modelAttribute="nuevoUsuario">

                <div class="form-group">
                    <form:label path="nombre">Nombre:</form:label>
                    <form:input path="nombre" class="form-control"></form:input>
                    <form:errors path="nombre" class="text-danger"></form:errors>
                </div>

                <div class="form-group">
                    <form:label path="apellido">Apellido:</form:label>
                    <form:input path="apellido" class="form-control"></form:input>
                    <form:errors path="apellido" class="text-danger"></form:errors>
                </div>

                <div class="form-group">
                    <form:label path="nombreUsuario">Nombre de Usuario:</form:label>
                    <form:input path="nombreUsuario" class="form-control"></form:input>
                    <form:errors path="nombreUsuario" class="text-danger"></form:errors>
                </div>

                <div class="form-group">
                    <form:label path="contra">Contraseña:</form:label>
                    <form:password path="contra" class="form-control"></form:password>
                    <form:errors path="contra" class="text-danger"></form:errors>
                </div>

                <form:hidden path="rol" value="USER"></form:hidden>
                <input type="submit" class="btn btn-success" value="Crear"/>

            </form:form>
	</div>

</body>
</html>