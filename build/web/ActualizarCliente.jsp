<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Actualizar Cliente</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center mb-4">Actualizar Información del Cliente</h1>
        <form action="controlador" method="post">
            <input type="hidden" name="accion" value="ActualizarCliente">
            
            <div class="mb-3">
                <label for="DOCUMENTO" class="form-label">Documento (Obligatorio para identificar al cliente)</label>
                <input type="text" class="form-control" id="DOCUMENTO" name="DOCUMENTO" required>
                <div class="form-text">Ingresa el documento del cliente para identificarlo.</div>
            </div>

            <div class="mb-3">
                <label for="NOMBRE" class="form-label">Nombre (Opcional)</label>
                <input type="text" class="form-control" id="NOMBRE" name="NOMBRE">
                <div class="form-text">Deja este campo vacío si no deseas cambiar el nombre.</div>
            </div>

            <div class="mb-3">
                <label for="APELLIDOS" class="form-label">Apellidos (Opcional)</label>
                <input type="text" class="form-control" id="APELLIDOS" name="APELLIDOS">
                <div class="form-text">Deja este campo vacío si no deseas cambiar los apellidos.</div>
            </div>

            <div class="mb-3">
                <label for="CELULAR" class="form-label">Celular (Opcional)</label>
                <input type="text" class="form-control" id="CELULAR" name="CELULAR">
                <div class="form-text">Deja este campo vacío si no deseas cambiar el número de celular.</div>
            </div>

            <div class="mb-3">
                <label for="DIRECCION" class="form-label">Dirección (Opcional)</label>
                <input type="text" class="form-control" id="DIRECCION" name="DIRECCION">
                <div class="form-text">Deja este campo vacío si no deseas cambiar la dirección.</div>
            </div>

            <div class="mb-3">
                <label for="CORREO" class="form-label">Correo (Opcional)</label>
                <input type="email" class="form-control" id="CORREO" name="CORREO">
                <div class="form-text">Deja este campo vacío si no deseas cambiar el correo.</div>
            </div>

            <div class="mb-3">
                <label for="CONTRASEÑA" class="form-label">Contraseña (Opcional)</label>
                <input type="password" class="form-control" id="CONTRASEÑA" name="CONTRASEÑA">
                <div class="form-text">Deja este campo vacío si no deseas cambiar la contraseña.</div>
            </div>

            <button type="submit" class="btn btn-primary w-100">Actualizar</button>
        </form>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
