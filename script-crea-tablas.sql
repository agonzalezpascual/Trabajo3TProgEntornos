CREATE DATABASE Proy3TE5;

USE Proy3TE5;

CREATE TABLE DONANTES(
	DNI CHAR (9),
	Nombre VARCHAR (50),
	Direccion VARCHAR (50),
	CodPostal CHAR (5),
	Localidad VARCHAR (80),
	FechaNac DATE,
	Correo VARCHAR (50),
	Telefono CHAR (9),
	GrupoSang CHAR (2),
	FactorRH CHAR (1),
	PRIMARY KEY (DNI)
);

CREATE OR REPLACE TABLE SANITARIOSBANCO(
	CodSanitario INT,
	NombreSanitario VARCHAR (50),
	FechaDonacion DATE,
	Cantidad DECIMAL (8,2),
	Incidencia BOOLEAN,
	DniDonante CHAR (9),
	PRIMARY KEY (CodSanitario),
	FOREIGN KEY (DniDonante) REFERENCES DONANTES (DNI)
);

CREATE TABLE COMPATIBILDAD(
	IdCompatibilidad INT AUTO_INCREMENT,
	GrupoSang CHAR (2),
	FactorRH CHAR (1),
	DonarA VARCHAR (50),
	RecibirDe VARCHAR (50)
);

INSERT INTO DONANTES(DNI, Nombre, Direccion, CodPostal, Localidad, FechaNac, Correo, Telefono, GrupoSang, FactorRH) VALUES('12345698F', 'Francisco Armario', 'Calle Zafiro', '41009', 'Sevilla', '2000-04-04', 'farmar@safareyes.es', 638438341, 'AB', '+');
INSERT INTO DONANTES(DNI, Nombre, Direccion, CodPostal, Localidad, FechaNac, Correo, Telefono, GrupoSang, FactorRH) VALUES('98653212S', 'Alfonso González', 'Calle Rubí', '41009', 'Sevilla', '2003-07-04', 'agonza@safareyes.es', 678838342, 'A', '+');
INSERT INTO DONANTES(DNI, Nombre, Direccion, CodPostal, Localidad, FechaNac, Correo, Telefono, GrupoSang, FactorRH) VALUES('45689423M', 'Jorge Tenorio', 'Calle Esmeralda', '41009', 'Sevilla', '1997-07-01', 'jtenorio@safareyes.es', 671839323, '0', '-');
INSERT INTO DONANTES(DNI, Nombre, Direccion, CodPostal, Localidad, FechaNac, Correo, Telefono, GrupoSang, FactorRH) VALUES('20206520J', 'Juanma Aguilar', 'Calle Rojo', '41009', 'Sevilla', '1994-09-14', 'jaguilar@safareyes.es', 677337594, 'A', '+');

INSERT INTO DONANTES(DNI, Nombre, Direccion, CodPostal, Localidad, FechaNac, Correo, Telefono, GrupoSang, FactorRH) VALUES('65432165U', 'Pedro Blanco', 'Calle Verde', '41009', 'Sevilla', '1988-07-18', 'pblanco@safareyes.es', 627822395, 'A', '-');
INSERT INTO DONANTES(DNI, Nombre, Direccion, CodPostal, Localidad, FechaNac, Correo, Telefono, GrupoSang, FactorRH) VALUES('26535985L', 'Mariano Gómez', 'Calle Diamante', '41009', 'Sevilla', '2000-01-15', 'mgomez@safareyes.es', 677837626, 'AB', '-');
INSERT INTO DONANTES(DNI, Nombre, Direccion, CodPostal, Localidad, FechaNac, Correo, Telefono, GrupoSang, FactorRH) VALUES('65239856K', 'Manuel Rodríguez', 'Calle Perla', '41009', 'Sevilla', '1968-08-24', 'mrodri@safareyes.es', 677227347, '0', '-');
INSERT INTO DONANTES(DNI, Nombre, Direccion, CodPostal, Localidad, FechaNac, Correo, Telefono, GrupoSang, FactorRH) VALUES('32541841G', 'Inés Espinosa', 'Calle Platino', '41009', 'Sevilla', '1977-06-04', 'iespino@safareyes.es', 669837378, 'B', '+');

INSERT INTO DONANTES(DNI, Nombre, Direccion, CodPostal, Localidad, FechaNac, Correo, Telefono, GrupoSang, FactorRH) VALUES('36985214R', 'Álex Vázquez', 'Calle Blanco', '41009', 'Sevilla', '1986-08-11', 'avazquez@safareyes.es', 677227359, '0', '+');
INSERT INTO DONANTES(DNI, Nombre, Direccion, CodPostal, Localidad, FechaNac, Correo, Telefono, GrupoSang, FactorRH) VALUES('65465465T', 'Guillermo Tarín', 'Calle Negro', '41009', 'Sevilla', '1992-06-20', 'guilletar@safareyes.es', 672237346, 'B', '+');
