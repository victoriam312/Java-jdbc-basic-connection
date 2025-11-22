package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


//Esta clase se encarga de TODO lo relacionado con la conexión
public final class MySQL {
    
    //PASO 1 --> definir parámetros (PDF tema 4 = Código 1 y Código 2)
    
    //Esta es la URL de conexión. Conecta a la BBDD "hoteles"
    private static final String DEFAULT_URL = "\"jdbc:mysql://localhost:3306/hoteles\"\n" +
                                      "+ \"?useSSL=false\"\n" +
                                      "+ \"&serverTimezone=Europe/Madrid\"";
    
    //Tu usuario de MySQL
    private static final String USER = "root";
    
    //Tu contraseña ROOT
    private static final String PASS = "Malagacf.25";
    
    private static final String KEY_URL = "DB_URL";
    private static final String KEY_USER = "DB_USER";
    private static final String KEY_PASS = "DB_PASS";
    
    private static final String URL = pick(System.getProperty (KEY_URL), System.getenv(KEY_URL), DEFAULT_URL);
    
    
    //PASO 2 --> REGISTRAR EL DRIVER (Código 3 en el PDF)
    static{
        try{
            //Le decimos a Java: "Oye, carga esta clase de la librería .jar"
            new com.mysql.cj.jdbc.Driver();
        }catch (SQLException e){
            //Esto salta si no encuentra el .jar (el pom.xml está mal)    
            System.out.println("Error: No se encontró el driver JDBC de MySQL");
            throw new RuntimeException("Error cargando el driver", e);    
        }   
    }
    
    //PASO 3 --> OBTENER CONEXCIÓN
    //Devuelve una conexión abierta a la base de datos "hoteles"
    public static Connection getConnection() throws SQLException{
        //Esta es la línea que abre la conexión
        return DriverManager.getConnection(URL, USER, PASS);
    }
    
   
}
