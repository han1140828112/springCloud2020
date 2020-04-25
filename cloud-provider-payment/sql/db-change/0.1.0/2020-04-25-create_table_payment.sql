-- 2020-04-25 开发已执行

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for payment
-- ----------------------------
DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
  `id` bigint(200) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `serial` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of payment
-- ----------------------------
BEGIN;
INSERT INTO `payment` VALUES (1, '123123');
INSERT INTO `payment` VALUES (2, '456456');
INSERT INTO `payment` VALUES (3, '789789');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

