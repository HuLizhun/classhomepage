package com.textile083.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.textile083.entity.Permission;

@Repository("operation")
public interface Operation {

	//根据student_id查询权限范围内的url
    public List<Permission> findPermissionListByStudentId(String student_id);
}
