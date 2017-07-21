/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.15-log : Database - mybatis_test
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mybatis_test` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `mybatis_test`;

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID，自增长ID',
  `user_uuid` varchar(36) NOT NULL COMMENT 'UUID值',
  `login_name` varchar(32) NOT NULL COMMENT '登录账号',
  `email` varchar(50) NOT NULL COMMENT '注册邮箱地址',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `user_name` varchar(32) DEFAULT NULL COMMENT '昵称',
  `salt` varchar(20) NOT NULL COMMENT '登录密码加的盐值',
  `available_enum` char(1) NOT NULL DEFAULT '0' COMMENT '是否可用,0：可用，1不可用',
  `delete_enum` char(1) NOT NULL DEFAULT '0' COMMENT '是否删除,0：未删除，1已删除',
  `request_ip` varchar(40) DEFAULT NULL COMMENT '注册时候的请求IP',
  `request_mac` varchar(30) DEFAULT NULL COMMENT '注册时候的请求的机子MAC地址',
  `request_user_agent` varchar(200) DEFAULT NULL COMMENT '注册时候的请求user agent',
  `avatar_image_path` varchar(100) DEFAULT NULL COMMENT '个人头像图片完整目录路径（不包含域名、端口、工程名）',
  `self_introduction` varchar(200) DEFAULT NULL COMMENT '自我介绍',
  `sex_enum` char(1) DEFAULT '0' COMMENT '性别：0保密，1男性，2女性',
  `user_birthday` datetime DEFAULT NULL COMMENT '用户生日（出生日期）',
  `create_datetime` datetime NOT NULL COMMENT '创建时间',
  `lock_version` bigint(20) DEFAULT '0' COMMENT 'JPA乐观锁标识字段，必须有值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`user_uuid`,`login_name`,`email`,`password`,`user_name`,`salt`,`available_enum`,`delete_enum`,`request_ip`,`request_mac`,`request_user_agent`,`avatar_image_path`,`self_introduction`,`sex_enum`,`user_birthday`,`create_datetime`,`lock_version`) values (1,'a3006a53f2064ce8adf62dc3a1a2ce72','admin','judas.n@qq.com','353c87e543a41339dfbc705bc1228d0e','admin','T6X2ea','0','0',NULL,NULL,NULL,NULL,NULL,'0',NULL,'2016-06-20 11:49:53',3);
insert  into `sys_user`(`id`,`user_uuid`,`login_name`,`email`,`password`,`user_name`,`salt`,`available_enum`,`delete_enum`,`request_ip`,`request_mac`,`request_user_agent`,`avatar_image_path`,`self_introduction`,`sex_enum`,`user_birthday`,`create_datetime`,`lock_version`) values (2,'e1344b0674e94dbf9bd3cbaa1409d7fe','judasn','363379444@qq.com','9092c370cd64cc58ba5c4e064c1388c8','judasn','X7Ao1K','0','0','0:0:0:0:0:0:0:1',NULL,'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.110 Safari/537.36',NULL,NULL,'0',NULL,'2017-01-05 14:59:05',2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
