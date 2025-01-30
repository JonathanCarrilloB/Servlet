<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="refresh" content="4; url=InventarioServlet"> <!-- Redirige al inicio después de 3 segundos -->
    <title>Actualización Exitosa</title>
    <!-- Actualiza el enlace de Bootstrap 5 a la versión más reciente -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body class="container text-center py-5">
    <div class="alert alert-success" role="alert">
        <h4 class="alert-heading">¡Actualización exitosa!</h4>
        <p>La información del producto se ha actualizado correctamente.</p>
        <hr>
        <p class="mb-0">Serás redirigido al inventario en breve...</p>
    </div>
    <!-- Botón de redirección manual -->
    <a href="InventarioServlet" class="btn btn-primary">Ir al inicio</a>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
