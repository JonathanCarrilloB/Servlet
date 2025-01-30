
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertarProductos {
    PreparedStatement ps; // Para preparar la consulta SQL
    Connection con; // Para manejar la conexión
    Conexion cn = new Conexion(); // Instancia de tu clase Conexion

    // Método para insertar un cliente en la base de datos
    public boolean InsertarProductos(productos producto) {
        String sql = "INSERT INTO productos (NOMBRE, VALOR_UNITARIO_VENTA, VALOR_UNITARIO_COMPRA, DESCRIPCION, CANTIDAD, CATEGORIA_ID_CATEGORIA, DISTRIBUIDORES_ID_DISTRIBUIDOR) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            con = cn.Conexion(); // Establecer conexión con la base de datos
            ps = con.prepareStatement(sql); // Preparar la consulta SQL
            ps.setString(1, producto.getNOMBRE()); // Configurar el valor de NOMBRE
            ps.setString(2, producto.getVALOR_UNITARIO_VENTA()); // Configurar el valor de APELLIDOS
            ps.setString(3, producto.getVALOR_UNITARIO_COMPRA()); // Configurar el valor de DOCUMENTO
            ps.setString(4, producto.getDESCRIPCION()); // Configurar el valor de CELULAR
            ps.setString(5, producto.getCANTIDAD()); // Configurar el valor de DIRECCION
            ps.setString(6, producto.getCATEGORIA_ID_CATEGORIA()); // Configurar el valor de CORREO
            ps.setString(7, producto.getDISTRIBUIDORES_ID_DISTRIBUIDOR()); // Configurar el valor de CONTRASEÑA

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

