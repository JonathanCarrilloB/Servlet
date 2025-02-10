package controlador;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Validar;
import modelo.clientes;

public class controlador extends HttpServlet {

    // Creamos instancias de Validar y clientes
    Validar Valid = new Validar();
    clientes p = new clientes();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response); // Redirige la solicitud al método común para manejar la lógica
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response); // Redirige la solicitud al método común para manejar la lógica
    }

    // Este método común maneja tanto las solicitudes GET como POST
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Obtención de la acción enviada desde el formulario
        String accion = request.getParameter("accion");

        // Comprobamos la acción seleccionada
        if (accion != null) {
            // Acción para iniciar sesión
            if (accion.equals("login")) {
                String CORREO = request.getParameter("CORREO");
                String CONTRASEÑA = request.getParameter("CONTRASEÑA");

                p.setCORREO(CORREO);
                p.setCONTRASEÑA(CONTRASEÑA);

                // Llamada al método de validación
                int r = Valid.Validar(p);

                if (r >= 1) {
                    // Si la validación es exitosa, redirige a la página principal
                    request.getSession().setAttribute("CORREO", CORREO);
                    request.getSession().setAttribute("CONTRASEÑA", CONTRASEÑA);
                    request.getRequestDispatcher("principal.jsp").forward(request, response);
                } else {
                    // Si la validación falla, muestra un error
                    request.getRequestDispatcher("errorLogin.jsp").forward(request, response);
                }
            }
            // Acción para redirigir al formulario de registro
            else if (accion.equals("registro")) {
                request.getRequestDispatcher("registro.jsp").forward(request, response);
            }
            // Acción para insertar un cliente en la base de datos
            else if (accion.equals("Insertar")) {
                String NOMBRE = request.getParameter("NOMBRE");
                String APELLIDOS = request.getParameter("APELLIDOS");
                String DOCUMENTO = request.getParameter("DOCUMENTO");
                String CELULAR = request.getParameter("CELULAR");
                String DIRECCION = request.getParameter("DIRECCION");
                String CORREO = request.getParameter("CORREO");
                String CONTRASEÑA = request.getParameter("CONTRASEÑA");

                // Configurar el objeto cliente
                p.setNOMBRE(NOMBRE);
                p.setAPELLIDOS(APELLIDOS);
                p.setDOCUMENTO(DOCUMENTO);
                p.setCELULAR(CELULAR);
                p.setDIRECCION(DIRECCION);
                p.setCORREO(CORREO);
                p.setCONTRASEÑA(CONTRASEÑA);

                // Llamar al método para insertar en la base de datos
                int resultado = p.Insertar();

                if (resultado == 1) {
                    // Si la inserción es exitosa, redirige a la página de éxito
                    request.getRequestDispatcher("registroExitoso.jsp").forward(request, response);
                } else {
                    // Si la inserción falla, muestra un error
                    request.getRequestDispatcher("errorRegistro.jsp").forward(request, response);
                }
            }
            
            // Acción para actualizar todos los campos de un cliente
            else if (accion.equals("ActualizarCliente")) {
                String NOMBRE = request.getParameter("NOMBRE");
                String APELLIDOS = request.getParameter("APELLIDOS");
                String DOCUMENTO = request.getParameter("DOCUMENTO");
                String CELULAR = request.getParameter("CELULAR");
                String DIRECCION = request.getParameter("DIRECCION");
                String CORREO = request.getParameter("CORREO");
                String CONTRASEÑA = request.getParameter("CONTRASEÑA");

                // Configurar los datos en el objeto cliente
                p.setNOMBRE(NOMBRE);
                p.setAPELLIDOS(APELLIDOS);
                p.setDOCUMENTO(DOCUMENTO);
                p.setCELULAR(CELULAR);
                p.setDIRECCION(DIRECCION);
                p.setCORREO(CORREO);
                p.setCONTRASEÑA(CONTRASEÑA);

                // Llamar al método de actualización en la clase clientes
                boolean actualizado = p.ActualizarCliente();

                if (actualizado) {
                    // Si se actualiza correctamente, redirige a una página de éxito
                    request.getRequestDispatcher("actualizacionExitosa.jsp").forward(request, response);
                } else {
                    // Si falla, redirige a una página de error
                    request.getRequestDispatcher("errorActualizacion.jsp").forward(request, response);
                }
            }
            // Acción no reconocida
            else {
                request.getRequestDispatcher("errorLogin.jsp").forward(request, response);
            }
        } else {
            // Si no se recibe ninguna acción
            request.getRequestDispatcher("errorLogin.jsp").forward(request, response);
        }
    }
}
