package db.repositorys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import db.conexion.ConexionDB;
import interfaces.RepositoryInterfaces;
import models.Genero;

public class GenerosRepository implements RepositoryInterfaces<Genero> {
    @Override
    public Genero recuperarId(Long id) {
        try (Connection connection = ConexionDB.obtenerConnection()) {

            String q = "SELECT * FROM  generos WHERE id = ?";
            try (
                    PreparedStatement preparedStatement = connection.prepareStatement(q)) {
                preparedStatement.setLong(1, id);
                return dameEntidadResultSet(preparedStatement.executeQuery());

            } catch (Exception e) {
                System.out.println("Error en  la consulta");
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos");
        }
        return null;
    }

    @Override
    public List<Genero> recuperarTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'recuperarTodos'");
    }

    @Override
    public void agregar(Genero entidad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'agregar'");
    }

    @Override
    public void modificar(Genero entidad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificar'");
    }

    @Override
    public void eliminar(Genero entidad) {

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

    private Genero dameEntidadResultSet(ResultSet resultSet) {
        Long id = 0L;
        String nombre = "";
        try {
            while (resultSet.next()) {
                id = resultSet.getLong("id");
                nombre = resultSet.getString("nombre");
            }
            return new Genero(id, nombre);

        } catch (Exception e) {
            System.out.println("Error al recuperar resulSet");
        }
        return null;
    }
}