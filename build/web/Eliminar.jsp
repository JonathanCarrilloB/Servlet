<!DOCTYPE html>
<html>
<head>
    <title>Eliminar Cliente</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container py-5">
        <h1 class="text-center text-danger">Eliminar Cliente</h1>
        <form action="controlador" method="POST" class="mt-4">
            <!-- N�mero de Documento -->
            <div class="mb-3">
                <label for="DOCUMENTO" class="form-label">N�mero de Documento</label>
                <input type="text" name="DOCUMENTO" class="form-control" id="DOCUMENTO" placeholder="Ingrese el n�mero de documento" required>
            </div>

            <!-- Bot�n de Eliminar -->
            <button type="submit" name="accion" value="Eliminar" class="btn btn-danger">Eliminar Cliente</button>
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

