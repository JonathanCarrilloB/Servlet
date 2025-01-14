
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
     <head>
    <!-- Meta Tags -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <title>Registro</title>
</head>
<body>
    <div class="container py-5">
        <div class="text-center">
            <h1 class="text-danger mb-4">Registrarme</h1>
            <p class="text-muted">
                Es importante que utilices tu correo principal en caso que olvides la contraseña para poder recuperarla.
            </p>
        </div>
        
        <form action="controlador" method="POST">
            <!-- Correo Electrónico -->
            <div class="mb-3 col-md-6 mx-auto">
                <label for="Usuario" class="form-label">Correo Electrónico</label>
                <input type="email" name="CORREO" class="form-control" id="CORREO" placeholder="Correo Electrónico @" required>
            </div>

            <!-- Contraseña -->
            <div class="mb-3 col-md-6 mx-auto">
                <label for="Contraseña" class="form-label">Contraseña</label>
                <input type="password" name="CONTRASEÑA" class="form-control" id="CONTRASEÑA" placeholder="Cree su contraseña" required>
                <small class="form-text text-muted">
                    (Al menos 8 caracteres, incluyendo números y letras.)
                </small>
            </div>

            <!-- Nombre -->
            <div class="mb-3 col-md-6 mx-auto">
                <label for="Nombre" class="form-label">Nombre</label>
                <input type="text" name="NOMBRE" class="form-control" id="NOMBRE" placeholder="Nombre" required>
            </div>

            <!-- Apellidos -->
            <div class="mb-3 col-md-6 mx-auto">
                <label for="Apellidos" class="form-label">Apellidos</label>
                <input type="text" name="APELLIDOS" class="form-control" id="APELLIDOS" placeholder="Apellidos" required>
            </div>

            <!-- Documento -->
            <div class="mb-3 col-md-6 mx-auto">
                <label for="Cedula" class="form-label">Número de Documento</label>
                <input type="text" name="DOCUMENTO" class="form-control" id="DOCUMENTO" placeholder="Número de documento" required>
            </div>

            <!-- Número de Celular -->
            <div class="mb-3 col-md-6 mx-auto">
                <label for="celular" class="form-label">Número de Celular</label>
                <input type="text" name="CELULAR" class="form-control" id="CELULAR" placeholder="Número de celular" required>
            </div>

            <!-- Dirección -->
            <div class="mb-3 col-md-6 mx-auto">
                <label for="Dirección" class="form-label">Dirección</label>
                <textarea class="form-control" name="DIRECCION" id="DIRECCION" rows="2" placeholder="Dirección"></textarea>
            </div>

            <!-- Botón de Registro -->
            <div class="d-grid col-md-6 mx-auto">
                <button type="submit" name="accion" value="Insertar" class="btn btn-danger btn-lg">Registrarme</button>
            </div>
        </form>
    </div>

    <!-- Bootstrap 5 JS Bundle -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
