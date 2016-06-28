-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 28, 2016 at 08:18 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.5.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `chessenginedatabase`
--

-- --------------------------------------------------------

--
-- Table structure for table `chess_move`
--

CREATE TABLE `chess_move` (
  `ID` bigint(20) NOT NULL,
  `FEN_POSITION` varchar(255) DEFAULT NULL,
  `MOVE_THAT_WAS_MADE` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `chess_move_pair`
--

CREATE TABLE `chess_move_pair` (
  `ID` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `chess_problem`
--

CREATE TABLE `chess_problem` (
  `ID` bigint(20) NOT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `DIFFICULTY_LEVEL` varchar(255) DEFAULT NULL,
  `INITIAL_POSITION_FEN` varchar(255) DEFAULT NULL,
  `IS_PROBLEM_OF_THE_DAY` bit(1) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `SOLUTION_MOVE_FROM` varchar(255) DEFAULT NULL,
  `SOLUTION_MOVE_TO` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `chess_problem`
--

INSERT INTO `chess_problem` (`ID`, `DESCRIPTION`, `DIFFICULTY_LEVEL`, `INITIAL_POSITION_FEN`, `IS_PROBLEM_OF_THE_DAY`, `NAME`, `SOLUTION_MOVE_FROM`, `SOLUTION_MOVE_TO`) VALUES
(1, 'Make one move for check mate.', 'EASY', '2R5/8/8/k1K5/8/8/8/8', b'0', 'Check mate with the rook', 'c8', 'a8'),
(2, 'Make one move for check mate.', 'HARD', '1kq2r2/2r1n2p/1p3p2/6p1/Q3N1P1/5P2/2P4P/RK3R2', b'1', 'Check mate with the Queen', 'a4', 'a8');

-- --------------------------------------------------------

--
-- Table structure for table `chess_strategy`
--

CREATE TABLE `chess_strategy` (
  `ID` bigint(20) NOT NULL,
  `CATEGORY` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `chess_strategy_chess_strategy_move_pair`
--

CREATE TABLE `chess_strategy_chess_strategy_move_pair` (
  `CHESS_STRATEGY_ID` bigint(20) NOT NULL,
  `movePairs_ID` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `chess_strategy_move`
--

CREATE TABLE `chess_strategy_move` (
  `ID` bigint(20) NOT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `chess_strategy_move_pair`
--

CREATE TABLE `chess_strategy_move_pair` (
  `ID` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `join_table_chess_game_black_move`
--

CREATE TABLE `join_table_chess_game_black_move` (
  `blackMove_ID` bigint(20) DEFAULT NULL,
  `ID` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `join_table_chess_game_white_move`
--

CREATE TABLE `join_table_chess_game_white_move` (
  `whiteMove_ID` bigint(20) DEFAULT NULL,
  `ID` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `join_table_strategy_black_move`
--

CREATE TABLE `join_table_strategy_black_move` (
  `blackMove_ID` bigint(20) DEFAULT NULL,
  `ID` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `join_table_strategy_white_move`
--

CREATE TABLE `join_table_strategy_white_move` (
  `whiteMove_ID` bigint(20) DEFAULT NULL,
  `ID` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `latest_news`
--

CREATE TABLE `latest_news` (
  `ID` bigint(20) NOT NULL,
  `DATE` datetime DEFAULT NULL,
  `TEXT` varchar(255) DEFAULT NULL,
  `TITLE` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `latest_news`
--

INSERT INTO `latest_news` (`ID`, `DATE`, `TEXT`, `TITLE`) VALUES
(2, '2016-06-28 20:13:04', 'The new design has been successfully installed on the site.', 'New design available!'),
(3, '2016-06-28 20:23:22', 'Browse the site and <a href="/contact-us/">give us feedback</a>', 'Site is now online!');

-- --------------------------------------------------------

--
-- Table structure for table `message`
--

CREATE TABLE `message` (
  `ID` bigint(20) NOT NULL,
  `DATE` datetime DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `IS_READ` bit(1) DEFAULT NULL,
  `TEXT` varchar(255) DEFAULT NULL,
  `USERNAME` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `quote_of_the_day`
--

CREATE TABLE `quote_of_the_day` (
  `ID` bigint(20) NOT NULL,
  `AUTHOR` varchar(255) DEFAULT NULL,
  `IS_QUOTE_OF_THE_DAY` bit(1) DEFAULT NULL,
  `QUOTE` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `quote_of_the_day`
--

INSERT INTO `quote_of_the_day` (`ID`, `AUTHOR`, `IS_QUOTE_OF_THE_DAY`, `QUOTE`) VALUES
(1, 'Emanuel Lasker', b'0', 'When you see a good move, look for a better one'),
(2, 'Brian Tracy', b'1', 'The greatest pleasure in life is doing what people say you cannot do.'),
(4, 'Brian Tracy', b'0', 'Mistakes are proof that you are trying.');

-- --------------------------------------------------------

--
-- Table structure for table `saved_match`
--

CREATE TABLE `saved_match` (
  `ID` bigint(20) NOT NULL,
  `DATE` datetime DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `PLAYER_COLOR` varchar(255) DEFAULT NULL,
  `STATUS` varchar(255) DEFAULT NULL,
  `VIRTUAL_PLAYER_LEVEL` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `saved_match_chess_move_pair`
--

CREATE TABLE `saved_match_chess_move_pair` (
  `SAVED_MATCH_ID` bigint(20) NOT NULL,
  `movePairs_ID` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `USERNAME` varchar(255) NOT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `FIRST_NAME` varchar(255) DEFAULT NULL,
  `LAST_NAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) NOT NULL,
  `ROLE` varchar(255) NOT NULL,
  `STATE` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`USERNAME`, `EMAIL`, `FIRST_NAME`, `LAST_NAME`, `PASSWORD`, `ROLE`, `STATE`) VALUES
('admin', 'admin@chessengine.com', 'David', 'Balazs', 'admin', 'ROLE_ADMIN', 'ACTIVE');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chess_move`
--
ALTER TABLE `chess_move`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `chess_move_pair`
--
ALTER TABLE `chess_move_pair`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `chess_problem`
--
ALTER TABLE `chess_problem`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `chess_strategy`
--
ALTER TABLE `chess_strategy`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `chess_strategy_chess_strategy_move_pair`
--
ALTER TABLE `chess_strategy_chess_strategy_move_pair`
  ADD UNIQUE KEY `UK_kn9hbb1dh2y6jucrctn40sd86` (`movePairs_ID`),
  ADD KEY `FK_pq49fd2p5t2ya9wfhy7xiqurf` (`CHESS_STRATEGY_ID`);

--
-- Indexes for table `chess_strategy_move`
--
ALTER TABLE `chess_strategy_move`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `chess_strategy_move_pair`
--
ALTER TABLE `chess_strategy_move_pair`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `join_table_chess_game_black_move`
--
ALTER TABLE `join_table_chess_game_black_move`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_bruwn12mm3j7e0c14rrrpxm92` (`blackMove_ID`);

--
-- Indexes for table `join_table_chess_game_white_move`
--
ALTER TABLE `join_table_chess_game_white_move`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_fh7ebuph6otluf20f95c9qr6j` (`whiteMove_ID`);

--
-- Indexes for table `join_table_strategy_black_move`
--
ALTER TABLE `join_table_strategy_black_move`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_jdkukravqu9tlfkvc2h2e83ga` (`blackMove_ID`);

--
-- Indexes for table `join_table_strategy_white_move`
--
ALTER TABLE `join_table_strategy_white_move`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_fm2emlgctm2utyxkernaw56mr` (`whiteMove_ID`);

--
-- Indexes for table `latest_news`
--
ALTER TABLE `latest_news`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `quote_of_the_day`
--
ALTER TABLE `quote_of_the_day`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `saved_match`
--
ALTER TABLE `saved_match`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `saved_match_chess_move_pair`
--
ALTER TABLE `saved_match_chess_move_pair`
  ADD UNIQUE KEY `UK_k3ontwjpfk2cwd99jq5uosu6n` (`movePairs_ID`),
  ADD KEY `FK_kh28755ocl8bfcla9cly7inv9` (`SAVED_MATCH_ID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`USERNAME`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `chess_move`
--
ALTER TABLE `chess_move`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `chess_move_pair`
--
ALTER TABLE `chess_move_pair`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `chess_problem`
--
ALTER TABLE `chess_problem`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `chess_strategy`
--
ALTER TABLE `chess_strategy`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `chess_strategy_move`
--
ALTER TABLE `chess_strategy_move`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `chess_strategy_move_pair`
--
ALTER TABLE `chess_strategy_move_pair`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `latest_news`
--
ALTER TABLE `latest_news`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `message`
--
ALTER TABLE `message`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `quote_of_the_day`
--
ALTER TABLE `quote_of_the_day`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `saved_match`
--
ALTER TABLE `saved_match`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `chess_strategy_chess_strategy_move_pair`
--
ALTER TABLE `chess_strategy_chess_strategy_move_pair`
  ADD CONSTRAINT `FK_kn9hbb1dh2y6jucrctn40sd86` FOREIGN KEY (`movePairs_ID`) REFERENCES `chess_strategy_move_pair` (`ID`),
  ADD CONSTRAINT `FK_pq49fd2p5t2ya9wfhy7xiqurf` FOREIGN KEY (`CHESS_STRATEGY_ID`) REFERENCES `chess_strategy` (`ID`);

--
-- Constraints for table `join_table_chess_game_black_move`
--
ALTER TABLE `join_table_chess_game_black_move`
  ADD CONSTRAINT `FK_74m90mqouwmhfjvnp2qlqffdc` FOREIGN KEY (`ID`) REFERENCES `chess_move_pair` (`ID`),
  ADD CONSTRAINT `FK_bruwn12mm3j7e0c14rrrpxm92` FOREIGN KEY (`blackMove_ID`) REFERENCES `chess_move` (`ID`);

--
-- Constraints for table `join_table_chess_game_white_move`
--
ALTER TABLE `join_table_chess_game_white_move`
  ADD CONSTRAINT `FK_fh7ebuph6otluf20f95c9qr6j` FOREIGN KEY (`whiteMove_ID`) REFERENCES `chess_move` (`ID`),
  ADD CONSTRAINT `FK_l0pup5866gevrgf6jhrpsuhwm` FOREIGN KEY (`ID`) REFERENCES `chess_move_pair` (`ID`);

--
-- Constraints for table `join_table_strategy_black_move`
--
ALTER TABLE `join_table_strategy_black_move`
  ADD CONSTRAINT `FK_9komrokytks6q9p6njmfcurop` FOREIGN KEY (`ID`) REFERENCES `chess_strategy_move_pair` (`ID`),
  ADD CONSTRAINT `FK_jdkukravqu9tlfkvc2h2e83ga` FOREIGN KEY (`blackMove_ID`) REFERENCES `chess_strategy_move` (`ID`);

--
-- Constraints for table `join_table_strategy_white_move`
--
ALTER TABLE `join_table_strategy_white_move`
  ADD CONSTRAINT `FK_fm2emlgctm2utyxkernaw56mr` FOREIGN KEY (`whiteMove_ID`) REFERENCES `chess_strategy_move` (`ID`),
  ADD CONSTRAINT `FK_rc1272vh8h6dgqr4k31o3hrac` FOREIGN KEY (`ID`) REFERENCES `chess_strategy_move_pair` (`ID`);

--
-- Constraints for table `saved_match_chess_move_pair`
--
ALTER TABLE `saved_match_chess_move_pair`
  ADD CONSTRAINT `FK_k3ontwjpfk2cwd99jq5uosu6n` FOREIGN KEY (`movePairs_ID`) REFERENCES `chess_move_pair` (`ID`),
  ADD CONSTRAINT `FK_kh28755ocl8bfcla9cly7inv9` FOREIGN KEY (`SAVED_MATCH_ID`) REFERENCES `saved_match` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
