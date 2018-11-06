-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Waktu pembuatan: 06 Nov 2018 pada 14.27
-- Versi server: 10.1.36-MariaDB
-- Versi PHP: 5.6.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_android`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_anggota`
--

CREATE TABLE `tb_anggota` (
  `id` int(11) NOT NULL,
  `kecamatan` varchar(100) NOT NULL,
  `desa` varchar(100) NOT NULL,
  `nama_anggota` varchar(100) NOT NULL,
  `luas_lahan` varchar(100) NOT NULL,
  `jenis_lahan` varchar(100) NOT NULL,
  `jumlah_petak` varchar(100) NOT NULL,
  `premi` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_anggota`
--

INSERT INTO `tb_anggota` (`id`, `kecamatan`, `desa`, `nama_anggota`, `luas_lahan`, `jenis_lahan`, `jumlah_petak`, `premi`) VALUES
(1, 'bgor rian', 'perumdos', 'surya', '1230', 'milik', '200', '20000'),
(2, 'sumedang', 'malaka', 'diman', '200', 'pribadi', '10', '290'),
(3, 'jujue', 'qwwq', 'qwqwq', '1223', '1213', 'qweq', '1222');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_pegawai`
--

CREATE TABLE `tb_pegawai` (
  `id` int(11) NOT NULL,
  `kelompok` varchar(100) NOT NULL,
  `ketua_kelompok` varchar(100) NOT NULL,
  `luas_lahan` varchar(100) NOT NULL,
  `no_hp` varchar(15) NOT NULL,
  `musim_tanam` varchar(100) NOT NULL,
  `kira_tanam` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_pegawai`
--

INSERT INTO `tb_pegawai` (`id`, `kelompok`, `ketua_kelompok`, `luas_lahan`, `no_hp`, `musim_tanam`, `kira_tanam`) VALUES
(2, 'Perdian', 'Developer', '30.000.000', '0', '', '0'),
(3, 'Perdian', 'Developer', '30.000.000', '0', '', '0'),
(4, 'defor', 'apa aja', '100', '0', '', '0'),
(5, 'asal', 'asal', '1000', '0', '', '0'),
(6, 'beben', 'preman', '2000', '0', '', '0'),
(7, 'usaha kita', 'manajer', '2000', '0', '', '0'),
(8, 'Tani Kita', 'Diman', '200', '2147483647', 'februari', 'November'),
(9, 'sue', 'sue', '1000', '10000', 'juli', '0'),
(10, 'wardah', 'wardfetkl', '2001', '121811', 'zxc', 'qasd');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tb_anggota`
--
ALTER TABLE `tb_anggota`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `tb_pegawai`
--
ALTER TABLE `tb_pegawai`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `tb_anggota`
--
ALTER TABLE `tb_anggota`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `tb_pegawai`
--
ALTER TABLE `tb_pegawai`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
