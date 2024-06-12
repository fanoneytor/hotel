<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
        crossorigin="anonymous">
</head>

<body>
    <div class="container">
        <div class="row">
            <div class="col-8">
                <h2>Inicia Sesión</h2>
                <form:form action="/login" method="post" modelAttribute="nuevoLogin">

                    <div class="form-group">
                        <form:label path="nombreUsuario">Email:</form:label>
                        <form:input path="nombreUsuario" class="form-control"></form:input>
                        <form:errors path="nombreUsuario" class="text-danger"></form:errors>
                    </div>

                    <div class="form-group">
                        <form:label path="contra">Contraseña:</form:label>
                        <form:password path="contra" class="form-control"></form:password>
                        <form:errors path="contra" class="text-danger"></form:errors>
                    </div>
                    <input type="submit" value="Iniciar Sesión" class="btn btn-primary" />
                </form:form>
            </div>
        </div>
    </div>
</body>
</html>