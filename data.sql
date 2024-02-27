DROP DATABASE IF EXISTS empleados;
CREATE DATABASE  empleados;
USE empleados;

CREATE TABLE login (
id int auto_increment primary key,
nombre varchar (100),
email varchar (100),
usuario varchar (100),
contraseña varchar (100)
);

CREATE TABLE generos (
id int auto_increment primary key,
nombre varchar (20)
);

CREATE TABLE empleados (
id int auto_increment primary key,
nombre varchar (100),
domicilio varchar (100),
telefono varchar (12),
email varchar (100),
fecha_de_nacimiento date,
id_genero int,
CONSTRAINT empleado_id_genero_generos_id_genero
FOREIGN KEY (id_genero)
REFERENCES generos(id)
);


INSERT INTO generos VALUES
(1, "FEMENINO"),
(2, "MASCULINO"),
(3, NULL)


-- quiubo x2