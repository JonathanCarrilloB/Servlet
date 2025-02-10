package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Categoria;

import java.io.IOException;
import java.util.List;

@WebServlet("/categoria")
public class CategoriaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("eliminar".equals(action)) {
            eliminarCategoria(request, response);
        } else {
            mostrarCategoria(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("accion");

        if ("InsertarCategoria".equals(action)) {
            insertarCategoria(request, response);
        } else {
            response.sendRedirect("Categoria.jsp");
        }
    }

    private void insertarCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombreCategoria = request.getParameter("NombreCategoria");

        if (nombreCategoria != null && !nombreCategoria.trim().isEmpty()) {
            Categoria nuevaCategoria = new Categoria();
            nuevaCategoria.setNombreCategoria(nombreCategoria);

            int resultado = nuevaCategoria.InsertarCategoria();

            if (resultado == 1) {
                response.sendRedirect("RegistroCategoriaExitoso.jsp"); // Página de éxito
            } else {
                request.setAttribute("error", "Hubo un problema al registrar la categoría.");
                request.getRequestDispatcher("errorRegistroCategoria.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("error", "El nombre de la categoría es obligatorio.");
            request.getRequestDispatcher("errorRegistroCategoria.jsp").forward(request, response);
        }
    }

    private void eliminarCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idCategoriaStr = request.getParameter("id");

        if (idCategoriaStr != null) {
            try {
                int idCategoria = Integer.parseInt(idCategoriaStr);
                Categoria cat = new Categoria();
                boolean eliminado = cat.eliminarCategoria(idCategoria);

                if (eliminado) {
                    request.setAttribute("mensaje", "Categoría eliminada exitosamente.");
                } else {
                    request.setAttribute("mensaje", "Error al eliminar la categoría.");
                }
            } catch (NumberFormatException e) {
                request.setAttribute("mensaje", "ID de la categoría no es válido.");
            }
        } else {
            request.setAttribute("mensaje", "No se proporcionó un ID de la categoría.");
        }

        mostrarCategoria(request, response);
    }

    private void mostrarCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Categoria> listaCategoria = Categoria.obtenerCategorias();
        request.setAttribute("categoria", listaCategoria);
        request.getRequestDispatcher("Categoria.jsp").forward(request, response);
    }
}
