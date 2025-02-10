<%@page contentType="text/html; charset=UTF-8" %>
<%@page language="java" %>
<%@page import="java.util.List" %>
<%@page import="modelo.productos" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inventario</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        .table th, .table td {
            text-align: center;
        }
        h1 {
            text-align: center;
            margin-bottom: 30px;
        }
    </style>
</head>
<body class="bg-light">

   <div class="container">
        <div class="row mt-5">
            <div class="col">
                <h1 class="text-success">Inventario 
                    <a href="registroProducto" class="btn btn-outline-success">Añadir Producto</a> <a href="principal.jsp" class="btn btn-outline-dark">Regresar</a></h1>
                </h1>
            </div>
        </div>

        <div class="row mt-4">
            <div class="col">
                <div class="table-responsive">
                    <table class="table table-striped table-hover">
                        <thead class="table-dark">
                            <tr>
                                <th>COD_PRODUCTO</th>
                                <th>NOMBRE</th>
                                <th>VALOR UNITARIO VENTA</th>
                                <th>VALOR UNITARIO COMPRA</th>
                                <th>DESCRIPCION</th>
                                <th>CANTIDAD</th>
                                <th>CATEGORIA</th>
                                <th>DISTRIBUIDOR</th>
                                <th>ACCIONES</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% 
                                List<productos> productos = (List<productos>) request.getAttribute("productos");
                                if (productos != null && !productos.isEmpty()) {
                                    for (productos producto : productos) { 
                            %>
                            <tr>
                                <td><%= producto.getCOD_PRODUCTO() %></td>
                                <td><%= producto.getNOMBRE() %></td>
                                <td>$<%= producto.getVALOR_UNITARIO_VENTA() %></td>
                                <td>$<%= producto.getVALOR_UNITARIO_COMPRA() %></td>
                                <td><%= producto.getDESCRIPCION() %></td>
                                <td><%= producto.getCANTIDAD() %></td>
                                <td><%= producto.obtenerNombreCategoria() %></td>
                                <td><%= producto.obtenerNombreDistribuidor() %></td>

                                <td>
                                    <a href="editarProductoServlet?COD_PRODUCTO=<%= producto.getCOD_PRODUCTO() %>" 
                                       class="btn btn-warning btn-sm">Editar</a>

                                    <!-- Botón de eliminar con confirmación -->
                                    <a href="inventario?action=eliminar&id=<%= producto.getCOD_PRODUCTO() %>" 
                                       class="btn btn-danger btn-sm"
                                       onclick="return confirm('¿Estás seguro de eliminar este producto?');">
                                       Eliminar
                                    </a>
                                </td>
                            </tr>
                            <% 
                                    }
                                } else { 
                            %>
                            <tr>
                                <td colspan="9" class="text-center text-muted">No hay productos registrados</td>
                            </tr>
                            <% } %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
   </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
