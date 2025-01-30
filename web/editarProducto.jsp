 <%@ page import="modelo.productos" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Producto</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1 class="text-warning">Editar Producto <a href="InventarioServlet" class="btn btn-outline-dark">Regresar</a></h1>
        <h4>Modifica los campos que desees cambiar y luego pulsa el botón "Actualizar Producto" para guardar los cambios.</h4>
        <form action="editarProductoServlet" method="POST">
            <input type="hidden" name="COD_PRODUCTO" value="${producto.COD_PRODUCTO}">
            
            <div class="mb-3">
                <label for="nombre" class="form-label">Nombre</label>
                <input type="text" class="form-control" id="nombre" name="NOMBRE" value="${producto.NOMBRE}" required>
            </div>

            <div class="mb-3">
                <label for="valor_venta" class="form-label">Valor Unitario de Venta</label>
                <input type="text" class="form-control" id="valor_venta" name="VALOR_UNITARIO_VENTA" value="${producto.VALOR_UNITARIO_VENTA}" required>
            </div>

            <div class="mb-3">
                <label for="valor_compra" class="form-label">Valor Unitario de Compra</label>
                <input type="text" class="form-control" id="valor_compra" name="VALOR_UNITARIO_COMPRA" value="${producto.VALOR_UNITARIO_COMPRA}" required>
            </div>

            <div class="mb-3">
                <label for="descripcion" class="form-label">Descripción</label>
                <textarea class="form-control" id="descripcion" name="DESCRIPCION" rows="3" required>${producto.DESCRIPCION}</textarea>
            </div>

            <div class="mb-3">
                <label for="cantidad" class="form-label">Cantidad</label>
                <input type="number" class="form-control" id="cantidad" name="CANTIDAD" value="${producto.CANTIDAD}" required>
            </div>

            <div class="mb-3">
                <label for="categoria" class="form-label">Categoría</label>
                <select class="form-select" id="categoria" name="CATEGORIA_ID_CATEGORIA" required>
                    <!-- Aquí puedes cargar las categorías disponibles dinámicamente -->
                    <option value="${producto.CATEGORIA_ID_CATEGORIA}" selected>${producto.obtenerNombreCategoria()}</option>
                    <!-- Suponiendo que tienes una lista de categorías -->
                    <c:forEach var="categoria" items="${categorias}">
                        <option value="${categoria.ID_CATEGORIA}">${categoria.NOMBRE_CATEGORIA}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="mb-3">
                <label for="distribuidor" class="form-label">Distribuidor</label>
                <select class="form-select" id="distribuidor" name="DISTRIBUIDORES_ID_DISTRIBUIDOR" required>
                    <!-- Aquí puedes cargar los distribuidores disponibles dinámicamente -->
                    <option value="${producto.DISTRIBUIDORES_ID_DISTRIBUIDOR}" selected>${producto.obtenerNombreDistribuidor()}</option>
                    <!-- Suponiendo que tienes una lista de distribuidores -->
                    <c:forEach var="distribuidor" items="${distribuidores}">
                        <option value="${distribuidor.ID_DISTRIBUIDOR}">${distribuidor.NOMBRE_DISTRIBUIDOR}</option>
                    </c:forEach>
                </select>
            </div>

            <button type="submit" class="btn btn-primary">Actualizar Producto</button>
        </form>
    </div>
</body>
</html>