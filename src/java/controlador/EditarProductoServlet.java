package controlador;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.productos;

@WebServlet("/editarProductoServlet")
public class EditarProductoServlet extends HttpServlet {

    // Creamos una instancia de la clase Producto
    productos producto = new productos();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // En caso de que se necesite procesar el GET, como para cargar un producto para editar.
        int productoId = Integer.parseInt(request.getParameter("COD_PRODUCTO"));
        productos productoEditado = producto.obtenerProductoPorId(productoId);

        // Establecemos el producto como atributo para pasarlo a la vista
        request.setAttribute("producto", productoEditado);

        // Redirigir al formulario de edición
        request.getRequestDispatcher("editarProducto.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener los parámetros enviados por el formulario
        String productoIdStr = request.getParameter("COD_PRODUCTO");
        String nombre = request.getParameter("NOMBRE");
        String descripcion = request.getParameter("DESCRIPCION");
        String valorVentaStr = request.getParameter("VALOR_UNITARIO_VENTA");
        String valorCompraStr = request.getParameter("VALOR_UNITARIO_COMPRA");
        String cantidadStr = request.getParameter("CANTIDAD");
        String categoriaIdStr = request.getParameter("CATEGORIA_ID_CATEGORIA");
        String distribuidorIdStr = request.getParameter("DISTRIBUIDORES_ID_DISTRIBUIDOR");

        // Convertimos el String productoIdStr a int antes de pasarlo al método setCOD_PRODUCTO
        int productoId = Integer.parseInt(productoIdStr);

        // Configuramos el objeto producto con los datos obtenidos del formulario
        producto.setCOD_PRODUCTO(productoId);

        // Solo se actualizan los campos si el usuario los ha proporcionado (no nulos o vacíos)
        if (nombre != null && !nombre.isEmpty()) {
            producto.setNOMBRE(nombre);
        }
        if (descripcion != null && !descripcion.isEmpty()) {
            producto.setDESCRIPCION(descripcion);
        }
        if (valorVentaStr != null && !valorVentaStr.isEmpty()) {
            producto.setVALOR_UNITARIO_VENTA(valorVentaStr);
        }
        if (valorCompraStr != null && !valorCompraStr.isEmpty()) {
            producto.setVALOR_UNITARIO_COMPRA(valorCompraStr);
        }
        if (cantidadStr != null && !cantidadStr.isEmpty()) {
            producto.setCANTIDAD(cantidadStr);
        }
        if (categoriaIdStr != null && !categoriaIdStr.isEmpty()) {
            producto.setCATEGORIA_ID_CATEGORIA(categoriaIdStr);
        }
        if (distribuidorIdStr != null && !distribuidorIdStr.isEmpty()) {
            producto.setDISTRIBUIDORES_ID_DISTRIBUIDOR(distribuidorIdStr);
        }

        // Llamamos al método para actualizar el producto en la base de datos
        boolean actualizado = producto.ActualizarProducto();

        if (actualizado) {
            // Si la actualización es exitosa, redirige a la página de éxito
            request.getRequestDispatcher("ActualizaciónExitosaProducto.jsp").forward(request, response);
        } else {
            // Si la actualización falla, redirige a la página de error
            request.getRequestDispatcher("errorActualizacionProducto.jsp").forward(request, response);
        }
    }
}


