package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Categoria {
    
    // Atributos
    private int idCategoria;
    private String nombreCategoria;

    // Getters y setters
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    // Método para obtener todas las categorías
    public static List<Categoria> obtenerCategorias() {
        List<Categoria> categorias = new ArrayList<>();

        String sql = "SELECT ID_CATEGORIA, NOMBRE_CATEGORIA FROM categoria";

        try (Connection con = new Conexion().Conexion();  // Obtén la conexión con tu clase de conexión
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                // Obtener los valores del ResultSet
                int idCategoria = rs.getInt("ID_CATEGORIA");
                String nombreCategoria = rs.getString("NOMBRE_CATEGORIA");

                // Crear una instancia de Categoria y agregarla a la lista
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(idCategoria);
                categoria.setNombreCategoria(nombreCategoria);
                categorias.add(categoria);
            }

            // Verificación de las categorías obtenidas
            System.out.println("Categorías obtenidas: " + categorias.size());

        } catch (SQLException e) {
            // Manejo de excepciones
            System.out.println("Error al obtener las categorías: " + e.getMessage());
            e.printStackTrace();
        }

        return categorias;  // Devolver la lista de categorías
    }
}


