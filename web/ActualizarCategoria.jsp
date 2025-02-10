<%@ page import="modelo.Categoria" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Categoría</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <h1 class="text-warning">Editar Categoría 
            <a href="CategoriaServlet" class="btn btn-outline-dark">Regresar</a>
        </h1>
        <h4>Modifica el nombre de la categoría y luego pulsa el botón "Actualizar Categoría" para guardar los cambios.</h4>
        
        <form action="editarCategoria" method="POST">
            <!-- Aquí corregí el campo oculto para enviar el ID correctamente -->
            <input type="hidden" name="ID_CATEGORIA" value="${categoria.idCategoria}">
            
            <div class="mb-3">
                <label for="NombreCategoria" class="form-label">Nombre</label>
                <input type="text" class="form-control" name="NOMBRE_CATEGORIA" value="${categoria.nombreCategoria}" required>
            </div>

            <button type="submit" class="btn btn-primary">Actualizar Categoría</button>
        </form>
    </div>
</body>
</html>
