import db.conexion.ConexionDB;

public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("HOLA MUNDO NO funciona nada de lo que estoy haciendo ya me desespere llevo 3 horas y nomas no avanzo nada");
        ConexionDB.obtenerConnection();
    }
}