 # Proyecto Integrador Programacion DAMP 1º     :computer:

*Integrantes:*
- Callizaya Fernández, Guillermo
- Fernández Turín, Raul
- Maya Salas, Jose
- Monedero Cabrera, Daniel
- Turienzo Prieto, Javier

Comenzamos con que cada uno nos hemos repartido las pantallas para realizar nuestra aplicación. Hemos usado Eclipse junto el plugin "WindowBuilder" para realizar la parte grafica de nuestra aplicación.
En total tenemos unas 12 pantallas repartidas asi:

0. **PaginaPrincipal** 
1. **Inicio de sesion**
2. **Registro**
3. **Recuperar Cuenta**
4. **MiCuenta**
5. **Unirse Liga**
6. **Unirse Equipo**
7. **Crear Ligas** 
8. **Crear Equipos**
9. **Liga especifica**
10. **Equipo Especifico**
11. **Apuestas**
12. **Mis Apuestas**

## PaginaPrincipal
Esta es la página principal del programa. En ella se pueden ver las ligas publicas y privadas, pudiendo cambiar a la pantalla de liga específica de cada liga pulsando en ella. Es lo mismo que la pantalla Ver Ligas, la hemos puesto como principal ya que creemos que sería la pantalla en la que más entrarian los usuarios.
## Inicio de sesion
En esta pantalla el usuario introducirá su nombre de usuario y su contraseña si los tuviese, en caso de no estar registrado, cuenta con un botón para acceder al registro y otro para acceder a la aplicación como invitado. Además, debajo del campo de contraseña, hay un label con el texto "¿Ha olvidado su contraseña?" en el que podrá pinchar para recuperar su contraseña.
## Registro 
En esta pagina el usuario introducira sus datos personales siendo estos obligatorios y otros datos no obligatorios como telefono o correo, tiene tambien una pequeña descripcion del funcionamiento de las monedas de la aplicacion.
## Recuperar Cuenta
En esta página, será una ventana para poder recuperar tu contraseña si la has olvidado. Tienes varios JLabels donde te explica que tienes que hacer, como por ejemplo; Introduzca tu usuario o correo electronico.
Tendras dos JTexteField donde seran los campos donde introduciras lo que te pide. También tendrás un boton de recuperar cuenta para cuando introduzcas en uno de los campos si le das se hara visible un Jlabel que tendrá un texto: "Revise su Correo".
## MiCuenta
En esta pantalla el usuario podrá acceder a su cuenta de usuaria donde puede ver todos los datos que ingreso para registrarse: "Nombre","Usuario","Apellido","Apellido2","Telefono","Correo electronico","Fecha de nacimiento". También tendremos un buttom para poder modificiar los datos si un usuario quiere hacer algún ajuste.
cambiar los datos del usuario.
## Unirse Liga
Aqui el usuario puede unirse a las ligas atraves de un codigo de union, tambien se puede unirse a un equipo o crearlo atraves de dos botones que redirigiran a la pantalla correspondiente.
## Unirse Equipo
En esta pantalla el usuario introducirá el código del equipo al que desea unirse. El resultado se mostrará pon pantalla, indicando si ha podido unirse satisfactoriamente al equipo o si por el contrario no ha sido posible.
## Crear Ligas
En esta pantalla el usuario introducira los datos necesarios para crear una nueva liga, los campos obligatorios están señalados con un asterisco. Podra establecer un premio si marca el checkBox situado al lado de "Premio", que hará que se permita escribir en el textField situado a su lado. Además, podrá modificar el reglamento para establecer el sistema de puntuación de la liga. 
## Crear Equipos
Esta pantalla es la que el usuario usa para dar de alta un equipo nuevo, tendra que dar informacion sobre el nombre, el deporte, y su sede o lugar (si asi lo desea donde se realizaran los partidos "en casa"). Aparte cuenta con el boton "Crear" que da de alta el equipo con los datos introducidos.
## Liga especifica
En esta pantalla se mostrara la clasificacion y el calendario de una liga en concreto. Dentro de la clasificacion estara el ranking en si de la liga, con puntuacion, partidos jugados, goles...etc., tipicos de cualquier ranking de liga de futbol. En la pestaña de calendario esta el calendario de partidos que van a tener lugar entre todos los integrantes de la liga.
## Equipo Especifico
En esta pantalla se puede observar el nombre del equipo como titulo seguido de tres columnas siendo la que se encuentra mas a la izquierda en la que apareceran los componentes del equipo la que se encuentra en el medio se muestran los deportes en los que participa dicho equipo junto a la sede del equipo si tiene y la de más a la derecha aparecen todas las ligas a las que pertenece dicho equipo.
## Apuestas
En esta pantalla aparecerán los partidos de una jornada en concreto de la liga desde la que se accedió a la pantalla, esta jornada se podra cambiar mediante los botones situados a los lados. El usuario podrá seleccionar el checkBox del equipo por el que quiere apostar, los dos checkBox para indicar empate o ninguno si no quiere apostar ese partido. En el spinner situado entre los dos equipos de cada partido introducira la cantidad a apostar. Además, en esta pantalla aparece a la izquierda la clasificacion actual de la liga y a la derecha una columna en la que aparece una previsualización de las apuestas seleccionadas, el total de tokens apostados y un botón para confirmar la apuesta.
## Mis Apuestas
En esta pantalla el usuario podra ver, a la izquierda, las apuestas que tiene en curso, y a la derecha, su historico de apuestas realizadas con su correspondiente resultado. En cada apuesta se indica el partido, la selección de la apuesta y la fecha del partido, asi como el resultado de la apuesta en el caso de las apuestas vencidas.
