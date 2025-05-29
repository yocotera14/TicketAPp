||||||# TicketApp - Sistema de Gestión de Tickets

Este proyecto es una aplicación desarrollada en Java utilizando el enfoque de arquitectura por capas. Implementa acceso a datos mediante el patrón DAO (Data Access Object) y maneja entidades representativas del modelo de base de datos. Está desarrollado con NetBeans.

---

Estructura del Proyecto

```
TicketApp/
├── src/
│   ├── dao/                  # Clases DAO e interfaz IBaseDAO
│   ├── businessentity/       # Entidades del modelo
│   ├── database/             # Conexión a la base de datos
│   └── main/                 # Clase principal del sistema
├── database/
│   └── script.sql            # Script de creación de la base de datos
├── README.md
```

---

Indicaciones cumplidas

**DAO y Clases:** Se implementó un paquete `dao` con clases DAO individuales por tabla.  
**Entidades:** Se creó una clase entidad por cada tabla en el paquete `businessentity`.  
**Interfaz IBaseDAO:** Todas las clases DAO implementan la interfaz `IBaseDAO`.  
**CRUD:** Los métodos de Create, Read, Update y Delete están presentes.  
**Conexión BD:** Incluye clase `DBConnection.java` para manejar la conexión a la base de datos.  
**Script SQL:** Incluido en la carpeta `database` (ver más abajo).  
**Repositorio GIT:** Asegúrate de compartir el enlace privado de tu repositorio GIT.

---
Entregables

**Repositorio GIT**: Proporcione un enlace privado con permisos restringidos para el equipo.
**Proyecto NetBeans**: Estructurado como se describe.
**Script SQL**: Archivo script.sql incluido en database/.

---

Ejecución

1. Clona el repositorio.
2. Abre el proyecto en NetBeans.
3. Asegúrate de tener una base de datos MySQL/MariaDB configurada.
4. Ejecuta el script SQL (database/script.sql) para crear las tablas.
5. Ejecuta TicketApp.java desde src/main.

---

Autores

- Luis Alexander Castro Cancino
- Josef Richard Cotera Marcilla
