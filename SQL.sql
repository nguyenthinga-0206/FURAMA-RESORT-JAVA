create database caseStudy;

use caseStudy;

create table trinhdo(
id_trinhdo nvarchar(15) not null primary key ,
ten_trinhdo nvarchar(250) not null
);
create table vitri(
id_vitri  nvarchar(15) not null primary key ,
ten_vitri nvarchar(250) not null
);
create table bophan(
id_bophan  nvarchar(15) not null primary key ,
ten_bophan nvarchar(250) not null
);
create table diachi(
id_diachi  nvarchar(15) not null primary key ,
sonha nvarchar(250) not null,
xa  nvarchar(250) not null,
huyen nvarchar(250) not null,
tinh nvarchar(250) not null,
quocgia nvarchar(250) not null
);
create table user(
ten_user nvarchar(250) not null primary key ,
matkhau  nvarchar(250) not null
);
create table vaitro(
vaitro_id  nvarchar(15) not null primary key ,
ten_vaitro  nvarchar(250) not null
);
create table user_vaitro(
vaitro_id  nvarchar(15) not null ,
ten_user  nvarchar(250) not null,
primary key (vaitro_id,ten_user),
foreign key(ten_user) references  user(ten_user) on delete cascade,
foreign key(vaitro_id) references  vaitro(vaitro_id) on delete cascade
);
create table nhanvien(
id_nhanvien nvarchar(15) not null primary key ,
ten_nhanvien nvarchar(250) not null,
ngaysinh  nvarchar(250) not null,
socmnd int not null,
sdt int not null,
email nvarchar(250) not null,
id_trinhdo  nvarchar(15) ,
foreign key(id_trinhdo) references trinhdo(id_trinhdo) on delete cascade,
id_vitri nvarchar(15) ,
foreign key(id_vitri) references vitri(id_vitri)on delete cascade,
id_bophan  nvarchar(15),
foreign key(id_bophan) references bophan(id_bophan) on delete cascade,
luong float ,
id_diachi  nvarchar(15) not null,
foreign key(id_diachi) references diachi(id_diachi) on delete cascade,
ten_user nvarchar(250) not null ,
foreign key(ten_user) references user(ten_user) on delete cascade
);
create table kieuthue(
id_kieuthue  nvarchar(5) not null primary key ,
ten_kieuthue nvarchar(250) not null
);
create table dichvu(
id_dichvu  nvarchar(15) not null primary key ,
ten_dichvu  nvarchar(250) not null,
dientich float,
chiphi float,
songuoi  nvarchar(250) not null,
id_kieuthue nvarchar(15) not null ,
foreign key(id_kieuthue) references kieuthue(id_kieuthue) on delete cascade
);
create table house(
id_house nvarchar(15) not null primary key ,
ten_house nvarchar(250) not null,
tieuchuaphong  nvarchar(250) not null,
mota  nvarchar(250) not null,
sotang int,
id_dichvu nvarchar(15) not null ,
foreign key(id_dichvu) references dichvu(id_dichvu) on delete cascade
);
create table villa(
id_villa nvarchar(15) not null primary key ,
ten_villa  nvarchar(250) not null,
tieuchuaphong  nvarchar(250) not null,
mota  nvarchar(250) not null,
dientichhoboi float,
sotang int,
id_dichvu nvarchar(15) not null ,
foreign key(id_dichvu) references dichvu(id_dichvu) on delete cascade
);
create table  room(
id_room nvarchar(15) not null primary key ,
ten_room  nvarchar(250) not null,
tendichvufreedikem  nvarchar(250) not null,
id_dichvu nvarchar(15) not null ,
foreign key(id_dichvu) references dichvu(id_dichvu) on delete cascade
);
create table dvdikem(
 id_dvdikem nvarchar(15) not null primary key ,
 ten_dvdikem  nvarchar(250) not null,
 dongia  nvarchar(250) not null,
 tien float
);
create table loaikhach( 
id_loaikhach  nvarchar(15) not null primary key ,
ten_loaikhach nvarchar(250) not null
);
create table khachhang(
id_khachhang nvarchar(15) not null primary key ,
ten_khachhang  nvarchar(250) not null,
ngaysinh  nvarchar(250) not null,
gioitinh  nvarchar(250) not null,
socmnd int,
sdt int,
email  nvarchar(250) not null,
id_loaikhach  nvarchar(15) not null,
foreign key(id_loaikhach) references loaikhach(id_loaikhach)on delete cascade,
id_diachi  nvarchar(15) not null, 
foreign key(id_diachi) references diachi(id_diachi) on delete cascade
);
create table hopdong(
id_hopdong nvarchar(15) not null primary key ,
ngaybatau  nvarchar(250),
ngayketthuc  nvarchar(250),
sotiendatcuoc float,
tongsotienthanhtoan float,
id_nhanvien nvarchar(15) not null,
foreign key(id_nhanvien) references nhanvien(id_nhanvien) on delete cascade,
id_khachhang nvarchar(15) not null,
foreign key(id_khachhang) references khachhang(id_khachhang) on delete cascade,
id_dichvu nvarchar(15) not null,
foreign key(id_dichvu) references dichvu(id_dichvu) on delete cascade
);
create table hopdong_dvdikem(
id_dvdikem  nvarchar(15) not null,
id_hopdong  nvarchar(15) not null,
soluong int ,
primary key (id_dvdikem, id_hopdong),
foreign key( id_dvdikem) references dvdikem(id_dvdikem) on delete cascade,
foreign key( id_hopdong) references hopdong(id_hopdong) on delete cascade
);


-- thực hiện yêu cầu 

-- 1 thêm mới thông tin các bảng
insert into trinhdo( id_trinhdo,ten_trinhdo ) value
('TD01','trung cấp'),
('TD02','cao đẳng'),
('TD03','đại học'),
('TD04','sau đại học');

 insert into vitri(id_vitri,ten_vitri) value
('VT01','lễ tân'),
('VT02','phục vụ'),
('VT03','chuyên viên'),
('VT04','giám sát'),
('VT05','quản lý'),
('VT06','giám đốc');

 insert into bophan(id_bophan,ten_bophan) value
 ('BP01','sale_marketing'),
 ('BP02','hành chính'),
 ('BP03','phục vụ'),
 ('BP04','quản lý');
  insert into diachi(id_diachi,sonha,xa,huyen,tinh,quocgia) value
  ('DC01','kiệt 98 NGuyễn lương bằng','Hòa khánh  Bắc','Liên Chiểu','Đà Nẵng','Việt Nam'),
  ('DC02','08 hà văn tính','Hòa khánh Nam','Liên Chiểu','Đà Nẵng','Việt Nam'),
  ('DC03','Thổ 2',' Bình Đào','Thăng Bình','Quảng Nam','Việt Nam'),
  ('DC04','Chò tráng','Cao Ngọc','Ngọc Lặc','Thanh Hóa','Việt Nam'),
  ('DC05','kiệt 9 Trà Lương','Trà Đỏa','Gia Lâm','Hà Nội','Việt Nam'),
  ('DC06','làng ngọc','cao ngọc','ngoc thanh','thanh hoa','Việt Nam'),
  ('DC07','hem 76','phù luông','bá thước','hà tinh','Việt Nam'),
  ('DC08','kiệt 54 truong giang','bình tan','Gia Lâm','quảng ngãi','Việt Nam'),
  ('DC09','làng chôm','Trà Đỏa','trang khánh','Hà Nội','Việt Nam'),
  ('DC10','hẻm 1','Thôn 1','xã 1','vinh','Việt Nam');
  
insert into user(ten_user, matkhau) value
('user1','11111'),
('user2','22222'),
('user3','33333'),
('user4','44444'),
('user5','55555');

insert into vaitro(vaitro_id, ten_vaitro) value
('admin','giamdoc'),
('sv','quanlysv'),
('kh','quanlykh'),
('dv','quanlydv'),
('hd','quanlyhd');

insert into user_vaitro(vaitro_id, ten_user) value
('admin','user1'),
('sv','user2'),
('kh','user3'),
('dv','user4'),
('hd','user5');

select ten_user from user_vaitro inner join vaitro 
 on user_vaitro.vaitro_id= vaitro.vaitro_id where vaitro.ten_vaitro ='giamdoc';
select * from user_vaitro;




insert into nhanvien(id_nhanvien,ten_nhanvien,ngaysinh,socmnd,sdt,email,id_trinhdo,id_vitri,id_bophan,luong,id_diachi,ten_user ) value
('NV01','Phạm Thị Quỳnh Như','2000/09/28','123456789','1234432154','quynhnhuctcn@gmail.com','TD03','VT05','BP04','50000000','DC06','user1'),
('NV02','Trần Mỹ Hạnh','1989/04/08','111111111','567887867','tranhanh@gmail.com','TD04','VT03','BP02','24000000','DC07','user2'),
('NV03','Nguyễn Trung Trọng','1999/12/03','222222222','987809675','trungtrong@gmail.com','TD03','VT02','BP03','14000000','DC08','user3'),
('NV04','Trần Thanh phương','1979/01/24','33333333','876678945','phuongtran@gmail.com','TD04','VT06','BP04','60000000','DC09','user4'),
('NV05','Doãn Mạnh Thắng','1998/04/15','444444444','987657812','manhthang@gmail.com','TD02','VT04','BP01','67000000','DC10','user5');

insert into kieuthue(id_kieuthue,ten_kieuthue) value 
('KT01','năm'),
('KT02','thang'),
('KT03','ngay'),
('KT04','giờ');


insert into dichvu(id_dichvu,ten_dichvu,dientich,chiphi,songuoi,id_kieuthue) value
('DV01','Room','300000','7000','4','KT04'),
('DV02','Room','300000','10000000','4','KT03'),
('DV03','Room','300000','290000000','4','KT02'),
('DV04','Room','300000','100000000','4','KT01'),
('DV05','House','4700000','20000000','20','KT04'),
('DV06','House','4700000','400000000','20','KT03'),
('DV07','House','4700000','700000000','20','KT02'),
('DV08','House','4700000','10000000000','20','KT01'),
('DV09','Villa','5000000','70000000','25','KT03'),
('DV10','Villa','5000000','100000000','15','KT02'),
('DV11','Villa','5000000','200000000','23','KT01'),
('DV12','Villa','5000000','21540000','20','KT04');

insert into room(id_room, ten_room,tendichvufreedikem,id_dichvu) value
('R01','Room1','nuoc','DV01'),
('R02','Room2','nuoc','DV03'),
('R03','Room3','sữa tắm','DV03'),
('R04','Room4','karaoke','DV02'),
('R05','Room5','trái cây','DV04');

insert into house(id_house,ten_house,tieuchuaphong,mota,sotang,id_dichvu) value
('H01','House1','vip','có điều hòa, máy giặt, bồn tắm',10,'DV08'),
('H02','House2','trung bình','co dieu hoa may giat',7,'DV07'),
('H03','House3','thương gia','có điều hòa, máy lạnh, bồn tắm, tủ lạnh',8,'DV06'),
('H04','House4','bình dan','có máy lạnh',5,'DV05');

insert into villa(id_villa,ten_villa,tieuchuaphong ,mota,dientichhoboi,sotang,id_dichvu) value
('V01','Villa1','vip','có điều hòa, máy giặt, bồn tắm','3460',10,'DV12'),
('V02','Villa2','trung bình','co dieu hoa may giat',7,'50000','DV11'),
('V03','Villa3','thương gia','có điều hòa, máy lạnh, bồn tắm, tủ lạnh','5000',8,'DV10'),
('V04','Villa4','bình dan','có máy lạnh','560',5,'DV09');

   insert into dvdikem( id_dvdikem, ten_dvdikem, dongia,tien) value
   ('DK01','massage','giờ','500000'),
   ('DK02','karaoke','giờ','60000'),
   ('DK03','thức ăn','dĩa','100000'),
   ('DK04','nước uống','chai','30000'),
   ('DK05','thuê xe','gio','120000');
   
    insert into loaikhach(id_loaikhach,ten_loaikhach) value
    ('LK01','Diamond'),
	('LK02','Platinnium'),
	('LK03','Gold'),
	('LK04','Silver'),
	('LK05','Member');
    
 insert into khachhang(id_khachhang,ten_khachhang,ngaysinh,gioitinh,socmnd,sdt,email,id_loaikhach,id_diachi) values
 ('KH94','Kh94','004/08/15','nu','1234','1232','email','LK01','DC04');


insert into khachhang( id_khachhang,ten_khachhang,ngaysinh,gioitinh,socmnd,sdt,email,id_loaikhach, id_diachi) value
('KH01','Phạm Thùy Linh','2004/08/15','nu','999999999','1234554321','thuylinh123@gmail.com','LK03','DC04'),
('KH02','Phạm Thị Như Quỳnh','1997/08/15','nu','888888888','0987667867','nhuquynh@gmail.com','LK02','DC05'),
('KH03','Nguyễn Thị Nga','2000/06/02','nu','55555555','1111111111','nguyennga13@gmail.com','LK04','DC02'),
('KH04','Trần Ngọc Huy','2000/10/14','nam','876923401','0358693432','truongduc910@gmail.com','LK01','DC03'),
('KH05','Phạm Văn Tánh','1999/08/05','nam','345345549','1233212321','tanhpham@gmail.com','LK05','DC01'),
('KH06','Trần Ngọc Huy','2000/10/14','nam','876923401','0358693432','truongduc910@gmail.com','LK01','DC03'),
('KH08','Trần Yến Nhi','2003/10/14','nam','876923401','0322293432','yennhi@gmail.com','LK01','DC03'),
('KH09','Nguyễn Thị Nhung','2000/03/15','nu','345679999','888954321','Nhungnguyen3@gmail.com','LK01','DC02');
select * from hopdong;
select * from nhanvien;
select * from khachhang;
select * from dichvu;
select * from hop;

  insert into hopdong( id_hopdong, ngaybatau,  ngayketthuc, sotiendatcuoc,tongsotienthanhtoan ,  id_nhanvien, id_khachhang ,  id_dichvu) value
--  ('HD12','2021/12/12','2021/4/12','4500000','450000000','NV03','KH05','DV10');
  ('HD01','2020/12/10','2020/12/10','3000000','30000000','NV02','KH01','DV01'),
  ('HD02','2021/02/10','2021/2/25','10000000','50000000','NV03','KH02','DV02'),
  ('HD03','2021/04/10','2021/6/10','4000000','60000000','NV05','KH04','DV07'),
  ('HD04','2020/12/10','2021/12/10','30000000','900000000','NV03','KH03','DV08'),
  ('HD05','2021/03/12','2021/4/12','4500000','450000000','NV03','KH05','DV10'),
  ('HD06','2021/03/12','2021/4/12','4500000','450000000','NV02','KH06','DV10'),
   ('HD07','2019/02/12','2021/06/12','45060000','450000000','NV05','KH09','DV08'),
  ('HD08','2021/05/17','2021/06/12','45060000','450000000','NV02','KH06','DV11'),
  ('HD09','2019/02/12','2021/06/12','45060000','450000000','NV01','KH09','DV10'),
  ('HD10','2018/02/12','2021/06/12','45060000','450000000','NV02','KH94','DV01'),
('HD11','2019/07/07','2021/06/12','340000','543000000','NV03','KH04','DV12');
select * from hopdong_dvdikem;
select * from  dvdikem;
 insert into hopdong_dvdikem( id_dvdikem , id_hopdong,soluong) value
  ('DK02','HD12','5'),
   ('DK05','HD12','5'),
   ('DK03','HD08','7'),
  ('DK01','HD10','7'),
('DK05','HD09','5'),
 ('DK02','HD01','4'),
 ('DK01','HD02','6'),
 ('DK02','HD03','3'),
 ('DK03','HD04','6'),
 ('DK05','HD05','9'),
 ('DK04','HD05','5'),
 ('DK05','HD04','4'),
 ('DK02','HD04','3');

 -- -- -- -- -- -- -- -- -- --  2 -- -- -- -- -- 
 -- 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K”
 -- và có tối đa 15 ký tự.
 select * from nhanvien
  where  (ten_nhanvien like 'H%' or  ten_nhanvien like  't%' or  ten_nhanvien like 'k%') and length(ten_nhanvien) <=15; 


-- -- -- -- -- -- -- -- --  3 -- -- -- -- -- -- 
-- . khachhangHiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
 select * from khachhang 
 left join diachi on khachhang.id_diachi = diachi.id_diachi
 where  (year(now()) - year(ngaysinh) >=18 AND year(now()) - year(ngaysinh) <=40) AND (  tinh = 'Đà Nẵng' OR tinh='Quảng Trị'); 

--  thongo tin  khach hang
 select id_khachhang,ten_khachhang,ngaysinh,gioitinh,socmnd,sdt,email,ten_loaikhach, sonha,xa,huyen,tinh,quocgia ,loaikhach.id_loaikhach, diachi.id_diachi from khachhang 
 left join diachi on khachhang.id_diachi = diachi.id_diachi
 left join loaikhach on loaikhach.id_loaikhach = khachhang.id_loaikhach;
 
 

-- -- -- -- -- -- -- -- -- --  4-- -- -- -- -- -- -- -- -- -- -- 
 --   4. Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần.
 -- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng.
 -- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
 
select  ten_khachhang ,hopdong.id_hopdong , count(*) as solanhopdong from (hopdong 
inner join khachhang on khachhang.id_khachhang = hopdong.id_khachhang)
 inner join loaikhach on  loaikhach.id_loaikhach = khachhang.id_loaikhach 
where ten_loaikhach = 'diamond' 
group by ten_khachhang 
 order by solanhopdong;   -- mạc định tăng dần,  DESC giảm dần
 
 
 -- -- -- -- 5-- -- -- -- -- -- -- 
 --  5.	Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong,
 -- TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien (Với TongTien được tính theo 
 -- công thức như sau: ChidvdikemdichvuPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) 
 -- cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
 
select khachhang.id_khachhang, ten_khachhang, ten_loaikhach,hopdong.id_hopdong,ten_dichvu,ngaybatau,ngayketthuc, (dichvu.chiphi + dvdikem.tien *   hopdong_dvdikem.soluong) as tongtien from ((((khachhang
inner join hopdong on khachhang.id_khachhang = hopdong.id_khachhang)
inner join  loaikhach on  loaikhach.id_loaikhach = khachhang.id_loaikhach )
inner join dichvu on dichvu.id_dichvu = hopdong.id_dichvu)
inner join hopdong_dvdikem on hopdong_dvdikem.id_hopdong = hopdong.id_hopdong)
inner join dvdikem  on dvdikem.id_dvdikem = hopdong_dvdikem.id_dvdikem ;


-- -- -- -- -- -- -- -- -- -- 6-- -- -- -- -- 
-- 6.	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại Dịch vụ chưa từng 
-- được Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).

select dichvu.id_dichvu ,hopdong.id_hopdong,ngaybatau, ten_dichvu, dientich,ten_room as tenDV, chiphi from( dichvu
 join hopdong on hopdong.id_dichvu = dichvu.id_dichvu )
 join room on room.id_dichvu = dichvu.id_dichvu
where    hopdong.id_hopdong not in (select hopdong.id_hopdong from dichvu  join hopdong on hopdong.id_dichvu = dichvu.id_dichvu where month(ngaybatau) in (1,2,3) AND year(ngaybatau) = '2019' )
union all
select dichvu.id_dichvu ,hopdong.id_hopdong, ngaybatau,ten_dichvu, dientich,ten_house as tenDV, chiphi from (dichvu
 join hopdong on hopdong.id_dichvu = dichvu.id_dichvu )
 join house  on house.id_dichvu = dichvu.id_dichvu
where  hopdong.id_hopdong not in (select hopdong.id_hopdong   from dichvu  join hopdong on hopdong.id_dichvu = dichvu.id_dichvu  where month(ngaybatau) in (1,2,3) AND year(ngaybatau) = '2019' )
union all
select dichvu.id_dichvu ,hopdong.id_hopdong,ngaybatau, ten_dichvu, dientich,ten_villa as tenDV, chiphi from (dichvu
  join hopdong on hopdong.id_dichvu = dichvu.id_dichvu )
  join villa  on villa.id_dichvu = dichvu.id_dichvu
where hopdong.id_hopdong not in (select hopdong.id_hopdong  from dichvu  join hopdong on hopdong.id_dichvu = dichvu.id_dichvu  where month(ngaybatau) in (1,2,3) AND year(ngaybatau) = '2019' );


-- -- -- -- -- -- --  7 -- -- -- -- -- -- -- -- 
-- 7.	Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu
--  của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019

select dichvu.id_dichvu,ngaybatau,hopdong.id_hopdong,ten_room as tendichvu,dientich,songuoi,chiphi, ten_dichvu as tenloaidv from( dichvu
 join hopdong on hopdong.id_dichvu = dichvu.id_dichvu )
 join room on room.id_dichvu = dichvu.id_dichvu
where  hopdong.id_hopdong  in (select hopdong.id_hopdong from dichvu  join hopdong on hopdong.id_dichvu = dichvu.id_dichvu  where year(ngaybatau) ='2018'and not year(ngaybatau) ='2019') 
union all
select dichvu.id_dichvu,ngaybatau,hopdong.id_hopdong,ten_house as tendichvu,dientich,songuoi,chiphi, ten_dichvu as tenloaidv from (dichvu
 join hopdong on hopdong.id_dichvu = dichvu.id_dichvu )
 join house  on house.id_dichvu = dichvu.id_dichvu
where  hopdong.id_hopdong  in (select hopdong.id_hopdong   from dichvu  join hopdong on hopdong.id_dichvu = dichvu.id_dichvu  
where year(ngaybatau) ='2018'and not year(ngaybatau) ='2019')
union all
select dichvu.id_dichvu,ngaybatau,hopdong.id_hopdong,ten_villa as tendichvu,dientich,songuoi,chiphi, ten_dichvu as tenloaidv from (dichvu
  join hopdong on hopdong.id_dichvu = dichvu.id_dichvu )
  join villa  on villa.id_dichvu = dichvu.id_dichvu
where hopdong.id_hopdong  in (select hopdong.id_hopdong  from dichvu  join hopdong on hopdong.id_dichvu = dichvu.id_dichvu   where year(ngaybatau) ='2018'and not year(ngaybatau) ='2019');

-- -- -- -- -- -- -- 8-- -- -- -- -- -- -- 
-- 8.	Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.
--   Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên
-- cách 1: 
select * from hopdong;
select * from khachhang
group by ten_khachhang;
-- cách 2
select distinct ten_khachhang from khachhang;
-- cách 3 
select ten_khachhang from khachhang
 union
 select  ten_khachhang from khachhang;
 
 
 -- -- -- -- -- -- -- -- -- 9-- -- -- -- -- -- -- 
 -- 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong 
 -- năm 2019 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
select month(ngaybatau) as Thang  , count(*) as soluong from khachhang
inner join hopdong on  khachhang.id_khachhang = hopdong.id_khachhang
where month(ngaybatau)  in ('01','07','03','04','05','06','02','08','09','10','11','12')  and year(ngaybatau) = '2019'
group by month(ngaybatau);

-- -- -- -- -- -- -- -- 10-- -- -- -- -- -- -- -- 
 -- 10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm.
 -- Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem (được tính dựa trên việc count các IDHopDongChiTiet).
select hopdong.id_hopdong, ngaybatau as ngaylamhopdong, ngayketthuc , sotendatcuoc as tiendatcoc , count(id_dvdikem) as soluongdvdikem from hopdong
inner join hopdong_dvdikem on hopdong_dvdikem.id_hopdong = hopdong.id_hopdong
group by hopdong.id_hopdong;


-- -- -- -- -- -- -- -- 11-- -- -- -- -- -- 
--  11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có 
-- TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Nam”. 
select dvdikem.id_dvdikem,ten_dvdikem,dongia,tien,diachi.tinh from ((((dvdikem 
inner join hopdong_dvdikem on hopdong_dvdikem.id_dvdikem= dvdikem.id_dvdikem)
inner join hopdong on hopdong.id_hopdong = hopdong_dvdikem.id_hopdong)
inner join khachhang on khachhang.id_khachhang = hopdong.id_khachhang)
inner join  loaikhach on loaikhach.id_loaikhach = khachhang.id_loaikhach)
inner join diachi on diachi.id_diachi = khachhang.id_diachi
where ten_loaikhach = 'Diamond' and tinh in ('Vinh','Quảng Nam');

-- -- -- -- -- -- -- -- -- -- -- -- -- -- --  12-- -- -- -- -- -- -- -- -- -- 
-- 	Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, 
-- SoLuongDichVuDikem (được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc
--  của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2019 
-- nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019. 

select hopdong.id_hopdong, nhanvien.id_nhanvien, khachhang.id_khachhang,  khachhang.sdt, ten_room as tendichvu,
dvdikem.id_dvdikem as soluongdvdikem,ngaybatau,sotendatcuoc as tiendatcoc from nhanvien
inner join hopdong on hopdong.id_nhanvien = nhanvien.id_nhanvien
inner join khachhang on khachhang.id_khachhang = hopdong.id_khachhang
inner join dichvu  on dichvu.id_dichvu = hopdong.id_dichvu
inner join room on room.id_dichvu = dichvu.id_dichvu
inner join hopdong_dvdikem on hopdong_dvdikem.id_hopdong= hopdong.id_hopdong
inner join dvdikem on hopdong_dvdikem.id_dvdikem= dvdikem.id_dvdikem
where  (hopdong.id_khachhang  in (select id_khachhang  from hopdong where
 month(ngaybatau)  in('10','11','12') and year(ngaybatau) ='2019')) and  (hopdong.id_khachhang not in (select id_khachhang  from hopdong where
 month(ngaybatau)  in('01','02','03','04','05','06') and year(ngaybatau) ='2019'))
 union
select hopdong.id_hopdong, nhanvien.id_nhanvien, khachhang.id_khachhang,  khachhang.sdt, ten_house as tendichvu,
dvdikem.id_dvdikem as soluongdvdikem,ngaybatau,sotendatcuoc as tiendatcoc from nhanvien
inner join hopdong on hopdong.id_nhanvien = nhanvien.id_nhanvien
inner join khachhang on khachhang.id_khachhang = hopdong.id_khachhang
inner join dichvu  on dichvu.id_dichvu = hopdong.id_dichvu
inner join house on house.id_dichvu = dichvu.id_dichvu
inner join hopdong_dvdikem on hopdong_dvdikem.id_hopdong= hopdong.id_hopdong
inner join dvdikem on hopdong_dvdikem.id_dvdikem= dvdikem.id_dvdikem
where  (hopdong.id_khachhang  in (select id_khachhang  from hopdong where
 month(ngaybatau)  in('10','11','12') and year(ngaybatau) ='2019')) and  (hopdong.id_khachhang not in (select id_khachhang  from hopdong where
 month(ngaybatau)  in('01','02','03','04','05','06') and year(ngaybatau) ='2019'))
 union
select hopdong.id_hopdong, nhanvien.id_nhanvien, khachhang.id_khachhang,  khachhang.sdt, ten_villa as tendichvu,
dvdikem.id_dvdikem as soluongdvdikem ,ngaybatau,sotendatcuoc as tiendatcoc from nhanvien
inner join hopdong on hopdong.id_nhanvien = nhanvien.id_nhanvien
inner join khachhang on khachhang.id_khachhang = hopdong.id_khachhang
inner join dichvu  on dichvu.id_dichvu = hopdong.id_dichvu
inner join villa on villa.id_dichvu = dichvu.id_dichvu
inner join hopdong_dvdikem on hopdong_dvdikem.id_hopdong= hopdong.id_hopdong
inner join dvdikem on hopdong_dvdikem.id_dvdikem= dvdikem.id_dvdikem
where  (hopdong.id_khachhang  in (select id_khachhang  from hopdong where
 month(ngaybatau)  in('10','11','12') and year(ngaybatau) ='2019')) and  (hopdong.id_khachhang not in (select id_khachhang  from hopdong where
 month(ngaybatau)  in('01','02','03','04','05','06') and year(ngaybatau) ='2019'));  

-- -- -- -- -- -- -- 13-- -- -- -- -- -- 
 -- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất
 -- bởi các Khách hàng đã đặt phòng. (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau);
 select count(dvdikem.id_dvdikem) as iddv_soluongsdnhieunhat,ten_dvdikem,dongia,tien from dvdikem
 inner join hopdong_dvdikem on hopdong_dvdikem.id_dvdikem= dvdikem.id_dvdikem
 inner join hopdong on hopdong.id_hopdong = hopdong_dvdikem.id_hopdong
 inner join khachhang on khachhang.id_khachhang = hopdong.id_khachhang 
 group by dvdikem.id_dvdikem
 having count(dvdikem.id_dvdikem) =
 ( select count(dvdikem.id_dvdikem) from dvdikem 
 inner join hopdong_dvdikem on hopdong_dvdikem.id_dvdikem= dvdikem.id_dvdikem
 inner join hopdong on hopdong.id_hopdong = hopdong_dvdikem.id_hopdong
 inner join khachhang on khachhang.id_khachhang = hopdong.id_khachhang
group by dvdikem.id_dvdikem
order by count(dvdikem.id_dvdikem)  DESC
limit 1);
-- --  13 : select trong  tạo ra giá trị  lớn có số lần mà dvdikem đc khách hàng sử dùng và đc order by sắp xếp cao xuống thấp, đc limit chọn chỉ in ra 1 kq trên cùng
-- nhằm thỏa mãn th  (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau);


-- -- -- -- -- -- -- 14-- -- -- -- 
-- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất.
--  Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.
select hopdong.id_hopdong,dichvu.ten_dichvu as tenloaidichvu, dvdikem.ten_dvdikem, count(hopdong.id_hopdong) as solansudung from dvdikem
inner join hopdong_dvdikem on hopdong_dvdikem.id_dvdikem = dvdikem.id_dvdikem
inner join hopdong on hopdong.id_hopdong = hopdong_dvdikem.id_hopdong
inner join dichvu on dichvu.id_dichvu = hopdong.id_dichvu
group by dvdikem.id_dvdikem
having count(hopdong.id_hopdong) ='1';

-- -- -- -- 15-- -- -- -- -- -- -- 
--  15.	Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai, DiaChi 
-- mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.
select nhanvien.id_nhanvien, ten_nhanvien, ten_trinhdo, bophan.ten_bophan,sdt,sonha, xa, huyen,tinh, quocgia  , count(id_hopdong) as soluonghopdong from  nhanvien
inner join diachi  on diachi.id_diachi = nhanvien.id_diachi
inner join trinhdo on trinhdo.id_trinhdo = nhanvien.id_trinhdo
inner join bophan on bophan.id_bophan = nhanvien.id_bophan
inner join hopdong on hopdong.id_nhanvien = nhanvien.id_nhanvien
where year(ngaybatau) in ('2018','2019')
group by nhanvien.id_nhanvien
having count(id_hopdong) <=3 ;


-- -- -- -- -- -- -- -- -- -- 16-- -- -- -- -- 
-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.

delete  from nhanvien 
where id_nhanvien in (select  nhanvien.id_nhanvien from  nhanvien
inner join hopdong on hopdong.id_nhanvien = nhanvien.id_nhanvien
where year(ngaybatau)  not in ('2017','2019')
group by nhanvien.id_nhanvien);


-- -- -- -- -- -- -- --  17 -- -- -- -- -- -- 
-- 17.	Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond,
 -- chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ.

 update  khachhang
 inner join hopdong  on hopdong.id_khachhang = khachhang.id_khachhang
 inner join loaikhach   on  loaikhach.id_loaikhach = khachhang.id_loaikhach
 set khachhang.id_loaikhach = 'LK01'
 where khachhang.id_khachhang in ( select hopdong.id_khachhang from hopdong
 where Year(ngaybatau) ='2019' and  khachhang.id_loaikhach = 'LK02'
 group by  khachhang.id_khachhang
having  sum(tongsotienthanhtoan) > 10000000
); 

select * from khachhang;

-- -- --  18 -- -- -- -- 
-- 18.	Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràngbuộc giữa các bảng). alter


delete khachhang,hopdong,hopdong_dvdikem from khachhang
inner join hopdong on hopdong.id_khachhang = khachhang.id_khachhang
inner join hopdong_dvdikem on hopdong_dvdikem.id_hopdong = hopdong.id_hopdong
     where not exists ( select hopdong.id_hopdong where year(ngaybatau) >'2019' and hopdong.id_khachhang = khachhang.id_khachhang);
select * from hopdong ;


-- 19.	Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi.
update dvdikem 
 set tien = (2 * tien)
 where id_dvdikem  in ( select team.id_dvdikem from team);
select * from team;
drop view tam;
create view team as
 select hopdong_dvdikem.id_dvdikem,ten_dvdikem,dongia,tien  from dvdikem 
 inner join hopdong_dvdikem on hopdong_dvdikem.id_dvdikem = dvdikem.id_dvdikem
inner join hopdong  on hopdong_dvdikem.id_hopdong = hopdong.id_hopdong
where year(ngaybatau)  = '2019'
group by hopdong_dvdikem.id_dvdikem 
having count(hopdong_dvdikem.id_hopdong) >0  ;

update dvdikem inner join ( select dvdikem.ten_dvdikem from dvdikem 
 inner join hopdong_dvdikem on hopdong_dvdikem.id_dvdikem = dvdikem.id_dvdikem
inner join hopdong  on hopdong_dvdikem.id_hopdong = hopdong.id_hopdong
where year(ngaybatau)  = '2019'
group by hopdong_dvdikem.id_dvdikem 
having count(hopdong_dvdikem.id_hopdong) >0 ) as team
 set tien = (2 * tien)
 where dvdikem.ten_dvdikem =team.ten_dvdikem;


select * from vaitro;
select ten_user from user_vaitro inner join vaitro on user_vaitro.vaitro_id= vaitro.vaitro_id where vaitro.ten_vaitro ='quanlysv';

select ten_user from user_vaitro inner join vaitro on user_vaitro.vaitro_id= vaitro.vaitro_id where ten_user ='user2' and vaitro.ten_vaitro='quanlysv';