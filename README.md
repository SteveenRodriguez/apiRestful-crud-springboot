#Spring Boot RESTful services

Creando servicios web con Spring Boot

Como hemos visto previamente Spring Framework sirve para hacer muchas cosas, sin embargo en este curso vamos a centrarnos en Spring Boot para la creación de servicios tipo RESTful como medio de comunicación entre aplicaciones, el caso mas típico en el desarrollo web es el de conectar una pagina web (front-end) con una base de datos, en esta escenario nuestra aplicación desarrollada (back-end) en Spring Boot contendrá todas las reglas, validaciones y lógica de negocio para una correcta gestión de la informacion. Para esta sección crearemos una aplicaciones usando el inicializador de Spring Boot una aplicación con las dependencias Web y Mongo. 

Estructura de un proyecto Spring Boot
Como todo proyecto de software es importante definir una estructura que nos permita organizar nuestro código que le permita crecer y mantener una coherencia entre las clases y estructuras algorítmicas que se crean.  En el caso de Spring Boot se nos recomienda una estructura de paquetes donde organizaremos nuestras clases de la siguiente manera:

Controllers - Responsable de procesar las solicitudes de API REST entrantes, comunicarlas a los servicios y devolver una respuesta. Es básicamente el punto de comunicación con el Front-End.
Services - A estas clases se les inyectarán repositorios y pueden consultar varias clases de repositorios y combinar sus datos para formar objetos nuevos y más complejos. Además, introducen una capa de abstracción entre la aplicación web y los repositorios para que puedan trabajar de forma más independiente.
Repositories - Estas clases manejan la entrada y salida de datos de nuestro base de datos, cada repositorio solo funciona con una única clase de modelo. Entonces, si sus modelos son Perros, Gatos y Ratas, tendría un Repositorio para cada una de estas clases.
Models (Entities / Collections) - Define un contenedor para los atributos del modelo y está diseñado principalmente para agregar atributos al modelo. Una clase marcada como modelo representara una tabla o colección en nuestro sistema de base de datos, sus atributos son el reflejo de las contenidos en la tabla o colección, de manera que operar la clase modelo será equivalente a manejar los registros de la base de datos. 
DTOs - Los Data Transfer Objects sirven para no exponer las funcionalidades o estructuras de nuestro modelos (recuerdan que están relacionados directamente con la base de datos) en su lugar se crea un objeto plano que sirva como medio de envió y recuperación de informacion en nuestra API
Mappers -  Permite realizar conversiones entre los objetos DTO y los modelos, estas clases permitirán operar con la informacion que llega desde un controlador en forma de un DTO y convertirla en una entidad para ser manejada por el repositorio.
