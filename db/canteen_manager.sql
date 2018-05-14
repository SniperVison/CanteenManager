/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : 127.0.0.1:3306
 Source Schema         : canteen_manager

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 14/05/2018 20:17:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comsume_info
-- ----------------------------
DROP TABLE IF EXISTS `comsume_info`;
CREATE TABLE `comsume_info`  (
  `id` bigint(20) UNSIGNED NOT NULL,
  `card` bigint(20) NOT NULL COMMENT '一卡通账号',
  `money` decimal(8, 2) NOT NULL COMMENT '消费金额',
  `status` int(11) NOT NULL COMMENT '资金状态,1为消费, 2为存款',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '消费信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comsume_info
-- ----------------------------
INSERT INTO `comsume_info` VALUES (445678224119169024, 201941543225, 120.00, 1, '2018-05-14 20:06:09', '2018-05-14 20:12:05');
INSERT INTO `comsume_info` VALUES (445679802741948416, 201941543225, 60.00, 0, '2018-05-14 20:12:25', '2018-05-14 20:12:25');

-- ----------------------------
-- Table structure for goods_info
-- ----------------------------
DROP TABLE IF EXISTS `goods_info`;
CREATE TABLE `goods_info`  (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `price` decimal(8, 2) NOT NULL COMMENT '单价',
  `stock` int(11) NOT NULL COMMENT '库存',
  `unit` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '单位',
  `shelf_life` int(11) NOT NULL COMMENT '保质期',
  `whole_saler` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '批发商',
  `updator` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '处理人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '粮油杂货类信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_info
-- ----------------------------
INSERT INTO `goods_info` VALUES (445548182634496000, '老干妈', 8.60, 250, '瓶', 180, '新润杂货市场', '周润发', '2018-05-14 11:29:25', '2018-05-14 11:29:24');

-- ----------------------------
-- Table structure for meat_info
-- ----------------------------
DROP TABLE IF EXISTS `meat_info`;
CREATE TABLE `meat_info`  (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `price` decimal(8, 2) NOT NULL COMMENT '单价',
  `stock` int(11) NOT NULL COMMENT '库存',
  `unit` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '单位',
  `shelf_life` int(11) NOT NULL COMMENT '保质期',
  `whole_saler` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '批发商',
  `updator` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '处理人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '蔬菜类信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of meat_info
-- ----------------------------
INSERT INTO `meat_info` VALUES (445204324272832512, '猪肉', 4.60, 600, '600', 2, '芙蓉区肉类批发市场', '赵柳', '2018-05-13 12:43:02', '2018-05-13 12:48:24');

-- ----------------------------
-- Table structure for staff_info
-- ----------------------------
DROP TABLE IF EXISTS `staff_info`;
CREATE TABLE `staff_info`  (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '员工名称',
  `work_number` bigint(20) NOT NULL COMMENT '工号',
  `position` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '工作职位',
  `work_unit` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '工作单位',
  `birthday` date NOT NULL COMMENT '出生年月',
  `induction` date NOT NULL COMMENT '就职时间',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '食堂员工信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of staff_info
-- ----------------------------
INSERT INTO `staff_info` VALUES (445548424687779840, '李三', 11154, '厨师', '金岸一楼食堂', '1994-11-08', '2018-04-28', '2018-05-14 11:30:22', '2018-05-14 11:30:22');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `url` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'url地址',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'url描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('10', '/member/changeSessionStatus.html', '用户Session踢出');
INSERT INTO `sys_permission` VALUES ('11', '/member/forbidUserById.html', '用户激活&禁止');
INSERT INTO `sys_permission` VALUES ('12', '/member/deleteUserById.html', '用户删除');
INSERT INTO `sys_permission` VALUES ('16', '/role/deleteRoleById.html', '角色列表删除');
INSERT INTO `sys_permission` VALUES ('17', '/role/addRole.html', '角色列表添加');
INSERT INTO `sys_permission` VALUES ('18', '/role/index.html', '角色列表');
INSERT INTO `sys_permission` VALUES ('19', '/permission/allocation.html', '权限分配');
INSERT INTO `sys_permission` VALUES ('20', '/role/allocation.html', '角色分配');
INSERT INTO `sys_permission` VALUES ('4', '/permission/index.html', '权限列表');
INSERT INTO `sys_permission` VALUES ('6', '/permission/addPermission.html', '权限添加');
INSERT INTO `sys_permission` VALUES ('7', '/permission/deletePermissionById.html', '权限删除');
INSERT INTO `sys_permission` VALUES ('8', '/member/list.html', '用户列表');
INSERT INTO `sys_permission` VALUES ('9', '/member/online.html', '在线用户');

-- ----------------------------
-- Table structure for sys_permission_init
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission_init`;
CREATE TABLE `sys_permission_init`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '链接地址',
  `permission_init` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '需要具备的权限',
  `sort` int(50) NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_permission_init
-- ----------------------------
INSERT INTO `sys_permission_init` VALUES ('1', '/static/**', 'anon,kickout', 1);
INSERT INTO `sys_permission_init` VALUES ('2', '/ajaxLogin', 'anon,kickout', 2);
INSERT INTO `sys_permission_init` VALUES ('3', '/logout', 'logout,kickout', 3);
INSERT INTO `sys_permission_init` VALUES ('4', '/add', 'perms[权限添加:权限删除],roles[100002],kickout', 4);
INSERT INTO `sys_permission_init` VALUES ('5', '/**', 'user,kickout', 5);
INSERT INTO `sys_permission_init` VALUES ('6', '/getGifCode', 'anon,kickout', 2);
INSERT INTO `sys_permission_init` VALUES ('7', '/kickout', 'anon', 2);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `type` int(11) NOT NULL COMMENT '角色类型',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `description` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  `is_able` tinyint(3) UNSIGNED NULL DEFAULT NULL COMMENT '角色是否可用'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1001', 1, '管理员', '拥有一切权限', 1);
INSERT INTO `sys_role` VALUES ('1002', 0, '普通用户', '可以查询自己的消费记录以及查询共享的网络资源', 1);

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `rid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色ID',
  `pid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(20) UNSIGNED NOT NULL,
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '账号',
  `email` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '邮箱',
  `name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '昵称/名称',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `card` bigint(20) NOT NULL COMMENT '一卡通账号',
  `salt` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '加密密码的盐',
  `status` int(3) NULL DEFAULT NULL COMMENT '用户状态, 默认1正常状态, 2用户被锁定',
  `avatar_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像url',
  `last_login_time` datetime(0) NULL DEFAULT NULL COMMENT '最后登录时间',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `modify_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (445640225864024064, 'vison', 'asdfjhdsakhk@qq.com', NULL, 'da2795ee4abf11f551f8a19fc2fba52e', 201941843223, NULL, 1, NULL, '2018-05-14 19:47:47', '2018-05-14 17:35:09', '2018-05-14 19:47:47');
INSERT INTO `sys_user` VALUES (445648953879298048, 'abc', 'adsfjhklds@163.com', NULL, 'ed252076e8a2bfb5fe76f3546f636808', 201941543225, NULL, 1, NULL, '2018-05-14 20:12:44', '2018-05-14 18:09:50', '2018-05-14 20:12:44');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT '用户角色表主键',
  `uid` bigint(20) UNSIGNED NOT NULL COMMENT '用户id',
  `rid` bigint(20) UNSIGNED NOT NULL COMMENT '角色id',
  `create_time` timestamp(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `modify_time` timestamp(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (445591789903020032, 445591789701693440, 1001, '2018-05-14 14:22:41', '0000-00-00 00:00:00');
INSERT INTO `sys_user_role` VALUES (445629839253176320, 445629838850523136, 1002, '2018-05-14 16:53:53', '0000-00-00 00:00:00');
INSERT INTO `sys_user_role` VALUES (445640226069544960, 445640225864024064, 1001, '2018-05-14 17:35:09', '0000-00-00 00:00:00');
INSERT INTO `sys_user_role` VALUES (445648953933824000, 445648953879298048, 1002, '2018-05-14 18:09:50', '0000-00-00 00:00:00');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` bigint(20) UNSIGNED NOT NULL,
  `user_id` bigint(20) UNSIGNED NOT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '个人简介',
  `phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机',
  `college` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '学院名称',
  `profession` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '专业名称',
  `classes` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '班级名称',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `modify_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户个人信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (444130766285176832, 444130648190353408, NULL, NULL, NULL, NULL, NULL, '2018-05-10 13:37:06', '0000-00-00 00:00:00');

-- ----------------------------
-- Table structure for vegetable_info
-- ----------------------------
DROP TABLE IF EXISTS `vegetable_info`;
CREATE TABLE `vegetable_info`  (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `price` decimal(8, 2) NOT NULL COMMENT '单价',
  `stock` int(11) NOT NULL COMMENT '库存',
  `unit` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '单位',
  `shelf_life` int(11) NOT NULL COMMENT '保质期',
  `whole_saler` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '批发商',
  `updator` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '处理人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '蔬菜类信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vegetable_info
-- ----------------------------
INSERT INTO `vegetable_info` VALUES (444984032254492672, '小白菜', 1.20, 300, '斤', 3, '芙蓉区蔬菜批发市场', '张三', '2018-05-12 22:07:41', '2018-05-12 22:07:40');
INSERT INTO `vegetable_info` VALUES (444996250698252288, '黄瓜', 2.05, 400, '斤', 3, '天心区瓜果批发市场', '李四', '2018-05-12 22:56:14', '2018-05-12 22:56:13');

SET FOREIGN_KEY_CHECKS = 1;
