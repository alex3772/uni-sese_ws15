insert into role (role_key, name) values ('admin', 'Administrator');

insert into employee (name, surname, gender, street, city, zipcode, role_id, initial, social_security_number)
	values ('Max', 'Mustermann', 'MALE', 'Teststrasse 1', 'Wien', '1010', (select id from role where role_key = 'admin'), 'mustermann', '12345');
