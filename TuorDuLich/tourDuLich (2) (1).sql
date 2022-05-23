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


insert NHANVIEN values (2000, N'Admin', '10/01/2002', N'Nam', 989823484, N'111 số 47 tân quy q7', N'Hoạt động', 'Admin')
insert NHANVIEN values (2001, N'Trần Thiên Đạt', '2002-02-20', N'Nam', 989823484, '', N'Hoạt động', 'Admin')
insert NHANVIEN values (2002, N'Trần Văn Nam', '2001-02-10', N'Nam', 394847362, N'111 số 47 tân quy q7', N'Hoạt động', 'Admin')
insert NHANVIEN values (2003, N'Võ Văn V', '2002-02-22', N'Nam', 989823484, '', N'Hoạt động', 'Admin')
insert NHANVIEN values (2004, N'Lê Văn B', '2002-03-22', N'Nam', 394847362, N'111 số 47 tân quy q7', N'Hoạt động', 'Admin')
insert NHANVIEN values (2005, N'Khương Duy', '2001-03-22', N'Nam', 989823484, '', N'Hoạt động', 'Admin')
insert NHANVIEN values (2006, N'Yasuo', '2002-01-11', N'Nam', 394847362, N'111 số 47 tân quy q7', N'Hoạt động', 'Admin')


insert NGUOIDUNG values (2000, 'admin0123', 'admin0123', 'tranthiendat220102@gmail.com')
insert NGUOIDUNG values (2001, 'ohmhaha0123', '47474747', '')
insert NGUOIDUNG values (2002, 'oklanhe0123', '47474747', '')
insert NGUOIDUNG values (2003, 'prono123', '47474747', '')
insert NGUOIDUNG values (2004, 'huhu0123', '47474747', 'kkk@gmail.com')

insert NHACUNGCAP values (3001, N'Không Biết', 77778811, N'Hoạt động', '111 số 23')
insert NHACUNGCAP values (3002, N'Nhà Cung Cấp Khách Sạn Số 1', 78887788, N'Hoạt động', N'111 số 22')
insert NHACUNGCAP values (3003, N'Nhà Cung Cấp Nhà Hàng Số 2 ', 99888888, N'Hoạt động', N'22 số 33')
insert NHACUNGCAP values (3004, N'Nhà Cung Cấp Nhà Hàng Số 4', 776622663, N'Hoạt động', N'111 số 33')
insert NHACUNGCAP values (3005, N'Nhà Cung Cấp Khách Sạn Không Thể Ngờ', 222233999, N'Hoạt động', N'222 số 22')

insert NHAHANG values (1001, N'Nhà Hàng Thế Giới', 3004, 987789)
insert NHAHANG values (1002, N'Nhà Hàng Số 2', 3004, 55555555)
insert NHAHANG values (1003, N'Nhà Hàng 1 Thành Viên', 3004, 66666666)
insert NHAHANG values (1004, N'Nhà Hàng Bao No', 3003, 78787878)
insert NHAHANG values (1005, N'Nhà Hàng Không Lo Đói', 3003, 88889999)

insert KHACHSAN values ( 4001, N'Khách sạn bình dân', N'Khách Sạn Vui Vẻ', 3001, N'Thường', 88888888)
insert KHACHSAN values ( 4002, N'Khách sạn căn hộ', N'Khách Sạn Cùng Nhau', 3002, N'Thường', 77777777)
insert KHACHSAN values ( 4003, N'Khách sạn căn hộ', N'Khách Sạn Không Buồn', 3005, N'VIP', 88888888)
insert KHACHSAN values ( 4004, N'Khách sạn căn hộ', N'Khách Sạn Không Lo Thiếu Phòng', 3005, N'Thường', 77777777)
insert KHACHSAN values ( 4005, N'Khách sạn bình dân', N'Khách Sạn Song Ngư', 3002, N'Thường', 88888888)

insert KHACHHANG values ( 1, N'Trần Văn Đạt', N'Nam', '2002-10-02', 999988889, N'112 số 12 tân quy')
insert KHACHHANG values ( 2, N'Võ Đức Trọng', N'Nam', '2002-10-02', 988766667, N'222 số 54 tân phú')
insert KHACHHANG values ( 3, N'Lê Văn A', N'Nam', '2002-02-10', 99889988, N'111 số 32')
insert KHACHHANG values ( 4, N'Trần Văn K', N'Nữ', '2002-02-20', 223344333, N'99 số 21 tân phú')
insert KHACHHANG values ( 5, N'Lê Bá Khải', N'Nam', '2002-02-20', 223344444, N'33 số 23 ')

insert TOURMOBAN values ( 30001, 'Private', N'Thôi thì du lịch', N'3 ngày 3 đêm', N'Chưa chiết tính', 98789, 98888, 12, '2022-02-10')
insert TOURMOBAN values ( 30002, 'S.I.C', N'Du lịch nhớ mãi', N'2 ngày 2 đêm', N'Chưa chiết tính', 98789, 98888, 11, '2022-12-22')
insert TOURMOBAN values ( 30003, 'Private', N'Du lịch cùng nhau', N'1 ngày 1 đêm', N'Chưa chiết tính', 98789, 98888, 5, '2022-11-11')
insert TOURMOBAN values ( 30004, 'Private', N'Du lịch 3 người', N'2 ngày 2 đêm', N'Chưa chiết tính', 98789, 98888, 7, '2002-02-22')
insert TOURMOBAN values ( 30005, 'Private', N'Du lịch gia đình', N'12 ngày ', N'Chưa chiết tính', 98789, 98888, 4, '2022-03-30')

insert TOURSANPHAM values ( 40001, 'Private', N'Du lịch mỗi ngày', N'12 ngày', N'Chưa chiết tính', N'Du lịch xanh', 1)
insert TOURSANPHAM values ( 40002, 'Private', N'Du lịch thôi', N'12 ngày', N'Chưa chiết tính', N'Du lịch ẩm thực', 5)
insert TOURSANPHAM values ( 40003, 'Private', N'Du lịch mệt lắm', N'12 ngày', N'Chưa chiết tính', N'Du lịch xanh', 4)
insert TOURSANPHAM values ( 40004, 'Private', N'Du lịch 1 mình', N'1 ngày', N'Chưa chiết tính', N'Du lịch ẩm thực', 3)
insert TOURSANPHAM values ( 40005, 'Private', N'Du lịch 3 mình', N'10 ngày', N'Chưa chiết tính', N'Du lịch xanh', 12)

insert LOTRINH values ( 30001, N'10 giờ', '12/02/2022', N'3 giờ', '12/04/2022', N'Đà Lạt', N'Đà nẵng')
insert LOTRINH values ( 30002, N'8 giờ', '12/22/2022', N'13 giờ', '10/02/2022', N'Bến tre', N'Đà Lạt')
insert LOTRINH values ( 30003, N'10 giờ', '12/02/2022', N'3 giờ', '12/04/2022', N'Đà Lạt', N'Bắc giang')
insert LOTRINH values ( 30004, N'10 giờ', '12/22/2022', N'13 giờ', '10/02/2022', N'Bắc giang', N'Hà Nội')
insert LOTRINH values ( 30005, N'8 giờ', '12/02/2022', N'3 giờ', '12/04/2022', N'Đà nẵng', N'Đà Lạt')

insert LOTRINH values ( 40001, N'8 giờ', '12/22/2022', N'13 giờ', '10/02/2022', N'Bến tre', N'Bắc giang')
insert LOTRINH values ( 40002, N'10 giờ', '12/02/2022', N'3 giờ', '12/04/2022', N'Đà Lạt', N'Đà nẵng')
insert LOTRINH values ( 40003, N'10 giờ', '12/22/2022', N'13 giờ', '10/02/2022', N'Bến tre', N'Hà Nội')
insert LOTRINH values ( 40004, N'8 giờ', '12/02/2022', N'3 giờ', '12/04/2022', N'Đà nẵng', N'Bắc giang')
insert LOTRINH values ( 40005, N'10 giờ', '12/02/2022', N'3 giờ', '12/04/2022', N'Đà Lạt', N'Đà nẵng')





