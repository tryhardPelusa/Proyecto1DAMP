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
<<<<<<< HEAD
CodEquipo varchar(10) NOT NULL,
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
CodLiga varchar(10) NOT NULL,
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

CREATE TABLE Equipo_Pert_Liga(
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


INSERT INTO Apuestas (Cantidad, Pronostico) VALUES (500, 'Gana local');
INSERT INTO Apuestas (Cantidad, Pronostico) VALUES (200, 'Gana visitante');
INSERT INTO Apuestas (Cantidad, Pronostico) VALUES (1000, 'Empate');
INSERT INTO Apuestas (Cantidad, Pronostico) VALUES (350, 'Gana local');
INSERT INTO Apuestas (Cantidad, Pronostico) VALUES (800, 'Gana visitante');
INSERT INTO Apuestas (Cantidad, Pronostico) VALUES (700, 'Gana local');
INSERT INTO Apuestas (Cantidad, Pronostico) VALUES (250, 'Empate');
INSERT INTO Apuestas (Cantidad, Pronostico) VALUES (450, 'Gana local');
INSERT INTO Apuestas (Cantidad, Pronostico) VALUES (900, 'Gana visitante');
INSERT INTO Apuestas (Cantidad, Pronostico) VALUES (1500, 'Empate');
INSERT INTO Apuestas (Cantidad, Pronostico) VALUES (650, 'Gana local');
INSERT INTO Apuestas (Cantidad, Pronostico) VALUES (850, 'Gana visitante');
INSERT INTO Apuestas (Cantidad, Pronostico) VALUES (400, 'Empate');
INSERT INTO Apuestas (Cantidad, Pronostico) VALUES (550, 'Gana local');
INSERT INTO Apuestas (Cantidad, Pronostico) VALUES (750, 'Gana visitante');

INSERT INTO Usuario (Nombre, Apellido1, Apellido2, monedas, Edad, Correo, contraseña, Usuario) VALUES ('Publicas', 'Publicas', 'Publicas', 1, '1', 'publicas@gmail.com', 'publicas', 'publicas');
INSERT INTO Usuario (Nombre, Apellido1, Apellido2, monedas, Edad, Correo, contraseña, Usuario) VALUES ('Juan', 'Pérez', 'García', 1000, '30', 'juan.perez@gmail.com', '1234abcd', 'juan_perez');
INSERT INTO Usuario (Nombre, Apellido1, Apellido2, monedas, Edad, Correo, contraseña, Usuario) VALUES ('Ana', 'Sánchez', 'López', 2000, '28', 'ana.sanchez@gmail.com', 'abcd1234', 'ana_sanchez');
INSERT INTO Usuario (Nombre, Apellido1, Apellido2, monedas, Edad, Correo, contraseña, Usuario) VALUES ('Carlos', 'Rodríguez', 'Martín', 3000, '32', 'carlos.rodriguez@gmail.com', '1234efgh', 'carlos_rodriguez');
INSERT INTO Usuario (Nombre, Apellido1, Apellido2, monedas, Edad, Correo, contraseña, Usuario) VALUES ('Beatriz', 'Morales', 'Fernández', 1000, '27', 'beatriz.morales@gmail.com', 'efgh1234', 'beatriz_morales');
INSERT INTO Usuario (Nombre, Apellido1, Apellido2, monedas, Edad, Correo, contraseña, Usuario) VALUES ('David', 'González', 'Ramírez', 2000, '31', 'david.gonzalez@gmail.com', '1234ijkl', 'david_gonzalez');
INSERT INTO Usuario (Nombre, Apellido1, Apellido2, monedas, Edad, Correo, contraseña, Usuario) VALUES ('Admin', 'Admin', 'Admin', 1000, '30', 'admin@gmail.com', '1234', 'admin');

INSERT INTO Equipos (Nombre, Deporte, Estadio, CodEquipo) VALUES ('Real Madrid', 'Fútbol', 'Estadio 6', '11ABC');
INSERT INTO Equipos (Nombre, Deporte, Estadio, CodEquipo) VALUES ('Atletico de Madrid', 'Fútbol', 'Estadio 7', '11ABD');
INSERT INTO Equipos (Nombre, Deporte, Estadio, CodEquipo) VALUES ('Barcelona FC', 'Fútbol', 'Estadio 8', '11ABE');
INSERT INTO Equipos (Nombre, Deporte, Estadio, CodEquipo) VALUES ('Manchester City', 'Fútbol', 'Estadio 9', '11ABF');
INSERT INTO Equipos (Nombre, Deporte, Estadio, CodEquipo) VALUES ('Arsenal', 'Fútbol', 'Estadio 10', '11ABG');
INSERT INTO Equipos (Nombre, Deporte, Estadio, CodEquipo) VALUES ('Chelsea', 'Fútbol', 'Estadio 11', '11ABH');
INSERT INTO Equipos (Nombre, Deporte, Estadio, CodEquipo) VALUES ('Lakers', 'Basket', 'Estadio 12', '11ABI');
INSERT INTO Equipos (Nombre, Deporte, Estadio, CodEquipo) VALUES ('Los angeles', 'Basket', 'Estadio 13', '11ABJ');
INSERT INTO Equipos (Nombre, Deporte, Estadio, CodEquipo) VALUES ('Las Palmas FC', 'Fútbol', 'Estadio 14', '11ABK');
INSERT INTO Equipos (Nombre, Deporte, Estadio, CodEquipo) VALUES ('Granada FC', 'Fútbol', 'Estadio 15', '11ABL');

INSERT INTO usuario_pertequipo (IDUsuario, IDEquipo) VALUES (2, 1);
INSERT INTO usuario_pertequipo (IDUsuario, IDEquipo) VALUES (2, 4);
INSERT INTO usuario_pertequipo (IDUsuario, IDEquipo) VALUES (2, 7);
INSERT INTO usuario_pertequipo (IDUsuario, IDEquipo) VALUES (3, 2);
INSERT INTO usuario_pertequipo (IDUsuario, IDEquipo) VALUES (3, 5);
INSERT INTO usuario_pertequipo (IDUsuario, IDEquipo) VALUES (3, 8);

INSERT INTO Ligas (Premio, Nombre, Sede, fechaInicio, privacidad, deporte, IDAdmin, CodLiga) VALUES (5000, 'La Liga', 'Sede 1', '2023-05-26', 'publico', 'Fútbol', 1, "ABC11");
INSERT INTO Ligas (Premio, Nombre, Sede, fechaInicio, privacidad, deporte, IDAdmin, CodLiga) VALUES (6000, 'Liga 123', 'Sede 2', '2023-06-01', 'publico', 'Fútbol', 1, 'ABC12');
INSERT INTO Ligas (Premio, Nombre, Sede, fechaInicio, privacidad, deporte, IDAdmin, CodLiga) VALUES (7000, 'NBA', 'Sede 3', '2023-06-05', 'privado', 'Basket', 1, 'ABC13');
INSERT INTO Ligas (Premio, Nombre, Sede, fechaInicio, privacidad, deporte, IDAdmin, CodLiga) VALUES (8000, 'Major League Baseball', 'Sede 4', '2023-06-10', 'publico', 'Basket', 1, 'ABC14');
INSERT INTO Ligas (Premio, Nombre, Sede, fechaInicio, privacidad, deporte, IDAdmin, CodLiga) VALUES (9000, 'National Hockey League', 'Sede 5', '2023-06-15', 'privado', 'Fútbol', 1, 'ABC15');
INSERT INTO Ligas (Premio, Nombre, Sede, fechaInicio, privacidad, deporte, IDAdmin, CodLiga) VALUES (10000, 'Premier League', 'Sede 6', '2023-06-20', 'publico', 'Fútbol', 1, 'ABC16');
INSERT INTO Ligas (Premio, Nombre, Sede, fechaInicio, privacidad, deporte, IDAdmin, CodLiga) VALUES (11000, 'Bundesliga', 'Sede 7', '2023-06-25', 'publico', 'Fútbol', 1, 'ABC17');
INSERT INTO Ligas (Premio, Nombre, Sede, fechaInicio, privacidad, deporte, IDAdmin, CodLiga) VALUES (12000, 'Ligue 1', 'Sede 8', '2023-06-30', 'privado', 'Basket', 1, 'ABC18');
INSERT INTO Ligas (Premio, Nombre, Sede, fechaInicio, privacidad, deporte, IDAdmin, CodLiga) VALUES (13000, 'Liga MX', 'Sede 9', '2023-07-05', 'publico', 'Basket', 1, 'ABC19');
INSERT INTO Ligas (Premio, Nombre, Sede, fechaInicio, privacidad, deporte, IDAdmin, CodLiga) VALUES (14000, 'Liga ACB', 'Sede 10', '2023-07-10', 'privado', 'Fútbol', 1, 'ABC20');
INSERT INTO Ligas (Premio, Nombre, Sede, fechaInicio, privacidad, deporte, IDAdmin, CodLiga) VALUES (15000, 'National Rugby League', 'Sede 11', '2023-07-15', 'publico', 'Fútbol', 1, 'ABC21');
INSERT INTO Ligas (Premio, Nombre, Sede, fechaInicio, privacidad, deporte, IDAdmin, CodLiga) VALUES (16000, 'Major League Soccer', 'Sede 12', '2023-07-20', 'publico', 'Basket', 1, 'ABC22');
INSERT INTO Ligas (Premio, Nombre, Sede, fechaInicio, privacidad, deporte, IDAdmin, CodLiga) VALUES (17000, 'Indian Premier League', 'Sede 13', '2023-07-25', 'privado', 'Basket', 1, 'ABC23');
INSERT INTO Ligas (Premio, Nombre, Sede, fechaInicio, privacidad, deporte, IDAdmin, CodLiga) VALUES (18000, 'Professional Golfers Association', 'Sede 14', '2023-07-30', 'publico', 'Fútbol', 1, 'ABC24');
INSERT INTO Ligas (Premio, Nombre, Sede, fechaInicio, privacidad, deporte, IDAdmin, CodLiga) VALUES (19000, 'National Football League', 'Sede 15', '2023-08-05', 'privado', 'Fútbol', 1, 'ABC25');

INSERT INTO Equipo_Pert_Liga (IDEquipo, IDLiga) VALUES (1, 1);
INSERT INTO Equipo_Pert_Liga (IDEquipo, IDLiga) VALUES (2, 1);
INSERT INTO Equipo_Pert_Liga (IDEquipo, IDLiga) VALUES (3, 1);
INSERT INTO Equipo_Pert_Liga (IDEquipo, IDLiga) VALUES (4, 6);
INSERT INTO Equipo_Pert_Liga (IDEquipo, IDLiga) VALUES (5, 6);
INSERT INTO Equipo_Pert_Liga (IDEquipo, IDLiga) VALUES (6, 6);
INSERT INTO Equipo_Pert_Liga (IDEquipo, IDLiga) VALUES (7, 3);
INSERT INTO Equipo_Pert_Liga (IDEquipo, IDLiga) VALUES (8, 3);
INSERT INTO Equipo_Pert_Liga (IDEquipo, IDLiga) VALUES (9, 2);
INSERT INTO Equipo_Pert_Liga (IDEquipo, IDLiga) VALUES (10, 2);

INSERT INTO Partidos (EquipLocal, EquipVisitante, Lugar, Fecha, IDLiga) VALUES ('Equipo A', 'Equipo B', 'Estadio 1', '2023-06-26', 1);
INSERT INTO Partidos (EquipLocal, EquipVisitante, Lugar, Fecha, IDLiga) VALUES ('Equipo C', 'Equipo D', 'Estadio 3', '2023-07-01', 1);
INSERT INTO Partidos (EquipLocal, EquipVisitante, Lugar, Fecha, IDLiga) VALUES ('Equipo E', 'Equipo A', 'Estadio 5', '2023-07-05', 1);
INSERT INTO Partidos (EquipLocal, EquipVisitante, Lugar, Fecha, IDLiga) VALUES ('Equipo B', 'Equipo C', 'Estadio 2', '2023-07-10', 1);
INSERT INTO Partidos (EquipLocal, EquipVisitante, Lugar, Fecha, IDLiga) VALUES ('Equipo D', 'Equipo E', 'Estadio 4', '2023-07-15', 1);
INSERT INTO Partidos (EquipLocal, EquipVisitante, Lugar, Fecha, IDLiga) VALUES ('Equipo F', 'Equipo G', 'Estadio 6', '2023-07-20', 2);
INSERT INTO Partidos (EquipLocal, EquipVisitante, Lugar, Fecha, IDLiga) VALUES ('Equipo H', 'Equipo I', 'Estadio 8', '2023-07-25', 2);
INSERT INTO Partidos (EquipLocal, EquipVisitante, Lugar, Fecha, IDLiga) VALUES ('Equipo J', 'Equipo F', 'Estadio 10', '2023-07-30', 2);
INSERT INTO Partidos (EquipLocal, EquipVisitante, Lugar, Fecha, IDLiga) VALUES ('Equipo G', 'Equipo H', 'Estadio 7', '2023-08-05', 2);
INSERT INTO Partidos (EquipLocal, EquipVisitante, Lugar, Fecha, IDLiga) VALUES ('Equipo I', 'Equipo J', 'Estadio 9', '2023-08-10', 2);
INSERT INTO Partidos (EquipLocal, EquipVisitante, Lugar, Fecha, IDLiga) VALUES ('Equipo K', 'Equipo L', 'Estadio 11', '2023-08-15', 3);
INSERT INTO Partidos (EquipLocal, EquipVisitante, Lugar, Fecha, IDLiga) VALUES ('Equipo M', 'Equipo N', 'Estadio 13', '2023-08-20', 3);
INSERT INTO Partidos (EquipLocal, EquipVisitante, Lugar, Fecha, IDLiga) VALUES ('Equipo O', 'Equipo K', 'Estadio 15', '2023-08-25', 3);
INSERT INTO Partidos (EquipLocal, EquipVisitante, Lugar, Fecha, IDLiga) VALUES ('Equipo L', 'Equipo M', 'Estadio 12', '2023-08-30', 3);
INSERT INTO Partidos (EquipLocal, EquipVisitante, Lugar, Fecha, IDLiga) VALUES ('Equipo N', 'Equipo O', 'Estadio 14', '2023-09-05', 3);
=======
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


INSERT INTO Apuestas (Cantidad, Pronostico) VALUES (500, 'Gana local');
INSERT INTO Apuestas (Cantidad, Pronostico) VALUES (200, 'Gana visitante');
INSERT INTO Apuestas (Cantidad, Pronostico) VALUES (1000, 'Empate');
INSERT INTO Apuestas (Cantidad, Pronostico) VALUES (350, 'Gana local');
INSERT INTO Apuestas (Cantidad, Pronostico) VALUES (800, 'Gana visitante');
INSERT INTO Apuestas (Cantidad, Pronostico) VALUES (700, 'Gana local');
INSERT INTO Apuestas (Cantidad, Pronostico) VALUES (250, 'Empate');
INSERT INTO Apuestas (Cantidad, Pronostico) VALUES (450, 'Gana local');
INSERT INTO Apuestas (Cantidad, Pronostico) VALUES (900, 'Gana visitante');
INSERT INTO Apuestas (Cantidad, Pronostico) VALUES (1500, 'Empate');
INSERT INTO Apuestas (Cantidad, Pronostico) VALUES (650, 'Gana local');
INSERT INTO Apuestas (Cantidad, Pronostico) VALUES (850, 'Gana visitante');
INSERT INTO Apuestas (Cantidad, Pronostico) VALUES (400, 'Empate');
INSERT INTO Apuestas (Cantidad, Pronostico) VALUES (550, 'Gana local');
INSERT INTO Apuestas (Cantidad, Pronostico) VALUES (750, 'Gana visitante');


INSERT INTO Usuario (Nombre, Apellido1, Apellido2, monedas, Edad, Correo, contraseña, Usuario) VALUES ('Juan', 'Pérez', 'García', 1000, '30', 'juan.perez@gmail.com', '1234abcd', 'juan_perez');
INSERT INTO Usuario (Nombre, Apellido1, Apellido2, monedas, Edad, Correo, contraseña, Usuario) VALUES ('Ana', 'Sánchez', 'López', 2000, '28', 'ana.sanchez@gmail.com', 'abcd1234', 'ana_sanchez');
INSERT INTO Usuario (Nombre, Apellido1, Apellido2, monedas, Edad, Correo, contraseña, Usuario) VALUES ('Carlos', 'Rodríguez', 'Martín', 3000, '32', 'carlos.rodriguez@gmail.com', '1234efgh', 'carlos_rodriguez');
INSERT INTO Usuario (Nombre, Apellido1, Apellido2, monedas, Edad, Correo, contraseña, Usuario) VALUES ('Beatriz', 'Morales', 'Fernández', 1000, '27', 'beatriz.morales@gmail.com', 'efgh1234', 'beatriz_morales');
INSERT INTO Usuario (Nombre, Apellido1, Apellido2, monedas, Edad, Correo, contraseña, Usuario) VALUES ('David', 'González', 'Ramírez', 2000, '31', 'david.gonzalez@gmail.com', '1234ijkl', 'david_gonzalez');
INSERT INTO Usuario (Nombre, Apellido1, Apellido2, monedas, Edad, Correo, contraseña, Usuario) VALUES ('Admin', 'Admin', 'Admin', 1000, '30', 'admin@gmail.com', '1234', 'admin');

INSERT INTO Equipos (Nombre, Deporte, Estadio) VALUES ('Equipo A', 'Fútbol', 'Estadio 1');
INSERT INTO Equipos (Nombre, Deporte, Estadio) VALUES ('Equipo B', 'Fútbol', 'Estadio 2');
INSERT INTO Equipos (Nombre, Deporte, Estadio) VALUES ('Equipo C', 'Basket', 'Estadio 3');
INSERT INTO Equipos (Nombre, Deporte, Estadio) VALUES ('Equipo D', 'Basket', 'Estadio 4');
INSERT INTO Equipos (Nombre, Deporte, Estadio) VALUES ('Equipo E', 'Fútbol', 'Estadio 5');

INSERT INTO Ligas (Premio, Nombre, Sede, fechaInicio, privacidad, deporte, IDAdmin) VALUES (5000, 'Liga 1', 'Sede 1', '2023-05-26', 'publico', 'Fútbol', 1);
INSERT INTO Ligas (Premio, Nombre, Sede, fechaInicio, privacidad, deporte, IDAdmin) VALUES (6000, 'Liga 2', 'Sede 2', '2023-06-01', 'publico', 'Fútbol', 1);
INSERT INTO Ligas (Premio, Nombre, Sede, fechaInicio, privacidad, deporte, IDAdmin) VALUES (7000, 'Liga 3', 'Sede 3', '2023-06-05', 'privado', 'Basket', 1);
INSERT INTO Ligas (Premio, Nombre, Sede, fechaInicio, privacidad, deporte, IDAdmin) VALUES (8000, 'Liga 4', 'Sede 4', '2023-06-10', 'publico', 'Basket', 1);
INSERT INTO Ligas (Premio, Nombre, Sede, fechaInicio, privacidad, deporte, IDAdmin) VALUES (9000, 'Liga 5', 'Sede 5', '2023-06-15', 'privado', 'Fútbol', 1);
INSERT INTO Ligas (Premio, Nombre, Sede, fechaInicio, privacidad, deporte, IDAdmin) VALUES (10000, 'Liga 6', 'Sede 6', '2023-06-20', 'publico', 'Fútbol', 1);
INSERT INTO Ligas (Premio, Nombre, Sede, fechaInicio, privacidad, deporte, IDAdmin) VALUES (11000, 'Liga 7', 'Sede 7', '2023-06-25', 'publico', 'Fútbol', 1);
INSERT INTO Ligas (Premio, Nombre, Sede, fechaInicio, privacidad, deporte, IDAdmin) VALUES (12000, 'Liga 8', 'Sede 8', '2023-06-30', 'privado', 'Basket', 1);
INSERT INTO Ligas (Premio, Nombre, Sede, fechaInicio, privacidad, deporte, IDAdmin) VALUES (13000, 'Liga 9', 'Sede 9', '2023-07-05', 'publico', 'Basket', 1);
INSERT INTO Ligas (Premio, Nombre, Sede, fechaInicio, privacidad, deporte, IDAdmin) VALUES (14000, 'Liga 10', 'Sede 10', '2023-07-10', 'privado', 'Fútbol', 1);
INSERT INTO Ligas (Premio, Nombre, Sede, fechaInicio, privacidad, deporte, IDAdmin) VALUES (15000, 'Liga 11', 'Sede 11', '2023-07-15', 'publico', 'Fútbol', 1);
INSERT INTO Ligas (Premio, Nombre, Sede, fechaInicio, privacidad, deporte, IDAdmin) VALUES (16000, 'Liga 12', 'Sede 12', '2023-07-20', 'publico', 'Basket', 1);
INSERT INTO Ligas (Premio, Nombre, Sede, fechaInicio, privacidad, deporte, IDAdmin) VALUES (17000, 'Liga 13', 'Sede 13', '2023-07-25', 'privado', 'Basket', 1);
INSERT INTO Ligas (Premio, Nombre, Sede, fechaInicio, privacidad, deporte, IDAdmin) VALUES (18000, 'Liga 14', 'Sede 14', '2023-07-30', 'publico', 'Fútbol', 1);
INSERT INTO Ligas (Premio, Nombre, Sede, fechaInicio, privacidad, deporte, IDAdmin) VALUES (19000, 'Liga 15', 'Sede 15', '2023-08-05', 'privado', 'Fútbol', 1);

INSERT INTO Partidos (EquipLocal, EquipVisitante, Lugar, Fecha, IDLiga) VALUES ('Equipo A', 'Equipo B', 'Estadio 1', '2023-06-26', 1);
INSERT INTO Partidos (EquipLocal, EquipVisitante, Lugar, Fecha, IDLiga) VALUES ('Equipo C', 'Equipo D', 'Estadio 3', '2023-07-01', 1);
INSERT INTO Partidos (EquipLocal, EquipVisitante, Lugar, Fecha, IDLiga) VALUES ('Equipo E', 'Equipo A', 'Estadio 5', '2023-07-05', 1);
INSERT INTO Partidos (EquipLocal, EquipVisitante, Lugar, Fecha, IDLiga) VALUES ('Equipo B', 'Equipo C', 'Estadio 2', '2023-07-10', 1);
INSERT INTO Partidos (EquipLocal, EquipVisitante, Lugar, Fecha, IDLiga) VALUES ('Equipo D', 'Equipo E', 'Estadio 4', '2023-07-15', 1);
INSERT INTO Partidos (EquipLocal, EquipVisitante, Lugar, Fecha, IDLiga) VALUES ('Equipo F', 'Equipo G', 'Estadio 6', '2023-07-20', 2);
INSERT INTO Partidos (EquipLocal, EquipVisitante, Lugar, Fecha, IDLiga) VALUES ('Equipo H', 'Equipo I', 'Estadio 8', '2023-07-25', 2);
INSERT INTO Partidos (EquipLocal, EquipVisitante, Lugar, Fecha, IDLiga) VALUES ('Equipo J', 'Equipo F', 'Estadio 10', '2023-07-30', 2);
INSERT INTO Partidos (EquipLocal, EquipVisitante, Lugar, Fecha, IDLiga) VALUES ('Equipo G', 'Equipo H', 'Estadio 7', '2023-08-05', 2);
INSERT INTO Partidos (EquipLocal, EquipVisitante, Lugar, Fecha, IDLiga) VALUES ('Equipo I', 'Equipo J', 'Estadio 9', '2023-08-10', 2);
INSERT INTO Partidos (EquipLocal, EquipVisitante, Lugar, Fecha, IDLiga) VALUES ('Equipo K', 'Equipo L', 'Estadio 11', '2023-08-15', 3);
INSERT INTO Partidos (EquipLocal, EquipVisitante, Lugar, Fecha, IDLiga) VALUES ('Equipo M', 'Equipo N', 'Estadio 13', '2023-08-20', 3);
INSERT INTO Partidos (EquipLocal, EquipVisitante, Lugar, Fecha, IDLiga) VALUES ('Equipo O', 'Equipo K', 'Estadio 15', '2023-08-25', 3);
INSERT INTO Partidos (EquipLocal, EquipVisitante, Lugar, Fecha, IDLiga) VALUES ('Equipo L', 'Equipo M', 'Estadio 12', '2023-08-30', 3);
INSERT INTO Partidos (EquipLocal, EquipVisitante, Lugar, Fecha, IDLiga) VALUES ('Equipo N', 'Equipo O', 'Estadio 14', '2023-09-05', 3);

INSERT INTO Equipos (Nombre, Deporte, Estadio) VALUES ('Equipo F', 'Fútbol', 'Estadio 6');
INSERT INTO Equipos (Nombre, Deporte, Estadio) VALUES ('Equipo G', 'Fútbol', 'Estadio 7');
INSERT INTO Equipos (Nombre, Deporte, Estadio) VALUES ('Equipo H', 'Basket', 'Estadio 8');
INSERT INTO Equipos (Nombre, Deporte, Estadio) VALUES ('Equipo I', 'Basket', 'Estadio 9');
INSERT INTO Equipos (Nombre, Deporte, Estadio) VALUES ('Equipo J', 'Fútbol', 'Estadio 10');
INSERT INTO Equipos (Nombre, Deporte, Estadio) VALUES ('Equipo K', 'Fútbol', 'Estadio 11');
INSERT INTO Equipos (Nombre, Deporte, Estadio) VALUES ('Equipo L', 'Basket', 'Estadio 12');
INSERT INTO Equipos (Nombre, Deporte, Estadio) VALUES ('Equipo M', 'Basket', 'Estadio 13');
INSERT INTO Equipos (Nombre, Deporte, Estadio) VALUES ('Equipo N', 'Fútbol', 'Estadio 14');
INSERT INTO Equipos (Nombre, Deporte, Estadio) VALUES ('Equipo O', 'Fútbol', 'Estadio 15');
>>>>>>> refs/remotes/MiGithub/JoseUD16Tarea

INSERT INTO resultado (PuntosVisitante, PuntosLocales, Fecha, EquipLocal, EquipVisitante, IDPartido) VALUES (3, 2, '2023-06-26', 'Equipo A', 'Equipo B', 1);
INSERT INTO resultado (PuntosVisitante, PuntosLocales, Fecha, EquipLocal, EquipVisitante, IDPartido) VALUES (1, 3, '2023-07-01', 'Equipo C', 'Equipo D', 2);
INSERT INTO resultado (PuntosVisitante, PuntosLocales, Fecha, EquipLocal, EquipVisitante, IDPartido) VALUES (0, 2, '2023-07-05', 'Equipo E', 'Equipo A', 3);
INSERT INTO resultado (PuntosVisitante, PuntosLocales, Fecha, EquipLocal, EquipVisitante, IDPartido) VALUES (4, 3, '2023-07-10', 'Equipo B', 'Equipo C', 4);
INSERT INTO resultado (PuntosVisitante, PuntosLocales, Fecha, EquipLocal, EquipVisitante, IDPartido) VALUES (1, 1, '2023-07-15', 'Equipo D', 'Equipo E', 5);
INSERT INTO resultado (PuntosVisitante, PuntosLocales, Fecha, EquipLocal, EquipVisitante, IDPartido) VALUES (2, 2, '2023-07-20', 'Equipo F', 'Equipo G', 6);
INSERT INTO resultado (PuntosVisitante, PuntosLocales, Fecha, EquipLocal, EquipVisitante, IDPartido) VALUES (3, 3, '2023-07-25', 'Equipo H', 'Equipo I', 7);
INSERT INTO resultado (PuntosVisitante, PuntosLocales, Fecha, EquipLocal, EquipVisitante, IDPartido) VALUES (1, 2, '2023-07-30', 'Equipo J', 'Equipo F', 8);
INSERT INTO resultado (PuntosVisitante, PuntosLocales, Fecha, EquipLocal, EquipVisitante, IDPartido) VALUES (4, 4, '2023-08-05', 'Equipo G', 'Equipo H', 9);
INSERT INTO resultado (PuntosVisitante, PuntosLocales, Fecha, EquipLocal, EquipVisitante, IDPartido) VALUES (0, 3, '2023-08-10', 'Equipo I', 'Equipo J', 10);
INSERT INTO resultado (PuntosVisitante, PuntosLocales, Fecha, EquipLocal, EquipVisitante, IDPartido) VALUES (2, 2, '2023-08-15', 'Equipo K', 'Equipo L', 11);
INSERT INTO resultado (PuntosVisitante, PuntosLocales, Fecha, EquipLocal, EquipVisitante, IDPartido) VALUES (1, 1, '2023-08-20', 'Equipo M', 'Equipo N', 12);
INSERT INTO resultado (PuntosVisitante, PuntosLocales, Fecha, EquipLocal, EquipVisitante, IDPartido) VALUES (3, 4, '2023-08-25', 'Equipo O', 'Equipo K', 13);
INSERT INTO resultado (PuntosVisitante, PuntosLocales, Fecha, EquipLocal, EquipVisitante, IDPartido) VALUES (2, 3, '2023-08-30', 'Equipo L', 'Equipo M', 14);
INSERT INTO resultado (PuntosVisitante, PuntosLocales, Fecha, EquipLocal, EquipVisitante, IDPartido) VALUES (1, 0, '2023-09-05', 'Equipo N', 'Equipo O', 15);
