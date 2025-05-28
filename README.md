ProyectoIntegrador-AskAcademy
# 📚 AskAcademy - Plataforma educativa interactiva
Se desea Crear una plataforma enfocada en educación con el propósito de darayuda a estudiantes con conceptos vistos en clase

## 🚀 Acerca del proyecto
AskAcademy es una plataforma educativa elaborada para que el alumno pueda reforzar los conceptos trabajados en clase a través de una dinámica distinta a la que utilizaría si se plantease como estudiar lo visto: el alumno no debe realiza una lectura de lo que el profesor ha explicado, o bien de la que tiene en sus apuntes, sino que tiene que responder formularios de opción múltiple elaborados por los distintos profesores, de tal manera que se hace un aprendizaje más dinámico y se obtiene una evaluación de lo que ha podido asimilar.

La plataforma está construida a partir de React.js, en ella el usuario puede elegir entre los siguientes roles:
- **Profesores** → Crean formularios, los editan y visualizan los resultados de los alumnos.
- **Alumnos** → Responden formularios y pueden ver su progreso.
Todo el sistema está optimizado para que la navegación fluya, así como su almacenamiento a partir de localStorage de tal manera que no es necesario tener una base de datos.

## 🎯 Principales características
- ✅ Autenticación de usuarios y registro e inicio de sesión obligatorios.
- ✅ Crear, editar y eliminar formularios a partir de los profesores.
- ✅ Acceso a formularios según materia y posibilidad de responder preguntas.
- ✅ Visualización de resultados para los profesores con estadísticas del alumno.
- ✅ Control del sistema con rutas protegidas mediante tokens.
- ✅ Interfaz de gráfica responsiva basada en una paleta de colores de azul y blanco.
- ✅ Enrutamiento dinámico con React Router (RouterProvider) para una navegación eficiente

## 📂 Estructura del Proyecto 
```
📂 src
    ┣ 📂 main
      ┣ 📂 java
        ┣ 📂 com.example.AskAcademy
            ┣ 📂 Controladores
            ┣ 📂 Helpers
            ┣ 📂 Modelos
            ┣ 📂 Repositorios
            ┣ 📂 Servicios
              ▶ AskAcademyApplication
```

# 🛠️ Herramientas usadas
- **Java** → Base fundamental para la creación de la aplicación.
- **Spring Boot**→ Tratamiento de rutas y navegación fluidad entre secciones.
