<%@page contentType="text/html; charset=UTF-8" %>
<%@page language="java" %>
<%@page import="java.util.List" %>
<%@page import="modelo.Distribuidor" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Distribuidor</title>
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
                <h1 class="text-secondary">Distribuidores 
                    <a href="registroDistribuidor.jsp" class="btn btn-outline-success">Añadir Distribuidor</a> <a href="principal.jsp" class="btn btn-outline-dark">Regresar</a></h1>
                </h1>
            </div>
        </div>

        <div class="row mt-4">
            <div class="col">
                <div class="table-responsive">
                    <table class="table table-striped table-hover">
                        <thead class="table-dark">
                            <tr>
                                <th>ID_DISTRIBUIDOR</th>
                                <th>NOMBRE</th>
                                <th>DIRECCION</th>
                                <th>CELULAR</th>
                                <th>CORREO</th>
                                <th>PEDIDOS</th>
                                <th>ACCIONES</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% 
                                List<Distribuidor> distribuidores = (List<Distribuidor>) request.getAttribute("distribuidor"); // Corregido
                                if (distribuidores != null && !distribuidores.isEmpty()) { 
                                    for (Distribuidor distribuidor : distribuidores) { 
                            %>
                            <tr>
                                <td><%= distribuidor.getIdDistribuidor() %></td>
                                <td><%= distribuidor.getNombreDistribuidor() %></td>
                                <td><%= distribuidor.getDIRECCION() %></td>
                                <td><%= distribuidor.getCELULAR() %></td>
                                <td><%= distribuidor.getCORREO() %></td>
                                <td><%= distribuidor.getPEDIDOS() %></td>
                                
                                <td>
                                    <a href="editarDistribuidor?ID_DISTRIBUIDOR=<%= distribuidor.getIdDistribuidor() %>" 
                                       class="btn btn-warning btn-sm">Editar</a>

                                    <!-- Botón de eliminar con confirmación -->
                                    <a href="distribuidor?action=eliminar&id=<%= distribuidor.getIdDistribuidor() %>" 
                                       class="btn btn-danger btn-sm"
                                       onclick="return confirm('¿Estás seguro de eliminar este Distribuidor?');">
                                       Eliminar
                                    </a>
                                </td>
                            </tr>
                            <% 
                                    }
                                } else { 
                            %>
                            <tr>
                                <td colspan="3" class="text-center text-muted">No hay distribuidores registrados</td> <!-- Corregido colspan -->
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

