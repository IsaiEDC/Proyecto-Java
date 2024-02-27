import java.util.List;

import db.conexion.ConexionDB;
import db.repositorys.GenerosRepository;
import models.Genero;

public class App {
    public static void main(String[] args) throws Exception {
        // ConexionDB.obtenerConnection();
        GenerosRepository generosRepository = new GenerosRepository();
        Genero g = generosRepository.recuperarId(2L);
        System.out.println(g.getNombre());
        g.
    }
}
