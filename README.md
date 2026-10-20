# JDBC Basic Connection Test (MySQL)

## Descripción del Proyecto

Este proyecto es una implementación de la conexión a una base de datos **MySQL** utilizando **JDBC (Java Database Connectivity)**. Fue desarrollado para la asignatura **Acceso a Datos (AD)** del ciclo formativo DAM.

El objetivo principal es demostrar los tres pasos esenciales para interactuar con una base de datos desde Java: establecer la conexión, gestionar los recursos y ejecutar consultas básicas.

## Habilidades y Conceptos Demostrados

* **Conectividad JDBC (Driver):** Configuración del proyecto Maven (`pom.xml`) para incluir el conector MySQL y carga del driver.
* **Manejo de Conexiones Modulares:** La clase `db.MySQL` encapsula los parámetros de conexión (URL, USER, PASS) en una única clase para establecer la comunicación con el esquema `hoteles`.
* **Consultas Básicas (SELECT):** La clase `db.TestDB` ejecuta una consulta SQL (`SELECT id_hotel, nombre FROM hotel`) utilizando un `Statement` y procesa el `ResultSet`.
* **Gestión de Recursos Segura:** Uso del bloque **`try-with-resources`** en `TestDB.java` para asegurar que la conexión (`Connection`) y los recursos JDBC se cierran automáticamente, previniendo fugas de recursos.

## Tecnologías Utilizadas

* **Lenguaje:** Java
* **Gestor de Dependencias:** Apache Maven
* **Base de Datos:** MySQL
* **Conector:** `mysql-connector-j`

## Requisitos y Configuración para ejecutar

Para ejecutar este proyecto localmente:

1.  Tener instalado y activo un servidor MySQL.
2.  Tener una base de datos llamada `hoteles` con la tabla `hotel`.
3.  **Configurar las credenciales** sin tocar el código, con variables de entorno o propiedades de la JVM:
    * Variables de entorno: `DB_USER`, `DB_PASSWORD` (y opcionalmente `DB_URL`).
    * O al ejecutar: `-DDB_USER=tu_usuario -DDB_PASSWORD=tu_contraseña`.

    En NetBeans se pueden poner en *Properties → Run → VM Options*.
