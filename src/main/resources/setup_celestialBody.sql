drop table CelestialBody;

CREATE TABLE CelestialBody (
	id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	name VARCHAR(50),
	location int
);

INSERT INTO CelestialBody (name, location) VALUES ('The North Star (Polaris)',1);
INSERT INTO CelestialBody (name, location) VALUES ('The Crab Nebula (M1)',2);
INSERT INTO CelestialBody (name, location) VALUES ('The Andromeda Galaxy (M31)',3);
INSERT INTO CelestialBody (name, location) VALUES ('The Virgo Cluster',4);
INSERT INTO CelestialBody (name, location) VALUES ('Sirius (the brightest star in the night sky)',5);
INSERT INTO CelestialBody (name, location) VALUES ('Betelgeuse (a red supergiant star in Orion)',6);
INSERT INTO CelestialBody (name, location) VALUES ('Milky Way center',7);
INSERT INTO CelestialBody (name, location) VALUES ('Cetus Ring Nebula',8);