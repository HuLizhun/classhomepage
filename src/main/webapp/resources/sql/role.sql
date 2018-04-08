drop table if exists role;
create table role(
  id varchar(32) primary key,
  name varchar(32)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
insert into role values('member','网站成员');
insert into role values('manager','网站管理员');