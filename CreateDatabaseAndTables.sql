CREATE DATABASE requesthandling;

USE requesthandling;



CREATE TABLE person(
person_id int AUTO_INCREMENT PRIMARY KEY, 
first_name varchar(60) NOT NULL,
last_name varchar(100) NOT NULL
);

CREATE TABLE role(
role_id int AUTO_INCREMENT PRIMARY KEY,
role_description varchar(40) NOT NULL
);

CREATE TABLE area(
area_id int AUTO_INCREMENT PRIMARY KEY, 
area_name varchar(100)
);

CREATE TABLE house(
house_id int AUTO_INCREMENT PRIMARY KEY, 
house_no varchar(5) NOT NULL,
area_id int NOT NULL,
house_name varchar(100),
FOREIGN KEY(area_id) REFERENCES area(area_id)
);

CREATE TABLE apartment(
apartment_id int AUTO_INCREMENT PRIMARY KEY, 
apartment_no int NOT NULL,
house_id int /*NOT NULL*/
/*, FOREIGN KEY(house_id) REFERENCES house(house_id)*/
);

CREATE TABLE person_apartment(
person_apartment_id int AUTO_INCREMENT PRIMARY KEY, 
person_id int NOT NULL,
apartment_id int NOT NULL,
FOREIGN KEY(person_id) REFERENCES person(person_id),
FOREIGN KEY(apartment_id) REFERENCES apartment(apartment_id)
);

CREATE TABLE person_role(
person_role_id int AUTO_INCREMENT PRIMARY KEY, 
person_id int NOT NULL,
role_id int NOT NULL,
FOREIGN KEY(person_id) REFERENCES person(person_id),
FOREIGN KEY(role_id) REFERENCES role(role_id)
);

CREATE TABLE status(
status_id int AUTO_INCREMENT PRIMARY KEY,
status_description varchar(20) NOT NULL
);

CREATE TABLE request(
request_id int AUTO_INCREMENT PRIMARY KEY, 
/*requester_id int NOT NULL,*/
apartment_id int NOT NULL,
request_description mediumtext NOT NULL,
request_date datetime NOT NULL,
status_id int NOT NULL,
completion_date datetime,
/*solver_id int,*/
/*FOREIGN KEY(requester_id) REFERENCES person_request(person_id),*/
FOREIGN KEY(apartment_id) REFERENCES apartment(apartment_id),
FOREIGN KEY(status_id) REFERENCES status(status_id)
);

CREATE TABLE person_request(
person_request_id int AUTO_INCREMENT PRIMARY KEY, 
person_id int NOT NULL,
request_id int NOT NULL,
FOREIGN KEY(person_id) REFERENCES person(person_id),
FOREIGN KEY(request_id) REFERENCES request(request_id)
);

SHOW TABLES;