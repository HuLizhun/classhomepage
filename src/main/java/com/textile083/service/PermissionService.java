package com.textile083.service;

import java.util.List;

import com.textile083.entity.Permission;


public interface PermissionService {
	//根据用户id查询权限范围内的url
	public List<Permission> findPermissionListByStudentId(int student_id);
}
