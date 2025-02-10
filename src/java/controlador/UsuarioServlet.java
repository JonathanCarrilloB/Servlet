package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.clientes;

import java.io.IOException;
import java.util.List;

@WebServlet("/usuarios")
public class UsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("eliminar".equals(action)) {
            eliminarCliente(request, response);
        } else {
            mostrarUsuario(request, response);
        }
    }

    private void eliminarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idClienteStr = request.getParameter("id");

        if (idClienteStr != null) {
            try {
                int idCliente = Integer.parseInt(idClienteStr);
                clientes prod = new clientes();
                boolean eliminado = prod.eliminarCliente(idCliente);

                if (eliminado) {
                    request.setAttribute("mensaje", "Usuario eliminado exitosamente.");
                } else {
                    request.setAttribute("mensaje", "Error al eliminar el Usuario.");
                }
            } catch (NumberFormatException e) {
                request.setAttribute("mensaje", "ID del Usuario no es válido.");
            }
        } else {
            request.setAttribute("mensaje", "No se proporcionó un ID del Usuario.");
        }

        // Mostrar inventario actualizado
        mostrarUsuario(request, response);
    }

    private void mostrarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener lista de productos desde la base de datos
        List<clientes> listaClientes = clientes.obtenerClientes();

        // Enviar la lista de productos al JSP
        request.setAttribute("clientes", listaClientes);

        // Redirigir a la página de inventario
        request.getRequestDispatcher("Usuarios.jsp").forward(request, response);
    }
}



