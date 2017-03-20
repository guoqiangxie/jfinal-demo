/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : jfinal_demo

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-03-20 14:47:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `xgq_user`
-- ----------------------------
DROP TABLE IF EXISTS `xgq_user`;
CREATE TABLE `xgq_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '名字',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  `nick_name` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '昵称',
  `last_login` timestamp NULL DEFAULT NULL COMMENT '最后登录时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of xgq_user
-- ----------------------------
