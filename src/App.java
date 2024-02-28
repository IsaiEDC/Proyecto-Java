import java.util.List;

import db.repositorys.EmpleadosRepository;
import db.repositorys.GenerosRepository;
import models.Empleado;
import models.Genero;

public class App {
    public static void main(String[] args) throws Exception {
        GenerosRepository generosRepository = new GenerosRepository();
        EmpleadosRepository empleadosRepository = new EmpleadosRepository();
        Empleado e = empleadosRepository.recuperarId(1L);
        System.out.println(e.getNombre());
        /*List<Genero> generos = generosRepository.recuperarTodos();
        for (Genero genero : generos) {
            System.out.println(genero.getNombre());
        } */
    }
}
