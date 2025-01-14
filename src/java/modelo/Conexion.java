
package modelo;

import java.sql.*;
import java.util.logging.Level; 
import java.util.logging.Logger; 


public class Conexion {
    
    String user = "root";
    String password = "";
    String url = "jdbc:mysql://localhost:3306/mydb";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection conex; //Creando una variable tipo connexion
    Statement statement; // Permite ejecutar sentencias sql atraves de la conexión establecida.
    ResultSet rs;
    
    //creamos un método tipo connection
    public Connection Conexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //Carga una clase de manera dinamica en tiempo de ejecución.
            try {
                conex = DriverManager.getConnection(url, user, password); //Establece una conexión con la bd
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("No hay conexión con "+url);
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conex;
    }
    }

