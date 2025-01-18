<div align="center">
  <img src="./src/main/resources/img/badge-forohub.png" alt="Logo" height="100">
  <h2>
    🌐 Foro Hub - Backend Challenge
  </h2>
</div> 

[//]: # (# 🌐 ForoHub - Backend Challenge)
## 📖 Descripción
**ForoHub** es un proyecto de Backend desarrollado con Java y Spring Boot como parte **Backend Challenge** en la formación de Desarrollador Backend de Alura Latam con Oracle. Este proyecto ofrece una API REST con operaciones CRUD (CREATE, READ, UPDATE, DELETE) para gestionar foros de discusión. La seguridad de la aplicación está gestionada utilizando Spring Security y JWT (JSON Web Tokens).

## ⚙️ Tecnologías utilizadas
[![Tecnologias](https://skillicons.dev/icons?i=java,spring,mysql,maven,idea,git)](https://skillicons.dev)
- **Java 17** o superior
- **Spring Boot 3.x**
- **Spring Security** (Autenticación y Autorización)
- **Spring Data JPA** (Gestión de base de datos)
- **JWT (Java JWT)** (Tokens de seguridad)
- **Flyway** (Migraciones de base de datos)
- **MySQL** (Base de datos relacional)
- **Springdoc OpenAPI** (Documentación de API)

## 🔒 Seguridad
La aplicación incluye autenticación y autorización utilizando:
- **Spring Security**
- **JWT**: para proteger los endpoints
- **BCrypt**: para el cifrado de contraseñas

## 🛠️ Requisitos previos
- **JDK 17** o superior instalado en el sistema.
- **Spring Boot** configurado en tu entorno de desarrollo.
- **MySQL**
- Un IDE compatible con Java, como Visual Studio Code o IntelliJ IDEA.

## 🔑 Inicialización Automática de Datos
Una de las migraciones de **Flyway** (específicamente la **V4**) crea credenciales de usuario predeterminadas. Estas credenciales permiten realizar el login y obtener un token necesario para acceder a los endpoints protegidos.

### Credenciales predeterminadas:
- **Email**: `admin@gmail.com`
- **Contrasena**: `admin1234`

## 📥 Instalación
1. **Descarga el archivo**: Desde la opción Code > Download ZIP, o puedes clonarlo para tenerlo de forma local:
    ```bash
    https://github.com/EmiJordan11/ForoHub.git

2. **Configurar la base de datos**: Asegúrate de tener MySQL instalado y en ejecución. Crea una base de datos para el proyecto, solo el SCHEMA, el programa generará las tablas necesarias a través de las migraciones.

3. **Configura las credenciales** de acceso en el archivo `application.properties`

4. **Ejecuta la aplicación** desde el archivo principal del proyecto.