<%@ page import="modelo.Distribuidor" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Distribuidor</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <h1 class="text-warning">Editar Distribuidor 
            <a href="DistribuidorServlet" class="btn btn-outline-dark">Regresar</a>
        </h1>
        <h4>Modifica los campos que desees cambiar y luego pulsa el botón "Actualizar Distribuidor" para guardar los cambios.</h4>
        
        <form action="editarDistribuidor" method="POST">
            <!-- Aquí corregí el campo oculto para enviar el ID correctamente -->
            <input type="hidden" name="ID_DISTRIBUIDOR" value="${distribuidor.idDistribuidor}">
            
            <div class="mb-3">
                <label for="NombreDistribuidor" class="form-label">Nombre</label>
                <input type="text" class="form-control" name="NOMBRE_DISTRIBUIDOR" value="${distribuidor.nombreDistribuidor}" required>
            </div>
            <div class="mb-3">
                <label for="direccion" class="form-label">Dirección</label>
                <input type="text" class="form-control" name="DIRECCION" value="${distribuidor.DIRECCION}" required>
            </div>
            <div class="mb-3">
                <label for="celular" class="form-label">Celular</label>
                <input type="text" class="form-control" name="CELULAR" value="${distribuidor.CELULAR}" required>
            </div>
            <div class="mb-3">
                <label for="correo" class="form-label">Correo</label>
                <input type="text" class="form-control" name="CORREO" value="${distribuidor.CORREO}" required>
            </div>
            <div class="mb-3">
                <label for="pedidos" class="form-label">Pedidos</label>
                <input type="text" class="form-control" name="PEDIDOS" value="${distribuidor.PEDIDOS}" required>
            </div>

            <button type="submit" class="btn btn-primary">Actualizar Distribuidor</button>
        </form>
    </div>
</body>
</html>

