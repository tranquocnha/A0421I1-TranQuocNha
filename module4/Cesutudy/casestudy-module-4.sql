use casestudy_module4;

insert into `role`
values
(1,'CUSTOMER'),
(2,'EMPLOYEE');

insert into `user`
values
('trunghau','123456'),
('quocnha','123456'),
('minhnhat','123456'),
('congquang','123456'),
('namvuong','123456'),
('vantu','123456'),
('congtung','123456'),
('minhhuy','123456'),
('cuuhuy','123456'),
('ducthang','123456');

insert into `position`
values
(1,'Lễ tân'),
(2,'phục vụ'),
(3,'chuyên viên'),
(4,'giám sát'),
(5,'quản lý'),
(6,'giám đốc');

insert into `education_degree`
values
(1,'Trung cấp'),
(2,'Cao đẳng'),
(3,'Đại học'),
(4,'Sau đại học');

insert into `division`
values
(1,'Sale – Marketing'),
(2,'Hành Chính'),
(3,'Phục vụ'),
(4,'Quản lý');

insert into `employee`
values
(1,'daklak','16/03/2000','trunghau@gmail.com','123123123','Trung Hau','0123456789','10000000',4,4,5,'trunghau'),
(2,'quang nam','16/03/2000','quocnha@gmail.com','123123123','Quoc Nha','0123456789','7000000',1,2,3,'quocnha'),
(3,'quang binh','16/03/2000','minhnhat@gmail.com','123123123','Minh Nhat','0123456789','5000000',2,2,2,'minhnhat'),
(4,'quang ngai','16/03/2000','congquang@gmail.com','123123123','Cong Quang','0123456789','15000000',3,4,6,'congquang'),
(5,'quang tri','16/03/2000','namvuong@gmail.com','123123123','Nam Vuong','0123456789','10000000',1,3,5,'namvuong'),
(6,'gia lai','16/03/2000','vantu@gmail.com','123123123','Van Tu','0123456789','7000000',3,4,3,'vantu'),
(7,'kon tum','16/03/2000','congtung@gmail.com','123123123','Cong Tung','0123456789','8000000',3,3,4,'congtung'),
(8,'hue','16/03/2000','minhhuy@gmail.com','123123123','Minh Huy','0123456789','7000000',2,4,3,'minhhuy'),
(9,'da nang','16/03/2000','cuuhuy@gmail.com','123123123','Cuu Huy','0123456789','7000000',1,2,3,'cuuhuy'),
(10,'daklak','16/03/2000','ducthang@gmail.com','123123123','Duc Thang','0123456789','5000000',2,3,1,'ducthang');

insert into `customer_type`
values
(1,'Diamond'),
(2,'Platinium'),
(3,'Gold'),
(4,'Silver'),
(5,'Member');

insert into `customer`
values
(1,'daklak','16/03/2000','trunghau@gmail.com','nam','123123123','Trung Hau','0123456789',1),
(2,'quang nam','16/03/2000','quocnha@gmail.com','nam','123123123','Quoc Nha','0123456789',1),
(3,'quang binh','16/03/2000','minhnhat@gmail.com','nam','123123123','Minh Nhat','0123456789',2),
(4,'quang ngai','16/03/2000','congquang@gmail.com','nam','123123123','Cong Quang','0123456789',3),
(5,'quang tri','16/03/2000','namvuong@gmail.com','nam','123123123','Nam Vuong','0123456789',1),
(6,'gia lai','16/03/2000','vantu@gmail.com','nam','123123123','Van Tu','0123456789',3),
(7,'kon tum','16/03/2000','congtung@gmail.com','nam','123123123','Cong Tung','0123456789',3),
(8,'hue','16/03/2000','minhhuy@gmail.com','nam','123123123','Minh Huy','0123456789',2),
(9,'da nang','16/03/2000','cuuhuy@gmail.com','nam','123123123','Cuu Huy','0123456789',1),
(10,'daklak','16/03/2000','ducthang@gmail.com','nam','123123123','Duc Thang','0123456789',2);

insert into attach_service
values
(1,500000,'massage','hoàn thành',1),
(2,400000,'karaoke','một giờ',1),
(3,100000,'thức ăn','một khẩu phần',1),
(4,20000,'nước uống','chai',1),
(5,1000000,'thuê xe di chuyển tham quan resort','tour',1);

insert into service_type
values
(1,'Villa'),
(2,'House'),
(3,'Room');

insert into rent_type
values
(1,90000000,'năm'),
(2,1200000,'tháng'),
(3,2000000,'ngày'),
(4,200000,'giờ');

insert into service
values
(1,'thuê view biển villa',2,300,300,5000000,10,'thuê view biển villa','tốt nhất',3,1),
(2,'thuê view biển house',1,150,100,4000000,8,'thuê view biển house','tốt nhất',2,2),
(3,'thuê view biển room',1,70,70,3000000,6,'thuê view biển room','tốt nhất',4,3),
(4,'thuê view trung tâm villa',2,200,200,4000000,8,'thuê view trung tâm villa','tốt nhất',3,1),
(5,'thuê view trung tâm house',1,100,100,3000000,6,'thuê view trung tâm house','tốt nhất',2,2),
(6,'thuê view trung tâm room',1,50,50,2000000,4,'thuê view trung tâm room','tốt nhất',3,3);

insert into contract
values
(1,3000000,'2020-12-12','2021-01-02',5000000,1,2,3),
(2,400000,'2021-01-12','2021-01-20',7000000,2,5,5),
(3,5000000,'2020-03-12','2021-03-22',10000000,6,6,6);

insert into contract_detail
values
(1,1,2,3),
(2,2,1,2),
(3,3,4,2);
