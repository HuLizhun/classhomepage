drop table if exists students;
create table students(
  student_id int auto_increment primary key,
  student_number varchar(50),
  student_sex varchar(50),
  student_name varchar(50)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of students
-- ----------------------------
insert into students values(1,'0810110301','男','白云');
insert into students values(2,'0810110302','男','陈耿彬');
insert into students values(3,'0810110303','男','杜东洵');
insert into students values(4,'0810110304','男','郭胜华');
insert into students values(5,'0810110305','男','何旭辉');
insert into students values(6,'0810110306','男','胡立准');
insert into students values(7,'0810110307','男','连经通');
insert into students values(8,'0810110308','男','吕一帆');
insert into students values(9,'0810110309','男','潘俊龙');
insert into students values(10,'0810110310','男','沈旭升');
insert into students values(11,'0810110311','男','宋爽');
insert into students values(12,'0810110312','男','苏营');
insert into students values(13,'0810110313','男','夏晓峰');
insert into students values(14,'0810110314','男','杨磊');
insert into students values(15,'0810110315','男','张鑫');
insert into students values(16,'0810110316','女','边鑫鑫');
insert into students values(17,'0810110317','女','崔凤娇');
insert into students values(18,'0810110318','女','邓嘉莹');
insert into students values(19,'0810110319','女','付海萍');
insert into students values(20,'0810110320','女','何丽云');
insert into students values(21,'0810110321','女','厉宗洁');
insert into students values(22,'0810110322','女','刘凤英');
insert into students values(23,'0810110323','女','孟焕');
insert into students values(25,'0810110325','女','王玉新');
insert into students values(26,'0810110326','女','张靖');
insert into students values(27,'0810110327','女','郑翠娟');
insert into students values(28,'0810110328','男','宋成');