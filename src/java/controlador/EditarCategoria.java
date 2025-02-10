package controlador;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Categoria;

@WebServlet("/editarCategoria")
public class EditarCategoria extends HttpServlet {

    // Creamos una instancia de la clase Producto
    Categoria categoria = new Categoria();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // En caso de que se necesite procesar el GET, como para cargar un producto para editar.
        int categoriaId = Integer.parseInt(request.getParameter("ID_CATEGORIA"));
        Categoria categoriaEditada = categoria.obtenerCategoriaPorId(categoriaId);

        // Establecemos el producto como atributo para pasarlo a la vista
        request.setAttribute("categoria", categoriaEditada);

        // Redirigir al formulario de edición
        request.getRequestDispatcher("ActualizarCategoria.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener los parámetros enviados por el formulario
        String categoriaIdStr = request.getParameter("ID_CATEGORIA");
        String nombreCategoria = request.getParameter("NOMBRE_CATEGORIA");

        // Convertimos el String productoIdStr a int antes de pasarlo al método setCOD_PRODUCTO
        int categoriaId = Integer.parseInt(categoriaIdStr);

        // Configuramos el objeto cliente con los datos obtenidos del formulario
        categoria.setIdCategoria(categoriaId);

        // Solo se actualizan los campos si el usuario los ha proporcionado (no nulos o vacíos)
        if (nombreCategoria != null && !nombreCategoria.isEmpty()) {
            categoria.setNombreCategoria(nombreCategoria);
        }

        // Llamamos al método para actualizar el producto en la base de datos
        boolean actualizado = categoria.ActualizarCategoria();

        if (actualizado) {
            // Si la actualización es exitosa, redirige a la página de éxito
            request.getRequestDispatcher("ActualizaciónExitosaCategoria.jsp").forward(request, response);
        } else {
            // Si la actualización falla, redirige a la página de error
            request.getRequestDispatcher("errorActualizacionCategoria.jsp").forward(request, response);
        }
    }
}


