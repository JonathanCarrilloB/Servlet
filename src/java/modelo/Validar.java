
package modelo;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.sql.Connection;
import java.sql.SQLException;
 

public class Validar {
    PreparedStatement ps; //Ejecuta una consulta o una sentencia SQL
    ResultSet rs; //Objeto que tendrá la capacidad de obtener la respuesta de la bd
    Connection con; //Interfaz que permite establecer la conexión con la bd
    Conexion cn = new Conexion();
    
    public Validar(){
        
    }
    
    public int Validar(clientes per){
        int r=0; //Para contar el número de registros que cumple una condición
        String sql = "SELECT * FROM clientes WHERE CORREO = ? AND CONTRASEÑA = ?";
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, per.getCORREO());
            ps.setString(2, per.getCONTRASEÑA());
            rs = ps.executeQuery();
            
            while(rs.next()){ //next realiza desplazamiento hasta encontrar un o un conjunto de datos
                r++;
                per.setCORREO(rs.getString("CORREO"));
                per.setCONTRASEÑA(rs.getString("CONTRASEÑA"));
            }
            
            if(r >= 1)
                return 1;
            else 
                return 0;
            
        } catch (SQLException e) {
            
        }
        
        return 0;
    }
}
