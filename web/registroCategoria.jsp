
<%@ page import="java.util.List" %>
<%@ page import="modelo.Categoria" %>
<%@ page import="modelo.Distribuidor" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registrar Categoría</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

    <div class="container">
        <div class="row mt-5">
            <div class="col">
                <h1 class="text-success">Nueva Categoría <a href="CategoriaServlet" class="btn btn-outline-dark">Regresar</a></h1>
            </div>
        </div>
        <form action="CategoriaServlet" method="POST">
    <input type="hidden" name="accion" value="InsertarCategoria">

    <div class="row mt-5">
        <div class="col-6">
            <label for="NombreCategoria" class="form-label">Nombre</label>
            <input type="text" class="form-control" name="NombreCategoria" id="NombreCategoria" required>
        </div>
    </div>
    <button type="submit" class="btn btn-primary mt-3">Registrar Categoría</button>
</form>

    </div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>




