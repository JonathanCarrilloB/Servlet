package controlador;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.productos;
import modelo.Categoria;
import java.util.List;

@WebServlet(name = "controlador2", urlPatterns = {"/controlador2"})
public class controlador2 extends HttpServlet {

    productos p = new productos();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Obtener las categorías de la base de datos
        List<Categoria> categorias = Categoria.obtenerCategorias();

        // Verificar si las categorías fueron obtenidas correctamente
        if (categorias == null || categorias.isEmpty()) {
            request.setAttribute("error", "No se encontraron categorías disponibles.");
            request.getRequestDispatcher("errorRegistroProducto.jsp").forward(request, response); // Redirige en caso de error
            return; // Asegúrate de que no continue con el proceso de inserción
        } else {
            // Si hay categorías, pasarlas al JSP
            request.setAttribute("categorias", categorias);
        }

        // Obtención de la acción enviada desde el formulario
        String accion = request.getParameter("accion");

        if (accion != null && accion.equals("InsertarProductos")) {
            // Obtener los parámetros enviados desde el formulario
            String NOMBRE = request.getParameter("NOMBRE");
            String VALOR_UNITARIO_VENTA = request.getParameter("VALOR_UNITARIO_VENTA");
            String VALOR_UNITARIO_COMPRA = request.getParameter("VALOR_UNITARIO_COMPRA");
            String DESCRIPCION = request.getParameter("DESCRIPCION");
            String CANTIDAD = request.getParameter("CANTIDAD");
            String CATEGORIA_ID_CATEGORIA = request.getParameter("CATEGORIA");
            String DISTRIBUIDORES_ID_DISTRIBUIDOR = request.getParameter("DISTRIBUIDOR");

            // Configurar el objeto de producto con los datos del formulario
            p.setNOMBRE(NOMBRE);
            p.setVALOR_UNITARIO_VENTA(VALOR_UNITARIO_VENTA);
            p.setVALOR_UNITARIO_COMPRA(VALOR_UNITARIO_COMPRA);
            p.setDESCRIPCION(DESCRIPCION);
            p.setCANTIDAD(CANTIDAD);
            p.setCATEGORIA_ID_CATEGORIA(CATEGORIA_ID_CATEGORIA);
            p.setDISTRIBUIDORES_ID_DISTRIBUIDOR(DISTRIBUIDORES_ID_DISTRIBUIDOR);

            // Llamar al método para insertar el producto en la base de datos
            int resultado = p.InsertarProductos();

            if (resultado == 1) {
                // Si la inserción es exitosa, redirige a la página de éxito
                response.sendRedirect("ProductoRegistrado.jsp"); // Redirección sin mantener los datos de la solicitud
            } else {
                // Si la inserción falla, muestra un error
                request.setAttribute("error", "Hubo un problema al registrar el producto.");
                request.getRequestDispatcher("errorRegistroProducto.jsp").forward(request, response);
            }
        } else {
            // Si no se recibe la acción, redirigir a la página principal o mostrar algún mensaje
            request.getRequestDispatcher("formularioProducto.jsp").forward(request, response);
        }
    }
}
