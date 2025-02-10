
<%@ page import="java.util.List" %>
<%@ page import="modelo.Categoria" %>
<%@ page import="modelo.Distribuidor" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registrar Distribuidor</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

    <div class="container">
        <div class="row mt-5">
            <div class="col">
                <h1 class="text-success">Nuevo Distribuidor <a href="DistribuidorServlet" class="btn btn-outline-dark">Regresar</a></h1>
            </div>
        </div>
        <form action="DistribuidorServlet" method="POST">
    <input type="hidden" name="accion" value="InsertarDistribuidor">

    <div class="row mt-5">
        <div class="col-6">
            <label for="NombreDistribuidor" class="form-label">Nombre</label>
            <input type="text" class="form-control" name="NombreDistribuidor" id="NombreDistribuidor" required>
        </div>
        
        <div class="col-6">
            <label for="DIRECCION" class="form-label">Dirección</label>
            <input type="text" class="form-control" name="DIRECCION" id="DIRECCION" required>
        </div>
        
        <div class="col-6">
            <label for="CELULAR" class="form-label">Celular</label>
            <input type="text" class="form-control" name="CELULAR" id="CELULAR" required>
        </div>
        
        <div class="col-6">
            <label for="CORREO" class="form-label">Correo</label>
            <input type="text" class="form-control" name="CORREO" id="CORREO" required>
        </div>
        
        <div class="col-6">
            <label for="PEDIDOS" class="form-label">Pedidos</label>
            <input type="text" class="form-control" name="PEDIDOS" id="PEDIDOS" required>
        </div>
    </div>
    <button type="submit" class="btn btn-primary mt-3">Registrar Distribuidor</button>
</form>

    </div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
