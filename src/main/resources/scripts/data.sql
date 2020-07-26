insert into dateofbirth (age, dob)
values
(44,'1976-07-24 18:47:52.69'),
(45,'1975-04-17 18:47:52.69'),
(46,'1975-02-17 18:47:52.69');

insert into location (street, city, state, postcode)
values
('House 133 Anand Nagar','bhopal','MP',46201),
('LIG 34 Javahar bus stand','Bhopal','MP',46201),
('House No 321 Defence Colony','Gwalior','MP',43201);

insert into login (username, password, uuid)
values
('sunil1976','123','5ebcb1ff-4a41-4a4b-8f08-2b3d143b1b45'),
('san1975','123','9fabf853-396e-478d-aabe-f660a58a5f08'),
('amit001','123','64afb80f-03ad-4f90-9ffe-3495db287cc2');

insert into profile (first_name  , last_name , middle_name , gender, phone , cell , email , date_of_birth_id , location_id , login_id)
values
('sunil','rai',null,'MALE','(+91)-9826130000','(+91)-9826130000','sunilrai@gmail.com',1,1,1),
('sanjeev','gupta',null,'MALE','(+91)-9525130000','(+91)-9525130000','sanjeevgupta@gmail.com',2,2,2),
('amit','yadav',null,'MALE','(+91)-9424130000','(+91)-9424130000','amityadav@gmail.com',3,3,3);