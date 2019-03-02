-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 02, 2019 at 01:02 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 7.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rescuethechild`
--

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `username` varchar(20) NOT NULL,
  `pwd` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`username`, `pwd`) VALUES
('Jyothi', '12345'),
('mani', 'sha');

-- --------------------------------------------------------

--
-- Table structure for table `map`
--

CREATE TABLE `map` (
  `name1` varchar(50) NOT NULL,
  `lat` varchar(40) NOT NULL,
  `lon` varchar(40) NOT NULL,
  `pn` varchar(14) NOT NULL,
  `addr` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `map`
--

INSERT INTO `map` (`name1`, `lat`, `lon`, `pn`, `addr`) VALUES
('chiguru children''s village', '16.509284', '80.565016', '8106005815', 'tadepalli,vja'),
('skcv child''s trust1', '16.515230', '80.624271', '8500735729', 'hanumanpet,vja'),
('nava jeevan bala bhavan', '16.518411', '80.633540', '9000515807', 'Bavajipeta,vja'),
('1-town police station', '16.515656', '80.613252', '9182023017', '1-town tarapeta,vja'),
('nirmala sishu bhavan', '16.501670', '80.627570', '9247233244', 'dwarakanagar,krishnalanka,vja'),
('2-town police station', '16.526330', '80.611128', '9963472867', 'vagu centre,vja');

-- --------------------------------------------------------

--
-- Table structure for table `orphanageregistration`
--

CREATE TABLE `orphanageregistration` (
  `name` varchar(20) NOT NULL,
  `ona` varchar(20) NOT NULL,
  `mid` varchar(20) NOT NULL,
  `pwd` varchar(10) NOT NULL,
  `add1` varchar(25) NOT NULL,
  `pn` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orphanageregistration`
--

INSERT INTO `orphanageregistration` (`name`, `ona`, `mid`, `pwd`, `add1`, `pn`) VALUES
('jyo', 'jyothi', 'jyothi', '12345', 'rrnagar', '12345'),
('jyo', 'jyo', 'jyo', '123', '123', '123'),
('jyo', 'jyo', 'jyo', '123', '123', '123'),
('dgnn', 'xgjnml', 'xghnk', 'xfbki', 'zfgvnk', ',gnki'),
('lakahmi', 'mother therisa', 'lakshmishine99@gmail', 'lakshmi', 'Vijayawada', '8106005815'),
('lakshmi', 'mother', 'lakshmishine99@gmail', 'lakshmi', 'Vijayawada', '8106005815');

-- --------------------------------------------------------

--
-- Table structure for table `peopleregistration`
--

CREATE TABLE `peopleregistration` (
  `fn` varchar(20) NOT NULL,
  `ln` varchar(20) NOT NULL,
  `mid` varchar(50) NOT NULL,
  `pwd` varchar(11) NOT NULL,
  `add1` varchar(25) NOT NULL,
  `pn` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `peopleregistration`
--

INSERT INTO `peopleregistration` (`fn`, `ln`, `mid`, `pwd`, `add1`, `pn`) VALUES
('', '', '', '', '', ''),
('jyothi1', 'addagiri2', 'Jyothiaddagiri1998', '12345', 'rr', '2345'),
('jyothi', 'addagiri', 'jyothiaddagiri1998@gmail.com', '12345', '3-2-51', '9182023017'),
('lakshmi', 'chakka', 'lakshmishine99', 'lakahmi', 'Vijayawada', '8106005815'),
('sri silpa', 'padmanabhuni', 'silpa@pscmr.ac.in', '12345678', 'vjw', '9966104060'),
('sowjanya', 'Boddu', 'sowjanyabodduabcd@gmail.com', 'appsabcd', 'krishnalanka,vja ', '6303502972');

-- --------------------------------------------------------

--
-- Table structure for table `temple`
--

CREATE TABLE `temple` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `age` varchar(3) NOT NULL,
  `gname` varchar(100) NOT NULL,
  `phoneno` varchar(12) NOT NULL,
  `address` varchar(500) NOT NULL,
  `imgpath` varchar(150) NOT NULL,
  `datatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `map`
--
ALTER TABLE `map`
  ADD PRIMARY KEY (`pn`);

--
-- Indexes for table `peopleregistration`
--
ALTER TABLE `peopleregistration`
  ADD PRIMARY KEY (`mid`);

--
-- Indexes for table `temple`
--
ALTER TABLE `temple`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `temple`
--
ALTER TABLE `temple`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
