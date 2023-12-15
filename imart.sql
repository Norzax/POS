-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 19, 2021 at 05:38 AM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.5
create database if not exists imart;
use imart;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `imart`
--

-- --------------------------------------------------------

--
-- Table structure for table `chuc_vu`
--

CREATE TABLE `chuc_vu` (
  `id` char(5) NOT NULL,
  `ten_chucvu` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `chuc_vu`
--

INSERT INTO `chuc_vu` (`id`, `ten_chucvu`) VALUES
('CV01', 'Admin'),
('CV02', 'Quan ly'),
('CV03', 'Nhan Vien');

-- --------------------------------------------------------

--
-- Table structure for table `ct_hoa_don`
--

CREATE TABLE `ct_hoa_don` (
  `ma_hd` char(20) NOT NULL,
  `ma_sp` char(20) NOT NULL,
  `soluong` int(255) NOT NULL,
  `dongia` double NOT NULL,
  `thanhtien` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ct_hoa_don`
--

INSERT INTO `ct_hoa_don` (`ma_hd`, `ma_sp`, `soluong`, `dongia`, `thanhtien`) VALUES
('HD001', 'DU02', 4, 139000, 556000),
('HD001', 'HM03', 10, 15000, 150000),
('HD001', 'TPK01', 1, 24000, 24000),
('HD001', 'VPP02', 5, 3000, 15000),
('HD001', 'TPK04', 2, 44000, 88000),
('HD002', 'BK03', 5, 20000, 100000),
('HD002', 'BK02', 3, 50000, 150000),
('HD002', 'BK04', 1, 36000, 36000),
('HD002', 'DM01', 2, 30000, 60000),
('HD003', 'BK06', 5, 100000, 500000),
('HD003', 'GD03', 1, 2500000, 2500000),
('HD003', 'HDL01', 2, 120000, 240000),
('HD003', 'HM04', 2, 80000, 160000),
('HD003', 'GVB02', 2, 11000, 22000),
('HD003', 'HDL02', 4, 47000, 188000),
('HD004', 'HP01', 2, 46000, 92000),
('HD004', 'HP02', 2, 21000, 42000),
('HD004', 'TPK05', 2, 9000, 18000),
('HD004', 'VPP01', 1, 7000, 7000),
('HD004', 'TPK12', 10, 3500, 35000),
('HD005', 'DU02', 2, 139000, 278000),
('HD005', 'DU03', 2, 150000, 300000),
('HD005', 'BK05', 4, 18000, 72000),
('HD005', 'MP05', 2, 500000, 1000000),
('HD006', 'GD03', 2, 2500000, 5000000),
('HD007', 'TPK08', 20, 70000, 1400000),
('HD008', 'DM02', 20, 23000, 460000),
('HD008', 'HM01', 10, 19000, 190000),
('HD008', 'HM03', 9, 15000, 135000),
('HD009', 'GD03', 10, 2500000, 25000000),
('HD0010', 'GD03', 10, 2500000, 25000000),
('HD0011', 'GD03', 7, 2500000, 17500000),
('HD0012', 'HDL03', 20, 72000, 1440000),
('HD0013', 'DU01', 30, 62000, 1860000),
('HD0014', 'DU04', 2, 800000, 1600000),
('HD0014', 'BK05', 27, 18000, 486000),
('HD0014', 'DM01', 19, 30000, 570000),
('HD0014', 'DU02', 18, 139000, 2502000),
('HD0014', 'HM01', 43, 19000, 817000),
('HD0014', 'GVB02', 12, 11000, 132000),
('HD0014', 'HDL02', 15, 47000, 705000),
('HD0014', 'GVB01', 19, 21000, 399000),
('HD0014', 'TPK10', 22, 26000, 572000),
('HD0015', 'BK01', 1, 85000, 85000),
('HD0015', 'BK02', 1, 50000, 50000),
('HD0015', 'BK03', 1, 20000, 20000),
('HD0015', 'BK04', 1, 36000, 36000),
('HD0015', 'BK05', 1, 18000, 18000),
('HD0015', 'BK06', 1, 100000, 100000),
('HD0015', 'DM01', 2, 30000, 60000),
('HD0015', 'DM02', 1, 23000, 23000),
('HD0015', 'DU01', 1, 62000, 62000),
('HD0015', 'DU02', 1, 139000, 139000),
('HD0015', 'DU03', 1, 150000, 150000),
('HD0015', 'DU05', 1, 28000, 28000),
('HD0016', 'BK04', 2, 38000, 76000),
('HD0016', 'DU05', 9, 28000, 252000),
('HD0016', 'DU06', 2, 10000, 20000),
('HD0017', 'BK05', 2, 12000, 24000),
('HD0017', 'BK06', 2, 100000, 200000),
('HD0017', 'DM01', 2, 30000, 60000),
('HD0018', 'DU01', 50, 62000, 3100000);

-- --------------------------------------------------------

--
-- Table structure for table `ct_khuyen_mai`
--

CREATE TABLE `ct_khuyen_mai` (
  `ma_km` char(20) NOT NULL,
  `ma_sp` char(20) NOT NULL,
  `%` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `ct_phieu_nhap`
--

CREATE TABLE `ct_phieu_nhap` (
  `ma_pn` char(20) NOT NULL,
  `ma_sp` char(20) NOT NULL,
  `dongia` double NOT NULL,
  `soluong` int(11) NOT NULL,
  `thanhtien` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ct_phieu_nhap`
--

INSERT INTO `ct_phieu_nhap` (`ma_pn`, `ma_sp`, `dongia`, `soluong`, `thanhtien`) VALUES
('PN001', 'DM01', 30000, 1, 24000),
('PN002', 'BK06', 100000, 6, 480000),
('PN002', 'DM01', 30000, 22, 660000),
('PN002', 'DU01', 62000, 31, 1537600),
('PN002', 'BK05', 18000, 32, 460800),
('PN003', 'DM03', 20000, 100, 1600000),
('PN004', 'BK08', 20000, 100, 1600000),
('PN005', 'BK08', 20000, 50, 800000);

-- --------------------------------------------------------

--
-- Table structure for table `hoa_don`
--

CREATE TABLE `hoa_don` (
  `id` char(20) NOT NULL,
  `ma_nv` char(20) NOT NULL,
  `ma_kh` char(20) NOT NULL,
  `ngaylap` date NOT NULL,
  `tongtien` double NOT NULL,
  `ghichu` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hoa_don`
--

INSERT INTO `hoa_don` (`id`, `ma_nv`, `ma_kh`, `ngaylap`, `tongtien`, `ghichu`) VALUES
('HD001', 'NV03', 'KH00', '2017-05-01', 833000, 'Không'),
('HD0010', 'NV03', 'KH00', '2019-05-17', 25000000, 'Không'),
('HD0011', 'NV02', 'KH00', '2019-08-08', 17500000, 'Không'),
('HD0012', 'NV03', 'KH01', '2021-05-17', 1440000, 'Không'),
('HD0013', 'NV02', 'KH03', '2019-01-02', 1860000, 'đem đến địa chỉ xxx lúc 4h'),
('HD0014', 'NV01', 'KH02', '2018-05-09', 7783000, 'Không'),
('HD0015', 'NV01', 'KH00', '2021-05-17', 771000, 'Không'),
('HD0016', 'NV03', 'KH03', '2021-05-08', 348000, 'Không'),
('HD0017', 'NV06', 'KH02', '2021-05-19', 284000, 'Không'),
('HD0018', 'NV03', 'KH01', '2021-05-19', 3100000, 'đem đến trường học xyz '),
('HD002', 'NV01', 'KH02', '2017-05-12', 346000, 'Không'),
('HD003', 'NV04', 'KH00', '2021-05-16', 3610000, 'Không'),
('HD004', 'NV03', 'KH03', '2017-09-13', 194000, 'Không'),
('HD005', 'NV03', 'KH00', '2017-02-03', 1650000, 'Không'),
('HD006', 'NV02', 'KH00', '2021-03-13', 5000000, 'Không'),
('HD007', 'NV04', 'KH03', '2018-05-12', 1400000, 'Không'),
('HD008', 'NV04', 'KH00', '2018-12-13', 785000, 'Không'),
('HD009', 'NV03', 'KH00', '2021-05-16', 25000000, 'Không');

-- --------------------------------------------------------

--
-- Table structure for table `khach_hang`
--

CREATE TABLE `khach_hang` (
  `id` char(20) NOT NULL,
  `ho` varchar(50) NOT NULL,
  `ten` varchar(50) NOT NULL,
  `diachi` varchar(255) NOT NULL,
  `sodienthoai` char(10) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `khach_hang`
--

INSERT INTO `khach_hang` (`id`, `ho`, `ten`, `diachi`, `sodienthoai`, `status`) VALUES
('KH00', 'Khách', 'lẻ', '//', '//', 'unchange'),
('KH01', 'Lê', 'Thị Đào', 'thpcm', '0901234567', 'on'),
('KH02', 'Nguyễn', 'Văn Mạnh', 'thpcm', '0907654321', 'on'),
('KH03', 'Lê', 'Thị Cam', 'thpcm', '0909876543', 'deleted'),
('KH04', 'Trần', 'Thị Mai', '92 Hàm tử', '0909876542', 'deleted'),
('KH05', 'c', 'c', 'c', '0909090909', 'deleted');

-- --------------------------------------------------------

--
-- Table structure for table `khuyen_mai`
--

CREATE TABLE `khuyen_mai` (
  `id` char(20) NOT NULL,
  `ngaybd` date NOT NULL,
  `ngaykt` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `loai_hang`
--

CREATE TABLE `loai_hang` (
  `id` int(255) NOT NULL,
  `ten_loai` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `loai_hang`
--

INSERT INTO `loai_hang` (`id`, `ten_loai`) VALUES
(1, 'Hàng mát'),
(2, 'Hàng đông lạnh'),
(3, 'Thực phẩm khô'),
(4, 'Đồ uống'),
(5, 'Bánh kẹo'),
(6, 'Thuốc lá'),
(7, 'Gia dụng'),
(8, 'Văn phòng phẩm'),
(9, 'Dệt may'),
(10, 'Mỹ phẩm'),
(11, 'Hóa phẩm'),
(12, 'Giấy và bông');

-- --------------------------------------------------------

--
-- Table structure for table `ncc`
--

CREATE TABLE `ncc` (
  `id` char(20) NOT NULL,
  `ten_ncc` varchar(255) NOT NULL,
  `diachi` varchar(255) NOT NULL,
  `dienthoai` char(20) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ncc`
--

INSERT INTO `ncc` (`id`, `ten_ncc`, `diachi`, `dienthoai`, `status`) VALUES
('NCC01', 'Nha cung cap so 1', 'xxx', '0211111111', 'on'),
('NCC02', 'Nha cung cap so 2', 'xxx', '0222222222', 'on'),
('NCC03', 'Nha cung cap so 3', 'xxx', '0233333333', 'on'),
('NCC04', 'Nha cung cap so 4', 'xxxx', '0244444444', 'on'),
('NCC05', 'Nha cung cap so 5', 'xxx', '0255555555', 'deleted'),
('NCC06', 'Nha cung cap so 6', 'xxx', '0266666666', 'on');

-- --------------------------------------------------------

--
-- Table structure for table `nhan_vien`
--

CREATE TABLE `nhan_vien` (
  `id` char(20) NOT NULL,
  `ho` varchar(50) NOT NULL,
  `ten` varchar(50) NOT NULL,
  `ngaysinh` date NOT NULL,
  `dienthoai` char(10) NOT NULL,
  `ngayvaolam` date NOT NULL,
  `gioitinh` char(1) NOT NULL,
  `diachi` varchar(255) NOT NULL,
  `ma_chucvu` char(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nhan_vien`
--

INSERT INTO `nhan_vien` (`id`, `ho`, `ten`, `ngaysinh`, `dienthoai`, `ngayvaolam`, `gioitinh`, `diachi`, `ma_chucvu`) VALUES
('NV00', 'root', 'admin', '2001-01-01', '0999999999', '2001-01-01', '1', 'USA', 'CV01'),
('NV01', 'Thái', 'Gia Đức', '2001-04-04', '0901234569', '2000-01-02', '1', 'VietNam', 'CV03'),
('NV02', 'La', 'Chí Bàng', '2001-01-03', '0901234978', '2021-04-01', '1', 'Australia', 'CV03'),
('NV03', 'Giang', 'Bảo Luân', '2001-01-01', '0923465888', '2021-04-01', '1', 'Canada', 'CV02'),
('NV04', 'Đoàn', 'Trung Hậu', '2001-01-10', '0909845856', '2021-04-01', '1', 'France', 'CV03'),
('NV05', 'a', 'a', '2021-05-03', '0909090907', '2021-05-17', '2', 'a', 'CV03'),
('NV06', 'b', 'b', '2021-05-03', '0909090908', '2021-05-17', '1', 'b', 'CV03'),
('NV07', 'c', 'c', '2021-05-01', '0909090909', '2021-05-17', '1', 'c', 'CV03'),
('NV08', 'La', 'Chí Bàng', '2001-01-03', '0901234977', '2021-04-01', '1', 'Australia', 'CV03');

-- --------------------------------------------------------

--
-- Table structure for table `phieu_nhap`
--

CREATE TABLE `phieu_nhap` (
  `id` char(20) NOT NULL,
  `ma_nv` char(20) NOT NULL,
  `ma_ncc` char(20) NOT NULL,
  `ngaylap` date NOT NULL,
  `tongtien` double NOT NULL,
  `ghichu` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `phieu_nhap`
--

INSERT INTO `phieu_nhap` (`id`, `ma_nv`, `ma_ncc`, `ngaylap`, `tongtien`, `ghichu`) VALUES
('PN001', 'NV03', 'NCC01', '2021-05-17', 24000, 'Không'),
('PN002', 'NV01', 'NCC05', '2021-06-10', 3138400, 'Không'),
('PN003', 'NV03', 'NCC04', '2021-05-19', 1600000, 'Không'),
('PN004', 'NV03', 'NCC02', '2021-05-19', 1600000, 'Không'),
('PN005', 'NV03', 'NCC01', '2021-05-19', 800000, 'Không');

-- --------------------------------------------------------

--
-- Table structure for table `quyen_han`
--

CREATE TABLE `quyen_han` (
  `ma_nhanvien` char(20) NOT NULL,
  `ql_nv` char(1) NOT NULL,
  `qly_pn` char(1) NOT NULL,
  `qly_ncc` char(1) NOT NULL,
  `phanquyen` char(1) NOT NULL,
  `qly_hd` char(1) NOT NULL,
  `nhaphang` char(1) NOT NULL,
  `banhang` char(1) NOT NULL,
  `thongke` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `quyen_han`
--

INSERT INTO `quyen_han` (`ma_nhanvien`, `ql_nv`, `qly_pn`, `qly_ncc`, `phanquyen`, `qly_hd`, `nhaphang`, `banhang`, `thongke`) VALUES
('NV00', '1', '1', '1', '1', '1', '1', '1', '0'),
('NV01', '0', '1', '0', '0', '1', '1', '1', '1'),
('NV02', '0', '1', '1', '0', '1', '1', '1', '0'),
('NV03', '1', '1', '1', '1', '1', '1', '1', '1'),
('NV04', '0', '1', '0', '0', '1', '1', '1', '1'),
('NV05', '0', '1', '0', '0', '1', '1', '1', '1'),
('NV06', '0', '1', '0', '0', '1', '1', '1', '1'),
('NV07', '0', '1', '0', '0', '1', '1', '1', '1'),
('NV08', '0', '1', '0', '0', '1', '1', '1', '1');

-- --------------------------------------------------------

--
-- Table structure for table `san_pham`
--

CREATE TABLE `san_pham` (
  `id` char(20) NOT NULL,
  `tensp` varchar(255) NOT NULL,
  `nsx` date NOT NULL,
  `hsd` date NOT NULL,
  `dongia` double NOT NULL,
  `soluong` int(11) NOT NULL,
  `ma_loai` int(255) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `san_pham`
--

INSERT INTO `san_pham` (`id`, `tensp`, `nsx`, `hsd`, `dongia`, `soluong`, `ma_loai`, `status`) VALUES
('BK01', 'Banh quy', '2021-01-01', '2022-12-12', 85000, 99, 5, 'on'),
('BK02', 'Banh xop', '2021-01-01', '2022-12-12', 50000, 96, 5, 'on'),
('BK03', 'Keo deo', '2021-01-01', '2022-12-12', 20000, 94, 5, 'on'),
('BK04', 'Chocolate', '2021-01-01', '2022-12-12', 38000, 96, 5, 'on'),
('BK05', 'Thach', '2021-01-01', '2022-12-12', 12000, 98, 5, 'on'),
('BK06', 'Omai', '2021-01-01', '2022-12-12', 100000, 98, 5, 'on'),
('BK07', 'món a', '2021-01-01', '2022-12-12', 20000, 0, 5, 'on'),
('BK08', 'abc', '2021-01-01', '2022-12-12', 30000, 150, 5, 'on'),
('DM01', 'Khan', '2021-01-01', '2022-12-12', 30000, 98, 9, 'on'),
('DM02', 'Khau trang', '2021-01-01', '2022-12-12', 23000, 79, 9, 'on'),
('DM03', 'Ao ca sa', '2021-01-01', '2022-12-12', 500000, 100, 9, 'on'),
('DU01', 'Bot ngu coc', '2021-01-01', '2022-12-12', 62000, 50, 4, 'on'),
('DU02', 'Bia', '2021-01-01', '2022-12-12', 139000, 75, 4, 'on'),
('DU03', 'Ruou manh', '2021-01-01', '2022-12-12', 150000, 97, 4, 'on'),
('DU04', 'Ruou vang', '2021-01-01', '2022-12-12', 800000, 98, 4, 'on'),
('DU05', 'Ruou gao', '2021-01-01', '2022-12-12', 28000, 90, 4, 'on'),
('DU06', 'Coca', '2021-01-01', '2022-12-12', 10000, 98, 4, 'on'),
('DU07', 'Pepsi', '2021-01-01', '2022-12-12', 12000, 100, 4, 'on'),
('DU08', 'Cafe', '2021-01-01', '2022-12-12', 14000, 100, 4, 'on'),
('GD01', 'Binh gom', '2021-01-01', '2022-12-12', 726000, 100, 7, 'on'),
('GD02', 'Ban ui', '2021-01-01', '2022-12-12', 350000, 100, 7, 'on'),
('GD03', 'Tu lanh', '2021-01-01', '2022-12-12', 2500000, 70, 7, 'on'),
('GVB01', 'Khan uot', '2021-01-01', '2022-12-12', 21000, 81, 12, 'on'),
('GVB02', 'Khan giay', '2021-01-01', '2022-12-12', 11000, 86, 12, 'on'),
('HDL01', 'Tom', '2021-01-01', '2022-12-12', 120000, 98, 2, 'on'),
('HDL02', 'Ca', '2021-01-01', '2022-12-12', 47000, 81, 2, 'on'),
('HDL03', 'Muc', '2021-01-01', '2022-12-12', 72000, 80, 2, 'on'),
('HM01', 'Banh bao', '2021-01-01', '2022-12-12', 19000, 47, 1, 'on'),
('HM02', 'Sua chua nep cam', '2021-01-01', '2022-12-12', 13000, 100, 1, 'on'),
('HM03', 'Xuc xich', '2021-01-01', '2022-12-12', 15000, 81, 1, 'on'),
('HM04', 'Lap xuong', '2021-01-01', '2022-12-12', 80000, 98, 1, 'on'),
('HP01', 'Bot giat', '2021-01-01', '2022-12-12', 46000, 98, 11, 'on'),
('HP02', 'Thuoc tay', '2021-01-01', '2022-12-12', 21000, 98, 11, 'on'),
('MP01', 'Kem danh rang PS', '2021-01-01', '2022-12-12', 16000, 100, 10, 'on'),
('MP02', 'Ban chai', '2021-01-01', '2022-12-12', 10000, 100, 10, 'on'),
('MP03', 'Dau goi', '2021-01-01', '2022-12-12', 62000, 100, 10, 'on'),
('MP04', 'Sua tam', '2021-01-01', '2022-12-12', 40000, 100, 10, 'on'),
('MP05', 'Son', '2021-01-01', '2022-12-12', 500000, 98, 10, 'on'),
('TPK01', 'Gao', '2021-01-01', '2022-12-12', 24000, 99, 3, 'on'),
('TPK02', 'Sua bot', '2021-01-01', '2022-12-12', 110000, 100, 3, 'on'),
('TPK03', 'Ngu coc', '2021-01-01', '2022-12-12', 56000, 100, 3, 'on'),
('TPK04', 'Rong bien', '2021-01-01', '2022-12-12', 44000, 98, 3, 'on'),
('TPK05', 'Duong', '2021-01-01', '2022-12-12', 9000, 98, 3, 'on'),
('TPK06', 'Sua ong Tho', '2021-01-01', '2022-12-12', 19000, 100, 3, 'on'),
('TPK07', 'Dau chien xao', '2021-01-01', '2022-12-12', 34000, 100, 3, 'on'),
('TPK08', 'Dau thuc vat', '2021-01-01', '2022-12-12', 70000, 80, 3, 'on'),
('TPK09', 'Dau oliu', '2021-01-01', '2022-12-12', 120000, 100, 3, 'on'),
('TPK10', 'Nuoc tuong', '2021-01-01', '2022-12-12', 26000, 78, 3, 'on'),
('TPK11', 'Dau hao', '2021-01-01', '2022-12-12', 31000, 100, 3, 'on'),
('TPK12', 'Mi goi', '2021-01-01', '2022-12-12', 3500, 90, 3, 'on'),
('VPP01', 'Thuoc ke', '2021-01-01', '2022-12-12', 7000, 99, 8, 'on'),
('VPP02', 'But', '2021-01-01', '2022-12-12', 3000, 95, 8, 'on'),
('VPP03', 'Ao mua', '2021-01-01', '2022-12-12', 5000, 100, 8, 'on'),
('VPP04', 'Mu', '2021-01-01', '2022-12-12', 30000, 100, 8, 'on'),
('VPP05', 'That lung', '2021-01-01', '2022-12-12', 400000, 100, 8, 'on');

-- --------------------------------------------------------

--
-- Table structure for table `tai_khoan`
--

CREATE TABLE `tai_khoan` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `ma_nv` char(20) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tai_khoan`
--

INSERT INTO `tai_khoan` (`username`, `password`, `ma_nv`, `status`) VALUES
('baoluan', '0512', 'NV03', 'on'),
('giaduc', '2304', 'NV01', 'on'),
('chibang', '1111', 'NV02', 'on'),
('admin', 'admin', 'NV00', 'on'),
('trunghau', '1111', 'NV04', 'on'),
('aaaaa', 'aaaaa', 'NV05', 'deleted'),
('bbb', 'bbb', 'NV06', 'deleted'),
('NV07', 'NV07', 'NV07', 'deleted'),
('NV08', 'NV081', 'NV08', 'deleted');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chuc_vu`
--
ALTER TABLE `chuc_vu`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ct_hoa_don`
--
ALTER TABLE `ct_hoa_don`
  ADD KEY `ma_sp` (`ma_sp`),
  ADD KEY `ma_hd` (`ma_hd`);

--
-- Indexes for table `ct_khuyen_mai`
--
ALTER TABLE `ct_khuyen_mai`
  ADD KEY `ma_km` (`ma_km`),
  ADD KEY `ma_sp` (`ma_sp`);

--
-- Indexes for table `ct_phieu_nhap`
--
ALTER TABLE `ct_phieu_nhap`
  ADD KEY `ma_pn` (`ma_pn`),
  ADD KEY `ma_sp` (`ma_sp`);

--
-- Indexes for table `hoa_don`
--
ALTER TABLE `hoa_don`
  ADD PRIMARY KEY (`id`),
  ADD KEY `ma_nv` (`ma_nv`),
  ADD KEY `ma_kh` (`ma_kh`);

--
-- Indexes for table `khach_hang`
--
ALTER TABLE `khach_hang`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `khuyen_mai`
--
ALTER TABLE `khuyen_mai`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `loai_hang`
--
ALTER TABLE `loai_hang`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ncc`
--
ALTER TABLE `ncc`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `nhan_vien`
--
ALTER TABLE `nhan_vien`
  ADD PRIMARY KEY (`id`),
  ADD KEY `ma_chucvu` (`ma_chucvu`);

--
-- Indexes for table `phieu_nhap`
--
ALTER TABLE `phieu_nhap`
  ADD PRIMARY KEY (`id`),
  ADD KEY `ma_nv` (`ma_nv`),
  ADD KEY `ma_ncc` (`ma_ncc`);

--
-- Indexes for table `quyen_han`
--
ALTER TABLE `quyen_han`
  ADD KEY `ma_chucvu` (`ma_nhanvien`);

--
-- Indexes for table `san_pham`
--
ALTER TABLE `san_pham`
  ADD PRIMARY KEY (`id`),
  ADD KEY `ma_loai` (`ma_loai`);

--
-- Indexes for table `tai_khoan`
--
ALTER TABLE `tai_khoan`
  ADD KEY `ma_nv` (`ma_nv`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ct_hoa_don`
--
ALTER TABLE `ct_hoa_don`
  ADD CONSTRAINT `ct_hoa_don_ibfk_1` FOREIGN KEY (`ma_hd`) REFERENCES `hoa_don` (`id`),
  ADD CONSTRAINT `ct_hoa_don_ibfk_2` FOREIGN KEY (`ma_sp`) REFERENCES `san_pham` (`id`);

--
-- Constraints for table `ct_khuyen_mai`
--
ALTER TABLE `ct_khuyen_mai`
  ADD CONSTRAINT `ct_khuyen_mai_ibfk_1` FOREIGN KEY (`ma_sp`) REFERENCES `san_pham` (`id`),
  ADD CONSTRAINT `ct_khuyen_mai_ibfk_2` FOREIGN KEY (`ma_km`) REFERENCES `khuyen_mai` (`id`);

--
-- Constraints for table `ct_phieu_nhap`
--
ALTER TABLE `ct_phieu_nhap`
  ADD CONSTRAINT `ct_phieu_nhap_ibfk_1` FOREIGN KEY (`ma_sp`) REFERENCES `san_pham` (`id`),
  ADD CONSTRAINT `ct_phieu_nhap_ibfk_2` FOREIGN KEY (`ma_pn`) REFERENCES `phieu_nhap` (`id`);

--
-- Constraints for table `hoa_don`
--
ALTER TABLE `hoa_don`
  ADD CONSTRAINT `hoa_don_ibfk_1` FOREIGN KEY (`ma_kh`) REFERENCES `khach_hang` (`id`),
  ADD CONSTRAINT `hoa_don_ibfk_2` FOREIGN KEY (`ma_nv`) REFERENCES `nhan_vien` (`id`);

--
-- Constraints for table `nhan_vien`
--
ALTER TABLE `nhan_vien`
  ADD CONSTRAINT `nhan_vien_ibfk_1` FOREIGN KEY (`ma_chucvu`) REFERENCES `chuc_vu` (`id`);

--
-- Constraints for table `phieu_nhap`
--
ALTER TABLE `phieu_nhap`
  ADD CONSTRAINT `phieu_nhap_ibfk_1` FOREIGN KEY (`ma_ncc`) REFERENCES `ncc` (`id`),
  ADD CONSTRAINT `phieu_nhap_ibfk_2` FOREIGN KEY (`ma_nv`) REFERENCES `nhan_vien` (`id`);

--
-- Constraints for table `quyen_han`
--
ALTER TABLE `quyen_han`
  ADD CONSTRAINT `quyen_han_ibfk_1` FOREIGN KEY (`ma_nhanvien`) REFERENCES `nhan_vien` (`id`);

--
-- Constraints for table `san_pham`
--
ALTER TABLE `san_pham`
  ADD CONSTRAINT `san_pham_ibfk_1` FOREIGN KEY (`ma_loai`) REFERENCES `loai_hang` (`id`);

--
-- Constraints for table `tai_khoan`
--
ALTER TABLE `tai_khoan`
  ADD CONSTRAINT `tai_khoan_ibfk_1` FOREIGN KEY (`ma_nv`) REFERENCES `nhan_vien` (`id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
