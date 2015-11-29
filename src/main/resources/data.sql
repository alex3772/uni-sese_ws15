-- roles
insert into role (role_key, name) values ('admin', 'Administrator');
insert into role (role_key, name) values ('customer', 'Customer');

-- employees
insert into employee (name, surname, gender, username, password, street, city, zipcode, role_id, social_security_number)
	values ('Max', 'Mustermann', 'MALE', 'max', '9baf3a40312f39849f46dad1040f2f039f1cffa1238c41e9db675315cfad39b6', 'Teststrasse 1',
		'Wien', '1010', (select id from role where role_key = 'admin'), '12345');

-- customer
insert into customer (name, surname, gender, username, password, street, city, zipcode)
	values ('Max', 'Mustermann', 'MALE', 'max', 'pwd', 'Teststrasse 1',
		'Wien', '1010');
		
-- rooms
insert into room (name, maxpersons, price_sr)
	values ('101', 1, 19.90);

insert into room (name, maxpersons, price_sr, price_dr, price_sr_one_child)
	values ('102', 2, 21.50, 29.90, 25.90);
	
insert into room (name, maxpersons, price_sr, price_dr, price_sr_one_child)
	values ('103', 2, 21.50, 29.90, 25.90);

insert into room (name, maxpersons, price_sr, price_dr, price_tr, price_sr_one_child, price_sr_two_children)
	values ('104', 3, 21.90, 30.50, 36.20, 25.60, 27.30);

--insert into room (name, maxpersons, price_sr, price_dr, price_tr, price_sr_one_child, price_sr_two_children, price_dr_one_child)
--	values ();

--insert into room (name, maxpersons, price_sr, price_dr, price_tr, price_sr_one_child, price_sr_two_children, price_dr_one_child)
--	values ();

--insert into room (name, maxpersons, price_sr, price_dr, price_tr, price_sr_one_child, price_sr_two_children, price_dr_one_child)
--	values ();

-- reservations
insert into reservation (checkin, checkout, price, customer_id, room_id)
	values ('12/12/2001', '12/12/2002', 132, (select id from customer where username = 'max'), (select id from room where name = '101'));
	
insert into reservation (checkin, checkout, price, customer_id, room_id)
	values ('12/12/2001', '12/12/2002', 132, (select id from customer where username = 'max'), (select id from room where name = '102'));