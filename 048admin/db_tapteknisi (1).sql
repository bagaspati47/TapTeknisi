-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 07 Sep 2016 pada 07.20
-- Versi Server: 10.1.10-MariaDB
-- PHP Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_tapteknisi`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `admin`
--

CREATE TABLE `admin` (
  `id_admin` varchar(5) NOT NULL,
  `nm_admin` varchar(50) NOT NULL,
  `un_admin` varchar(20) NOT NULL,
  `pw_admin` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `admin`
--

INSERT INTO `admin` (`id_admin`, `nm_admin`, `un_admin`, `pw_admin`) VALUES
('0001', 'Urip', 'urip', '123');

-- --------------------------------------------------------

--
-- Stand-in structure for view `status`
--
CREATE TABLE `status` (
`id_teknisi` int(5) unsigned zerofill
,`nm_teknisi` varchar(50)
,`hp_teknisi` varchar(12)
,`sts_terdaftar` varchar(15)
,`sts_reputasi` varchar(10)
,`fp_link` text
);

-- --------------------------------------------------------

--
-- Struktur dari tabel `teknisi`
--

CREATE TABLE `teknisi` (
  `id_teknisi` int(5) UNSIGNED ZEROFILL NOT NULL,
  `nm_teknisi` varchar(50) NOT NULL,
  `hp_teknisi` varchar(12) NOT NULL,
  `email` varchar(50) NOT NULL,
  `un_teknisi` varchar(20) NOT NULL,
  `pw_teknisi` varchar(8) NOT NULL,
  `sts_terdaftar` varchar(15) NOT NULL DEFAULT 'Belum Terdaftar' COMMENT 'ini nanti ada 2 pilihan: terdaftar atau tidak terdaftar',
  `sts_reputasi` varchar(10) NOT NULL DEFAULT 'Baik',
  `fp_link` text NOT NULL,
  `crt_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'ini date buatnya kang'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `teknisi`
--

INSERT INTO `teknisi` (`id_teknisi`, `nm_teknisi`, `hp_teknisi`, `email`, `un_teknisi`, `pw_teknisi`, `sts_terdaftar`, `sts_reputasi`, `fp_link`, `crt_date`) VALUES
(00047, 'Akiu', '089680139247', 'gagakitem47@gmail.com', 'Akiu', '28tap', 'Terdaftar', 'Baik', 'http://gdurl.com/cjVY', '2016-09-03 03:57:12'),
(00048, 'Alex Hermanto', '089999990', 'alex@gmail.com', 'alex', '1234', 'Terdaftar', 'Baik', 'http://gdurl.com/qrL0', '2016-09-02 17:00:00'),
(00049, 'Mardiansyah', '0898899000', 'mardi@gmail.com', 'yansa', '123', 'Belum Terdaftar', 'Baik', 'xxxxxxxxxxxxxxxxx', '2016-09-02 17:00:00'),
(00050, 'Agub', '0899889898', 'a@g.com', 'gub', '7110eda4', 'Belum Terdaftar', 'Baik', '', '2016-09-03 09:50:26'),
(00052, 'Aguj', '0899889898', 'a@b.com', 'gum', '7110eda4', 'Belum Terdaftar', 'Baik', '', '2016-09-03 09:55:03');

-- --------------------------------------------------------

--
-- Struktur untuk view `status`
--
DROP TABLE IF EXISTS `status`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `status`  AS  select `teknisi`.`id_teknisi` AS `id_teknisi`,`teknisi`.`nm_teknisi` AS `nm_teknisi`,`teknisi`.`hp_teknisi` AS `hp_teknisi`,`teknisi`.`sts_terdaftar` AS `sts_terdaftar`,`teknisi`.`sts_reputasi` AS `sts_reputasi`,`teknisi`.`fp_link` AS `fp_link` from `teknisi` where (`teknisi`.`sts_terdaftar` = 'Terdaftar') ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `teknisi`
--
ALTER TABLE `teknisi`
  ADD PRIMARY KEY (`id_teknisi`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `teknisi`
--
ALTER TABLE `teknisi`
  MODIFY `id_teknisi` int(5) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
