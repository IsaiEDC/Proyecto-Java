DROP DATABASE IF EXISTS base_de_datos;
CREATE DATABASE  base_de_datos;
USE base_de_datos;

CREATE TABLE login (
id int auto_increment primary key,
nombre varchar (100),
email varchar (100),
usuario varchar (100),
contraseña varchar (100)
);

CREATE TABLE generos (
id_genero int auto_increment primary key,
nombre varchar (20)
);

CREATE TABLE empleados (
id_empleado int auto_increment primary key,
nombre varchar (100),
domicilio varchar (100),
telefono varchar (12),
email varchar (100),
fecha_de_nacimiento date,
id_genero int,
CONSTRAINT id_genero
FOREIGN KEY (id_genero)
REFERENCES generos(id_genero)
);