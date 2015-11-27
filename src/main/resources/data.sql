-- roles
insert into role (role_key, name) values ('admin', 'Administrator');

-- employees
insert into employee (name, surname, gender, username, street, city, zipcode, role_id, social_security_number)
	values ('Max', 'Mustermann', 'MALE', 'max', 'Teststrasse 1', 'Wien', '1010', (select id from role where role_key = 'admin'), '12345');

-- rooms
insert into room (name, maxpersons, price_sr)
	values ('101', 1, 19.90);

insert into room (name, maxpersons, price_sr, price_dr, price_sr_one_child)
	values ('102', 2, 21.50, 29.90, 25.90);

insert into room (name, maxpersons, price_sr, price_dr, price_tr, price_sr_one_child, price_sr_two_children)
	values ('103', 3, 21.90, 30.50, 36.20, 25.60, 27.30);

--insert into room (name, maxpersons, price_sr, price_dr, price_tr, price_sr_one_child, price_sr_two_children, price_dr_one_child)
--	values ();

--insert into room (name, maxpersons, price_sr, price_dr, price_tr, price_sr_one_child, price_sr_two_children, price_dr_one_child)
--	values ();

--insert into room (name, maxpersons, price_sr, price_dr, price_tr, price_sr_one_child, price_sr_two_children, price_dr_one_child)
--	values ();
