create database quan_ly_furama;
use quan_ly_furama;

create table vi_tri(
id_vi_tri int auto_increment primary key,
ten_vi_tri varchar(45) not null
);

create table trinh_do(
id_trinh_do int auto_increment primary key,
trinh_do varchar(45) not null
);

create table bo_phan(
id_bo_phan int auto_increment primary key,
ten_bo_phan varchar(45) not null
);

create table nhan_vien(
id_nhan_vien int auto_increment primary key,
ho_ten varchar(45) not null,
id_vi_tri int,
id_trinh_do int,
id_bo_phan int,
ngay_sinh date not null,
so_cnnd varchar(45) not null,
luong varchar(45) not null,
sdt varchar(45),
email varchar(45),
dia_chi varchar(45),
foreign key (id_vi_tri) references vi_tri(id_vi_tri),
foreign key (id_trinh_do) references trinh_do(id_trinh_do),
foreign key (id_bo_phan) references bo_phan(id_bo_phan)
);

create table loai_khach(
id_loai_khach int auto_increment primary key,
ten_loai_khach varchar(45) not null
);

create table khach_hang(
id_khach_hang int auto_increment primary key,
id_loai_khach int,
ho_ten varchar(45) not null,
ngay_sinh date,
so_cnnd varchar(45) not null,
sdt varchar(45),
email varchar(45),
dia_chi varchar(45),
foreign key (id_loai_khach) references loai_khach(id_loai_khach)
);

create table kieu_thue(
id_kieu_thue int auto_increment primary key,
ten_kieu_thue varchar(45) not null,
gia int check(gia>=0)
);

create table loai_dich_vu(
id_loai_dich_vu int auto_increment primary key,
ten_loai_dich_vu varchar(45) not null
);

create table dich_vu(
id_dich_vu int auto_increment primary key,
ten_dich_vu varchar(45) not null,
dien_tich int check(dien_tich>0),
so_tang int  check(so_tang>0),
so_nguoi_toi_da int ,
chi_phi_thue int  check(chi_phi_thue>0),
id_kieu_thue int not null,
id_loai_dich_vu int not null,
trang_thai varchar(45),
foreign key(id_kieu_thue) references kieu_thue(id_kieu_thue),
foreign key(id_loai_dich_vu) references loai_dich_vu(id_loai_dich_vu)
);

create table hop_dong(
id_hop_dong int auto_increment primary key,
id_nhan_vien int not null,
id_khach_hang int not null,
id_dich_vu int not null,
ngay_lam_hop_dong date not null,
ngay_ket_thuc date not null,
tien_dat_coc int  check(tien_dat_coc>=0),
tong_tien int check(tong_tien>0),
foreign key(id_nhan_vien) references nhan_vien(id_nhan_vien),
foreign key(id_khach_hang) references khach_hang(id_khach_hang),
foreign key(id_dich_vu) references dich_vu(id_dich_vu)
);

create table dich_vu_di_kem(
id_dich_vu_di_kem int auto_increment primary key,
ten_dich_vu_di_kem varchar(45) not null,
gia int  check(Gia>0),
don_vi int check(don_vi>0),
trang_thai_kha_dung varchar(45)
);

create table hop_dong_chi_tiet(
id_hop_dong_chi_tiet int auto_increment primary key,
id_hop_dong int not null,
id_dich_vu_di_kem int not null,
so_luong int,
foreign key(id_hop_dong) references hop_dong(id_hop_dong),
foreign key(id_dich_vu_di_kem) references dich_vu_di_kem(id_dich_vu_di_kem)
);

-- task1: th??m th??ng tin cho t???t c??? c??c b???ng --

insert into vi_tri
values
(1,'l??? t??n'),
(2,'ph???c v???'),
(3,'chuy??n vi??n'),
(4,'gi??m s??t'),
(5,'qu???n l??'),
(6,'gi??m ?????c');

insert into trinh_do
values
(1,'trung c???p'),
(2,'cao ?????ng'),
(3,'?????i h???c'),
(4,'sau ?????i h???c');

insert into bo_phan
values
(1,'Sale ??? Marketing'),
(2,'H??nh Ch??nh'),
(3,'Ph???c v???'),
(4,'Qu???n l??');

insert into nhan_vien
values
(1,'Tr???n Qu???c Nh??',6,4,2,'1978-02-12',206184291,50000000,0905345432,'tranquocnha@gmail.com','???? N???ng'),
(2,'Nguy???n V??n A',1,1,1,'1999-12-12',206764234,5000000,090534345,'nguyena@gmail.com','???? N???ng'),
(3,'Nguy???n V??n An',1,1,3,'1988-04-13',206184291,5000000,0905768796,'vanan@gmail.com','Qu???ng Nam'),
(4,'Nguy???n Trung H???u',2,3,4,'1995-02-12',206184291,10000000,0905453657,'trunghau@gmail.com','???? N???ng'),
(5,'Phan Thanh To??n',2,3,1,'1989-02-09',206915647,10000000,0909452456,'thanhtoan@gmail.com','H??? Ch?? Minh'),
(6,'Nguy???n ?????c v????ng',3,3,2,'1991-12-17',202914563,20000000,0905567345,'duocvuong@gmail.com','H?? N???i'),
(7,'Nguy???n ?????c Nam',3,3,1,'1988-02-12',206566914,20000000,09055467846,'ducnam@gmail.com','Hai Ph??ng'),
(8,'Nguy???n Ph???m Qu???c Huy',4,4,4,'1978-02-12',206184291,50000000,0905345432,'quochuy@gmail.com','???? N???ng'),
(9,'T?? ?????ng',6,4,2,'1978-02-18',20657478,30000000,0935678567,'tudang@gmail.com','???? N???ng'),
(10,'S??n L?? Tr???n',5,4,1,'1990-02-12',20656465,40000000,0905345768,'letran@gmail.com','Qu???ng Nam');

insert into loai_khach
values
(1,'Diamond'),
(2,'Platinium'),
(3,'Gold'),
(4,'Silver'),
(5,'Member');	

insert into khach_hang
values
(1,2,'Nguy???n ??o??n','1989-02-09','234345345','090543454','nguyendoan@gmail.com','Hai Phong'),
(2,3,'Nguy???n Anh','1991-12-17','223445398','095643457','nguyenanh@gmail.com','Qu???ng B??nh'),
(3,1,'L?? H??ng','1990-02-12','342345456','0906456756','hung@gmail.com','Hai D????ng'),
(4,4,'??o??n L??nh','1978-02-12','234345665','0935678767','doanlinhgmail.com','???? N???ng'),
(5,5,'T?? L??m','1995-02-12','323454345','090542546','tolam@gmail.com','H?? N???i');

insert into loai_dich_vu
values
(1,'Villa'),
(2,'House'),
(3,'Room');

insert into kieu_thue
values
(1,'n??m',90000000),
(2,'th??ng',1200000),
(3,'ng??y',2000000),
(4,'gi???',200000);

insert into dich_vu
values
(1,'thu?? view bi???n villa',200,2,'12',5000000,3,1,'t???t nh???t'),
(2,'thu?? view bi???n house',100,2,'9',4000000,3,2,'t???t nh???t'),
(3,'thu?? view bi???n room',30,2,'3',3000000,3,3,'t???t nh???t'),
(4,'thu?? view trung t??m villa',200,2,'12',4000000,3,1,'t???t nh???t'),
(5,'thu?? view trung t??m house',100,2,'9',3000000,3,2,'t???t nh???t'),
(6,'thu?? view trung t??m room',30,2,'3',2000000,3,3,'t???t nh???t');

insert into hop_dong
values
(1,2,1,1,'2020-12-12','2021-01-02',3000000,5000000),
(2,3,4,2,'2021-01-12','2021-01-20',400000,7000000),
(3,6,3,4,'2020-03-12','2021-03-22',5000000,10000000);

insert into dich_vu_di_kem
values
(1,'massage',500000,1,'ho??n th??nh'),
(2,'karaoke',400000,1,'m???t gi???'),
(3,'th???c ??n',100000,1,'m???t kh???u ph???n'),
(4,'n?????c u???ng',20000,1,'chai'),
(5,'thu?? xe di chuy???n tham quan resort',1000000,1,'tour');

insert into hop_dong_chi_tiet
values
(1,1,2,3),
(2,2,1,2),
(3,3,4,2);