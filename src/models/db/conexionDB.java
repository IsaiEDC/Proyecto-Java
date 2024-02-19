
import java.sql.Connection;
import java.sql.DriverManager;

public class conexionDB {
    private static Connection conexion;
    private static String user = "root";
    private static String pwd = "root";
    private static String db = "base de datos";
    private static int port = 3306;
    private static String url = "jdbc:mysql://localhost:" + port + "/" + db;

    private void ConexionDB() {
        
    }

    public static Connection obtenerConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, user, pwd);
            return conexion;
        } catch (Exception ex) {
            System.out.println("Error al conectar la base de datos");
        }
        return null;
    }

    public static void cerrarConexion(Connection conexion) {
        try {
            if (conexion == null || conexion.isClosed())
                return;
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexión");
        }
    }
}