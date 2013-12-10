/*
Navicat MySQL Data Transfer

Source Server         : 192.168.10.15-testserver
Source Server Version : 50166
Source Host           : 192.168.10.242:3306
Source Database       : wechat_db

Target Server Type    : MYSQL
Target Server Version : 50166
File Encoding         : 65001

Date: 2013-12-06 18:02:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `wechat_app`
-- ----------------------------
DROP TABLE IF EXISTS `wechat_app`;
CREATE TABLE `wechat_app` (
  `app_id` mediumint(9) NOT NULL AUTO_INCREMENT,
  `app_key` varchar(128) DEFAULT NULL,
  `app_secret` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`app_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wechat_app
-- ----------------------------
INSERT INTO `wechat_app` VALUES ('1', 'wx136d668a243902c0', '1d557540724ec17578433e3040ebacf3');

-- ----------------------------
-- Table structure for `wechat_menu`
-- ----------------------------
DROP TABLE IF EXISTS `wechat_menu`;
CREATE TABLE `wechat_menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(64) NOT NULL,
  `menu_type` varchar(16) NOT NULL,
  `menu_url` varchar(128) DEFAULT NULL,
  `menu_description` varchar(128) DEFAULT NULL,
  `menu_key_code` varchar(32) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `app_id` mediumint(9) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wechat_menu
-- ----------------------------
INSERT INTO `wechat_menu` VALUES ('1', '非姐养生', '', null, null, null, null, '1', '1');
INSERT INTO `wechat_menu` VALUES ('2', '非姐分享', '', null, null, null, null, '1', '1');
INSERT INTO `wechat_menu` VALUES ('3', '更多', '', null, null, null, null, '1', '1');
INSERT INTO `wechat_menu` VALUES ('4', '养生馆', 'view', 'http://cod.com', null, null, '1', '1', '1');
INSERT INTO `wechat_menu` VALUES ('5', '微商城', 'view', 'http://cod.com', null, null, '1', '1', '1');
INSERT INTO `wechat_menu` VALUES ('6', '淘宝小店', 'view', 'http://cod.com', null, null, '1', '1', '1');
INSERT INTO `wechat_menu` VALUES ('7', '非姐小厨', 'click', null, 'ddd', '1', '2', '1', '1');
INSERT INTO `wechat_menu` VALUES ('8', '温灸养生', 'click', null, 'ddd', '3', '2', '1', '1');
INSERT INTO `wechat_menu` VALUES ('9', '非推荐', 'click', null, 'ddd', '2', '2', '1', '1');
INSERT INTO `wechat_menu` VALUES ('10', '订单查询', 'click', null, 'ddd', '5', '3', '1', '1');
INSERT INTO `wechat_menu` VALUES ('11', '微预约', 'click', null, 'ddd', '4', '3', '1', '1');
INSERT INTO `wechat_menu` VALUES ('12', '非客服', 'click', null, 'ddd', '6', '3', '1', '1');

-- ----------------------------
-- Table structure for `wechat_message`
-- ----------------------------
DROP TABLE IF EXISTS `wechat_message`;
CREATE TABLE `wechat_message` (
  `message_id` int(11) NOT NULL AUTO_INCREMENT,
  `message_from_user` varchar(128) DEFAULT NULL,
  `message_to_user` varchar(128) DEFAULT NULL,
  `message_type` tinyint(1) DEFAULT NULL,
  `message_create_time` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wechat_message
-- ----------------------------

-- ----------------------------
-- Table structure for `wechat_user`
-- ----------------------------
DROP TABLE IF EXISTS `wechat_user`;
CREATE TABLE `wechat_user` (
  `user_id` int(9) NOT NULL AUTO_INCREMENT,
  `user_login_name` varchar(64) NOT NULL,
  `user_password` varchar(128) NOT NULL,
  `user_login_time` bigint(20) DEFAULT NULL,
  `user_login_ip` varchar(32) DEFAULT NULL,
  `user_true_name` varchar(64) DEFAULT NULL,
  `user_type` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wechat_user
-- ----------------------------
INSERT INTO `wechat_user` VALUES ('1', 'test_one', '123456', null, null, null, null);
INSERT INTO `wechat_user` VALUES ('2', 'test_two', '123456', null, null, null, null);

-- ----------------------------
-- Table structure for `wechat_user_app`
-- ----------------------------
DROP TABLE IF EXISTS `wechat_user_app`;
CREATE TABLE `wechat_user_app` (
  `user_app_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `app_id` mediumint(9) NOT NULL,
  PRIMARY KEY (`user_app_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wechat_user_app
-- ----------------------------
INSERT INTO `wechat_user_app` VALUES ('1', '1', '1');
INSERT INTO `wechat_user_app` VALUES ('2', '2', '1');
