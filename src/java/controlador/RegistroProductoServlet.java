package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Categoria;
import modelo.Distribuidor;

import java.io.IOException;
import java.util.List;

@WebServlet("/registroProducto")
public class RegistroProductoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Llama al método para obtener categorías
        List<Categoria> categorias = Categoria.obtenerCategorias();

        // Llama al método para obtener distribuidores
        List<Distribuidor> distribuidores = Distribuidor.obtenerDistribuidores();

        // Pasa las categorías y distribuidores al JSP
        request.setAttribute("categorias", categorias);
        request.setAttribute("distribuidores", distribuidores);

        // Redirige al archivo JSP
        request.getRequestDispatcher("registroProducto.jsp").forward(request, response);
    }
}

