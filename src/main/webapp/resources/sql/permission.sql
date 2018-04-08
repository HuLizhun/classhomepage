drop table if exists permission;
create table permission(
  id int primary key,
  name varchar(32),
  url varchar(64)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
insert into permission values(11,'删除文章','/Textile083/skip.action?name=delete');
insert into permission values(12,'添加文章','/Textile083/skip.action?name=write');
insert into permission values(13,'查找我的文章','/Textile083/queryMyArtilce.action');