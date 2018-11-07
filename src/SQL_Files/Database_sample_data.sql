

INSERT INTO person(first_name, last_name) values("Shirley", "Williams");
INSERT INTO person(first_name, last_name) values("Rico", "Medina");
INSERT INTO person(first_name, last_name) values("Robert", "Wright");
INSERT INTO person(first_name, last_name) values("Willie", "Demarco");
INSERT INTO person(first_name, last_name) values("David", "Ye");

INSERT INTO role(role_description)VALUES ("Tenant");
INSERT INTO role(role_description) VALUES("Employee");

INSERT INTO area(area_name) VALUES("Duck Creek Road");
INSERT INTO area(area_name) VALUES("Kuhl Avenue");
INSERT INTO area(area_name) VALUES("Hampton Meadows");

INSERT INTO house(house_no, area_id, house_name) VALUES ("1159", "1", "Lansing");
INSERT INTO house(house_no, area_id, house_name) VALUES ("3510", "2", "Huntsville");
INSERT INTO house(house_no, area_id, house_name) VALUES ("2045", "3", "Rochelle");

INSERT INTO apartment(apartment_no, house_id) VALUES(4, 2);
INSERT INTO apartment(apartment_no, house_id) VALUES(55, 1);
INSERT INTO apartment(apartment_no, house_id) VALUES(033, 3);