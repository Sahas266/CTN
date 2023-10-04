drop table CelestialObservation;

CREATE TABLE CelestialObservation (
	id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	observation VARCHAR(50),
	location int
);

INSERT INTO CelestialObservation (observation, location) VALUES ('The Crab Nebula', 1);
INSERT INTO CelestialObservation (observation, location) VALUES ('The Andromeda Galaxy', 2);
INSERT INTO CelestialObservation (observation, location) VALUES ('The Orion Nebula', 3);
INSERT INTO CelestialObservation (observation, location) VALUES ('The Pleiades star cluster', 4);
INSERT INTO CelestialObservation (observation, location) VALUES ('The Hubble Deep Field', 5);