package com.textile083.listener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.textile083.dao.StudentDAO;
import com.textile083.entity.Student;

public class StudentsListListener extends ContextLoaderListener implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		super.contextInitialized(sce);
		//初始化系统数据
		ServletContext sc=sce.getServletContext();
		try{
			this.initStudentsList(sc);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		super.contextDestroyed(sce);
		
	}

	private void initStudentsList(ServletContext sc) throws Exception{
		WebApplicationContext ac=WebApplicationContextUtils.getWebApplicationContext(sc);
		StudentDAO sdao=ac.getBean(StudentDAO.class);
		List<Student> studentList=sdao.queryAllStudentList();
		sc.setAttribute("studentList",studentList);
	}
}
