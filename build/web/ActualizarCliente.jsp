 <%@ page import="modelo.productos" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Usuario</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1 class="text-warning">Editar Usuario <a href="UsuarioServlet" class="btn btn-outline-dark">Regresar</a></h1>
        <h4>Modifica los campos que desees cambiar y luego pulsa el botón "Actualizar Usuario" para guardar los cambios.</h4>
        <form action="editarUsuario" method="POST">
            <input type="hidden" name="ID_CLIENTES" value="${cliente.ID_CLIENTES}">
            
            <div class="mb-3">
                <label for="nombre" class="form-label">Nombre</label>
                <input type="text" class="form-control" id="nombre" name="NOMBRE" value="${cliente.NOMBRE}" required>
            </div>

            <div class="mb-3">
                <label for="apellidos" class="form-label">Apellidos</label>
                <input type="text" class="form-control" id="apellidos" name="APELLIDOS" value="${cliente.APELLIDOS}" required>
            </div>

            <div class="mb-3">
                <label for="documento" class="form-label">Documento</label>
                <input type="number" class="form-control" id="documento" name="DOCUMENTO" value="${cliente.DOCUMENTO}" required>
            </div>

            <div class="mb-3">
                <label for="celular" class="form-label">Celular</label>
                <textarea type="number" class="form-control" id="celular" name="CELULAR" rows="3" required>${cliente.CELULAR}</textarea>
            </div>

            <div class="mb-3">
                <label for="direccion" class="form-label">Dirección</label>
                <input type="text" class="form-control" id="direccion" name="DIRECCION" value="${cliente.DIRECCION}" required>
            </div>

            <div class="mb-3">
                <label for="correo" class="form-label">Correo</label>
                <input type="text" class="form-control" id="correo" name="CORREO" value="${cliente.CORREO}" required>
            </div>

            <div class="mb-3">
                <label for="contraseña" class="form-label">Contraseña</label>
                <input type="text" class="form-control" id="contraseña" name="CONTRASEÑA" value="${cliente.CONTRASEÑA}" required>
            </div>

            <button type="submit" class="btn btn-primary">Actualizar Usuario</button>
        </form>
    </div>
</body>
</html>