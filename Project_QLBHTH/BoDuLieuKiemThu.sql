CREATE DATABASE  IF NOT EXISTS `qltaphoa` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `qltaphoa`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: qltaphoa
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `hoadon`
--

DROP TABLE IF EXISTS `hoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoadon` (
  `MaHD` varchar(10) NOT NULL,
  `NgayTaoHD` date NOT NULL,
  `TriGia` varchar(45) NOT NULL,
  `MaKH` varchar(10) NOT NULL,
  `MaNV` varchar(10) NOT NULL,
  PRIMARY KEY (`MaHD`),
  KEY `mkh` (`MaKH`),
  KEY `mnv` (`MaNV`),
  CONSTRAINT `mkh` FOREIGN KEY (`MaKH`) REFERENCES `khachhang` (`MaKH`),
  CONSTRAINT `mnv` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoadon`
--

LOCK TABLES `hoadon` WRITE;
/*!40000 ALTER TABLE `hoadon` DISABLE KEYS */;
INSERT INTO `hoadon` VALUES ('HD1','2022-07-02','290000','KH1','NV1'),('HD2','2022-07-02','240000','KH2','NV1'),('HD3','2022-07-02','193000','KH3','NV1'),('HD4','2022-08-02','153000','KH1','NV1'),('HD5','2022-08-02','170000','KH5','NV1'),('HD6','2022-08-02','62000','KH3','NV1');
/*!40000 ALTER TABLE `hoadon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoadon_sanpham`
--

DROP TABLE IF EXISTS `hoadon_sanpham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoadon_sanpham` (
  `MaHD` varchar(10) NOT NULL,
  `MaSP` varchar(10) NOT NULL,
  `SoLuongBan` int NOT NULL,
  PRIMARY KEY (`MaHD`,`MaSP`),
  KEY `mhd` (`MaHD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoadon_sanpham`
--

LOCK TABLES `hoadon_sanpham` WRITE;
/*!40000 ALTER TABLE `hoadon_sanpham` DISABLE KEYS */;
INSERT INTO `hoadon_sanpham` VALUES ('HD1','TPH1',5),('HD1','TPH2',10),('HD2','TPH4',2),('HD2','TPH5',1),('HD2','TPH8',5),('HD2','TPH9',8),('HD3','TPH1',1),('HD3','TPH3',2),('HD3','TPH7',3),('HD3','TPH9',5),('HD4','TPH1',4),('HD4','TPH8',5),('HD5','TPH3',3),('HD5','TPH4',3),('HD5','TPH7',2),('HD5','TPH9',2),('HD6','TPH2',1),('HD6','TPH4',1),('HD6','TPH8',1),('HD6','TPH9',1);
/*!40000 ALTER TABLE `hoadon_sanpham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoadonnhap`
--

DROP TABLE IF EXISTS `hoadonnhap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoadonnhap` (
  `Ngaynhap` date NOT NULL,
  `Soluongnhap` int NOT NULL,
  `MaSP` varchar(50) NOT NULL,
  PRIMARY KEY (`Ngaynhap`,`MaSP`),
  KEY `MaSP` (`MaSP`),
  CONSTRAINT `hoadonnhap_ibfk_1` FOREIGN KEY (`MaSP`) REFERENCES `sanpham` (`MaSP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoadonnhap`
--

LOCK TABLES `hoadonnhap` WRITE;
/*!40000 ALTER TABLE `hoadonnhap` DISABLE KEYS */;
INSERT INTO `hoadonnhap` VALUES ('2022-07-01',100,'TPH1'),('2022-07-01',100,'TPH10'),('2022-07-01',50,'TPH11'),('2022-07-01',100,'TPH2'),('2022-07-01',100,'TPH3'),('2022-07-01',100,'TPH4'),('2022-07-01',100,'TPH5'),('2022-07-01',100,'TPH6'),('2022-07-01',100,'TPH7'),('2022-07-01',100,'TPH8'),('2022-07-01',100,'TPH9'),('2022-08-01',100,'TPH1'),('2022-08-01',20,'TPH10'),('2022-08-01',30,'TPH11'),('2022-08-01',50,'TPH2'),('2022-08-01',50,'TPH3'),('2022-08-01',50,'TPH4'),('2022-08-01',20,'TPH5'),('2022-08-01',50,'TPH6'),('2022-08-01',50,'TPH7'),('2022-08-01',50,'TPH8'),('2022-08-01',20,'TPH9'),('2022-09-01',20,'TPH1'),('2022-09-01',20,'TPH10'),('2022-09-01',20,'TPH11'),('2022-09-01',20,'TPH2'),('2022-09-01',20,'TPH3'),('2022-09-01',20,'TPH4'),('2022-09-01',20,'TPH5'),('2022-09-01',20,'TPH6'),('2022-09-01',20,'TPH7'),('2022-09-01',20,'TPH8'),('2022-09-01',20,'TPH9');
/*!40000 ALTER TABLE `hoadonnhap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khachhang` (
  `MaKH` varchar(10) NOT NULL,
  `TenKH` varchar(45) NOT NULL,
  `Gioitinh` varchar(45) NOT NULL,
  `Diachi` varchar(45) NOT NULL,
  `SoDT` varchar(45) NOT NULL,
  `Vande` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`MaKH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khachhang`
--

LOCK TABLES `khachhang` WRITE;
/*!40000 ALTER TABLE `khachhang` DISABLE KEYS */;
INSERT INTO `khachhang` VALUES ('KH1','An','Nam','HN','0953454534',''),('KH2','Cong','Nam','HP','0954734895',''),('KH3','Hung','Nam','HN','0824234332',''),('KH4','Nam','Nu','HD','0942343243',''),('KH5','Quan','Nu','HN','0642343342',''),('KH6','Binh','Nam','HN','0869975211',''),('KH7','Quyen','Nu','HP','0869972846',''),('KH8','Hang','Nu','HN','0912092426','');
/*!40000 ALTER TABLE `khachhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhacungcap`
--

DROP TABLE IF EXISTS `nhacungcap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhacungcap` (
  `MaNCC` varchar(10) NOT NULL,
  `TenNCC` varchar(45) NOT NULL,
  `DiaChi` varchar(45) NOT NULL,
  `SDT` varchar(45) NOT NULL,
  PRIMARY KEY (`MaNCC`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhacungcap`
--

LOCK TABLES `nhacungcap` WRITE;
/*!40000 ALTER TABLE `nhacungcap` DISABLE KEYS */;
INSERT INTO `nhacungcap` VALUES ('NCC1','Masan','HaNoi','02862563862'),('NCC2','Karavan','CanTho','02534545534');
/*!40000 ALTER TABLE `nhacungcap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhanvien` (
  `MaNV` varchar(10) NOT NULL,
  `TenNV` varchar(45) NOT NULL,
  `GioiTinh` varchar(45) NOT NULL,
  `SDT` varchar(45) NOT NULL,
  `CCCD` varchar(45) NOT NULL,
  PRIMARY KEY (`MaNV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien`
--

LOCK TABLES `nhanvien` WRITE;
/*!40000 ALTER TABLE `nhanvien` DISABLE KEYS */;
INSERT INTO `nhanvien` VALUES ('NV1','TranAnhQuoc','Nam','0869972765','226545238674');
/*!40000 ALTER TABLE `nhanvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sanpham`
--

DROP TABLE IF EXISTS `sanpham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sanpham` (
  `MaSP` varchar(10) NOT NULL,
  `TenSP` varchar(45) NOT NULL,
  `LoaiSP` varchar(45) NOT NULL,
  `GiaNhap` varchar(45) NOT NULL,
  `GiaBan` varchar(45) NOT NULL,
  `NgaySX` date NOT NULL,
  `HanSD` date NOT NULL,
  `SoLuongCon` int NOT NULL,
  `MaNCC` varchar(10) NOT NULL,
  `TrangThai` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`MaSP`),
  KEY `mncc` (`MaNCC`),
  CONSTRAINT `mncc` FOREIGN KEY (`MaNCC`) REFERENCES `nhacungcap` (`MaNCC`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sanpham`
--

LOCK TABLES `sanpham` WRITE;
/*!40000 ALTER TABLE `sanpham` DISABLE KEYS */;
INSERT INTO `sanpham` VALUES ('TPH1','Tra Lipton','Do uong','21000','22000','2022-04-01','2024-04-01',260,'NCC2',0),('TPH10','Mi tom Omachi','Do an lien','6000','7000','2022-03-01','2023-03-01',190,'NCC1',0),('TPH11','My tom Cung Dinh','Do an lien','5000','6000','2022-06-01','2023-06-09',100,'NCC1',0),('TPH12','Gao','Thuc pham kho','35000','40000','2022-05-04','2023-06-14',0,'NCC1',1),('TPH2','Banh Oreo','Banh keo','15000','18000','2022-06-01','2023-06-01',309,'NCC2',0),('TPH3','Sua tuoi Vinamilk','Sua','20000','22000','2022-05-01','2023-06-01',235,'NCC2',0),('TPH4','Sup chay Knorr','Do an lien','12000','14000','2022-07-01','2024-07-01',264,'NCC1',0),('TPH5','Nuoc chanh Muoi','Do uong','10000','11000','2022-05-01','2023-05-01',189,'NCC1',0),('TPH6','Gao Tam Xoan','Thuc pham kho','30000','33000','2022-03-01','2023-03-01',170,'NCC2',0),('TPH7','My tom Hao Hao','Do an lien','5000','14000','2022-02-01','2023-02-01',215,'NCC1',0),('TPH8','Sua chua Vinamilk','Sua','10000','13000','2022-05-01','2023-05-20',209,'NCC2',0),('TPH9','Coca-cola','Do uong','15000','17000','2022-05-01','2023-05-01',194,'NCC2',1);
/*!40000 ALTER TABLE `sanpham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taikhoan`
--

DROP TABLE IF EXISTS `taikhoan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `taikhoan` (
  `tendangnhap` varchar(50) NOT NULL,
  `matkhau` varchar(45) NOT NULL,
  PRIMARY KEY (`tendangnhap`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taikhoan`
--

LOCK TABLES `taikhoan` WRITE;
/*!40000 ALTER TABLE `taikhoan` DISABLE KEYS */;
INSERT INTO `taikhoan` VALUES ('admin','1234'),('employee','5678');
/*!40000 ALTER TABLE `taikhoan` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-22 19:44:28
