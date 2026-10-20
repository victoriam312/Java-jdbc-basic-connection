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
    
    
    
    private static final String KEY_URL = "DB_URL";
    private static final String KEY_USER = "DB_USER";
    private static final String KEY_PASS = "DB_PASS";
    
    private static final String URL = pick(System.getProperty (KEY_URL), System.getenv(KEY_URL), DEFAULT_URL);

    //Usuario y contraseña NO van en el código: se pasan como variables de
    //entorno (DB_USER, DB_PASSWORD) o propiedades -DDB_USER=... -DDB_PASSWORD=...
    private static final String USER = pick(System.getProperty(KEY_USER), System.getenv(KEY_USER), "");
    private static final String PASS = pick(System.getProperty(KEY_PASS), System.getenv(KEY_PASS), "");

    //Devuelve el primer valor que no esté vacío
    private static String pick(String... valores){
        for (String v : valores){
            if (v != null && !v.isEmpty()){
                return v;
            }
        }
        return null;
    }
    
    
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
