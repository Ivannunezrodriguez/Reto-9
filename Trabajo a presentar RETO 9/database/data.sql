
-- Perfiles
INSERT INTO perfiles (nombre) VALUES
('ADMIN'),
('EMPRESA'),
('USUARIO');
-- Categorías
INSERT INTO categorias (nombre, descripcion) VALUES ('Desarrollo', 'Quibusdam id repudiandae optio placeat harum.');
INSERT INTO categorias (nombre, descripcion) VALUES ('Diseño', 'Sit modi eaque saepe sapiente.');
INSERT INTO categorias (nombre, descripcion) VALUES ('Ventas', 'Nemo fugit dolores. Non aut laudantium mollitia.');
INSERT INTO categorias (nombre, descripcion) VALUES ('Administración', 'Facere cupiditate assumenda aut eveniet.');
INSERT INTO categorias (nombre, descripcion) VALUES ('Atención al cliente', 'Suscipit molestiae temporibus aspernatur ea nam.');
-- Empresas
INSERT INTO empresas (razon_social, direccion_fiscal, pais) VALUES (
    'Mancebo-Duran',
    'Camino de Mario Doménech 57
Salamanca, 51280',
    'Italia'
);
INSERT INTO empresas (razon_social, direccion_fiscal, pais) VALUES (
    'Bauzà LLC',
    'Urbanización de Arturo Hoz 70
Teruel, 77030',
    'Kenya'
);
INSERT INTO empresas (razon_social, direccion_fiscal, pais) VALUES (
    'Montaña-Cardona',
    'Via Javier Gual 655
Lugo, 25430',
    'Argelia'
);
-- Usuarios
INSERT INTO usuarios (username, nombre, apellidos, email, password, enabled, fecha_registro)
VALUES ('user1', 'Berto', 'Maza', 'sandaliosevillano@mari.es', '$2a$10$g3n3r4d0C0ntr4', 1, '2025-02-28');
INSERT INTO usuarios (username, nombre, apellidos, email, password, enabled, fecha_registro)
VALUES ('user2', 'Augusto', 'Blanco', 'emiliana61@arjona-caceres.es', '$2a$10$g3n3r4d0C0ntr4', 1, '2025-03-10');
INSERT INTO usuarios (username, nombre, apellidos, email, password, enabled, fecha_registro)
VALUES ('user3', 'Flavio', 'Gordillo', 'simon36@gmail.com', '$2a$10$g3n3r4d0C0ntr4', 1, '2025-01-21');
INSERT INTO usuarios (username, nombre, apellidos, email, password, enabled, fecha_registro)
VALUES ('user4', 'Apolinar', 'Rodríguez', 'poncio38@gmail.com', '$2a$10$g3n3r4d0C0ntr4', 1, '2025-01-01');
INSERT INTO usuarios (username, nombre, apellidos, email, password, enabled, fecha_registro)
VALUES ('user5', 'Florencia', 'Manso', 'cirinorivera@bastida.es', '$2a$10$g3n3r4d0C0ntr4', 1, '2025-03-27');
-- UsuarioPerfil
INSERT INTO usuarioPerfil (username, id_perfil) VALUES ('user1', 3);
INSERT INTO usuarioPerfil (username, id_perfil) VALUES ('user2', 3);
INSERT INTO usuarioPerfil (username, id_perfil) VALUES ('user3', 3);
INSERT INTO usuarioPerfil (username, id_perfil) VALUES ('user4', 3);
INSERT INTO usuarioPerfil (username, id_perfil) VALUES ('user5', 3);
-- Vacantes
INSERT INTO vacantes (nombre, descripcion, ubicacion, salario, estatus, fecha, imagen, detalles, id_empresa, id_categoria)
VALUES (
    'Media planner', 'Nisi incidunt ipsum. Enim accusamus quidem ipsum expedita eveniet autem.', 'Córdoba',
    31211, 'CREADA', '2025-03-24',
    'https://placeimg.com/73/195/any', 'Dolor eius placeat porro autem minima rem quis.',
    3, 1
);
INSERT INTO vacantes (nombre, descripcion, ubicacion, salario, estatus, fecha, imagen, detalles, id_empresa, id_categoria)
VALUES (
    'Best boy', 'Voluptatibus maxime commodi totam magnam. Hic fugit optio expedita asperiores.', 'Ourense',
    23088, 'CREADA', '2025-01-13',
    'https://www.lorempixel.com/838/945', 'Distinctio iste nisi dignissimos. Corrupti expedita nisi a.',
    3, 4
);
INSERT INTO vacantes (nombre, descripcion, ubicacion, salario, estatus, fecha, imagen, detalles, id_empresa, id_categoria)
VALUES (
    'Scientist, research (life sciences)', 'Omnis consequatur libero ut architecto. Atque quis aut.', 'Granada',
    28059, 'CREADA', '2025-01-24',
    'https://www.lorempixel.com/655/242', 'Deserunt modi debitis sapiente.',
    1, 4
);
INSERT INTO vacantes (nombre, descripcion, ubicacion, salario, estatus, fecha, imagen, detalles, id_empresa, id_categoria)
VALUES (
    'Accountant, chartered certified', 'Suscipit magni hic nihil nulla. Animi dolorum doloremque mollitia alias impedit.', 'Asturias',
    31899, 'CREADA', '2025-02-07',
    'https://placeimg.com/379/275/any', 'Doloremque ipsam aperiam esse animi.',
    1, 2
);
INSERT INTO vacantes (nombre, descripcion, ubicacion, salario, estatus, fecha, imagen, detalles, id_empresa, id_categoria)
VALUES (
    'Copy', 'Veniam adipisci incidunt sapiente nobis. Eius id dignissimos assumenda eum.', 'Salamanca',
    35434, 'CREADA', '2025-02-06',
    'https://dummyimage.com/453x46', 'Dicta minima illum nihil doloribus perspiciatis.',
    2, 3
);
INSERT INTO vacantes (nombre, descripcion, ubicacion, salario, estatus, fecha, imagen, detalles, id_empresa, id_categoria)
VALUES (
    'Sports coach', 'Assumenda repudiandae consequatur nobis. Dolorum hic enim illum est excepturi.', 'Guipúzcoa',
    32313, 'CREADA', '2025-03-30',
    'https://dummyimage.com/770x209', 'Dolor laborum totam iure.',
    2, 2
);
-- Solicitudes
INSERT INTO solicitudes (fecha, archivo, comentarios, estado, id_vacante, username)
VALUES ('2025-01-23', 'user1_cv.pdf', 'Accusamus at nihil ipsam.', 0, 3, 'user1');
INSERT INTO solicitudes (fecha, archivo, comentarios, estado, id_vacante, username)
VALUES ('2025-01-29', 'user3_cv.pdf', 'Error corporis unde cumque.', 0, 3, 'user3');
INSERT INTO solicitudes (fecha, archivo, comentarios, estado, id_vacante, username)
VALUES ('2025-01-15', 'user1_cv.pdf', 'Ex laudantium reiciendis eum quasi laboriosam cum.', 1, 6, 'user1');
INSERT INTO solicitudes (fecha, archivo, comentarios, estado, id_vacante, username)
VALUES ('2025-01-06', 'user3_cv.pdf', 'Ipsam similique in repudiandae ad ratione.', 1, 4, 'user3');
INSERT INTO solicitudes (fecha, archivo, comentarios, estado, id_vacante, username)
VALUES ('2025-03-21', 'user5_cv.pdf', 'Consequatur ipsum neque voluptatibus.', 1, 6, 'user5');
INSERT INTO solicitudes (fecha, archivo, comentarios, estado, id_vacante, username)
VALUES ('2025-01-25', 'user2_cv.pdf', 'Assumenda ipsa maxime vel nemo laboriosam.', 0, 5, 'user2');
INSERT INTO solicitudes (fecha, archivo, comentarios, estado, id_vacante, username)
VALUES ('2025-03-13', 'user4_cv.pdf', 'Libero voluptas nesciunt ad illum.', 1, 6, 'user4');
INSERT INTO solicitudes (fecha, archivo, comentarios, estado, id_vacante, username)
VALUES ('2025-02-01', 'user1_cv.pdf', 'Natus id earum vero numquam.', 0, 4, 'user1');
