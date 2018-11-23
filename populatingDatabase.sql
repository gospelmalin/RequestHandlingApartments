use requesthandling;

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

INSERT INTO district(district_name) VALUES("Duck Creek");
INSERT INTO district(district_name) VALUES("The Forest");
INSERT INTO district(district_name) VALUES("Hampton Meadows");

INSERT INTO house(house_no, district_id, house_address) VALUES ("10A", "1", "Duck Creek Road");
INSERT INTO house(house_no, district_id, house_address) VALUES ("3510", "2", "Greater Forest Road");
INSERT INTO house(house_no, district_id, house_address) VALUES ("2045", "3", "Rochelle street");

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
 ('Not started'), ('In progress'), ('Completed');
 
 select * from person p left outer join person_apartment pa
on pa.person_id=p.person_id
left outer join apartment a
on a.apartment_id=pa.apartment_id
order by a.house_id, a.apartment_no;

select * from person p inner join person_apartment pa
on pa.person_id=p.person_id
inner join apartment a
on a.apartment_id=pa.apartment_id
order by a.house_id, a.apartment_no;

select * from person p inner join person_apartment pa
on pa.person_id=p.person_id
inner join apartment a
on a.apartment_id=pa.apartment_id
inner join house h
on h.house_id = a.house_id
order by a.house_id, a.apartment_no;

select * from apartment;

select * from request;

select * from status;

SELECT 
	r.request_id AS 'Request id',
	CONCAT(t.first_name, ' ', t.last_name) AS 'Reported by',
	r.request_date AS "Date reported",
    h.house_address AS "Address",
    h.house_no AS "House number",
	a.apartment_no AS "Apartment",
	d.district_name AS "District",
	r.request_description AS "Description",
	s.status_description AS "Status",
	r.completion_date AS "Date completed",
	CONCAT(e.first_name,' ' , e.last_name) AS "Completed by"
FROM 
	request r INNER JOIN person t
		ON t.person_id = r.requester_id
	INNER JOIN apartment a
		ON a.apartment_id=r.apartment_id
	INNER JOIN house h
		ON h.house_id = a.house_id
	INNER JOIN district d
		ON d.district_id=h.district_id
	INNER JOIN status s
		ON s.status_id=r.status_id
	LEFT OUTER JOIN person e
		ON e.person_id=r.resolver_id
ORDER BY r.request_id, r.apartment_id;

select * from request;


select * FROM 
	request r INNER JOIN person t
		ON t.person_id = r.requester_id
	INNER JOIN apartment a
		ON a.apartment_id=r.apartment_id
	INNER JOIN house h
		ON h.house_id = a.house_id
	INNER JOIN district d
		ON d.district_id=h.district_id
	INNER JOIN status s
		ON s.status_id=r.status_id
	LEFT OUTER JOIN person e
		ON e.person_id=r.resolver_id
ORDER BY r.request_id, r.apartment_id;

insert into request(
	requester_id,
	apartment_id, 
    request_description, 
    request_date, 
    status_id, 
    completion_date,
    resolver_id
    )
	values(
    2,
    2, 
    'No water in kitchen', 
    '2018-11-04', 
    3, 
    '2018-11-05',
    13
    );
    
    insert into request(
	requester_id,
	apartment_id, 
    request_description, 
    request_date, 
    status_id
    )
	values(
    1,
    1, 
    'Door broken', 
    '2018-11-08', 
    14
    );
    
    insert into request(
	requester_id,
	apartment_id, 
    request_description, 
    request_date, 
    status_id
    )
	values(
    6,
    6, 
    'Door more broken', 
    '2018-11-08', 
    13
    );