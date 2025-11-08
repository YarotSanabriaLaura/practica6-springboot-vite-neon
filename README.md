---

## 🔍 Sección de Investigación

**¿Qué es Spring Boot y por qué simplifica el desarrollo web con Java?**  
Es un framework que automatiza gran parte de la configuración de un proyecto Java. Permite crear aplicaciones web rápido, sin tener que escribir todo el setup manual de Spring.  

**¿Qué diferencia hay entre `@RestController` y `@Controller`?**  
`@RestController` devuelve datos en formato JSON directo al cliente (ideal para APIs).  
`@Controller` se usa cuando querés devolver vistas HTML o usar plantillas.  

**¿Qué es JPA y cómo ayuda a mapear objetos en una base de datos relacional?**  
JPA (Java Persistence API) traduce las clases Java en tablas de una base de datos, haciendo más fácil guardar y leer objetos sin escribir SQL manual.  

**¿Por qué Neon se considera una base “serverless”?**  
Porque no necesita que el usuario administre un servidor. Neon maneja la infraestructura automáticamente y se escala según el uso.  

**¿Cómo funciona el CORS y por qué fue necesario configurarlo?**  
CORS permite que el frontend (en otro puerto o dominio) pueda comunicarse con el backend.  
Lo configuramos para que el Vite (5173) pudiera hacer peticiones al backend en 8080 sin ser bloqueado por el navegador.  

---
