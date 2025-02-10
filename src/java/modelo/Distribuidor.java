package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Distribuidor {

    private int idDistribuidor;
    private String nombreDistribuidor;
    private String DIRECCION;
    private String CELULAR;
    private String CORREO;
    private String PEDIDOS;
    

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
    
    public String getDIRECCION() {
        return DIRECCION;
    }

    public void setDIRECCION(String DIRECCION) {
        this.DIRECCION = DIRECCION;
    }
    
    public String getCELULAR() {
        return CELULAR;
    }

    public void setCELULAR(String CELULAR) {
        this.CELULAR = CELULAR;
    }
    
    public String getCORREO() {
        return CORREO;
    }

    public void setCORREO(String CORREO) {
        this.CORREO = CORREO;
    }
    
    public String getPEDIDOS() {
        return PEDIDOS;
    }

    public void setPEDIDOS(String PEDIDOS) {
        this.PEDIDOS = PEDIDOS;
    }

    // Método para obtener todos los distribuidores
    public static List<Distribuidor> obtenerDistribuidores() {
    List<Distribuidor> distribuidores = new ArrayList<>();
    String sql = "SELECT ID_DISTRIBUIDOR, NOMBRE_DISTRIBUIDOR, DIRECCION, CELULAR, CORREO, PEDIDOS FROM distribuidores"; // Agregar los campos faltantes

    try (Connection con = new Conexion().Conexion(); 
         PreparedStatement stmt = con.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            int idDistribuidor = rs.getInt("ID_DISTRIBUIDOR");
            String nombreDistribuidor = rs.getString("NOMBRE_DISTRIBUIDOR");
            String direccion = rs.getString("DIRECCION");
            String celular = rs.getString("CELULAR");
            String correo = rs.getString("CORREO");
            String pedidos = rs.getString("PEDIDOS");

            Distribuidor distribuidor = new Distribuidor();
            distribuidor.setIdDistribuidor(idDistribuidor);
            distribuidor.setNombreDistribuidor(nombreDistribuidor);
            distribuidor.setDIRECCION(direccion);
            distribuidor.setCELULAR(celular);
            distribuidor.setCORREO(correo);
            distribuidor.setPEDIDOS(pedidos);

            distribuidores.add(distribuidor);
        }

    } catch (SQLException e) {
        System.out.println("Error al obtener los distribuidores: " + e.getMessage());
        e.printStackTrace();
    }
    return distribuidores;
}

    
    public Distribuidor obtenerDistribuidorPorId(int idDistribuidor) {
        Distribuidor prod = null;
        String sql = "SELECT * FROM distribuidores WHERE ID_DISTRIBUIDOR = ?";

        try (Connection con = new Conexion().Conexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idDistribuidor); // Establecemos el ID del producto en la consulta

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    prod = new Distribuidor();
                    prod.setIdDistribuidor(rs.getInt("ID_DISTRIBUIDOR"));
                    prod.setNombreDistribuidor(rs.getString("NOMBRE_DISTRIBUIDOR"));
                    prod.setDIRECCION(rs.getString("DIRECCION"));
                    prod.setCELULAR(rs.getString("CELULAR"));
                    prod.setCORREO(rs.getString("CORREO"));
                    prod.setPEDIDOS(rs.getString("PEDIDOS"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prod;
    }
    
    public boolean ActualizarDistribuidor() {
        StringBuilder sql = new StringBuilder("UPDATE distribuidores SET ");
        boolean campoActualizado = false;

        // Añadir solo los campos que no sean nulos o vacíos
        if (this.nombreDistribuidor != null && !this.nombreDistribuidor.isEmpty()) {
            sql.append("NOMBRE_DISTRIBUIDOR = ?, ");
            campoActualizado = true;
        }
        if (this.DIRECCION != null && !this.DIRECCION.isEmpty()) {
            sql.append("DIRECCION = ?, ");
            campoActualizado = true;
        }
        if (this.CELULAR != null && !this.CELULAR.isEmpty()) {
            sql.append("CELULAR = ?, ");
            campoActualizado = true;
        }
        if (this.CORREO != null && !this.CORREO.isEmpty()) {
            sql.append("CORREO = ?, ");
            campoActualizado = true;
        }
        if (this.PEDIDOS != null && !this.PEDIDOS.isEmpty()) {
            sql.append("PEDIDOS = ?, ");
            campoActualizado = true;
        }
        if (sql.toString().endsWith(", ")) {
            sql.delete(sql.length() - 2, sql.length());
        }

        if (campoActualizado) {
            sql.append("WHERE ID_DISTRIBUIDOR = ?");
        } else {
            return false;  // Si no hay ningún campo para actualizar, retornar falso
        }

        try (Connection con = new Conexion().Conexion();
             PreparedStatement ps = con.prepareStatement(sql.toString())) {

            int index = 1;

            // Establecer los parámetros de actualización
            if (this.nombreDistribuidor != null && !this.nombreDistribuidor.isEmpty()) {
                ps.setString(index++, this.nombreDistribuidor);
            }
            if (this.DIRECCION != null && !this.DIRECCION.isEmpty()) {
                ps.setString(index++, this.DIRECCION);
            }
            if (this.CELULAR != null && !this.CELULAR.isEmpty()) {
                ps.setString(index++, this.CELULAR);
            }
            if (this.CORREO != null && !this.CORREO.isEmpty()) {
                ps.setString(index++, this.CORREO);
            }
            if (this.PEDIDOS != null && !this.PEDIDOS.isEmpty()) {
                ps.setString(index++, this.PEDIDOS);
            }

            ps.setInt(index, this.idDistribuidor); 

            int resultado = ps.executeUpdate();
            return resultado > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public int InsertarDistribuidor() {
        String sql = "INSERT INTO distribuidores (NOMBRE_DISTRIBUIDOR, DIRECCION, CELULAR, CORREO, PEDIDOS) VALUES (?, ?, ?, ?, ?)";
        int resultado = 0;

        try (Connection con = new Conexion().Conexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, this.getNombreDistribuidor());
            ps.setString(2, this.DIRECCION);
            ps.setString(3, this.CELULAR);
            ps.setString(4, this.CORREO);
            ps.setString(5, this.PEDIDOS);
            
            resultado = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultado;
    }
    
    public boolean eliminarDistribuidor(int idDistribuidor) {
        String sql = "DELETE FROM distribuidores WHERE ID_DISTRIBUIDOR = ?";
        boolean eliminado = false;

        try (Connection con = new Conexion().Conexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idDistribuidor);
            int resultado = ps.executeUpdate();
            eliminado = resultado > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return eliminado;
    }
    
    public ArrayList<Distribuidor> listarDistribuidor() {
        ArrayList<Distribuidor> lista = new ArrayList<>();
        String sql = "SELECT * FROM distribuidores";

        try (Connection con = new Conexion().Conexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Distribuidor prod = new Distribuidor();
                prod.setIdDistribuidor(rs.getInt("ID_DISTRIBUIDOR"));
                prod.setNombreDistribuidor(rs.getString("NOMBRE_DISTRIBUIDOR"));
                lista.add(prod);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}

