insert into role (role_key, name) values ('admin', 'Administrator');

insert into employee (name, surname, gender, username, street, city, zipcode, role_id, social_security_number)
	values ('Max', 'Mustermann', 'MALE', 'max', 'Teststrasse 1', 'Wien', '1010', (select id from role where role_key = 'admin'), '12345');
	
insert into room (name, maxPersons)
	values ('Zimmer name', 123);
	
insert into room (name, maxPersons)
values ('Zimmer 2', 123);
