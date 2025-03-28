-- Base de datos
CREATE DATABASE IF NOT EXISTS reto9db;
USE reto9db;

-- Tabla de usuarios
CREATE TABLE usuarios (
    username VARCHAR(50) PRIMARY KEY,
    nombre VARCHAR(50),
    apellidos VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(255),
    enabled BOOLEAN DEFAULT TRUE,
    fecha_registro DATE,
    roles VARCHAR(20) -- "ADMIN", "USUARIO"
);

-- Tabla de empresas
CREATE TABLE empresas (
    id_empresa INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    descripcion TEXT,
    direccion VARCHAR(255),
    email VARCHAR(100),
    telefono VARCHAR(20)
);

-- Tabla de categorías
CREATE TABLE categorias (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100)
);

-- Tabla de vacantes
CREATE TABLE vacantes (
    id_vacante INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100),
    descripcion TEXT,
    requisitos TEXT,
    ubicacion VARCHAR(100),
    estatus ENUM('CREADA', 'ASIGNADA', 'CANCELADA') DEFAULT 'CREADA',
    id_empresa INT,
    id_categoria INT,
    FOREIGN KEY (id_empresa) REFERENCES empresas(id_empresa),
    FOREIGN KEY (id_categoria) REFERENCES categorias(id_categoria)
);

-- Tabla de solicitudes
CREATE TABLE solicitudes (
    id_solicitud INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50),
    id_vacante INT,
    fecha_solicitud DATE,
    estado INT DEFAULT 0, -- 0: pendiente, 1: adjudicada, 2: cancelada
    FOREIGN KEY (username) REFERENCES usuarios(username),
    FOREIGN KEY (id_vacante) REFERENCES vacantes(id_vacante)
);
