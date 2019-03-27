/*
Navicat MySQL Data Transfer

Source Server         : localhost-mysql-1
Source Server Version : 50135
Source Host           : localhost:3306
Source Database       : pm

Target Server Type    : MYSQL
Target Server Version : 50135
File Encoding         : 65001

Date: 2017-05-18 10:49:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `account`
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
`id`  int(11) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
`account`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号' ,
`password`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码' ,
`head`  text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '头像' ,
`createTime`  bigint(20) NOT NULL COMMENT '创建时间' ,
`updateTime`  bigint(20) NOT NULL COMMENT '更新时间' ,
`state`  varchar(52) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态' ,
`creator`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='登录人力资源管理系统账号'
AUTO_INCREMENT=2

;

-- ----------------------------
-- Table structure for `account_authority`
-- ----------------------------
DROP TABLE IF EXISTS `account_authority`;
CREATE TABLE `account_authority` (
`id`  int(11) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
`accountId`  int(11) NOT NULL COMMENT '账号ID' ,
`authorityId`  int(11) NOT NULL COMMENT '权限ID' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='账号权限关系表'
AUTO_INCREMENT=114

;

-- ----------------------------
-- Table structure for `apply`
-- ----------------------------
DROP TABLE IF EXISTS `apply`;
CREATE TABLE `apply` (
`id`  int(11) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
`applyId`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '应聘编号' ,
`applyName`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '应聘人姓名' ,
`applySex`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '应聘人性别' ,
`applyBirthday`  bigint(20) NOT NULL COMMENT '应聘人出生日期' ,
`applyPhone`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '应聘人联系电话' ,
`applyEmail`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '应聘人邮箱地址' ,
`applyDepartment`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '应聘部门' ,
`applyJob`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '应聘职位' ,
`state`  varchar(52) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态' ,
`createTime`  bigint(20) NOT NULL COMMENT '创建时间' ,
`updateTime`  bigint(20) NOT NULL COMMENT '更新时间' ,
`creator`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作人' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='应聘记录'
AUTO_INCREMENT=6

;

-- ----------------------------
-- Table structure for `authority`
-- ----------------------------
DROP TABLE IF EXISTS `authority`;
CREATE TABLE `authority` (
`id`  int(11) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
`authorityName`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限名称' ,
`authorityCode`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限代码' ,
`authorityUrl`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限URL' ,
`defaultAuthority`  bit(1) NOT NULL ,
`accessAuthentication`  bit(1) NOT NULL ,
`state`  varchar(52) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态' ,
`createTime`  bigint(20) NOT NULL COMMENT '创建时间' ,
`updateTime`  bigint(20) NOT NULL COMMENT '更新时间' ,
`creator`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='权限'
AUTO_INCREMENT=114

;

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
`id`  int(11) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
`departmentName`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门名称' ,
`fixedNumber`  int(11) NOT NULL COMMENT '部门固定人数，预定需要多少人' ,
`actualNumber`  int(11) NOT NULL COMMENT '部门实际有多少人' ,
`state`  varchar(52) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态' ,
`createTime`  bigint(20) NOT NULL COMMENT '创建时间' ,
`updateTime`  bigint(20) NOT NULL COMMENT '更新时间' ,
`creator`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='部门'
AUTO_INCREMENT=12

;

-- ----------------------------
-- Table structure for `employee`
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
`id`  int(11) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
`employeeName`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工姓名' ,
`employeeNumber`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工编号(最大32位字符串组成),唯一性' ,
`employeePhoto`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工照片(存放的是员工照片的相对路径)' ,
`employeeSex`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工性别(男或女)' ,
`employeeBirthday`  bigint(20) NULL DEFAULT NULL COMMENT '员工生日' ,
`employeePhone`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工手机' ,
`employeeEmail`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工邮箱' ,
`employeeEducation`  varchar(52) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工学历' ,
`departmentName`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工部门' ,
`employeeJob`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工职务' ,
`gradeGrade`  varchar(52) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职称等级' ,
`basicPay`  int(11) NOT NULL DEFAULT 0 ,
`inductionTime`  bigint(20) NOT NULL COMMENT '入职时间' ,
`state`  varchar(52) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态' ,
`createTime`  bigint(20) NOT NULL COMMENT '创建时间' ,
`updateTime`  bigint(20) NOT NULL COMMENT '更新时间' ,
`creator`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='员工'
AUTO_INCREMENT=10

;

-- ----------------------------
-- Table structure for `employee_attendance`
-- ----------------------------
DROP TABLE IF EXISTS `employee_attendance`;
CREATE TABLE `employee_attendance` (
`id`  int(11) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
`attendanceNumber`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '考勤编号' ,
`departmentName`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门名称' ,
`employeeName`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工姓名' ,
`attendanceType`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '考勤类型' ,
`attendanceStartTime`  bigint(20) NOT NULL COMMENT '考勤开始时间' ,
`attendanceEndTime`  bigint(20) NOT NULL COMMENT '考勤结束时间' ,
`sanctionMoney`  int(11) NOT NULL COMMENT '奖罚金额' ,
`attendanceCause`  text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '考勤原因' ,
`state`  varchar(52) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态' ,
`createTime`  bigint(20) NOT NULL COMMENT '创建时间' ,
`updateTime`  bigint(20) NOT NULL COMMENT '更新时间' ,
`creator`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作人' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='员工考勤'
AUTO_INCREMENT=62

;

-- ----------------------------
-- Table structure for `employee_contract`
-- ----------------------------
DROP TABLE IF EXISTS `employee_contract`;
CREATE TABLE `employee_contract` (
`id`  int(11) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
`contractContent`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '合同内容' ,
`contractNumber`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '合同编号' ,
`employeeId`  int(11) NOT NULL COMMENT '员工ID' ,
`employeeName`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`contractStartTime`  bigint(20) NOT NULL COMMENT '合同开始日期' ,
`contractEndTime`  bigint(20) NOT NULL COMMENT '合同结束日期' ,
`contractRemarks`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '合同备注' ,
`state`  varchar(52) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态' ,
`createTime`  bigint(20) NOT NULL COMMENT '创建时间' ,
`updateTime`  bigint(20) NOT NULL COMMENT '更新时间' ,
`creator`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作人' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='员工合同'
AUTO_INCREMENT=7

;

-- ----------------------------
-- Table structure for `employee_files`
-- ----------------------------
DROP TABLE IF EXISTS `employee_files`;
CREATE TABLE `employee_files` (
`id`  int(11) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
`archivesNumber`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '档案编号' ,
`archivesName`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '档案名称' ,
`archivesContent`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '档案内容' ,
`archivesRemarks`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '档案备注' ,
`archivesSummary`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '档案摘要' ,
`employeeId`  int(11) NOT NULL COMMENT '员工ID' ,
`employeeName`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`state`  varchar(52) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态' ,
`createTime`  bigint(20) NOT NULL COMMENT '创建时间' ,
`updateTime`  bigint(20) NOT NULL COMMENT '更新时间' ,
`creator`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作人' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='员工档案'
AUTO_INCREMENT=5

;

-- ----------------------------
-- Table structure for `employee_pay`
-- ----------------------------
DROP TABLE IF EXISTS `employee_pay`;
CREATE TABLE `employee_pay` (
`id`  int(11) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
`employeeId`  int(11) NOT NULL COMMENT '员工ID' ,
`employeeName`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工姓名' ,
`basePay`  int(11) NOT NULL COMMENT '基本工资' ,
`meritPay`  int(11) NOT NULL COMMENT '绩效工资' ,
`bonus`  int(11) NOT NULL COMMENT '奖金' ,
`fine`  int(11) NOT NULL COMMENT '罚款' ,
`pay`  int(11) NOT NULL COMMENT '薪酬' ,
`giveTime`  bigint(20) NOT NULL COMMENT '获取时间' ,
`createTime`  bigint(20) NOT NULL COMMENT '创建时间' ,
`updateTime`  bigint(20) NOT NULL COMMENT '更新时间' ,
`creator`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作人' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='员工薪酬记录'
AUTO_INCREMENT=721

;

-- ----------------------------
-- Table structure for `employee_training`
-- ----------------------------
DROP TABLE IF EXISTS `employee_training`;
CREATE TABLE `employee_training` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`employeeId`  int(11) NOT NULL COMMENT '员工ID' ,
`employeeName`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工姓名' ,
`trainId`  int(11) NOT NULL COMMENT '培训项目ID' ,
`projectName`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '培训项目名称' ,
`trainingType`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '培训类型:岗前培训,定期培训' ,
`trainingStartTime`  bigint(20) NOT NULL COMMENT '培训开始时间' ,
`trainingEndTime`  bigint(20) NOT NULL COMMENT '培训结束时间' ,
`trainingResult`  text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '培训结果' ,
`state`  varchar(52) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态' ,
`createTime`  bigint(20) NOT NULL COMMENT '创建时间' ,
`updateTime`  bigint(20) NOT NULL COMMENT '更新时间' ,
`creator`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作人' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='员工培训记录'
AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `employee_transfer`
-- ----------------------------
DROP TABLE IF EXISTS `employee_transfer`;
CREATE TABLE `employee_transfer` (
`id`  int(11) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
`employeeId`  int(11) NOT NULL COMMENT '员工ID' ,
`employeeName`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工名字' ,
`originalDepartment`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '原部门' ,
`originalJob`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '原职位' ,
`newDepartment`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '新部门' ,
`newJob`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '新职位' ,
`transferTime`  bigint(20) NOT NULL COMMENT '调动时间' ,
`transferCause`  text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '调动原因' ,
`state`  varchar(52) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态' ,
`createTime`  bigint(20) NOT NULL COMMENT '创建时间' ,
`updateTime`  bigint(20) NOT NULL COMMENT '更新时间' ,
`creator`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作人' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='员工调动记录'
AUTO_INCREMENT=14

;

-- ----------------------------
-- Table structure for `recruitment`
-- ----------------------------
DROP TABLE IF EXISTS `recruitment`;
CREATE TABLE `recruitment` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`recruitmentDeparment`  char(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '招聘部门' ,
`recruitmentJob`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '招聘职位' ,
`jobRequirements`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '任职要求' ,
`jobContent`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工作内容' ,
`recruitmentNumber`  int(11) NOT NULL COMMENT '招聘人数' ,
`minimumEducation`  varchar(52) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学历要求' ,
`recruitmentAgency`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '招聘公司' ,
`companyAddress`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公司地址' ,
`workingProperty`  varchar(52) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工作性质' ,
`recruitmentState`  varchar(52) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '招聘状态' ,
`state`  varchar(52) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态' ,
`createTime`  bigint(20) NOT NULL COMMENT '创建时间' ,
`updateTime`  bigint(20) NOT NULL COMMENT '更新时间' ,
`creator`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作人' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='招聘'
AUTO_INCREMENT=5

;

-- ----------------------------
-- Table structure for `training_project`
-- ----------------------------
DROP TABLE IF EXISTS `training_project`;
CREATE TABLE `training_project` (
`id`  int(11) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
`projectName`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '培训项目' ,
`trainingContent`  text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '培训内容' ,
`trainingAddress`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '培训地址' ,
`trainingTime`  bigint(20) NOT NULL COMMENT '培训时间' ,
`state`  varchar(52) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态' ,
`createTime`  bigint(20) NOT NULL COMMENT '创建时间' ,
`updateTime`  bigint(20) NOT NULL COMMENT '更新时间' ,
`creator`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作人' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='培训项目'
AUTO_INCREMENT=9

;

-- ----------------------------
-- Auto increment value for `account`
-- ----------------------------
ALTER TABLE `account` AUTO_INCREMENT=2;

-- ----------------------------
-- Auto increment value for `account_authority`
-- ----------------------------
ALTER TABLE `account_authority` AUTO_INCREMENT=114;

-- ----------------------------
-- Auto increment value for `apply`
-- ----------------------------
ALTER TABLE `apply` AUTO_INCREMENT=6;

-- ----------------------------
-- Auto increment value for `authority`
-- ----------------------------
ALTER TABLE `authority` AUTO_INCREMENT=114;

-- ----------------------------
-- Auto increment value for `department`
-- ----------------------------
ALTER TABLE `department` AUTO_INCREMENT=12;

-- ----------------------------
-- Auto increment value for `employee`
-- ----------------------------
ALTER TABLE `employee` AUTO_INCREMENT=10;

-- ----------------------------
-- Auto increment value for `employee_attendance`
-- ----------------------------
ALTER TABLE `employee_attendance` AUTO_INCREMENT=62;

-- ----------------------------
-- Auto increment value for `employee_contract`
-- ----------------------------
ALTER TABLE `employee_contract` AUTO_INCREMENT=7;

-- ----------------------------
-- Auto increment value for `employee_files`
-- ----------------------------
ALTER TABLE `employee_files` AUTO_INCREMENT=5;

-- ----------------------------
-- Auto increment value for `employee_pay`
-- ----------------------------
ALTER TABLE `employee_pay` AUTO_INCREMENT=721;

-- ----------------------------
-- Auto increment value for `employee_training`
-- ----------------------------
ALTER TABLE `employee_training` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `employee_transfer`
-- ----------------------------
ALTER TABLE `employee_transfer` AUTO_INCREMENT=14;

-- ----------------------------
-- Auto increment value for `recruitment`
-- ----------------------------
ALTER TABLE `recruitment` AUTO_INCREMENT=5;

-- ----------------------------
-- Auto increment value for `training_project`
-- ----------------------------
ALTER TABLE `training_project` AUTO_INCREMENT=9;
