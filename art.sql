CREATE TABLE `artist` (
  `id` int(18) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `identity` TINYINT not null,
  `birth_year` INT DEFAULT NULL,
  `birth_month` TINYINT DEFAULT NULL,
  `gender` TINYINT DEFAULT NULL,
  `introduction` text DEFAULT null,
  nationality varchar(50) DEFAULT NULL ,
  live_province varchar(50) DEFAULT null,
  birth_province varchar(50) DEFAULT  null,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ;

create table production_info(
  `id` int(18) not null AUTO_INCREMENT,
  `property` TINYINT not null ,
  `name` varchar(200) not null,
  author_id int(18) not null,
  purchasing_price NUMERIC(11,3) DEFAULT null,
  selling_price NUMERIC(11,3) DEFAULT null,
  supply_channels int(1) not null,
  make_time INT DEFAULT null,
  purchasing_time INT DEFAULT null,
  selling_time INT DEFAULT null,
  add_time DATETIME not null,
  is_selled TINYINT not null,
  `image` varchar(200) DEFAULT null,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ;

create table D_CODE(
  `type` varchar(20) not null,
  `code` TINYINT not null ,
  `index` int ,
  `discription` varchar(200) not null
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;

/*
mysql> select * from d_code;
+------------------+------+-------+-------------+
| type             | code | index | discription |
+------------------+------+-------+-------------+
| T_GENDER         |    1 |     1 | 男          |
| T_GENDER         |    2 |     2 | 女          |
| T_IDENTITY       |    1 |     1 | 画家        |
| T_IDENTITY       |    2 |     2 | 书法家      |
| T_IDENTITY       |    0 |     3 | 全才        |
| T_IDENTITY       |    3 |     4 | 其他        |
| T_PROPERTY       |    0 |     1 | 画作        |
| T_PROPERTY       |    1 |     2 | 书法        |
| T_PROPERTY       |    2 |     3 | 其他        |
| T_SUPPLY_CHANNEL |    1 |     1 | 转手        |
| T_SUPPLY_CHANNEL |    2 |     2 | 拍卖        |
| T_SUPPLY_CHANNEL |    0 |     3 | 其他        |
| T_SELLED         |    0 |     1 | 未卖出      |
| T_SELLED         |    1 |     2 | 已卖出      |
+------------------+------+-------+-------------+
14 rows in set (0.00 sec)

*/