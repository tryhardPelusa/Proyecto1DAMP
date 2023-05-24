CREATE DATABASE IF NOT EXISTS ProyectoIntegrador CHARACTER SET Latin1 COLLATE latin1_spanish_ci;

USE ProyectoIntegrador;

CREATE TABLE Apuestas (
IDApuestas integer auto_increment NOT NULL,
Cantidad INTEGER NOT NULL,
Pronostico varchar (50) NOT NULL,
primary Key(IDApuestas)
)engine=innodb;

CREATE TABLE Usuario (
  ID Integer auto_increment not NULL,
  Nombre varchar(30) NOT NULL,
  Apellido1  varchar(50) NOT NULL,
  Apellido2 varchar(50) DEFAULT NULL,
  Telefono Integer DEFAULT NULL,
  monedas Integer NOT NULL,
  Edad Varchar(50) NOT NULL,
  Correo varchar(50) NOT NULL,
  contraseña varchar(20) not null,
	Usuario varchar(50) NOT NULL,
  PRIMARY KEY (ID)
) engine=innodb;


Create Table Equipos(
IDEquipo integer auto_increment NOT NULL,
Nombre Varchar (50) NOT NULL,
Deporte varchar(50) Not NULL,
Estadio varchar (50) DEFAULT NULL,
primary key (IDEquipo)
)engine=innodb;


Create Table Ligas(
Premio integer NOT NULL,
Nombre varchar(50) NOT NULL,
ID integer auto_increment NOT NULL,
Sede varchar(60) default NULL,
fechaInicio date NOT NULL,
privacidad enum('privado','publico') NOT NULL,
deporte varchar(50) NOT NULL,
IDAdmin Integer NOT NULL,
FOREIGN KEY (IDAdmin) REFERENCES usuario(ID) ON DELETE CASCADE ON UPDATE CASCADE,
 PRIMARY KEY (ID)
) engine=innodb;



create Table Partidos(
ID integer auto_increment NOT NULL,
EquipLocal varchar(20) not null,
EquipVisitante Varchar(20) not null,
Lugar Varchar(40) not null,
Fecha date not null,
IDLiga integer not null,
FOREIGN KEY (IDLiga) references ligas(ID) ON DELETE CASCADE ON UPDATE CASCADE,
PRIMARY KEY (ID)
)engine=innodb;



CREATE TABLE resultado(
ID INTEGER auto_increment NOT NULL,
PuntosVisitante INTEGER NOT NULL,
PuntosLocales INTEGER NOT NULL,
Fecha date NOT NULL,
EquipLocal Varchar (20) NOT NULL,
EquipVisitante Varchar(20) not null,
IDPartido INTEGER NOT NULL,
PRIMARY KEY (ID),
FOREIGN KEY (IDPartido) references Partidos(ID) ON DELETE CASCADE ON UPDATE CASCADE
)engine=innodb;


CREATE TABLE USUARIO_APUESTA(
IDApuesta INTEGER NOT NULL,
IDUsuario INTEGER NOT NULL,
FOREIGN KEY (IDApuesta) references Apuestas(IDApuestas) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (IDUsuario) references Usuario(ID) ON DELETE CASCADE ON UPDATE CASCADE
) engine=innodb;

CREATE TABLE Participan(
IDEquipo INTEGER NOT NULL,
IDLiga INTEGER NOT NULL,
FOREIGN KEY (IDEquipo) references Equipos(IDEquipo) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (IDLiga) references Ligas(ID) ON DELETE CASCADE ON UPDATE CASCADE
)engine=innodb;

CREATE TABLE Usuario_PertEquipo(
IDUsuario INTEGER NOT NULL,
IDEquipo INTEGER NOT NULL,
FOREIGN KEY (IDUsuario) references Usuario(ID) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (IDEquipo) references Equipos(IDEquipo) ON DELETE CASCADE ON UPDATE CASCADE
) engine=innodb;