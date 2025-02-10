package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Distribuidor;

import java.io.IOException;
import java.util.List;

@WebServlet("/distribuidor")
public class DistribuidorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("eliminar".equals(action)) {
            eliminarDistribuidor(request, response);
        } else {
            mostrarDistribuidor(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("accion");

        if ("InsertarDistribuidor".equals(action)) {
            insertarDistribuidor(request, response);
        } else {
            response.sendRedirect("Distribuidor.jsp");
        }
    }

    private void insertarDistribuidor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String nombreDistribuidor = request.getParameter("NombreDistribuidor");
    String direccion = request.getParameter("DIRECCION");
    String celular = request.getParameter("CELULAR");
    String correo = request.getParameter("CORREO");
    String pedidos = request.getParameter("PEDIDOS");

    if (nombreDistribuidor != null && !nombreDistribuidor.trim().isEmpty() &&
        direccion != null && !direccion.trim().isEmpty() &&
        celular != null && !celular.trim().isEmpty() &&
        correo != null && !correo.trim().isEmpty() &&
        pedidos != null && !pedidos.trim().isEmpty()) {

        try {

            Distribuidor nuevoDistribuidor = new Distribuidor();
            nuevoDistribuidor.setNombreDistribuidor(nombreDistribuidor);
            nuevoDistribuidor.setDIRECCION(direccion);
            nuevoDistribuidor.setCELULAR(celular);
            nuevoDistribuidor.setCORREO(correo);
            nuevoDistribuidor.setPEDIDOS(pedidos);

            int resultado = nuevoDistribuidor.InsertarDistribuidor();

            if (resultado == 1) {
                response.sendRedirect("RegistroDistribuidorExitoso.jsp"); // Página de éxito
            } else {
                request.setAttribute("error", "Hubo un problema al registrar el distribuidor.");
                request.getRequestDispatcher("errorRegistroDistribuidor.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            request.setAttribute("error", "El número de pedidos debe ser un valor numérico.");
            request.getRequestDispatcher("errorRegistroDistribuidor.jsp").forward(request, response);
        }
    } else {
        request.setAttribute("error", "Todos los campos son obligatorios.");
        request.getRequestDispatcher("errorRegistroDistribuidor.jsp").forward(request, response);
    }
}


    private void eliminarDistribuidor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idDistribuidorStr = request.getParameter("id");

        if (idDistribuidorStr != null) {
            try {
                int idDistribuidor = Integer.parseInt(idDistribuidorStr);
                Distribuidor cat = new Distribuidor();
                boolean eliminado = cat.eliminarDistribuidor(idDistribuidor);

                if (eliminado) {
                    request.setAttribute("mensaje", "Distribuidor eliminado exitosamente.");
                } else {
                    request.setAttribute("mensaje", "Error al eliminar el distribuidor.");
                }
            } catch (NumberFormatException e) {
                request.setAttribute("mensaje", "ID del distribuidor no es válido.");
            }
        } else {
            request.setAttribute("mensaje", "No se proporcionó un ID del distribuidor.");
        }

        mostrarDistribuidor(request, response);
    }

    private void mostrarDistribuidor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Distribuidor> listaDistribuidor = Distribuidor.obtenerDistribuidores();
        request.setAttribute("distribuidor", listaDistribuidor);
        request.getRequestDispatcher("Distribuidor.jsp").forward(request, response);
    }
}
