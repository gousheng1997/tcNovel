-- MySQL dump 10.13  Distrib 5.6.43, for Win64 (x86_64)
--
-- Host: localhost    Database: novel
-- ------------------------------------------------------
-- Server version	5.6.43

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) DEFAULT NULL,
  `userPw` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'admin','123'),(2,'oy','123');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL,
  `kefang_id` int(11) DEFAULT NULL,
  `content` varchar(50) DEFAULT NULL,
  `shijian` varchar(50) DEFAULT NULL,
  `user_id` int(11) unsigned zerofill DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,6,'不错。很干净。环境也好','2019-05-12 10 14:11:23',00000000000),(2,3,'<p>222222222222</p>','2019-5-11 11:47:22',00000000000),(3,3,'<p>很好。环境不错</p>','2019-5-16 12:58:15',00000000000),(4,4,'不错，就是太贵了','2019-3-20 12:53:05',00000000000),(5,5,'太好了','2019-3-20 12:53:46',00000000000),(6,7,'真好！','2019-3-20 12:54:24',00000000000),(7,11,'好啊','2019-4-13 20:02:40',00000000000),(9,21,'<p>11111</p>','2019-4-15 16:09:40',00000000000),(10,3,'1111111','2019-4-15 17:08:42',00000000000),(11,3,'wwwww','2019-4-15 17:09:05',00000000000),(13,6,'<p>123</p>','2019-4-15 17:15:26',00000000000),(14,5,'<p>范德萨发的</p>','2019-3-29 23:02:42',00000000000),(15,3,'???','2019-4-8 10:19:10',00000000000),(16,6,'请输入内容2222','2019-4-23 17:18:22',00000000000),(18,4,'请输入内容啊啊啊啊啊','2019-4-23 19:24:38',NULL),(19,3,'好nm','2019-4-23 20:11:35',NULL);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `novel`
--

DROP TABLE IF EXISTS `novel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `novel` (
  `novel_id` int(11) NOT NULL AUTO_INCREMENT,
  `novel_name` varchar(50) DEFAULT NULL,
  `novel_miaoshu` text,
  `novel_pic` varchar(100) DEFAULT NULL,
  `novel_yanse` varchar(50) DEFAULT NULL,
  `novel_like_num` int(11) DEFAULT NULL,
  `novel_recommend_weight` int(11) DEFAULT NULL,
  `novel_isrecommend` varchar(50) DEFAULT NULL,
  `novel_catelog_id` int(11) DEFAULT NULL,
  `novel_kucun` varchar(11) DEFAULT NULL,
  `novel_Del` varchar(50) DEFAULT NULL,
  `novel_author` varchar(50) DEFAULT NULL,
  `novel_tejia` int(11) DEFAULT NULL,
  PRIMARY KEY (`novel_id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `novel`
--

LOCK TABLES `novel` WRITE;
/*!40000 ALTER TABLE `novel` DISABLE KEYS */;
INSERT INTO `novel` VALUES (1,'疯巫妖的实验日志','拜托，这位先生，你读书读傻了是不？\r\n不过是「小小的」碰了一下，\r\n你说什么负责啊？\r\n江湖儿女是不拘小节滴！\r\n等一下？\r\n老哥抓她回去嫁人？\r\n还是个虐待狂？\r\n得，这位先生，就你了，赶快负责吧！\r\n虽然穷了点，但他说会尽力赚钱的是不？\r\n虽然不会武功，但他认真努力干活是不？\r\n正好，她也不想嫁个江湖人。\r\n可惜，她正和穷夫君好好的种田过日子，\r\n老哥就把她捉回去了。\r\n停停停——\r\n叫她夫君去闯江湖？\r\n屁啦！\r\n她那个木头夫君什么武功也不会，穷的叮当乱响，\r\n闯个屁江湖啦！\r\n哎哎哎？\r\n那个烂木头真的去了？','/upload/1394096685175.jpg',NULL,50,0,'yes',9,'19','no','愤怒的松鼠',NULL),(2,'鬼喊抓鬼','表面上是杂乱无章的段子拼凑起来的科普文\r\n\r\n实际上是暗地里讽刺别人的百合文\r\n\r\n\r\n每个时代有每个时代的难关，而现代人的难关之一就是各种心理疾病。\r\n人一生当中心理疾病有两个高发期，一个是青春期，一个是中年期。\r\n从网络，贴吧，QQ群盛行之后，网络上也涌现了许多性质迥异，参差不齐的心理疾病交友群。\r\n2016年某个心理疾病野鸡群里，大家互相用头像和签名区分彼此的年龄段，用表情包来确认彼此的三观。\r\n直到某天线上聊天不足以慰藉心灵时，而恰好大家都是一个大学的新生时，故事就开始了。\r\n表面上是杂乱无章的段子拼凑起来的科普文\r\n\r\n实际上是暗地里讽刺别人的百合文\r\n\r\n\r\n每个时代有每个时代的难关，而现代人的难关之一就是各种心理疾病。\r\n人一生当中心理疾病有两个高发期，一个是青春期，一个是中年期。\r\n从网络，贴吧，QQ群盛行之后，网络上也涌现了许多性质迥异，参差不齐的心理疾病交友群。\r\n2016年某个心理疾病野鸡群里，大家互相用头像和签名区分彼此的年龄段，用表情包来确认彼此的三观。\r\n直到某天线上聊天不足以慰藉心灵时，而恰好大家都是一个大学的新生时，故事就开始了。\r\n表面上是杂乱无章的段子拼凑起来的科普文\r\n\r\n实际上是暗地里讽刺别人的百合文\r\n\r\n\r\n每个时代有每个时代的难关，而现代人的难关之一就是各种心理疾病。\r\n人一生当中心理疾病有两个高发期，一个是青春期，一个是中年期。\r\n从网络，贴吧，QQ群盛行之后，网络上也涌现了许多性质迥异，参差不齐的心理疾病交友群。\r\n2016年某个心理疾病野鸡群里，大家互相用头像和签名区分彼此的年龄段，用表情包来确认彼此的三观。\r\n直到某天线上聊天不足以慰藉心灵时，而恰好大家都是一个大学的新生时，故事就开始了。\r\n','/upload/1394096758028.jpg',NULL,69,99,'yes',11,'99','no','三天两觉',NULL),(7,'一念永恒','我是男主，受雇于作者来到作者的小说里面配合她完成剧情，虽然出场费不高，但是我拥有着常人难以比拟的责任心，所以我认真地走剧情……\r\n等等……这个剧情是什么情况啊！雅蠛蝶呀！','/upload/1431692992841.jpg',NULL,514,18,'yes',9,'1000','no','耳根',NULL),(3,'剑来','烽火巅峰之作。。。','/upload/1394096841982.jpg',NULL,503,480,'no',9,'29','no','???',NULL),(11,'one piece','海贼王','/upload/1394096841982.jpg',NULL,100,100,'no',12,'5899960','no','尾田',NULL),(8,'史上第一混乱','\r\n韶关是个帅哥。\r\n从十八岁到二十八岁，他经历了三十场恋情，每一场都出奇地相似——被妹子倒追，交往，被妹子甩掉。\r\n直到，他得到了一个情商学习机 。\r\n\r\n韶关是个帅哥。\r\n从十八岁到二十八岁，他经历了三十场恋情，每一场都出奇地相似——被妹子倒追，交往，被妹子甩掉。\r\n直到，他得到了一个情商学习机 。\r\n\r\n韶关是个帅哥。\r\n从十八岁到二十八岁，他经历了三十场恋情，每一场都出奇地相似——被妹子倒追，交往，被妹子甩掉。\r\n直到，他得到了一个情商学习机 。\r\n','/upload/1431693176673.jpg',NULL,101,80,'yes',13,'10','no','张小花',NULL),(4,'贩罪','雍正元年，新帝登基，乌呼拉呼宜修成为皇后，母仪天下。与此同时，年羹尧功高震主，引得雍正在床上力不从心。新帝登基的首次选秀，假嬛、沈霉庄、安零容和复查贵人等秀女入宫被册为妃嫔，殊不知一场脑浆四溅的后宫争斗就此展开。假嬛因脸比碗大，特被册封为碗常在，成为皇帝的新宠】\r\n','/upload/1394096941266.jpg',NULL,652,600,'yes',9,'885','no','三天两觉',NULL),(5,'惊悚乐园','山楂的最新作品。。','/upload/1394097014927.jpg',NULL,1002,0,'yes',11,'555','no','三天两觉',NULL),(10,'异常生物见闻录','每天一个异闻录。。。','/upload/1394097014927.jpg',NULL,10,10,'no',9,'011','yes','远瞳',NULL),(6,'大王饶命','材质成分: 聚氨酯弹性纤维(氨纶)10% 其他90%袖长: 无袖销售渠道类型: 纯电商(只在线上销售)货号: LF170321品牌: BORUIDIA/波瑞蒂亚礼服摆型: 鱼尾颜色分类: 鱼尾敬酒服长款尺码: S M L XL上市年份季节: 2014年夏季适用场景: 婚礼 成人礼 聚会 公司年会 表演 日常 约会材质: 氨纶流行元素: 拉链风格: 时尚适用年龄: 18-25周岁腰型: 中腰款式: 立领服装款式细节: 花朵花朵: 手工花袖型: 常规填充物: 其他图案: 纯色','/upload/1394097078553.jpg',NULL,102,40,'yes',14,'117','no','会说话的肘子',NULL),(9,'122','请1111输入内容','/upload/1492264898573.jpg',NULL,100,100,'no',11,'5899960','yes','美梦初醒',NULL);
/*!40000 ALTER TABLE `novel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_gonggao`
--

DROP TABLE IF EXISTS `t_gonggao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_gonggao` (
  `gonggao_id` int(11) NOT NULL AUTO_INCREMENT,
  `gonggao_title` varchar(50) DEFAULT NULL,
  `gonggao_content` text,
  `gonggao_data` varchar(50) DEFAULT NULL,
  `gonggao_fabuzhe` varchar(255) DEFAULT NULL,
  `gonggao_del` varchar(50) DEFAULT NULL,
  `gonggao_one1` varchar(50) DEFAULT NULL,
  `gonggao_one2` varchar(50) DEFAULT NULL,
  `gonggao_one3` varchar(50) DEFAULT NULL,
  `gonggao_one4` varchar(50) DEFAULT NULL,
  `gonggao_one5` datetime DEFAULT NULL,
  `gonggao_one6` datetime DEFAULT NULL,
  `gonggao_one7` int(11) DEFAULT NULL,
  `gonggao_one8` int(11) DEFAULT NULL,
  PRIMARY KEY (`gonggao_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_gonggao`
--

LOCK TABLES `t_gonggao` WRITE;
/*!40000 ALTER TABLE `t_gonggao` DISABLE KEYS */;
INSERT INTO `t_gonggao` VALUES (1,'新品来了','新品来了','2019-03-6 18:34:55',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,'asd','请输入内容sadsda','2019-03-18 9:28:26',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'111','<br />\r\n????<br type=\"_moz\" />','2019-4-7 20:38:35',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,'奥','好','2019-4-17 12:17:42',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `t_gonggao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_liuyan`
--

DROP TABLE IF EXISTS `t_liuyan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_liuyan` (
  `liuyan_id` int(11) NOT NULL AUTO_INCREMENT,
  `liuyan_title` varchar(50) DEFAULT NULL,
  `liuyan_content` text,
  `liuyan_date` varchar(50) DEFAULT NULL,
  `liuyan_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`liuyan_id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_liuyan`
--

LOCK TABLES `t_liuyan` WRITE;
/*!40000 ALTER TABLE `t_liuyan` DISABLE KEYS */;
INSERT INTO `t_liuyan` VALUES (2,'??','123','2019-4-8 10:18:55','ztest'),(6,'好','好请输入内容','2019-4-24 12:43:36','ztest'),(7,'提议','这个网站太无聊了','2019-4-24 14:16:07','ztest'),(5,'啊？','请输入内容。。。。。。。。。。。。','2019-4-23 17:17:45','ztest');
/*!40000 ALTER TABLE `t_liuyan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_order`
--

DROP TABLE IF EXISTS `t_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_bianhao` varchar(50) DEFAULT NULL,
  `order_date` varchar(50) DEFAULT NULL,
  `order_zhuangtai` varchar(50) DEFAULT NULL,
  `order_songhuodizhi` varchar(50) DEFAULT NULL,
  `order_fukuangfangshi` varchar(50) DEFAULT NULL,
  `order_jine` int(11) DEFAULT NULL,
  `order_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_order`
--

LOCK TABLES `t_order` WRITE;
/*!40000 ALTER TABLE `t_order` DISABLE KEYS */;
INSERT INTO `t_order` VALUES (2,'20140318092718','2019-03-18 09:27:18','yes','北京','货到付款',105,2),(3,'20150526100906','2019-05-26 10:09:06','yes','北京店','货到付款',610,1),(4,'20170410102229','2019-04-10 10:22:29','no','','货到付款',40,1),(5,'20170411082439','2019-04-11 08:24:39','no','','货到付款',40,1),(6,'20170411093857','2019-04-11 09:38:57','no','','货到付款',520,1);
/*!40000 ALTER TABLE `t_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_orderitem`
--

DROP TABLE IF EXISTS `t_orderitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_orderitem` (
  `orderItem_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) DEFAULT NULL,
  `goods_id` int(11) DEFAULT NULL,
  `goods_quantity` int(11) DEFAULT NULL,
  `novel_id` int(11) DEFAULT NULL,
  `novel_quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`orderItem_id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_orderitem`
--

LOCK TABLES `t_orderitem` WRITE;
/*!40000 ALTER TABLE `t_orderitem` DISABLE KEYS */;
INSERT INTO `t_orderitem` VALUES (1,1,3,1,NULL,NULL),(2,2,4,1,NULL,NULL),(3,2,6,1,NULL,NULL),(4,3,1,1,NULL,NULL),(5,3,4,2,NULL,NULL),(6,3,2,1,NULL,NULL),(7,3,3,1,NULL,NULL),(8,3,6,2,NULL,NULL),(9,4,6,1,NULL,NULL),(10,5,6,1,NULL,NULL),(11,6,3,1,NULL,NULL),(12,6,6,1,NULL,NULL);
/*!40000 ALTER TABLE `t_orderitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type`
--

DROP TABLE IF EXISTS `type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `type` (
  `catelog_id` int(11) NOT NULL AUTO_INCREMENT,
  `catelog_name` varchar(50) DEFAULT NULL,
  `catelog_miaoshu` text,
  `catelog_del` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`catelog_id`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type`
--

LOCK TABLES `type` WRITE;
/*!40000 ALTER TABLE `type` DISABLE KEYS */;
INSERT INTO `type` VALUES (9,'玄幻魔法','玄幻魔法','no'),(10,'武侠修真','武侠修真','yes'),(11,'都市科幻','都市言科幻','no'),(12,'其他','<p>其他</p>','yes'),(13,'职场校园','职场校园','no'),(14,'穿越重生','穿越重生','no'),(15,'','?????','yes'),(16,'','?????','yes');
/*!40000 ALTER TABLE `type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT NULL,
  `user_pw` varchar(50) DEFAULT NULL,
  `user_type` int(11) DEFAULT NULL,
  `user_realname` varchar(50) DEFAULT NULL,
  `user_address` varchar(255) DEFAULT NULL,
  `user_sex` varchar(10) DEFAULT NULL,
  `user_tel` varchar(50) DEFAULT NULL,
  `user_email` varchar(50) DEFAULT NULL,
  `user_qq` varchar(50) DEFAULT NULL,
  `user_man` varchar(50) DEFAULT NULL,
  `user_age` varchar(50) DEFAULT NULL,
  `user_birthday` varchar(50) DEFAULT NULL,
  `user_xueli` varchar(50) DEFAULT NULL,
  `user_del` varchar(50) DEFAULT NULL,
  `user_one1` varchar(50) DEFAULT NULL,
  `user_one2` varchar(50) DEFAULT NULL,
  `user_one3` varchar(50) DEFAULT NULL,
  `user_one4` varchar(50) DEFAULT NULL,
  `user_one5` varchar(50) DEFAULT NULL,
  `user_one6` int(11) DEFAULT NULL,
  `user_one7` int(11) DEFAULT NULL,
  `user_one8` int(11) DEFAULT NULL,
  `user_one9` datetime DEFAULT NULL,
  `user_one10` datetime DEFAULT NULL,
  `user_one11` bigint(20) DEFAULT NULL,
  `user_one12` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'ztest','123456',0,'ooo','在你家','女','123123321','58850198@qq.com','458820',NULL,NULL,NULL,NULL,'no',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,'zhgl322','123456',0,'张三','北京','男','18300726818','5555@qq.com','588550198',NULL,NULL,NULL,NULL,'no',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'ztest','123456',0,'张光磊','北京','男','187445100','58850198@qq.com','58850198',NULL,NULL,NULL,NULL,'no',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zhangjie`
--

DROP TABLE IF EXISTS `zhangjie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zhangjie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_id` int(11) DEFAULT NULL,
  `content` text,
  `pushtime` varchar(255) DEFAULT NULL,
  `zhangjiename` varchar(255) DEFAULT NULL,
  `novel_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zhangjie`
--

LOCK TABLES `zhangjie` WRITE;
/*!40000 ALTER TABLE `zhangjie` DISABLE KEYS */;
INSERT INTO `zhangjie` VALUES (1,1,'<div align=\"center\" style=\"padding: 14px 0px 0px; margin: 0px; font-size: 16px; font-family: 宋体; background-color: rgb(238, 250, 238); float: left; width: 713px;\">\r\n<h2 style=\"padding: 0px; margin: 0px; font-size: 16px; color: rgb(51, 51, 51); font-weight: normal;\">第一章水边相遇</h2>\r\n</div>\r\n<div style=\"padding: 0px; margin: 0px; font-family: 宋体; background-color: rgb(238, 250, 238); clear: both;\">&nbsp;</div>\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　江湖是个神奇的地方。</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　昨天的敌人只要通过小小的手段就能成为今天的朋友，而联姻就成为了促进「友谊」发展的有效手段，毕竟只是牺牲一个女人却能换来一个能够增强自己力量的联盟，对于各个家族和门派来说实在是再划算不过了。</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　燕家，在武林中说大不大说小却也不小，这样一个家族，是最让各大门派觊觎的，吞并这样的家族谈不上困难，但只要吞并这样一个家族就能增强不少实力。</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　所以，结交一些强大势力就成了燕家势在必行的工作。</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　而，燕家的女儿个个如花似玉，亭亭玉立，有着江南少女独有的媚骨柔情。</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　除了燕小小。</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　燕小小并不如她的姐妹们那么美貌动人，仅仅能算的上是可爱的小妹妹罢了，就如她的名字一样长得小小的，除了那双很大的杏目外，她的一切都是小小的，小小的鼻子，小小的嘴唇，还有小小的个子。可是她的性格与小小一点也没有关系，倔强不认输的个性，不失活泼俏皮，还有点小小的火爆，却也不乏为他人着想的细心体贴。</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　她一直觉得即使是联姻也与她无关，事实上也差不多，今年她十七岁，刚刚好是嫁人的年纪，可是她的父亲却像是忘了还有她这么个女儿似的。不过她也不急，她还想再玩两年呢！</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　尽管她的兄弟姐妹都很苛刻，但总比那些江湖中凶神恶煞的男人好！</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　而且鉴于她娘的经历，她立志绝对不要嫁给江湖中人！</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　如果一定要嫁&hellip;&hellip;</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　那她就&mdash;&mdash;逃！</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　厉狩这是第一次下山，他听说江南很美，而且江湖门派很多，所以，他决定向江南进发。二十三个春秋完完全全是在山上渡过的厉狩，唯一接触过的人只有他的师父。</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　所以当他看到城镇的时候，第一次知道原来这个世界上有这么多他的同类，这里没有豺狼虎豹，这里没有狠毒蛇蝎，可是&hellip;&hellip;</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　厉狩皱眉，这里吃饭是要钱的！</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　所谓钱，就是那种圆形方孔的东西，可是，他的师父根本没有给他留下那种东西。&nbsp;</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　所以，下山仅仅21天，他偶尔会路过山里，那时是他解决食物的唯一途径。还会用野兽的皮换点钱。</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　原本他有一点小积蓄，但在路上，他又听说闯荡江湖的话需要有一把趁手的武器，他在山上用的剑委实短了一些，所以在用动物皮毛换掉钱后，很开心的跑到铁匠铺去打了一柄软剑，一柄极其普通的软剑，可这柄软剑就花费了他所有的积蓄。</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　所以，大侠又成为穷光蛋一枚了。他又饿肚子了。</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　就这样，有一顿没一顿的，厉狩带着他师父嘱咐他要带的「东西」还有几件衣服，终于到达了苏州边境的一片小树林里。</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　而这时他已经三天没有碰到林子了，也就是说，初出江湖的厉狩三天没吃饭了。</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　林子里传来一阵歌声，甜甜的声音让厉狩想起焦糖渣&mdash;&mdash;请原谅这个没见过世面又没钱的孩子只能想到这个比喻。</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　没有半分江湖经验的厉狩根本不懂什么危机意识，径直的走了进去，不由自主的寻找着歌声的源头，那美好的声音一直吸引着他。</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　一场相遇，就源于一条小溪。</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　一个小小的女孩子在溪间跳跃，唱着歌，长裙被挽了起来露出白皙的腿，小巧的脚丫踏着水，激起水花，女孩畅快的笑着，偶尔还使出一些轻功。</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　可是，厉狩却皱起眉，闭起眼，&ldquo;非礼勿视，非礼勿听。女孩子应该端庄稳重，不应该随便露出腿，女孩子应该会持家，会女红，不应该习武的。&rdquo;厉狩嘟嘟囔囔的也不知道说给谁听，可是他这么一闭眼，心思也不在走路上，所以&hellip;&hellip;</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　扑通</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　厉狩掉在水里了。</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　不远处的燕小小一惊，却看见一个高大的男人一下子掉在了水里，急忙跑到厉狩的身边，帮忙把厉狩从水里拉起来，&ldquo;你没事吧？&rdquo;</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　&ldquo;咳咳，咳咳。&rdquo;厉狩咳出进到嘴里的水，&ldquo;没事。&rdquo;眼神却飘向别处，不去看小小。</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　&ldquo;没事就好。&rdquo;小小拍拍厉狩的肩膀，忍不住发挥一下管家婆的特征，&ldquo;我说啊，你一个大男人怎么还那么不小心？竟然掉到水里了，幸好，这条小溪水浅，不然你就惨了！&rdquo;</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　厉狩没有回话，因为他不知道回什么，也没有打断她的唠叨，因为打断别人说话时不礼貌的行为。</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　&ldquo;&hellip;&hellip;这次不小心，下次可能&hellip;&hellip;&rdquo;</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　&ldquo;燕小小！&rdquo;树林里传来人的叫喊。</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　小小却一下子变了脸色，&ldquo;该死，他们怎么能追到这来？&rdquo;小小四处打量一下，却没有藏身的地方，只有藏在水里了，小小一把拉住厉狩的袖子，&ldquo;能不能帮我个忙？&rdquo;</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　&ldquo;恩？&rdquo;厉狩困惑的挑挑眉。</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　&ldquo;就说没看到我！&rdquo;</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　望着小小盼望的眼神，厉狩决定帮她这个忙，即使他认为说谎是不道德的行为，&ldquo;恩。&rdquo;</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　&ldquo;太谢谢了！&rdquo;说着，小小在厉狩诧异的眼神中一下子钻到水里，移动到他身后，如果不仔细看是不会发现她的。</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　就在小小钻到水里不久后，一群人就来到了河边，为首的人是一个颇为英俊的年轻男人，眉宇间却透着一股高傲，在打量了一下衣着破烂的厉狩之后眼神中透着一股轻蔑，&ldquo;你有没有看到一个女人路过这？&rdquo;</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　厉狩没有说话，只是摇摇头。</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　&ldquo;该死的，被她给逃了！&rdquo;年轻男人咒骂着，他是燕小小的长兄，这次来找小小是为了让她去嫁给一个门派的掌门，可是那个人却已经死了三个妻子了，还有两个孩子。</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　话落，男人一刻也不愿意多停留似的，挥挥手带着手下的人离开了。</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　厉狩的耳朵微微动了一下，确定没有人留下之后，垂头，低语，&ldquo;他们走了。&rdquo;</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　小小一下子从水中窜了出来，长长的舒了一口气。</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　可是这口气还没喘完，小小的脚下一滑一下子又落入水中，还不小心踹了厉狩一脚，结果是厉狩和她一起掉到水里去了&hellip;&hellip;</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　而且姿势非常暧昧。</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　厉狩在上，小小在下，厉狩的手还放到了某个不该放的位置&hellip;&hellip;</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　两个人同时愣住。在水里大眼瞪小眼的瞪了半天。</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　下一秒，两个人像触电一样从水里窜出来，同时推开对方。</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　两个人的脸上有着可疑的红晕。</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　接着，大眼又瞪着小眼几秒。</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　厉狩咳了咳，脸上竟然出现了某种像是壮士断腕似的悲壮，&ldquo;姑娘，嫁给我！&rdquo;</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　&ldquo;&hellip;&hellip;&rdquo;</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　&ldquo;&hellip;&hellip;&rdquo;</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　两双眼睛继续对瞪着。</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　&ldquo;为什么？&rdquo;小小嘟起嘴，最近她烂桃花很多嘛，不仅那个江湖人要娶她，就连仅仅见过一面的家伙都要娶她，怎么？她突然变美了？还是说因为眼前这个两次掉到河里的男人脑袋进水了？</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　&ldquo;为什么？&rdquo;厉狩一双漂亮的眉紧紧攒起来，眼神中露出明显的不赞同，&ldquo;因为刚刚我们&hellip;&hellip;&rdquo;厉狩的耳根露出明显的红晕，&ldquo;咳咳，抱在一起，我看到了你的腿，还&hellip;&hellip;还&hellip;&hellip;&rdquo;这下子厉狩连脸都红了起来，&ldquo;摸到了&hellip;&hellip;咳咳，你的&hellip;&hellip;你的&hellip;&hellip;&rdquo;</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　&ldquo;胸部。&rdquo;小小面无表情的帮他补充完。</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　&ldquo;对。&rdquo;厉狩直视着小小，一副你嫁给我理所当然的表情，&ldquo;所以你要嫁给我！&rdquo;</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　这下子，小小哭笑不得，原来是为了这个破理由，她还以为是很美好的一见钟情呢！即使不是，也要说些甜言蜜语的话来诱惑她啊！</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　&ldquo;江湖儿女不在意这些小节的！&rdquo;小小豪气的挥挥手。</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　&ldquo;可是你是女孩子，贞节很重要，和江湖儿女没关系！&rdquo;厉狩像是想到什么似的，露出恍然的表情，&ldquo;虽然现在我没什么钱，但我会努力赚钱养你，不会让你很辛苦的。&rdquo;</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　跟那个没关系好不好！</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　小小继续苦笑，她上下打量着厉狩，眼前这个家伙漂亮是漂亮，比她那些哥哥都要英俊，还要多出几分，不，很多男子气概，但她肯定这个家伙的脑袋绝对是进水了！小小撇撇嘴，想到了一个绝佳的解决办法，&ldquo;你看到刚刚那些男人了吗？&rdquo;</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　&ldquo;看到了。&rdquo;</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　&ldquo;那些是我的仇人，如果我嫁给你会给你惹麻烦的。&rdquo;</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　&ldquo;我会保护你。&rdquo;厉狩直视着小小，宣誓式的回答着，虽然他到现在仍然没有与其他人比试过，但师父教过他，保护妻子是男人的责任。所以无论如何他都会保护她的。</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　小小被那种认真的语气弄得一愣，从来没有人说过要保护她，没有一个，她的娘亲，没说过，更别提讨厌她的父亲和兄弟姐妹了&mdash;&mdash;唯一一个对她好的还是她的弟弟，她不能依靠一个比她还小两岁的大男孩儿啊！所以从小到大一直是她自己照顾自己，自己保护自己，没有人可以让她依靠，就连武功都是她自己偷学的。</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　一瞬间，小小觉得眼前的男人很温柔！</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　&ldquo;既然我抱过你，还碰了你的&hellip;&hellip;咳咳，胸部，我就一定会负责任的。&rdquo;</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　去他妈的温柔，这个男人是个榆木疙瘩！</span><br style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\" />\r\n<span style=\"font-family: 宋体; font-size: 16px; background-color: rgb(238, 250, 238);\">　　【第一章完】</span>','2019-3-29 15:06:41','第一章 水边相遇',NULL),(2,1,'内容待定。。。<br />\r\n第二章结束','2019-3-29 18:29:19','第二章 智取只能智取',NULL),(4,1,'??????????????????????????????????????????????????????????????','2019-4-17 10:54:28','???',NULL),(5,6,'请输入内容','2019-4-23 17:13:00','123',NULL),(6,6,'请输入内容','2019-4-23 17:13:47','12343',NULL),(7,NULL,'啊啊啊啊啊','2019-4-24 19:43:50','第一章',6);
/*!40000 ALTER TABLE `zhangjie` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-24 21:58:49
