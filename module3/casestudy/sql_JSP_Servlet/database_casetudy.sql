create database casestudy_jsp_and_servlet;
use casestudy_jsp_and_servlet;
create table `position` (
position_id int auto_increment primary key,
position_name varchar(45)
);
create table education_degree (
education_degree_id int auto_increment primary key,
education_degree_name varchar(45)
);
create table division (
division_id int auto_increment primary key,
division_name varchar(45)
);
create table `role` (
role_id int auto_increment primary key,
role_name varchar(255)
);
create table `user` (
user_name varchar(255) primary key,
`password` varchar(255)
);
create table user_role (
role_id int,
user_name varchar(255),
primary key (role_id,user_name),
foreign key(role_id) references `role`(role_id) on delete cascade on update cascade,
foreign key(user_name) references `user`(user_name) on delete cascade on update cascade
);
create table employee (
employee_id int auto_increment primary key,
employee_name varchar(45),
employee_birthday date,
employee_id_card varchar(45),
employee_salary double,
employee_phone varchar(45),
employee_email varchar(45),
employee_address varchar(45),
position_id int,foreign key(position_id) references `position` (position_id) on delete cascade on update cascade,
education_degree_id int,foreign key(education_degree_id) references education_degree (education_degree_id) on delete cascade on update cascade,
division_id int,foreign key(division_id) references division (division_id) on delete cascade on update cascade,
user_name varchar(255),foreign key(user_name) references `user` (user_name) on delete cascade on update cascade
);
create table customer_type (
customer_type_id int auto_increment primary key,
customer_type_name varchar(45)
);
create table customer (
customer_id int auto_increment primary key,
customer_code varchar(45),
customer_name varchar(45),
customer_birthday date,
customer_gender varchar(45),
customer_id_card varchar(45),
customer_phone varchar(45),
customer_email varchar(45),
customer_address varchar(45),
customer_type_id int,
 foreign key(customer_type_id) references customer_type (customer_type_id) on delete cascade on update cascade
);
create table service_type (
service_type_id int auto_increment primary key,
service_type_name varchar(45)
);
create table rent_type (
rent_type_id int auto_increment primary key,
rent_type_name varchar(45),
rent_type_cost double
);
create table service (
service_id int auto_increment primary key,
service_code varchar(45),
service_name varchar(45),
service_area int,
service_cost double,
service_max_people int,
standard_room varchar(45),
description_other_convenience varchar(45),
pool_area double,
number_of_floors int,
service_type_id int,foreign key(service_type_id) references service_type (service_type_id) on delete cascade on update cascade,
rent_type_id int,foreign key(rent_type_id) references rent_type (rent_type_id) on delete cascade on update cascade
);
create table contract (
contract_id int auto_increment primary key,
contract_start_date date,
contract_end_date date,
contract_deposit double,
contract_total_money double,
employee_id int,foreign key(employee_id) references employee (employee_id) on delete cascade on update cascade,
customer_id int,foreign key(customer_id) references customer (customer_id) on delete cascade on update cascade,
service_id int,foreign key(service_id) references service (service_id) on delete cascade on update cascade
);
create table attach_service (
attach_service_id int auto_increment primary key,
attach_service_name varchar(45),
attach_service_cost double,
attach_service_unit int,
attach_service_status varchar(45)
);
create table contract_detail (
contract_detail_id int auto_increment primary key,
contract_id int,foreign key(contract_id) references contract (contract_id) on delete cascade on update cascade,
attach_service_id int,foreign key(attach_service_id) references attach_service (attach_service_id) on delete cascade on update cascade,
quantity int
);


insert into customer
values
(1,	'KH-1001','Nguyễn Đoàn','1989-02-09','nam',	'234345345'	,'090543454','nguyendoan@gmail.com','Hai Phong',2),
(2,	'KH-1002',	'Nguyễn Anh',	'1991-12-17',	'nam',	'223445398',	'095643457'	,'nguyenanh@gmail.com'	,'Quảng Bình',	3),
(3,	'KH-1003',	'Lê Hùng',	'1990-02-12',	'nam',	'342345456',	'0906456756'	,'hung@gmail.com'	,'Hai Dương'	,1),
(4,	'KH-1004',	'Đoàn Lĩnh',	'1978-02-12',	'nam'	,'234345665'	,'0935678767'	,'doanlinhgmail.com',	'Đà Nẵng',	4),
(5,	'KH-1005',	'Tô Lâm',	'1995-02-12','nam',	'323454345',	'090542546'	,'tolam@gmail.com'	,'Hà Nội',	5),
(6,'KH-1006',	'Tran Quoc Nha',	'2000-07-18','nam','24211211894'	,'0965184565',	'tranquocnha@gmail.com'	,'Da Nang',	1);

