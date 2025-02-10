package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class productos {
    // Atributos
    int COD_PRODUCTO;
    String NOMBRE;
    String VALOR_UNITARIO_VENTA;
    String VALOR_UNITARIO_COMPRA;
    String DESCRIPCION;
    String CANTIDAD;
    String CATEGORIA_ID_CATEGORIA;
    String DISTRIBUIDORES_ID_DISTRIBUIDOR;

    // Constructor vacío
    public productos() {
    }

    // Constructor con parámetros
    public productos(int COD_PRODUCTO, String NOMBRE, String VALOR_UNITARIO_VENTA, String VALOR_UNITARIO_COMPRA, 
                     String DESCRIPCION, String CANTIDAD, String CATEGORIA_ID_CATEGORIA, String DISTRIBUIDORES_ID_DISTRIBUIDOR) {
        this.COD_PRODUCTO = COD_PRODUCTO;
        this.NOMBRE = NOMBRE;
        this.VALOR_UNITARIO_VENTA = VALOR_UNITARIO_VENTA;
        this.VALOR_UNITARIO_COMPRA = VALOR_UNITARIO_COMPRA;
        this.DESCRIPCION = DESCRIPCION;
        this.CANTIDAD = CANTIDAD;
        this.CATEGORIA_ID_CATEGORIA = CATEGORIA_ID_CATEGORIA;
        this.DISTRIBUIDORES_ID_DISTRIBUIDOR = DISTRIBUIDORES_ID_DISTRIBUIDOR;
    }

    // Getters y Setters
    public int getCOD_PRODUCTO() {
        return COD_PRODUCTO;
    }

    public void setCOD_PRODUCTO(int COD_PRODUCTO) {
        this.COD_PRODUCTO = COD_PRODUCTO;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getVALOR_UNITARIO_VENTA() {
        return VALOR_UNITARIO_VENTA;
    }

    public void setVALOR_UNITARIO_VENTA(String VALOR_UNITARIO_VENTA) {
        this.VALOR_UNITARIO_VENTA = VALOR_UNITARIO_VENTA;
    }

    public String getVALOR_UNITARIO_COMPRA() {
        return VALOR_UNITARIO_COMPRA;
    }

    public void setVALOR_UNITARIO_COMPRA(String VALOR_UNITARIO_COMPRA) {
        this.VALOR_UNITARIO_COMPRA = VALOR_UNITARIO_COMPRA;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    public String getCANTIDAD() {
        return CANTIDAD;
    }

    public void setCANTIDAD(String CANTIDAD) {
        this.CANTIDAD = CANTIDAD;
    }

    public String getCATEGORIA_ID_CATEGORIA() {
        return CATEGORIA_ID_CATEGORIA;
    }

    public void setCATEGORIA_ID_CATEGORIA(String CATEGORIA_ID_CATEGORIA) {
        this.CATEGORIA_ID_CATEGORIA = CATEGORIA_ID_CATEGORIA;
    }

    public String getDISTRIBUIDORES_ID_DISTRIBUIDOR() {
        return DISTRIBUIDORES_ID_DISTRIBUIDOR;
    }

    public void setDISTRIBUIDORES_ID_DISTRIBUIDOR(String DISTRIBUIDORES_ID_DISTRIBUIDOR) {
        this.DISTRIBUIDORES_ID_DISTRIBUIDOR = DISTRIBUIDORES_ID_DISTRIBUIDOR;
    }

    // Método para insertar un producto en la base de datos
    public int InsertarProductos() {
        String sql = "INSERT INTO productos (NOMBRE, VALOR_UNITARIO_VENTA, VALOR_UNITARIO_COMPRA, DESCRIPCION, CANTIDAD, CATEGORIA_ID_CATEGORIA, DISTRIBUIDORES_ID_DISTRIBUIDOR) VALUES (?, ?, ?, ?, ?, ?, ?)";
        int resultado = 0;

        try (Connection con = new Conexion().Conexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, this.NOMBRE);
            ps.setString(2, this.VALOR_UNITARIO_VENTA);
            ps.setString(3, this.VALOR_UNITARIO_COMPRA);
            ps.setString(4, this.DESCRIPCION);
            ps.setString(5, this.CANTIDAD);  // Se mantiene como String
            ps.setString(6, this.CATEGORIA_ID_CATEGORIA);
            ps.setString(7, this.DISTRIBUIDORES_ID_DISTRIBUIDOR);

            resultado = ps.executeUpdate(); // Devuelve 1 si se inserta correctamente
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultado;
    }

    // Método para obtener la lista de productos desde la base de datos
    public ArrayList<productos> listarProductos() {
        ArrayList<productos> lista = new ArrayList<>();
        String sql = "SELECT * FROM productos";

        try (Connection con = new Conexion().Conexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                productos prod = new productos();
                prod.setCOD_PRODUCTO(rs.getInt("COD_PRODUCTO"));
                prod.setNOMBRE(rs.getString("NOMBRE"));
                prod.setVALOR_UNITARIO_VENTA(rs.getString("VALOR_UNITARIO_VENTA"));
                prod.setVALOR_UNITARIO_COMPRA(rs.getString("VALOR_UNITARIO_COMPRA"));
                prod.setDESCRIPCION(rs.getString("DESCRIPCION"));
                prod.setCANTIDAD(rs.getString("CANTIDAD"));  // Se mantiene como String
                prod.setCATEGORIA_ID_CATEGORIA(rs.getString("CATEGORIA_ID_CATEGORIA"));
                prod.setDISTRIBUIDORES_ID_DISTRIBUIDOR(rs.getString("DISTRIBUIDORES_ID_DISTRIBUIDOR"));
                lista.add(prod);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // Método estático para obtener productos desde la base de datos
    public static ArrayList<productos> obtenerProductos() {
        ArrayList<productos> lista = new ArrayList<>();
        String sql = "SELECT * FROM productos";

        try (Connection con = new Conexion().Conexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                productos prod = new productos();
                prod.setCOD_PRODUCTO(rs.getInt("COD_PRODUCTO"));
                prod.setNOMBRE(rs.getString("NOMBRE"));
                prod.setVALOR_UNITARIO_VENTA(rs.getString("VALOR_UNITARIO_VENTA"));
                prod.setVALOR_UNITARIO_COMPRA(rs.getString("VALOR_UNITARIO_COMPRA"));
                prod.setDESCRIPCION(rs.getString("DESCRIPCION"));
                prod.setCANTIDAD(rs.getString("CANTIDAD"));  // Se mantiene como String
                prod.setCATEGORIA_ID_CATEGORIA(rs.getString("CATEGORIA_ID_CATEGORIA"));
                prod.setDISTRIBUIDORES_ID_DISTRIBUIDOR(rs.getString("DISTRIBUIDORES_ID_DISTRIBUIDOR"));
                lista.add(prod);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // Método para obtener el nombre de la categoría
    public String obtenerNombreCategoria() {
        String nombreCategoria = "";
        String sql = "SELECT NOMBRE_CATEGORIA FROM categoria WHERE ID_CATEGORIA = ?";

        try (Connection con = new Conexion().Conexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, this.CATEGORIA_ID_CATEGORIA);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    nombreCategoria = rs.getString("NOMBRE_CATEGORIA");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nombreCategoria;
    }

    // Método para obtener el nombre del distribuidor
    public String obtenerNombreDistribuidor() {
        String nombreDistribuidor = "";
        String sql = "SELECT NOMBRE_DISTRIBUIDOR FROM distribuidores WHERE ID_DISTRIBUIDOR = ?";

        try (Connection con = new Conexion().Conexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, this.DISTRIBUIDORES_ID_DISTRIBUIDOR);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    nombreDistribuidor = rs.getString("NOMBRE_DISTRIBUIDOR");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nombreDistribuidor;
    }

    // Método para obtener un producto por su ID
    public productos obtenerProductoPorId(int idProducto) {
        productos prod = null;
        String sql = "SELECT * FROM productos WHERE COD_PRODUCTO = ?";

        try (Connection con = new Conexion().Conexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idProducto); // Establecemos el ID del producto en la consulta

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    prod = new productos();
                    prod.setCOD_PRODUCTO(rs.getInt("COD_PRODUCTO"));
                    prod.setNOMBRE(rs.getString("NOMBRE"));
                    prod.setVALOR_UNITARIO_VENTA(rs.getString("VALOR_UNITARIO_VENTA"));
                    prod.setVALOR_UNITARIO_COMPRA(rs.getString("VALOR_UNITARIO_COMPRA"));
                    prod.setDESCRIPCION(rs.getString("DESCRIPCION"));
                    prod.setCANTIDAD(rs.getString("CANTIDAD"));
                    prod.setCATEGORIA_ID_CATEGORIA(rs.getString("CATEGORIA_ID_CATEGORIA"));
                    prod.setDISTRIBUIDORES_ID_DISTRIBUIDOR(rs.getString("DISTRIBUIDORES_ID_DISTRIBUIDOR"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return prod;
    }

    // Método para actualizar un producto en la base de datos
    public boolean ActualizarProducto() {
        StringBuilder sql = new StringBuilder("UPDATE productos SET ");
        boolean campoActualizado = false;

        // Añadir solo los campos que no sean nulos o vacíos
        if (this.NOMBRE != null && !this.NOMBRE.isEmpty()) {
            sql.append("NOMBRE = ?, ");
            campoActualizado = true;
        }
        if (this.VALOR_UNITARIO_VENTA != null && !this.VALOR_UNITARIO_VENTA.isEmpty()) {
            sql.append("VALOR_UNITARIO_VENTA = ?, ");
            campoActualizado = true;
        }
        if (this.VALOR_UNITARIO_COMPRA != null && !this.VALOR_UNITARIO_COMPRA.isEmpty()) {
            sql.append("VALOR_UNITARIO_COMPRA = ?, ");
            campoActualizado = true;
        }
        if (this.DESCRIPCION != null && !this.DESCRIPCION.isEmpty()) {
            sql.append("DESCRIPCION = ?, ");
            campoActualizado = true;
        }
        if (this.CANTIDAD != null && !this.CANTIDAD.isEmpty()) {
            sql.append("CANTIDAD = ?, ");
            campoActualizado = true;
        }
        if (this.CATEGORIA_ID_CATEGORIA != null && !this.CATEGORIA_ID_CATEGORIA.isEmpty()) {
            sql.append("CATEGORIA_ID_CATEGORIA = ?, ");
            campoActualizado = true;
        }
        if (this.DISTRIBUIDORES_ID_DISTRIBUIDOR != null && !this.DISTRIBUIDORES_ID_DISTRIBUIDOR.isEmpty()) {
            sql.append("DISTRIBUIDORES_ID_DISTRIBUIDOR = ? ");
            campoActualizado = true;
        }

        
        if (sql.toString().endsWith(", ")) {
            sql.delete(sql.length() - 2, sql.length());
        }

        if (campoActualizado) {
            sql.append("WHERE COD_PRODUCTO = ?");
        } else {
            return false;  // Si no hay ningún campo para actualizar, retornar falso
        }

        try (Connection con = new Conexion().Conexion();
             PreparedStatement ps = con.prepareStatement(sql.toString())) {

            int index = 1;

            // Establecer los parámetros de actualización
            if (this.NOMBRE != null && !this.NOMBRE.isEmpty()) {
                ps.setString(index++, this.NOMBRE);
            }
            if (this.VALOR_UNITARIO_VENTA != null && !this.VALOR_UNITARIO_VENTA.isEmpty()) {
                ps.setString(index++, this.VALOR_UNITARIO_VENTA);
            }
            if (this.VALOR_UNITARIO_COMPRA != null && !this.VALOR_UNITARIO_COMPRA.isEmpty()) {
                ps.setString(index++, this.VALOR_UNITARIO_COMPRA);
            }
            if (this.DESCRIPCION != null && !this.DESCRIPCION.isEmpty()) {
                ps.setString(index++, this.DESCRIPCION);
            }
            if (this.CANTIDAD != null && !this.CANTIDAD.isEmpty()) {
                ps.setString(index++, this.CANTIDAD);
            }
            if (this.CATEGORIA_ID_CATEGORIA != null && !this.CATEGORIA_ID_CATEGORIA.isEmpty()) {
                ps.setString(index++, this.CATEGORIA_ID_CATEGORIA);
            }
            if (this.DISTRIBUIDORES_ID_DISTRIBUIDOR != null && !this.DISTRIBUIDORES_ID_DISTRIBUIDOR.isEmpty()) {
                ps.setString(index++, this.DISTRIBUIDORES_ID_DISTRIBUIDOR);
            }

            ps.setInt(index, this.COD_PRODUCTO);  // Establecer el ID del producto

            int resultado = ps.executeUpdate();
            return resultado > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para eliminar un producto por su ID
    public boolean eliminarProducto(int idProducto) {
        String sql = "DELETE FROM productos WHERE COD_PRODUCTO = ?";
        boolean eliminado = false;

        try (Connection con = new Conexion().Conexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idProducto);
            int resultado = ps.executeUpdate();
            eliminado = resultado > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return eliminado;
    }
}
