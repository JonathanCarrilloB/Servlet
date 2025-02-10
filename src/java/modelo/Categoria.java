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

        try (Connection con = new Conexion().Conexion();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("ID_CATEGORIA"));
                categoria.setNombreCategoria(rs.getString("NOMBRE_CATEGORIA"));
                categorias.add(categoria);
            }

            System.out.println("Categorías obtenidas: " + categorias.size());

        } catch (SQLException e) {
            System.out.println("Error al obtener las categorías: " + e.getMessage());
            e.printStackTrace();
        }

        return categorias;
    }
    
    public Categoria obtenerCategoriaPorId(int idCategoria) {
        Categoria prod = null;
        String sql = "SELECT * FROM categoria WHERE ID_CATEGORIA = ?";

        try (Connection con = new Conexion().Conexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idCategoria); // Establecemos el ID del producto en la consulta

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    prod = new Categoria();
                    prod.setIdCategoria(rs.getInt("ID_CATEGORIA"));
                    prod.setNombreCategoria(rs.getString("NOMBRE_CATEGORIA"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prod;
    }
    
    public boolean ActualizarCategoria() {
        StringBuilder sql = new StringBuilder("UPDATE categoria SET ");
        boolean campoActualizado = false;

        // Añadir solo los campos que no sean nulos o vacíos
        if (this.nombreCategoria != null && !this.nombreCategoria.isEmpty()) {
            sql.append("NOMBRE_CATEGORIA = ?, ");
            campoActualizado = true;
        }
        if (sql.toString().endsWith(", ")) {
            sql.delete(sql.length() - 2, sql.length());
        }

        if (campoActualizado) {
            sql.append("WHERE ID_CATEGORIA = ?");
        } else {
            return false;  // Si no hay ningún campo para actualizar, retornar falso
        }

        try (Connection con = new Conexion().Conexion();
             PreparedStatement ps = con.prepareStatement(sql.toString())) {

            int index = 1;

            // Establecer los parámetros de actualización
            if (this.nombreCategoria != null && !this.nombreCategoria.isEmpty()) {
                ps.setString(index++, this.nombreCategoria);
            }

            ps.setInt(index, this.idCategoria); 

            int resultado = ps.executeUpdate();
            return resultado > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public int InsertarCategoria() {
        String sql = "INSERT INTO categoria (NOMBRE_CATEGORIA) VALUES (?)";
        int resultado = 0;

        try (Connection con = new Conexion().Conexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, this.getNombreCategoria());
            resultado = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultado;
    }
    
    public boolean eliminarCategoria(int idCategoria) {
        String sql = "DELETE FROM categoria WHERE ID_CATEGORIA = ?";
        boolean eliminado = false;

        try (Connection con = new Conexion().Conexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idCategoria);
            int resultado = ps.executeUpdate();
            eliminado = resultado > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return eliminado;
    }
    
    public ArrayList<Categoria> listarCategoria() {
        ArrayList<Categoria> lista = new ArrayList<>();
        String sql = "SELECT * FROM categoria";

        try (Connection con = new Conexion().Conexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Categoria prod = new Categoria();
                prod.setIdCategoria(rs.getInt("ID_CATEGORIA"));
                prod.setNombreCategoria(rs.getString("NOMBRE_CATEGORIA"));
                lista.add(prod);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
