drop table CelestialLocation;

CREATE TABLE CelestialLocation (
	id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	celestialLongitude DOUBLE,
	celestialLatitude DOUBLE
);

INSERT INTO CelestialLocation (celestialLongitude, celestialLatitude) VALUES (2.425656368, 89.233105469);
INSERT INTO CelestialLocation (celestialLongitude, celestialLatitude) VALUES (5.575891879, 22.014201539);
INSERT INTO CelestialLocation (celestialLongitude, celestialLatitude) VALUES (0.7034927881, 41.269897276);
INSERT INTO CelestialLocation (celestialLongitude, celestialLatitude) VALUES (12.452145996, 12.741471277);
INSERT INTO CelestialLocation (celestialLongitude, celestialLatitude) VALUES (6.871434065, -16.741061602);
INSERT INTO CelestialLocation (celestialLongitude, celestialLatitude) VALUES (8.776453583, -5.224153657);
INSERT INTO CelestialLocation (celestialLongitude, celestialLatitude) VALUES (266.425111092, -28.940447218);
INSERT INTO CelestialLocation (celestialLongitude, celestialLatitude) VALUES (22.976937784, -4.034066323);