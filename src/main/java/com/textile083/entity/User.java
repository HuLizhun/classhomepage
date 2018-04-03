package com.textile083.entity;

import java.util.List;

public class User {

	private String number;//学号
	private String name;//姓名
	private List<Permission> permissionList;//权限
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Permission> getPermissionList() {
		return permissionList;
	}
	public void setPermissionList(List<Permission> permissionList) {
		this.permissionList = permissionList;
	}
	public User() {
		super();
	}
	
}
