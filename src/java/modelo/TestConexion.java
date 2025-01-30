package modelo;

import java.util.List;

public class TestConexion {
    public static void main(String[] args) {
        // Probar la conexión
        Conexion conexion = new Conexion();
        if (conexion.Conexion() != null) {
            System.out.println("Conexión exitosa a la base de datos.");
        } else {
            System.out.println("Error al conectar con la base de datos.");
            return; // Detener ejecución si no hay conexión
        }

        // Probar el método obtenerCategorias()
        List<Categoria> categorias = Categoria.obtenerCategorias();
        if (categorias.isEmpty()) {
            System.out.println("No se encontraron categorías.");
        } else {
            System.out.println("Categorías encontradas:");
            for (Categoria categoria : categorias) {
                System.out.println("ID: " + categoria.getIdCategoria() + ", Nombre: " + categoria.getNombreCategoria());
            }
        }
    }
}


