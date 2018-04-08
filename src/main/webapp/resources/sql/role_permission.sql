drop table if exists role_permission;
create table role_permission(
  id varchar(32) primary key,
  role_id varchar(32),
  permission_id int,
  foreign key(role_id) references role(id),
  foreign key(permission_id) references permission(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
insert into role_permission values('10000','member',12);
insert into role_permission values('10001','member',13);
insert into role_permission values('11000','manager',11);
insert into role_permission values('11001','manager',12);
insert into role_permission values('11002','manager',13);