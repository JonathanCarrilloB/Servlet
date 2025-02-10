package controlador;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Distribuidor;

@WebServlet("/editarDistribuidor")
public class EditarDistribuidor extends HttpServlet {

    // Creamos una instancia de la clase Producto
    Distribuidor distribuidor = new Distribuidor();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // En caso de que se necesite procesar el GET, como para cargar un producto para editar.
        int distribuidorId = Integer.parseInt(request.getParameter("ID_DISTRIBUIDOR"));
        Distribuidor distribuidorEditado = distribuidor.obtenerDistribuidorPorId(distribuidorId);

        // Establecemos el producto como atributo para pasarlo a la vista
        request.setAttribute("distribuidor", distribuidorEditado);

        // Redirigir al formulario de edición
        request.getRequestDispatcher("ActualizarDistribuidor.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener los parámetros enviados por el formulario
        String distribuidorIdStr = request.getParameter("ID_DISTRIBUIDOR");
        String nombreDistribuidor = request.getParameter("NOMBRE_DISTRIBUIDOR");
        String direccionStr = request.getParameter("DIRECCION");
        String celularStr = request.getParameter("CELULAR");
        String correoStr = request.getParameter("CORREO");
        String pedidosStr = request.getParameter("PEDIDOS");

        // Convertimos el String productoIdStr a int antes de pasarlo al método setCOD_PRODUCTO
        int distribuidorId = Integer.parseInt(distribuidorIdStr);

        // Configuramos el objeto cliente con los datos obtenidos del formulario
        distribuidor.setIdDistribuidor(distribuidorId);

        // Solo se actualizan los campos si el usuario los ha proporcionado (no nulos o vacíos)
        if (nombreDistribuidor != null && !nombreDistribuidor.isEmpty()) {
            distribuidor.setNombreDistribuidor(nombreDistribuidor);
        }
        if (direccionStr != null && !direccionStr.isEmpty()) {
            distribuidor.setDIRECCION(direccionStr);
        }
        if (celularStr != null && !celularStr.isEmpty()) {
            distribuidor.setCELULAR(celularStr);
        }
        if (correoStr != null && !correoStr.isEmpty()) {
            distribuidor.setCORREO(correoStr);
        }
        if (pedidosStr != null && !pedidosStr.isEmpty()) {
            distribuidor.setPEDIDOS(pedidosStr);
        }

        // Llamamos al método para actualizar el producto en la base de datos
        boolean actualizado = distribuidor.ActualizarDistribuidor();

        if (actualizado) {
            // Si la actualización es exitosa, redirige a la página de éxito
            request.getRequestDispatcher("ActualizaciónExitosaDistribuidor.jsp").forward(request, response);
        } else {
            // Si la actualización falla, redirige a la página de error
            request.getRequestDispatcher("errorActualizacionDistribuidor.jsp").forward(request, response);
        }
    }
}


