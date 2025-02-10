package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List; // Importa List
import java.util.ArrayList;
import java.sql.ResultSet;
 

public class clientes {
    int ID_CLIENTES;
    String CORREO;
    String CONTRASEÑA;
    String NOMBRE;
    String APELLIDOS;
    String DOCUMENTO;
    String CELULAR;
    String DIRECCION;

    public clientes() {
    }

    public clientes(int ID_CLIENTES, String CORREO, String CONTRASEÑA, String NOMBRE, String APELLIDOS, String DOCUMENTO, String CELULAR, String DIRECCION) {
        this.ID_CLIENTES = ID_CLIENTES;
        this.CORREO = CORREO;
        this.CONTRASEÑA = CONTRASEÑA;
        this.NOMBRE = NOMBRE;
        this.APELLIDOS = APELLIDOS;
        this.DOCUMENTO = DOCUMENTO;
        this.CELULAR = CELULAR;
        this.DIRECCION = DIRECCION;
    }

    // Getters y Setters para todos los atributos
    public int getID_CLIENTES() {
        return ID_CLIENTES;
    }

    public void setID_CLIENTES(int ID_CLIENTES) {
    this.ID_CLIENTES = ID_CLIENTES;
    }

    public String getCORREO() {
        return CORREO;
    }

    public void setCORREO(String CORREO) {
        this.CORREO = CORREO;
    }

    public String getCONTRASEÑA() {
        return CONTRASEÑA;
    }

    public void setCONTRASEÑA(String CONTRASEÑA) {
        this.CONTRASEÑA = CONTRASEÑA;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getAPELLIDOS() {
        return APELLIDOS;
    }

    public void setAPELLIDOS(String APELLIDOS) {
        this.APELLIDOS = APELLIDOS;
    }

    public String getDOCUMENTO() {
        return DOCUMENTO;
    }

    public void setDOCUMENTO(String DOCUMENTO) {
        this.DOCUMENTO = DOCUMENTO;
    }

    public String getCELULAR() {
        return CELULAR;
    }

    public void setCELULAR(String CELULAR) {
        this.CELULAR = CELULAR;
    }

    public String getDIRECCION() {
        return DIRECCION;
    }

    public void setDIRECCION(String DIRECCION) {
        this.DIRECCION = DIRECCION;
    }

    // Método para insertar un cliente en la base de datos
    public int Insertar() {
        String sql = "INSERT INTO clientes (NOMBRE, APELLIDOS, DOCUMENTO, CELULAR, DIRECCION, CORREO, CONTRASEÑA) VALUES (?, ?, ?, ?, ?, ?, ?)";
        int resultado = 0;

        try (Connection con = new Conexion().Conexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, this.NOMBRE);
            ps.setString(2, this.APELLIDOS);
            ps.setString(3, this.DOCUMENTO);
            ps.setString(4, this.CELULAR);
            ps.setString(5, this.DIRECCION);
            ps.setString(6, this.CORREO);
            ps.setString(7, this.CONTRASEÑA);

            resultado = ps.executeUpdate(); // Devuelve 1 si se inserta correctamente
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultado;
    }
    
    public ArrayList<clientes> listarClientes() {
        ArrayList<clientes> lista = new ArrayList<>();
        String sql = "SELECT * FROM clientes";

        try (Connection con = new Conexion().Conexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                clientes prod = new clientes();
                prod.setID_CLIENTES(rs.getInt("ID_CLIENTES"));
                prod.setNOMBRE(rs.getString("NOMBRE"));
                prod.setAPELLIDOS(rs.getString("APELLIDOS"));
                prod.setDOCUMENTO(rs.getString("DOCUMENTO"));
                prod.setCELULAR(rs.getString("CELULAR"));
                prod.setDIRECCION(rs.getString("DIRECCION"));  // Se mantiene como String
                prod.setCORREO(rs.getString("CORREO"));
                prod.setCONTRASEÑA(rs.getString("CONTRASEÑA"));
                lista.add(prod);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // Método para eliminar un cliente por su ID
    public boolean eliminarCliente(int idCliente) {
        String sql = "DELETE FROM clientes WHERE ID_CLIENTES = ?";
        boolean eliminado = false;

        try (Connection con = new Conexion().Conexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idCliente);
            int resultado = ps.executeUpdate();
            eliminado = resultado > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return eliminado;
    }

    // Método para actualizar los datos de un cliente
    public boolean ActualizarCliente() {
        boolean actualizado = false;
        StringBuilder sql = new StringBuilder("UPDATE clientes SET ");
        boolean primerCampo = true; // Para controlar la inclusión de la coma en la consulta

        try (Connection conex = new Conexion().Conexion()) {
            // Lista de parámetros para la consulta
            List<Object> parametros = new ArrayList<>(); // Importado correctamente

            if (this.NOMBRE != null && !this.NOMBRE.isEmpty()) {
                if (!primerCampo) sql.append(", ");
                sql.append("NOMBRE = ?");
                parametros.add(this.NOMBRE);
                primerCampo = false;
            }
            if (this.APELLIDOS != null && !this.APELLIDOS.isEmpty()) {
                if (!primerCampo) sql.append(", ");
                sql.append("APELLIDOS = ?");
                parametros.add(this.APELLIDOS);
                primerCampo = false;
            }
            if (this.CELULAR != null && !this.CELULAR.isEmpty()) {
                if (!primerCampo) sql.append(", ");
                sql.append("CELULAR = ?");
                parametros.add(this.CELULAR);
                primerCampo = false;
            }
            if (this.DIRECCION != null && !this.DIRECCION.isEmpty()) {
                if (!primerCampo) sql.append(", ");
                sql.append("DIRECCION = ?");
                parametros.add(this.DIRECCION);
                primerCampo = false;
            }
            if (this.CORREO != null && !this.CORREO.isEmpty()) {
                if (!primerCampo) sql.append(", ");
                sql.append("CORREO = ?");
                parametros.add(this.CORREO);
                primerCampo = false;
            }
            if (this.CONTRASEÑA != null && !this.CONTRASEÑA.isEmpty()) {
                if (!primerCampo) sql.append(", ");
                sql.append("CONTRASEÑA = ?");
                parametros.add(this.CONTRASEÑA);
                primerCampo = false;
            }

            // Verifica que al menos un campo fue enviado para actualizar
            if (parametros.isEmpty()) {
                return false; // Nada que actualizar
            }

            // Agregar la condición WHERE
            sql.append(" WHERE DOCUMENTO = ?");
            parametros.add(this.DOCUMENTO);

            // Crear la consulta preparada
            try (PreparedStatement ps = conex.prepareStatement(sql.toString())) {
                for (int i = 0; i < parametros.size(); i++) {
                    ps.setObject(i + 1, parametros.get(i));
                }

                // Ejecutar la actualización
                actualizado = ps.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return actualizado;
    }
    public clientes obtenerClientePorId(int idCliente) {
        clientes prod = null;
        String sql = "SELECT * FROM clientes WHERE ID_CLIENTES = ?";

        try (Connection con = new Conexion().Conexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idCliente); // Establecemos el ID del producto en la consulta

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    prod = new clientes();
                    prod.setID_CLIENTES(rs.getInt("ID_CLIENTES"));
                    prod.setNOMBRE(rs.getString("NOMBRE"));
                    prod.setAPELLIDOS(rs.getString("APELLIDOS"));
                    prod.setDOCUMENTO(rs.getString("DOCUMENTO"));
                    prod.setCELULAR(rs.getString("CELULAR"));
                    prod.setDIRECCION(rs.getString("DIRECCION"));
                    prod.setCORREO(rs.getString("CORREO"));
                    prod.setCONTRASEÑA(rs.getString("CONTRASEÑA"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return prod;
    }
    // Método estático para obtener productos desde la base de datos
    public static ArrayList<clientes> obtenerClientes() {
        ArrayList<clientes> lista = new ArrayList<>();
        String sql = "SELECT * FROM clientes";

        try (Connection con = new Conexion().Conexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                clientes prod = new clientes();
                prod.setID_CLIENTES(rs.getInt("ID_CLIENTES"));
                prod.setNOMBRE(rs.getString("NOMBRE"));
                prod.setAPELLIDOS(rs.getString("APELLIDOS"));
                prod.setDOCUMENTO(rs.getString("DOCUMENTO"));
                prod.setCELULAR(rs.getString("CELULAR"));
                prod.setDIRECCION(rs.getString("DIRECCION"));  // Se mantiene como String
                prod.setCORREO(rs.getString("CORREO"));
                prod.setCONTRASEÑA(rs.getString("CONTRASEÑA"));
                lista.add(prod);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
