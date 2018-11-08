CREATE DATABASE requesthandling;

USE requesthandling;



CREATE TABLE person(
person_id int AUTO_INCREMENT PRIMARY KEY, 
first_name varchar(60) NOT NULL,
last_name varchar(100) NOT NULL
);

CREATE TABLE role(
role_id int AUTO_INCREMENT PRIMARY KEY,
role_description varchar(20) NOT NULL
);

/*renamed table area to district*/
CREATE TABLE district(
district_id int AUTO_INCREMENT PRIMARY KEY, 
district_name varchar(100)
);

CREATE TABLE house(
house_id int AUTO_INCREMENT PRIMARY KEY, 
house_no varchar(5) NOT NULL,
district_id int NOT NULL,
house_address varchar(100),
CONSTRAINT fk_house_district
		FOREIGN KEY(district_id) REFERENCES district(district_id)
		ON DELETE CASCADE
		ON UPDATE RESTRICT
);

CREATE TABLE apartment(
apartment_id int AUTO_INCREMENT PRIMARY KEY, 
apartment_no int NOT NULL,
house_id int NOT NULL, 
CONSTRAINT fk_apartment_house
	FOREIGN KEY(house_id) REFERENCES house(house_id)
    ON DELETE CASCADE
	ON UPDATE RESTRICT
);

CREATE TABLE person_apartment(
person_apartment_id int AUTO_INCREMENT PRIMARY KEY, 
person_id int NOT NULL,
apartment_id int NOT NULL,
CONSTRAINT fk_person_apartment_person
	FOREIGN KEY(person_id) REFERENCES person(person_id),
    /*TODO add on delete cascade and on update restrict?*/
CONSTRAINT fk_person_apartment_apartment
	FOREIGN KEY(apartment_id) REFERENCES apartment(apartment_id)
    /*TODO add on delete cascade and on update restrict?*/
);


CREATE TABLE person_role(
person_role_id int AUTO_INCREMENT PRIMARY KEY, 
person_id int NOT NULL,
role_id int NOT NULL,
CONSTRAINT fk_person_role_person
	FOREIGN KEY(person_id) REFERENCES person(person_id)
    ON UPDATE RESTRICT,
CONSTRAINT fk_person_role_role
	FOREIGN KEY(role_id) REFERENCES role(role_id)
    ON UPDATE RESTRICT
);

CREATE TABLE status(
status_id int AUTO_INCREMENT PRIMARY KEY,
status_description varchar(20) NOT NULL
);

CREATE TABLE request(
request_id int AUTO_INCREMENT PRIMARY KEY, 
requester_id int NOT NULL,
apartment_id int NOT NULL,
request_description mediumtext NOT NULL,
request_date datetime NOT NULL,
status_id int NOT NULL DEFAULT 1,
completion_date datetime,
resolver_id int,
CONSTRAINT fk_request_tenant
	FOREIGN KEY(requester_id) REFERENCES person_request(person_id)
    ON UPDATE RESTRICT,
CONSTRAINT fk_request_employee
	FOREIGN KEY(resolver_id) REFERENCES person_request(person_id),
CONSTRAINT fk_request_apartment
	FOREIGN KEY(apartment_id) REFERENCES apartment(apartment_id)
    ON UPDATE RESTRICT,
CONSTRAINT fk_request_status
	FOREIGN KEY(status_id) REFERENCES status(status_id)
    ON UPDATE RESTRICT
);

/* Table removed - no longer in use
CREATE TABLE person_request(
person_request_id int AUTO_INCREMENT PRIMARY KEY, 
person_id int NOT NULL,
request_id int NOT NULL,
FOREIGN KEY(person_id) REFERENCES person(person_id),
FOREIGN KEY(request_id) REFERENCES request(request_id)
);
*/

SHOW TABLES;