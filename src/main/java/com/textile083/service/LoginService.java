package com.textile083.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.textile083.dao.ArticleDAO;
import com.textile083.dao.StudentDAO;
import com.textile083.entity.Article;
import com.textile083.entity.Student;

@Service("loginService")
@Transactional
public class LoginService {
	@Autowired
	private StudentDAO studentDAO;
	@Autowired
	private ArticleDAO articleDAO;

	public String[] doLogin(Cookie[] cookies) throws UnsupportedEncodingException {
		String[] str = new String[2];
		if (cookies != null && cookies.length > 0) {
			for (Cookie c : cookies) {
				if (c.getName().equals("name")) {
					str[0] = URLDecoder.decode(c.getValue(), "utf-8");
				}
				if (c.getName().equals("number")) {
					str[1] = URLDecoder.decode(c.getValue(), "utf-8");
				}
			}
		}
		return str;
	}

	/**
	 * 查询数据库中所有article的信息
	 * 
	 * @return
	 */
	public List<Article> queryAllArticleList() {
		List<Article> articleList = articleDAO.queryAllArticleList();
		return articleList;
	}

	/**
	 * 查询数据库中所有student的信息
	 * 
	 * @return
	 */
	public List<Student> queryAllStudentList() {
		List<Student> studentList = studentDAO.queryAllStudentList();
		return studentList;
	}

	/**
	 * 判断是否第一次登陆，如果第一次登陆，验证name和number，如果已经登陆，不再验证信息
	 */
	public Student checkStudent(String name, String number, Student student) {
		if (student != null) {
			// 向页面跳转
			return student;
		} else {
			// 查询数据库中所有student的信息
			List<Student> studentList = queryAllStudentList();
			if (studentList != null && studentList.size() > 0) {
				for (int i = 0; i < studentList.size(); i++) {
					if (name.equals(studentList.get(i).getName()) && number.equals(studentList.get(i).getNumber())) {
						Student s = studentList.get(i);
						return s;
					}
				}
			}
		}
		return null;
	}

	/**
	 * 检查用户是否勾选记住学号和姓名，如果勾选在cookie中保存
	 * 
	 * @throws UnsupportedEncodingException
	 */
	public Cookie[] checkMsg(String name, String number, String[] msg, Cookie[] cookies1)
			throws UnsupportedEncodingException {
		if (msg != null && msg.length > 0) {
			Cookie[] cookies2 = new Cookie[2];
			cookies2[0] = new Cookie("name", URLEncoder.encode(name, "utf-8"));
			cookies2[1] = new Cookie("number", URLEncoder.encode(number, "utf-8"));
			cookies2[0].setMaxAge(10 * 24 * 60 * 60);// 设置cookie保存10天
			cookies2[1].setMaxAge(10 * 24 * 60 * 60);
			return cookies2;
		} else {
			if (cookies1 != null && cookies1.length > 0) {
				for (Cookie c : cookies1) {
					if (c.getName().equals("name") || c.getName().equals("number")) {
						c.setMaxAge(0);// 设置cookie失效
					}
				}
			}
			return cookies1;
		}
	}
}
