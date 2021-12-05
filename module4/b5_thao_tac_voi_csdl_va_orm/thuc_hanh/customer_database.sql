create database cms;
use cms;
create table `customer` (
id int auto_increment primary key,
`name` varchar(45),
email varchar(255),
address varchar(45)
);

insert into customer
values
(1,	'Nha','luytlong@gmail.com','da nang');

