package com.textile083.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.textile083.dao.Operation;
import com.textile083.entity.Permission;
import com.textile083.service.PermissionService;

@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private Operation operation;
	
	public List<Permission> findPermissionListByStudentId(int student_id) {
		// TODO Auto-generated method stub
		String id=Integer.toString(student_id);
		List<Permission> permissionList=operation.findPermissionListByStudentId(id);
		return	permissionList;
	}

}
