-- phpMyAdmin SQL Dump
-- version 4.4.3
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Mar 16 Juin 2015 à 19:44
-- Version du serveur :  5.6.24
-- Version de PHP :  5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `find_a_desk`
--

-- --------------------------------------------------------

--
-- Structure de la table `booking`
--

CREATE TABLE IF NOT EXISTS `booking` (
  `booking_id` int(15) NOT NULL,
  `start_date` timestamp NULL DEFAULT NULL,
  `finish_date` timestamp NULL DEFAULT NULL,
  `date_booking` date DEFAULT NULL,
  `price_booking` double DEFAULT NULL,
  `user_id` int(11) NOT NULL DEFAULT '0',
  `workspace_id` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `booking`
--

INSERT INTO `booking` (`booking_id`, `start_date`, `finish_date`, `date_booking`, `price_booking`, `user_id`, `workspace_id`) VALUES
(1, '2015-06-16 17:44:35', '2015-06-16 17:44:35', NULL, NULL, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `card_type`
--

CREATE TABLE IF NOT EXISTS `card_type` (
  `card_type_id` int(11) NOT NULL,
  `label` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(11) NOT NULL,
  `first_name` varchar(32) NOT NULL,
  `last_name` varchar(32) NOT NULL,
  `address` varchar(255) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(32) NOT NULL,
  `telephone_number` varchar(15) NOT NULL,
  `company` varchar(32) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`user_id`, `first_name`, `last_name`, `address`, `email`, `password`, `telephone_number`, `company`) VALUES
(1, 'Damien', 'TALBOT', '2 st...', 'damientalbot26@email.com', 'encrypted pwd', '9364204930', 'brand new company');

-- --------------------------------------------------------

--
-- Structure de la table `workspace`
--

CREATE TABLE IF NOT EXISTS `workspace` (
  `workspace_id` int(11) NOT NULL,
  `workspace_type_id` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `seats_number` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `email_admin` varchar(32) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `city` varchar(32) DEFAULT NULL,
  `cp` int(5) DEFAULT NULL,
  `country` varchar(20) DEFAULT NULL,
  `longitude` float DEFAULT NULL,
  `latitude` float DEFAULT NULL,
  `type` bigint(20) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `workspace`
--

INSERT INTO `workspace` (`workspace_id`, `workspace_type_id`, `price`, `seats_number`, `description`, `email_admin`, `address`, `city`, `cp`, `country`, `longitude`, `latitude`, `type`) VALUES
(1, NULL, 0, 0, 'description', 'admin@gmail.com', '120 street something', 'LA', 27000, 'USA', 0, 0, 2);

-- --------------------------------------------------------

--
-- Structure de la table `workspace_type`
--

CREATE TABLE IF NOT EXISTS `workspace_type` (
  `workspace_type_id` int(11) NOT NULL,
  `label` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`booking_id`,`user_id`,`workspace_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `workspace_id` (`workspace_id`);

--
-- Index pour la table `card_type`
--
ALTER TABLE `card_type`
  ADD PRIMARY KEY (`card_type_id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- Index pour la table `workspace`
--
ALTER TABLE `workspace`
  ADD PRIMARY KEY (`workspace_id`),
  ADD KEY `workspace_type_id` (`workspace_type_id`);

--
-- Index pour la table `workspace_type`
--
ALTER TABLE `workspace_type`
  ADD PRIMARY KEY (`workspace_type_id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `booking`
--
ALTER TABLE `booking`
  MODIFY `booking_id` int(15) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `card_type`
--
ALTER TABLE `card_type`
  MODIFY `card_type_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `workspace`
--
ALTER TABLE `workspace`
  MODIFY `workspace_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `workspace_type`
--
ALTER TABLE `workspace_type`
  MODIFY `workspace_type_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `booking`
--
ALTER TABLE `booking`
  ADD CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `booking_ibfk_2` FOREIGN KEY (`workspace_id`) REFERENCES `workspace` (`workspace_id`);

--
-- Contraintes pour la table `workspace`
--
ALTER TABLE `workspace`
  ADD CONSTRAINT `workspace_ibfk_1` FOREIGN KEY (`workspace_type_id`) REFERENCES `workspace_type` (`workspace_type_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
