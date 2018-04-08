drop table if exists students_role;
create table students_role(
  id varchar(32) primary key,
  student_id int,
  role_id varchar(32),
  foreign key(role_id) references role(id),
  foreign key(student_id) references students(student_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of students_role
-- ----------------------------
insert into students_role values('baiyun_1',1,'member');
insert into students_role values('chengengbin_2',2,'member');
insert into students_role values('dudongxun_3',3,'member');
insert into students_role values('guoshenghua_4',4,'member');
insert into students_role values('hexuhui_5',5,'member');
insert into students_role values('hulizhun_6',6,'manager');
insert into students_role values('lianjingtong_7',7,'member');
insert into students_role values('lvyifan_8',8,'member');
insert into students_role values('panjunlong_9',9,'member');
insert into students_role values('shenxusheng_10',10,'member');
insert into students_role values('songshuang_11',11,'member');
insert into students_role values('suying_12',12,'member');
insert into students_role values('xiaxiaofeng_13',13,'member');
insert into students_role values('yanglei_14',14,'member');
insert into students_role values('zhangxin_15',15,'member');
insert into students_role values('bianxinxin_16',16,'member');
insert into students_role values('cuifengjiao_17',17,'member');
insert into students_role values('dengjiaying_18',18,'member');
insert into students_role values('fuhaiping_19',19,'member');
insert into students_role values('heliyun_20',20,'member');
insert into students_role values('lizongjie_21',21,'member');
insert into students_role values('liufengying_22',22,'member');
insert into students_role values('menghuan_23',23,'member');
insert into students_role values('wangyuxin_25',25,'member');
insert into students_role values('zhangjing_26',26,'member');
insert into students_role values('zhengcuijuan_27',27,'member');
insert into students_role values('songcheng_28',28,'member');