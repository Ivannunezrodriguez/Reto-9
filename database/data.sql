-- Usuarios
INSERT INTO usuarios (username, nombre, apellidos, email, password, enabled, fecha_registro, roles)
VALUES 
('admin', 'Admin', 'User', 'admin@example.com', '$2a$10$EmmQ22QvIYocA/Q.NWQZHewrRDzuAvt1faGMou58bBIHfbWpoNN8i', 1, CURDATE(), 'ADMIN'),
('jdoe', 'John', 'Doe', 'jdoe@example.com', '$2a$10$4Vp2OzRIg9vbOtjViFHZsOKxUyaZjjyPOZnI2VQAYE7WTOjOZJ8Cu', 1, CURDATE(), 'USUARIO');

-- Empresas
INSERT INTO empresa (nombre, descripcion, ubicacion)
VALUES 
('TechCorp', 'Empresa de tecnología e innovación', 'Calle Falsa 123, Madrid');

-- Categorías
INSERT INTO categoria (nombre)
VALUES ('Informática'), ('Marketing'), ('Logística');

-- Vacantes
INSERT INTO vacante (nombre, descripcion, ubicacion, estatus, fecha_publicacion, salario, empresa_id, categoria_id)
VALUES 
('Desarrollador Java', 'Desarrollo backend con Spring Boot', 'Madrid', 'ACTIVA', CURDATE(), 30000.00, 1, 1),
('Community Manager', 'Gestión de redes sociales', 'Barcelona', 'ACTIVA', CURDATE(), 22000.00, 1, 2);

-- Solicitudes
INSERT INTO solicitud (usuario_username, vacante_id_vacante, fecha_solicitud, comentario)
VALUES 
('jdoe', 1, CURDATE(), 'Estoy muy interesado en esta vacante');
