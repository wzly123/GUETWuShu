
CREATE DATABASE `guetwushu_1` DEFAULT CHARACTER SET utf8;

USE `guetwushu_1`;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for administrator
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator` (
  `id` tinyint NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL COMMENT '昵称',
  `real_name` varchar(5) DEFAULT NULL COMMENT '真实姓名',
  `student_id` varchar(20) DEFAULT NULL COMMENT '学号',
  `phone_number` varchar(11) DEFAULT NULL COMMENT '电话号码',
  `pwd` varchar(40) DEFAULT NULL COMMENT '密码',
  `introduction` varchar(200) COMMENT '个人介绍',
  `academy` varchar(15) DEFAULT NULL COMMENT '学院',
  `major` varchar(15) DEFAULT NULL COMMENT '专业',
  `sex` char COMMENT '性别',
  `create_time` datetime COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of administrator
-- ----------------------------

INSERT INTO `administrator` VALUES ('1', '小红', '刘红', "1700001801", "18888888888", "E10ADC3949BA59ABBE56E057F20F883E","无","信息与通信学院","电子信息工程","男","2020-03-02 23:32:52");
INSERT INTO `administrator` VALUES ('2', '小黄', '陈黄', "1700201802", "18888888888", "E10ADC3949BA59ABBE56E057F20F883E","无","信息与通信学院","通信工程","男","2020-03-02 23:33:15");
INSERT INTO `administrator` VALUES ('3', '小绿', '王绿', "1700201803", "18888888888", "E10ADC3949BA59ABBE56E057F20F883E","无","信息与通信学院","计算机与科学","男","2020-03-02 23:34:01");


-- ----------------------------
-- Table structure for banner
-- ----------------------------
DROP TABLE IF EXISTS `banner`;
CREATE TABLE `banner` (
  `id` tinyint NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL COMMENT '名称',
  `weight` tinyint COMMENT '图片的大小',
  `url` varchar(60) DEFAULT NULL COMMENT '图片的地址',
  `create_time` datetime COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of banner
-- ----------------------------
INSERT INTO `banner` VALUES ('1', "新闻", '42', "www.baidu,com", "2020-03-03 09:10:00");
INSERT INTO `banner` VALUES ('2', "体育", '44', "www.souhu.com", "2020-03-03 09:11:15");
INSERT INTO `banner` VALUES ('3', "文化", '35', "www.goole.com", "2020-03-03 09:12:34");
INSERT INTO `banner` VALUES ('4', "杂谈", '45', "www.csdn.net", "2020-03-03 09:13:22");


-- ----------------------------
-- Table structure for study
-- ----------------------------
DROP TABLE IF EXISTS `study`;
CREATE TABLE `study` (
  `id` tinyint NOT NULL AUTO_INCREMENT,
  `news` text COMMENT '武术新闻',
  `species_list` varchar(10) DEFAULT NULL COMMENT '武术种类列表',
  `introduction_list` varchar(10) DEFAULT NULL COMMENT '武术介绍列表',
  `culture_list` varchar(10) DEFAULT NULL COMMENT '武术文化列表',
  `essence_list` varchar(10) DEFAULT NULL COMMENT '武术精髓列表',
  `create_time` datetime COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of study
-- ----------------------------

INSERT INTO `study` VALUES ('1', "武术学习", "武术种类", "武术介绍", "武术文化", "武术精髓", "2020-03-03 10:01:22");

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` tinyint NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL COMMENT '昵称',
  `real_name` varchar(5) DEFAULT NULL COMMENT '真实姓名',
  `student_id` varchar(20) DEFAULT NULL COMMENT '学号',
  `phone_number` varchar(11) DEFAULT NULL COMMENT '电话号码',
  `pwd` varchar(40) DEFAULT NULL COMMENT '密码',
  `introduction` varchar(200) COMMENT '个人介绍',
  `academy` varchar(15) DEFAULT NULL COMMENT '学院',
  `major` varchar(15) DEFAULT NULL COMMENT '专业',
  `sex` char COMMENT '性别',
  `create_time` datetime COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------

INSERT INTO `user` VALUES ('1', "小陈", "陈一","1700201801","18888888888","E10ADC3949BA59ABBE56E057F20F883E","无","信息与通信学院","电子信息工程","男","2020-03-04 12:32:52");
INSERT INTO `user` VALUES ('2', "小刘", "刘二","1700201802","18888888888","E10ADC3949BA59ABBE56E057F20F883E","无","信息与通信学院","通信工程","男","2020-03-04 12:33:15");
INSERT INTO `user` VALUES ('3', "小王", "王三","1700201803","18888888888","E10ADC3949BA59ABBE56E057F20F883E","无","信息与通信学院","计算机与科学","男","2020-03-04 12:34:01");

-- ----------------------------
-- Table structure for wushu_culture
-- ----------------------------
DROP TABLE IF EXISTS `wushu_culture`;
CREATE TABLE `wushu_culture` (
  `c_id` tinyint NOT NULL AUTO_INCREMENT,
  `title` varchar(20) DEFAULT NULL COMMENT '标题',
  `content` varchar(200) COMMENT '标题',
  `study_id` tinyint COMMENT '对于的学习Id',
  `click_times` int COMMENT '点击次数',
  `create_time` datetime COMMENT '创建日期',
  
  PRIMARY KEY (`c_id`),
  KEY `study_id` (`study_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wushu_culture
-- ----------------------------

INSERT INTO `wushu_culture` VALUES ('1', "武侠文化", "武侠", 1, 5, "2020-03-04 14:12:34");
INSERT INTO `wushu_culture` VALUES ('2', "武学文化", "武学", 1, 7, "2020-03-04 14:13:52");
INSERT INTO `wushu_culture` VALUES ('3', "武道文化", "武道", 1, 9, "2020-03-04 14:14:12");

-- ----------------------------
-- Table structure for wushu_essence
-- ----------------------------
DROP TABLE IF EXISTS `wushu_essence`;
CREATE TABLE `wushu_essence` (
  `e_id` tinyint NOT NULL AUTO_INCREMENT,
  `title` varchar(20) DEFAULT NULL COMMENT '标题',
  `content` varchar(200) COMMENT '标题',
  `study_id` tinyint COMMENT '对于的学习Id',
  `click_times` int COMMENT '点击次数',
  `create_time` datetime COMMENT '创建日期',
  
  PRIMARY KEY (`e_id`),
  KEY `study_id` (`study_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wushu_essence
-- ----------------------------

INSERT INTO `wushu_essence` VALUES ('1', "武术实战", "实战", 1, 9, "2020-03-04 14:20:12");
INSERT INTO `wushu_essence` VALUES ('2', "武术套路", "套路", 1, 11, "2020-03-04 14:21:02");
INSERT INTO `wushu_essence` VALUES ('3', "武术基本功", "基本功", 1, 4, "2020-03-04 14:22:45");

-- ----------------------------
-- Table structure for wushu_introduction
-- ----------------------------
DROP TABLE IF EXISTS `wushu_introduction`;
CREATE TABLE `wushu_introduction` (
  `i_id` tinyint NOT NULL AUTO_INCREMENT,
  `title` varchar(20) DEFAULT NULL COMMENT '标题',
  `content` varchar(200) COMMENT '标题',
  `study_id` tinyint COMMENT '对于的学习Id',
  `click_times` int COMMENT '点击次数',
  `create_time` datetime COMMENT '创建日期',
  
  PRIMARY KEY (`i_id`),
  KEY `study_id` (`study_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wushu_introduction
-- ----------------------------

INSERT INTO `wushu_introduction` VALUES ('1', "武术起源", "起源", 1, 21, "2020-03-04 16:12:12");
INSERT INTO `wushu_introduction` VALUES ('2', "武术发展", "发展", 1, 5, "2020-03-04 16:14:02");
INSERT INTO `wushu_introduction` VALUES ('3', "近代武术", "近代", 1, 12, "2020-03-04 16:15:23");
INSERT INTO `wushu_introduction` VALUES ('4', "现代武术", "现代", 1, 9, "2020-03-04 16:17:44");
INSERT INTO `wushu_introduction` VALUES ('5', "武术流派", "流派", 1, 15, "2020-03-04 16:18:34");
INSERT INTO `wushu_introduction` VALUES ('6', "武术器械", "器械", 1, 18, "2020-03-04 16:19:51");

-- ----------------------------
-- Table structure for wushu_species
-- ----------------------------
DROP TABLE IF EXISTS `wushu_species`;
CREATE TABLE `wushu_species` (
  `s_id` tinyint NOT NULL AUTO_INCREMENT,
  `title` varchar(20) DEFAULT NULL COMMENT '标题',
  `content` varchar(200) COMMENT '标题',
  `study_id` tinyint COMMENT '对于的学习Id',
  `click_times` int COMMENT '点击次数',
  `create_time` datetime COMMENT '创建日期',
  
  PRIMARY KEY (`s_id`),
  KEY `study_id` (`study_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wushu_species
-- ----------------------------
INSERT INTO `wushu_species` VALUES ('1', "武术拳术", "拳", 1, 15, "2020-03-04 17:12:12");
INSERT INTO `wushu_species` VALUES ('2', "武术防身术", "防身", 1, 8, "2020-03-04 17:14:02");
INSERT INTO `wushu_species` VALUES ('3', "武术腿法", "腿法", 1, 4, "2020-03-04 17:15:23");
INSERT INTO `wushu_species` VALUES ('4', "武术剑术", "剑术", 1, 21, "2020-03-04 17:17:44");
INSERT INTO `wushu_species` VALUES ('5', "武术刀法", "刀法", 1, 12, "2020-03-04 17:18:34");


