CREATE TABLE `Person` (
	`person_id` int NOT NULL,
	`first_name` varchar(200) NOT NULL,
	`last_name` varchar(200) NOT NULL,
	PRIMARY KEY (`person_id`)
);

CREATE TABLE `Request` (
	`request_id`  NOT NULL,
	`requester_id` int NOT NULL,
	`apartment_id` int NOT NULL,
	`description` mediumtext NOT NULL,
	`request_date` DATETIME NOT NULL,
	`status_id` int NOT NULL,
	`completion_date` DATE NOT NULL,
	`solver_id` int NOT NULL
);

CREATE TABLE `Person_request` (
	`person_request_id` int NOT NULL,
	`person_id`  NOT NULL,
	`request_id` int NOT NULL,
	PRIMARY KEY (`person_request_id`)
);

CREATE TABLE `Status` (
	`status_id` INT NOT NULL,
	`status_description` varchar NOT NULL,
	PRIMARY KEY (`status_id`)
);

CREATE TABLE `Person_role` (
	`person_role_id` int NOT NULL,
	`person_id`  NOT NULL,
	`role_id` int NOT NULL,
	PRIMARY KEY (`person_role_id`)
);

CREATE TABLE `Role` (
	`role_id`  NOT NULL,
	`role_description` varchar NOT NULL,
	PRIMARY KEY (`role_id`)
);

CREATE TABLE `Person_apartment` (
	`person_apartment_id` int NOT NULL,
	`person_id`  NOT NULL,
	`apartement_id` int NOT NULL,
	PRIMARY KEY (`person_apartment_id`)
);

CREATE TABLE `Apartment` (
	`apartment_id`  NOT NULL,
	`apartment_no` int NOT NULL,
	`house_id` int NOT NULL,
	PRIMARY KEY (`apartment_id`)
);

CREATE TABLE `House` (
	`house_id`  NOT NULL,
	`house_no` int NOT NULL,
	`area_id` int NOT NULL,
	`house_name` varchar NOT NULL,
	PRIMARY KEY (`house_id`)
);

CREATE TABLE `Area` (
	`area_id`  NOT NULL,
	`area_name` varchar NOT NULL,
	PRIMARY KEY (`area_id`)
);

ALTER TABLE `Request` ADD CONSTRAINT `Request_fk0` FOREIGN KEY (`request_id`) REFERENCES `Person_request`(`request_id`);

ALTER TABLE `Person_request` ADD CONSTRAINT `Person_request_fk0` FOREIGN KEY (`person_id`) REFERENCES `Person`(`person_id`);

ALTER TABLE `Status` ADD CONSTRAINT `Status_fk0` FOREIGN KEY (`status_id`) REFERENCES `Request`(`status_id`);

ALTER TABLE `Person_role` ADD CONSTRAINT `Person_role_fk0` FOREIGN KEY (`person_id`) REFERENCES `Person`(`person_id`);

ALTER TABLE `Role` ADD CONSTRAINT `Role_fk0` FOREIGN KEY (`role_id`) REFERENCES `Person_role`(`role_id`);

ALTER TABLE `Person_apartment` ADD CONSTRAINT `Person_apartment_fk0` FOREIGN KEY (`person_id`) REFERENCES `Person`(`person_id`);

ALTER TABLE `Apartment` ADD CONSTRAINT `Apartment_fk0` FOREIGN KEY (`apartment_id`) REFERENCES `Person_apartment`(`apartement_id`);

ALTER TABLE `House` ADD CONSTRAINT `House_fk0` FOREIGN KEY (`house_id`) REFERENCES `Apartment`(`house_id`);

ALTER TABLE `Area` ADD CONSTRAINT `Area_fk0` FOREIGN KEY (`area_id`) REFERENCES `House`(`area_id`);
