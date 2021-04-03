# woloxTest

This application was generated using JHipster 6.9.1, you can find documentation and help at [https://www.jhipster.tech/documentation-archive/v6.9.1](https://www.jhipster.tech/documentation-archive/v6.9.1).

Aplicación API prueba técnica WChallenge Wolox; desarrollada por Juan Carlos Giraldo Atehortúa.

## Explicación del ejercicio realizado

Se desarrolla una Single Web Application como API, el cual es un maven project y tiene la estructura de proyecto base generado por Jhipster usando Java como tecnología base y Spring Boot 2.2.7.RELEASE para su arranque; el SDK usado es jdk-1.8.0_151

### Estructura de carpetas o paquetes del proyecto

    src->main->java->ar.com.wolox.test: 
Aqui se encuentra la clase principal con el main de la aplicacion que ejecuta Spring Boot (WoloxTestApp) 

    ->domain:
Aqui se encuentran los modelos u objetos del negocio del sistema (POJOs)

    ->repository:
Aqui se encuentra la interfaz TestRepository como repositorio con la declaracion de los metodos

    ->service:
Aqui se encuentran la clase TestService como servicio que implementa la interfaz con los metodos y logica de negocio

    ->web.rest: 
Aqui se encuentra la clase TestController como controlador puente de la API; allí están los metodos como GetMapping (protocolos GET) que serán visualizados en la ejecuciòn de la API.

### Presentacion del API

El proyecto usa swagger-ui para la presentacion de la API que enlaza los controladores existentes en el sistema y la estructura de los modelos

## Pasos para ingresar al sistema
Una vez descargado el repositorio desde GitHub en el IDE, se ejecuta Run del main que dispara el Spring Boot o luego de hacer maven install correr el .jar generado en la carpeta target desde el jre.
Luego en la consola se imprime el arranque del sistema y brinda las url de acceso de la aplicacion por http, en el puerto 8080.

luego de ingresar a la url y haber accedido al sistema se llega a la landing page Home; se requiere iniciar sesión y se ingresa como credenciales en account->sing in /
login: admin y password: admin en donde ingresa al Home ya logueado; luego en el menú Administration->API abre la pagina swagger-ui con los accesos a los controladores y modelos existentes.

el controlador que nos interesa es Test Controller con los metodos GET solucion del ejercicio:
De la información del servicio se tiene que poder acceder a través de nuestra API a:

1. Los usuarios: GET /api/users. obtenerUsuarios 
2. Las fotos: GET /api/photos. obtenerFotos
3. Los álbumes del sistema: GET /api/albums. obtenerAlbumes 
3.1. y de cada usuario: GET /api/albumsUserId. obtenerAlbumesUserId
4. Plus: Las fotos de un usuario: GET /api/photosUserId. obtenerFotosUsuario
5. En cuanto a los comentarios, se espera que la aplicación pueda traerlos del
   servicio externo brindando la posibilidad de filtrar por el campo “name” o por el
   usuario que realizó dicho comentario: GET /api​/commentsName. obtenerCommentariosNombre 
    
