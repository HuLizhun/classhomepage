package com.textile083.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.textile083.entity.Article;
import com.textile083.entity.Student;
import com.textile083.entity.User;
import com.textile083.service.LoginService;
import com.textile083.service.PermissionService;

/**
 * 登陆相关操作的控制器
 *
 */
@Controller
@RequestMapping("/Textile083")
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@Autowired
	private PermissionService permissionService;

	@RequestMapping("/doLogin.action")
	public String doLogin(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		//获取Cookies中的姓名和学号缓存
		String[] str = loginService.doLogin(request.getCookies());
		request.getSession().setAttribute("name", str[0]);
		request.getSession().setAttribute("number", str[1]);
		return "login";
	}

	@RequestMapping("/login.action")
	public String login(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		String[] msg = request.getParameterValues("msg");
		String name = (String) request.getParameter("name");
		String number = (String) request.getParameter("number");
		Cookie[] cookies1 = request.getCookies();
		Cookie[] cookies2 = loginService.checkMsg(name, number, msg, cookies1);
		// 如果两个cookies不相同，将缓存中的内容添加到response中，如果没有缓存，重新保存
		if (cookies2 != cookies1) {
			response.addCookie(cookies2[0]);
			response.addCookie(cookies2[1]);
		} else {
			for (Cookie c : cookies1) {
				response.addCookie(c);// 重新保存
			}
		}
		// 验证用户登录信息，如果已经登陆不再验证
		Student s = loginService.checkStudent(name, number);
		if (s != null) {
			List<Student> studentList = loginService.queryAllStudentList();
			List<Article> articleList1 = loginService.queryAllArticleList().subList(0, 10);
			User user=new  User();
			user.setName(s.getName());
			user.setNumber(s.getNumber());
			user.setPermissionList(permissionService.findPermissionListByStudentId(s.getId()));
			request.getSession().setAttribute("studentList", studentList);
			request.getSession().setAttribute("articleList1", articleList1);
			request.getSession().setAttribute("user", user);
			return "index";
		} else {
			request.getSession().setAttribute("msg", "输入的学号或姓名不对！");
			return "failure";
		}
	}
}
