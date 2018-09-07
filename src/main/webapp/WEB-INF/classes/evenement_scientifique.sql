-- phpMyAdmin SQL Dump
-- version 4.1.4
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Ven 24 Août 2018 à 21:38
-- Version du serveur :  5.6.15-log
-- Version de PHP :  5.4.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `evenement_scientifique`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE IF NOT EXISTS `client` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `device`
--

CREATE TABLE IF NOT EXISTS `device` (
  `id` bigint(20) NOT NULL,
  `adresseip` varchar(255) DEFAULT NULL,
  `adresse_mac` varchar(255) DEFAULT NULL,
  `date_entree` datetime DEFAULT NULL,
  `date_sortie` datetime DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `user_connexion_login` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKj41sre7ib8mp6b5pki6off5mt` (`user_connexion_login`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `etablissement`
--

CREATE TABLE IF NOT EXISTS `etablissement` (
  `dtype` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `fax` bigint(20) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `tel` bigint(20) DEFAULT NULL,
  `responsable_cin` varchar(255) DEFAULT NULL,
  `rue_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfdtct6f7jpwkauf30k1d318tq` (`responsable_cin`),
  KEY `FKgwafoer7wix6naxskinpmct8h` (`rue_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `etablissement_services_hopital`
--

CREATE TABLE IF NOT EXISTS `etablissement_services_hopital` (
  `hopitals_id` bigint(20) NOT NULL,
  `services_hopital_id` bigint(20) NOT NULL,
  KEY `FK9pxxeqh08cl9mos59xkblutrv` (`services_hopital_id`),
  KEY `FKtpapj24lnyqwe0rnlp3c323qx` (`hopitals_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `etablissement_service_labos`
--

CREATE TABLE IF NOT EXISTS `etablissement_service_labos` (
  `laboratoires_id` bigint(20) NOT NULL,
  `service_labos_id` bigint(20) NOT NULL,
  KEY `FKtidkiec2ixs5aap6744xortq4` (`service_labos_id`),
  KEY `FKlgoj8pq3c5762fktf0vauedxr` (`laboratoires_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `etablissement_specialites`
--

CREATE TABLE IF NOT EXISTS `etablissement_specialites` (
  `cabinets_id` bigint(20) NOT NULL,
  `specialites_id` bigint(20) NOT NULL,
  KEY `FKj0bct0sy5bglli9mneyhucewd` (`specialites_id`),
  KEY `FK3crt3cuw7wfo8rviqyw0pns5v` (`cabinets_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


-- --------------------------------------------------------

--
-- Structure de la table `quartier`
--

CREATE TABLE IF NOT EXISTS `quartier` (
  `id` bigint(20) NOT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `ville_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5iktcd7acpcm546pye2gpbyt5` (`ville_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `rue`
--

CREATE TABLE IF NOT EXISTS `rue` (
  `id` bigint(20) NOT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `quartier_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdw0cx674acqg4e3jcfoeit6i9` (`quartier_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `service_hopital`
--

CREATE TABLE IF NOT EXISTS `service_hopital` (
  `id` bigint(20) NOT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `service_labo`
--

CREATE TABLE IF NOT EXISTS `service_labo` (
  `id` bigint(20) NOT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `specialite`
--

CREATE TABLE IF NOT EXISTS `specialite` (
  `id` bigint(20) NOT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `dtype` varchar(31) NOT NULL,
  `cin` varchar(255) NOT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `tel` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`cin`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `user_connexion`
--

CREATE TABLE IF NOT EXISTS `user_connexion` (
  `login` varchar(255) NOT NULL,
  `blocked` bit(1) DEFAULT NULL,
  `mdp` varchar(255) DEFAULT NULL,
  `question_secrete` varchar(255) DEFAULT NULL,
  `reponse_secrete` varchar(255) DEFAULT NULL,
  `user_cin` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`login`),
  KEY `FKa8mbmfy7p4rdom2rigfdxx3n0` (`user_cin`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `ville`
--

CREATE TABLE IF NOT EXISTS `ville` (
  `id` bigint(20) NOT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
