drop table Telescope;

CREATE TABLE Telescope (
	id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	name VARCHAR(50),
	location INT,
	type INT,
	aperture DOUBLE,
	fieldOfView DOUBLE
);

INSERT INTO Telescope (name, location, type, aperture, fieldOfView) VALUES ('Hubble Space Telescope', 0, 1, 2.4, 5);
INSERT INTO Telescope (name, location, type, aperture, fieldOfView) VALUES ('James Webb Space Telescope', 0, 1, 6.5, 2.5);
INSERT INTO Telescope (name, location, type, aperture, fieldOfView) VALUES ('Keck Observatory', 1, 1, 10, 1.8);
INSERT INTO Telescope (name, location, type, aperture, fieldOfView) VALUES ('Very Large Telescope', 1, 1, 8.2, 1.4);
INSERT INTO Telescope (name, location, type, aperture, fieldOfView) VALUES ('Subaru Telescope', 1, 1, 8.2, 1.4);