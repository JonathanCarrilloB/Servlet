package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.productos;

import java.io.IOException;
import java.util.List;

@WebServlet("/inventario")
public class InventarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("eliminar".equals(action)) {
            eliminarProducto(request, response);
        } else {
            mostrarInventario(request, response);
        }
    }

    private void eliminarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idProductoStr = request.getParameter("id");

        if (idProductoStr != null) {
            try {
                int idProducto = Integer.parseInt(idProductoStr);
                productos prod = new productos();
                boolean eliminado = prod.eliminarProducto(idProducto);

                if (eliminado) {
                    request.setAttribute("mensaje", "Producto eliminado exitosamente.");
                } else {
                    request.setAttribute("mensaje", "Error al eliminar el producto.");
                }
            } catch (NumberFormatException e) {
                request.setAttribute("mensaje", "ID de producto no válido.");
            }
        } else {
            request.setAttribute("mensaje", "No se proporcionó un ID de producto.");
        }

        // Mostrar inventario actualizado
        mostrarInventario(request, response);
    }

    private void mostrarInventario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener lista de productos desde la base de datos
        List<productos> listaProductos = productos.obtenerProductos();

        // Enviar la lista de productos al JSP
        request.setAttribute("productos", listaProductos);

        // Redirigir a la página de inventario
        request.getRequestDispatcher("Inventario.jsp").forward(request, response);
    }
}


