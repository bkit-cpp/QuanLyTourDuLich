create database TOURDULICH4

use TOURDULICH4

create table VE
(
  MAVE int not null PRIMARY KEY,
  NGAYTAO date NOT NULL,
  MAKH int not null,
  MADVTOUR int not null,
  GIA int not null,
  MANV INT NOT NULL
)

create table CHIETTINHTOUR
(
  MADVTOUR int not null primary key,
  MAKS int ,
  MANH int ,
  MALOTRINH int not null,
  GIAKS int ,
  GIANH int ,
  GIADVTOUR int not null,
  GHICHU nvarchar(255),
  MANV INT NOT NULL
)

create table TOURMOBAN
(
 MADVTOUR int not null primary key,
 LOAITOUR nvarchar(255) not null,
 TENDVTOUR nvarchar(355) not null,
 THOIGIAN nvarchar(255) not null,
 TRANGTHAI nvarchar(255) not null,
 GIADAILY int not null,
 GIAKHACHLE int not null,
 SOCHO int not null,
 NGAYKHOIHANH date not null
)

create table TOURSANPHAM
(
 MADVTOUR int not null primary key,
 LOAITOUR nvarchar(255) not null,
 TENDVTOUR nvarchar(355) not null,
 THOIGIAN nvarchar(255) not null,
 TRANGTHAI nvarchar(255) not null,
 LOAIHINHTOUR nvarchar(255) not null,
 booking int
)

create table LOTRINH
(
 MADVTOUR int not null primary key,
 GIODI nvarchar(255) not null,
 NGAYDI nvarchar(255) not null,
 GIOVE nvarchar(255) not null,
 NGAYVE nvarchar(255) not null,
 DIEMDON nvarchar(255) not null,
 DIEMDEN nvarchar(255) not null
)

create table KHACHHANG
(
 MAKH int not null primary key,
 TENKH nvarchar(255) not null, 
 GIOITINH nvarchar(4) not null,
 NGAYSINH date not null,
 SODT int not null,
 DIACHI nvarchar(355)
)

create table NHANVIEN
(
 MANV int not null primary key,
 TENNV nvarchar(255) not null,
 NGAYSINH date not null,
 GIOITINH nvarchar(4) not null,
 SODT int not null, 
 DIACHI nvarchar(355) not null,
 TRANGTHAI NVARCHAR(50) NOT NULL,
 CHUCVU nvarchar(255) not null
)

create table NGUOIDUNG
(
 MANV int not null primary key,
 TAIKHOAN nvarchar(255) not null,
 MATKHAU nvarchar(255) not null,
 EMAIL nvarchar(255)
)

create table QUYENQUANLY
(
  MAQUYENQL int not null primary key,
  MANV int not null,
  TENQUYENQL nvarchar(255) not null
)

create table NHAHANG
(
 MANH int not null primary key,
 TENNH nvarchar(255) not null,
 MANCC int not null,
 GIA int not null
)

create table NHACUNGCAP
(
  MANCC int not null primary key,
  TENCC nvarchar(355) not null,
  SODT int not null,
  TRANGTHAI NVARCHAR(50) NOT NULL,
  DIACHI nvarchar(355)
)

create table KHACHSAN
(
  MAKS int not null primary key,
  LOAIHINHKS nvarchar(100) not null,
  TENKS nvarchar(255) not null,
  MANCC int not null,
  LOAIPHONG nvarchar(50),
  GIA int not null
)

create table DOANHTHU
(
 MADVTOUR int not null primary key,
 TENKH nvarchar(255) not null,
 DOANHTHU int not null
)



create table MAXMA (
 ma int not null primary key,
 matourmoban int not null,
 matoursanpham int not null,
 maks int not null,
 manh int not null,
 mave int not null,
 makh int not null
)


insert into MAXMA values (1, 30005, 40005, 10000, 9000, 600000, 100000)

--KHOA NGOAI NHA HANG
alter table NHAHANG add constraint FK_NHAHANG foreign key (MANCC) references NHACUNGCAP(MANCC)

--KHOA NGOAI KHACH SAN
alter table KHACHSAN add constraint FK_KHACHSAN foreign key (MANCC) references NHACUNGCAP(MANCC)

--KHOA NGOAI CUA CHIETTINHTOUR
--alter table CHIETTINHTOUR add constraint FK_CHIETTINH foreign key (MAKS) references KHACHSAN(MAKS)
--alter table CHIETTINHTOUR add constraint FK_CHIETTINH1 foreign key (MANH) references NHAHANG(MANH)

--alter table CHIETTINHTOUR add constraint FK_CHIETTINH2 foreign key (MADVTOUR) references TOURSANPHAM(MADVTOUR)
--alter table CHIETTINHTOUR add constraint FK_CHIETTINH3 foreign key (MADVTOUR) references TOURMOBAN(MADVTOUR)

alter table CHIETTINHTOUR add constraint FK_CHIETTINH4 foreign key (MANV) references NHANVIEN(MANV)

-- KHOA NGOAI CUA VE
alter table VE add constraint FK_VE foreign key (MAKH) references KHACHHANG(MAKH)
--alter table VE add constraint FK_DVTOUR foreign key (MADVTOUR) references TOURSANPHAM(MADVTOUR)
--alter table VE add constraint FK_DVTOUR1 foreign key (MADVTOUR) references TOURMOBAN(MADVTOUR)
alter table VE add constraint FK_VE1 foreign key (MANV) references NHANVIEN(MANV)



--KHOA NGOAI CUA LO TRINH
--alter table LOTRINH add constraint FK_CLOTRINH foreign key (MADVTOUR) references TOURSANPHAM(MADVTOUR)
--alter table LOTRINH add constraint FK_LOTRINH1 foreign key (MADVTOUR) references TOURMOBAN(MADVTOUR)

--KHOA NGOAI CUA NGUOI DUNG
alter table NGUOIDUNG add constraint FK_NGUOIDUNG foreign key (MANV) references NHANVIEN(MANV)

--KHOA NGOAI CUA DOANH THU
alter table DOANHTHU add constraint FK_DOANHTHU foreign key (MADVTOUR) references TOURSANPHAM(MADVTOUR)
alter table DOANHTHU add constraint FK_DOANHTHU1 foreign key (MADVTOUR) references TOURMOBAN(MADVTOUR)

--KHOA NGOAI CUA QUYEN QL
alter table QUYENQUANLY add constraint FK_QUYENQL foreign key (MANV) references NGUOIDUNG(MANV)


insert NHANVIEN values (2000, N'Admin', '10/01/2002', N'Nam', 989823484, N'111 s??? 47 t??n quy q7', N'Ho???t ?????ng', 'Admin')
insert NHANVIEN values (2001, N'Tr???n Thi??n ?????t', '2002-02-20', N'Nam', 989823484, '', N'Ho???t ?????ng', 'Admin')
insert NHANVIEN values (2002, N'Tr???n V??n Nam', '2001-02-10', N'Nam', 394847362, N'111 s??? 47 t??n quy q7', N'Ho???t ?????ng', 'Admin')
insert NHANVIEN values (2003, N'V?? V??n V', '2002-02-22', N'Nam', 989823484, '', N'Ho???t ?????ng', 'Admin')
insert NHANVIEN values (2004, N'L?? V??n B', '2002-03-22', N'Nam', 394847362, N'111 s??? 47 t??n quy q7', N'Ho???t ?????ng', 'Admin')
insert NHANVIEN values (2005, N'Kh????ng Duy', '2001-03-22', N'Nam', 989823484, '', N'Ho???t ?????ng', 'Admin')
insert NHANVIEN values (2006, N'Yasuo', '2002-01-11', N'Nam', 394847362, N'111 s??? 47 t??n quy q7', N'Ho???t ?????ng', 'Admin')


insert NGUOIDUNG values (2000, 'admin0123', 'admin0123', 'tranthiendat220102@gmail.com')
insert NGUOIDUNG values (2001, 'ohmhaha0123', '47474747', '')
insert NGUOIDUNG values (2002, 'oklanhe0123', '47474747', '')
insert NGUOIDUNG values (2003, 'prono123', '47474747', '')
insert NGUOIDUNG values (2004, 'huhu0123', '47474747', 'kkk@gmail.com')

insert NHACUNGCAP values (3001, N'Kh??ng Bi???t', 77778811, N'Ho???t ?????ng', '111 s??? 23')
insert NHACUNGCAP values (3002, N'Nh?? Cung C???p Kh??ch S???n S??? 1', 78887788, N'Ho???t ?????ng', N'111 s??? 22')
insert NHACUNGCAP values (3003, N'Nh?? Cung C???p Nh?? H??ng S??? 2 ', 99888888, N'Ho???t ?????ng', N'22 s??? 33')
insert NHACUNGCAP values (3004, N'Nh?? Cung C???p Nh?? H??ng S??? 4', 776622663, N'Ho???t ?????ng', N'111 s??? 33')
insert NHACUNGCAP values (3005, N'Nh?? Cung C???p Kh??ch S???n Kh??ng Th??? Ng???', 222233999, N'Ho???t ?????ng', N'222 s??? 22')

insert NHAHANG values (1001, N'Nh?? H??ng Th??? Gi???i', 3004, 987789)
insert NHAHANG values (1002, N'Nh?? H??ng S??? 2', 3004, 55555555)
insert NHAHANG values (1003, N'Nh?? H??ng 1 Th??nh Vi??n', 3004, 66666666)
insert NHAHANG values (1004, N'Nh?? H??ng Bao No', 3003, 78787878)
insert NHAHANG values (1005, N'Nh?? H??ng Kh??ng Lo ????i', 3003, 88889999)

insert KHACHSAN values ( 4001, N'Kh??ch s???n b??nh d??n', N'Kh??ch S???n Vui V???', 3001, N'Th?????ng', 88888888)
insert KHACHSAN values ( 4002, N'Kh??ch s???n c??n h???', N'Kh??ch S???n C??ng Nhau', 3002, N'Th?????ng', 77777777)
insert KHACHSAN values ( 4003, N'Kh??ch s???n c??n h???', N'Kh??ch S???n Kh??ng Bu???n', 3005, N'VIP', 88888888)
insert KHACHSAN values ( 4004, N'Kh??ch s???n c??n h???', N'Kh??ch S???n Kh??ng Lo Thi???u Ph??ng', 3005, N'Th?????ng', 77777777)
insert KHACHSAN values ( 4005, N'Kh??ch s???n b??nh d??n', N'Kh??ch S???n Song Ng??', 3002, N'Th?????ng', 88888888)

insert KHACHHANG values ( 1, N'Tr???n V??n ?????t', N'Nam', '2002-10-02', 999988889, N'112 s??? 12 t??n quy')
insert KHACHHANG values ( 2, N'V?? ?????c Tr???ng', N'Nam', '2002-10-02', 988766667, N'222 s??? 54 t??n ph??')
insert KHACHHANG values ( 3, N'L?? V??n A', N'Nam', '2002-02-10', 99889988, N'111 s??? 32')
insert KHACHHANG values ( 4, N'Tr???n V??n K', N'N???', '2002-02-20', 223344333, N'99 s??? 21 t??n ph??')
insert KHACHHANG values ( 5, N'L?? B?? Kh???i', N'Nam', '2002-02-20', 223344444, N'33 s??? 23 ')

insert TOURMOBAN values ( 30001, 'Private', N'Th??i th?? du l???ch', N'3 ng??y 3 ????m', N'Ch??a chi???t t??nh', 98789, 98888, 12, '2022-02-10')
insert TOURMOBAN values ( 30002, 'S.I.C', N'Du l???ch nh??? m??i', N'2 ng??y 2 ????m', N'Ch??a chi???t t??nh', 98789, 98888, 11, '2022-12-22')
insert TOURMOBAN values ( 30003, 'Private', N'Du l???ch c??ng nhau', N'1 ng??y 1 ????m', N'Ch??a chi???t t??nh', 98789, 98888, 5, '2022-11-11')
insert TOURMOBAN values ( 30004, 'Private', N'Du l???ch 3 ng?????i', N'2 ng??y 2 ????m', N'Ch??a chi???t t??nh', 98789, 98888, 7, '2002-02-22')
insert TOURMOBAN values ( 30005, 'Private', N'Du l???ch gia ????nh', N'12 ng??y ', N'Ch??a chi???t t??nh', 98789, 98888, 4, '2022-03-30')

insert TOURSANPHAM values ( 40001, 'Private', N'Du l???ch m???i ng??y', N'12 ng??y', N'Ch??a chi???t t??nh', N'Du l???ch xanh', 1)
insert TOURSANPHAM values ( 40002, 'Private', N'Du l???ch th??i', N'12 ng??y', N'Ch??a chi???t t??nh', N'Du l???ch ???m th???c', 5)
insert TOURSANPHAM values ( 40003, 'Private', N'Du l???ch m???t l???m', N'12 ng??y', N'Ch??a chi???t t??nh', N'Du l???ch xanh', 4)
insert TOURSANPHAM values ( 40004, 'Private', N'Du l???ch 1 m??nh', N'1 ng??y', N'Ch??a chi???t t??nh', N'Du l???ch ???m th???c', 3)
insert TOURSANPHAM values ( 40005, 'Private', N'Du l???ch 3 m??nh', N'10 ng??y', N'Ch??a chi???t t??nh', N'Du l???ch xanh', 12)

insert LOTRINH values ( 30001, N'10 gi???', '12/02/2022', N'3 gi???', '12/04/2022', N'???? L???t', N'???? n???ng')
insert LOTRINH values ( 30002, N'8 gi???', '12/22/2022', N'13 gi???', '10/02/2022', N'B???n tre', N'???? L???t')
insert LOTRINH values ( 30003, N'10 gi???', '12/02/2022', N'3 gi???', '12/04/2022', N'???? L???t', N'B???c giang')
insert LOTRINH values ( 30004, N'10 gi???', '12/22/2022', N'13 gi???', '10/02/2022', N'B???c giang', N'H?? N???i')
insert LOTRINH values ( 30005, N'8 gi???', '12/02/2022', N'3 gi???', '12/04/2022', N'???? n???ng', N'???? L???t')

insert LOTRINH values ( 40001, N'8 gi???', '12/22/2022', N'13 gi???', '10/02/2022', N'B???n tre', N'B???c giang')
insert LOTRINH values ( 40002, N'10 gi???', '12/02/2022', N'3 gi???', '12/04/2022', N'???? L???t', N'???? n???ng')
insert LOTRINH values ( 40003, N'10 gi???', '12/22/2022', N'13 gi???', '10/02/2022', N'B???n tre', N'H?? N???i')
insert LOTRINH values ( 40004, N'8 gi???', '12/02/2022', N'3 gi???', '12/04/2022', N'???? n???ng', N'B???c giang')
insert LOTRINH values ( 40005, N'10 gi???', '12/02/2022', N'3 gi???', '12/04/2022', N'???? L???t', N'???? n???ng')





