<%@page contentType="text/html; charset=UTF-8" %>
<%@page language="java" %>
<%@page import="java.util.List" %>
<%@page import="modelo.clientes" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Usuarios</title>
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
                <h1 class="text-secondary">Usuarios 
                    <a href="registro.jsp" class="btn btn-outline-success">Añadir Usuario</a> <a href="principal.jsp" class="btn btn-outline-dark">Regresar</a></h1>
                </h1>
            </div>
        </div>

        <div class="row mt-4">
            <div class="col">
                <div class="table-responsive">
                    <table class="table table-striped table-hover">
                        <thead class="table-dark">
                            <tr>
                                <th>ID_CLIENTES</th>
                                <th>NOMBRE</th>
                                <th>APELLIDOS</th>
                                <th>DOCUMENTO</th>
                                <th>CELULAR</th>
                                <th>DIRECCION</th>
                                <th>CORREO</th>
                                <th>CONTRASEÑA</th>
                                <th>ACCIONES</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% 
                                List<clientes> clientes = (List<clientes>) request.getAttribute("clientes");
                                if (clientes != null && !clientes.isEmpty()) {
                                    for (clientes cliente : clientes) { 
                            %>
                            <tr>
                                <td><%= cliente.getID_CLIENTES() %></td>
                                <td><%= cliente.getNOMBRE() %></td>
                                <td>$<%= cliente.getAPELLIDOS() %></td>
                                <td>$<%= cliente.getDOCUMENTO() %></td>
                                <td><%= cliente.getCELULAR() %></td>
                                <td><%= cliente.getDIRECCION() %></td>
                                <td><%= cliente.getCORREO() %></td>
                                <td><%= cliente.getCONTRASEÑA() %></td>

                                <td>
                                    <a href="editarUsuario?ID_CLIENTES=<%= cliente.getID_CLIENTES() %>" 
                                       class="btn btn-warning btn-sm">Editar</a>

                                    <!-- Botón de eliminar con confirmación -->
                                    <a href="usuarios?action=eliminar&id=<%= cliente.getID_CLIENTES() %>" 
                                       class="btn btn-danger btn-sm"
                                       onclick="return confirm('¿Estás seguro de eliminar este Usuario?');">
                                       Eliminar
                                    </a>
                                </td>
                            </tr>
                            <% 
                                    }
                                } else { 
                            %>
                            <tr>
                                <td colspan="9" class="text-center text-muted">No hay usuarios registrados</td>
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

