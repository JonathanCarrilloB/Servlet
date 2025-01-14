
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insertar {
    PreparedStatement ps; // Para preparar la consulta SQL
    Connection con; // Para manejar la conexión
    Conexion cn = new Conexion(); // Instancia de tu clase Conexion

    // Método para insertar un cliente en la base de datos
    public boolean Insertar(clientes cliente) {
        String sql = "INSERT INTO clientes (NOMBRE, APELLIDOS, DOCUMENTO, CELULAR, DIRECCION, CORREO, CONTRASEÑA) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            con = cn.Conexion(); // Establecer conexión con la base de datos
            ps = con.prepareStatement(sql); // Preparar la consulta SQL
            ps.setString(1, cliente.getNOMBRE()); // Configurar el valor de NOMBRE
            ps.setString(2, cliente.getAPELLIDOS()); // Configurar el valor de APELLIDOS
            ps.setString(3, cliente.getDOCUMENTO()); // Configurar el valor de DOCUMENTO
            ps.setString(4, cliente.getCELULAR()); // Configurar el valor de CELULAR
            ps.setString(5, cliente.getDIRECCION()); // Configurar el valor de DIRECCION
            ps.setString(6, cliente.getCORREO()); // Configurar el valor de CORREO
            ps.setString(7, cliente.getCONTRASEÑA()); // Configurar el valor de CONTRASEÑA

            int resultado = ps.executeUpdate(); // Ejecutar la consulta de inserción
            return resultado > 0; // Retorna true si la inserción fue exitosa
        } catch (SQLException e) {
            e.printStackTrace(); // Muestra el error en la consola
            return false;
        } finally {
            try {
                if (ps != null) ps.close(); // Cierra el PreparedStatement
                if (con != null) con.close(); // Cierra la conexión
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
