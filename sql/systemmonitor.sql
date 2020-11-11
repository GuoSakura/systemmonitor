/*
 Navicat Premium Data Transfer

 Source Server         : dev
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : 106.13.47.59:3306
 Source Schema         : systemmonitor

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 26/08/2019 11:17:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_monitor
-- ----------------------------
DROP TABLE IF EXISTS `sys_monitor`;
CREATE TABLE `sys_monitor` (
  `id` varchar(32) NOT NULL COMMENT 'id',
  `operat_system` varchar(32) DEFAULT NULL COMMENT '操作系统',
  `total_memory` bigint(20) DEFAULT NULL COMMENT '总内存',
  `used_memory` bigint(20) DEFAULT NULL COMMENT '使用内存',
  `left_memory` bigint(20) DEFAULT NULL COMMENT '剩余内存',
  `process_num` int(2) DEFAULT NULL COMMENT '处理器个数',
  `cpu_used` varchar(5) DEFAULT NULL COMMENT 'cpu占用率',
  `cpu_freed` varchar(5) DEFAULT NULL COMMENT 'cpu空闲率',
  `disk` varchar(200) DEFAULT NULL,
  `create_date` date DEFAULT NULL COMMENT '统计日期',
  `create_time` time DEFAULT NULL COMMENT '统计时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统监控表';

SET FOREIGN_KEY_CHECKS = 1;
