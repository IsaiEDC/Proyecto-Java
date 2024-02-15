package models;

import java.sql.Date;

public class Empleado {
    Long id;
    String nombre;
    String domicilio;
    String telefono;
    String email;
    Date fechanacimiento;
    Genero Genero;
    public Empleado(Long id, String nombre, String domicilio, String telefono, String email, Date fechanacimiento,
            models.Genero genero) {
        this.id = id;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.email = email;
        this.fechanacimiento = fechanacimiento;
        Genero = genero;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDomicilio() {
        return domicilio;
    }
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getFechanacimiento() {
        return fechanacimiento;
    }
    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }
    public Genero getGenero() {
        return Genero;
    }
    public void setGenero(Genero genero) {
        Genero = genero;
    }
}
