-- SCRIPT: ESTRUCTURA BASE DE DATOS Reto9
CREATE DATABASE IF NOT EXISTS reto9_db;
USE reto9_db;

CREATE TABLE IF NOT EXISTS categorias (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS empresas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    ubicacion VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS usuarios (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    nombre VARCHAR(100),
    apellidos VARCHAR(100),
    email VARCHAR(100),
    fecha_registro DATETIME,
    enabled INT DEFAULT 1,
    roles VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS vacante (
    id_vacante INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    descripcion TEXT,
    ubicacion VARCHAR(100),
    salario DOUBLE,
    estatus VARCHAR(20),
    fecha_publicacion DATE,
    empresa_id INT,
    categoria_id INT,
    FOREIGN KEY (empresa_id) REFERENCES empresas(id),
    FOREIGN KEY (categoria_id) REFERENCES categorias(id)
);

CREATE TABLE IF NOT EXISTS solicitud (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_username VARCHAR(50),
    vacante_id INT,
    comentario TEXT,
    fecha_solicitud DATETIME,
    estado INT DEFAULT 0,
    FOREIGN KEY (usuario_username) REFERENCES usuarios(username),
    FOREIGN KEY (vacante_id) REFERENCES vacante(id_vacante)
);
