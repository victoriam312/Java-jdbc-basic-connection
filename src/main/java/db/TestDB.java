package db;

import db.MySQL;
import db.MySQL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDB {
    
    public static void main(String[] args){
        
        System.out.println("Intentando conectar a la BBDD 'hoteles...");
        
        //Usamos "try-with-resources", es la versión moderna del "finally"
        //que se explica en el PDF para cerrar conexiones
        
        try (Connection miConexion = MySQL.getConnection()){
            
            System.out.println("¡Conexión OK! Creando consulta...");
            
            //Crear sentencia 
            Statement miStatement = miConexion.createStatement();
            
            //Ejecutar consulta
            //Vamos a hacer una consulta sencilla a la tabla 'hotel'
            String sql = "SELECT id_hotel, nombre FROM hotel";
            ResultSet rs = miStatement.executeQuery(sql);
            
            System.out.println("---HOTELES ENCONTRADOS ----");
            
            //Recorrer resultados
            //El bucle 'while(rs.next())'
            while (rs.next()){
                int id = rs.getInt("id_hotel");
                String nombre = rs.getString("nombre");
                System.out.println(" > ID: " + id + ", Nombre: " + nombre );
            }
            System.out.println("----------------");
        } catch (SQLException e){
            //Esto salta si la URL, User o Pass están mal
            System.err.println("¡ERROR! No se pudo conectar o consultar");
            e.printStackTrace();
        }
        
    }
}
