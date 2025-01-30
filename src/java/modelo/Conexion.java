
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    private final String user = "root";
    private final String password = "";
    private final String url = "jdbc:mysql://localhost:3306/mydb"; // Reemplaza 'mydb' por tu base de datos real
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private Connection conex;

    // Método para establecer la conexión
    public Connection Conexion() {
        try {
            // Carga el driver de MySQL
            Class.forName(driver);
            
            // Establece la conexión con la base de datos
            conex = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (ClassNotFoundException e) {
            System.err.println("Error: No se encontró el driver de la base de datos.");
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException e) {
            System.err.println("Error: No se pudo conectar a la base de datos.");
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }
        return conex;
    }

    // Método para cerrar la conexión
    public void cerrarConexion() {
        try {
            if (conex != null && !conex.isClosed()) {
                conex.close();
                System.out.println("Conexión cerrada correctamente.");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión.");
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}


