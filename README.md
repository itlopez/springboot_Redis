# springboot_Redis
springboot集成redis的demo，使用spring_data_redis,简单易用好上手，此项目主要列举了redis的string模型以及hash模型，后续还会补上。
###简介
~~~

业务：将存在mysql中的学校数据录入redis，增加查询速度
~~~
###数据库表
~~~
CREATE TABLE `school` (
  `id` varchar(80) NOT NULL COMMENT '唯一标识',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `orgNo` varchar(10) DEFAULT NULL COMMENT '机构编码',
  `status` tinyint(4) DEFAULT '0' COMMENT '是否有效，0代表有效，1代表无效',
  `type` tinyint(4) DEFAULT '1' COMMENT '1：小学 2：中学 3：高中',
  `school_key` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`school_key`),
  KEY `index_orgNo` (`orgNo`),
  KEY `index_type` (`type`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=762322 DEFAULT CHARSET=utf8;

~~~
