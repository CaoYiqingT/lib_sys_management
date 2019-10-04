/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.40 : Database - simss
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`simss` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `simss`;

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `ISBN` varchar(20) NOT NULL,
  `bookName` varchar(20) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `bookPrice` float DEFAULT NULL,
  `auditing` tinyint(1) DEFAULT NULL,
  `requirment` int(11) DEFAULT NULL,
  `providing` varchar(4) DEFAULT NULL,
  `semeter` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ISBN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `book` */

insert  into `book`(`ISBN`,`bookName`,`number`,`bookPrice`,`auditing`,`requirment`,`providing`,`semeter`) values ('15468359','概率论与数理统计',45,45.21,1,56,NULL,NULL),('15982356','张宇考研一千题',46,45.32,0,16,NULL,NULL),('23568159','数字图像处理',46,23.56,0,48,NULL,NULL),('26546515','英语',20,20.54,0,20,'0',NULL),('45498711','高等数学上',52,54.21,0,23,'1','2018-2019 春季学期'),('45678932','线性代数',89,32.16,1,51,NULL,'2018-2019 秋季学期'),('46516484','论道 ',20,20,1,30,'1','2018-2019 春季学期'),('46584643','高等数学下',12,52.13,0,25,'1','2018-2019 春季学期'),('48675654','算法概论',45,23.45,1,56,NULL,NULL),('48973265','现代软件工程',56,12.56,0,89,NULL,NULL);

/*Table structure for table `borrowbook` */

DROP TABLE IF EXISTS `borrowbook`;

CREATE TABLE `borrowbook` (
  `borrowID` varchar(20) NOT NULL,
  `studentID` varchar(20) NOT NULL,
  `borrowName` varchar(20) DEFAULT NULL,
  `borrowMoney` int(11) DEFAULT NULL,
  PRIMARY KEY (`borrowID`),
  KEY `FK_student_borrow` (`studentID`),
  CONSTRAINT `FK_student_borrow` FOREIGN KEY (`studentID`) REFERENCES `student` (`studentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `borrowbook` */

insert  into `borrowbook`(`borrowID`,`studentID`,`borrowName`,`borrowMoney`) values ('01','201501','面向对象',10),('02','201501','数据库',20),('03','201501','java',10),('04','201503','高等数学',10),('05','201503','概率论',10),('06','201502','斗破苍穹',5);

/*Table structure for table `dorm` */

DROP TABLE IF EXISTS `dorm`;

CREATE TABLE `dorm` (
  `dormNumber` varchar(20) NOT NULL,
  `dormKind` int(11) DEFAULT NULL,
  `dormPrice` int(11) DEFAULT NULL,
  `isFull` tinyint(1) DEFAULT NULL,
  `sex` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`dormNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `dorm` */

insert  into `dorm`(`dormNumber`,`dormKind`,`dormPrice`,`isFull`,`sex`) values ('0000',8,0,1,'男宿'),('11-1-901',4,1200,0,'女宿'),('11-1-902',4,1200,0,'女宿'),('11-1-903',8,2000,0,'女宿'),('11-1-904',4,1200,0,'女宿'),('11-1-905',4,1200,0,'女宿'),('11-1-906',4,1200,0,'女宿'),('11-2-801',4,1200,0,'男宿'),('11-2-802',8,2000,0,'男宿'),('11-2-803',4,1200,0,'男宿'),('11-2-901',8,2000,0,'男宿'),('11-2-902',8,2000,0,'男宿'),('11-2-903',4,1200,0,'男宿'),('11-2-904',4,1200,0,'男宿'),('11-2-905',4,1200,0,'男宿'),('11-2-906',8,2000,0,'男宿'),('11-2-907',8,2000,0,'男宿'),('11-2-908',4,1200,0,'男宿'),('11-2-909',8,2000,0,'男宿'),('waitForSet',0,0,1,'男宿');

/*Table structure for table `dormapplication` */

DROP TABLE IF EXISTS `dormapplication`;

CREATE TABLE `dormapplication` (
  `applyNumber` varchar(30) NOT NULL,
  `studentID` varchar(20) NOT NULL,
  `applyKind` varchar(10) DEFAULT NULL,
  `other` varchar(60) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `date` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`applyNumber`),
  KEY `FK_stuent_dormApplication` (`studentID`),
  CONSTRAINT `FK_stuent_dormApplication` FOREIGN KEY (`studentID`) REFERENCES `student` (`studentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `dormapplication` */

insert  into `dormapplication`(`applyNumber`,`studentID`,`applyKind`,`other`,`status`,`date`) values ('20180824040724','201503','维修','宿舍水管漏水',1,'2018-08-24'),('20180824040943','201503','调换','申请调换到11-2-903',1,'2018-08-24'),('20180824041413','201503','维修','床板开裂',1,'2018-08-24'),('20180824062217','201503','维修','座椅问题',1,'2018-08-24'),('20180824063648','201503','调换','申请与1669宿舍调换',0,'2018-08-24'),('20180824063805','201503','调换','示例数据',0,'2018-08-24'),('20180824063911','201503','调换','示例数据',0,'2018-08-24'),('20180824063953','201503','维修','示例数据',0,'2018-08-24'),('20180824064030','201503','调换','示例数据',0,'2018-08-24'),('20180825080011','201503','维修','示例数据',0,'2018-08-25'),('20180830065625','201503','维修','宿舍漏水',0,'2018-08-30');

/*Table structure for table `money` */

DROP TABLE IF EXISTS `money`;

CREATE TABLE `money` (
  `payNumber` varchar(20) NOT NULL,
  `studentID` varchar(20) NOT NULL,
  `payPrice` int(11) DEFAULT NULL,
  `isPay` tinyint(1) DEFAULT NULL,
  `deadline` date DEFAULT NULL,
  `payDate` date DEFAULT NULL,
  `payKind` varchar(20) DEFAULT NULL,
  `studentName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`payNumber`),
  KEY `FK_student_money` (`studentID`),
  CONSTRAINT `FK_student_money` FOREIGN KEY (`studentID`) REFERENCES `student` (`studentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `money` */

insert  into `money`(`payNumber`,`studentID`,`payPrice`,`isPay`,`deadline`,`payDate`,`payKind`,`studentName`) values ('20180830011621','201502',6000,1,'2018-09-30','2018-08-30','书费','李四'),('20180830011735','201502',6000,1,'2018-08-24','2018-08-30','学费','李四'),('201808300120590','201502',2000,1,'2018-08-01','2018-08-30','住宿费','李四'),('201808300122290','201501',1000,1,'2018-08-31','2018-08-30','杂费','张三'),('201808300122291','201502',1000,1,'2018-08-31','2018-08-30','杂费','李四'),('201808300122292','201503',1000,1,'2018-08-31','2018-08-30','杂费','王二'),('201808300122293','201504',1000,0,'2018-08-31',NULL,'杂费','麻子'),('201808300124530','2018140000',2000,1,'2018-08-16','2018-08-30','test','王一博'),('201808300124531','2018140001',2000,0,'2018-08-16',NULL,'test','蔡文'),('201808300124532','2018140002',2000,0,'2018-08-16',NULL,'test','后羿'),('201808300124533','2018140003',2000,0,'2018-08-16',NULL,'test','蔡文姬'),('201808300124534','2018140004',2000,0,'2018-08-16',NULL,'test','鲁班'),('201808300124535','2018140005',2000,0,'2018-08-16',NULL,'test','项羽'),('201808300130140','2018140001',20000,0,'2018-08-16',NULL,'test2','蔡文'),('201808300130141','2018140002',20000,0,'2018-08-16',NULL,'test2','后羿'),('201808300130142','2018140003',20000,0,'2018-08-16',NULL,'test2','蔡文姬'),('201808300130143','2018140004',20000,0,'2018-08-16',NULL,'test2','鲁班'),('20180830125856','201503',13000,1,'2018-09-30','2018-08-30','学费','王二'),('201808301258562','201503',5000,0,'2018-09-30',NULL,'学费','王二'),('201808301258565','201503',2000,0,'2018-09-30',NULL,'书费','王二');

/*Table structure for table `notice` */

DROP TABLE IF EXISTS `notice`;

CREATE TABLE `notice` (
  `noticeID` varchar(20) NOT NULL,
  `context` text,
  PRIMARY KEY (`noticeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `notice` */

insert  into `notice`(`noticeID`,`context`) values ('1501','<div>公告：各学院及相关教学单位：</div><div>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 2018～2019学年秋季学期第三周至第四周，将对2017～2018学年春季学期开设的课程（部分不安排补考的课程除外）安排补考，现将有关事项通知如下：</div><div>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 1.根据规定，在校学生（2015级以后）不需要学生个人报名补考，系统将自动生成补考学生应考名单，补考仍未通过的课程只能通过重修且考核合格后取得相应学分；在校学生（2013和2014级延长学制）可通过报名补考或通过重修方式参与课程考核，考核合格后取得相应学分，要密切留意、及时确认和反馈课程编码更换等原因造成的补考课程信息不全的情况，以免造成考试科目遗漏。</div><div>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 2.结业生返校补考：请在9月3日前到所在学院报名（报名信息包括：学号、姓名、课程号、课程名称、学分），学院整理汇总后9月4日下班前交教务处学生注册中心。</div><div>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 3.在校学生8月27日至9月3日期间，务必要认真核对补考报名情况，以免造成考试科目遗漏。9月6日（第一周周四）开课学院本科教学管理办公室打印报名名单，提交给相关课程教学负责人，按照实际报名人数印刷试卷。学生注册中心于9月6日（第一周周四）安排补考课程的时间地点。正式考试时间从9月17日（第三周周一）开始。已报名学生按照考试日程安排表参加考试，学生可在新教务系统中查询自己报名的考试安排情况。</div><div>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 4.补考结束后，开课学院教务员指定老师录入补考成绩，各开课学院确保在10月10日之前完成补考成绩录入工作，并于10月11日前将纸质成绩单送至学生所在学院，并按照相应要求完成成绩单和考试材料的归档工作。</div><div>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 教务处&nbsp;</div><div>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;2018年7月12日</div>');

/*Table structure for table `project` */

DROP TABLE IF EXISTS `project`;

CREATE TABLE `project` (
  `projectKind` varchar(10) NOT NULL,
  `ISBN` varchar(20) NOT NULL,
  PRIMARY KEY (`projectKind`,`ISBN`),
  KEY `FK_student_book2` (`ISBN`),
  CONSTRAINT `FK_student_book` FOREIGN KEY (`projectKind`) REFERENCES `student` (`studentID`),
  CONSTRAINT `FK_student_book2` FOREIGN KEY (`ISBN`) REFERENCES `book` (`ISBN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `project` */

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `studentID` varchar(30) NOT NULL,
  `dormNumber` varchar(20) NOT NULL,
  `studentName` varchar(20) DEFAULT NULL,
  `sex` varchar(4) DEFAULT NULL,
  `identifyID` varchar(20) NOT NULL,
  `staySchool` tinyint(1) DEFAULT NULL,
  `projectKind` varchar(10) DEFAULT NULL,
  `isAdmin` tinyint(1) DEFAULT NULL,
  `leaveDate` varchar(20) DEFAULT NULL,
  `classID` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`studentID`),
  KEY `FK_student_dorm` (`dormNumber`),
  CONSTRAINT `FK_student_dorm` FOREIGN KEY (`dormNumber`) REFERENCES `dorm` (`dormNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`studentID`,`dormNumber`,`studentName`,`sex`,`identifyID`,`staySchool`,`projectKind`,`isAdmin`,`leaveDate`,`classID`) values ('200001','0000','张志君','女','123456',1,'A',1,'2018-8-9',NULL),('201501','0000','张伟','男','1234567',0,'A',0,'2018-8-9','waitForSet'),('201502','0000','王伟','男','1234568',0,'A',0,'2018-8-9','waitForSet'),('201503','0000','王芳','女','12345689',0,'B',0,'2018-8-9','waitForSet'),('201504','0000','王秀英','女','12345690',0,'B',0,'2018-8-10','waitForSet'),('2018140000','0000','王一博','男','12345671',1,'A',1,'2018-8-9',NULL),('2018140001','0000','李伟','男','45454',0,'A',0,'2018-8-9','waitForSet'),('2018140002','0000','刘伟','男','5465123',0,'C',0,'2018-8-9','waitForSet'),('2018140003','0000','李娜','女','4564646',0,'C',0,'2018-8-9','waitForSet'),('2018140004','0000','周东','男','844593682',0,'A',0,'2018-8-9','waitForSet'),('2018140005','0000','王晨','男','134698',0,'B',0,'2018-8-9','waitForSet'),('2018170001','11-1-901','刘丹','女','5849845',0,'D',0,'2018-8-9','18001'),('2018170002','11-1-901','安阳','女','48748476',0,'A',0,'2019-8-30','18002'),('2018170003','11-1-901','张洁','女','87684548',0,'A',0,'2019-8-30','18001'),('2018170004','11-1-901','李艳','女','4646474',0,'A',0,'2019-8-30','18002'),('2018170005','11-1-902','刘悦','女','7854345',0,'A',0,'2019-8-30','18001'),('2018170006','11-1-902','南岚','女','78786768',0,'A',0,'2019-8-30','18002'),('2018170007','11-1-902','郑蕾','女','7876874',0,'A',0,'2019-8-30','18001'),('2018170008','11-1-902','范琳','女','47848145',0,'A',0,'2019-8-30','18002'),('2018170009','11-1-903','芳菲','女','454546564',0,'A',0,'2019-8-30','18001'),('2018170010','11-1-903','孙菲','女','4646443',0,'A',0,'2019-8-30','18002'),('2018170011','11-2-801','海荣','男','8768453',0,'A',0,'2019-8-30','18001'),('2018170012','11-2-801','昆明','男','7154165',0,'A',0,'2019-8-30','18002'),('2018170013','11-2-801','吉星','男','1561653',0,'A',0,'2019-8-30','18001'),('2018170014','11-2-801','振国','男','156136',0,'A',0,'2019-8-30','18002'),('2018170015','11-2-802','晗日','男','613485132',0,'A',0,'2019-8-30','18001'),('2018170016','11-2-802','星腾','男','6131652',0,'A',0,'2019-8-30','18002'),('2018170017','11-2-802','昊然','男','498615',0,'A',0,'2019-8-30','18001'),('2018170018','11-2-802','浩阔','男','65165456',0,'A',0,'2019-8-30','18002'),('2018170019','11-2-802','起运','男','631244653',0,'A',0,'2019-8-30','18001'),('2018170020','11-2-802','智杰','男','6513156',0,'A',0,'2019-8-30','18002'),('2018170021','11-2-802','星爵','男','4621513',0,'A',0,'2019-8-30','18001'),('2018170022','11-2-802','昆纬','男','465135',0,'A',0,'2019-8-30','18002'),('2018170023','11-2-803','耘豪','男','4681285',0,'A',0,'2019-8-30','18001'),('2018170024','11-2-803','永昌','男','5132135',0,'A',0,'2019-8-30','18002'),('2018170025','11-2-803','学智','男','513213',0,'A',0,'2019-8-30','18001'),('2018170026','11-2-803','昊嘉','男','523165165',0,'A',0,'2019-8-30','18002'),('2018170027','11-2-901','宣朗','男','4612313',0,'B',0,'2019-8-30','18001'),('2018170028','11-2-901','昆鹏','男','531635',0,'D',0,'2019-8-30','18002'),('2018170029','11-2-901','智宇','男','46813212',0,'A',0,'2019-8-30','18001'),('2018170030','11-2-901','曜文','男','4651323',0,'A',0,'2019-8-30','18002'),('2018170031','11-2-901','俊晖','男','7681521',0,'A',0,'2019-8-30','18001'),('2018170032','11-2-901','景行','男','461351',0,'A',0,'2019-8-30','18002'),('2018170033','11-2-901','德曜','男','5413165',0,'A',0,'2019-8-30','18001'),('2018170034','11-2-901','德明','男','3135115',0,'A',0,'2019-8-30','18002'),('2018170035','11-2-902','文景','男','4651355684',0,'A',0,'2019-8-30','18001'),('2018170036','11-2-902','王博','男','93511653',0,'A',0,'2019-8-30','18002');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
