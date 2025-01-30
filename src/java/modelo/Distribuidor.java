package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Distribuidor {

    private int idDistribuidor;
    private String nombreDistribuidor;

    // Getters y setters
    public int getIdDistribuidor() {
        return idDistribuidor;
    }

    public void setIdDistribuidor(int idDistribuidor) {
        this.idDistribuidor = idDistribuidor;
    }

    public String getNombreDistribuidor() {
        return nombreDistribuidor;
    }

    public void setNombreDistribuidor(String nombreDistribuidor) {
        this.nombreDistribuidor = nombreDistribuidor;
    }

    // Método para obtener todos los distribuidores
    public static List<Distribuidor> obtenerDistribuidores() {
        List<Distribuidor> distribuidores = new ArrayList<>();
        String sql = "SELECT ID_DISTRIBUIDOR, NOMBRE_DISTRIBUIDOR FROM distribuidores"; // Cambia el nombre de la tabla si es diferente

        try (Connection con = new Conexion().Conexion(); 
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int idDistribuidor = rs.getInt("ID_DISTRIBUIDOR");
                String nombreDistribuidor = rs.getString("NOMBRE_DISTRIBUIDOR");

                Distribuidor distribuidor = new Distribuidor();
                distribuidor.setIdDistribuidor(idDistribuidor);
                distribuidor.setNombreDistribuidor(nombreDistribuidor);
                distribuidores.add(distribuidor);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener los distribuidores: " + e.getMessage());
            e.printStackTrace();
        }
        return distribuidores;
    }
}

