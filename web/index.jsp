<%-- 
    Document   : index
    Created on : 10/01/2025, 2:22:28 a. m.
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Proyecto SENA</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <style>
        /* Centrar el contenido verticalmente */
        .flex-center {
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh; /* Tomar el 100% de la altura de la ventana */
        }

        /* Estilo del logo */
        .logo img {
            max-width: 100%; /* Ajustar el tamaño de la imagen */
            height: auto;
        }

        /* Márgenes personalizados */
        .login-form {
            margin: 20px;
        }
    </style>    
    </head>
    <body>
        <div class="container">
        <div class="row flex-center">
            <!-- Columna para el formulario de inicio de sesión -->
            <div class="col-md-6 login-form">
                <h1 class="text-center text-danger">Inicio de Sesión</h1>
                <p class="text-center text-muted">Bienvenidos a nuestro sistema, para continuar por favor regístrate e inicia sesión.</p>
                <form action="controlador" method="POST">
                    <div class="mb-3">
                        <label for="Usuario" class="form-label">Usuario</label>
                        <input type="text" name="CORREO" class="form-control" id="CORREO" placeholder="Correo Electrónico @" required>
                    </div>
                    <div class="mb-3">
                        <label for="Contraseña" class="form-label">Contraseña</label>
                        <input type="password" name="CONTRASEÑA" class="form-control" id="CONTRASEÑA" placeholder="Ingrese su contraseña" required>
                    </div>
                    <button type="submit" name="accion" value="login" class="btn btn-danger w-100">Iniciar Sesión</button>
                    <div class="text-center mt-3">
                        <a href="ruta_a_tu_pagina_de_recuperacion" class="text-decoration-none">¿Olvidaste tu contraseña?</a>
                    </div>
                    <div class="text-center mt-3">
    <a href="registro.jsp" class="btn btn-warning w-100">Registrarme</a>
</div>

                </form>
            </div>

            <!-- Columna para el logo -->
            <div class="col-md-6 text-center">
                <div class="logo">
                    <img src="LOGO1.jpg" alt="Logo de la Empresa" class="img-fluid">
                </div>
            </div>
        </div>
    </div>

        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
