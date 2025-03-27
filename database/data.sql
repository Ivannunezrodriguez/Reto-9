
-- Inserción de datos iniciales para pruebas

-- Empresas
INSERT INTO Empresas (razon_social, nombre_fiscal, pais) VALUES
('Tech Solutions', 'Tech Solutions S.A.', 'España'),
('Global Corp', 'Global Corporation Ltd.', 'México');

-- Categorias
INSERT INTO Categorias (nombre, descripcion) VALUES
('Desarrollo', 'Puestos relacionados con desarrollo de software'),
('Marketing', 'Puestos relacionados con publicidad y marketing');

-- Perfiles
INSERT INTO Perfiles (nombre) VALUES
('USUARIO'), ('ADMIN');

-- Usuarios
INSERT INTO Usuarios (username, nombre, apellidos, email, password, enabled, fecha_registro) VALUES
('jdoe', 'John', 'Doe', 'jdoe@example.com', '1234', 1, CURDATE()),
('admin', 'Admin', 'User', 'admin@example.com', 'admin', 1, CURDATE());

-- UsuarioPerfil
INSERT INTO UsuarioPerfil (username, id_perfil) VALUES
('jdoe', 1),
('admin', 2);

-- Vacantes
INSERT INTO Vacantes (nombre, descripcion, fecha, salario, estatus, destacado, imagen_vacante, detalles, id_categoria, id_empresa) VALUES
('Programador Java', 'Desarrollo de aplicaciones backend en Java', CURDATE(), 28000, 'CREADA', 1, 'img/java.png', 'Se requiere experiencia en Spring Boot', 1, 1),
('Especialista SEO', 'Optimización de motores de búsqueda', CURDATE(), 24000, 'CREADA', 0, 'img/seo.png', 'Se valorará conocimiento en Google Analytics', 2, 2);

-- Solicitudes
INSERT INTO Solicitudes (fecha, archivo, comentarios, estado, id_vacante, username) VALUES
(CURDATE(), 'cv_jdoe.pdf', 'Estoy interesado en esta vacante.', 0, 1, 'jdoe');
