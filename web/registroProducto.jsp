
<%@ page import="java.util.List" %>
<%@ page import="modelo.Categoria" %>
<%@ page import="modelo.Distribuidor" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registrar Producto</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

    <div class="container">
        <div class="row mt-5">
            <div class="col">
                <h1 class="text-success">Nuevo Producto <a href="InventarioServlet" class="btn btn-outline-dark">Regresar</a></h1>
            </div>
        </div>
        <form action="controlador2" method="POST">
    <input type="hidden" name="accion" value="InsertarProductos">

    <div class="row mt-5">
        <div class="col-6">
            <label for="NOMBRE" class="form-label">Nombre</label>
            <input type="text" class="form-control" name="NOMBRE" id="NOMBRE" required>
        </div>

        <div class="col-6">
            <label for="VALOR_UNITARIO_VENTA" class="form-label">Valor Unitario Venta</label>
            <input type="text" class="form-control" name="VALOR_UNITARIO_VENTA" id="VALOR_UNITARIO_VENTA" required>
        </div>

        <div class="col-6">
            <label for="VALOR_UNITARIO_COMPRA" class="form-label">Valor Unitario Compra</label>
            <input type="text" class="form-control" name="VALOR_UNITARIO_COMPRA" id="VALOR_UNITARIO_COMPRA" required>
        </div>

        <div class="col-12 mb-3">
            <label for="DESCRIPCION" class="form-label">Descripción</label>
            <input type="text" class="form-control" name="DESCRIPCION" id="DESCRIPCION" required>
        </div>

        <div class="col-6">
            <label for="CANTIDAD" class="form-label">Cantidad</label>
            <input type="text" class="form-control" name="CANTIDAD" id="CANTIDAD" required>
        </div>

        <div class="col-6">
            <label for="CATEGORIA" class="form-label">Categoría</label>
            <select name="CATEGORIA" id="CATEGORIA" class="form-select" required>
                <option value="0">Seleccione una categoría</option>
                <% 
                List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
                if (categorias != null && !categorias.isEmpty()) {
                    for (Categoria categoria : categorias) {
                %>
                <option value="<%= categoria.getIdCategoria() %>">
                    <%= categoria.getNombreCategoria() %>
                </option>
                <% 
                    }
                }
                %>
            </select>
        </div>

        <div class="col-6">
            <label for="DISTRIBUIDOR" class="form-label">Distribuidor</label>
            <select name="DISTRIBUIDOR" id="DISTRIBUIDOR" class="form-select" required>
                <option value="0">Seleccione un distribuidor</option>
                <% 
                List<Distribuidor> distribuidores = (List<Distribuidor>) request.getAttribute("distribuidores");
                if (distribuidores != null && !distribuidores.isEmpty()) {
                    for (Distribuidor distribuidor : distribuidores) {
                %>
                <option value="<%= distribuidor.getIdDistribuidor() %>">
                    <%= distribuidor.getNombreDistribuidor() %>
                </option>
                <% 
                    }
                }
                %>
            </select>
        </div>
    </div>

    <button type="submit" class="btn btn-primary mt-3">Registrar Producto</button>
</form>

    </div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>



