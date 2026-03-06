-- Initializing the tables;

drop table if exists users cascade;
drop table if exists orders cascade;
drop table if exists coffee cascade;
drop table if exists coffee_types cascade;
drop table if exists providers cascade;
drop table if exists adoptions cascade;
drop table if exists cats cascade;
drop table if exists cat_races cascade;
drop table if exists shelters cascade;
drop table if exists reservations cascade;
drop table if exists locations cascade;
drop table if exists cats_in_shelters cascade;
drop table if exists cats_in_locations cascade;
drop table if exists menu cascade;
drop table if exists food_type cascade;
drop table if exists locations_types cascade;

-- Declaring the tables;

create table users (
	id serial primary key,
	username varchar(50) unique not null,
	email varchar(100) unique not null,
	password varchar(50) not null,
	first_name varchar(50) not null,
	last_name varchar(50) not null,
	birth_date date not null,
	phone_number char(12) unique not null
);

create table orders (
	id serial primary key,
	user_id int not null,
	coffee_id int not null
);

create table coffee (
	id serial primary key,
	name varchar(50) unique not null,
	intensity int check (intensity <= 5 and intensity >= 1) not null,
	weight float check (weight > 0 and weight <= 5) not null,
	type_id int check (type_id >= 1 and type_id <= 5) not null,
	provider_id int check (provider_id >= 1 and provider_id <= 15) not null
);

create table coffee_types (
	id serial primary key,
	type varchar(50) not null
);

create table providers (
	id serial primary key,
	provider varchar(50) not null
);

create table adoptions (
	cat_id serial not null,
	user_id serial not null,
	constraint adoptions_pk primary key (cat_id)
);

create table cats (
	id serial primary key,
	name varchar(50) not null,
	race_id int check (race_id >= 1 and race_id <= 73) not null,
	isadopted int check (isadopted >= 0 and isadopted <= 1) not null
);

create table cat_races (
	id serial primary key,
	race varchar(50) not null
);

create table shelters (
	id serial primary key,
	address varchar(50) not null
);

create table reservations (
	id serial primary key,
	user_id int not null,
	location_id int not null,
	date date not null,
	time char(5) not null,
	reserved_seats int check (reserved_seats >= 1 and reserved_seats <= 10) not null
);

create table locations (
	id serial primary key,
	address varchar(50) not null,
	seats int check (seats >= 20 and seats <= 100) not null
);

create table cats_in_shelters (
	cat_id int not null,
	shelter_id int not null,
	constraint cats_in_shelters_pk primary key (cat_id)
);

create table cats_in_locations (
	cat_id int not null,
	location_id int not null,
	constraint cats_in_locations_pk primary key (cat_id)
);

create table menu (
	id serial primary key,
	name varchar(50) unique not null,
	price float check (price >= 0.99 and price <= 50) not null,
	type_id int not null
);

create table food_type (
	id serial primary key,
	name varchar(50) unique not null
);

create table locations_types (
	location_id int not null,
	type_id int not null,
	constraint locations_menu_pk primary key (location_id, type_id)
);

-- Adding their data

insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('wpulford0', 'wpulford0@gmail.com', 'rG1|v5q6_5y\gg.', 'Wait', 'Pulford', '8/7/1999', '506-343-9196');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('jyarrington1', 'jyarrington1@gmail.com', 'sN9<Xo=LQ''WVi9', 'Jared', 'Yarrington', '10/28/2004', '146-217-9267');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('cgillmore2', 'cgillmore2@gmail.com', 'pK7/O\.ang(6n%3e', 'Callida', 'Gillmore', '10/8/2006', '809-250-4810');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('rcorkish3', 'rcorkish3@gmail.com', 'oU0(Zt}e?q', 'Rubia', 'Corkish', '12/5/2001', '652-209-1485');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('egarnson4', 'egarnson4@gmail.com', 'eF4{yfkVvH|WZ7X', 'Estelle', 'Garnson', '1/1/2007', '332-960-4385');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('jmccrow5', 'jmccrow5@gmail.com', 'kK1(V)zwS', 'Jenilee', 'McCrow', '2/25/1999', '274-337-2673');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('gslopier6', 'gslopier6@gmail.com', 'bU8?gs80I(EO7=J#', 'Gerta', 'Slopier', '10/28/2002', '266-268-9872');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('spinnion7', 'spinnion7@gmail.com', 'iS9!M<245+0e3<x', 'Shayla', 'Pinnion', '8/8/2000', '718-857-3107');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('spharoah8', 'spharoah8@gmail.com', 'gM4(_b''8hQQsl', 'Sammy', 'Pharoah', '2/19/2005', '534-165-1990');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('jchitty9', 'jchitty9@gmail.com', 'dN6=h4\`j', 'Jesselyn', 'Chitty', '11/1/2005', '286-208-8372');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('cbrownliea', 'cbrownliea@gmail.com', 'cJ1=`,W''!I_)', 'Cob', 'Brownlie', '9/5/2006', '984-500-6467');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('jreveleyb', 'jreveleyb@gmail.com', 'mV4@gzPd''uq1', 'Joannes', 'Reveley', '12/4/2004', '348-117-2912');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('gmacaleesec', 'gmacaleesec@gmail.com', 'yU1,F,vWF!SMYWF', 'Gilligan', 'MacAleese', '6/9/2005', '617-355-0444');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('dpardid', 'dpardid@gmail.com', 'rC6=_`T<VfNze', 'Dell', 'Pardi', '10/13/2001', '791-988-1873');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('acentere', 'acentere@gmail.com', 'oN1((h#}B', 'Audi', 'Center', '2/23/1999', '760-434-0657');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('amedlarf', 'amedlarf@gmail.com', 'yP5$/D|ODg2', 'Armin', 'Medlar', '1/7/1999', '939-692-1104');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('gstubbertg', 'gstubbertg@gmail.com', 'iW5@_|Z''M', 'Gabriella', 'Stubbert', '10/13/2000', '241-943-3053');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('gminshallh', 'gminshallh@gmail.com', 'kY3\s)c|r9MG/\\', 'Geneva', 'Minshall', '10/11/2006', '859-711-6809');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('ncoverleyi', 'ncoverleyi@gmail.com', 'jB3$Kwr9~', 'Nixie', 'Coverley', '7/25/2001', '334-570-5112');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('ggouldthorpej', 'ggouldthorpej@gmail.com', 'gR8?n(RP>', 'Garvy', 'Gouldthorpe', '8/22/2002', '347-776-9538');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('bschiementzk', 'bschiementzk@gmail.com', 'kD6$w$Vf}Jro''5', 'Blakeley', 'Schiementz', '11/10/2001', '502-455-1225');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('nsomerliel', 'nsomerliel@gmail.com', 'pH4%77vl{+v13t', 'Neysa', 'Somerlie', '3/16/2006', '785-771-7361');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('mpavlenkom', 'mpavlenkom@gmail.com', 'mM8{&\c&|EVc', 'Moyra', 'Pavlenko', '3/3/2006', '362-782-6827');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('sbaxn', 'sbaxn@gmail.com', 'rC8}GRq>Fo', 'Sarah', 'Bax', '11/20/2000', '134-181-1496');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('gtsarovico', 'gtsarovico@gmail.com', 'fV9<ybC+#>', 'Genvieve', 'Tsarovic', '8/17/2000', '520-277-3770');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('tdevonaldp', 'tdevonaldp@gmail.com', 'hV0.y+q1=`', 'Timoteo', 'Devonald', '6/22/2000', '758-135-3024');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('lfawlteyq', 'lfawlteyq@gmail.com', 'xX1_ZTo/8|?X', 'Lillian', 'Fawltey', '4/18/2003', '160-309-1264');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('asapsforder', 'asapsforder@gmail.com', 'cJ1>"d_o(VwE', 'Annnora', 'Sapsforde', '2/9/2002', '683-384-6774');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('gwasielas', 'gwasielas@gmail.com', 'aM9_?@1@)DP', 'Garey', 'Wasiela', '5/17/2001', '468-495-4806');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('othomassett', 'othomassett@gmail.com', 'wC5+Eiw,IWdK', 'Oona', 'Thomasset', '12/14/2003', '490-963-8985');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('mrevelleu', 'mrevelleu@gmail.com', 'zW0(\gC>uVW_N', 'Modesta', 'Revelle', '6/5/2002', '400-324-2246');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('ejackmanv', 'ejackmanv@gmail.com', 'cD7%"_n"bDztb', 'Erich', 'Jackman', '5/7/2002', '743-221-2646');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('gskeldingew', 'gskeldingew@gmail.com', 'yB1@TkHLc3|?9ZGI', 'Guillaume', 'Skeldinge', '2/1/1999', '229-306-1501');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('fmabbsx', 'fmabbsx@gmail.com', 'wB1/h/`J+x', 'Franklyn', 'Mabbs', '7/21/2001', '646-640-8258');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('vhartmany', 'vhartmany@gmail.com', 'oP9}o)uH(', 'Valaree', 'Hartman', '8/8/2004', '240-872-0400');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('wsalterz', 'wsalterz@gmail.com', 'qG2''e+a3', 'Wilfred', 'Salter', '9/16/2006', '455-305-0908');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('kfreund10', 'kfreund10@gmail.com', 'vG0\v`\,!>#88.', 'Kathe', 'Freund', '12/5/2004', '481-283-2179');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('pcapoun11', 'pcapoun11@gmail.com', 'uU3%Zy##y?X4%U=V', 'Pepillo', 'Capoun', '8/17/2003', '430-767-8049');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('lsoper12', 'lsoper12@gmail.com', 'mX9*\RgVgbljt', 'Lexis', 'Soper', '2/24/2003', '742-164-8011');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('wbispham13', 'wbispham13@gmail.com', 'fO1_I<I3', 'Wernher', 'Bispham', '2/20/2002', '745-557-0614');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('elloyds14', 'elloyds14@gmail.com', 'uT3#7h9g', 'Edan', 'Lloyds', '4/4/2002', '195-773-0535');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('seversfield15', 'seversfield15@gmail.com', 'nK4~J4/_t1snAN#`', 'Sula', 'Eversfield', '1/30/2007', '416-661-9856');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('estillman16', 'estillman16@gmail.com', 'mC7#m_r|ji56', 'Edwin', 'Stillman', '12/7/2007', '818-216-5590');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('rnazair17', 'rnazair17@gmail.com', 'bM7''sMu+,', 'Robinette', 'Nazair', '4/7/2001', '875-734-7257');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('gdengel18', 'gdengel18@gmail.com', 'pD3''F!,yy', 'Georgeta', 'Dengel', '11/28/1999', '164-742-8893');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('skrolik19', 'skrolik19@gmail.com', 'zE3\B7ktTOm<71%', 'Stephi', 'Krolik', '10/1/2002', '528-229-8865');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('rfaich1a', 'rfaich1a@gmail.com', 'lK7<Qg?~$1', 'Rudolph', 'Faich', '6/7/2007', '892-412-7992');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('kdudgeon1b', 'kdudgeon1b@gmail.com', 'mZ1)zX+Zd5%', 'Kalie', 'Dudgeon', '4/4/2001', '603-136-1105');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('isantori1c', 'isantori1c@gmail.com', 'iG2{Q8w/hyX', 'Isa', 'Santori', '5/1/2004', '558-160-0334');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('ablemings1d', 'ablemings1d@gmail.com', 'lD6@!$9<aKmO', 'Amabelle', 'Blemings', '8/17/2006', '943-577-4998');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('dbasset1e', 'dbasset1e@gmail.com', 'hZ5%eSUt', 'Daffy', 'Basset', '5/10/2003', '687-138-1299');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('mpetyanin1f', 'mpetyanin1f@gmail.com', 'eU6+Mh$CXVJA', 'Morten', 'Petyanin', '6/5/2002', '939-882-0148');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('dwyvill1g', 'dwyvill1g@gmail.com', 'zG8>Z+{"<)!u', 'Donni', 'Wyvill', '8/20/1999', '676-767-4424');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('ndrew1h', 'ndrew1h@gmail.com', 'pA0$xu~n4eGpl>', 'Neel', 'Drew', '6/16/2001', '637-926-0745');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('kfindley1i', 'kfindley1i@gmail.com', 'qJ2`''Izlt', 'Karon', 'Findley', '8/19/2006', '210-612-2999');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('khazeldine1j', 'khazeldine1j@gmail.com', 'kC0!M42=&YzO', 'Kandy', 'Hazeldine', '2/15/2003', '921-589-9539');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('criccardini1k', 'criccardini1k@gmail.com', 'qO0&IdUVr', 'Chandal', 'Riccardini', '9/8/2000', '916-391-2951');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('wroly1l', 'wroly1l@gmail.com', 'bY3*D2rn', 'Wally', 'Roly', '4/9/2007', '669-795-4792');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('gbenedikt1m', 'gbenedikt1m@gmail.com', 'cJ3!Tb>$aK}_.mqB', 'Gardie', 'Benedikt', '7/14/2002', '438-383-0567');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('ebiasotti1n', 'ebiasotti1n@gmail.com', 'hX1)yxQr.|,31JEI', 'Esme', 'Biasotti', '7/30/2007', '953-676-9272');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('kcronchey1o', 'kcronchey1o@gmail.com', 'uY7''6g`Fxuu}6CV', 'Kort', 'Cronchey', '12/21/2007', '713-158-6339');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('eupcraft1p', 'eupcraft1p@gmail.com', 'eF8_=Oy8q9', 'Eloisa', 'Upcraft', '8/12/2004', '984-545-1117');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('bdimitrov1q', 'bdimitrov1q@gmail.com', 'dD8)msvQ<h\%PY}', 'Betty', 'Dimitrov', '8/19/2001', '169-960-5658');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('ivossgen1r', 'ivossgen1r@gmail.com', 'bV1{,+P2U%>', 'Idette', 'Vossgen', '1/25/2001', '336-277-5541');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('ceastment1s', 'ceastment1s@gmail.com', 'sG3|h~#1FC', 'Camey', 'Eastment', '11/21/2002', '451-653-8252');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('ajuschka1t', 'ajuschka1t@gmail.com', 'vL8|$PK+CyS?yn|', 'Annis', 'Juschka', '2/22/2005', '274-487-7766');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('jeasdon1u', 'jeasdon1u@gmail.com', 'dX5@\Nx(', 'Jacquette', 'Easdon', '8/27/2002', '317-769-6468');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('ugurrado1v', 'ugurrado1v@gmail.com', 'oF0$EMFTnJ', 'Ulric', 'Gurrado', '3/31/2002', '217-607-0462');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('kgoodlett1w', 'kgoodlett1w@gmail.com', 'wX5!r"DBy~b', 'Kristel', 'Goodlett', '9/11/1999', '381-105-4483');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('ocurrom1x', 'ocurrom1x@gmail.com', 'bV7@E|l%}X', 'Odella', 'Currom', '11/10/2004', '706-881-4533');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('bjoly1y', 'bjoly1y@gmail.com', 'oW4<G?gjmKYS6', 'Brit', 'Joly', '3/27/2003', '358-155-1234');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('dmilligan1z', 'dmilligan1z@gmail.com', 'sT2@5""c~9xvOGY"', 'Damara', 'Milligan', '12/10/2002', '837-751-4812');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('greveley20', 'greveley20@gmail.com', 'yV4_VY6cg~', 'Gino', 'Reveley', '1/30/2000', '505-966-2985');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('krude21', 'krude21@gmail.com', 'iN4>yQszS4te~aV', 'Korry', 'Rude', '9/17/2003', '753-859-3606');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('hrammell22', 'hrammell22@gmail.com', 'xV8''e|!d)''x{', 'Helsa', 'Rammell', '5/30/2000', '776-578-9005');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('tdundon23', 'tdundon23@gmail.com', 'xP4/lJ\6>k1q`a5', 'Tyne', 'Dundon', '8/22/2003', '102-938-8623');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('awhitehouse24', 'awhitehouse24@gmail.com', 'nS4<PhEt)MOw$>', 'Adriena', 'Whitehouse', '11/19/2002', '329-455-0446');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('stisor25', 'stisor25@gmail.com', 'aL4#Xa|NRb', 'Shaughn', 'Tisor', '12/3/1999', '501-149-0638');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('pbaly26', 'pbaly26@gmail.com', 'iX4{&"p<q"', 'Petronille', 'Baly', '4/17/2003', '169-751-3922');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('tlogue27', 'tlogue27@gmail.com', 'uZ1&J6.,.=/', 'Teodoro', 'Logue', '1/6/1999', '428-956-8397');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('olorne28', 'olorne28@gmail.com', 'xX7*k2i&5yxuJN$<', 'Obie', 'Lorne', '9/12/2006', '787-394-3687');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('ffolland29', 'ffolland29@gmail.com', 'iA6_Sh5hgggS', 'Flory', 'Folland', '8/31/2003', '382-204-3552');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('jlanaway2a', 'jlanaway2a@gmail.com', 'oX8(gDm$`,*/.', 'Joby', 'Lanaway', '7/20/2003', '983-837-7572');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('nspinks2b', 'nspinks2b@gmail.com', 'bF1)~\Dfl', 'Nanci', 'Spinks', '12/9/2007', '529-896-4509');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('cjurn2c', 'cjurn2c@gmail.com', 'nR1"KG7kG', 'Chanda', 'Jurn', '1/4/2001', '172-519-6504');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('fmackrell2d', 'fmackrell2d@gmail.com', 'lG0&1q71(', 'Frederica', 'Mackrell', '6/3/2000', '632-811-8157');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('wrubinov2e', 'wrubinov2e@gmail.com', 'uH3"ToQ\T', 'Winston', 'Rubinov', '7/2/2000', '331-147-0518');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('klamzed2f', 'klamzed2f@gmail.com', 'lE4{{#4<vuMq%R!p', 'Karine', 'Lamzed', '2/17/2005', '673-614-6370');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('sjirek2g', 'sjirek2g@gmail.com', 'xJ3$a}"yn<wdP', 'Shirleen', 'Jirek', '9/8/2007', '252-676-6101');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('hdabs2h', 'hdabs2h@gmail.com', 'pZ2<V!l4mmEo', 'Hershel', 'Dabs', '8/7/2001', '388-704-6520');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('btomes2i', 'btomes2i@gmail.com', 'yZ9>Tc*o0X\', 'Brandy', 'Tomes', '4/22/2000', '666-938-2449');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('teliff2j', 'teliff2j@gmail.com', 'uB7>$`R3i', 'Tressa', 'Eliff', '10/30/2001', '960-448-7134');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('delizabeth2k', 'delizabeth2k@gmail.com', 'mQ1?O=Fu', 'Darelle', 'Elizabeth', '2/24/2003', '656-252-1473');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('afeehely2l', 'afeehely2l@gmail.com', 'aO4.?tHl', 'Aylmar', 'Feehely', '7/8/1999', '442-209-1227');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('jcheatle2m', 'jcheatle2m@gmail.com', 'lX1,LRJE7', 'Jackie', 'Cheatle', '5/24/2002', '856-964-5804');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('cdallaway2n', 'cdallaway2n@gmail.com', 'mR1\((dAjU=?4ye', 'Cassi', 'Dallaway', '6/12/2003', '721-882-8346');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('sholstein2o', 'sholstein2o@gmail.com', 'dI2"tx$)~V\M+Igu', 'Starla', 'Holstein', '7/10/1999', '530-812-6602');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('cingliss2p', 'cingliss2p@gmail.com', 'hC5+%P*<{Q', 'Catherina', 'Ingliss', '8/6/2001', '410-467-1627');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('mhodge2q', 'mhodge2q@gmail.com', 'oL8{"_Bcs,@8pc{s', 'Mina', 'Hodge', '7/19/2007', '571-784-8558');
insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('wforsyde2r', 'wforsyde2r@gmail.com', 'pE4<*`<@?>', 'Willyt', 'Forsyde', '2/8/2002', '336-723-7416');


insert into orders (user_id, coffee_id) values (83, 25);
insert into orders (user_id, coffee_id) values (63, 47);
insert into orders (user_id, coffee_id) values (60, 33);
insert into orders (user_id, coffee_id) values (2, 29);
insert into orders (user_id, coffee_id) values (53, 35);
insert into orders (user_id, coffee_id) values (71, 1);
insert into orders (user_id, coffee_id) values (97, 26);
insert into orders (user_id, coffee_id) values (75, 28);
insert into orders (user_id, coffee_id) values (58, 9);
insert into orders (user_id, coffee_id) values (88, 46);
insert into orders (user_id, coffee_id) values (43, 37);
insert into orders (user_id, coffee_id) values (13, 48);
insert into orders (user_id, coffee_id) values (22, 6);
insert into orders (user_id, coffee_id) values (83, 46);
insert into orders (user_id, coffee_id) values (32, 7);
insert into orders (user_id, coffee_id) values (50, 45);
insert into orders (user_id, coffee_id) values (5, 20);
insert into orders (user_id, coffee_id) values (93, 49);
insert into orders (user_id, coffee_id) values (20, 24);
insert into orders (user_id, coffee_id) values (84, 23);
insert into orders (user_id, coffee_id) values (25, 42);
insert into orders (user_id, coffee_id) values (30, 7);
insert into orders (user_id, coffee_id) values (42, 34);
insert into orders (user_id, coffee_id) values (78, 20);
insert into orders (user_id, coffee_id) values (13, 47);
insert into orders (user_id, coffee_id) values (33, 33);
insert into orders (user_id, coffee_id) values (69, 29);
insert into orders (user_id, coffee_id) values (62, 42);
insert into orders (user_id, coffee_id) values (45, 3);
insert into orders (user_id, coffee_id) values (71, 27);
insert into orders (user_id, coffee_id) values (36, 47);
insert into orders (user_id, coffee_id) values (13, 23);
insert into orders (user_id, coffee_id) values (17, 34);
insert into orders (user_id, coffee_id) values (31, 12);
insert into orders (user_id, coffee_id) values (55, 38);
insert into orders (user_id, coffee_id) values (94, 46);
insert into orders (user_id, coffee_id) values (23, 32);
insert into orders (user_id, coffee_id) values (76, 26);
insert into orders (user_id, coffee_id) values (17, 36);
insert into orders (user_id, coffee_id) values (6, 42);
insert into orders (user_id, coffee_id) values (81, 1);
insert into orders (user_id, coffee_id) values (63, 32);
insert into orders (user_id, coffee_id) values (70, 40);
insert into orders (user_id, coffee_id) values (7, 3);
insert into orders (user_id, coffee_id) values (98, 22);
insert into orders (user_id, coffee_id) values (39, 32);
insert into orders (user_id, coffee_id) values (18, 40);
insert into orders (user_id, coffee_id) values (16, 7);
insert into orders (user_id, coffee_id) values (50, 7);
insert into orders (user_id, coffee_id) values (67, 45);



insert into coffee (name, intensity, weight, type_id, provider_id) values
('House Blend Medium', 3, 1.0, 2, 1),
('Dark Roast Espresso', 5, 0.5, 2, 1),
('Breakfast Blend', 2, 1.0, 2, 2),
('French Roast', 5, 1.0, 2, 2),
('Qualità Rossa', 4, 1.0, 5, 3),
('Qualità Oro', 3, 1.0, 2, 3),
('Intenso Capsules', 4, 0.25, 2, 4),
('Ristretto Capsules', 5, 0.25, 2, 4),
('Classico Ground', 3, 1.0, 2, 5),
('Intenso Dark Roast', 5, 1.0, 2, 5),
('Major Dickason''s Blend', 5, 1.5, 5, 6),
('Big Bang Medium Roast', 3, 1.0, 2, 6),
('Original Blend', 3, 1.0, 5, 7),
('Dark Roast Signature', 4, 1.0, 5, 7),
('Mocha Italia', 4, 1.0, 2, 8),
('Signature Blend', 3, 1.0, 2, 8),
('Caribou Blend', 3, 1.0, 2, 9),
('Daybreak Morning Blend', 2, 1.0, 2, 9),
('Classic Roast', 3, 1.2, 5, 10),
('Black Silk', 2, 1.0, 2, 10),
('Original Roast', 3, 1.2, 5, 11),
('Dark Roast Bold', 4, 1.0, 5, 11),
('Traditional Roast', 3, 1.0, 2, 12),
('Dark Royal Roast', 4, 1.0, 2, 12),
('Hair Bender', 4, 1.0, 2, 13),
('Holler Mountain', 3, 1.0, 2, 13),
('Three Africas', 3, 0.75, 2, 14),
('Bella Donovan', 4, 0.75, 2, 14),
('Valhalla Java', 5, 1.0, 5, 15),
('Dark Roast Extreme', 5, 2.0, 5, 15),
('Robusta Strong', 5, 1.0, 1, 10),
('Arabica Smooth', 2, 1.0, 2, 12),
('Liberica Rare', 4, 0.5, 3, 3),
('Excelsa Premium', 3, 0.75, 4, 5),
('Morning Energy Blend', 3, 1.5, 5, 7),
('Espresso Gold', 4, 1.0, 2, 8),
('Bold Kickstart', 5, 2.0, 1, 15),
('Silk Roast', 2, 1.0, 2, 11),
('Urban Dark', 4, 1.25, 5, 13),
('Mountain Reserve', 3, 1.5, 2, 9),
('Classic Robusta', 4, 2.0, 1, 10),
('Heritage Arabica', 3, 1.0, 2, 14),
('Island Liberica', 4, 0.6, 3, 5),
('Velvet Excelsa', 3, 0.8, 4, 6),
('Fusion Blend', 4, 1.0, 5, 1),
('Morning Glory', 2, 1.0, 2, 2),
('Night Owl Espresso', 5, 0.75, 2, 4),
('Balanced Roast', 3, 1.25, 5, 8),
('Pure Arabica Select', 3, 2.0, 2, 3);

insert into coffee_types (type) values
('Robusta'),
('Arabica'),
('Liberica'),
('Excelsa'),
('Robusta/Arabica');

INSERT INTO providers (provider) VALUES
('Starbucks'),
('Dunkin'''),
('Lavazza'),
('Nespresso'),
('Illy'),
('Peet''s Coffee'),
('Tim Hortons'),
('Costa Coffee'),
('Caribou Coffee'),
('Folgers'),
('Maxwell House'),
('Gevalia'),
('Stumptown Coffee Roasters'),
('Blue Bottle Coffee'),
('Death Wish Coffee');

INSERT INTO cat_races (race) VALUES
('Abyssinian'),
('Aegean'),
('American Bobtail'),
('American Curl'),
('American Shorthair'),
('American Wirehair'),
('Australian Mist'),
('Balinese'),
('Bambino'),
('Bengal'),
('Birman'),
('Bombay'),
('Brazilian Shorthair'),
('British Longhair'),
('British Shorthair'),
('Burmese'),
('Burmilla'),
('California Spangled'),
('Chantilly-Tiffany'),
('Chartreux'),
('Chausie'),
('Cheetoh'),
('Colorpoint Shorthair'),
('Cornish Rex'),
('Cymric'),
('Devon Rex'),
('Donskoy'),
('Dragon Li'),
('Egyptian Mau'),
('European Shorthair'),
('Exotic Shorthair'),
('Foldex'),
('Foreign White'),
('German Rex'),
('Havana Brown'),
('Highlander'),
('Himalayan'),
('Japanese Bobtail'),
('Javanese'),
('Korat'),
('Kurilian Bobtail'),
('LaPerm'),
('Maine Coon'),
('Manx'),
('Mau Egyptian'),
('Munchkin'),
('Nebelung'),
('Norwegian Forest Cat'),
('Ocicat'),
('Ojos Azules'),
('Oriental Bicolour'),
('Oriental Longhair'),
('Oriental Shorthair'),
('Persian'),
('Peterbald'),
('Pixiebob'),
('Ragamuffin'),
('Ragdoll'),
('Russian Blue'),
('Savannah'),
('Scottish Fold'),
('Selkirk Rex'),
('Siamese'),
('Siberian'),
('Singapura'),
('Snowshoe'),
('Somali'),
('Sphynx'),
('Tonkinese'),
('Toyger'),
('Turkish Angora'),
('Turkish Van'),
('York Chocolate');

insert into cats (name, race_id, isadopted) values
('Luna', 12, 0),
('Milo', 34, 0),
('Oliver', 7, 1),
('Leo', 55, 0),
('Bella', 22, 0),
('Charlie', 61, 0),
('Lucy', 18, 0),
('Max', 43, 0),
('Chloe', 9, 0),
('Simba', 71, 0),
('Nala', 5, 1),
('Jack', 29, 0),
('Loki', 66, 0),
('Sophie', 14, 0),
('Oreo', 38, 0),
('Daisy', 27, 0),
('Jasper', 52, 0),
('Misty', 3, 0),
('Shadow', 60, 1),
('Cleo', 20, 0),
('Rocky', 48, 0),
('Lilly', 31, 0),
('Felix', 69, 0),
('Rosie', 16, 0),
('Tiger', 41, 0),
('Willow', 6, 0),
('Oscar', 57, 0),
('Mochi', 25, 1),
('Pepper', 63, 0),
('Boots', 11, 0),
('Zoe', 36, 0),
('Toby', 45, 0),
('Millie', 19, 0),
('Apollo', 72, 0),
('Pumpkin', 28, 0),
('Athena', 4, 0),
('Gizmo', 59, 0),
('Hazel', 13, 0),
('Bandit', 67, 1),
('Penny', 24, 0),
('Bruno', 53, 0),
('Coco', 8, 0),
('Finn', 64, 0),
('Ruby', 33, 0),
('Buster', 47, 0),
('Maple', 17, 0),
('Thor', 70, 0),
('Olive', 2, 0),
('Louie', 40, 0),
('Snowball', 21, 0),
('Archie', 58, 0),
('Nova', 10, 1),
('Benji', 50, 0),
('Ivy', 15, 0),
('Marble', 35, 0),
('Dexter', 62, 0),
('Sasha', 26, 0),
('Blue', 68, 0),
('Theo', 44, 0),
('Peaches', 23, 0),
('Riley', 54, 0),
('Mango', 1, 1),
('Sammy', 49, 0),
('Layla', 30, 0),
('Hunter', 65, 0),
('Skye', 32, 0),
('George', 56, 0),
('Nico', 37, 0),
('Freya', 42, 1),
('Zeus', 73, 0),
('Honey', 39, 0),
('Ace', 46, 0),
('Lola', 51, 0),
('Murphy', 34, 0),
('Pixie', 18, 0),
('Rex', 7, 1),
('Echo', 27, 0),
('Mocha', 61, 0),
('Sunny', 12, 0),
('Comet', 22, 0),
('Biscuit', 47, 0),
('Nyx', 5, 0),
('Copper', 66, 1),
('Almond', 31, 0),
('Stormy', 14, 0);

insert into adoptions (cat_id, user_id) values
(3, 10),
(11, 16),
(19, 51),
(28, 3),
(39, 78),
(52, 91),
(62, 48),
(69, 27),
(76, 77),
(83, 61);

insert into shelters (id, address) values (1, '9 Arrowood Avenue');
insert into shelters (id, address) values (2, '5785 Hollow Ridge Pass');
insert into shelters (id, address) values (3, '6 Maple Avenue');
insert into shelters (id, address) values (4, '85613 Canary Lane');
insert into shelters (id, address) values (5, '350 Alpine Place');
insert into shelters (id, address) values (6, '568 Forster Avenue');
insert into shelters (id, address) values (7, '6429 International Point');
insert into shelters (id, address) values (8, '75976 Superior Crossing');
insert into shelters (id, address) values (9, '43750 Forest Run Place');
insert into shelters (id, address) values (10, '2511 Hermina Junction');
insert into shelters (id, address) values (11, '2 Dennis Lane');
insert into shelters (id, address) values (12, '990 Harper Way');
insert into shelters (id, address) values (13, '121 Fisk Drive');
insert into shelters (id, address) values (14, '9384 Meadow Valley Alley');
insert into shelters (id, address) values (15, '2009 Express Junction');

insert into locations (id, address, seats) values (1, '75347 Del Sol Place', 50);
insert into locations (id, address, seats) values (2, '7983 Arkansas Crossing', 30);
insert into locations (id, address, seats) values (3, '25421 Commercial Pass', 40);
insert into locations (id, address, seats) values (4, '49 Golf View Park', 20);
insert into locations (id, address, seats) values (5, '7957 Del Mar Crossing', 25);
insert into locations (id, address, seats) values (6, '345 Muir Pass', 20);
insert into locations (id, address, seats) values (7, '58 Ohio Court', 100);
insert into locations (id, address, seats) values (8, '708 Garrison Center', 30);
insert into locations (id, address, seats) values (9, '7646 Aberg Lane', 25);
insert into locations (id, address, seats) values (10, '90263 Sycamore Way', 35);

insert into cats_in_locations (cat_id, location_id) values
(1, 4),
(2, 7),
(4, 2),
(5, 9),
(6, 1),
(7, 6),
(8, 3),
(9, 8),
(10, 5),
(12, 10),
(13, 2),
(14, 7),
(15, 4),
(16, 1),
(17, 9),
(18, 6),
(20, 3),
(21, 8),
(22, 5),
(23, 10),
(24, 2),
(25, 7),
(26, 4),
(27, 1),
(29, 6),
(30, 9),
(31, 3),
(32, 8),
(33, 5),
(34, 10),
(35, 2),
(36, 7),
(37, 4),
(38, 1),
(40, 6),
(41, 9),
(42, 3),
(43, 8),
(44, 5),
(45, 10),
(46, 2),
(47, 7),
(48, 4),
(49, 1),
(50, 6),
(51, 9),
(53, 3),
(54, 8),
(55, 5),
(56, 10),
(57, 2),
(58, 7),
(59, 4),
(60, 1),
(61, 6),
(63, 9),
(64, 3),
(65, 8),
(66, 5),
(67, 10),
(68, 2),
(70, 7),
(71, 4),
(72, 1),
(73, 6),
(74, 9),
(75, 3),
(77, 8),
(78, 5),
(79, 10),
(80, 2),
(81, 7),
(82, 4),
(84, 1),
(85, 6);

insert into cats_in_shelters (cat_id, shelter_id) values
(1, 5),
(2, 12),
(4, 3),
(5, 9),
(6, 1),
(7, 14),
(8, 6),
(9, 10),
(10, 2),
(12, 15),
(13, 4),
(14, 8),
(15, 11),
(16, 7),
(17, 13),
(18, 5),
(20, 9),
(21, 1),
(22, 14),
(23, 6),
(24, 10),
(25, 2),
(26, 15),
(27, 4),
(29, 8),
(30, 11),
(31, 7),
(32, 13),
(33, 5),
(34, 9),
(35, 1),
(36, 14),
(37, 6),
(38, 10),
(40, 2),
(41, 15),
(42, 4),
(43, 8),
(44, 11),
(45, 7),
(46, 13),
(47, 5),
(48, 9),
(49, 1),
(50, 14),
(51, 6),
(53, 10),
(54, 2),
(55, 15),
(56, 4),
(57, 8),
(58, 11),
(59, 7),
(60, 13),
(61, 5),
(63, 9),
(64, 1),
(65, 14),
(66, 6),
(67, 10),
(68, 2),
(70, 15),
(71, 4),
(72, 8),
(73, 11),
(74, 7),
(75, 13),
(77, 5),
(78, 9),
(79, 1),
(80, 14),
(81, 6),
(82, 10),
(84, 2),
(85, 15);

insert into reservations (user_id, location_id, date, time, reserved_seats) values (16, 2, '12/18/2025', '16:30', 4);
insert into reservations (user_id, location_id, date, time, reserved_seats) values (11, 9, '11/6/2025', '15:40', 2);
insert into reservations (user_id, location_id, date, time, reserved_seats) values (99, 2, '12/24/2025', '11:10', 6);
insert into reservations (user_id, location_id, date, time, reserved_seats) values (18, 4, '5/1/2025', '17:30', 5);
insert into reservations (user_id, location_id, date, time, reserved_seats) values (77, 8, '1/29/2026', '19:10', 8);
insert into reservations (user_id, location_id, date, time, reserved_seats) values (72, 10, '2/12/2026', '12:00', 3);
insert into reservations (user_id, location_id, date, time, reserved_seats) values (45, 4, '1/12/2026', '10:30', 2);
insert into reservations (user_id, location_id, date, time, reserved_seats) values (21, 10, '9/16/2025', '10:30', 7);
insert into reservations (user_id, location_id, date, time, reserved_seats) values (96, 7, '6/26/2025', '15:00', 4);
insert into reservations (user_id, location_id, date, time, reserved_seats) values (23, 5, '5/5/2025', '13:00', 6);
insert into reservations (user_id, location_id, date, time, reserved_seats) values (38, 3, '2/25/2025', '9:50', 1);
insert into reservations (user_id, location_id, date, time, reserved_seats) values (17, 4, '6/19/2025', '10:45', 3);
insert into reservations (user_id, location_id, date, time, reserved_seats) values (11, 9, '11/24/2025', '10:00', 5);
insert into reservations (user_id, location_id, date, time, reserved_seats) values (77, 7, '1/11/2026', '17:10', 4);
insert into reservations (user_id, location_id, date, time, reserved_seats) values (77, 2, '7/23/2025', '11:40', 2);
insert into reservations (user_id, location_id, date, time, reserved_seats) values (79, 2, '3/10/2025', '15:11', 6);
insert into reservations (user_id, location_id, date, time, reserved_seats) values (99, 6, '1/8/2026', '14:40', 8);
insert into reservations (user_id, location_id, date, time, reserved_seats) values (67, 9, '6/28/2025', '14:00', 3);
insert into reservations (user_id, location_id, date, time, reserved_seats) values (62, 2, '7/2/2025', '18:00', 5);
insert into reservations (user_id, location_id, date, time, reserved_seats) values (30, 10, '9/28/2025', '18:20', 9);
insert into reservations (user_id, location_id, date, time, reserved_seats) values (55, 2, '12/20/2025', '11:20', 4);
insert into reservations (user_id, location_id, date, time, reserved_seats) values (79, 6, '12/18/2025', '11:50', 2);
insert into reservations (user_id, location_id, date, time, reserved_seats) values (10, 10, '3/10/2025', '12:50', 6);
insert into reservations (user_id, location_id, date, time, reserved_seats) values (43, 4, '11/28/2025', '17:10', 7);
insert into reservations (user_id, location_id, date, time, reserved_seats) values (59, 3, '9/4/2025', '15:10', 3);
insert into reservations (user_id, location_id, date, time, reserved_seats) values (81, 7, '9/20/2025', '11:50', 4);
insert into reservations (user_id, location_id, date, time, reserved_seats) values (100, 7, '3/20/2025', '19:00', 10);
insert into reservations (user_id, location_id, date, time, reserved_seats) values (82, 7, '8/26/2025', '11:30', 2);
insert into reservations (user_id, location_id, date, time, reserved_seats) values (79, 5, '5/18/2025', '14:10', 6);
insert into reservations (user_id, location_id, date, time, reserved_seats) values (4, 4, '5/25/2025', '08:00', 1);

insert into menu (name, price, type_id) values
('Espresso', 9.99, 1),
('Double Espresso', 11.99, 1),
('Americano', 10.99, 1),
('Caffe Latte', 14.99, 1),
('Cappuccino', 12.99, 1),
('Flat White', 14.99, 1),
('Caffe Mocha', 16.99, 1),
('Macchiato', 12.99, 1),
('Irish Coffee', 21.99, 1),
('Cold Brew', 16.99, 1),
('Vanilla Latte', 15.99, 2),
('Caramel Latte', 16.99, 2),
('Hazelnut Latte', 16.99, 2),
('Pumpkin Spice Latte', 17.99, 2),
('White Chocolate Mocha', 18.99, 2),
('Affogato', 13.99, 2),
('Black Tea', 8.99, 3),
('Green Tea', 8.99, 3),
('Mint Tea', 8.99, 3),
('Chamomile Tea', 8.99, 3),
('Fruit Tea', 8.99, 3),
('Chai Latte', 13.99, 3),
('Matcha Latte', 17.99, 3),
('Classic Hot Chocolate', 13.99, 4),
('White Hot Chocolate', 14.99, 4),
('Hazelnut Hot Chocolate', 15.99, 4),
('Still Water 0.5L', 5.99, 5),
('Sparkling Water 0.5L', 5.99, 5),
('Fresh Orange Juice', 13.99, 5),
('Apple Juice', 9.99, 5),
('Classic Lemonade', 11.99, 5),
('Mint Lemonade', 12.99, 5),
('Lemon Iced Tea', 8.99, 5),
('Strawberry Smoothie', 17.99, 6),
('Mango Smoothie', 18.99, 6),
('Banana Peanut Butter Smoothie', 19.99, 6),
('Berry Smoothie', 18.99, 6),
('Plain Croissant', 7.99, 7),
('Butter Croissant', 8.99, 7),
('Chocolate Croissant', 9.99, 7),
('Pain au Chocolat', 9.99, 7),
('Blueberry Muffin', 8.99, 7),
('Chocolate Muffin', 8.99, 7),
('Lemon Pound Cake', 8.99, 7),
('Cheesecake', 15.99, 8),
('Raspberry Cheesecake', 16.99, 8),
('Chocolate Cake', 18.99, 8),
('Tiramisu', 17.99, 8),
('Carrot Cake', 14.99, 8),
('Brownie', 13.99, 8),
('Brownie with Ice Cream', 18.99, 8),
('Toast with Butter and Jam', 10.99, 9),
('Avocado Toast', 17.99, 9),
('Eggs Benedict', 23.99, 9),
('Plain Omelette', 13.99, 9),
('Cheese Omelette', 15.99, 9),
('Ham Omelette', 16.99, 9),
('English Breakfast', 31.99, 9),
('Ham and Cheese Sandwich', 17.99, 10),
('Chicken Sandwich', 19.99, 10),
('Vegetarian Sandwich', 16.99, 10),
('Mozzarella Panini', 18.99, 10),
('Prosciutto Panini', 20.99, 10),
('Caesar Salad', 25.99, 11),
('Chicken Caesar Salad', 28.99, 11),
('Greek Salad', 23.99, 11),
('Tuna Salad', 26.99, 11),
('Pretzels', 4.99, 12),
('Homemade Cookies', 5.99, 12),
('Potato Chips', 6.99, 12),
('Mixed Nuts', 9.99, 12),
('Beer 0.33L', 9.99, 13),
('Craft Beer', 15.99, 13),
('White Wine (Glass)', 17.99, 13),
('Red Wine (Glass)', 17.99, 13),
('Prosecco (Glass)', 19.99, 13),
('Aperol Spritz', 24.99, 13);

insert into food_type (name) values
('Coffee'),
('Specialty Coffee'),
('Tea'),
('Hot Chocolate'),
('Soft Drinks'),
('Smoothies'),
('Pastry & Bakery'),
('Cakes & Desserts'),
('Breakfast'),
('Sandwiches'),
('Salads'),
('Snacks'),
('Alcohol');

insert into locations_types (location_id, type_id) values
(4, 1), 
(4, 3), 
(6, 1),
(6, 3),
(6, 9),
(5, 1),
(5, 3),
(5, 9),
(5, 7), 
(9, 1),
(9, 3),
(9, 9),
(9, 7),
(9, 12),
(2, 1),
(2, 2),  
(2, 3),
(2, 7),
(2, 9),
(2, 12),
(8, 1),
(8, 2),
(8, 3),
(8, 5),  
(8, 7),
(8, 9),
(8, 12),
(10, 1),
(10, 2),
(10, 3),
(10, 5),
(10, 6), 
(10, 7),
(10, 9),
(10, 12),
(3, 1),
(3, 2),
(3, 3),
(3, 5),
(3, 6),
(3, 7),
(3, 8), 
(3, 9),
(3, 12),
(1, 1),
(1, 2),
(1, 3),
(1, 5),
(1, 6),
(1, 7),
(1, 8),
(1, 9),
(1, 10), 
(1, 11),
(1, 12),
(7, 1),
(7, 2),
(7, 3),
(7, 4), 
(7, 5),
(7, 6),
(7, 7),
(7, 8),
(7, 9),
(7, 10),
(7, 11),
(7, 12),
(7, 13); 

-- Add foreign constraints

alter table orders add constraint orders_users_fk foreign key (user_id) references users(id);
alter table orders add constraint orders_coffee_fk foreign key (coffee_id) references coffee(id);
alter table coffee add constraint coffee_coffee_types_fk foreign key (type_id) references coffee_types(id);
alter table coffee add constraint coffee_provider_fk foreign key (provider_id) references providers(id);
alter table adoptions add constraint adoptions_cats_fk foreign key (cat_id) references cats(id);
alter table adoptions add constraint adoptions_users_fk foreign key (user_id) references users(id);
alter table cats add constraint cats_cat_races_fk foreign key (race_id) references cat_races(id);
alter table reservations add constraint reservations_users_fk foreign key (user_id) references users(id);
alter table reservations add constraint reservations_locations_fk foreign key (location_id) references locations(id);
alter table cats_in_locations add constraint cats_in_locations_cats_fk foreign key (cat_id) references cats(id);
alter table cats_in_locations add constraint cats_in_locations_locations_fk foreign key (location_id) references locations(id);
alter table cats_in_shelters add constraint cats_in_shelters_cats_fk foreign key (cat_id) references cats(id);
alter table cats_in_shelters add constraint cats_in_shelters_shelters_fk foreign key (shelter_id) references shelters(id);
alter table menu add constraint menu_types_fk foreign key (type_id) references food_type(id);
alter table locations_types add constraint locations_type_locations_fk foreign key (location_id) references locations(id);
alter table locations_types add constraint locations_type_type_fk foreign key (type_id) references food_type(id);
