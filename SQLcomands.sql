INSERT INTO person(first_name, last_name) values("Shirley", "Williams");
INSERT INTO person(first_name, last_name) values("Rico", "Medina");
INSERT INTO person(first_name, last_name) values("Robert", "Wright");
INSERT INTO person(first_name, last_name) values("Willie", "Demarco");
INSERT INTO person(first_name, last_name) values("David", "Ye");
INSERT INTO person(first_name, last_name) values("Miriam", "Shell");
INSERT INTO person(first_name, last_name) values("John", "Parker");
INSERT INTO person(first_name, last_name) values("Max", "Power");
INSERT INTO person(first_name, last_name) values("Cameron", "Delae");
INSERT INTO person(first_name, last_name) values("Carlos", "Hernandez");
INSERT INTO person(first_name, last_name) values("Emma", "Satori");
INSERT INTO person(first_name, last_name) values("Mayra", "Martinez");

INSERT INTO person(first_name, last_name) values("Juan", "Perez");
INSERT INTO person(first_name, last_name) values("Emil", "Lund");

INSERT INTO role(role_description)VALUES ("Tenant");
INSERT INTO role(role_description) VALUES("Employee");

INSERT INTO area(area_name) VALUES("Duck Creek Road");
INSERT INTO area(area_name) VALUES("Kuhl Avenue");
INSERT INTO area(area_name) VALUES("Hampton Meadows");

INSERT INTO house(house_no, area_id, house_name) VALUES ("1159", "1", "Lansing");
INSERT INTO house(house_no, area_id, house_name) VALUES ("3510", "2", "Huntsville");
INSERT INTO house(house_no, area_id, house_name) VALUES ("2045", "3", "Rochelle");

INSERT INTO apartment(apartment_no, house_id) VALUES(15, 1);
INSERT INTO apartment(apartment_no, house_id) VALUES(25, 1);
INSERT INTO apartment(apartment_no, house_id) VALUES(35, 1);
INSERT INTO apartment(apartment_no, house_id) VALUES(45, 1);

INSERT INTO apartment(apartment_no, house_id) VALUES(4, 2);
INSERT INTO apartment(apartment_no, house_id) VALUES(5, 2);
INSERT INTO apartment(apartment_no, house_id) VALUES(6, 2);
INSERT INTO apartment(apartment_no, house_id) VALUES(7, 2);

INSERT INTO apartment(apartment_no, house_id) VALUES(031, 3);
INSERT INTO apartment(apartment_no, house_id) VALUES(032, 3);
INSERT INTO apartment(apartment_no, house_id) VALUES(033, 3);
INSERT INTO apartment(apartment_no, house_id) VALUES(034, 3);

INSERT INTO person_apartment(person_id, apartment_id) VALUES(1, 1);
INSERT INTO person_apartment(person_id, apartment_id) VALUES(2, 2);
INSERT INTO person_apartment(person_id, apartment_id) VALUES(3, 3);
INSERT INTO person_apartment(person_id, apartment_id) VALUES(4, 4);
INSERT INTO person_apartment(person_id, apartment_id) VALUES(5, 5);
INSERT INTO person_apartment(person_id, apartment_id) VALUES(6, 6);
INSERT INTO person_apartment(person_id, apartment_id) VALUES(7, 7);
INSERT INTO person_apartment(person_id, apartment_id) VALUES(8, 8);
INSERT INTO person_apartment(person_id, apartment_id) VALUES(9, 9);
INSERT INTO person_apartment(person_id, apartment_id) VALUES(10, 10);
INSERT INTO person_apartment(person_id, apartment_id) VALUES(11, 11);
INSERT INTO person_apartment(person_id, apartment_id) VALUES(12, 12);

INSERT INTO person_role(person_id, role_id) VALUES(1, 1);
INSERT INTO person_role(person_id, role_id) VALUES(2, 1);
INSERT INTO person_role(person_id, role_id) VALUES(3, 1);
INSERT INTO person_role(person_id, role_id) VALUES(4, 1);
INSERT INTO person_role(person_id, role_id) VALUES(5, 1);
INSERT INTO person_role(person_id, role_id) VALUES(6, 1);
INSERT INTO person_role(person_id, role_id) VALUES(7, 1);
INSERT INTO person_role(person_id, role_id) VALUES(8, 1);
INSERT INTO person_role(person_id, role_id) VALUES(9, 1);
INSERT INTO person_role(person_id, role_id) VALUES(10, 1);
INSERT INTO person_role(person_id, role_id) VALUES(11, 1);
INSERT INTO person_role(person_id, role_id) VALUES(12, 1);
INSERT INTO person_role(person_id, role_id) VALUES(13, 2);
INSERT INTO person_role(person_id, role_id) VALUES(14, 2);



INSERT INTO status(
status_description) VALUES
 ('not completed'), ('completed');

