drop table Event;

CREATE TABLE CelestialEvent (
	id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	event VARCHAR(50),
	location int
);

INSERT INTO CelestialEvent (event, location) VALUES ('Solar Eclipse',1);
INSERT INTO CelestialEvent (event, location) VALUES ('Lunar Eclipse',2);
INSERT INTO CelestialEvent (event, location) VALUES ('Meteor shower',3);
INSERT INTO CelestialEvent (event, location) VALUES ('Comet',4);
INSERT INTO CelestialEvent (event, location) VALUES ('Supernova',5);