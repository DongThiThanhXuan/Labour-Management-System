drop database if exists  Labour
go
create database Labour
go
use Labour
go
create table department(
iddep varchar(10) primary key ,
namedep varchar(50),
)
go
create table typeaccount(
[typeid] varchar(10) primary key,
typename varchar(30)
)
go

create table employee (
idemp int primary key Identity ,
fullname varchar(50),
username varchar(30),
pass varchar(100),
[typeid] varchar(10)  FOREIGN key references typeaccount([typeid]),
dob date,
[address] varchar(100),
gender varchar(10),
email varchar(50),
phone varchar(11),
iddep varchar(10) FOREIGN key references department(iddep),
basicsalary decimal(10,0),
onboarddate date,--ngay nv bat dau di lam
annualleave decimal(3,1),--ngày nghỉ có phép mac dinh la 1 tu khi insert vo bang, sẽ tự động tăng lên 1 hàng tháng
--den khi hết năm sẽ reset về 1
unpaidleave decimal(3,1),--ngày nghỉ ko phép/ ngày nghỉ ko trả lương : mac dinh la 15 ngay
sickleave decimal(3,1),--ngay nghi om, mac dinh la 30 ngay. Nv nghi om thi BH tra, cty ko chi tra
sttemp tinyint--status employee: 1 la hoat dong, 0 la nghi cho thanh ly hop dong/cho onboard, 
)
go
--bang than nhan
create table relatives(
idemp int primary key references employee(idemp),
fullname varchar(50),
relationship varchar(30),
phone varchar(11)
)
go
insert into department values('HR','Human Resources')
go
insert into department values('AO','Admin Officer')
go
insert into department values('OP','Operations team')
go
insert into typeaccount values('HR','Human Resources')
go
insert into typeaccount values('ADO','Admin Officer')
go
insert into typeaccount values('EMP','employee')
go
insert into employee(fullname,dob,[address],gender,email,phone ,iddep ,onboarddate ,annualleave ,unpaidleave,sickleave,sttemp,username,pass,[typeid],basicsalary ) 
values('Nguyen Binh Phuong Lan','1997-05-31','p Binh An, Q2, TP HCM','Female','Nguyenlan3105@gmail.com','0774911853','HR','2018-01-01',2,10,8,1,'phuonglanhr','$2a$10$5SHP5iVfarYqnA39EJmiOuGrr/0xYHCxsUcb1EjkczOXj7zIRyzhy','HR',11000000)
go
insert into relatives values(1,'Nguyen Hong','Dad','0774911853')
go
insert into employee(fullname,dob,[address],gender,email,phone ,iddep ,onboarddate ,annualleave ,unpaidleave,sickleave,sttemp ,username,pass,[typeid] ,basicsalary) 
values('Dong Thi Thanh Xuan','1989-09-04','p Tan Dinh, Q1, TP HCM','Female','Dongthithanhxuan.hn@gmail.com','0904859325','AO','2018-01-01',10,12,9,1,'thanhxuandt','$2a$10$5SHP5iVfarYqnA39EJmiOuGrr/0xYHCxsUcb1EjkczOXj7zIRyzhy','ADO',11000000)
go
insert into relatives values(2,'Nguyen Thi Lien','Mom','098230103')
go

insert into employee(fullname,dob,[address],gender,email,phone ,iddep ,onboarddate ,annualleave ,unpaidleave,sickleave,sttemp,username,pass,[typeid],basicsalary  ) 
values('Pham Danh Dac','2000-08-28','Lam Ha, Lam Dong','Male','dacvn5672@gmail.com','0703901941','OP','2018-01-01',8,15,25,1,'danhdac','$2a$10$5SHP5iVfarYqnA39EJmiOuGrr/0xYHCxsUcb1EjkczOXj7zIRyzhy','EMP',9000000)
go
insert into relatives values(3,'Nguyen Thi Ngoc','Mom','0938402133')
go
insert into employee(fullname,dob,[address],gender,email,phone ,iddep ,onboarddate ,annualleave ,unpaidleave,sickleave,sttemp,username,pass,[typeid],basicsalary  ) 
values('Nguyen Manh Cuong','2000-12-12','Bao Loc, Lam Dong','Male','Manhcuong@gmail.com','0703342043','OP','2018-01-01',6,15,25,1,'manhcuong','$2a$10$5SHP5iVfarYqnA39EJmiOuGrr/0xYHCxsUcb1EjkczOXj7zIRyzhy','EMP',9000000)
go
insert into relatives values(4,'Nguyen Ha Linh','Wife','0938422142')
go
insert into employee(fullname,dob,[address],gender,email,phone ,iddep ,onboarddate ,annualleave ,unpaidleave,sickleave,sttemp,username,pass,[typeid] ,basicsalary ) 
values('Dinh Cong Tuan','2000-09-01','Ca Mau, Ca Mau','Male','Congtuan@gmail.com','0903274029','OP','2018-01-01',4,15,25,1,'congtuan','$2a$10$5SHP5iVfarYqnA39EJmiOuGrr/0xYHCxsUcb1EjkczOXj7zIRyzhy','EMP',9000000)
go
insert into relatives values(5,'Le Thi Giau','Mom','0938402133')
go
insert into employee(fullname,dob,[address],gender,email,phone ,iddep ,onboarddate ,annualleave ,unpaidleave,sickleave,sttemp,username,pass,[typeid] ,basicsalary )
values('Trang Trung Nghia','1998-09-12','Q8, TPHCM','Male','Trungnghia@gmail.com','0902009009','OP','2018-01-01',9,15,25,1,'trungnghia','$2a$10$5SHP5iVfarYqnA39EJmiOuGrr/0xYHCxsUcb1EjkczOXj7zIRyzhy','EMP',9000000)
go
insert into relatives values(6,'Nguyen Ngoc Hai Anh','Mom','0938402133')
go

insert into employee(fullname,dob,[address],gender,email,phone ,iddep ,onboarddate ,annualleave ,unpaidleave,sickleave,sttemp,username,pass,[typeid],basicsalary  )
values('Luong Ngoc Khac Nguyen','1982-09-12','Tan Binh, TPHCM','Male','Khacnguyen@gmail.com','0902009342','OP','2018-01-01',9,15,25,1,'khacnguyen','$2a$10$5SHP5iVfarYqnA39EJmiOuGrr/0xYHCxsUcb1EjkczOXj7zIRyzhy','EMP',9000000)
go
insert into relatives values(7,'Nguyen Thi Anh','Mom','0784235678')
go
insert into employee(fullname,dob,[address],gender,email,phone ,iddep ,onboarddate ,annualleave ,unpaidleave,sickleave,sttemp ,username,pass,[typeid],basicsalary )
values('Le Hoang Minh Duong','1995-09-12','Q1, TPHCM','Male','Minhduong@gmail.com','0701837654','OP','2018-01-01',9,15,25,1,'minhduong','$2a$10$5SHP5iVfarYqnA39EJmiOuGrr/0xYHCxsUcb1EjkczOXj7zIRyzhy','EMP',9000000)
go
insert into relatives values(8,'Le Hoang Anh Tuan','Dad','0784235678')
go
insert into employee(fullname,dob,[address],gender,email,phone ,iddep ,onboarddate ,annualleave ,unpaidleave,sickleave,sttemp,username,pass,[typeid],basicsalary  )
values('Luu Thi Hien','1995-12-12','q3, TPHCM','Female','Hienluu@gmail.com','0927492053','OP','2018-01-01',9,15,25,1,'hienluu','$2a$10$5SHP5iVfarYqnA39EJmiOuGrr/0xYHCxsUcb1EjkczOXj7zIRyzhy','EMP',9000000)
go
insert into relatives values(9,'Tran Hai Ha','Husband','0375917462')
go
insert into employee(fullname,dob,[address],gender,email,phone ,iddep ,onboarddate ,annualleave ,unpaidleave,sickleave,sttemp,username,pass,[typeid],basicsalary  )
values('Nguyen Hai Nam','1997-09-12','Q7, TPHCM','Male','hainam@gmail.com','0983625374','OP','2018-01-01',9,15,25,1,'hainam','$2a$10$5SHP5iVfarYqnA39EJmiOuGrr/0xYHCxsUcb1EjkczOXj7zIRyzhy','EMP',9000000)
go
insert into relatives values(10,'Dang Ngoc Ha','Wife','0927492053')
go
insert into employee(fullname,dob,[address],gender,email,phone ,iddep ,onboarddate ,annualleave ,unpaidleave,sickleave,sttemp,username,pass,[typeid] ,basicsalary )
values('Nguyen Hai Ha','1990-09-16','Q10, TPHCM','Female','hanguyen@gmail.com','0740103890','OP','2018-01-01',9,15,25,1,'hanguyen','$2a$10$5SHP5iVfarYqnA39EJmiOuGrr/0xYHCxsUcb1EjkczOXj7zIRyzhy','EMP',9000000)
go
insert into relatives values(11,'Nguyen Minh Thu','Mom','0983625374')
go
insert into employee(fullname,dob,[address],gender,email,phone ,iddep ,onboarddate ,annualleave ,unpaidleave,sickleave,sttemp,username,pass,[typeid] ,basicsalary )
values('Tran Ngoc Linh','1995-02-02','Binh Chanh, TPHCM','Female','Ngoclinh@gmail.com','0909374653','OP','2018-01-01',9,15,25,1,'ngoclinh1','$2a$10$5SHP5iVfarYqnA39EJmiOuGrr/0xYHCxsUcb1EjkczOXj7zIRyzhy','EMP',10000000)
go
insert into relatives values(12,'Tu thi Nghia','Mom','0740103890')
go
insert into employee(fullname,dob,[address],gender,email,phone ,iddep ,onboarddate ,annualleave ,unpaidleave,sickleave,sttemp,username,pass,[typeid],basicsalary  )
values('Nguyen Thi Lien','1999-01-04','Hai Ba Trung, Ha Noi','Female','liennguyen@gmail.com','0748023904','OP','2018-01-01',9,15,25,1,'liennguyen','$2a$10$5SHP5iVfarYqnA39EJmiOuGrr/0xYHCxsUcb1EjkczOXj7zIRyzhy','EMP',9000000)
go
insert into relatives values(13,'Hoang Huu Trung','Husband','0909374653')
go
insert into employee(fullname,dob,[address],gender,email,phone ,iddep ,onboarddate ,annualleave ,unpaidleave,sickleave,sttemp,username,pass,[typeid] ,basicsalary )
values('Nguyen Thi Huong','1996-07-23','Da Nang, Da Nang','Female','Huongnguyen@gmail.com','09018274500','OP','2018-01-01',9,15,25,1,'huongnguyen','$2a$10$5SHP5iVfarYqnA39EJmiOuGrr/0xYHCxsUcb1EjkczOXj7zIRyzhy','EMP',10000000)
go
insert into relatives values(14,'Nguyen Anh Tri','Dad','0748023904')
go
insert into employee(fullname,dob,[address],gender,email,phone ,iddep ,onboarddate ,annualleave ,unpaidleave,sickleave,sttemp,username,pass,[typeid],basicsalary  )
values('Nguyen Thi Hien','1982-09-30','Tan Binh, TPHCM','Female','Hiennguyenhcm@gmail.com','0701837644','OP','2018-01-01',9,15,25,1,'huongnguyen1','$2a$10$5SHP5iVfarYqnA39EJmiOuGrr/0xYHCxsUcb1EjkczOXj7zIRyzhy','EMP',9000000)
go
insert into relatives values(15,'Nguyen Thi Hai','Mom','09018274500')
go
insert into employee(fullname,dob,[address],gender,email,phone ,iddep ,onboarddate ,annualleave ,unpaidleave,sickleave,sttemp,username,pass,[typeid] ,basicsalary )
values('Tran Thi Thao','1986-02-12','Q5, TPHCM','Female','Thaotran@gmail.com','0909759123','OP','2018-01-01',9,15,25,1,'thaotran','$2a$10$5SHP5iVfarYqnA39EJmiOuGrr/0xYHCxsUcb1EjkczOXj7zIRyzhy','EMP',8000000)
go
insert into relatives values(16,'Tran Tuan Tu','Dad','0791274890')
go
insert into employee(fullname,dob,[address],gender,email,phone ,iddep ,onboarddate ,annualleave ,unpaidleave,sickleave,sttemp,username,pass,[typeid],basicsalary  )
values('Tran Thu Trang','1989-03-30','Cam Ranh, Nha Trang','Female','Thutrang@gmail.com','09374830002','OP','2018-01-01',9,15,25,1,'thutrang','$2a$10$5SHP5iVfarYqnA39EJmiOuGrr/0xYHCxsUcb1EjkczOXj7zIRyzhy','EMP',9000000)
go
insert into relatives values(17,'Tran Anh Tuan','Dad','0753020948')
go
insert into employee(fullname,dob,[address],gender,email,phone ,iddep ,onboarddate ,annualleave ,unpaidleave,sickleave,sttemp,username,pass,[typeid],basicsalary ) 
values('Nguyen Thi No','1990-05-30','p Binh Trieu, Q Thu Duc, TP HCM','Female','Nonguyen@gmail.com','0284910980','HR','2020-09-01',2,10,8,1,'nonguyen','$2a$10$5SHP5iVfarYqnA39EJmiOuGrr/0xYHCxsUcb1EjkczOXj7zIRyzhy','HR',9000000)
go
insert into relatives values(18,'Nguyen Hai','Dad','07395019090')
go
insert into employee(fullname,dob,[address],gender,email,phone ,iddep ,onboarddate ,annualleave ,unpaidleave,sickleave,sttemp ,username,pass,[typeid] ,basicsalary) 
values('Nguyen Nhi','1999-08-06','p 25, Q Binh Thach, TP HCM','Female','NhiNguyen@gmail.com','0790002758','AO','2020-09-01',10,12,9,1,'nhinguyen','$2a$10$5SHP5iVfarYqnA39EJmiOuGrr/0xYHCxsUcb1EjkczOXj7zIRyzhy','ADO',11000000)
go
insert into relatives values(19,'Nguyen Thi Tuyen','Mom','0749098231')
go
update employee set sttemp=1
go

--khi phan ca, se tu dong insert vo bang username nao, gio check in-out theo ca la bao nhieu,
--khi nv checkin/out thi se tim den dong co username do, ngay do, cap nhap gio checkin/out thuc te
--tu do tinh duoc gio di/ve tre
create table [Shift](
idShift tinyint primary key,--id ca lam viec
timein time,--thoi gian mac dinh bat dau ca lam viec 
[timeout] time,--thoi gian mac dinh ket thuc ca lam viec 
)
go
--chi tiết chấm công theo ngày cho từng người trong tháng
create table Attendancerecord(
idemp int FOREIGN key references employee(idemp),
idShift tinyint,
[date] date,--ngay di lam
seasondate tinyint,---loai ngay
checkin time, --thoi gian thuc te nhan vien bat dau ca lam viec 
checkout time,--thoi gian thuc te nhan vien ket thuc ca lam viec 
OT decimal(3,1),---admin set so gio OT cua nhan vien o day
reasoncheckin varchar(100), -- ly do neu di tre/ve som , neu thoi gian check in/out hop le thi cot nay null
reasoncheckout varchar(100), -- ly do neu di tre/ve som , neu thoi gian check in/out hop le thi cot nay null
validreason tinyint,---admin team se insert vo:0 la ko hợp lệ, 1 là hợp lệ cá nhân, 2 là hợp lệ cty, cuối tháng quét tổng hợp
Timekeepingbyday decimal(2,1),--ket qua tinh cong theo ngay : nghia la cuoi tuan,admin review lai, tinh cong ngay cho nv: cham 1 ngay cong hay 0.5 ngay cong
primary key(idemp,[date])
)
go

--bảng tổng hợp thông tin chấm công theo tháng cho từng người
create table Attendancemonthlyreport(
idemp int ,
[month] tinyint,---thang lam bao cao
totaltimekeeping decimal(3,1),-- tong ket qua tinh cong theo ngay : total Timekeepingbyday o bang Timekeepingdetails
totalworkHL decimal(3,1),--tong so ngay lam le tet theo quy dinh ( + luong 1 ngay *3)
totalworkoffday decimal(3,1),--tong so ngay lam vao ngay nghi cua nhan vien ( + 1 ngày luong *2)
totalshift3 decimal(3,1),--so ngay ca 3,32 để tính phụ cấp làm ca đêm
totalshift4 decimal(3,1),--so ngay ca 4,42 để tính phụ cấp làm ca đêm
totalworkfullday tinyint,--tong so ngay lam full ca trong thang de tinh phu cap an
totalOTonday decimal(3,1),--tong so gio overtime ngay thuong trong thang
totalOToffday decimal(3,1),--tong so gio overtime ngay nghi trong thang
totalOTHL decimal(3,1),--tong so gio overtime ngay nghi trong thang
totalOToffHL decimal(3,1),--tong so gio overtime ngay nghi bù ngày lễ trong thang
validreason1 tinyint,---admin team cout reason gia trị 1 xem nhan vien vi pham bao nhieu lan: tuc la di tre ly do chap nhan dươc bao nhieu lan
validreason2 tinyint,---admin team cout reason giá tri 2 xem nhan vien vi pham bao nhieu lan: tuc la di tre ly do ko duoc chap nhan bao nhieu lan
totalsalarydeduction decimal(8,0)--tong  khoan giam tru nhan vien trong thang
)
go

--bảng này để theo dõi số ngày nghỉ của nhân viên: có phép, ko phép, nghỉ ốm
create table requestleave(
idrqleave int primary key Identity,
idemp int FOREIGN key references employee(idemp),
fromdate date,--ngay muon nghi
todate date,--ngay muon nghi
annualleave decimal(3,1),--muon submit nghi AL thi se insert vao cot nay, ko thi bo trong
unpaidleave decimal(3,1),--muon submit nghi UL thi se insert vao cot nay, ko thi bo trong
sickleave decimal(3,1),--muon submit nghi SL thi se insert vao cot nay, ko thi bo trong
sendrequesttoadmin int,--gui thong tin request toi admin nao, day la id cua emp
sttrequestleave tinyint,--admin duyet phep hay ko duyet phep
note tinyint,--ghi chu ca lamf nua ngay muon nghi
deadline date
)
go
create table detailsRequestLeave(
idrqleave int FOREIGN key references requestleave(idrqleave),
dateleave date,
leave decimal(2,1)
)
go
--1
insert into requestleave(idemp,fromdate,todate,annualleave,unpaidleave,sickleave,sendrequesttoadmin,sttrequestleave,[note],deadline)
VALUES ( 4, CAST(N'2021-09-27' AS Date), CAST(N'2021-09-27' AS Date), CAST(0.5 AS Decimal(3, 1)), CAST(0.0 AS Decimal(3, 1)), CAST(0.0 AS Decimal(3, 1)), 2, 4, 32, CAST(N'2021-10-12' AS Date))
GO
INSERT [dbo].[detailsRequestLeave] ([idrqleave], [dateleave], [leave])
VALUES (1, CAST(N'2021-09-27' AS Date), CAST(0.5 AS Decimal(2, 1)))
GO
--2-----
insert into requestleave(idemp,fromdate,todate,annualleave,unpaidleave,sickleave,sendrequesttoadmin,sttrequestleave,[note],deadline)
VALUES ( 9, CAST(N'2021-09-15' AS Date), CAST(N'2021-09-15' AS Date), CAST(0.5 AS Decimal(3, 1)), CAST(0.0 AS Decimal(3, 1)), CAST(0.0 AS Decimal(3, 1)), 2, 4, 32, CAST(N'2021-10-12' AS Date))
GO
INSERT [dbo].[detailsRequestLeave] ([idrqleave], [dateleave], [leave])
VALUES (2,  CAST(N'2021-09-15' AS Date), CAST(0.5 AS Decimal(2, 1)))
GO
--3----
insert into requestleave(idemp,fromdate,todate,annualleave,unpaidleave,sickleave,sendrequesttoadmin,sttrequestleave,[note],deadline)
VALUES ( 9,  CAST(N'2021-09-15' AS Date),  CAST(N'2021-09-15' AS Date), CAST(0.0 AS Decimal(3, 1)), CAST(0.0 AS Decimal(3, 1)), CAST(0.5 AS Decimal(3, 1)), 2, 4, 32, CAST(N'2021-10-12' AS Date))
GO
INSERT [dbo].[detailsRequestLeave] ([idrqleave], [dateleave], [leave])
VALUES (3,  CAST(N'2021-09-15' AS Date), CAST(0.5 AS Decimal(2, 1)))
GO
--4-----
insert into requestleave(idemp,fromdate,todate,annualleave,unpaidleave,sickleave,sendrequesttoadmin,sttrequestleave,[note],deadline)
VALUES ( 10, CAST(N'2021-10-03' AS Date), CAST(N'2021-10-03' AS Date), CAST(0.5 AS Decimal(3, 1)), CAST(0.0 AS Decimal(3, 1)), CAST(0.0 AS Decimal(3, 1)), 2, 4, 32, CAST(N'2021-10-12' AS Date))
GO
INSERT [dbo].[detailsRequestLeave] ([idrqleave], [dateleave], [leave])
VALUES (4,  CAST(N'2021-10-03' AS Date), CAST(0.5 AS Decimal(2, 1)))
GO
--5----
insert into requestleave(idemp,fromdate,todate,annualleave,unpaidleave,sickleave,sendrequesttoadmin,sttrequestleave,[note],deadline)
VALUES ( 10,  CAST(N'2021-10-03' AS Date),  CAST(N'2021-10-03' AS Date), CAST(0.0 AS Decimal(3, 1)), CAST(0.0 AS Decimal(3, 1)), CAST(0.5 AS Decimal(3, 1)), 2, 4, 32, CAST(N'2021-10-12' AS Date))
GO
INSERT [dbo].[detailsRequestLeave] ([idrqleave], [dateleave], [leave])
VALUES (5,  CAST(N'2021-10-03' AS Date), CAST(0.5 AS Decimal(2, 1)))
GO
--6
insert into requestleave(idemp,fromdate,todate,unpaidleave,sendrequesttoadmin,sttrequestleave,deadline)
values (7,'2021-10-05','2021-10-06',2,16,2,'2021-10-09')
go
insert into detailsRequestLeave(idrqleave,dateleave,leave)
values (6,'2021-10-05',1)
go
insert into detailsRequestLeave(idrqleave,dateleave,leave)
values (6,'2021-10-06',1)
go
--7
insert into requestleave(idemp,fromdate,todate,annualleave,unpaidleave,sickleave,sendrequesttoadmin,sttrequestleave,[note],deadline)
VALUES ( 3, CAST(N'2021-09-28' AS Date), CAST(N'2021-09-30' AS Date), CAST(2.0 AS Decimal(3, 1)), CAST(0.0 AS Decimal(3, 1)), CAST(0.0 AS Decimal(3, 1)), 2, 1, 0, CAST(N'2021-10-10' AS Date))
GO

INSERT [dbo].[detailsRequestLeave] ([idrqleave], [dateleave], [leave]) 
VALUES (7, CAST(N'2021-09-28' AS Date), CAST(1.0 AS Decimal(2, 1)))
GO
INSERT [dbo].[detailsRequestLeave] ([idrqleave], [dateleave], [leave]) 
VALUES (7, CAST(N'2021-09-29' AS Date), CAST(0.0 AS Decimal(2, 1)))
GO
INSERT [dbo].[detailsRequestLeave] ([idrqleave], [dateleave], [leave]) 
VALUES (7, CAST(N'2021-09-30' AS Date), CAST(1.0 AS Decimal(2, 1)))
GO
--8
insert into requestleave(idemp,fromdate,todate,annualleave,unpaidleave,sickleave,sendrequesttoadmin,sttrequestleave,[note],deadline)
VALUES ( 3, CAST(N'2021-10-07' AS Date), CAST(N'2021-10-08' AS Date), CAST(2.0 AS Decimal(3, 1)), CAST(0.0 AS Decimal(3, 1)), CAST(0.0 AS Decimal(3, 1)), 2, 4, 0, CAST(N'2021-10-10' AS Date))
GO
INSERT [dbo].[detailsRequestLeave] ([idrqleave], [dateleave], [leave])
VALUES (8, CAST(N'2021-10-07' AS Date), CAST(1.0 AS Decimal(2, 1)))
GO
INSERT [dbo].[detailsRequestLeave] ([idrqleave], [dateleave], [leave]) 
VALUES (8, CAST(N'2021-10-08' AS Date), CAST(1.0 AS Decimal(2, 1)))
GO
--9
insert into requestleave(idemp,fromdate,todate,annualleave,unpaidleave,sickleave,sendrequesttoadmin,sttrequestleave,[note],deadline)
VALUES ( 3, CAST(N'2021-10-24' AS Date), CAST(N'2021-10-27' AS Date), CAST(3.0 AS Decimal(3, 1)), CAST(0.0 AS Decimal(3, 1)), CAST(0.0 AS Decimal(3, 1)), 2, 0, 0, CAST(N'2021-10-11' AS Date))
GO
INSERT [dbo].[detailsRequestLeave] ([idrqleave], [dateleave], [leave]) 
VALUES (9, CAST(N'2021-10-24' AS Date), CAST(1.0 AS Decimal(2, 1)))
GO
INSERT [dbo].[detailsRequestLeave] ([idrqleave], [dateleave], [leave]) 
VALUES (9, CAST(N'2021-10-25' AS Date), CAST(1.0 AS Decimal(2, 1)))
GO
INSERT [dbo].[detailsRequestLeave] ([idrqleave], [dateleave], [leave]) 
VALUES (9, CAST(N'2021-10-26' AS Date), CAST(0.0 AS Decimal(2, 1)))
GO
INSERT [dbo].[detailsRequestLeave] ([idrqleave], [dateleave], [leave]) 
VALUES (9, CAST(N'2021-10-27' AS Date), CAST(1.0 AS Decimal(2, 1)))
--10
insert into requestleave(idemp,fromdate,todate,annualleave,unpaidleave,sickleave,sendrequesttoadmin,sttrequestleave,[note],deadline)
VALUES ( 4, CAST(N'2021-10-19' AS Date), CAST(N'2021-10-22' AS Date), CAST(3.0 AS Decimal(3, 1)), CAST(0.0 AS Decimal(3, 1)), CAST(0.0 AS Decimal(3, 1)), 2, 1, 0, CAST(N'2021-10-11' AS Date))
GO
INSERT [dbo].[detailsRequestLeave] ([idrqleave], [dateleave], [leave]) 
VALUES (10, CAST(N'2021-10-19' AS Date), CAST(1.0 AS Decimal(2, 1)))
GO
INSERT [dbo].[detailsRequestLeave] ([idrqleave], [dateleave], [leave]) 
VALUES (10, CAST(N'2021-10-20' AS Date), CAST(1.0 AS Decimal(2, 1)))
GO
INSERT [dbo].[detailsRequestLeave] ([idrqleave], [dateleave], [leave])
VALUES (10, CAST(N'2021-10-21' AS Date), CAST(0.0 AS Decimal(2, 1)))
GO
INSERT [dbo].[detailsRequestLeave] ([idrqleave], [dateleave], [leave]) 
VALUES (10, CAST(N'2021-10-22' AS Date), CAST(1.0 AS Decimal(2, 1)))
GO
--11
insert into requestleave(idemp,fromdate,todate,annualleave,unpaidleave,sickleave,sendrequesttoadmin,sttrequestleave,[note],deadline)
VALUES (4, CAST(N'2021-10-17' AS Date), CAST(N'2021-10-17' AS Date), CAST(0.5 AS Decimal(3, 1)), CAST(0.0 AS Decimal(3, 1)), CAST(0.0 AS Decimal(3, 1)), 2, 3, 31, CAST(N'2021-10-12' AS Date))
GO
INSERT [dbo].[detailsRequestLeave] ([idrqleave], [dateleave], [leave]) 
VALUES (11, CAST(N'2021-10-17' AS Date), CAST(0.5 AS Decimal(2, 1)))
GO
--12
insert into requestleave(idemp,fromdate,todate,annualleave,unpaidleave,sickleave,sendrequesttoadmin,sttrequestleave,[note],deadline)
VALUES ( 12, CAST(N'2021-10-30' AS Date), CAST(N'2021-10-30' AS Date), CAST(1 AS Decimal(3, 1)), CAST(0.0 AS Decimal(3, 1)), CAST(0.0 AS Decimal(3, 1)), 1, 2, 0, CAST(N'2021-10-11' AS Date))
GO
INSERT [dbo].[detailsRequestLeave] ([idrqleave], [dateleave], [leave])
VALUES (12, CAST(N'2021-10-30' AS Date), 1)
GO
--13
insert into requestleave(idemp,fromdate,todate,annualleave,unpaidleave,sickleave,sendrequesttoadmin,sttrequestleave,[note],deadline)
VALUES ( 13, CAST(N'2021-10-21' AS Date), CAST(N'2021-10-21' AS Date), CAST(1.0 AS Decimal(3, 1)), CAST(0.0 AS Decimal(3, 1)), CAST(0.0 AS Decimal(3, 1)), 1, 2, 32, CAST(N'2021-10-09' AS Date))
GO
INSERT [dbo].[detailsRequestLeave] ([idrqleave], [dateleave], [leave])
VALUES (13, CAST(N'2021-10-21' AS Date), CAST(1.0 AS Decimal(2, 1)))
GO
--14-----
insert into requestleave(idemp,fromdate,todate,annualleave,unpaidleave,sickleave,sendrequesttoadmin,sttrequestleave,[note],deadline)
VALUES ( 4, CAST(N'2021-10-07' AS Date), CAST(N'2021-10-07' AS Date), CAST(0.5 AS Decimal(3, 1)), CAST(0.0 AS Decimal(3, 1)), CAST(0.0 AS Decimal(3, 1)), 19, 4, 32, CAST(N'2021-10-12' AS Date))
GO
INSERT [dbo].[detailsRequestLeave] ([idrqleave], [dateleave], [leave])
VALUES (14,  CAST(N'2021-10-07' AS Date), CAST(0.5 AS Decimal(2, 1)))
GO


create or alter trigger deadlinerequestleave
on requestleave
for insert
AS
BEGIN 
declare @idrqleave int=(select idrqleave from inserted)
declare @fromdate date=(select fromdate from inserted)
declare @deadline date
declare @create date = (cast(getdate() as date))
declare @chenhlechngay int = (select DATEDIFF(DAY,@create,@fromdate))
if (@chenhlechngay>6 or @chenhlechngay<=1)
begin
set @deadline= (select dateadd(DAY,6,@create))
end
if (@chenhlechngay<=6 and @chenhlechngay >1)
begin
set @deadline=@fromdate
end
update requestleave set deadline= @deadline where idrqleave=@idrqleave
END
GO

create table salary(
idemp int FOREIGN key references employee(idemp),
[month] tinyint,---thang tinh luong
standardday	tinyint, --so ngay cong chuan hang thang, mac dinh la 26 neu ko co nghi le tet, neu co le tet thi tru ra ngay le tet
numberAl decimal(3,1), --so ngay nghi phep co luong trong thang
numberUL decimal(3,1),--so ngay nghi phep ko luong trong thang
numberSL decimal(3,1),--so ngay nghi om ko tra luong(bao hiem tra) trong thang
workingHL decimal(3,1),-- so ngay lam viec ngay le tet
workingoffday decimal(3,1),--so ngay lam viec ngay nghi, ngay off
workingday decimal(3,1),--so ngay lam viec ngay binh thuong = standardday - AL-UL-SL-workingHL-workingoffday
totalworkfullday tinyint,--tong so ngay lam full ca trong thang
totalshift3 decimal(3,1),--so ngay ca 3,32 để tính phụ cấp làm ca đêm
totalshift4 decimal(3,1),--so ngay ca 4,42 để tính phụ cấp làm ca đêm
totalOTonday decimal(3,1),--so gio tang ca ngay thuong
totalOToffday decimal(3,1),--so gio tang ca ngay nghi
totalOTHL decimal(3,1),--so gio tang ca ngay le tet nghi
totalOToffHL decimal(3,1),--tong so gio overtime ngay nghi bù ngày lễ trong thang
OTondaysalary decimal(10,0), --tien tang ca ngay thuong = OTonday *1.5
OToffdaysalary decimal(10,0), --tien tang ca ngay nghi = OToffday * 2
OTHLsalary decimal(10,0), --tien tang ca ngay le = OTHLday * 4
OToffHLsalary decimal(10,0), --tien tang ca ngay nghi bu le = OTonday * 3
mealallowance decimal(10,0),--phu cap an=totalworkfullday*50.000
nightshiftallowance decimal(10,0),--phu cap ca dem=(totalshift3 + totalshift4) * 100.000
basicsalary decimal(10,0),--luong co ban theo hop dong
OTsalary decimal(10,0),--tong luong tang ca = OTondaysalary + OToffdaysalary + OTHLsalary + OToffHLsalary
totalsalary decimal(10,0),--((basicsalary/standardday) * ( standardday-UL-SL ) ) + nightshiftsalary+OTsalary+mealallowance+nightshiftallowance
salarydeduction decimal(10,0),--giam tru
insurance decimal(10,0),--BHXH,BHYT
income decimal(10,1),--luong thuc lanh/ thu nhap thuc te = totalsalary-salarydeduction-insurance
payday date,---ngay chuyen luong
primary key(idemp,[month])
)
go
--bang nay de gui yeu cau doi ca tren ung dung
create table requestchangeShift(
idrqcShift int primary key Identity,
fromidemp int,--tu emp nào
fromidShift tinyint,--ca nao
datechange date,--ngay nao
toidemp int,--doi snag cho ng nao
toidShift tinyint,--ca nao
sendrequesttoadmin int,--gui thong tin request toi admin nao
sttrequestchangeShift tinyint,--cho user dong y doi ca/ cho admin confirm/ tu choi
deadline date
)
go
insert into requestchangeShift(fromidemp,fromidShift,datechange,toidemp,toidShift,sendrequesttoadmin,sttrequestchangeShift,deadline)
values (10,1,'2021-10-26',6,4,2,5,'2021-10-07')
go
insert into requestchangeShift(fromidemp,fromidShift,datechange,toidemp,toidShift,sendrequesttoadmin,sttrequestchangeShift,deadline)
VALUES ( 3, 1, CAST(N'2021-10-10' AS Date), 6, 2, 0, 0, CAST(N'2021-10-08' AS Date))
GO
insert into requestchangeShift(fromidemp,fromidShift,datechange,toidemp,toidShift,sendrequesttoadmin,sttrequestchangeShift,deadline)
VALUES ( 3, 1, CAST(N'2021-10-20' AS Date), 4, 4, 2, 2, CAST(N'2021-10-09' AS Date))
GO
insert into requestchangeShift(fromidemp,fromidShift,datechange,toidemp,toidShift,sendrequesttoadmin,sttrequestchangeShift,deadline)
VALUES ( 4, 2, CAST(N'2021-10-31' AS Date), 13, 3, 0, 1, CAST(N'2021-10-10' AS Date))
go
insert into requestchangeShift(fromidemp,fromidShift,datechange,toidemp,toidShift,sendrequesttoadmin,sttrequestchangeShift,deadline)
VALUES ( 16, 2, CAST(N'2021-10-06' AS Date), 17, 1, 2, 3, CAST(N'2021-10-09' AS Date))
GO


create or alter trigger deadlinerequestChangeShift
on requestchangeShift
for insert
AS
BEGIN 
declare @idrqcShift int=(select idrqcShift from inserted)
declare @fromdate date=(select datechange from inserted)
declare @deadline date
declare @create date = (cast(getdate() as date))
set @deadline= (select dateadd(DAY,3,@create))
update requestchangeShift set deadline= @deadline where idrqcShift=@idrqcShift
END
GO
create table temptheteam(
idteam tinyint primary key,
teamname varchar(30))
go
create table tempsplittheteam(
idemp int primary key,
idteam tinyint FOREIGN key references temptheteam(idteam),
)
go

insert into temptheteam values (1,'team 1')
go
insert into temptheteam values (2,'team 2')
go
insert into temptheteam values (3,'team 3')
go
insert into temptheteam values (4,'team 4')
go
insert into temptheteam values (5,'team 5')
go


insert into [Shift] values(1,CAST('08:00:00' AS time),CAST('17:00:00' AS time) )
go
insert into [Shift] values(11,CAST('08:00:00' AS time),CAST('12:00:00' AS time) )
go
insert into [Shift] values(12,CAST('13:00:00' AS time),CAST('17:00:00' AS time) )
go
insert into [Shift] values(2,CAST('06:00:00' AS time),CAST('15:00:00' AS time) )
go
insert into [Shift] values(21,CAST('06:00:00' AS time),CAST('10:00:00' AS time) )
go
insert into [Shift] values(22,CAST('11:00:00' AS time),CAST('15:00:00' AS time) )
go
insert into [Shift] values(3,CAST('11:00:00' AS time),CAST('20:00:00' AS time) )
go
insert into [Shift] values(31,CAST('11:00:00' AS time),CAST('15:00:00' AS time) )
go
insert into [Shift] values(32,CAST('16:00:00' AS time),CAST('20:00:00' AS time) )
go
insert into [Shift] values(4,CAST('14:00:00' AS time),CAST('23:00:00' AS time) )
go
insert into [Shift] values(41,CAST('14:00:00' AS time),CAST('18:00:00' AS time) )
go
insert into [Shift] values(42,CAST('19:00:00' AS time),CAST('23:00:00' AS time) )
go

---------------------bat dau viet proc o day---------
create or alter proc ShowlistEmployee
AS
begin
	select *
	from employee where username is not null
end
go
--proc cua dac o day
CREATE OR ALTER PROC dac_insert_requestleave
@IDEMP INT, @FROMDATE DATE, @TODATE DATE,@AL DECIMAL(3,1),@UL DECIMAL(3,1),
@SL DECIMAL(3,1), @ADMIN INT,@STATUS TINYINT,@note tinyint
AS
BEGIN
 DECLARE @ID INT;
 DECLARE @INSERTED TABLE(ID INT);
 DECLARE @DAY DATE=@FROMDATE;
 DECLARE @CHECK TINYINT=1;
  INSERT INTO dbo.requestleave( idemp,fromdate,todate,annualleave,unpaidleave,sickleave,sendrequesttoadmin,sttrequestleave,note)
 OUTPUT Inserted.idrqleave
 INTO @INSERTED
  VALUES
  (   @IDEMP, -- idemp - int
      @FROMDATE, -- fromdate - date
      @TODATE, -- todate - date
	  @AL,
	  @UL,
	  @SL,
      @ADMIN, -- sendrequesttoadmin - int
      @STATUS,
	  @note
	
      )		 
	  SET @ID = (SELECT TOP 1 ID FROM @INSERTED);
	  
	  WHILE @CHECK =1
	  BEGIN
	  DECLARE @SHIFT INT;
	  DECLARE @LEAVE DECIMAL(2,1)=0;
	
	  SET @SHIFT=(SELECT TOP 1 idShift FROM dbo.Attendancerecord WHERE [date] =@DAY AND idemp=@IDEMP);
	  IF @SHIFT != 0
	  BEGIN
	  IF @note<1 OR @note IS null
	   BEGIN
	       SET @LEAVE = 1;  
	   END
	  ELSE  
	   BEGIN
	       SET @LEAVE = 0.5;  
	   END
	       	    
	  END;

	      INSERT INTO dbo.detailsRequestLeave
	      (
	          idrqleave,
	          dateleave,
	          leave
	      )
	      VALUES
	      (   @ID, -- idrqleave - int
	          @DAY, -- dateleave - date
	          @LEAVE  -- leave - tinyint
	          )
	    SET @DAY =(SELECT TOP 1 DATEADD(DAY,1,@DAY));
		IF @DAY>@TODATE
		BEGIN
		    SET @CHECK =0
		END;
	  END;
END
GO

CREATE OR ALTER PROC dac_getrl_by_id
@IDEMP INT
AS
BEGIN
    SELECT * FROM dbo.requestleave WHERE idemp = @IDEMP ORDER BY idrqleave DESC
END
GO
CREATE OR ALTER PROC dac_select_half_shift
@KEY VARCHAR(20)
AS
BEGIN
    SELECT * FROM [Shift] WHERE idShift LIKE @KEY+'%' AND idShift NOT IN (@KEY)
END
GO

CREATE OR ALTER PROC check_date_leave
@DATETO DATE, @DATEFROM DATE, @IDEMP INT
AS
BEGIN
    SELECT COUNT(*) AS total FROM ((SELECT * FROM dbo.Attendancerecord WHERE [date] >= @DATETO AND [date] <= @DATEFROM AND (idShift IS NULL OR idShift=0) AND idemp = @IDEMP )) AS p
END
GO 

CREATE OR ALTER PROC dac_insert_change_shift
@FROMEMP INT , @FROMSHIFT TINYINT, @DATE DATE,@TOEMP INT , @TOSHIFT TINYINT,@ADMIN INT, @STATUS INT
AS 
BEGIN
   INSERT INTO dbo.requestchangeShift
   (
       fromidemp,
       fromidShift,
       datechange,
	   toidemp,
       toidShift,
       sendrequesttoadmin,
       sttrequestchangeShift
   )
   VALUES
   (   @FROMEMP, -- fromidemp - int
       @FROMSHIFT, -- fromidShift - tinyint
       @DATE, -- datechange - date
	   @TOEMP,
       @TOSHIFT, -- toidShift - tinyint
       @ADMIN, -- sendrequesttoadmin - int
       @STATUS  -- sttrequestchangeShift - tinyint
       )
END
GO 

CREATE OR ALTER PROC select_ReShift
@ID INT 
AS
BEGIN
    SELECT * FROM dbo.requestchangeShift WHERE (fromidemp = @ID) OR (toidemp=@Id) ORDER BY idrqcShift DESC
END
GO

CREATE OR ALTER PROC select_SubmitShift
@TOEMP INT
AS
BEGIN
      SELECT * FROM dbo.requestchangeShift WHERE toidemp = @TOEMP AND sttrequestchangeShift=1
END
GO 

CREATE OR ALTER PROC update_SubmitShift
@STATUS TINYINT,@TOADMIN INT, @IDRESHIFT INT
AS
BEGIN
   UPDATE dbo.requestchangeShift
   SET sttrequestchangeShift = @STATUS, sendrequesttoadmin =@TOADMIN
   WHERE idrqcShift = @IDRESHIFT
END
GO 

CREATE OR ALTER PROC select_emp_by_shift
@SHIFT TINYINT, @DATE DATE
AS
BEGIN
  SELECT e.* FROM dbo.employee e INNER JOIN dbo.Attendancerecord a ON e.idemp=a.idemp WHERE a.idShift=@SHIFT AND a.[date] = @DATE AND e.typeid='EMP' AND sttemp = 1
END
GO 

CREATE OR ALTER PROC countDay
@DATEFROM DATE, @DATETO DATE, @IDEMP INT
AS
BEGIN
    SELECT COUNT(*) AS COUNTDATE FROM dbo.Attendancerecord WHERE [date]>=@DATEFROM AND [date]<=@DATETO AND idShift>0 AND idemp= @IDEMP
END
GO

CREATE OR ALTER PROC requestHalfShift
@DATE DATE, @IDEMP INT
AS
BEGIN 
  DECLARE @i INT
  DECLARE @NOTE INT 
  SET @i = (SELECT COUNT(*) AS COUNTDATE FROM requestleave WHERE [fromdate] = @DATE AND [todate] = @DATE AND idemp = @IDEMP AND sttrequestleave !=0  AND  sttrequestleave!=5)

  IF @i = 0
    BEGIN
       SET @NOTE = 0
    END
  ELSE IF @i = 1
    BEGIN
       SET @NOTE =(SELECT note AS N FROM requestleave WHERE [fromdate] = @DATE AND [todate] = @DATE AND idemp = @IDEMP AND sttrequestleave=4)
    END
  ELSE IF @i = 2
    BEGIN
       SET @NOTE = -1
    END

	SELECT @NOTE AS NOTE
END
GO



CREATE OR ALTER PROC selectHR
AS
BEGIN
select employee.idemp,fullname,date FROM employee 
inner join Attendancerecord on employee.idemp=Attendancerecord.idemp
WHERE [typeid] = 'HR' and idShift!=0 and [date]=cast(GETDATE() as date)
ORDER BY fullname ASC 
END

go
CREATE OR ALTER PROC selectADO
AS
BEGIN
declare @today date=(select GETDATE())
declare @nextmonday date
declare @check17h int=(select datediff(minute,cast(GETDATE() AS TIME),cast('17:00:00' as TIME)))
declare @thu INT 
			set @thu= (select (case datename(dw, @today)
             when 'Monday' then 1
             when 'Tuesday' then 2
             when 'Wednesday' then 3
             when 'Thursday' then 4
             when 'Friday' then 5
             when 'Saturday' then 6
             when 'Sunday' then 7
			 end))

if(@check17h>0)--NEU TRUOC 17H HANG NGAY
begin
	if(@thu=1 or @thu=2 or @thu=3 or @thu=4 or @thu=5)--truoc 17h hang ngay tu thu 2 den thu 6
	---hien thi tat ca nhan vien admin di lam vao ngay hom do
		begin
		select employee.idemp,fullname,date FROM employee 
		inner join Attendancerecord on employee.idemp=Attendancerecord.idemp
		WHERE [typeid] = 'ADO' and idShift!=0 and [date]=cast(GETDATE() as date)
		ORDER BY fullname ASC 
		END
	if(@thu=6)----truoc 17h thu 7 
	--hien thi nhan vien di lam vao thu 2 ke tiep
		begin
		set @nextmonday=(select DATEADD(day,2,cast(@today as date)))

		select employee.idemp,fullname,date FROM employee 
		inner join Attendancerecord on employee.idemp=Attendancerecord.idemp
		WHERE [typeid] = 'ADO' and idShift!=0 and [date]=@nextmonday
		ORDER BY fullname ASC 

		end
	if( @thu=7)----truoc 17h  chu nhat
	--hien thi nhan vien di lam vao thu 2 ke tiep
		begin
			set @nextmonday=(select DATEADD(day,1,cast(@today as date)))
			select employee.idemp,fullname,date FROM employee 
			inner join Attendancerecord on employee.idemp=Attendancerecord.idemp
			WHERE [typeid] = 'ADO' and idShift!=0 and [date]=@nextmonday
			ORDER BY fullname ASC 
		end
end
if(@check17h<=0)---neu sau 17h hang nay
	begin
		if(@thu=1 or @thu=2 or @thu=3 or @thu=4)--sau 17h hang ngay tu thu 2 den thu 5
			begin
			set @nextmonday=(select DATEADD(day,1,cast(@today as date)))
			select employee.idemp,fullname,date FROM employee 
			inner join Attendancerecord on employee.idemp=Attendancerecord.idemp
			WHERE [typeid] = 'ADO' and idShift!=0 and [date]=@nextmonday
			ORDER BY fullname ASC 

			end
		if(@thu=5)----sau 17h thu 6
			begin
			set @nextmonday=(select DATEADD(day,3,cast(@today as date)))
			select employee.idemp,fullname,date FROM employee 
			inner join Attendancerecord on employee.idemp=Attendancerecord.idemp
			WHERE [typeid] = 'ADO' and idShift!=0 and [date]=@nextmonday
			ORDER BY fullname ASC 

			end
		if(@thu=6)----sau 17h thu 7 
			begin
			set @nextmonday=(select DATEADD(day,2,cast(@today as date)))
			select employee.idemp,fullname,date FROM employee 
			inner join Attendancerecord on employee.idemp=Attendancerecord.idemp
			WHERE [typeid] = 'ADO' and idShift!=0 and [date]=@nextmonday
			ORDER BY fullname ASC 

			end
		if(@thu=7)----sau 17h chu nhat
			begin
			set @nextmonday=(select DATEADD(day,1,cast(@today as date)))
			select employee.idemp,fullname,date FROM employee 
			inner join Attendancerecord on employee.idemp=Attendancerecord.idemp
			WHERE [typeid] = 'ADO' and idShift!=0 and [date]=@nextmonday
			ORDER BY fullname ASC 

			end
	end
END
go


--proc cua lan o day
create or alter proc Lan_salary_sort_DeptMonthDesc
@month int, @iddep varchar(10)
as
begin
	select sal.*, emp.fullname, dept.namedep, dept.iddep from salary sal inner join employee emp on sal.idemp = emp.idemp inner join department dept on emp.iddep = dept.iddep
	where sal.[month] =@month and dept.iddep = @iddep order by income desc
end
go

create or alter proc Lan_salary_sort_DeptMonthAsc
@month int, @iddep varchar(10)
as
begin
	select sal.*, emp.fullname, dept.namedep, dept.iddep from salary sal inner join employee emp on sal.idemp = emp.idemp inner join department dept on emp.iddep = dept.iddep
	where sal.[month] =@month and dept.iddep = @iddep order by income asc
end
go
create or alter proc Lan_update_emp_leave
@idemp int,
@dayALrq decimal(3,1), @dayULrq decimal(3,1), @daySLrq decimal(3,1)
as
begin
	declare @al decimal(3,1), @ul decimal(3,1), @sl decimal(3,1)
	set @al = (select annualleave from employee where idemp = @idemp)
	set @ul = (select unpaidleave from employee where idemp = @idemp)
	set @sl = (select sickleave from employee where idemp = @idemp)
	update employee set annualleave = @al - @dayALrq, unpaidleave = @ul - @dayULrq, sickleave = @sl - @daySLrq
	where idemp = @idemp
end
go

create or alter proc Lan_updateleave_month  
@date date
as
begin
	declare @day int=(select day(@date))
	if(@day=1)
	begin
	declare @maxidemp int=(select max(idemp) from employee)
	declare @idemp int=1
		while(@idemp<=@maxidemp)
			begin
			declare @oldAL decimal(3,1) =(select annualleave from employee where idemp=@idemp)
			update employee set annualleave=@oldAL +1 where idemp=@idemp
			set @idemp+=1
		end	
	end
end
go

create or alter proc Lan_updateleave_year
@date date
as
begin
	declare @day int=(select day(@date))
	declare @month int=(select month(@date))
	if(@day=1 and @month =1)
	begin
	declare @maxidemp int=(select max(idemp) from employee)
	declare @idemp int=1
		while(@idemp<=@maxidemp)
			begin
			update employee set annualleave= 1, unpaidleave = 15, sickleave = 30 where idemp=@idemp
			set @idemp+=1
		end	
	end
end
go

create or alter proc age
@DOB date
 as
 begin
declare @now DATE;
set @now=GETDATE();
 SELECT DATEDIFF(YY, @DOB, @now) - 
  CASE WHEN MONTH(@DOB) > MONTH(@now) 
    OR MONTH(@DOB) = MONTH(@now) AND DAY(@DOB) > DAY(@now) 
  THEN 1 ELSE 0 END as AGE
end
go

create or alter proc Lan_insert_emp
@fullname varchar(50),  @username varchar(30), @pass varchar(100), @typeid varchar(10), @dob date, @address varchar(100), @gender varchar(10), @email varchar(50),
@phone varchar(10), @iddep varchar(10), @basicsalary decimal(10,0), @onboarddate date
as
begin
	insert into employee (fullname, username, pass, [typeid], dob, [address], gender, email, phone, iddep, basicsalary, onboarddate, annualleave, unpaidleave, sickleave, sttemp)
	values (@fullname, @username, @pass, @typeid, @dob, @address, @gender, @email, @phone, @iddep, @basicsalary, @onboarddate, 1, 15, 30, 1)
end
go

create or alter proc Lan_update_relatives
@fullname varchar(50), @relationship varchar(30), @idemp int
as
begin
	update relatives set fullname = @fullname, relationship = @relationship
	where idemp = @idemp
end
go

create or alter proc Lan_delete_info
@idemp int
as
begin
	update employee set sttemp = 0, username = null, pass = NULL where idemp = @idemp
end
go

create or alter proc Lan_update_status
@sttemp tinyint, @idemp int
as
begin
	update employee set sttemp = @sttemp where idemp = @idemp
end
go

create or alter proc Lan_search_idemp
@idemp int
as
begin
	select * from employee where idemp = @idemp
and username IS NOT NULL
end
go

create or alter proc Lan_search_by_dept
@iddep varchar(10)
as
begin
	select * from employee where iddep = @iddep
and username IS NOT NULL
end
go

create or alter proc Lan_search_emp_name
@key varchar(50)
as
begin
	select * from employee where fullname like '%' + @key + '%'
and username IS NOT NULL
end
go

create or alter proc Lan_search_emp_name_byDept
@iddep varchar(10), @key varchar(50)
as
begin
	select * from employee where iddep = @iddep and fullname like '%' + @key + '%'
and username IS NOT NULL
end
go

create or alter proc Lan_search_emp_name_byDept_Gen
@iddep varchar(10), @gender varchar(10), @key varchar(50)
as
begin
	select * from employee where iddep = @iddep and gender = @gender and fullname like '%' + @key + '%'
and username IS NOT NULL
end
go

create or alter proc Lan_search_emp_username
@key varchar(50)
as
begin
	select * from employee where username like '%' + @key + '%'
and username IS NOT NULL
end
go

create or alter proc Lan_search_emp_username_byDept
@iddep varchar(10), @key varchar(50)
as
begin
	select * from employee where iddep = @iddep and username like '%' + @key + '%'
and username IS NOT NULL
end
go

create or alter proc Lan_search_emp_username_byDept_Gen
@iddep varchar(10), @gender varchar(10), @key varchar(50)
as
begin
	select * from employee where iddep = @iddep and gender = @gender and username like '%' + @key + '%'
and username IS NOT NULL
end
go

create or alter proc Lan_search_dob
@key varchar(50)
as
begin
	select * from employee where  YEAR(dob) = @key or MONTH(dob) = @key
and username IS NOT NULL
end
go

create or alter proc Lan_search_dob_by_dept
@iddep varchar(10), @key varchar(50)
as
begin
	select * from employee where iddep = @iddep and  (YEAR(dob) = @key or MONTH(dob) = @key)
and username IS NOT NULL
end
go

create or alter proc Lan_search_dob_by_dept_Gen
@iddep varchar(10), @gender varchar(10), @key varchar(50)
as
begin
	select * from employee where iddep = @iddep and gender = @gender and (YEAR(dob) = @key or MONTH(dob) = @key)
and username IS NOT NULL
end
go

create or alter proc Lan_search_onboard
@key varchar(50)
as
begin
	select * from employee where  YEAR(onboarddate) = @key or MONTH(onboarddate) = @key
and username IS NOT NULL
end
go

create or alter proc Lan_search_onboard_by_dept
@iddep varchar(10), @key varchar(50)
as
begin
	select * from employee where iddep = @iddep and  (YEAR(onboarddate) = @key or MONTH(onboarddate) = @key)
and username IS NOT NULL
end
go

create or alter proc Lan_search_onboard_by_dept_Gen
@iddep varchar(10), @gender varchar(10), @key varchar(50)
as
begin
	select * from employee where iddep = @iddep and gender = @gender and  (YEAR(onboarddate) = @key or MONTH(onboarddate) = @key)
and username IS NOT NULL
end
go

create or alter proc Lan_search_phone
@key varchar(50)
as
begin
	select * from employee where  phone like '%' + @key + '%'
and username IS NOT NULL
end
go

create or alter proc Lan_search_phone_by_dept
@iddep varchar(10), @key varchar(50)
as
begin
	select * from employee where iddep = @iddep and  phone like '%' + @key + '%'
and username IS NOT NULL
end
go

create or alter proc Lan_search_address
@key varchar(50)
as
begin
	select * from employee where  [address] like '%' + @key + '%'
and username IS NOT NULL
end
go

create or alter proc Lan_search_address_by_dept
@iddep varchar(10), @key varchar(50)
as
begin
	select * from employee where iddep = @iddep and [address] like '%' + @key + '%'
and username IS NOT NULL
end
go

create or alter proc Lan_search_address_by_dept_Gen
@iddep varchar(10), @gender varchar(10), @key varchar(50)
as
begin
	select * from employee where iddep = @iddep and gender = @gender and [address] like '%' + @key + '%'
and username IS NOT NULL
end
go

create or alter proc Lan_sort_gender
@gender varchar(10)
as
begin
	select * from employee where gender = @gender
and username IS NOT NULL
end
go

create or alter proc Lan_sort_genderbyDept
@iddep varchar(10), @gender varchar(10)
as
begin
	select * from employee where iddep = @iddep and gender = @gender
and username IS NOT NULL
end
go

create or alter proc Lan_search_name_by_gender
@gender varchar(10), @key varchar(50)
as
begin
	select * from employee where gender = @gender and  fullname like '%' + @key + '%'
and username IS NOT NULL
end
go

create or alter proc Lan_search_username_by_gender
@gender varchar(10), @key varchar(50)
as
begin
	select * from employee where gender = @gender and  username like '%' + @key + '%'
and username IS NOT NULL
end
go

create or alter proc Lan_search_dob_by_gender
@gender varchar(10), @key varchar(50)
as
begin
	select * from employee where gender = @gender and  (YEAR(dob) = @key or MONTH(dob) = @key)
and username IS NOT NULL
end
go

create or alter proc Lan_search_onboard_by_gender
@gender varchar(10), @key varchar(50)
as
begin
	select * from employee where gender = @gender and  (YEAR(onboarddate) = @key or MONTH(onboarddate) = @key)
and username IS NOT NULL
end
go

create or alter proc Lan_search_address_by_gender
@gender varchar(10), @key varchar(50)
as
begin
	select * from employee where gender = @gender and [address] like '%' + @key + '%'
and username IS NOT NULL
end
go


create or alter proc Lan_salary_search_name
@key varchar(50)
as
begin
	select sal.*, emp.fullname from salary sal inner join employee emp on sal.idemp = emp.idemp 
	where emp.fullname like '%' + @key + '%'
end
go

create or alter proc Lan_salary_sort_DeptMonth
@month int, @iddep varchar(10)
as
begin
	select sal.*, emp.fullname, dept.namedep, dept.iddep from salary sal inner join employee emp on sal.idemp = emp.idemp inner join department dept on emp.iddep = dept.iddep
	where sal.[month] =@month and dept.iddep = @iddep
end
go

create or alter proc Lan_rqleave_searchname
@key varchar(30) , @idemp int
as
begin
	select rq.*, emp.fullname, emp.onboarddate, emp.annualleave, emp.unpaidleave, emp.sickleave, dept.iddep, dept.namedep
	from requestleave rq inner join employee emp on rq.idemp = emp.idemp 
	inner join department dept on emp.iddep = dept.iddep
	where emp.fullname like '%' + @key + '%' and rq.sendrequesttoadmin = @idemp
end
go
-----------------SALARY------------------

create or alter proc numberAL
@idemp int, @month tinyint
as
begin
	select sum(leave) as al from requestleave rq 
	inner join detailsRequestLeave dtrq 
	on dtrq.idrqleave = rq.idrqleave 
	where MONTH(dateleave) = @month and idemp = @idemp
	and sttrequestleave = 4 and annualleave !=0
end
go

create or alter proc numberUL
@idemp int, @month tinyint
as
begin
	select sum(leave) as ul from requestleave rq inner join detailsRequestLeave dtrq 
	on dtrq.idrqleave = rq.idrqleave where MONTH(dateleave) = @month and idemp = @idemp
	and sttrequestleave = 4 and unpaidleave !=0
end
go

create or alter proc numberSL
@idemp int, @month tinyint
as
begin
	select sum(leave) as sl from requestleave rq 
	inner join detailsRequestLeave dtrq 
	on dtrq.idrqleave = rq.idrqleave 
	where MONTH(dateleave) = @month and idemp = @idemp
	and sttrequestleave = 4 and sickleave !=0
end
go

create or alter proc sal_workingHL
@idemp int, @month tinyint
as
begin
	 select totalworkHL from Attendancemonthlyreport where idemp = @idemp and [month] = @month
end
go

create or alter proc sal_workingOffday
@idemp int, @month tinyint
as
begin
	 select totalworkoffday from Attendancemonthlyreport where idemp = @idemp and [month] = @month
end
go

create or alter proc sal_totalFullday
@idemp int, @month tinyint
as
begin
	 select totalworkfullday from Attendancemonthlyreport where idemp = @idemp and [month] = @month
end
go

create or alter proc sal_totalShift3
@idemp int, @month tinyint
as
begin
	 select totalshift3 from Attendancemonthlyreport where idemp = @idemp and [month] = @month
end
go

create or alter proc sal_totalShift4
@idemp int, @month tinyint
as
begin
	 select totalshift4 from Attendancemonthlyreport where idemp = @idemp and [month] = @month
end
go

create or alter proc sal_totalOTonday
@idemp int, @month tinyint
as
begin
	 select totalOTonday from Attendancemonthlyreport where idemp = @idemp and [month] = @month
end
go

create or alter proc sal_totalOToffday
@idemp int, @month tinyint
as
begin
	 select totalOToffday from Attendancemonthlyreport where idemp = @idemp and [month] = @month
end
go
create or alter proc sal_totalOTHL
@idemp int, @month tinyint
as
begin
	select totalOTHL from Attendancemonthlyreport where idemp = @idemp and [month] = @month
end
go

create or alter proc sal_totalOToffHL
@idemp int, @month tinyint
as
begin
	select totalOToffHL from Attendancemonthlyreport where idemp = @idemp and [month] = @month
end
go

create or alter proc sal_basicsalary
@idemp int
as
begin
	 select basicsalary from employee where idemp = @idemp
end
go

create or alter proc sal_deduction
@idemp int, @month tinyint
as
begin
	 select totalsalarydeduction from Attendancemonthlyreport where idemp = @idemp and [month] = @month
end
go

create or alter proc sal_insurance
@idemp int
as
begin
	 select (basicsalary*0.105) as BH from employee where idemp = @idemp
end
go

create or alter proc sal_meal
@idemp int, @month tinyint
as
begin
	 select (totalworkfullday*50000)as meal from Attendancemonthlyreport where idemp = @idemp and [month] = @month
end
go

create or alter proc sal_nightshift
@idemp int, @month tinyint
as
begin
	 select (totalshift3+totalshift4)*100000 as night from Attendancemonthlyreport where idemp = @idemp and [month] = @month
end
go

create or alter proc OTondaySalary
@idemp int, @month tinyint
as
begin
	 select ((basicsalary/176)* att.totalOTonday *1.5) as OTon from employee emp inner join Attendancemonthlyreport att on emp.idemp = att.idemp where att.idemp = @idemp and [month] = @month
end
go

create or alter proc OToffdaySalary
@idemp int, @month tinyint
as
begin
	 select ((basicsalary/176)* att.totalOToffday *2) as OToff from employee emp inner join Attendancemonthlyreport att on emp.idemp = att.idemp where att.idemp = @idemp and [month] = @month
end
go

create or alter proc OTHLSalary
@idemp int, @month tinyint
as
begin
	 select ((basicsalary/22)*4/8* att.totalOTHL) as OTHL from employee emp inner join Attendancemonthlyreport att on emp.idemp = att.idemp where att.idemp = @idemp and [month] = @month
end
go

create or alter proc OToffHLSalary
@idemp int, @month tinyint
as
begin
	 select ((basicsalary/22)*3/8* att.totalOToffHL) as OToffHL from employee emp inner join Attendancemonthlyreport att on emp.idemp = att.idemp where att.idemp = @idemp and [month] = @month
end
go

create or alter proc insert_salary
@idemp int, @month tinyint, @standardday tinyint, @AL decimal(3,1), @UL decimal(3,1), @SL decimal(3,1), @workingHL decimal(3,1), @offday decimal(3,1),
@workingday decimal(3,1), @fullday tinyint, @shift3 decimal(3,1), @shift4 decimal(3,1), @OTonday decimal(3,1), @OToffday decimal(3,1), @OTHL decimal(3,1),
@OToffHL decimal(3,1), @OTondaySal decimal(10,0), @OToffdaySal decimal(10,0), @OTHLSal decimal(10,0), @OToffHLSal decimal(10,0), @meal decimal(10,0), 
@night decimal(10,0), @basicSal decimal(10,0), @OTSal decimal(10,0), @totalSal decimal(10,0), @SalDeduction decimal(10,0), @insurance decimal(10,0),
@income decimal(10,0)
as
begin
	 insert into salary(idemp, [month], standardday, numberAl, numberUL, numberSL, workingHL, workingoffday, workingday, totalworkfullday, totalshift3, totalshift4,
	 totalOTonday, totalOToffday, totalOTHL, totalOToffHL, OTondaysalary, OToffdaysalary, OTHLsalary, OToffHLsalary, mealallowance, nightshiftallowance, basicsalary,
	 OTsalary, totalsalary, salarydeduction, insurance, income)
	 values(@idemp, @month, @standardday, @AL, @UL, @SL, @workingHL, @offday, @workingday, @fullday, @shift3, @shift4, @OTonday, @OToffday, @OTHL, @OToffHL,
	 @OTondaySal, @OToffdaySal, @OTHLSal, @OToffHLSal, @meal, @night, @basicSal, @OTSal, @totalSal, @SalDeduction, @insurance, @income)
end
go

create or alter proc edit_salary
@standardday tinyint, @AL decimal(3,1), @UL decimal(3,1), @SL decimal(3,1), @workingHL decimal(3,1), @offday decimal(3,1),
@workingday decimal(3,1), @fullday tinyint, @shift3 decimal(3,1), @shift4 decimal(3,1), @OTonday decimal(3,1), @OToffday decimal(3,1), @OTHL decimal(3,1),
@OToffHL decimal(3,1), @OTondaySal decimal(10,0), @OToffdaySal decimal(10,0), @OTHLSal decimal(10,0), @OToffHLSal decimal(10,0), @meal decimal(10,0), 
@night decimal(10,0), @basicSal decimal(10,0), @OTSal decimal(10,0), @totalSal decimal(10,0), @SalDeduction decimal(10,0), @insurance decimal(10,0),
@income decimal(10,0), @idemp int, @month tinyint
as
begin
	 update salary set standardday = @standardday, numberAl = @AL, numberUL = @UL, numberSL = @SL, workingHL = @workingHL, workingoffday = @offday,
	 workingday = @workingday, totalworkfullday = @fullday, totalshift3 = @shift3, totalshift4 = @shift4, totalOTonday = @OTonday, totalOToffday = @OToffday,
	 totalOTHL = @OTHL, totalOToffHL = @OToffHL, OTondaysalary = @OTondaySal, OToffdaysalary = @OToffdaySal, OTHLsalary = @OTHLSal, OToffHLsalary = @OToffHLSal,
	 mealallowance = @meal, nightshiftallowance = @night, basicsalary = @basicSal, OTsalary = @OTSal, totalsalary = @totalSal, salarydeduction = @SalDeduction, 
	 insurance = @insurance, income = @income
	 where idemp = @idemp and [month] = @month
end
go

create or alter proc Lan_select_maxid
as
begin
	select max(idemp) as maxid from Attendancemonthlyreport
end
go

create or alter proc Lan_select_maxMonth
as
begin
	select max([month]) as maxM from Attendancemonthlyreport
end
go
--============report salary==========================
create or alter proc Lan_countAllEmp_rp
@month tinyint
as
begin
	select count(sal.idemp) from salary sal inner join employee emp on sal.idemp = emp.idemp where [month] = @month
end
go

create or alter proc Lan_countEmpbyDept_rp
@iddep varchar(10), @month tinyint
as
begin
	select count(sal.idemp) from salary sal inner join employee emp on sal.idemp = emp.idemp
	inner join department dept on emp.iddep = dept.iddep
	where dept.iddep = @iddep and [month] = @month
end
go

create or alter proc Lan_sumMeal_rp
@month tinyint
as
begin
	select sum(mealallowance) from salary where [month] = @month
end
go

create or alter proc Lan_sumMealDept_rp
@iddep varchar(10), @month tinyint
as
begin
	select sum(mealallowance) from salary sal inner join employee emp on sal.idemp = emp.idemp
	inner join department dept on emp.iddep = dept.iddep
	where dept.iddep = @iddep and [month] = @month
end
go

create or alter proc Lan_sumNight_rp
@month tinyint
as
begin
	select sum(nightshiftallowance) from salary where [month] = @month
end
go

create or alter proc Lan_sumNightDept_rp
@iddep varchar(10), @month tinyint
as
begin
	select sum(nightshiftallowance) from salary sal inner join employee emp on sal.idemp = emp.idemp
	inner join department dept on emp.iddep = dept.iddep
	where dept.iddep = @iddep and [month] = @month
end
go

create or alter proc Lan_sumOTSal_rp
@month tinyint
as
begin
	select sum(OTsalary) from salary where [month] = @month
end
go

create or alter proc Lan_sumOTSalDept_rp
@iddep varchar(10), @month tinyint
as
begin
	select sum(OTsalary) from salary sal inner join employee emp on sal.idemp = emp.idemp
	inner join department dept on emp.iddep = dept.iddep
	where dept.iddep = @iddep and [month] = @month
end
go

create or alter proc Lan_sumTotalSal_rp
@month tinyint
as
begin
	select sum(totalsalary) from salary where [month] = @month
end
go

create or alter proc Lan_sumTotalSalDept_rp
@iddep varchar(10), @month tinyint
as
begin
	select sum(totalsalary) from salary sal inner join employee emp on sal.idemp = emp.idemp
	inner join department dept on emp.iddep = dept.iddep
	where dept.iddep = @iddep and [month] = @month
end
go

create or alter proc Lan_sumSalDeduc_rp
@month tinyint
as
begin
	select sum(salarydeduction) from salary where [month] = @month
end
go

create or alter proc Lan_sumSalDeducDept_rp
@iddep varchar(10), @month tinyint
as
begin
	select sum(salarydeduction) from salary sal inner join employee emp on sal.idemp = emp.idemp
	inner join department dept on emp.iddep = dept.iddep
	where dept.iddep = @iddep and [month] = @month
end
go

create or alter proc Lan_sumInsurance_rp
@month tinyint
as
begin
	select sum(insurance) from salary where [month] = @month
end
go

create or alter proc Lan_sumInsuranceDept_rp
@iddep varchar(10), @month tinyint
as
begin
	select sum(insurance) from salary sal inner join employee emp on sal.idemp = emp.idemp
	inner join department dept on emp.iddep = dept.iddep
	where dept.iddep = @iddep and [month] = @month
end
go

create or alter proc Lan_sumNetpay_rp
@month tinyint
as
begin
	select sum(income) from salary where [month] = @month
end
go

create or alter proc Lan_sumNetpayDept_rp
@iddep varchar(10), @month tinyint
as
begin
	select sum(income) from salary sal inner join employee emp on sal.idemp = emp.idemp
	inner join department dept on emp.iddep = dept.iddep
	where dept.iddep = @iddep and [month] = @month
end
go

create or alter proc Lan_AvgNetpay_rp
@month tinyint
as
begin
	select AVG(income) from salary where [month] = @month
end
go

create or alter proc Lan_AvgNetpayDept_rp
@iddep varchar(10), @month tinyint
as
begin
	select AVG(income) from salary sal inner join employee emp on sal.idemp = emp.idemp
	inner join department dept on emp.iddep = dept.iddep
	where dept.iddep = @iddep and [month] = @month
end
go

create or alter proc Lan_MaxNetpay_rp
@month tinyint
as
begin
	select MAX(income) from salary where [month] = @month
end
go

create or alter proc Lan_MaxNetpayDept_rp
@iddep varchar(10), @month tinyint
as
begin
	select MAX(income) from salary sal inner join employee emp on sal.idemp = emp.idemp
	inner join department dept on emp.iddep = dept.iddep
	where dept.iddep = @iddep and [month] = @month
end
go

create or alter proc Lan_MinNetpay_rp
@month tinyint
as
begin
	select MIN(income) from salary where [month] = @month
end
go

create or alter proc Lan_MinNetpayDept_rp
@iddep varchar(10), @month tinyint
as
begin
	select MIN(income) from salary sal inner join employee emp on sal.idemp = emp.idemp
	inner join department dept on emp.iddep = dept.iddep
	where dept.iddep = @iddep and [month] = @month
end
go







--proc cua xuan o day
create or alter proc Xuaninsertshiftofoffice
@month tinyint,
@year decimal(4,0),
@cfnhan bit
AS
BEGIN
declare @date tinyint =1;
	if(@month=1 or @month=3 or @month=5 or @month=7 or @month=8 or @month=10 or @month=12)
	begin
	while(@date<=31)
			begin
			declare @thu INT 
			set @thu= (select (case datename(dw, CAST(CONCAT(@year,'-',@month,'-',@date) as date))
             when 'Monday' then 1
             when 'Tuesday' then 2
             when 'Wednesday' then 3
             when 'Thursday' then 4
             when 'Friday' then 5
             when 'Saturday' then 6
             when 'Sunday' then 7
			 end))

			if (@thu=1 or @thu=2 or @thu=3 or @thu=4 or @thu=5 )
					begin
						insert into Attendancerecord (idemp,[date],idShift,OT) 
						select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),1,0 from employee 
						 where iddep='HR' or iddep='AO'
					 end
			if (@thu=6 or @thu=7 )
					begin
						insert into Attendancerecord (idemp,[date],idShift,OT) 
						select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),0,0 from employee 
						 where iddep='HR' or iddep='AO'
					 end

			set @date+=1	
			end
	end
	if(@month=2)
		begin
			if(@cfnhan=1)
				begin
				while(@date<=29)
					begin
					declare @thu1 INT 
					set @thu1= (select (case datename(dw, CAST(CONCAT(@year,'-',@month,'-',@date) as date))
								 when 'Monday' then 1
								 when 'Tuesday' then 2
								 when 'Wednesday' then 3
								 when 'Thursday' then 4
								 when 'Friday' then 5
								 when 'Saturday' then 6
								 when 'Sunday' then 7
							end))

						if (@thu1=1 or @thu1=2 or @thu1=3 or @thu1=4 or @thu1=5)
							begin
						insert into Attendancerecord (idemp,[date],idShift,OT) 
						select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),1,0 from employee 
						 where iddep='HR' or iddep='AO'
					 end
			if (@thu1 =6 or @thu1 =7)
					begin
						insert into Attendancerecord (idemp,[date],idShift,OT) 
						select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),0,0 from employee 
						 where iddep='HR' or iddep='AO'
					 end

						set @date+=1
					end
				end
			if(@cfnhan=0)
				begin
				while(@date<=28)
					begin
					declare @thu2 INT 
set @thu2= (select (case datename(dw, CAST(CONCAT(@year,'-',@month,'-',@date) as date))
             when 'Monday' then 1
             when 'Tuesday' then 2
             when 'Wednesday' then 3
             when 'Thursday' then 4
             when 'Friday' then 5
             when 'Saturday' then 6
             when 'Sunday' then 7
        end))

						if (@thu2=1 or @thu2=2 or @thu2=3 or @thu2=4 or @thu2=5)
					begin
						insert into Attendancerecord (idemp,[date],idShift,OT) 
						select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),1,0 from employee 
						 where iddep='HR' or iddep='AO'
					 end
			if (@thu2 =6 or @thu2 =7)
					begin
						insert into Attendancerecord (idemp,[date],idShift,OT) 
						select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),0,0 from employee 
						 where iddep='HR' or iddep='AO'
					 end

						set @date+=1
					end
				end		
		end
	if(@month=4 or @month=6 or @month=9 or @month=11)
		begin
		while(@date<=30)
		begin
		declare @thu3 INT = (select (case datename(dw, CAST(CONCAT(@year,'-',@month,'-',@date) as date))
					 when 'Monday' then 1
					 when 'Tuesday' then 2
					 when 'Wednesday' then 3
					 when 'Thursday' then 4
					 when 'Friday' then 5
					 when 'Saturday' then 6
					 when 'Sunday' then 7
				end))
	
			if (@thu3=1 or @thu3=2 or @thu3=3 or @thu3=4 or @thu3=5)
					begin
						insert into Attendancerecord (idemp,[date],idShift,OT) 
						select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),1,0 from employee 
						 where iddep='HR' or iddep='AO'
						
					 end
			if (@thu3 =6 or @thu3 =7)
					begin
						insert into Attendancerecord (idemp,[date],idShift,OT)  
						select idemp,[date]=CAST(CONCAT(2021,'-',@month,'-',@date) as date),0,0 from employee 
						 where iddep='HR' or iddep='AO'
					 end
		set @date+=1
		end
		end
END
go
create or alter proc updatehlforOF
@fromdate date,
@todate date
as
begin
update Attendancerecord set idShift=0 
where idemp in (select idemp from employee where iddep!='OP') 
and (date between @fromdate and @todate)
end
go
create or alter proc updatehlforOP
@fromdate date,
@todate date,
@season int
as
begin
if(@season=1)
begin
update Attendancerecord set seasondate=1 
where idemp in (select idemp from employee where iddep='OP') 
and (date between '2021-09-02' and '2021-09-03') and idShift!=0
end
if(@season=2)
begin
update Attendancerecord set seasondate=2 
where idemp in (select idemp from employee where iddep='OP') 
and (date between @fromdate and @todate) and idShift!=0
end

end
go

create or alter proc updatenghibuhlforOF
@fromdate date,
@todate date
as
begin
update Attendancerecord set idShift=0 
where idemp in (select idemp from employee where iddep!='OP') 
and (date between @fromdate and @todate)
end
go


create or alter proc Xuan_searchonAttendancerecord
@phone varchar(11)
AS
begin
	select * from employee where phone = @phone
end
go
--chia ca cho team 1 loai 5 team 4 ca
CREATE or alter PROC team1and4shift
@month tinyint,
@year decimal(4,0),
@cfnhan bit
AS
BEGIN
declare @date tinyint =1;
	if(@month=1 or @month=3 or @month=5 or @month=7 or @month=8 or @month=10 or @month=12)
	begin
	while(@date<=31)
			begin
			if(@date=1 or @date=2 or @date=11 or  @date=12 or @date=21 or @date=22 or @date=31 or @date=30)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),2,0 from tempsplittheteam 
					 where idteam=1	
				end
				if(@date=4 or @date=5 or @date=14 or  @date=15 or @date=24 or @date=25)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),3,0 from tempsplittheteam 
					 where idteam=1	
				end
				if(@date=7 or @date=8 or @date=17 or  @date=18 or @date=27 or @date=28)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),4,0 from tempsplittheteam 
					 where idteam=1	
				end
				if(@date=10  or @date=20)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),1,0 from tempsplittheteam 
					 where idteam=1	
				end
				if(@date=3 or @date=6 or @date=9 or @date=13 or  @date=16 or  @date=19 or @date=23 or @date=26 or @date=29 )
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),0,0 from tempsplittheteam 
					 where idteam=1	
				end
				set @date+=1
			end
	end
	if(@month=2)
		begin
			if(@cfnhan=1)
				begin
				while(@date<=29)
					begin
					if(@date=1 or @date=2 or @date=3 or @date=11 or  @date=12 or @date=21 or @date=22)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),2,0 from tempsplittheteam 
					 where idteam=1	
				end
				if(@date=4 or @date=5 or @date=14 or  @date=15 or @date=24 or @date=25)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),3,0 from tempsplittheteam 
					 where idteam=1		
				end
				if(@date=7 or @date=8 or @date=17 or  @date=18 or @date=27 or @date=28)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),4,0 from tempsplittheteam 
					 where idteam=1	
				end
				if(@date=10  or @date=20 or  @date=16)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),1,0 from tempsplittheteam 
					 where idteam=1	
				end
				if( @date=6 or @date=9 or @date=13 or  @date=19 or @date=23 or @date=26 or @date=29 )
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),0,0 from tempsplittheteam 
					 where idteam=1	
				end
				set @date+=1
					end
				end
			if(@cfnhan=0)
				begin
				while(@date<=28)
					begin
				if(@date=1 or @date=2 or @date=3 or @date=11 or  @date=12 or @date=21 or @date=22)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),2,0 from tempsplittheteam 
					 where idteam=1	
				end
				if(@date=4 or @date=5 or @date=14 or  @date=15 or @date=24 or @date=25)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),3,0 from tempsplittheteam 
					 where idteam=1		
				end
				if(@date=7 or @date=8 or @date=17 or  @date=18 or @date=27 or @date=28)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),4,0 from tempsplittheteam 
					 where idteam=1	
				end
				if(@date=10  or @date=20 or  @date=16)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),1,0 from tempsplittheteam 
					 where idteam=1	
				end
				if( @date=6 or @date=9 or @date=13 or  @date=19 or @date=23 or @date=26  )
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),0,0 from tempsplittheteam 
					 where idteam=1	
				end
				set @date+=1
					end
				end		
		end
	if(@month=4 or @month=6 or @month=9 or @month=11)
		begin
		while(@date<=30)
			begin
			if(@date=1 or @date=2 or @date=11 or  @date=12 or @date=21 or @date=22 or @date=30)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),2,0 from tempsplittheteam 
					 where idteam=1	
				end
				if(@date=4 or @date=5 or @date=14 or  @date=15 or @date=24 or @date=25)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),3,0 from tempsplittheteam 
					 where idteam=1		
				end
				if(@date=7 or @date=8 or @date=17 or  @date=18 or @date=27 or @date=28)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),4,0 from tempsplittheteam 
					 where idteam=1	
				end
				if(@date=10 or @date=16 or @date=20)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),1,0 from tempsplittheteam 
					 where idteam=1	
				end
				if(@date=3 or @date=6 or @date=9 or  @date=13 or  @date=19 or @date=23 or @date=26 or @date=29 )
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),0,0 from tempsplittheteam 
					 where idteam=1	
				end
				set @date+=1
			end
		end
END
go
--chia ca cho team 2 loai 5 team 4 ca
CREATE or alter PROC team2and4shift
@month tinyint,
@year decimal(4,0),
@cfnhan bit
AS
BEGIN
declare @date tinyint =1;
	if(@month=1 or @month=3 or @month=5 or @month=7 or @month=8 or @month=10 or @month=12)
	begin
	while(@date<=31)
			begin
			if(@date=3 or @date=4 or @date=13 or  @date=14 or @date=23 or @date=24 or @date=31)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),2,0 from tempsplittheteam 
					 where idteam=2	
				end
				if(@date=6 or @date=7 or @date=16 or  @date=17 or @date=26 or @date=27)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),3,0 from tempsplittheteam 
					 where idteam=2
				end
				if(@date=9 or @date=10 or @date=19 or  @date=20 or @date=29 or @date=30)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),4,0 from tempsplittheteam 
					 where idteam=2
				end
				if(@date=1or @date=12 or @date=22 )
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),1,0 from tempsplittheteam 
					 where idteam=2
				end
				if(@date=5  or @date=2 or @date=8 or  @date=11 or  @date=18 or @date=21 or @date=15 or @date=25 or @date=28 )
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),0,0 from tempsplittheteam 
					 where idteam=2
				end
				set @date+=1
			end
	end
	if(@month=2)
		begin
			if(@cfnhan=1)
				begin
				while(@date<=29)
					begin
					if(@date=3 or @date=4 or @date=13 or  @date=14 or @date=23 or @date=24 )
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),2,0 from tempsplittheteam 
					 where idteam=2
				end
				if(@date=6 or @date=7 or @date=16 or  @date=17 or @date=26 or @date=27 or @date=28)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),3,0 from tempsplittheteam 
					 where idteam=2
				end
				if(@date=9 or @date=10 or  @date=11 or @date=19 or  @date=20 or @date=29)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),4,0 from tempsplittheteam 
					 where idteam=2
				end
				if(@date=5  or @date=1 or @date=22 )
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),1,0 from tempsplittheteam 
					 where idteam=2
				end
				if(@date=15 or @date=2 or @date=8  or @date=12 or  @date=18 or @date=21 or @date=25 )
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),0,0 from tempsplittheteam 
					 where idteam=2
				end
				set @date+=1
					end
				end
			if(@cfnhan=0)
				begin
				while(@date<=28)
					begin
						if(@date=3 or @date=4 or @date=13 or  @date=14 or @date=23 or @date=24 )
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),2,0 from tempsplittheteam 
					 where idteam=2
				end
				if(@date=6 or @date=7 or @date=16 or  @date=17 or @date=26 or @date=27 or @date=28)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),3,0 from tempsplittheteam 
					 where idteam=2
				end
				if(@date=9 or @date=10 or  @date=11 or @date=19 or  @date=20 )
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),4,0 from tempsplittheteam 
					 where idteam=2
				end
				if(@date=5  or @date=1 or @date=22 )
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),1,0 from tempsplittheteam 
					 where idteam=2
				end
				if(@date=15 or @date=2 or @date=8  or @date=12 or  @date=18 or @date=21 or @date=25 )
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),0,0 from tempsplittheteam 
					 where idteam=2
				end
				set @date+=1
					end
				end		
		end
	if(@month=4 or @month=6 or @month=9 or @month=11)
		begin
		while(@date<=30)
			begin
			if(@date=3 or @date=4 or @date=13 or  @date=14 or @date=23 or @date=24 )
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),2,0 from tempsplittheteam 
					 where idteam=2
				end
				if(@date=6 or @date=7 or @date=16 or  @date=17 or @date=26 or @date=27 or @date=28)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),3,0 from tempsplittheteam 
					 where idteam=2
				end
				if(@date=9 or @date=10 or @date=19 or  @date=20 or @date=29 or @date=30)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),4,0 from tempsplittheteam 
					 where idteam=2
				end
				if(@date=1 or @date=12 or @date=22 )
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),1,0 from tempsplittheteam 
					 where idteam=2	
				end
				if(@date=5 or @date=2 or @date=8 or  @date=11 or  @date=15 or @date=18 or @date=21 or @date=25 )
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),0,0 from tempsplittheteam 
					 where idteam=2
				end
				set @date+=1
			end
		end
END
go
CREATE or alter PROC team3and4shift
@month tinyint,
@year decimal(4,0),
@cfnhan bit
AS
BEGIN
declare @date tinyint =1;
	if(@month=1 or @month=3 or @month=5 or @month=7 or @month=8 or @month=10 or @month=12)
	begin
	while(@date<=31)
			begin
			if(@date=5 or @date=6 or @date=15 or  @date=16 or @date=25 or @date=26 )
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),2,0 from tempsplittheteam 
					 where idteam=3	
				end
				if(@date=8 or @date=9 or @date=18 or  @date=19 or @date=28 or @date=29)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),3,0 from tempsplittheteam 
					 where idteam=3	
				end
				if(@date=1 or @date=2 or @date=11 or @date=12 or  @date=21 or @date=22 or @date=23 )
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),4,0 from tempsplittheteam 
					 where idteam=3	
				end
				if(@date=4 or @date=14  or @date=31)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),1,0 from tempsplittheteam 
					 where idteam=3	
				end
				if(@date=3 or @date=7 or @date=10 or  @date=13 or  @date=17 or @date=20 or @date=24 or @date=27 or @date=30 )
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),0,0 from tempsplittheteam 
					 where idteam=3	
				end
				set @date+=1
			end
	end
	if(@month=2)
		begin
			if(@cfnhan=1)
				begin
				while(@date<=29)
					begin
				if(@date=5 or @date=6 or @date=15 or  @date=16 or @date=25 or @date=26 )
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),2,0 from tempsplittheteam 
					 where idteam=3		
				end
				if(@date=8 or @date=9 or @date=18 or  @date=19 or @date=28 or @date=29)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),3,0 from tempsplittheteam 
					 where idteam=3		
				end
				if(@date=1  or @date=11 or @date=12 or  @date=21 or @date=22 or @date=23)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),4,0 from tempsplittheteam 
					 where idteam=3	
				end
				if(@date=4 or  @date=3 or @date=14 or @date=10)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),1,0 from tempsplittheteam 
					 where idteam=3	
				end
				if(@date=2  or @date=7 or @date=13 or  @date=17 or  @date=20 or @date=24  or @date=27)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),0,0 from tempsplittheteam 
					 where idteam=3	
				end
				set @date+=1
					end
				end
			if(@cfnhan=0)
				begin
				while(@date<=28)
					begin
				if(@date=5 or @date=6 or @date=15 or  @date=16 or @date=25 or @date=26 )
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),2,0 from tempsplittheteam 
					 where idteam=3		
				end
				if(@date=8 or @date=9 or @date=18 or  @date=19 or @date=28)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),3,0 from tempsplittheteam 
					 where idteam=3		
				end
				if(@date=1  or @date=11 or @date=12 or  @date=21 or @date=22 or @date=23)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),4,0 from tempsplittheteam 
					 where idteam=3	
				end
				if(@date=4 or  @date=3 or @date=14 or @date=10)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),1,0 from tempsplittheteam 
					 where idteam=3	
				end
				if(@date=2  or @date=7 or @date=13 or  @date=17 or  @date=20 or @date=24  or @date=27)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),0,0 from tempsplittheteam 
					 where idteam=3	
				end
				set @date+=1
					end
				end		
		end
	if(@month=4 or @month=6 or @month=9 or @month=11)
		begin
		while(@date<=30)
			begin
			if(@date=5 or @date=6 or @date=15 or  @date=16 or @date=25 or @date=26 )
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),2,0 from tempsplittheteam 
					 where idteam=3	
				end
				if(@date=8 or @date=9 or @date=18 or  @date=19 or @date=28 or @date=29)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),3,0 from tempsplittheteam 
					 where idteam=3		
				end
				if(@date=1 or @date=2 or @date=11 or @date=12 or  @date=21 or @date=22 or @date=23)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),4,0 from tempsplittheteam 
					 where idteam=3		
				end
				if(@date=4 or @date=14 or @date=30)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),1,0 from tempsplittheteam 
					 where idteam=3	
				end
				if(@date=3 or @date=7 or @date=10 or  @date=13 or  @date=17 or @date=20  or @date=24 or @date=27)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),0,0 from tempsplittheteam 
					 where idteam=3	
				end
				set @date+=1
			end
		end
END

go
CREATE or alter PROC team4and4shift
@month tinyint,
@year decimal(4,0),
@cfnhan bit
AS
BEGIN
declare @date tinyint =1;
	if(@month=1 or @month=3 or @month=5 or @month=7 or @month=8 or @month=10 or @month=12)
	begin
	while(@date<=31)
			begin
			if(@date=7 or @date=8 or @date=17 or  @date=18 or @date=27 or @date=28 )
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),2,0 from tempsplittheteam 
					 where idteam=4	
				end
				if(@date=1 or @date=10 or @date=11 or  @date=20 or @date=21 or @date=30 or @date=31)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),3,0 from tempsplittheteam 
					 where idteam=4		
				end
				if(@date=3 or @date=4 or @date=12 or @date=13 or @date=14  or @date=24 )
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),4,0 from tempsplittheteam 
					 where idteam=4	
				end
				if(@date=6 or @date=26 or @date=19)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),1,0 from tempsplittheteam 
					 where idteam=4	
				end
				if(@date=2 or @date=5  or  @date=9 or  @date=15 or  @date=16 or @date=22 or  @date=23 or @date=25 or @date=29)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),0,0 from tempsplittheteam 
					 where idteam=4	
				end
				set @date+=1
			end
	end
	if(@month=2)
		begin
			if(@cfnhan=1)
				begin
				while(@date<=29)
					begin
			if(@date=7 or @date=8 or @date=17 or  @date=18 or @date=27 or @date=28 )
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),2,0 from tempsplittheteam 
					 where idteam=4	
				end
				if(@date=1 or @date=10 or @date=11 or  @date=20 or @date=21)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),3,0 from tempsplittheteam 
					 where idteam=4		
				end
				if(@date=2 or @date=3 or @date=4 or @date=13 or @date=14 or @date=24 )
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),4,0 from tempsplittheteam 
					 where idteam=4	
				end
				if(@date=6 or @date=12 or  @date=16 or @date=19 or @date=26 )
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),1,0 from tempsplittheteam 
					 where idteam=4	
				end
				if( @date=23  or @date=5  or @date=9 or  @date=15  or @date=22 or @date=25 or @date=29)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT)  
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),0,0 from tempsplittheteam 
					 where idteam=4	
				end
				set @date+=1
					end
				end
			if(@cfnhan=0)
				begin
				while(@date<=28)
					begin
				if(@date=7 or @date=8 or @date=17 or  @date=18 or @date=27 or @date=28 )
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),2,0 from tempsplittheteam 
					 where idteam=4	
				end
				if(@date=1 or @date=10 or @date=11 or  @date=20 or @date=21)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),3,0 from tempsplittheteam 
					 where idteam=4		
				end
				if(@date=2 or @date=3 or @date=4 or @date=13 or @date=14 or @date=24 )
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),4,0 from tempsplittheteam 
					 where idteam=4	
				end
				if(@date=6 or @date=12 or  @date=16 or @date=19 or @date=26 )
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),1,0 from tempsplittheteam 
					 where idteam=4	
				end
				if( @date=23  or @date=5  or @date=9 or  @date=15  or @date=22 or @date=25)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT)  
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),0,0 from tempsplittheteam 
					 where idteam=4	
				end
				set @date+=1
					end
				end		
		end
	if(@month=4 or @month=6 or @month=9 or @month=11)
		begin
		while(@date<=30)
			begin
			if(@date=7 or @date=8 or @date=17 or  @date=18 or @date=27 or @date=28 )
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),2,0 from tempsplittheteam 
					 where idteam=4	
				end
				if(@date=1 or @date=10 or @date=11 or  @date=20 or @date=21 or @date=30)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),3,0 from tempsplittheteam 
					 where idteam=4		
				end
				if(@date=3 or @date=4 or @date=12 or @date=13 or @date=14  or @date=24 )
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),4,0 from tempsplittheteam 
					 where idteam=4	
				end
				if(@date=6 or  @date=16  or @date=19 or @date=26)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),1,0 from tempsplittheteam 
					 where idteam=4	
				end
				if(@date=2 or @date=5 or @date=9 or  @date=15 or @date=22 or  @date=23 or @date=25  or @date=29)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT)  
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),0,0 from tempsplittheteam 
					 where idteam=4	
				end
				set @date+=1
			end
		end
END

go
CREATE or alter PROC team5and4shift
@month tinyint,
@year decimal(4,0),
@cfnhan bit
AS
BEGIN
declare @date tinyint =1;
	if(@month=1 or @month=3 or @month=5 or @month=7 or @month=8 or @month=10 or @month=12)
	begin
	while(@date<=31)
			begin
			if(@date=9 or @date=10 or @date=19 or  @date=20 or @date=29 or @date=30 )
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),2,0 from tempsplittheteam 
					 where idteam=5	
				end
				if(@date=2 or @date=3 or @date=12 or  @date=13 or @date=22 or @date=23 )
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),3,0 from tempsplittheteam 
					 where idteam=5	
				end
				if(@date=5 or @date=6 or @date=15 or @date=16 or  @date=25 or @date=26 or @date=31 )
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),4,0 from tempsplittheteam 
					 where idteam=5
				end
				if(@date=11 or @date=21  or @date=28)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),1,0 from tempsplittheteam 
					 where idteam=5
				end
				if(@date=1 or @date=4 or @date=7 or  @date=8 or  @date=14 or  @date=17 or @date=18 or @date=24 or @date=27)
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),0,0 from tempsplittheteam 
					 where idteam=5
				end
				set @date+=1
			end
	end
	if(@month=2)
		begin
			if(@cfnhan=1)
				begin
				while(@date<=29)
					begin
				if(@date=9 or @date=10 or @date=19 or  @date=20 or @date=29 )
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),2,0 from tempsplittheteam 
					 where idteam=5
				end
				if(@date=2 or @date=3 or @date=12 or  @date=14 or @date=22 or @date=23 )
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),3,0 from tempsplittheteam 
					 where idteam=5	
				end
				if(@date=5 or @date=6 or @date=15 or @date=16 or  @date=25 or @date=26 )
				begin
						insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),4,0 from tempsplittheteam 
					 where idteam=5
				end
				if(@date=8 or @date=11 or @date=18 or @date=21 or @date=28 )
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),1,0 from tempsplittheteam 
					 where idteam=5
				end
				if(@date=1 or @date=4 or @date=7 or  @date=13 or  @date=17  or @date=24 or @date=27 )
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),0,0 from tempsplittheteam 
					 where idteam=5
				end
				set @date+=1
					end
				end
			if(@cfnhan=0)
				begin
				while(@date<=28)
					begin
					if(@date=9 or @date=10 or @date=19 or  @date=20  )
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),2,0 from tempsplittheteam 
					 where idteam=5
				end
				if(@date=2 or @date=3 or @date=12 or  @date=14 or @date=22 or @date=23 )
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),3,0 from tempsplittheteam 
					 where idteam=5	
				end
				if(@date=5 or @date=6 or @date=15 or @date=16 or  @date=25 or @date=26 )
				begin
						insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),4,0 from tempsplittheteam 
					 where idteam=5
				end
				if(@date=8 or @date=11 or @date=18 or @date=21 or @date=28 )
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),1,0 from tempsplittheteam 
					 where idteam=5
				end
				if(@date=1 or @date=4 or @date=7 or  @date=13 or  @date=17  or @date=24 or @date=27 )
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),0,0 from tempsplittheteam 
					 where idteam=5
				end
				set @date+=1
					end
				end		
		end
	if(@month=4 or @month=6 or @month=9 or @month=11)
		begin
		while(@date<=30)
			begin
				if(@date=9 or @date=10 or @date=19 or  @date=20 or @date=29 or @date=30 )
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),2,0 from tempsplittheteam 
					 where idteam=5	
				end
				if(@date=2 or @date=3 or @date=12 or @date=14 or @date=22 or @date=23 )
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),3,0 from tempsplittheteam 
					 where idteam=5	
				end
				if(@date=5 or @date=6 or @date=15 or @date=16 or  @date=25 or @date=26 )
				begin
						insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),4,0 from tempsplittheteam 
					 where idteam=5
				end
				if(@date=8 or @date=11 or @date=21 or @date=28 )
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),1,0 from tempsplittheteam 
					 where idteam=5
				end
				if(@date=1 or @date=4 or @date=7 or     @date=13  or  @date=17 or @date=18 or @date=24 or @date=27 )
				begin
					insert into Attendancerecord (idemp,[date],idShift,OT) 
					select idemp,[date]=CAST(CONCAT(@year,'-',@month,'-',@date) as date),0,0 from tempsplittheteam 
					 where idteam=5
				end
				set @date+=1
			end
		end
END

go
create or alter proc layshifttheongay
@idemp int,
@date date
AS
begin
select idShift from Attendancerecord   where idemp=@idemp and  [date]=@date                                         
end
go
create or alter proc chenhlechgio
@idShift int,
@nowtime time
AS
begin
declare @timein time =(select timein from [Shift] where idShift=@idShift)
SELECT DATEDIFF(MINUTE,@timein,@nowtime) 
end
go	
create or alter proc timekepingbyday
@month tinyint
AS
begin
update Attendancerecord set Timekeepingbyday=1 where month(date)=@month and validreason!=2
end
go
create or alter proc showattendancebyday
@day date
AS
begin
SELECT * FROM Attendancerecord where date=@day
end
go
create or alter proc searchattendancebyday1
@day date,
@key varchar(50)
AS
begin
SELECT Attendancerecord.idemp,idShift,seasondate,[date],checkin,checkout,Ot,reasoncheckin,reasoncheckout,validreason,Timekeepingbyday FROM Attendancerecord
inner join employee on Attendancerecord.idemp=employee.idemp
where date=@day and fullname like @key
end
go
create or alter proc searchattendancebyday2
@day date,
@key varchar(50),
@ihshift int
AS
begin
SELECT Attendancerecord.idemp,idShift,seasondate,[date],checkin,checkout,Ot,reasoncheckin,reasoncheckout,validreason,Timekeepingbyday FROM Attendancerecord
inner join employee on Attendancerecord.idemp=employee.idemp
where date=@day and fullname like @key and idShift=@ihshift
end
go
create or alter proc searchattendancebyday3
@day date,
@ihshift int
AS
begin
SELECT Attendancerecord.idemp,idShift,seasondate,[date],checkin,checkout,Ot,reasoncheckin,reasoncheckout,validreason,Timekeepingbyday FROM Attendancerecord
inner join employee on Attendancerecord.idemp=employee.idemp
where date=@day and idShift=@ihshift
end
go
create or alter proc countempopteam
AS
begin
select COUNT(idemp) as total from employee where iddep='OP' and sttemp=1                              
end
go

create or alter proc chiateam
@numteam1 int,
@numteam2 int,
@numteam3 int,
@numteam4 int,
@numteam5 int
AS
begin
delete tempsplittheteam
insert into tempsplittheteam (idemp,idteam) 
select idemp,idteam 
from (select top (@numteam1) idemp,idteam=1 from employee 
where iddep='OP' and sttemp=1 order by newid()) as t1

insert into tempsplittheteam (idemp,idteam) 
select idemp,idteam 
from (select top (@numteam2) idemp,idteam=2 from employee 
where iddep='OP' and idemp not in (select idemp from tempsplittheteam)
order by newid()) as t2

insert into tempsplittheteam (idemp,idteam) 
select idemp,idteam 
from (select top (@numteam3) idemp,idteam=3 from employee 
where iddep='OP' and sttemp=1 and idemp not in (select idemp from tempsplittheteam)
order by newid()) as t3

insert into tempsplittheteam (idemp,idteam) 
select idemp,idteam 
from (select top (@numteam4) idemp,idteam=4 from employee 
where iddep='OP' and sttemp=1 and idemp not in (select idemp from tempsplittheteam)
order by newid()) as t4

insert into tempsplittheteam (idemp,idteam) 
select idemp,idteam 
from (select top (@numteam5) idemp,idteam=5 from employee 
where iddep='OP' and sttemp=1 and idemp not in (select idemp from tempsplittheteam)
order by newid()) as t5
end
go
create or alter proc sumot
@idemp int,
@date date
AS
begin
  select sum(OT) as total from Attendancerecord where idemp=@idemp and MONTH(date)=MONTH(@date)                            
end
go
create or alter proc chenhlechthang
@date date
AS
begin
SELECT DATEDIFF(MONTH,@date,GETDATE()) 
end
go
create or alter proc chenhlechngay
@date date
AS
begin
SELECT DATEDIFF(DAY,@date,GETDATE()) 
end
go
create or alter proc chenhlechngay1
@date date
AS
begin
SELECT DATEDIFF(DAY,GETDATE(),@date) 
end
go

create or alter proc sovoingay1thangsau
@date date
AS
begin
declare @fdnm date
declare @m tinyint =(select MONTH(@date))
declare @y int =(select year(@date))
if(@m=12)
begin
set @fdnm =( cast(concat(@y+1,'-',01,'-',01) as date) )
end
if(@m!=12)
begin
set @fdnm =( cast(concat(@y,'-',@m+1,'-',01)as date))
end
SELECT DATEDIFF(DAY,@date,@fdnm) 
end
go
create or alter proc chenhlech2ngay
@date1 date,
@date2 date
AS
begin
SELECT DATEDIFF(DAY,@date1,@date2) 
end
go
create or alter proc chenhlechcheckinvaOut
@timein time,
@timeout time
AS
begin
SELECT DATEDIFF(MINUTE,@timein,@timeout) 
end
go
create or alter proc updateTimekyeepingbyday
@day Date
AS
begin
declare @idemp int=1
declare @maxidemp int = (select max(idemp) from employee)
	while(@idemp<=@maxidemp)
	begin
		declare @idshift tinyint=(SELECT idShift FROM  Attendancerecord where idemp=@idemp and [date]=@day)
		if(@idshift=1 or @idshift=2 or @idshift=3 or @idshift=4)
		begin
		update Attendancerecord set Timekeepingbyday=1 where idemp=@idemp and [date]=@day
		end
		if(@idshift=11 or @idshift=12 or @idshift=21 or @idshift=22 or @idshift=31 or @idshift=32 or @idshift=41 or @idshift=42)
		begin
		update Attendancerecord set Timekeepingbyday=0.5 where idemp=@idemp and [date]=@day
		end
		if(@idshift=0)
		begin
		update Attendancerecord set Timekeepingbyday=0 where idemp=@idemp and [date]=@day
		end
	set @idemp+=1
	end
end
go

create or alter proc Showdateleavebyid
@idrq int
AS
begin
select a.idemp,idShift,date from Attendancerecord a 
inner join requestleave r on a.idemp=r.idemp
inner join employee e on a.idemp=e.idemp
where r.idrqleave=@idrq and [date] between  r.fromdate and r.todate
end
go
CREATE OR ALTER PROC selectEmpHR
@rownum int
AS
BEGIN
declare @rownumintable int =(select (@rownum+1))
select t.idemp from (select ROW_NUMBER() OVER (ORDER BY employee.idemp) as rownum, employee.idemp,fullname,[typeid],[date],idShift
FROM employee 
inner join Attendancerecord on employee.idemp=Attendancerecord.idemp
WHERE [typeid] = 'HR' and idShift!=0 and [date]=cast(GETDATE() as date)) as t
 WHERE t.rownum= @rownumintable
ORDER BY fullname ASC 
END
GO
CREATE OR ALTER PROC updateleaveforemp
@idemp int,
@fromdate date,
@todate date
AS
BEGIN
update Attendancerecord set idShift=0 where idemp=@idemp and date between @fromdate and @todate
END
GO
CREATE OR ALTER PROC updateleaveforemp2
@idemp int,
@date date,
@idshift tinyint
AS
BEGIN
if( @idshift=1 or @idshift=2 or @idshift=3 or @idshift=4 )
begin
	update Attendancerecord set idShift=0 where idemp=@idemp and date=@date
	end
if( @idshift=11)
begin
	update Attendancerecord set idShift=12 where idemp=@idemp and date=@date
	end

if( @idshift=12)
begin
	update Attendancerecord set idShift=11 where idemp=@idemp and date=@date
	end

if( @idshift=21)
begin
	update Attendancerecord set idShift=22 where idemp=@idemp and date=@date
	end

if( @idshift=22)
begin
	update Attendancerecord set idShift=21 where idemp=@idemp and date=@date
	end

if( @idshift=31)
begin
	update Attendancerecord set idShift=32 where idemp=@idemp and date=@date
	end

if( @idshift=32)
begin
	update Attendancerecord set idShift=31 where idemp=@idemp and date=@date
	end

if( @idshift=41)
begin
	update Attendancerecord set idShift=42 where idemp=@idemp and date=@date
	end

if( @idshift=42)
begin
	update Attendancerecord set idShift=41 where idemp=@idemp and date=@date
	end
end
GO


CREATE OR ALTER PROC insertatdreport
@idemp int,
@month tinyint,
@totaltimekeeping decimal(3,1),
@totalworkHL decimal(3,1),
@totalworkoffday decimal(3,1),
@totalshift3 decimal(3,1),
@totalshift4 decimal(3,1),
@totalworkfullday tinyint,
@totalOTonday decimal(3,1),
@totalOToffday decimal(3,1),
@totalOTHL decimal(3,1),
@totalOToffHL decimal(3,1),
@validreason1 tinyint,
@validreason2 tinyint
AS
BEGIN
	insert into Attendancemonthlyreport 
	(idemp,[month],totaltimekeeping,totalworkHL,totalworkoffday,totalshift3,totalshift4,totalworkfullday,
	totalOTonday,totalOToffday,totalOTHL,totalOToffHL,validreason1,validreason2)
	values (@idemp,@month,@totaltimekeeping,@totalworkHL,@totalworkoffday,@totalshift3,@totalshift4,@totalworkfullday,
	@totalOTonday,@totalOToffday,@totalOTHL,@totalOToffHL,@validreason1,@validreason2)
END
GO
CREATE OR ALTER PROC totaltimekeeping
@idemp int,
@month tinyint
AS
BEGIN
select COUNT(idemp) as totaltimekeeping FROM Attendancerecord where idemp=@idemp and month(date)=@month and Timekeepingbyday!=0
END
GO
CREATE OR ALTER PROC totalworkHL
@idemp int,
@fromdate date,
@todate date
AS
BEGIN
select COUNT(idemp) as totaltimekeeping FROM Attendancerecord 
where idemp=@idemp and date between @fromdate and @todate and idShift!=0
and Timekeepingbyday!=0
END
GO
CREATE OR ALTER PROC totalworkoffday
@idemp int,
@fromdate date,
@todate date
AS
BEGIN
select COUNT(idemp) as totaltimekeeping FROM Attendancerecord 
where idemp=@idemp and date between @fromdate and @todate and idShift!=0
END
GO
CREATE OR ALTER PROC totalshift3
@idemp int,
@month tinyint
AS
BEGIN
select COUNT(idemp) as totaltimekeeping FROM Attendancerecord 
where idemp=@idemp and MONTH(date)=@month and (idShift=3 or idShift=32) and Timekeepingbyday!=0
END
GO
CREATE OR ALTER PROC totalshift4
@idemp int,
@month tinyint
AS
BEGIN
select COUNT(idemp) as totaltimekeeping FROM Attendancerecord 
where idemp=@idemp and MONTH(date)=@month and (idShift=4 or idShift=42) and Timekeepingbyday!=0
END
GO
CREATE OR ALTER PROC totalworkfullday
@idemp int,
@month tinyint
AS
BEGIN
select COUNT(idemp) as totaltimekeeping FROM Attendancerecord 
where idemp=@idemp and MONTH(date)=@month and Timekeepingbyday=1
END
GO

CREATE OR ALTER PROC validreason
@idemp int,
@season tinyint,
@month tinyint
AS
BEGIN
select count(validreason) as totaltimekeeping FROM Attendancerecord 
where idemp=@idemp and validreason=@season and MONTH(date)=@month
END
GO
CREATE OR ALTER PROC totalsalarydeduction
@idemp int,
@month tinyint,
@validreason1 tinyint,
@validreason2 tinyint
AS
BEGIN
declare @totalsalarydeduction decimal(8,0)
if(@validreason1<=3)
begin
set @totalsalarydeduction=(0+@validreason2 *500000)
update Attendancemonthlyreport set totalsalarydeduction=@totalsalarydeduction where idemp=@idemp and [month]=@month
end
if(@validreason1 >3 and @validreason1 <=5)
begin
set @totalsalarydeduction=(200000+@validreason2 *500000)
update Attendancemonthlyreport set totalsalarydeduction=@totalsalarydeduction where idemp=@idemp and [month]=@month
end
if(@validreason1 >5)
begin
set @totalsalarydeduction=(500000+@validreason2 *500000)
update Attendancemonthlyreport set totalsalarydeduction=@totalsalarydeduction where idemp=@idemp and [month]=@month
end
END
GO
create or alter proc selectmaxid
as
begin
select max(idemp) as idcaonhat from employee
end
go
--tong OT ngay off day ko co HL va ko co nghi bu
CREATE OR ALTER PROC totalOT_offdaymonth_noHL
@idemp int,
@month tinyint
AS
BEGIN
select sum(OT) as totaltimekeeping FROM Attendancerecord 
where idemp=@idemp and MONTH(date)=@month and idShift=0 
END
GO
--tinh tong OT ngay on day ma thang ko có hl, ko co nghi bu
CREATE OR ALTER PROC totalOTondayNoHL
@idemp int,
@month tinyint
AS
BEGIN
select sum(OT) as totaltimekeeping FROM Attendancerecord 
where idemp=@idemp and MONTH(date)=@month and idShift!=0
END
GO
--tinh tong OT ngay on day ma thang có hl,  co nghi bu
CREATE OR ALTER PROC totalOTOndaymonth_HLandOffHL
@idemp int,
@fromDateHL date,
@toDateHL date,
@fromDateoffHL date,
@toDateHLoffHL date
AS
BEGIN
select sum(OT) as totaltimekeeping FROM Attendancerecord 
where idemp=@idemp and idShift!=0 
and [date] not in(select date from Attendancerecord 
where (date between @fromDateHL and @toDateHL) and (date between @fromDateoffHL and @toDateHLoffHL))
END
GO
--tinh OT OFF DAY co HL va co nghi bu
CREATE OR ALTER PROC totalOToffdaymonthHLandOffHL
@idemp int,
@fromDateHL date,
@toDateHL date,
@fromDateoffHL date,
@toDateHLoffHL date
AS
BEGIN
select sum(OT) as totaltimekeeping FROM Attendancerecord 
where idemp=@idemp and idShift=0 
and [date] not in(select date from Attendancerecord 
where (date between @fromDateHL and @toDateHL) and (date between @fromDateoffHL and @toDateHLoffHL))
END
GO
--Tinh OT neu lam vao ngay HL/ NGHI BU 
CREATE OR ALTER PROC totalOTHLOrNghiBu
@idemp int,
@fromdate date,
@todate date
AS
BEGIN
select sum(OT) as totaltimekeeping FROM Attendancerecord 
where idemp=@idemp and  date between @fromdate and @todate
END
GO
--tinh OT neu lam vao ngay on day thang co nghi le HOAC nghi bu
CREATE OR ALTER PROC totalOTOnDaymaybeHL
@idemp int,
@fromdate date,
@todate date
AS
BEGIN
select sum(OT) as totaltimekeeping FROM Attendancerecord 
where idemp=@idemp and idShift!=0 and
date not in ( select date from Attendancerecord where date between @fromdate and @todate)
END
GO
--tinh OT neu lam vao OFF DAY co nghi le HOAC nghi bu
CREATE OR ALTER PROC totalOTOffDaymaybeHL
@idemp int,
@fromdate date,
@todate date
AS
BEGIN
select sum(OT) as totaltimekeeping FROM Attendancerecord 
where idemp=@idemp and idShift=0 and 
date not in ( select date from Attendancerecord where date between @fromdate and @todate)
END
GO

CREATE OR ALTER PROC checkreport
@month tinyint
AS
BEGIN
select count([month]) from Attendancemonthlyreport where [month]=@month
END
GO
CREATE OR ALTER PROC deletereport
@month tinyint
AS
BEGIN
delete from Attendancemonthlyreport where [month]=@month
END
GO
CREATE OR ALTER PROC getvaluefromemprqs
@idrq tinyint
AS
BEGIN
select a.idemp,a.idShift,a.date from requestchangeShift r
inner join employee e on e.idemp=r.fromidemp
inner join Attendancerecord a on r.fromidemp=a.idemp and r.datechange=a.date
where r.idrqcShift=@idrq
END
GO
CREATE OR ALTER PROC getvaluetoemprqs
@idrq tinyint
AS
BEGIN
select a.idemp,a.idShift,a.date from requestchangeShift r
inner join employee e on e.idemp=r.toidemp
inner join Attendancerecord a on r.toidemp=a.idemp and r.datechange=a.date
where r.idrqcShift=@idrq
END
GO
CREATE OR ALTER PROC deleterequestleave
AS
BEGIN 
update requestleave set sttrequestleave=5
WHERE  idrqleave in (select idrqleave from ( SELECT idrqleave, DATEDIFF(DAY,deadline,getdate()) as t
				from requestleave 
				where sttrequestleave !=3 and sttrequestleave !=4 and sttrequestleave !=5) tem where tem.t=0)
				or cast (getdate() as date)=fromdate
END
GO
CREATE OR ALTER PROC deleterequestChangeshift
AS
BEGIN 
update requestchangeShift set sttrequestchangeShift=5
WHERE  idrqcShift in (select idrqcShift from ( SELECT idrqcShift, DATEDIFF(DAY,deadline,getdate()) as t
				from requestchangeShift 
				where sttrequestchangeShift !=3 and sttrequestchangeShift !=5) tem where tem.t=0)				
END
GO

--proc de inpit du lieu
create or alter proc updateTimekyeepingbydaybymonth1
@month int
AS
begin
declare @idemp int=1
declare @maxidemp int = (select max(idemp) from employee)
	while(@idemp<=@maxidemp)
	begin	
update Attendancerecord set Timekeepingbyday=1 where idemp=@idemp and MONTH(date) = @month and ([idShift]=1 or [idShift]=2 or [idShift]=4 or [idShift]=3)	
	set @idemp+=1
	end
end
go
create or alter proc updateTimekyeepingbydaybymonth2
@month int
AS
begin
declare @idemp int=1
declare @maxidemp int = (select max(idemp) from employee)
	while(@idemp<=@maxidemp)
	begin	

update Attendancerecord set Timekeepingbyday=0.5 where idemp=@idemp and MONTH(date) = @month 
	and ([idShift]=11 or [idShift]=12 or [idShift]=21 or [idShift]=22 or [idShift]=321 or [idShift]=32 or [idShift]=41 or [idShift]=42)

	
	set @idemp+=1
	end
end
go
create or alter proc updateTimekyeepingbydaybymonth3
@month int
AS
begin
declare @idemp int=1
declare @maxidemp int = (select max(idemp) from employee)
	while(@idemp<=@maxidemp)
	begin	

update Attendancerecord set Timekeepingbyday=0 where idemp=@idemp and MONTH(date) = @month and ([idShift]=0)
	
	set @idemp+=1
	end
end
go
--thang 9
delete tempsplittheteam
go
insert into tempsplittheteam values(3,1)
go
insert into tempsplittheteam values(5,1)
go
insert into tempsplittheteam values(9,1)
go
insert into tempsplittheteam values(4,2)
go
insert into tempsplittheteam values(11,2)
go
insert into tempsplittheteam values(15,2)
go
insert into tempsplittheteam values(13,4)
go
insert into tempsplittheteam values(10,4)
go
insert into tempsplittheteam values(16,4)
go
insert into tempsplittheteam values(8,3)
go
insert into tempsplittheteam values(17,3)
go
insert into tempsplittheteam values(7,3)
go
insert into tempsplittheteam values(6,5)
go
insert into tempsplittheteam values(12,5)
go
insert into tempsplittheteam values(14,5)
go
exec team1and4shift 9,2021,0
go
exec team2and4shift 9,2021,0
go
exec team3and4shift 9,2021,0
go
exec team4and4shift 9,2021,0
go
exec team5and4shift 9,2021,0
go

exec Xuaninsertshiftofoffice 9,2021,0
go
exec updatehlforOF '2021-09-02','2021-09-03'
go
exec updatehlforOP '2021-09-02','2021-09-03',1
go
--thang 10
exec team1and4shift 10,2021,0
go
exec team2and4shift 10,2021,0
go
exec team3and4shift 10,2021,0
go
exec team4and4shift 10,2021,0
go
exec team5and4shift 10,2021,0
go
exec Xuaninsertshiftofoffice 10,2021,0
go

update Attendancerecord set checkin=cast('07:59:00' as datetime), checkout=cast('17:01:00' as time) where idShift=1 and MONTH([date]) = 9
go
update Attendancerecord set checkin=cast('05:59:00' as datetime), checkout=cast('15:01:00' as time) where idShift=2 and MONTH([date])  = 9
go
update Attendancerecord set checkin=cast('10:59:00' as datetime), checkout=cast('20:01:00' as time) where idShift=3 and MONTH([date])  = 9
go
update Attendancerecord set checkin=cast('13:59:00' as datetime), checkout=cast('23:01:00' as time) where idShift=4 and MONTH([date])  = 9
go
update Attendancerecord set checkin=CAST('11:30' as time),reasoncheckin='work reason',validreason=3 where idemp=10 and [date]='2021-09-01'
go
update Attendancerecord set checkin=CAST('06:50' as time),reasoncheckin='personal reason',validreason=1 where idemp=5 and [date]='2021-09-01'
go
update Attendancerecord set checkout=CAST('19:30' as time),reasoncheckout='tired',validreason=1 where idemp=7 and [date]='2021-09-09'
go
update Attendancerecord set checkin=CAST('11:40' as time),reasoncheckout='damaged car',validreason=1 where idemp=7 and [date]='2021-09-28'
go
update Attendancerecord set checkout=CAST('16:00' as time),reasoncheckout='personal work',validreason=1 where idemp=7 and [date]='2021-09-14'
go
update Attendancerecord set checkout=CAST('22:00' as time),reasoncheckout='tired',validreason=1 where idemp=7 and [date]='2021-09-11'
go
update Attendancerecord set checkin=CAST('11:20' as time),reasoncheckin='damaged car',validreason=1 where idemp=8 and [date]='2021-09-09'
go
update Attendancerecord set checkout=CAST('14:30' as time),reasoncheckout='Traffic jam',validreason=1 where idemp=8 and [date]='2021-09-05'
go
update Attendancerecord set checkout=CAST('22:00' as time),reasoncheckout='damaged car',validreason=1 where idemp=8 and [date]='2021-09-11'
go
update Attendancerecord set checkin=CAST('08:30' as time),reasoncheckin='tired',validreason=1 where idemp=8 and [date]='2021-09-14'
go
update Attendancerecord set checkin=CAST('12:00' as time),reasoncheckin='go to hospital',validreason=1 where idemp=8 and [date]='2021-09-18'
go
update Attendancerecord set checkout=CAST('19:00' as time),reasoncheckout='Traffic jam',validreason=1 where idemp=8 and [date]='2021-09-19'
go
update Attendancerecord set checkin=CAST('11:15' as time),reasoncheckin='damaged car',validreason=1 where idemp=17 and [date]='2021-09-09'
go
update Attendancerecord set checkout=CAST('12:00' as time),reasoncheckout='late',validreason=2 where idemp=17 and [date]='2021-09-19'
go
update Attendancerecord set checkin=CAST('06:30' as time),reasoncheckin='go to hospital',validreason=1 where idemp=6 and [date]='2021-09-20'
go
update Attendancerecord set checkin=CAST('08:30' as time),reasoncheckin='tired',validreason=1 where idemp=6 and [date]='2021-09-28'
go
update Attendancerecord set validreason=4 where month(date)=9 and reasoncheckin is null and reasoncheckout is null
go
update Attendancerecord set OT=4 where idemp=6 and [date]='2021-09-15'
go
exec updateTimekyeepingbydaybymonth1 9
go
go
exec updateTimekyeepingbydaybymonth2 9
go
exec updateTimekyeepingbydaybymonth3 9
go
update Attendancerecord set seasondate=4 ,idShift=0 where idemp=4 and date='2021-09-27'
go
update Attendancerecord set seasondate=6,idShift=0 where idemp=9 and date='2021-09-15'
go
update Attendancerecord set seasondate=6,idShift=0 where idemp=10 and date='2021-10-03'
go
update Attendancerecord set seasondate=3,idShift=31 where idemp=4 and date='2021-10-07'
go
update Attendancerecord set checkin=cast('07:59:00' as datetime), checkout=cast('17:01:00' as time) where idShift=1 and date between '2021-10-01' and '2021-10-06'
go
update Attendancerecord set checkin=cast('05:59:00' as datetime), checkout=cast('15:01:00' as time) where idShift=2 and date between '2021-10-01' and '2021-10-06'
go
update Attendancerecord set checkin=cast('10:59:00' as datetime), checkout=cast('20:01:00' as time) where idShift=3 and date between '2021-10-01' and '2021-10-06'
go
update Attendancerecord set checkin=cast('13:59:00' as datetime), checkout=cast('23:01:00' as time) where idShift=4 and date between '2021-10-01' and '2021-10-06'
go
update Attendancerecord set checkin=CAST('11:30' as time),reasoncheckin='work reason',validreason=0 where idemp=10 and [date]='2021-10-01'
go
update Attendancerecord set checkout=CAST('14:30' as time),reasoncheckout='Traffic jam',validreason=0 where idemp=8 and [date]='2021-10-05'
go
update Attendancerecord set checkin=cast('07:59:00' as datetime) where idemp=1 and [date]='2021-10-07'
go
update Attendancerecord set checkin=cast('07:59:00' as datetime) where idemp=18 and [date]='2021-10-07'
go
update Attendancerecord set checkin=cast('07:59:00' as datetime) where idemp=19 and [date]='2021-10-07'
go
update Attendancerecord set checkin=cast('05:59:00' as datetime) where idemp=16 and [date]='2021-10-07'
go
update Attendancerecord set checkin=cast('05:59:00' as datetime) where idemp=13 and [date]='2021-10-07'
go
update Attendancerecord set seasondate=8,idShift=0 where idemp=5 and date='2021-10-05'
go
update Attendancerecord set OT=12 where idemp=10 and date='2021-10-02'
go
update Attendancerecord set OT=4 where idemp=10 and date='2021-10-04'
go
update Attendancerecord set OT=12 where idemp=10 and date='2021-10-05'
go
update Attendancerecord set OT=12 where idemp=10 and date='2021-10-22'

