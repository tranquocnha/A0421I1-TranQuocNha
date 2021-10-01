create database QuanLyBanHang;
use QuanLyBanHang;
create table Custormer(
cID varchar(255) primary key,
cName varchar(255) not null,
cAge int not null check(cAge >=18)
);

create table Product(
pID int auto_increment primary key,
pName varchar(255) not null,
pPrice float not null check(pPrice >0)
);

create table OrderProduct(
oID int auto_increment primary key,
pID int,
oDate datetime not null,
oTotalPrice float not null check(oTotalPrice>0),
foreign key (pID) references Product(pID)
);

create table OrderDetail(
oID int,
pID int,
odQTY int not null check(odQTY >=1),
foreign key (oID) references OrderProduct(oID),
foreign key (pID) references Product(pID)
);