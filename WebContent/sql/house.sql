/*
Navicat MySQL Data Transfer

Source Server         : house
Source Server Version : 50156
Source Host           : localhost:3306
Source Database       : house

Target Server Type    : MYSQL
Target Server Version : 50156
File Encoding         : 65001

Date: 2017-04-29 18:34:05
*/
SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `uid` varchar(10) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL, 
  `power` int(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `uid` varchar(10) NOT NULL,
  `name` varchar(30) NOT NULL,
  `nicname` varchar(50) NOT NULL,
  `gender` varchar(4) NOT NULL,
  `photo` varchar(50),
  `mail` varchar(50),
  `phone` varchar(20),
  `qq` varchar(30),
  `address` varchar(100) ,
  `birthday` varchar(8),
  `Power` int(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `agent``
-- ----------------------------
DROP TABLE IF EXISTS `agent`;
CREATE TABLE `agent` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `agentid` varchar(10) NOT NULL,
  `uid` varchar(10) NOT NULL,
  `acredit` int(1) NOT NULL,
  `agrade` int(2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8;

