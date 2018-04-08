drop table if exists students;
create table students(
  student_id int auto_increment primary key,
  student_number varchar(32),
  student_sex varchar(16),
  student_name varchar(32)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of students
-- ----------------------------
insert into students values(1,'5eb4667e400b96bbf116cb7d02f2b115','男','白云');
insert into students values(2,'1f5a93506c95756a42adf400d3981246','男','陈耿彬');
insert into students values(3,'37ae5c40889166728b09a68112734a42','男','杜东洵');
insert into students values(4,'2c1cc9f4b5d36dd120858d2168f98b18','男','郭胜华');
insert into students values(5,'72e7acb18aa58a9d153993f74889d10b','男','何旭辉');
insert into students values(6,'3e1343941df6d97646d880c1bd10d5c4','男','胡立准');
insert into students values(7,'1dc8f2ef0d277e4c44c1e13ba21b266c','男','连经通');
insert into students values(8,'ad26125e50c759f71383816c573c3e5','男','吕一帆');
insert into students values(9,'6af0c530a8596805cdc4dfbda296ac78','男','潘俊龙');
insert into students values(10,'4092f93209b27326c6f8fbb27a3ec5c5','男','沈旭升');
insert into students values(11,'17cb5b5f0295d0acd981b655db270f20','男','宋爽');
insert into students values(12,'55f027e08334b2f67148d17b5b5d078b','男','苏营');
insert into students values(13,'6025de217308c177ebb6accfa6e7bbb1','男','夏晓峰');
insert into students values(14,'6419a64e8c06d255f7abe9d9e147526b','男','杨磊');
insert into students values(15,'43d154125d7c8bff8fa40e60e30f0439','男','张鑫');
insert into students values(16,'408724835fdebe88d665fccb31f08f32','女','边鑫鑫');
insert into students values(17,'37083ce4ea2407df55d43f9e1b61a81e','女','崔凤娇');
insert into students values(18,'1ad68c2a4bb8f81ab5c8e43c3008b137','女','邓嘉莹');
insert into students values(19,'3de4bfbba10112a3e18d3ae6472fc332','女','付海萍');
insert into students values(20,'59b034147e6c5c00dfe8ec53f0a9dca1','女','何丽云');
insert into students values(21,'594cd42a81fd219c684f3ed0e3b5f070','女','厉宗洁');
insert into students values(22,'7851ad388c3ce5a0dae6385f0bafa33c','女','刘凤英');
insert into students values(23,'5f293dc2aa6b345ac4e3b641f6f09ddb','女','孟焕');
insert into students values(25,'5741c3e8c16338a883bf15857e71c09d','女','王玉新');
insert into students values(26,'622d008480322bc41ae33a4bbd3f41a4','女','张靖');
insert into students values(27,'457c3c5e7b75e09646d42970ddd053ee','女','郑翠娟');
insert into students values(28,'5721a838072605303923a191d5fedad7','男','宋成');