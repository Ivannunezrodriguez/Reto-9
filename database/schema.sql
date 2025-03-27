
-- Tabla: Empresas
CREATE TABLE Empresas (
    id_empresa INT PRIMARY KEY AUTO_INCREMENT,
    razon_social VARCHAR(45),
    nombre_fiscal VARCHAR(45),
    pais VARCHAR(45)
);

-- Tabla: Categorias
CREATE TABLE Categorias (
    id_categoria INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    descripcion VARCHAR(2000)
);

-- Tabla: Vacantes
CREATE TABLE Vacantes (
    id_vacante INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(200),
    descripcion TEXT,
    fecha DATE,
    salario DOUBLE,
    estatus ENUM('CREADA', 'CANCELADA', 'ASIGNADA'),
    destacado TINYINT,
    imagen_vacante VARCHAR(250),
    detalles TEXT,
    id_categoria INT,
    id_empresa INT,
    FOREIGN KEY (id_categoria) REFERENCES Categorias(id_categoria),
    FOREIGN KEY (id_empresa) REFERENCES Empresas(id_empresa)
);

-- Tabla: Usuarios
CREATE TABLE Usuarios (
    username VARCHAR(45) PRIMARY KEY,
    nombre VARCHAR(100),
    apellidos VARCHAR(100),
    email VARCHAR(100),
    password VARCHAR(100),
    enabled TINYINT,
    fecha_registro DATE
);

-- Tabla: Perfiles
CREATE TABLE Perfiles (
    id_perfil INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100)
);

-- Tabla: UsuarioPerfil
CREATE TABLE UsuarioPerfil (
    username VARCHAR(45),
    id_perfil INT,
    PRIMARY KEY (username, id_perfil),
    FOREIGN KEY (username) REFERENCES Usuarios(username),
    FOREIGN KEY (id_perfil) REFERENCES Perfiles(id_perfil)
);

-- Tabla: Solicitudes
CREATE TABLE Solicitudes (
    id_solicitud INT PRIMARY KEY AUTO_INCREMENT,
    fecha DATE,
    archivo VARCHAR(250),
    comentarios VARCHAR(2000),
    estado TINYINT,
    id_vacante INT,
    username VARCHAR(45),
    FOREIGN KEY (id_vacante) REFERENCES Vacantes(id_vacante),
    FOREIGN KEY (username) REFERENCES Usuarios(username)
);
