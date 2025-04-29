Descripción
Este módulo corresponde al Frontend para empresas y administradores dentro del proyecto Sistema de Gestión de Vacantes de Empleo.
La aplicación ha sido desarrollada en JavaFX utilizando el lenguaje de programación Java. Permite gestionar vacantes de empleo, usuarios, empresas y categorías mediante una interfaz gráfica clara e intuitiva.

Tecnologías utilizadas
Java 17

JavaFX (FXML y controladores)

CSS para la definición de estilos

Maven para la gestión de dependencias

Funcionalidades principales
El frontend está orientado a dos perfiles de usuario:

Empresas:

Publicar nuevas vacantes.

Modificar o cancelar vacantes existentes.

Consultar las solicitudes de los candidatos.

Administradores:

Gestionar usuarios, empresas y categorías de vacantes.

Crear, actualizar y eliminar administradores.

Controlar el estado de las vacantes (CREADA, ASIGNADA, CANCELADA).

Organización del proyecto
El proyecto sigue una estructura modular que separa la lógica de controladores, modelos de datos y vistas:

Los controladores gestionan la interacción entre la vista y el modelo.

Los modelos representan las entidades del sistema como Vacante, Usuario, Empresa y Categoría.

Las vistas están definidas mediante archivos FXML y estilizadas con CSS.

La aplicación está preparada para integrarse con un backend mediante consumo de API RESTful.

Ejecución de la aplicación
Para ejecutar la aplicación localmente es necesario tener instalado Java 17 y Maven.
Desde la raíz del proyecto, se puede compilar y ejecutar con los siguientes comandos:

arduino
Copiar
Editar
mvn clean install
mvn javafx:run
También es posible ejecutar directamente la clase principal App.java desde un entorno de desarrollo como IntelliJ IDEA o Eclipse.

Conexión con el Backend
La aplicación está diseñada para consumir servicios desde un backend Spring Boot, que debe estar disponible en:

bash
Copiar
Editar
http://localhost:8080/api/v1/
Actualmente, la aplicación está estructurada y lista para establecer dicha conexión una vez se encuentren disponibles los servicios y métodos de autenticación requeridos.

Autor
Nombre: Andrés Felipe González
Rol en el proyecto: Desarrollo del Frontend para Empresas y Administradores