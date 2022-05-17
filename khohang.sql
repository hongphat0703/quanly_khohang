-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 16, 2021 lúc 06:12 PM
-- Phiên bản máy phục vụ: 10.4.19-MariaDB
-- Phiên bản PHP: 7.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `khohang`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account`
--

CREATE TABLE `account` (
  `Username` varchar(20) NOT NULL,
  `Gmail` char(50) NOT NULL,
  `Password` char(20) NOT NULL,
  `Confirm_Password` char(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `account`
--

INSERT INTO `account` (`Username`, `Gmail`, `Password`, `Confirm_Password`) VALUES
('admin', 'admin@gmail.com', '1', '1'),
('admin', 'a', '1', '1'),
('admin', 'a', '1', '1'),
('admin', 'a', '1', '1'),
('admin', 'a', '1', '1');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ct_phieu_nhap`
--

CREATE TABLE `ct_phieu_nhap` (
  `Ma_PN` varchar(10) NOT NULL,
  `Ma_SP` varchar(10) NOT NULL,
  `So_Luong` int(11) NOT NULL,
  `Don_gia` double NOT NULL,
  `ThanhTien` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `ct_phieu_nhap`
--

INSERT INTO `ct_phieu_nhap` (`Ma_PN`, `Ma_SP`, `So_Luong`, `Don_gia`, `ThanhTien`) VALUES
('002', '001', 5, 10000, 50000),
('005', '001', 12, 12000, 144000),
('001', '002', 7, 12000, 84000),
('003', '002', 9, 12000, 108000),
('003', '003', 20, 15000, 300000),
('004', '003', 12, 20000, 240000),
('006', '003', 12, 12000, 144000),
('002', '005', 10, 10000, 100000),
('006', '007', 12, 120000, 1440000),
('003', '008', 45, 30000, 1350000),
('001', '010', 7, 10000, 70000),
('002', '014', 10, 10000, 100000),
('004', '017', 80, 20000, 1600000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ct_phieu_xuat`
--

CREATE TABLE `ct_phieu_xuat` (
  `Ma_PX` varchar(10) NOT NULL,
  `Ma_SP` varchar(10) NOT NULL,
  `So_Luong` int(11) NOT NULL,
  `Don_gia` double NOT NULL,
  `ThanhTien` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `ct_phieu_xuat`
--

INSERT INTO `ct_phieu_xuat` (`Ma_PX`, `Ma_SP`, `So_Luong`, `Don_gia`, `ThanhTien`) VALUES
('001', '001', 10, 10000, 100000),
('001', '005', 10, 10000, 100000),
('002', '009', 10, 6000, 60000),
('003', '001', 8, 10000, 80000),
('003', '002', 12, 12000, 144000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khach_hang`
--

CREATE TABLE `khach_hang` (
  `Ma_KH` varchar(10) NOT NULL,
  `Ho_KH` varchar(30) NOT NULL,
  `Ten_KH` varchar(20) NOT NULL,
  `Dia_Chi` varchar(50) NOT NULL,
  `Dien_Thoai` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `khach_hang`
--

INSERT INTO `khach_hang` (`Ma_KH`, `Ho_KH`, `Ten_KH`, `Dia_Chi`, `Dien_Thoai`) VALUES
('001', 'Nguyễn Văn', 'B', '347B Bãi S?y, P4, Q6, HCM', '0903050978'),
('002', 'Nguyễn Thị', 'Thắm', '175 Kinh Dương Vương, Tân Tạo A, Bình Tân, HCM', '090009900'),
('003', 'Trương Hồng ', 'Phát', '345 Hòa Bình, P1, Q11, HCM', '0938116038'),
('004', 'Trương Hữu', 'Ái', '1166/60/65 QL1A, Tân Tạo A, Bình Tân, HCM', '0902429747');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `kho`
--

CREATE TABLE `kho` (
  `Ma_Kho` varchar(10) NOT NULL,
  `Ten_Kho` varchar(30) NOT NULL,
  `Dia_Chi` varchar(50) NOT NULL,
  `Dien_Thoai` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `kho`
--

INSERT INTO `kho` (`Ma_Kho`, `Ten_Kho`, `Dia_Chi`, `Dien_Thoai`) VALUES
('001', 'Kho A', '345 Hòa Bình, P1, Q11, HCM', '0938116038'),
('002', 'Kho B', '234B Hậu Giang, P5, Q6, HCM', '0933624198'),
('003', 'Kho C', '309/12 Trần Hưng Đạo, P3, Q1, HCM', '0902876291'),
('004', 'Kho D', '152 Lạc Long Quân, P1, Q11, HCM', '0902478632');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ncc`
--

CREATE TABLE `ncc` (
  `Ma_NCC` varchar(10) NOT NULL,
  `Ten_NCC` varchar(30) NOT NULL,
  `Dia_Chi` varchar(50) NOT NULL,
  `Dien_Thoai` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `ncc`
--

INSERT INTO `ncc` (`Ma_NCC`, `Ten_NCC`, `Dia_Chi`, `Dien_Thoai`) VALUES
('001', 'NCC A', '1166 QL1A, Tân Tạo A, Bình Tân, HCM', '19006067'),
('002', 'NCC B', '123 Hòa Bình, P4, Q11, HCM', '0908978782'),
('003', 'NCC C', '456 Tân Hòa ?ông, P14, Q6, HCM', '0909090505'),
('004', 'NCC D', '123 Bãi S?y, P4, Q6, HCM', '1234567890');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `Ma_NV` varchar(10) NOT NULL,
  `Ho_NV` varchar(30) NOT NULL,
  `Ten_NV` varchar(20) NOT NULL,
  `Ngay_Sinh` date DEFAULT NULL,
  `Dia_Chi` varchar(50) NOT NULL,
  `Dien_Thoai` varchar(10) NOT NULL,
  `Luong` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`Ma_NV`, `Ho_NV`, `Ten_NV`, `Ngay_Sinh`, `Dia_Chi`, `Dien_Thoai`, `Luong`) VALUES
('001', 'Trương Hồng', 'Phát', '2001-03-07', '348B Bãi Sậy, P4, Q6, HCM', '0938116038', 5000000),
('002', 'Nguy?n V?n', 'A', '2002-04-07', '123 Hòa Bình, P5, Q11, HCM', '0933562278', 5600000),
('003', 'Trần Thị', 'Nữ', '1991-02-13', '45/21/23 Trần Bình Trọng, P5, Q5, HCM', '0902529474', 6800000),
('004', 'Tăng Trình', 'Quang', '2001-01-11', '152 Lạc Long Quân,P5,Q11,HCM', '0902375381', 20000000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nsx`
--

CREATE TABLE `nsx` (
  `Ma_NSX` varchar(10) NOT NULL,
  `Ten_NSX` varchar(30) NOT NULL,
  `Dia_Chi` varchar(50) NOT NULL,
  `Dien_Thoai` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `nsx`
--

INSERT INTO `nsx` (`Ma_NSX`, `Ten_NSX`, `Dia_Chi`, `Dien_Thoai`) VALUES
('BK', 'Bánh kẹo', '111 Bình Phú, P14, Q6, HCM', '0938116038'),
('CP', 'Cà Phê', '456 Hậu Giang, P4, Q6, HCM', '0933562278'),
('NGK', 'Nước giải khát', '123 Trương Định, P1, Q1, HCM', '0902429797'),
('VNM', 'Vinamilk', '348B Bãi Sậy, P4, Q6, HCM', '090116345');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieunhap`
--

CREATE TABLE `phieunhap` (
  `Ma_PN` varchar(10) NOT NULL,
  `Ma_NV` varchar(10) NOT NULL,
  `Ma_NCC` varchar(10) NOT NULL,
  `Ma_Kho` varchar(10) NOT NULL,
  `Ngay` date NOT NULL,
  `TongTien` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `phieunhap`
--

INSERT INTO `phieunhap` (`Ma_PN`, `Ma_NV`, `Ma_NCC`, `Ma_Kho`, `Ngay`, `TongTien`) VALUES
('001', '001', '001', '001', '2021-04-08', 154000),
('002', '002', '003', '002', '2021-04-12', 250000),
('003', '001', '001', '001', '2021-05-01', 1758000),
('004', '001', '001', '001', '2021-05-13', 1840000),
('005', '001', '001', '001', '2021-05-21', 144000),
('006', '001', '001', '001', '2021-05-21', 1584000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieuxuat`
--

CREATE TABLE `phieuxuat` (
  `Ma_PX` varchar(10) NOT NULL,
  `Ma_NV` varchar(10) NOT NULL,
  `Ma_KH` varchar(10) NOT NULL,
  `Ma_Kho` varchar(10) NOT NULL,
  `Ngay` date NOT NULL,
  `TongTien` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `phieuxuat`
--

INSERT INTO `phieuxuat` (`Ma_PX`, `Ma_NV`, `Ma_KH`, `Ma_Kho`, `Ngay`, `TongTien`) VALUES
('001', '003', '002', '001', '2021-05-18', 200000),
('002', '002', '003', '004', '2021-05-22', 60000),
('003', '001', '001', '001', '2021-05-13', 224000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ql_sp_kho`
--

CREATE TABLE `ql_sp_kho` (
  `Ma_Kho` varchar(10) NOT NULL,
  `Ma_SP` varchar(10) NOT NULL,
  `So_Luong` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `Ma_SP` varchar(10) NOT NULL,
  `Ten_SP` varchar(50) NOT NULL,
  `Don_Gia` double NOT NULL,
  `So_Luong` int(5) NOT NULL,
  `DV_Tinh` varchar(10) NOT NULL,
  `Ma_NSX` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`Ma_SP`, `Ten_SP`, `Don_Gia`, `So_Luong`, `DV_Tinh`, `Ma_NSX`) VALUES
('001', 'Coca', 10000, 456, 'Chai', 'NGK'),
('002', '7Up', 12000, 386, 'Chai', 'NGK'),
('003', 'OreO', 200000, 452, 'Thùng', 'BK'),
('004', 'Pepsi', 12000, 39, 'L?c', 'NGK'),
('005', 'Sprite', 10000, 256, 'Lon', 'NGK'),
('006', 'ChocoPie', 150000, 12, 'Thùng', 'BK'),
('007', 'Cà Phê Trung Nguyên', 350000, 152, 'Thùng', 'CP'),
('008', 'Custas', 500000, 67, 'Thùng', 'BK'),
('009', 'Aquafina', 6000, 61, 'Thùng', 'NGK'),
('010', 'Mirinda', 10000, 122, 'Lon', 'NGK'),
('011', 'Fanta', 12000, 137, 'Lon', 'NGK'),
('012', 'TH True Milk', 50000, 90, 'L?c', 'VNM'),
('013', 'NutriBoost', 60000, 50, 'L?c', 'NGK'),
('014', 'Olong', 10000, 129, 'Chai', 'NGK'),
('015', 'Cà phê Robusta', 400000, 36, 'Thùng', 'CP'),
('016', 'Cà phê Arabica', 450000, 34, 'Thùng', 'CP'),
('017', 'Satori', 7000, 417, 'Chai', 'NGK'),
('018', 'Pocari Sweet', 12000, 78, 'Chai', 'NGK'),
('019', 'Fami', 36000, 45, 'L?c', 'VNM');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `ct_phieu_nhap`
--
ALTER TABLE `ct_phieu_nhap`
  ADD PRIMARY KEY (`Ma_SP`,`Ma_PN`),
  ADD KEY `Ma_PN` (`Ma_PN`);

--
-- Chỉ mục cho bảng `ct_phieu_xuat`
--
ALTER TABLE `ct_phieu_xuat`
  ADD PRIMARY KEY (`Ma_PX`,`Ma_SP`),
  ADD KEY `Ma_SP` (`Ma_SP`);

--
-- Chỉ mục cho bảng `khach_hang`
--
ALTER TABLE `khach_hang`
  ADD PRIMARY KEY (`Ma_KH`);

--
-- Chỉ mục cho bảng `kho`
--
ALTER TABLE `kho`
  ADD PRIMARY KEY (`Ma_Kho`);

--
-- Chỉ mục cho bảng `ncc`
--
ALTER TABLE `ncc`
  ADD PRIMARY KEY (`Ma_NCC`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`Ma_NV`);

--
-- Chỉ mục cho bảng `nsx`
--
ALTER TABLE `nsx`
  ADD PRIMARY KEY (`Ma_NSX`);

--
-- Chỉ mục cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`Ma_PN`),
  ADD KEY `Ma_NCC` (`Ma_NCC`),
  ADD KEY `Ma_NV` (`Ma_NV`);

--
-- Chỉ mục cho bảng `phieuxuat`
--
ALTER TABLE `phieuxuat`
  ADD PRIMARY KEY (`Ma_PX`),
  ADD KEY `Ma_NV` (`Ma_NV`),
  ADD KEY `Ma_KH` (`Ma_KH`);

--
-- Chỉ mục cho bảng `ql_sp_kho`
--
ALTER TABLE `ql_sp_kho`
  ADD PRIMARY KEY (`Ma_Kho`,`Ma_SP`),
  ADD KEY `Ma_SP` (`Ma_SP`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`Ma_SP`),
  ADD KEY `Ma_NSX` (`Ma_NSX`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `ct_phieu_nhap`
--
ALTER TABLE `ct_phieu_nhap`
  ADD CONSTRAINT `ct_phieu_nhap_ibfk_1` FOREIGN KEY (`Ma_PN`) REFERENCES `phieunhap` (`Ma_PN`),
  ADD CONSTRAINT `ct_phieu_nhap_ibfk_2` FOREIGN KEY (`Ma_SP`) REFERENCES `sanpham` (`Ma_SP`);

--
-- Các ràng buộc cho bảng `ct_phieu_xuat`
--
ALTER TABLE `ct_phieu_xuat`
  ADD CONSTRAINT `ct_phieu_xuat_ibfk_2` FOREIGN KEY (`Ma_SP`) REFERENCES `sanpham` (`Ma_SP`);

--
-- Các ràng buộc cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `phieunhap_ibfk_1` FOREIGN KEY (`Ma_NCC`) REFERENCES `ncc` (`Ma_NCC`),
  ADD CONSTRAINT `phieunhap_ibfk_2` FOREIGN KEY (`Ma_NV`) REFERENCES `nhanvien` (`Ma_NV`);

--
-- Các ràng buộc cho bảng `phieuxuat`
--
ALTER TABLE `phieuxuat`
  ADD CONSTRAINT `phieuxuat_ibfk_1` FOREIGN KEY (`Ma_NV`) REFERENCES `nhanvien` (`Ma_NV`),
  ADD CONSTRAINT `phieuxuat_ibfk_2` FOREIGN KEY (`Ma_KH`) REFERENCES `khach_hang` (`Ma_KH`);

--
-- Các ràng buộc cho bảng `ql_sp_kho`
--
ALTER TABLE `ql_sp_kho`
  ADD CONSTRAINT `ql_sp_kho_ibfk_1` FOREIGN KEY (`Ma_Kho`) REFERENCES `kho` (`Ma_Kho`),
  ADD CONSTRAINT `ql_sp_kho_ibfk_2` FOREIGN KEY (`Ma_SP`) REFERENCES `sanpham` (`Ma_SP`);

--
-- Các ràng buộc cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `sanpham_ibfk_1` FOREIGN KEY (`Ma_NSX`) REFERENCES `nsx` (`Ma_NSX`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
