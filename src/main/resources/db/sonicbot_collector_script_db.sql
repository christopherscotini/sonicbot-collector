/*
Navicat MySQL Data Transfer

Source Server         : LOCAL
Source Server Version : 50522
Source Host           : localhost:3306
Source Database       : sonicbot_collector

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2017-04-07 00:52:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for competition
-- ----------------------------
DROP TABLE IF EXISTS `competition`;
CREATE TABLE `competition` (
  `COMP_CD_ID_PK` bigint(20) NOT NULL,
  `COMP_DS_NAME` varchar(100) NOT NULL,
  `COMP_DS_URL` varchar(255) DEFAULT NULL,
  `FLAG_CD_ID_FK` bigint(20) NOT NULL,
  `COUN_CD_ID_FK` bigint(20) NOT NULL,
  PRIMARY KEY (`COMP_CD_ID_PK`),
  KEY `FLAG_CD_ID_FK` (`FLAG_CD_ID_FK`),
  KEY `FKqa5skmjjre6g9r73axwoe4l8p` (`COUN_CD_ID_FK`),
  CONSTRAINT `FKkb261to0pyyny1t0xeenvgy22` FOREIGN KEY (`FLAG_CD_ID_FK`) REFERENCES `flag` (`FLAG_CD_ID_PK`),
  CONSTRAINT `FKqa5skmjjre6g9r73axwoe4l8p` FOREIGN KEY (`COUN_CD_ID_FK`) REFERENCES `country` (`COUN_CD_ID_PK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of competition
-- ----------------------------
INSERT INTO `competition` VALUES ('1', 'Holanda - Eredivisie', '', '19', '13');
INSERT INTO `competition` VALUES ('5', 'Holanda - Eerste Divisie', '', '20', '13');
INSERT INTO `competition` VALUES ('7', 'Espanha - Primera División', '', '12', '9');
INSERT INTO `competition` VALUES ('8', 'Inglaterra - Championship', '', '22', '15');
INSERT INTO `competition` VALUES ('9', 'Alemanha - 2. Bundesliga', '', '1', '1');
INSERT INTO `competition` VALUES ('11', 'Alemanha - Bundesliga', '', '2', '1');
INSERT INTO `competition` VALUES ('12', 'Espanha - Segunda División', '', '13', '9');
INSERT INTO `competition` VALUES ('13', 'Itália - Série A', '', '26', '17');
INSERT INTO `competition` VALUES ('14', 'Itália - Série B', '', '27', '17');
INSERT INTO `competition` VALUES ('15', 'Inglaterra - Premier League', '', '24', '15');
INSERT INTO `competition` VALUES ('16', 'França - Ligue 1', '', '15', '11');
INSERT INTO `competition` VALUES ('17', 'França - Ligue 2', '', '16', '11');
INSERT INTO `competition` VALUES ('19', 'Turquia - Super Liga', '', '39', '26');
INSERT INTO `competition` VALUES ('24', 'Bélgica - Pro League', '', '7', '4');
INSERT INTO `competition` VALUES ('26', 'Brasil - Série A', '', '5', '3');
INSERT INTO `competition` VALUES ('27', 'Suíça - Super League', '', '38', '25');
INSERT INTO `competition` VALUES ('28', 'Suécia - Allsvenskan', '', '37', '24');
INSERT INTO `competition` VALUES ('29', 'Noruega - Eliteserien', '', '30', '19');
INSERT INTO `competition` VALUES ('30', 'Dinamarca - Super Liga', '', '10', '7');
INSERT INTO `competition` VALUES ('33', 'Estados Unidos da América - MLS', '', '14', '10');
INSERT INTO `competition` VALUES ('34', 'Irlanda - Premier Division', '', '25', '16');
INSERT INTO `competition` VALUES ('43', 'Escócia - Premiership', '', '11', '8');
INSERT INTO `competition` VALUES ('51', 'China - CSL Super Liga', '', '8', '5');
INSERT INTO `competition` VALUES ('59', 'Bulgária - A PFG', '', '41', '28');
INSERT INTO `competition` VALUES ('61', 'Croácia - 1. HNL Primeira Liga', '', '42', '29');
INSERT INTO `competition` VALUES ('63', 'Portugal - Primeira Liga', '', '32', '21');
INSERT INTO `competition` VALUES ('67', 'Hungria - NB I', '', '21', '14');
INSERT INTO `competition` VALUES ('70', 'Inglaterra - League One', '', '23', '15');
INSERT INTO `competition` VALUES ('82', 'República Checa - Czech Liga', '', '34', '22');
INSERT INTO `competition` VALUES ('87', 'Argentina - Prim B Nacional', '', '3', '2');
INSERT INTO `competition` VALUES ('88', 'Argentina - Primera División', '', '4', '2');
INSERT INTO `competition` VALUES ('89', 'Brasil - Série B', '', '6', '3');
INSERT INTO `competition` VALUES ('100', 'Portugal - Segunda Liga', '', '33', '21');
INSERT INTO `competition` VALUES ('107', 'Grécia - Football League', '', '17', '12');
INSERT INTO `competition` VALUES ('108', 'Grécia - Super League', '', '18', '12');
INSERT INTO `competition` VALUES ('109', 'Japão - J1 League', '', '28', '18');
INSERT INTO `competition` VALUES ('110', 'Japão - J2 League', '', '29', '18');
INSERT INTO `competition` VALUES ('119', 'Polónia - Ekstraklasa', '', '31', '20');
INSERT INTO `competition` VALUES ('121', 'Rússia - FNL', '', '35', '23');
INSERT INTO `competition` VALUES ('122', 'Rússia - Premier League', '', '36', '23');
INSERT INTO `competition` VALUES ('125', 'Ucrânia - Premier League', '', '40', '27');
INSERT INTO `competition` VALUES ('136', 'Coreia do Sul - Primeira Liga', '', '9', '6');
INSERT INTO `competition` VALUES ('155', 'México - Liga MX', '', '43', '30');

-- ----------------------------
-- Table structure for country
-- ----------------------------
DROP TABLE IF EXISTS `country`;
CREATE TABLE `country` (
  `COUN_CD_ID_PK` bigint(20) NOT NULL AUTO_INCREMENT,
  `COUN_DS_NAME` varchar(100) NOT NULL,
  PRIMARY KEY (`COUN_CD_ID_PK`),
  KEY `FLAG_CD_ID_FK` (`COUN_CD_ID_PK`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of country
-- ----------------------------
INSERT INTO `country` VALUES ('1', 'Alemanha');
INSERT INTO `country` VALUES ('2', 'Argentina');
INSERT INTO `country` VALUES ('3', 'Brasil');
INSERT INTO `country` VALUES ('4', 'Bélgica');
INSERT INTO `country` VALUES ('5', 'China');
INSERT INTO `country` VALUES ('6', 'Coreia do Sul');
INSERT INTO `country` VALUES ('7', 'Dinamarca');
INSERT INTO `country` VALUES ('8', 'Escócia');
INSERT INTO `country` VALUES ('9', 'Espanha');
INSERT INTO `country` VALUES ('10', 'Estados Unidos da América');
INSERT INTO `country` VALUES ('11', 'França');
INSERT INTO `country` VALUES ('12', 'Grécia');
INSERT INTO `country` VALUES ('13', 'Holanda');
INSERT INTO `country` VALUES ('14', 'Hungria');
INSERT INTO `country` VALUES ('15', 'Inglaterra');
INSERT INTO `country` VALUES ('16', 'Irlanda');
INSERT INTO `country` VALUES ('17', 'Itália');
INSERT INTO `country` VALUES ('18', 'Japão');
INSERT INTO `country` VALUES ('19', 'Noruega');
INSERT INTO `country` VALUES ('20', 'Polónia');
INSERT INTO `country` VALUES ('21', 'Portugal');
INSERT INTO `country` VALUES ('22', 'República Checa');
INSERT INTO `country` VALUES ('23', 'Rússia');
INSERT INTO `country` VALUES ('24', 'Suécia');
INSERT INTO `country` VALUES ('25', 'Suíça');
INSERT INTO `country` VALUES ('26', 'Turquia');
INSERT INTO `country` VALUES ('27', 'Ucrânia');
INSERT INTO `country` VALUES ('28', 'Bulgária');
INSERT INTO `country` VALUES ('29', 'Croácia');
INSERT INTO `country` VALUES ('30', 'México');

-- ----------------------------
-- Table structure for flag
-- ----------------------------
DROP TABLE IF EXISTS `flag`;
CREATE TABLE `flag` (
  `FLAG_CD_ID_PK` bigint(20) NOT NULL AUTO_INCREMENT,
  `FLAG_DS_NAME` varchar(255) DEFAULT NULL,
  `FLAG_DS_URL` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`FLAG_CD_ID_PK`)
) ENGINE=InnoDB AUTO_INCREMENT=223 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of flag
-- ----------------------------
INSERT INTO `flag` VALUES ('1', 'Alemanha - 2. Bundesliga.gif', '/resources/images/flags/174.gif');
INSERT INTO `flag` VALUES ('2', 'Alemanha - Bundesliga.gif', '/resources/images/flags/175.gif');
INSERT INTO `flag` VALUES ('3', 'Argentina - Primeira B Nacional.gif', '/resources/images/flags/176.gif');
INSERT INTO `flag` VALUES ('4', 'Argentina - Primeira Divisão.gif', '/resources/images/flags/177.gif');
INSERT INTO `flag` VALUES ('5', 'Brasil - Série A.gif', '/resources/images/flags/178.gif');
INSERT INTO `flag` VALUES ('6', 'Brasil - Série B.gif', '/resources/images/flags/179.gif');
INSERT INTO `flag` VALUES ('7', 'Bélgica - Primeira Liga.gif', '/resources/images/flags/180.gif');
INSERT INTO `flag` VALUES ('8', 'China - CSL Super Liga.gif', '/resources/images/flags/181.gif');
INSERT INTO `flag` VALUES ('9', 'Coreia do Sul - Primeira Liga.gif', '/resources/images/flags/183.gif');
INSERT INTO `flag` VALUES ('10', 'Dinamarca - Super Liga.gif', '/resources/images/flags/184.gif');
INSERT INTO `flag` VALUES ('11', 'Escócia - Primeira Liga.gif', '/resources/images/flags/185.gif');
INSERT INTO `flag` VALUES ('12', 'Espanha - Primeira Divisão.gif', '/resources/images/flags/186.gif');
INSERT INTO `flag` VALUES ('13', 'Espanha - Segunda Divisão.gif', '/resources/images/flags/187.gif');
INSERT INTO `flag` VALUES ('14', 'Estados Unidos da América - MLS.gif', '/resources/images/flags/188.gif');
INSERT INTO `flag` VALUES ('15', 'França - Ligue 1.gif', '/resources/images/flags/189.gif');
INSERT INTO `flag` VALUES ('16', 'França - Ligue 2.gif', '/resources/images/flags/190.gif');
INSERT INTO `flag` VALUES ('17', 'Grécia - Segunda Liga.gif', '/resources/images/flags/191.gif');
INSERT INTO `flag` VALUES ('18', 'Grécia - Super Liga.gif', '/resources/images/flags/192.gif');
INSERT INTO `flag` VALUES ('19', 'Holanda - Eredivisie.gif', '/resources/images/flags/193.gif');
INSERT INTO `flag` VALUES ('20', 'Holanda - Segunda Liga.gif', '/resources/images/flags/194.gif');
INSERT INTO `flag` VALUES ('21', 'Hungria - NB I Primeira Liga.gif', '/resources/images/flags/195.gif');
INSERT INTO `flag` VALUES ('22', 'Inglaterra - 2. Championship.gif', '/resources/images/flags/196.gif');
INSERT INTO `flag` VALUES ('23', 'Inglaterra - 3. League One.gif', '/resources/images/flags/197.gif');
INSERT INTO `flag` VALUES ('24', 'Inglaterra - Premier League.gif', '/resources/images/flags/198.gif');
INSERT INTO `flag` VALUES ('25', 'Irlanda - Primeira Divisão.gif', '/resources/images/flags/199.gif');
INSERT INTO `flag` VALUES ('26', 'Itália - Série A.gif', '/resources/images/flags/200.gif');
INSERT INTO `flag` VALUES ('27', 'Itália - Série B.gif', '/resources/images/flags/201.gif');
INSERT INTO `flag` VALUES ('28', 'Japão - J1 Primeira Liga.gif', '/resources/images/flags/202.gif');
INSERT INTO `flag` VALUES ('29', 'Japão - J2 Segunda Liga.gif', '/resources/images/flags/203.gif');
INSERT INTO `flag` VALUES ('30', 'Noruega - Primeira Liga.gif', '/resources/images/flags/204.gif');
INSERT INTO `flag` VALUES ('31', 'Polónia - Primeira Liga.gif', '/resources/images/flags/205.gif');
INSERT INTO `flag` VALUES ('32', 'Portugal - Primeira Liga.gif', '/resources/images/flags/206.gif');
INSERT INTO `flag` VALUES ('33', 'Portugal - Segunda Liga.gif', '/resources/images/flags/207.gif');
INSERT INTO `flag` VALUES ('34', 'República Checa - Primeira Liga.gif', '/resources/images/flags/208.gif');
INSERT INTO `flag` VALUES ('35', 'Rússia - FNL Segunda Liga.gif', '/resources/images/flags/210.gif');
INSERT INTO `flag` VALUES ('36', 'Rússia - Primeira Liga.gif', '/resources/images/flags/211.gif');
INSERT INTO `flag` VALUES ('37', 'Suécia - Primeira Liga.gif', '/resources/images/flags/212.gif');
INSERT INTO `flag` VALUES ('38', 'Suíça - Super Liga.gif', '/resources/images/flags/213.gif');
INSERT INTO `flag` VALUES ('39', 'Turquia - Super Liga.gif', '/resources/images/flags/214.gif');
INSERT INTO `flag` VALUES ('40', 'Ucrânia - Primeira Liga.gif', '/resources/images/flags/215.gif');
INSERT INTO `flag` VALUES ('41', 'Bulgária - A PFG Primeira Liga.gif', '/resources/images/flags/218.gif');
INSERT INTO `flag` VALUES ('42', 'Croácia - 1. HNL Primeira Liga.gif', '/resources/images/flags/220.gif');
INSERT INTO `flag` VALUES ('43', 'México - Primeira Liga.gif', '/resources/images/flags/129.gif');

-- ----------------------------
-- Table structure for goal_type
-- ----------------------------
DROP TABLE IF EXISTS `goal_type`;
CREATE TABLE `goal_type` (
  `goty_cd_id_pk` bigint(20) NOT NULL AUTO_INCREMENT,
  `goty_ds_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`goty_cd_id_pk`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of goal_type
-- ----------------------------
INSERT INTO `goal_type` VALUES ('1', 'SCORED');
INSERT INTO `goal_type` VALUES ('2', 'CONCEDED');

-- ----------------------------
-- Table structure for market_bet
-- ----------------------------
DROP TABLE IF EXISTS `market_bet`;
CREATE TABLE `market_bet` (
  `MABE_CD_ID_PK` bigint(20) NOT NULL AUTO_INCREMENT,
  `MABE_DS_NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`MABE_CD_ID_PK`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of market_bet
-- ----------------------------
INSERT INTO `market_bet` VALUES ('1', 'Fulltime Result');
INSERT INTO `market_bet` VALUES ('2', 'Gols');
INSERT INTO `market_bet` VALUES ('3', 'Double Chance');

-- ----------------------------
-- Table structure for selection_market_bet
-- ----------------------------
DROP TABLE IF EXISTS `selection_market_bet`;
CREATE TABLE `selection_market_bet` (
  `SEMB_CD_ID_PK` bigint(20) NOT NULL AUTO_INCREMENT,
  `SEMB_DS_NAME` varchar(255) DEFAULT NULL,
  `MABE_CD_ID_FK` bigint(20) NOT NULL,
  PRIMARY KEY (`SEMB_CD_ID_PK`),
  KEY `FKhia181560p6uelanglivwg4w8` (`MABE_CD_ID_FK`),
  CONSTRAINT `FKhia181560p6uelanglivwg4w8` FOREIGN KEY (`MABE_CD_ID_FK`) REFERENCES `market_bet` (`MABE_CD_ID_PK`),
  CONSTRAINT `MABE_CD_ID_FK_SEMB` FOREIGN KEY (`MABE_CD_ID_FK`) REFERENCES `market_bet` (`MABE_CD_ID_PK`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of selection_market_bet
-- ----------------------------
INSERT INTO `selection_market_bet` VALUES ('1', 'Home Team', '1');
INSERT INTO `selection_market_bet` VALUES ('2', 'Draw', '1');
INSERT INTO `selection_market_bet` VALUES ('3', 'Away Team', '1');
INSERT INTO `selection_market_bet` VALUES ('5', 'Over 0.5', '3');
INSERT INTO `selection_market_bet` VALUES ('6', 'Under 0.5', '3');
INSERT INTO `selection_market_bet` VALUES ('7', 'Over 1.5', '3');
INSERT INTO `selection_market_bet` VALUES ('8', 'Under 1.5', '3');
INSERT INTO `selection_market_bet` VALUES ('9', 'Over 2.5', '3');
INSERT INTO `selection_market_bet` VALUES ('10', 'Under 2.5', '3');
INSERT INTO `selection_market_bet` VALUES ('11', 'Over 3.5', '3');
INSERT INTO `selection_market_bet` VALUES ('12', 'Under 3.5', '3');
INSERT INTO `selection_market_bet` VALUES ('13', 'Over 4.5', '3');
INSERT INTO `selection_market_bet` VALUES ('14', 'Under 4.5', '3');
INSERT INTO `selection_market_bet` VALUES ('15', 'Over 5.5', '3');
INSERT INTO `selection_market_bet` VALUES ('16', 'Under 5.5', '3');
INSERT INTO `selection_market_bet` VALUES ('17', 'Over 6.5', '3');
INSERT INTO `selection_market_bet` VALUES ('18', 'Under 6.5', '3');
INSERT INTO `selection_market_bet` VALUES ('19', 'Over 7.5', '3');
INSERT INTO `selection_market_bet` VALUES ('20', 'Under 7.5', '3');
INSERT INTO `selection_market_bet` VALUES ('21', 'Home Team or Draw', '2');
INSERT INTO `selection_market_bet` VALUES ('22', 'Home Team or Away Team', '2');
INSERT INTO `selection_market_bet` VALUES ('23', 'Away Team or Draw', '2');

-- ----------------------------
-- Table structure for team
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team` (
  `TEAM_CD_ID_PK` bigint(20) NOT NULL,
  `TEAM_DS_NAME` varchar(255) DEFAULT NULL,
  `COUN_CD_ID_FK` bigint(20) NOT NULL,
  PRIMARY KEY (`TEAM_CD_ID_PK`),
  KEY `FK1qeh9cs0d2jx3h5w5i39m636y` (`COUN_CD_ID_FK`),
  CONSTRAINT `COUN_CD_ID_FK_TEAM` FOREIGN KEY (`COUN_CD_ID_FK`) REFERENCES `country` (`COUN_CD_ID_PK`),
  CONSTRAINT `FK1qeh9cs0d2jx3h5w5i39m636y` FOREIGN KEY (`COUN_CD_ID_FK`) REFERENCES `country` (`COUN_CD_ID_PK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of team
-- ----------------------------
INSERT INTO `team` VALUES ('92', 'Arsenal', '2');
INSERT INTO `team` VALUES ('93', 'Rafaela', '2');
INSERT INTO `team` VALUES ('94', 'Banfield', '2');
INSERT INTO `team` VALUES ('95', 'Boca', '2');
INSERT INTO `team` VALUES ('96', 'Chacarita', '2');
INSERT INTO `team` VALUES ('97', 'Colón', '2');
INSERT INTO `team` VALUES ('98', 'Estudiantes', '2');
INSERT INTO `team` VALUES ('99', 'Gimn La Plata', '2');
INSERT INTO `team` VALUES ('100', 'Independiente', '2');
INSERT INTO `team` VALUES ('101', 'Lanús', '2');
INSERT INTO `team` VALUES ('102', 'NOB', '2');
INSERT INTO `team` VALUES ('103', 'Nueva Chicago', '2');
INSERT INTO `team` VALUES ('104', 'Olimpo', '2');
INSERT INTO `team` VALUES ('105', 'Quilmes', '2');
INSERT INTO `team` VALUES ('106', 'Racing', '2');
INSERT INTO `team` VALUES ('107', 'River Plate', '2');
INSERT INTO `team` VALUES ('108', 'Rosario', '2');
INSERT INTO `team` VALUES ('109', 'San Lorenzo', '2');
INSERT INTO `team` VALUES ('110', 'Talleres', '2');
INSERT INTO `team` VALUES ('111', 'Vélez', '2');
INSERT INTO `team` VALUES ('112', 'Almagro', '2');
INSERT INTO `team` VALUES ('113', 'Arg Juniors', '2');
INSERT INTO `team` VALUES ('114', 'Belgrano', '2');
INSERT INTO `team` VALUES ('117', 'Def y Justicia', '2');
INSERT INTO `team` VALUES ('119', 'Ferro', '2');
INSERT INTO `team` VALUES ('121', 'Gimnasia', '2');
INSERT INTO `team` VALUES ('122', 'Godoy Cruz', '2');
INSERT INTO `team` VALUES ('123', 'Huracán', '2');
INSERT INTO `team` VALUES ('127', 'Los Andes', '2');
INSERT INTO `team` VALUES ('129', 'San Martín SJ', '2');
INSERT INTO `team` VALUES ('131', 'Santa Fe', '2');
INSERT INTO `team` VALUES ('214', 'Gent', '4');
INSERT INTO `team` VALUES ('215', 'Anderlecht', '4');
INSERT INTO `team` VALUES ('218', 'Charleroi', '4');
INSERT INTO `team` VALUES ('219', 'Club Brugge', '4');
INSERT INTO `team` VALUES ('227', 'Oostende', '4');
INSERT INTO `team` VALUES ('236', 'ZW', '4');
INSERT INTO `team` VALUES ('301', 'Ponte Preta', '3');
INSERT INTO `team` VALUES ('302', 'São Paulo', '3');
INSERT INTO `team` VALUES ('303', 'Figueirense', '3');
INSERT INTO `team` VALUES ('304', 'Cruzeiro', '3');
INSERT INTO `team` VALUES ('305', 'Criciúma', '3');
INSERT INTO `team` VALUES ('306', 'Vitória', '3');
INSERT INTO `team` VALUES ('307', 'Goiás', '3');
INSERT INTO `team` VALUES ('308', 'Internacional', '3');
INSERT INTO `team` VALUES ('309', 'Paraná', '3');
INSERT INTO `team` VALUES ('310', 'Palmeiras', '3');
INSERT INTO `team` VALUES ('312', 'Fluminense', '3');
INSERT INTO `team` VALUES ('313', 'Grêmio', '3');
INSERT INTO `team` VALUES ('314', 'Juventude', '3');
INSERT INTO `team` VALUES ('315', 'Atlético-PR', '3');
INSERT INTO `team` VALUES ('316', 'Guarani', '3');
INSERT INTO `team` VALUES ('317', 'Atlético MG', '3');
INSERT INTO `team` VALUES ('318', 'Flamengo', '3');
INSERT INTO `team` VALUES ('319', 'Santos', '3');
INSERT INTO `team` VALUES ('320', 'Corinthians', '3');
INSERT INTO `team` VALUES ('321', 'Vasco', '3');
INSERT INTO `team` VALUES ('322', 'Paysandu', '3');
INSERT INTO `team` VALUES ('323', 'Botafogo', '3');
INSERT INTO `team` VALUES ('324', 'Coritiba', '3');
INSERT INTO `team` VALUES ('325', 'Santa Cruz', '3');
INSERT INTO `team` VALUES ('326', 'Náutico', '3');
INSERT INTO `team` VALUES ('329', 'Vila Nova', '3');
INSERT INTO `team` VALUES ('330', 'Avaí', '3');
INSERT INTO `team` VALUES ('333', 'Ceará', '3');
INSERT INTO `team` VALUES ('337', 'América MG', '3');
INSERT INTO `team` VALUES ('338', 'Sport', '3');
INSERT INTO `team` VALUES ('341', 'Bahia', '3');
INSERT INTO `team` VALUES ('344', 'CRB', '3');
INSERT INTO `team` VALUES ('346', 'Londrina', '3');
INSERT INTO `team` VALUES ('352', 'Lok Plovdiv', '28');
INSERT INTO `team` VALUES ('353', 'Levski', '28');
INSERT INTO `team` VALUES ('354', 'CSKA Sofia', '28');
INSERT INTO `team` VALUES ('356', 'Slavia Sofia', '28');
INSERT INTO `team` VALUES ('360', 'Cherno More', '28');
INSERT INTO `team` VALUES ('368', 'Beroe', '28');
INSERT INTO `team` VALUES ('369', 'Pirin', '28');
INSERT INTO `team` VALUES ('425', 'Guangzhou R&F', '5');
INSERT INTO `team` VALUES ('429', 'Guoan', '5');
INSERT INTO `team` VALUES ('431', 'Tianjin', '5');
INSERT INTO `team` VALUES ('432', 'Lifan', '5');
INSERT INTO `team` VALUES ('433', 'Shenhua', '5');
INSERT INTO `team` VALUES ('434', 'Shandong', '5');
INSERT INTO `team` VALUES ('437', 'Changchun', '5');
INSERT INTO `team` VALUES ('441', 'Jiangsu', '5');
INSERT INTO `team` VALUES ('442', 'Henan Jianye', '5');
INSERT INTO `team` VALUES ('478', 'Hajduk Split', '29');
INSERT INTO `team` VALUES ('479', 'Dinamo Zagreb', '29');
INSERT INTO `team` VALUES ('480', 'Rijeka', '29');
INSERT INTO `team` VALUES ('481', 'Osijek', '29');
INSERT INTO `team` VALUES ('485', 'Int Zapresic', '29');
INSERT INTO `team` VALUES ('486', 'Slaven', '29');
INSERT INTO `team` VALUES ('487', 'Cibalia', '29');
INSERT INTO `team` VALUES ('532', 'Sparta Praga', '22');
INSERT INTO `team` VALUES ('533', 'Slavia Praga', '22');
INSERT INTO `team` VALUES ('536', 'Zlín', '22');
INSERT INTO `team` VALUES ('537', 'Slov Liberec', '22');
INSERT INTO `team` VALUES ('539', 'Teplice', '22');
INSERT INTO `team` VALUES ('540', 'Jablonec', '22');
INSERT INTO `team` VALUES ('541', 'Příbram', '22');
INSERT INTO `team` VALUES ('543', 'FCZ Brno', '22');
INSERT INTO `team` VALUES ('546', 'Viktoria Plzeň', '22');
INSERT INTO `team` VALUES ('548', 'Mladá Boleslav', '22');
INSERT INTO `team` VALUES ('550', 'Bohemians \'05', '22');
INSERT INTO `team` VALUES ('552', 'Vysočina', '22');
INSERT INTO `team` VALUES ('556', 'Králové', '22');
INSERT INTO `team` VALUES ('599', 'Esbjerg', '7');
INSERT INTO `team` VALUES ('600', 'Copenhaga', '7');
INSERT INTO `team` VALUES ('601', 'Brondby', '7');
INSERT INTO `team` VALUES ('602', 'AaB', '7');
INSERT INTO `team` VALUES ('603', 'Midtjylland', '7');
INSERT INTO `team` VALUES ('604', 'Viborg', '7');
INSERT INTO `team` VALUES ('605', 'Aarhus', '7');
INSERT INTO `team` VALUES ('606', 'Nordsjælland', '7');
INSERT INTO `team` VALUES ('608', 'Odense', '7');
INSERT INTO `team` VALUES ('609', 'Silkeborg', '7');
INSERT INTO `team` VALUES ('610', 'Randers', '7');
INSERT INTO `team` VALUES ('613', 'Horsens', '7');
INSERT INTO `team` VALUES ('635', 'Lyngby', '7');
INSERT INTO `team` VALUES ('660', 'Arsenal', '15');
INSERT INTO `team` VALUES ('661', 'Chelsea', '15');
INSERT INTO `team` VALUES ('662', 'Man Utd', '15');
INSERT INTO `team` VALUES ('663', 'Liverpool', '15');
INSERT INTO `team` VALUES ('664', 'Newcastle', '15');
INSERT INTO `team` VALUES ('665', 'Aston Villa', '15');
INSERT INTO `team` VALUES ('666', 'Bolton', '15');
INSERT INTO `team` VALUES ('667', 'Fulham', '15');
INSERT INTO `team` VALUES ('668', 'Charlton', '15');
INSERT INTO `team` VALUES ('669', 'Birmingham', '15');
INSERT INTO `team` VALUES ('670', 'Southampton', '15');
INSERT INTO `team` VALUES ('671', 'Middlesbrough', '15');
INSERT INTO `team` VALUES ('672', 'Blackburn', '15');
INSERT INTO `team` VALUES ('674', 'Everton', '15');
INSERT INTO `team` VALUES ('675', 'Tottenham', '15');
INSERT INTO `team` VALUES ('676', 'Man City', '15');
INSERT INTO `team` VALUES ('677', 'Norwich', '15');
INSERT INTO `team` VALUES ('678', 'West Bromwich', '15');
INSERT INTO `team` VALUES ('679', 'Crystal Palace', '15');
INSERT INTO `team` VALUES ('680', 'Wolverhampton', '15');
INSERT INTO `team` VALUES ('681', 'Leeds', '15');
INSERT INTO `team` VALUES ('682', 'Leicester', '15');
INSERT INTO `team` VALUES ('683', 'Sunderland', '15');
INSERT INTO `team` VALUES ('684', 'West Ham', '15');
INSERT INTO `team` VALUES ('685', 'Ipswich', '15');
INSERT INTO `team` VALUES ('686', 'Wigan', '15');
INSERT INTO `team` VALUES ('687', 'Sheff Utd', '15');
INSERT INTO `team` VALUES ('688', 'Reading', '15');
INSERT INTO `team` VALUES ('689', 'Millwall', '15');
INSERT INTO `team` VALUES ('690', 'Stoke', '15');
INSERT INTO `team` VALUES ('691', 'Cardiff', '15');
INSERT INTO `team` VALUES ('692', 'Coventry', '15');
INSERT INTO `team` VALUES ('693', 'Preston', '15');
INSERT INTO `team` VALUES ('694', 'Nottm Forest', '15');
INSERT INTO `team` VALUES ('695', 'Rotherham', '15');
INSERT INTO `team` VALUES ('696', 'Watford', '15');
INSERT INTO `team` VALUES ('698', 'Burnley', '15');
INSERT INTO `team` VALUES ('699', 'Derby', '15');
INSERT INTO `team` VALUES ('700', 'Gillingham', '15');
INSERT INTO `team` VALUES ('702', 'QPR', '15');
INSERT INTO `team` VALUES ('703', 'Brighton', '15');
INSERT INTO `team` VALUES ('704', 'Walsall', '15');
INSERT INTO `team` VALUES ('705', 'Bradford', '15');
INSERT INTO `team` VALUES ('706', 'MK Dons', '15');
INSERT INTO `team` VALUES ('707', 'Bristol City', '15');
INSERT INTO `team` VALUES ('708', 'Swindon', '15');
INSERT INTO `team` VALUES ('710', 'Port Vale', '15');
INSERT INTO `team` VALUES ('711', 'Bournemouth', '15');
INSERT INTO `team` VALUES ('716', 'Barnsley', '15');
INSERT INTO `team` VALUES ('718', 'Oldham', '15');
INSERT INTO `team` VALUES ('719', 'Sheff Wed', '15');
INSERT INTO `team` VALUES ('721', 'Peterborough', '15');
INSERT INTO `team` VALUES ('722', 'Brentford', '15');
INSERT INTO `team` VALUES ('723', 'Chesterfield', '15');
INSERT INTO `team` VALUES ('725', 'Hull', '15');
INSERT INTO `team` VALUES ('726', 'Huddersfield', '15');
INSERT INTO `team` VALUES ('734', 'Northampton', '15');
INSERT INTO `team` VALUES ('736', 'Oxford', '15');
INSERT INTO `team` VALUES ('738', 'Swansea', '15');
INSERT INTO `team` VALUES ('739', 'Bristol Rovers', '15');
INSERT INTO `team` VALUES ('741', 'Southend', '15');
INSERT INTO `team` VALUES ('742', 'Bury', '15');
INSERT INTO `team` VALUES ('747', 'Rochdale', '15');
INSERT INTO `team` VALUES ('749', 'Scunthorpe', '15');
INSERT INTO `team` VALUES ('751', 'Shrewsbury', '15');
INSERT INTO `team` VALUES ('764', 'Burton Albion', '15');
INSERT INTO `team` VALUES ('884', 'Lyon', '11');
INSERT INTO `team` VALUES ('885', 'Mónaco', '11');
INSERT INTO `team` VALUES ('886', 'PSG', '11');
INSERT INTO `team` VALUES ('887', 'Sochaux', '11');
INSERT INTO `team` VALUES ('888', 'Auxerre', '11');
INSERT INTO `team` VALUES ('889', 'Nantes', '11');
INSERT INTO `team` VALUES ('890', 'Marselha', '11');
INSERT INTO `team` VALUES ('891', 'Bordeaux', '11');
INSERT INTO `team` VALUES ('892', 'Lens', '11');
INSERT INTO `team` VALUES ('893', 'Rennes', '11');
INSERT INTO `team` VALUES ('894', 'Nice', '11');
INSERT INTO `team` VALUES ('895', 'Lille', '11');
INSERT INTO `team` VALUES ('896', 'Metz', '11');
INSERT INTO `team` VALUES ('897', 'Bastia', '11');
INSERT INTO `team` VALUES ('898', 'Strasbourg', '11');
INSERT INTO `team` VALUES ('899', 'Toulouse', '11');
INSERT INTO `team` VALUES ('900', 'Ajaccio', '11');
INSERT INTO `team` VALUES ('901', 'Saint-Étienne', '11');
INSERT INTO `team` VALUES ('902', 'Caen', '11');
INSERT INTO `team` VALUES ('904', 'Guingamp', '11');
INSERT INTO `team` VALUES ('906', 'Montpellier', '11');
INSERT INTO `team` VALUES ('907', 'Lorient', '11');
INSERT INTO `team` VALUES ('908', 'Amiens', '11');
INSERT INTO `team` VALUES ('909', 'Niort', '11');
INSERT INTO `team` VALUES ('911', 'Nancy', '11');
INSERT INTO `team` VALUES ('912', 'Le Havre', '11');
INSERT INTO `team` VALUES ('914', 'Troyes', '11');
INSERT INTO `team` VALUES ('916', 'Clermont Foot', '11');
INSERT INTO `team` VALUES ('918', 'Angers', '11');
INSERT INTO `team` VALUES ('920', 'Stade Lavall', '11');
INSERT INTO `team` VALUES ('921', 'Stade Reims', '11');
INSERT INTO `team` VALUES ('922', 'Stade Brest', '11');
INSERT INTO `team` VALUES ('923', 'Dijon', '11');
INSERT INTO `team` VALUES ('931', 'GFC Ajaccio', '11');
INSERT INTO `team` VALUES ('932', 'Nîmes', '11');
INSERT INTO `team` VALUES ('933', 'Valenciennes', '11');
INSERT INTO `team` VALUES ('935', 'Tours', '11');
INSERT INTO `team` VALUES ('943', 'Bourg', '11');
INSERT INTO `team` VALUES ('960', 'Bremen', '1');
INSERT INTO `team` VALUES ('961', 'Bayern Munique', '1');
INSERT INTO `team` VALUES ('962', 'Stuttgart', '1');
INSERT INTO `team` VALUES ('963', 'Leverkusen', '1');
INSERT INTO `team` VALUES ('964', 'Dortmund', '1');
INSERT INTO `team` VALUES ('965', 'Bochum', '1');
INSERT INTO `team` VALUES ('966', 'Schalke 04', '1');
INSERT INTO `team` VALUES ('967', 'Hamburgo', '1');
INSERT INTO `team` VALUES ('968', 'Wolfsburg', '1');
INSERT INTO `team` VALUES ('970', 'Freiburg', '1');
INSERT INTO `team` VALUES ('971', 'M\'gladbach', '1');
INSERT INTO `team` VALUES ('972', 'Hannover', '1');
INSERT INTO `team` VALUES ('973', 'Kaiserslautern', '1');
INSERT INTO `team` VALUES ('974', 'Hertha', '1');
INSERT INTO `team` VALUES ('975', 'Nuremberga', '1');
INSERT INTO `team` VALUES ('976', 'Bielefeld', '1');
INSERT INTO `team` VALUES ('977', 'Mainz 05', '1');
INSERT INTO `team` VALUES ('978', '1860 Munique', '1');
INSERT INTO `team` VALUES ('979', 'Frankfurt', '1');
INSERT INTO `team` VALUES ('980', 'Colonia', '1');
INSERT INTO `team` VALUES ('985', 'Aue', '1');
INSERT INTO `team` VALUES ('986', 'Greuther Fürth', '1');
INSERT INTO `team` VALUES ('989', 'Karlsruhe', '1');
INSERT INTO `team` VALUES ('995', 'Dresden', '1');
INSERT INTO `team` VALUES ('1000', 'Augsburg', '1');
INSERT INTO `team` VALUES ('1001', 'Hoffenheim', '1');
INSERT INTO `team` VALUES ('1015', 'Braunschweig', '1');
INSERT INTO `team` VALUES ('1018', 'St. Pauli', '1');
INSERT INTO `team` VALUES ('1026', 'Union Berlin', '1');
INSERT INTO `team` VALUES ('1029', 'Düsseldorf', '1');
INSERT INTO `team` VALUES ('1039', 'Panathinaikos', '12');
INSERT INTO `team` VALUES ('1040', 'Olympiakos', '12');
INSERT INTO `team` VALUES ('1041', 'PAOK', '12');
INSERT INTO `team` VALUES ('1042', 'AEK Atenas', '12');
INSERT INTO `team` VALUES ('1044', 'Panionios', '12');
INSERT INTO `team` VALUES ('1046', 'Iraklis', '12');
INSERT INTO `team` VALUES ('1047', 'Xanthi', '12');
INSERT INTO `team` VALUES ('1048', 'OFI Creta', '12');
INSERT INTO `team` VALUES ('1050', 'Kallithea', '12');
INSERT INTO `team` VALUES ('1051', 'Aris Salónica', '12');
INSERT INTO `team` VALUES ('1055', 'Kerkyra', '12');
INSERT INTO `team` VALUES ('1062', 'Levadiakos', '12');
INSERT INTO `team` VALUES ('1063', 'Apollon', '12');
INSERT INTO `team` VALUES ('1065', 'Panserraikos', '12');
INSERT INTO `team` VALUES ('1067', 'Atromitos', '12');
INSERT INTO `team` VALUES ('1068', 'Giannina', '12');
INSERT INTO `team` VALUES ('1071', 'Larissa', '12');
INSERT INTO `team` VALUES ('1081', 'Veria', '12');
INSERT INTO `team` VALUES ('1084', 'Agrotikos', '12');
INSERT INTO `team` VALUES ('1101', 'Ferencvaros', '14');
INSERT INTO `team` VALUES ('1103', 'Debrecen', '14');
INSERT INTO `team` VALUES ('1104', 'MTK Budapeste', '14');
INSERT INTO `team` VALUES ('1105', 'Újpest', '14');
INSERT INTO `team` VALUES ('1112', 'Szombathelyi', '14');
INSERT INTO `team` VALUES ('1113', 'Honved', '14');
INSERT INTO `team` VALUES ('1115', 'Vasas', '14');
INSERT INTO `team` VALUES ('1116', 'DVTK', '14');
INSERT INTO `team` VALUES ('1182', 'Drogheda', '16');
INSERT INTO `team` VALUES ('1184', 'Shamrock', '16');
INSERT INTO `team` VALUES ('1185', 'Cork', '16');
INSERT INTO `team` VALUES ('1186', 'Bohemians', '16');
INSERT INTO `team` VALUES ('1187', 'Derry', '16');
INSERT INTO `team` VALUES ('1188', 'St Patrick\'s', '16');
INSERT INTO `team` VALUES ('1192', 'Bray', '16');
INSERT INTO `team` VALUES ('1193', 'Sligo', '16');
INSERT INTO `team` VALUES ('1194', 'Finn Harps', '16');
INSERT INTO `team` VALUES ('1196', 'Dundalk', '16');
INSERT INTO `team` VALUES ('1240', 'Milan', '17');
INSERT INTO `team` VALUES ('1241', 'Roma', '17');
INSERT INTO `team` VALUES ('1242', 'Juventus', '17');
INSERT INTO `team` VALUES ('1244', 'Inter', '17');
INSERT INTO `team` VALUES ('1245', 'Lazio', '17');
INSERT INTO `team` VALUES ('1246', 'Udinese', '17');
INSERT INTO `team` VALUES ('1247', 'Sampdoria', '17');
INSERT INTO `team` VALUES ('1248', 'Chievo', '17');
INSERT INTO `team` VALUES ('1249', 'Bologna', '17');
INSERT INTO `team` VALUES ('1250', 'Brescia', '17');
INSERT INTO `team` VALUES ('1254', 'Palermo', '17');
INSERT INTO `team` VALUES ('1255', 'Atalanta', '17');
INSERT INTO `team` VALUES ('1256', 'Cagliari', '17');
INSERT INTO `team` VALUES ('1259', 'Fiorentina', '17');
INSERT INTO `team` VALUES ('1261', 'Empoli', '17');
INSERT INTO `team` VALUES ('1262', 'Perugia', '17');
INSERT INTO `team` VALUES ('1265', 'Ternana', '17');
INSERT INTO `team` VALUES ('1268', 'Torino', '17');
INSERT INTO `team` VALUES ('1269', 'Vicenza', '17');
INSERT INTO `team` VALUES ('1270', 'Nápoles', '17');
INSERT INTO `team` VALUES ('1271', 'Ascoli', '17');
INSERT INTO `team` VALUES ('1275', 'Salernitana', '17');
INSERT INTO `team` VALUES ('1276', 'Génova', '17');
INSERT INTO `team` VALUES ('1277', 'Verona', '17');
INSERT INTO `team` VALUES ('1279', 'Cesena', '17');
INSERT INTO `team` VALUES ('1280', 'Crotone', '17');
INSERT INTO `team` VALUES ('1282', 'Pescara', '17');
INSERT INTO `team` VALUES ('1287', 'SPAL', '17');
INSERT INTO `team` VALUES ('1288', 'Spezia', '17');
INSERT INTO `team` VALUES ('1290', 'Pisa', '17');
INSERT INTO `team` VALUES ('1291', 'Cittadella', '17');
INSERT INTO `team` VALUES ('1293', 'Novara', '17');
INSERT INTO `team` VALUES ('1300', 'Avellino', '17');
INSERT INTO `team` VALUES ('1301', 'Bari 1908', '17');
INSERT INTO `team` VALUES ('1302', 'Benevento', '17');
INSERT INTO `team` VALUES ('1320', 'Júbilo', '18');
INSERT INTO `team` VALUES ('1321', 'JEF Utd', '18');
INSERT INTO `team` VALUES ('1322', 'F Marinos', '18');
INSERT INTO `team` VALUES ('1323', 'Urawa', '18');
INSERT INTO `team` VALUES ('1324', 'Kashima', '18');
INSERT INTO `team` VALUES ('1325', 'Nagoya', '18');
INSERT INTO `team` VALUES ('1326', 'Oita', '18');
INSERT INTO `team` VALUES ('1327', 'Gamba', '18');
INSERT INTO `team` VALUES ('1328', 'Vissel Kobe', '18');
INSERT INTO `team` VALUES ('1329', 'Shimizu', '18');
INSERT INTO `team` VALUES ('1330', 'Tokyo', '18');
INSERT INTO `team` VALUES ('1331', 'Kashiwa', '18');
INSERT INTO `team` VALUES ('1332', 'Tokyo Verdy', '18');
INSERT INTO `team` VALUES ('1333', 'Albirex', '18');
INSERT INTO `team` VALUES ('1334', 'Sanfrecce', '18');
INSERT INTO `team` VALUES ('1335', 'Cerezo', '18');
INSERT INTO `team` VALUES ('1336', 'Kawasaki', '18');
INSERT INTO `team` VALUES ('1337', 'Montedio', '18');
INSERT INTO `team` VALUES ('1338', 'Avispa', '18');
INSERT INTO `team` VALUES ('1339', 'Omiya', '18');
INSERT INTO `team` VALUES ('1340', 'Kyoto', '18');
INSERT INTO `team` VALUES ('1341', 'Yokohama', '18');
INSERT INTO `team` VALUES ('1342', 'Ventforet', '18');
INSERT INTO `team` VALUES ('1343', 'Sagan', '18');
INSERT INTO `team` VALUES ('1344', 'Vegalta', '18');
INSERT INTO `team` VALUES ('1345', 'Mito', '18');
INSERT INTO `team` VALUES ('1346', 'Shonan', '18');
INSERT INTO `team` VALUES ('1347', 'Consadole', '18');
INSERT INTO `team` VALUES ('1372', 'Pohang', '6');
INSERT INTO `team` VALUES ('1373', 'Daegu', '6');
INSERT INTO `team` VALUES ('1374', 'Ulsan', '6');
INSERT INTO `team` VALUES ('1376', 'Dragons', '6');
INSERT INTO `team` VALUES ('1377', 'Jeonbuk Motors', '6');
INSERT INTO `team` VALUES ('1378', 'Sangju', '6');
INSERT INTO `team` VALUES ('1380', 'Incheon Utd', '6');
INSERT INTO `team` VALUES ('1381', 'Seoul', '6');
INSERT INTO `team` VALUES ('1382', 'Suwon BWings', '6');
INSERT INTO `team` VALUES ('1458', 'América', '30');
INSERT INTO `team` VALUES ('1460', 'Atlas', '30');
INSERT INTO `team` VALUES ('1461', 'Cruz Azul', '30');
INSERT INTO `team` VALUES ('1462', 'Guadalajara', '30');
INSERT INTO `team` VALUES ('1463', 'Jaguares', '30');
INSERT INTO `team` VALUES ('1464', 'Morelia', '30');
INSERT INTO `team` VALUES ('1465', 'Necaxa', '30');
INSERT INTO `team` VALUES ('1466', 'Pachuca', '30');
INSERT INTO `team` VALUES ('1467', 'Puebla', '30');
INSERT INTO `team` VALUES ('1468', 'Santos Laguna', '30');
INSERT INTO `team` VALUES ('1469', 'Veracruz', '30');
INSERT INTO `team` VALUES ('1470', 'Tigres', '30');
INSERT INTO `team` VALUES ('1471', 'Toluca', '30');
INSERT INTO `team` VALUES ('1473', 'Pumas', '30');
INSERT INTO `team` VALUES ('1474', 'Querétaro', '30');
INSERT INTO `team` VALUES ('1477', 'León', '30');
INSERT INTO `team` VALUES ('1514', 'ADO', '13');
INSERT INTO `team` VALUES ('1515', 'Ajax', '13');
INSERT INTO `team` VALUES ('1516', 'AZ', '13');
INSERT INTO `team` VALUES ('1517', 'PSV', '13');
INSERT INTO `team` VALUES ('1518', 'Feyenoord', '13');
INSERT INTO `team` VALUES ('1519', 'Heerenveen', '13');
INSERT INTO `team` VALUES ('1520', 'Roda', '13');
INSERT INTO `team` VALUES ('1521', 'Willem B', '13');
INSERT INTO `team` VALUES ('1522', 'Twente', '13');
INSERT INTO `team` VALUES ('1523', 'Utrecht', '13');
INSERT INTO `team` VALUES ('1524', 'NAC', '13');
INSERT INTO `team` VALUES ('1526', 'Waalwijk', '13');
INSERT INTO `team` VALUES ('1527', 'Groningen', '13');
INSERT INTO `team` VALUES ('1528', 'NEC', '13');
INSERT INTO `team` VALUES ('1529', 'Zwolle', '13');
INSERT INTO `team` VALUES ('1530', 'Vitesse', '13');
INSERT INTO `team` VALUES ('1531', 'Volendam', '13');
INSERT INTO `team` VALUES ('1532', 'Excelsior', '13');
INSERT INTO `team` VALUES ('1533', 'Den Bosch', '13');
INSERT INTO `team` VALUES ('1534', 'Helmond', '13');
INSERT INTO `team` VALUES ('1535', 'Roterdão', '13');
INSERT INTO `team` VALUES ('1536', 'Heracles', '13');
INSERT INTO `team` VALUES ('1537', 'De Graafschap', '13');
INSERT INTO `team` VALUES ('1538', 'VVV', '13');
INSERT INTO `team` VALUES ('1539', 'Emmen', '13');
INSERT INTO `team` VALUES ('1540', 'Go Ahead', '13');
INSERT INTO `team` VALUES ('1542', 'Oss', '13');
INSERT INTO `team` VALUES ('1544', 'Telstar', '13');
INSERT INTO `team` VALUES ('1547', 'Cambuur', '13');
INSERT INTO `team` VALUES ('1548', 'Dordrecht', '13');
INSERT INTO `team` VALUES ('1549', 'FC Eindoven', '13');
INSERT INTO `team` VALUES ('1550', 'MVV', '13');
INSERT INTO `team` VALUES ('1551', 'Sittard', '13');
INSERT INTO `team` VALUES ('1585', 'Tromso', '19');
INSERT INTO `team` VALUES ('1586', 'Odd', '19');
INSERT INTO `team` VALUES ('1587', 'Rosenborg', '19');
INSERT INTO `team` VALUES ('1588', 'Vålerenga', '19');
INSERT INTO `team` VALUES ('1591', 'Brann', '19');
INSERT INTO `team` VALUES ('1592', 'Lillestrøm', '19');
INSERT INTO `team` VALUES ('1593', 'Stabæk', '19');
INSERT INTO `team` VALUES ('1594', 'Molde', '19');
INSERT INTO `team` VALUES ('1596', 'Viking', '19');
INSERT INTO `team` VALUES ('1597', 'Sogndal', '19');
INSERT INTO `team` VALUES ('1601', 'Sandefjord', '19');
INSERT INTO `team` VALUES ('1602', 'Aalesund', '19');
INSERT INTO `team` VALUES ('1607', 'Stromsgodset', '19');
INSERT INTO `team` VALUES ('1610', 'Haugesund', '19');
INSERT INTO `team` VALUES ('1647', 'Wisla', '20');
INSERT INTO `team` VALUES ('1648', 'Legia', '20');
INSERT INTO `team` VALUES ('1651', 'Wisła Plock', '20');
INSERT INTO `team` VALUES ('1653', 'Lech', '20');
INSERT INTO `team` VALUES ('1654', 'Górnik Leczna', '20');
INSERT INTO `team` VALUES ('1661', 'Pogoń', '20');
INSERT INTO `team` VALUES ('1663', 'Zaglebie', '20');
INSERT INTO `team` VALUES ('1664', 'Cracovia', '20');
INSERT INTO `team` VALUES ('1668', 'Ruch', '20');
INSERT INTO `team` VALUES ('1670', 'Jagiellonia', '20');
INSERT INTO `team` VALUES ('1672', 'Arka', '20');
INSERT INTO `team` VALUES ('1673', 'Piast', '20');
INSERT INTO `team` VALUES ('1678', 'Porto', '21');
INSERT INTO `team` VALUES ('1679', 'Benfica', '21');
INSERT INTO `team` VALUES ('1680', 'Sporting CP', '21');
INSERT INTO `team` VALUES ('1681', 'Nacional', '21');
INSERT INTO `team` VALUES ('1682', 'Braga', '21');
INSERT INTO `team` VALUES ('1683', 'Rio Ave', '21');
INSERT INTO `team` VALUES ('1684', 'Marítimo', '21');
INSERT INTO `team` VALUES ('1685', 'Boavista', '21');
INSERT INTO `team` VALUES ('1687', 'Moreirense', '21');
INSERT INTO `team` VALUES ('1689', 'Guimarães', '21');
INSERT INTO `team` VALUES ('1690', 'Académica', '21');
INSERT INTO `team` VALUES ('1692', 'Belenenses', '21');
INSERT INTO `team` VALUES ('1693', 'Paços Ferreira', '21');
INSERT INTO `team` VALUES ('1695', 'Estoril', '21');
INSERT INTO `team` VALUES ('1696', 'Setúbal', '21');
INSERT INTO `team` VALUES ('1697', 'Penafiel', '21');
INSERT INTO `team` VALUES ('1698', 'Varzim', '21');
INSERT INTO `team` VALUES ('1702', 'Aves', '21');
INSERT INTO `team` VALUES ('1704', 'Chaves', '21');
INSERT INTO `team` VALUES ('1705', 'Feirense', '21');
INSERT INTO `team` VALUES ('1706', 'Santa Clara', '21');
INSERT INTO `team` VALUES ('1707', 'Leixões', '21');
INSERT INTO `team` VALUES ('1710', 'Portimonense', '21');
INSERT INTO `team` VALUES ('1711', 'União Madeira', '21');
INSERT INTO `team` VALUES ('1712', 'Covilhã', '21');
INSERT INTO `team` VALUES ('1713', 'Olhanense', '21');
INSERT INTO `team` VALUES ('1728', 'Sporting CP B', '21');
INSERT INTO `team` VALUES ('1737', 'Viseu', '21');
INSERT INTO `team` VALUES ('1755', 'Vizela', '21');
INSERT INTO `team` VALUES ('1756', 'Porto B', '21');
INSERT INTO `team` VALUES ('1758', 'Braga B', '21');
INSERT INTO `team` VALUES ('1761', 'Freamunde', '21');
INSERT INTO `team` VALUES ('1765', 'Fafe', '21');
INSERT INTO `team` VALUES ('1841', 'Zenit', '23');
INSERT INTO `team` VALUES ('1842', 'CSKA', '23');
INSERT INTO `team` VALUES ('1843', 'Lokomotiv M', '23');
INSERT INTO `team` VALUES ('1844', 'Spartak M', '23');
INSERT INTO `team` VALUES ('1845', 'Dinamo M', '23');
INSERT INTO `team` VALUES ('1848', 'Krylya', '23');
INSERT INTO `team` VALUES ('1850', 'Shinnik', '23');
INSERT INTO `team` VALUES ('1851', 'Amkar', '23');
INSERT INTO `team` VALUES ('1852', 'Rubin', '23');
INSERT INTO `team` VALUES ('1853', 'Kuban\'', '23');
INSERT INTO `team` VALUES ('1854', 'Rostov', '23');
INSERT INTO `team` VALUES ('1856', 'Terek', '23');
INSERT INTO `team` VALUES ('1857', 'Spartak', '23');
INSERT INTO `team` VALUES ('1858', 'Sokol', '23');
INSERT INTO `team` VALUES ('1860', 'Luch Energiya', '23');
INSERT INTO `team` VALUES ('1863', 'Arsenal', '23');
INSERT INTO `team` VALUES ('1867', 'Khimki', '23');
INSERT INTO `team` VALUES ('1868', 'Anzhi', '23');
INSERT INTO `team` VALUES ('1870', 'Tom\'', '23');
INSERT INTO `team` VALUES ('1872', 'Energiya', '23');
INSERT INTO `team` VALUES ('1875', 'Baltika', '23');
INSERT INTO `team` VALUES ('1877', 'Neftekhimik', '23');
INSERT INTO `team` VALUES ('1898', 'Celtic', '8');
INSERT INTO `team` VALUES ('1899', 'Rangers', '8');
INSERT INTO `team` VALUES ('1900', 'Midlothian', '8');
INSERT INTO `team` VALUES ('1902', 'Motherwell', '8');
INSERT INTO `team` VALUES ('1906', 'Kilmarnock', '8');
INSERT INTO `team` VALUES ('1907', 'Dundee', '8');
INSERT INTO `team` VALUES ('1908', 'Aberdeen', '8');
INSERT INTO `team` VALUES ('1909', 'Partick', '8');
INSERT INTO `team` VALUES ('1911', 'Inverness', '8');
INSERT INTO `team` VALUES ('1912', 'St. Johnstone', '8');
INSERT INTO `team` VALUES ('1914', 'Ross', '8');
INSERT INTO `team` VALUES ('1922', 'Hamilton', '8');
INSERT INTO `team` VALUES ('2015', 'Valencia', '9');
INSERT INTO `team` VALUES ('2016', 'Real Madrid', '9');
INSERT INTO `team` VALUES ('2017', 'Barcelona', '9');
INSERT INTO `team` VALUES ('2018', 'La Coruña', '9');
INSERT INTO `team` VALUES ('2019', 'Ath Bilbao', '9');
INSERT INTO `team` VALUES ('2020', 'Atl. Madrid', '9');
INSERT INTO `team` VALUES ('2021', 'Sevilla', '9');
INSERT INTO `team` VALUES ('2022', 'Osasuna', '9');
INSERT INTO `team` VALUES ('2023', 'Villarreal', '9');
INSERT INTO `team` VALUES ('2024', 'Málaga', '9');
INSERT INTO `team` VALUES ('2025', 'Betis', '9');
INSERT INTO `team` VALUES ('2027', 'Maiorca', '9');
INSERT INTO `team` VALUES ('2028', 'Real Sociedad', '9');
INSERT INTO `team` VALUES ('2030', 'Zaragoza', '9');
INSERT INTO `team` VALUES ('2031', 'Valladolid', '9');
INSERT INTO `team` VALUES ('2032', 'Espanyol', '9');
INSERT INTO `team` VALUES ('2033', 'Celta de Vigo', '9');
INSERT INTO `team` VALUES ('2035', 'Numancia', '9');
INSERT INTO `team` VALUES ('2036', 'Levante', '9');
INSERT INTO `team` VALUES ('2037', 'Alavés', '9');
INSERT INTO `team` VALUES ('2038', 'Gijón', '9');
INSERT INTO `team` VALUES ('2039', 'Getafe', '9');
INSERT INTO `team` VALUES ('2041', 'Cádiz', '9');
INSERT INTO `team` VALUES ('2042', 'Eibar', '9');
INSERT INTO `team` VALUES ('2043', 'Elche', '9');
INSERT INTO `team` VALUES ('2048', 'Tenerife', '9');
INSERT INTO `team` VALUES ('2049', 'Almería', '9');
INSERT INTO `team` VALUES ('2050', 'Córdoba', '9');
INSERT INTO `team` VALUES ('2053', 'Leganés', '9');
INSERT INTO `team` VALUES ('2054', 'Vallecano', '9');
INSERT INTO `team` VALUES ('2055', 'Las Palmas', '9');
INSERT INTO `team` VALUES ('2085', 'Alcorcón', '9');
INSERT INTO `team` VALUES ('2099', 'Tarragona', '9');
INSERT INTO `team` VALUES ('2101', 'Girona', '9');
INSERT INTO `team` VALUES ('2118', 'Sevilla B', '9');
INSERT INTO `team` VALUES ('2145', 'Halmstad', '24');
INSERT INTO `team` VALUES ('2146', 'Malmo', '24');
INSERT INTO `team` VALUES ('2147', 'Hammarby', '24');
INSERT INTO `team` VALUES ('2148', 'Kalmar', '24');
INSERT INTO `team` VALUES ('2149', 'IFK Gotemburgo', '24');
INSERT INTO `team` VALUES ('2150', 'Djurgården', '24');
INSERT INTO `team` VALUES ('2153', 'AIK Solna', '24');
INSERT INTO `team` VALUES ('2156', 'Orebro SK', '24');
INSERT INTO `team` VALUES ('2157', 'Sundsvall', '24');
INSERT INTO `team` VALUES ('2158', 'Elfsborg', '24');
INSERT INTO `team` VALUES ('2163', 'IFK Norrkoping', '24');
INSERT INTO `team` VALUES ('2174', 'Basileia', '25');
INSERT INTO `team` VALUES ('2175', 'Young Boys', '25');
INSERT INTO `team` VALUES ('2177', 'São Gallen', '25');
INSERT INTO `team` VALUES ('2178', 'Grasshopper', '25');
INSERT INTO `team` VALUES ('2180', 'Thun', '25');
INSERT INTO `team` VALUES ('2189', 'Sion', '25');
INSERT INTO `team` VALUES ('2193', 'Luzern', '25');
INSERT INTO `team` VALUES ('2212', 'Fenerbahçe', '26');
INSERT INTO `team` VALUES ('2213', 'Trabzon', '26');
INSERT INTO `team` VALUES ('2214', 'Besiktas', '26');
INSERT INTO `team` VALUES ('2216', 'Gaziantepspor', '26');
INSERT INTO `team` VALUES ('2217', 'Galatasaray', '26');
INSERT INTO `team` VALUES ('2219', 'Gençlerbirliği', '26');
INSERT INTO `team` VALUES ('2223', 'Konya', '26');
INSERT INTO `team` VALUES ('2224', 'Rize', '26');
INSERT INTO `team` VALUES ('2227', 'Bursa', '26');
INSERT INTO `team` VALUES ('2229', 'Adanaspor', '26');
INSERT INTO `team` VALUES ('2232', 'Osmanlispor', '26');
INSERT INTO `team` VALUES ('2235', 'Kayserispor', '26');
INSERT INTO `team` VALUES ('2236', 'Antalyaspor', '26');
INSERT INTO `team` VALUES ('2253', 'Dínamo Kiev', '27');
INSERT INTO `team` VALUES ('2254', 'Shakhtar D', '27');
INSERT INTO `team` VALUES ('2255', 'Dnipro', '27');
INSERT INTO `team` VALUES ('2257', 'Chornomorets', '27');
INSERT INTO `team` VALUES ('2261', 'Volyn', '27');
INSERT INTO `team` VALUES ('2265', 'Vorskla', '27');
INSERT INTO `team` VALUES ('2267', 'Karpaty', '27');
INSERT INTO `team` VALUES ('2272', 'LA Galaxy', '10');
INSERT INTO `team` VALUES ('2273', 'Chicago', '10');
INSERT INTO `team` VALUES ('2274', 'Kansas', '10');
INSERT INTO `team` VALUES ('2276', 'Earthquakes', '10');
INSERT INTO `team` VALUES ('2277', 'DC United', '10');
INSERT INTO `team` VALUES ('2278', 'Colorado', '10');
INSERT INTO `team` VALUES ('2279', 'New England', '10');
INSERT INTO `team` VALUES ('2280', 'Columbus Crew', '10');
INSERT INTO `team` VALUES ('2336', 'Real Oviedo', '9');
INSERT INTO `team` VALUES ('2351', 'Karabukspor', '26');
INSERT INTO `team` VALUES ('2378', 'Red Star', '11');
INSERT INTO `team` VALUES ('2398', 'Häcken', '24');
INSERT INTO `team` VALUES ('2478', 'Sirius', '24');
INSERT INTO `team` VALUES ('2496', 'Sarpsburgo', '19');
INSERT INTO `team` VALUES ('2549', 'Darmstadt 98', '1');
INSERT INTO `team` VALUES ('2572', 'Gil Vicente', '21');
INSERT INTO `team` VALUES ('2574', 'Neftohimik', '28');
INSERT INTO `team` VALUES ('2581', 'Montana', '28');
INSERT INTO `team` VALUES ('2619', 'Split', '29');
INSERT INTO `team` VALUES ('2752', 'Famalicão', '21');
INSERT INTO `team` VALUES ('2782', 'Dukla', '22');
INSERT INTO `team` VALUES ('2784', 'Karviná', '22');
INSERT INTO `team` VALUES ('2884', 'Basaksehir', '26');
INSERT INTO `team` VALUES ('2891', 'Benfica B', '21');
INSERT INTO `team` VALUES ('2936', 'Panelefsiniakos', '12');
INSERT INTO `team` VALUES ('2937', 'Trikala', '12');
INSERT INTO `team` VALUES ('2939', 'Panaitolikos', '12');
INSERT INTO `team` VALUES ('2943', 'Anagennisi K', '12');
INSERT INTO `team` VALUES ('2948', 'Panegialios', '12');
INSERT INTO `team` VALUES ('2951', 'Lugano', '25');
INSERT INTO `team` VALUES ('2952', 'Lausanne', '25');
INSERT INTO `team` VALUES ('2981', 'Frosinone', '17');
INSERT INTO `team` VALUES ('2986', 'Slovácko', '22');
INSERT INTO `team` VALUES ('2990', 'Sonderjysk', '7');
INSERT INTO `team` VALUES ('3003', 'Huesca', '9');
INSERT INTO `team` VALUES ('3019', 'Sarmiento', '2');
INSERT INTO `team` VALUES ('3030', 'Lamia', '12');
INSERT INTO `team` VALUES ('3087', 'Monterrey', '30');
INSERT INTO `team` VALUES ('3109', 'Slask Wroclaw', '20');
INSERT INTO `team` VALUES ('3121', 'Kielce', '20');
INSERT INTO `team` VALUES ('3133', 'Lechia', '20');
INSERT INTO `team` VALUES ('3139', 'Liaoning', '5');
INSERT INTO `team` VALUES ('3163', 'Oryahovitsa', '28');
INSERT INTO `team` VALUES ('3613', 'ThespaKusatsu', '18');
INSERT INTO `team` VALUES ('3614', 'Tokushima', '18');
INSERT INTO `team` VALUES ('3703', 'Stal Dn', '27');
INSERT INTO `team` VALUES ('3704', 'Zorya', '27');
INSERT INTO `team` VALUES ('3744', 'Volgar', '23');
INSERT INTO `team` VALUES ('3748', 'Fakel', '23');
INSERT INTO `team` VALUES ('3750', 'Ural', '23');
INSERT INTO `team` VALUES ('3826', 'Yanbian Funde', '5');
INSERT INTO `team` VALUES ('3841', 'Dallas', '10');
INSERT INTO `team` VALUES ('3843', 'Salt Lake', '10');
INSERT INTO `team` VALUES ('3864', 'AFC Utd', '24');
INSERT INTO `team` VALUES ('3970', 'Mordovia', '23');
INSERT INTO `team` VALUES ('4034', 'Östersunds FK', '24');
INSERT INTO `team` VALUES ('4049', 'Gazovik', '23');
INSERT INTO `team` VALUES ('4094', 'Yenisey', '23');
INSERT INTO `team` VALUES ('4513', 'Istra', '29');
INSERT INTO `team` VALUES ('4529', 'Almere City', '13');
INSERT INTO `team` VALUES ('4593', 'Wimbledon', '15');
INSERT INTO `team` VALUES ('4717', 'Achilles \'29', '13');
INSERT INTO `team` VALUES ('4781', 'Ajax B', '13');
INSERT INTO `team` VALUES ('4789', 'PSV B', '13');
INSERT INTO `team` VALUES ('4799', 'Reus', '9');
INSERT INTO `team` VALUES ('4908', 'Fleetwood', '15');
INSERT INTO `team` VALUES ('5030', 'Aldosivi', '2');
INSERT INTO `team` VALUES ('5032', 'Tigre', '2');
INSERT INTO `team` VALUES ('5096', 'Gyirmót', '14');
INSERT INTO `team` VALUES ('5101', 'Paksi', '14');
INSERT INTO `team` VALUES ('5110', 'Tijuana', '30');
INSERT INTO `team` VALUES ('5112', 'ABC', '3');
INSERT INTO `team` VALUES ('5127', 'Boa', '3');
INSERT INTO `team` VALUES ('5130', 'Luverdense', '3');
INSERT INTO `team` VALUES ('5476', 'Ingolstadt', '1');
INSERT INTO `team` VALUES ('5604', 'Orléans', '11');
INSERT INTO `team` VALUES ('5665', 'Latina', '17');
INSERT INTO `team` VALUES ('5675', 'Pro Vercelli', '17');
INSERT INTO `team` VALUES ('5681', 'Sassuolo', '17');
INSERT INTO `team` VALUES ('5693', 'Asteras', '12');
INSERT INTO `team` VALUES ('5697', 'Panthrakikos', '12');
INSERT INTO `team` VALUES ('5862', 'Heidenheim', '1');
INSERT INTO `team` VALUES ('5898', 'Sandhausen', '1');
INSERT INTO `team` VALUES ('5966', 'Videoton', '14');
INSERT INTO `team` VALUES ('6205', 'Brasil Pelotas', '3');
INSERT INTO `team` VALUES ('6216', 'Atlético GO', '3');
INSERT INTO `team` VALUES ('6223', 'Chapecoense', '3');
INSERT INTO `team` VALUES ('6378', 'Jönköpings S', '24');
INSERT INTO `team` VALUES ('6422', 'Houston', '10');
INSERT INTO `team` VALUES ('6521', 'Ehime', '18');
INSERT INTO `team` VALUES ('6559', 'Sibir', '23');
INSERT INTO `team` VALUES ('6564', 'Jeju Utd', '6');
INSERT INTO `team` VALUES ('6571', 'NY Red Bulls', '10');
INSERT INTO `team` VALUES ('6637', 'Tyumen', '23');
INSERT INTO `team` VALUES ('6648', 'Guangzhou', '5');
INSERT INTO `team` VALUES ('6900', 'Kasımpaşa', '26');
INSERT INTO `team` VALUES ('6957', 'Oleksandria', '27');
INSERT INTO `team` VALUES ('6961', 'SM Tucumán', '2');
INSERT INTO `team` VALUES ('7026', 'All Boys', '2');
INSERT INTO `team` VALUES ('7029', 'Brown Adrogué', '2');
INSERT INTO `team` VALUES ('7036', 'Flandria', '2');
INSERT INTO `team` VALUES ('7043', 'Temperley', '2');
INSERT INTO `team` VALUES ('7044', 'Douglas Haig', '2');
INSERT INTO `team` VALUES ('7053', 'Santamarina', '2');
INSERT INTO `team` VALUES ('7054', 'Guillermo Br', '2');
INSERT INTO `team` VALUES ('7060', 'Independiente', '2');
INSERT INTO `team` VALUES ('7064', 'Tucumán', '2');
INSERT INTO `team` VALUES ('7072', 'Granada', '9');
INSERT INTO `team` VALUES ('7073', 'Lugo', '9');
INSERT INTO `team` VALUES ('7122', 'Olimpik D', '27');
INSERT INTO `team` VALUES ('7285', 'Alanyaspor', '26');
INSERT INTO `team` VALUES ('7458', 'Villa Dálmine', '2');
INSERT INTO `team` VALUES ('7787', 'Córdoba SdE', '2');
INSERT INTO `team` VALUES ('7788', 'Crucero', '2');
INSERT INTO `team` VALUES ('7853', 'Kristiansund', '19');
INSERT INTO `team` VALUES ('7903', 'Vaduz', '25');
INSERT INTO `team` VALUES ('7977', 'Toronto', '10');
INSERT INTO `team` VALUES ('8009', 'Juventud UG', '2');
INSERT INTO `team` VALUES ('8010', 'Patronato', '2');
INSERT INTO `team` VALUES ('8018', 'Boca Unidos', '2');
INSERT INTO `team` VALUES ('8200', 'Limerick', '16');
INSERT INTO `team` VALUES ('8333', 'Kumamoto', '18');
INSERT INTO `team` VALUES ('8347', 'Gifu', '18');
INSERT INTO `team` VALUES ('9063', 'Zirka', '27');
INSERT INTO `team` VALUES ('9113', 'MZSE', '14');
INSERT INTO `team` VALUES ('9670', 'Mirandés', '9');
INSERT INTO `team` VALUES ('10123', 'Cova Piedade', '21');
INSERT INTO `team` VALUES ('10309', 'Oeste', '3');
INSERT INTO `team` VALUES ('10610', 'Krasnodar', '23');
INSERT INTO `team` VALUES ('10655', 'Shanghai SIPG', '5');
INSERT INTO `team` VALUES ('10765', 'Fagiano', '18');
INSERT INTO `team` VALUES ('11060', 'Würzburg', '1');
INSERT INTO `team` VALUES ('11414', 'Nieciecza', '20');
INSERT INTO `team` VALUES ('11601', 'Lok Zagreb', '29');
INSERT INTO `team` VALUES ('11611', 'Arouca', '21');
INSERT INTO `team` VALUES ('11703', 'Akhisar', '26');
INSERT INTO `team` VALUES ('11833', 'Tondela', '21');
INSERT INTO `team` VALUES ('12109', 'Virtus', '17');
INSERT INTO `team` VALUES ('12140', 'Carpi', '17');
INSERT INTO `team` VALUES ('12229', 'Trapani', '17');
INSERT INTO `team` VALUES ('12387', 'Ludogorets', '28');
INSERT INTO `team` VALUES ('12592', 'Matsumoto', '18');
INSERT INTO `team` VALUES ('12595', 'Zweigen', '18');
INSERT INTO `team` VALUES ('12907', 'Gangwon', '6');
INSERT INTO `team` VALUES ('13024', 'Seattle', '10');
INSERT INTO `team` VALUES ('13025', 'Orlando', '10');
INSERT INTO `team` VALUES ('13133', 'V-Varen', '18');
INSERT INTO `team` VALUES ('13135', 'Machida', '18');
INSERT INTO `team` VALUES ('13204', 'Ufa', '23');
INSERT INTO `team` VALUES ('13410', 'Leipzig', '1');
INSERT INTO `team` VALUES ('13920', 'UCAM', '9');
INSERT INTO `team` VALUES ('14447', 'Platanias', '12');
INSERT INTO `team` VALUES ('14575', 'Philadelphia', '10');
INSERT INTO `team` VALUES ('14860', 'Minnesota', '10');
INSERT INTO `team` VALUES ('15156', 'Spartak M B', '23');
INSERT INTO `team` VALUES ('15342', 'Tosno', '23');
INSERT INTO `team` VALUES ('16355', 'Botev Plovdiv', '28');
INSERT INTO `team` VALUES ('16676', 'Paraná', '2');
INSERT INTO `team` VALUES ('16848', 'Kamatamare', '18');
INSERT INTO `team` VALUES ('16852', 'Renofa', '18');
INSERT INTO `team` VALUES ('16855', 'Chania', '12');
INSERT INTO `team` VALUES ('16860', 'Kalloni', '12');
INSERT INTO `team` VALUES ('17500', 'Whitecaps', '10');
INSERT INTO `team` VALUES ('17501', 'Portland', '10');
INSERT INTO `team` VALUES ('18351', 'Gwangju', '6');
INSERT INTO `team` VALUES ('18583', 'Tianjin', '5');
INSERT INTO `team` VALUES ('18584', 'Guizhou Zhicheng', '5');
INSERT INTO `team` VALUES ('18838', 'Zenit SPb B', '23');
INSERT INTO `team` VALUES ('19828', 'Dunav', '28');
INSERT INTO `team` VALUES ('20235', 'Vereya', '28');
INSERT INTO `team` VALUES ('20515', 'Aiginiakos', '12');
INSERT INTO `team` VALUES ('20584', 'Acharnaikos', '12');
INSERT INTO `team` VALUES ('20933', 'Montreal', '10');
INSERT INTO `team` VALUES ('21563', 'Hebei CFFC', '5');
INSERT INTO `team` VALUES ('21775', 'Guimarães B', '21');
INSERT INTO `team` VALUES ('21812', 'Estudiantes SL', '2');
INSERT INTO `team` VALUES ('22879', 'Utrecht', '13');
INSERT INTO `team` VALUES ('23444', 'Kissamikos', '12');
INSERT INTO `team` VALUES ('24539', 'Tambov', '23');
INSERT INTO `team` VALUES ('26455', 'Galway', '16');
INSERT INTO `team` VALUES ('27696', 'NYCFC', '10');
INSERT INTO `team` VALUES ('34937', 'Sparta', '12');
INSERT INTO `team` VALUES ('38167', 'Atlanta United', '10');

-- ----------------------------
-- Table structure for type_criteria_analisys_match
-- ----------------------------
DROP TABLE IF EXISTS `type_criteria_analisys_match`;
CREATE TABLE `type_criteria_analisys_match` (
  `tcam_cd_id_pk` bigint(20) NOT NULL AUTO_INCREMENT,
  `tcam_ds_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tcam_cd_id_pk`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of type_criteria_analisys_match
-- ----------------------------
INSERT INTO `type_criteria_analisys_match` VALUES ('1', 'ALL_GAMES');
INSERT INTO `type_criteria_analisys_match` VALUES ('2', 'LAST3_MATCHES');

-- ----------------------------
-- Table structure for type_general_condition
-- ----------------------------
DROP TABLE IF EXISTS `type_general_condition`;
CREATE TABLE `type_general_condition` (
  `tygc_cd_id_pk` bigint(20) NOT NULL AUTO_INCREMENT,
  `tygc_ds_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tygc_cd_id_pk`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of type_general_condition
-- ----------------------------
INSERT INTO `type_general_condition` VALUES ('1', 'GENERAL');
INSERT INTO `type_general_condition` VALUES ('2', 'CONDITION');
