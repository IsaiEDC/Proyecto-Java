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
        g.setNombre("MASCULINO");
        generosRepository.modificar(g);
        List<Genero> generos = generosRepository.recuperarTodos();
        for (Genero genero : generos) {
            System.out.println(genero.getNombre());
        }

    }
}
