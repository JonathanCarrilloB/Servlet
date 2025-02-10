package controlador;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.clientes;

@WebServlet("/editarUsuario")
public class EditarUsuario extends HttpServlet {

    // Creamos una instancia de la clase Producto
    clientes cliente = new clientes();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // En caso de que se necesite procesar el GET, como para cargar un producto para editar.
        int clienteId = Integer.parseInt(request.getParameter("ID_CLIENTES"));
        clientes clienteEditado = cliente.obtenerClientePorId(clienteId);

        // Establecemos el producto como atributo para pasarlo a la vista
        request.setAttribute("cliente", clienteEditado);

        // Redirigir al formulario de edición
        request.getRequestDispatcher("ActualizarCliente.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener los parámetros enviados por el formulario
        String clienteIdStr = request.getParameter("ID_CLIENTES");
        String nombre = request.getParameter("NOMBRE");
        String apellidos = request.getParameter("APELLIDOS");
        String documentoStr = request.getParameter("DOCUMENTO");
        String celularStr = request.getParameter("CELULAR");
        String direccionStr = request.getParameter("DIRECCION");
        String correoStr = request.getParameter("CORREO");
        String contraseñaStr = request.getParameter("CONTRASEÑA");

        // Convertimos el String productoIdStr a int antes de pasarlo al método setCOD_PRODUCTO
        int clienteId = Integer.parseInt(clienteIdStr);

        // Configuramos el objeto cliente con los datos obtenidos del formulario
        cliente.setID_CLIENTES(clienteId);

        // Solo se actualizan los campos si el usuario los ha proporcionado (no nulos o vacíos)
        if (nombre != null && !nombre.isEmpty()) {
            cliente.setNOMBRE(nombre);
        }
        if (apellidos != null && !apellidos.isEmpty()) {
            cliente.setAPELLIDOS(apellidos);
        }
        if (documentoStr != null && !documentoStr.isEmpty()) {
            cliente.setDOCUMENTO(documentoStr);
        }
        if (celularStr != null && !celularStr.isEmpty()) {
            cliente.setCELULAR(celularStr);
        }
        if (direccionStr != null && !direccionStr.isEmpty()) {
            cliente.setDIRECCION(direccionStr);
        }
        if (correoStr != null && !correoStr.isEmpty()) {
            cliente.setCORREO(correoStr);
        }
        if (contraseñaStr != null && !contraseñaStr.isEmpty()) {
            cliente.setCONTRASEÑA(contraseñaStr);
        }

        // Llamamos al método para actualizar el producto en la base de datos
        boolean actualizado = cliente.ActualizarCliente();

        if (actualizado) {
            // Si la actualización es exitosa, redirige a la página de éxito
            request.getRequestDispatcher("ActualizaciónExitosaCliente.jsp").forward(request, response);
        } else {
            // Si la actualización falla, redirige a la página de error
            request.getRequestDispatcher("errorActualizacionCliente.jsp").forward(request, response);
        }
    }
}


