<div align="center">
  <img src="./src/main/resources/img/badge-forohub.png" alt="Logo" height="100">
  <h2>
    🌐 Foro Hub - Backend Challenge
  </h2>
</div>

# 🌐 ForoHub - Backend Challenge

## 📚 Índice
1. [📖 Descripción](#-descripción)
2. [🌍 Deployment](#-deployment)
3. [🔑 Credenciales de Acceso](#-credenciales-de-acceso)
4. [⚙️ Tecnologías utilizadas](#️-tecnologías-utilizadas)
5. [🔒 Seguridad](#-seguridad)
6. [🛠️ Requisitos previos (para ejecución local)](#️-requisitos-previos-para-ejecución-local)
7. [📥 Instalación y Ejecución Local](#-instalación-y-ejecución-local)

---

## 📖 Descripción
**ForoHub** es un proyecto de Backend desarrollado con Java y Spring Boot como parte del **Backend Challenge** en la formación de Desarrollador Backend de Alura Latam con Oracle. Este proyecto ofrece una API REST con operaciones CRUD (CREATE, READ, UPDATE, DELETE) para gestionar foros de discusión. La seguridad de la aplicación está gestionada utilizando **Spring Security** y **JWT (JSON Web Tokens)**.

---

## 🌍 Deployment
La aplicación ha sido desplegada en **Render** y la base de datos se encuentra alojada en **Railway**.

🔗 **API Base URL:**  
[https://foro-hub.onrender.com](https://foro-hub.onrender.com)

🔗 **Documentación Swagger:**  
[https://foro-hub.onrender.com/swagger-ui/index.html](https://foro-hub.onrender.com/swagger-ui/index.html)

> [!WARNING]
> 
> La API requiere autenticación mediante **JWT** para la mayoría de sus endpoints.
> - Si intentas acceder a la URL en un **navegador**, es probable que no veas nada porque los endpoints protegidos requieren un token válido.
> - Para probar la API correctamente, usa **Postman** o herramientas similares.

> [!TIP]
> - **Puedes obtener un token usando las credenciales predeterminadas** (ver siguiente sección).
> - **También puedes hacer un `POST` a `auth/singup`** y crear un nuevo usuario para posteriormente iniciar sesión con esos datos

---

## 🔑 Credenciales de Acceso
Para realizar pruebas en **Postman** u otra herramienta de API, puedes usar estas credenciales predeterminadas para obtener un token JWT:

- **Email**: `admin@gmail.com`
- **Contraseña**: `admin1234`

1. **Hacer una solicitud `POST` a `/auth/login` con las credenciales anteriores.**
2. **Copiar el token JWT devuelto en la respuesta.**
3. **Usarlo en las siguientes solicitudes dentro del `Authorization Header` en formato `Bearer <TOKEN>`.**

---

## ⚙️ Tecnologías utilizadas
[![Tecnologias](https://skillicons.dev/icons?i=java,spring,mysql,maven,idea,git)](https://skillicons.dev)

- **Java 17** o superior
- **Spring Boot 3.x**
- **Spring Security** (Autenticación y Autorización)
- **Spring Data JPA** (Gestión de base de datos)
- **JWT (Java JWT)** (Tokens de seguridad)
- **Flyway** (Migraciones de base de datos)
- **MySQL** (Base de datos relacional)
- **Springdoc OpenAPI** (Documentación de API con Swagger)

---

## 🔒 Seguridad
La aplicación incluye autenticación y autorización utilizando:
- **Spring Security**
- **JWT**: para proteger los endpoints
- **BCrypt**: para el cifrado de contraseñas

---

## 🛠️ Requisitos previos (para ejecución local)
- **JDK 17** o superior instalado en el sistema.
- **Spring Boot** configurado en tu entorno de desarrollo.
- **MySQL** instalado y en ejecución.
- Un IDE compatible con Java, como Visual Studio Code o IntelliJ IDEA.

---

## 📥 Instalación y Ejecución Local
1. **Descarga el proyecto**:
    ```bash
    git clone https://github.com/EmiJordan11/ForoHub.git
    ```
2. **Configurar la base de datos**:
   - Asegúrate de tener MySQL instalado y en ejecución.
   - Crea un **SCHEMA** para la base de datos (las tablas se generan automáticamente con las migraciones).

3. **Configura las credenciales** en el archivo `application.properties`.

4. **Ejecuta la aplicación** desde el archivo principal del proyecto.

---

🚀 **¡Ahora puedes probar la API en Render y consultar su documentación en Swagger!**

