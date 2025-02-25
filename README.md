# Documentación del Proyecto: API de Notas

## 1. Descripción
Este proyecto es una API REST desarrollada en Java con Spring Boot. La aplicación permite gestionar notas (crear, consultar, actualizar y eliminar). Se implementaron **variables de entorno** para la configuración de la base de datos, mejorando la seguridad y flexibilidad de despliegue.

## 2. Tecnologías Utilizadas
- **Java**: Lenguaje principal.
- **Spring Boot**: Framework para servicios REST.
- **Spring Data JPA**: Interacción con bases de datos.
- **PostgreSQL**: Sistema de gestión de bases de datos.
- **Lombok**: Reduce código repetitivo (getters/setters).
- **Spring Boot DevTools**: Recarga automática en desarrollo.
- **Spring Boot Starter Validation**: Validación de datos.
- **Spring Boot Starter Test**: Pruebas unitarias/integración.

## 3. Configuración de la Base de Datos
### Variables de Entorno
Configura estas variables en tu entorno:
```bash
export DB_URL=jdbc:postgresql://localhost:5432/notes_db
export DB_USERNAME=tu_usuario
export DB_PASSWORD=tu_contraseña
```
### Parte 1: Configuración de la Base de Datos

#### 3.1 Variables de Entorno

```bash
export DB_URL=jdbc:postgresql://localhost:5432/notes_db
export DB_USERNAME=tu_usuario
export DB_PASSWORD=tu_contraseña
```

#### 3.2 Configuración en `application.properties`

```bash
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update` 
```

### Parte 2: Endpoints de la API

#### 4.1 Crear una Nota

-   **Método:** `POST`
    
-   **URL:** `http://localhost:8080/api/notes`
    
-   **Headers:** `Content-Type: application/json`
    
-   **Request Body:**
  ```bash
    {
        "body": "Contenido de la nota 5"
    }
```
-   **Respuesta Esperada (201 Created):**
```bash
{
   "id": 5,
   "body": "Contenido de la nota 5",
   "important": false,
   "createdAt": "2025-02-24T12:00:00Z"
}
```
    

_Nota:_ El campo `important` se establece por defecto en `false` y `createdAt` se asigna automáticamente al momento de crear la nota.

----------

#### 4.2 Obtener Todas las Notas

-   **Método:** `GET`
    
-   **URL:** `http://localhost:8080/api/notes`
    
-   **Respuesta Esperada (200 OK):**
    
  ```bash
    [
        {
            "id": 1,
            "body": "Nota de ejemplo 1",
            "important": false,
            "createdAt": "2025-02-24T10:00:00Z"
        },
        {
            "id": 5,
            "body": "Contenido de la nota 5",
            "important": false,
            "createdAt": "2025-02-24T12:00:00Z"
        }
    ] 
 ```
----------

#### 4.3 Actualizar una Nota

-   **Método:** `PUT`
    
-   **URL:** `http://localhost:8080/api/notes/5`
    
-   **Headers:** `Content-Type: application/json`
    
-   **Request Body:**
    
   ```bash
    {
        "important": true
    } 
  ```
-   **Respuesta Esperada (200 OK):**
    
  ```bash
    {
        "id": 5,
        "body": "Contenido de la nota 5",
        "important": true,
        "updatedAt": "2025-02-24T12:30:00Z"
    } 
 ```

_Nota:_ En este endpoint se actualiza el estado de la nota (por ejemplo, para marcarla como importante). Se asume que el único campo actualizable es `important`, pero se puede ampliar según necesidades.

----------

#### 4.4 Eliminar una Nota

-   **Método:** `DELETE`
    
-   **URL:** `http://localhost:8080/api/notes/2`
    
-   **Respuesta Esperada (204 No Content):**
    
    Al eliminar la nota, no se devuelve contenido en la respuesta, lo que indica que la operación fue exitosa.
    

----------

### Parte 3: Dependencias del Proyecto

Esta es la sección del archivo `pom.xml` con las dependencias utilizadas:

```bash
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <scope>runtime</scope>
        <optional>true</optional>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <version>42.2.20</version>
    </dependency>
</dependencies> 
```
----------

### Parte 4: Ejecución y Pruebas

Para ejecutar la aplicación, asegúrate de que las variables de entorno estén configuradas correctamente y luego ejecuta:

```bash
`mvn spring-boot:run` 
```
Puedes realizar pruebas de los endpoints utilizando herramientas como [Postman](https://www.postman.com/) o [cURL](https://curl.se/).
