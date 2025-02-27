-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 14, 2024 at 04:59 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `parikshit_20`
--

-- --------------------------------------------------------

--
-- Table structure for table `user_info`
--

CREATE TABLE `user_info` (
  `User_Id` int(11) NOT NULL,
  `Ufname` char(15) DEFAULT NULL,
  `Ulname` char(10) DEFAULT NULL,
  `Upwd` char(15) DEFAULT NULL,
  `Umail` varchar(50) DEFAULT NULL,
  `Umno` char(10) DEFAULT NULL,
  `Uaddres` varchar(100) DEFAULT NULL,
  `UserRole_Id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_info`
--

INSERT INTO `user_info` (`User_Id`, `Ufname`, `Ulname`, `Upwd`, `Umail`, `Umno`, `Uaddres`, `UserRole_Id`) VALUES
(1, 'Parikshit', 'Vaghela', '1234567', 'Parikshit@gmail.com', '8469133412', '115,Dhramanath Prabhu Sco,Naroda, Ahmedabad', 103),
(2, 'Parikshitsinh', 'arjunbhai', 'Pappu', 'Vaghelaparikshitsinh257@gmail.com', '8469133412', '115,dharmanath Prabhu soc. Opp satym school, Naroda', 102);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user_info`
--
ALTER TABLE `user_info`
  ADD PRIMARY KEY (`User_Id`),
  ADD KEY `User_Role` (`UserRole_Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user_info`
--
ALTER TABLE `user_info`
  MODIFY `User_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `user_info`
--
ALTER TABLE `user_info`
  ADD CONSTRAINT `User_Role` FOREIGN KEY (`UserRole_Id`) REFERENCES `user_role` (`UserRole_Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
