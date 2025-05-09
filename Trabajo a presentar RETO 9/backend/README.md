# Reto-9
 Proyecto grupal 
📌 Descripción
Reto9 es una API RESTful desarrollada en Java con Spring Boot para la gestión de vacantes de empleo, empresas, usuarios y solicitudes. Incluye autenticación basada en JWT, control de roles (ADMIN y USUARIO) y panel de administración completo.

🚀 Tecnologías
Java 17+

Spring Boot

Spring Security + JWT

Spring Data JPA

MySQL

Lombok

Maven

🔐 Autenticación y Seguridad
Autenticación con JWT.

Roles: ADMIN, USUARIO.

Filtro de seguridad personalizado (JwtAuthenticationFilter).

Codificación de contraseñas con BCrypt.

Acceso CORS configurado.

🧠 Roles y Funcionalidades
👤 Usuario (USUARIO)
Registro/Login

Buscar vacantes públicas (CREADA)

Postularse a vacantes

Ver sus solicitudes

Cancelar solicitud si no ha sido adjudicada

🏢 Empresa
Crear, editar y cancelar vacantes (estado: CREADA, CANCELADA, ASIGNADA)

Ver solicitudes recibidas por vacante

Asignar una vacante a una solicitud (y marcarla adjudicada)

🛠️ Administrador (ADMIN)
CRUD de usuarios, empresas y categorías

Dar de baja usuarios (enabled = 0)

Crear nuevos administradores (registro con rol ADMIN)