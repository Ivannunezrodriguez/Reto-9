-- ESTRUCTURA DEFINITIVA ADAPTADA AL DER FINAL
CREATE DATABASE IF NOT EXISTS reto9_db;
USE reto9_db;

CREATE TABLE IF NOT EXISTS categorias (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT
);

CREATE TABLE IF NOT EXISTS empresas (
    id_empresa INT AUTO_INCREMENT PRIMARY KEY,
    razon_social VARCHAR(100) NOT NULL,
    direccion_fiscal VARCHAR(255),
    pais VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS usuarios (
    username VARCHAR(50) PRIMARY KEY,
    nombre VARCHAR(100),
    apellidos VARCHAR(100),
    email VARCHAR(100),
    password VARCHAR(255),
    enabled INT,
    fecha_registro DATE
);

CREATE TABLE IF NOT EXISTS perfiles (
    id_perfil INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS usuarioPerfil (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50),
    id_perfil INT,
    FOREIGN KEY (username) REFERENCES usuarios(username),
    FOREIGN KEY (id_perfil) REFERENCES perfiles(id_perfil)
);

CREATE TABLE IF NOT EXISTS vacantes (
    id_vacante INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    descripcion TEXT,
    ubicacion VARCHAR(100),
    salario DOUBLE,
    estatus VARCHAR(20),
    destacado TINYINT(1),
    fecha DATE,
    imagen VARCHAR(255),
    detalles TEXT,
    id_empresa INT,
    id_categoria INT,
    FOREIGN KEY (id_empresa) REFERENCES empresas(id_empresa),
    FOREIGN KEY (id_categoria) REFERENCES categorias(id_categoria)
);

CREATE TABLE IF NOT EXISTS solicitudes (
    id_solicitud INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE,
    archivo VARCHAR(255),
    comentarios TEXT,
    estado INT,
    id_vacante INT,
    username VARCHAR(50),
    FOREIGN KEY (id_vacante) REFERENCES vacantes(id_vacante),
    FOREIGN KEY (username) REFERENCES usuarios(username)
);
