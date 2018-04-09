package com.textile083.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.textile083.exception.AssertException;
import com.textile083.service.LoginService;

/**
 * 登陆相关操作的控制器
 *
 */
@Controller
@RequestMapping("/Textile083")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping("/doLogin.action")
	public String doLogin(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");		
		loginService.doLogin(request);
		return "login";
	}

	@RequestMapping("/login.action")
	public String login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		try{
			if(loginService.checkMsg(request,response)){
				return "index";
			}
			//验证用户登录信息
			loginService.checkStudent(request);
			return "index";
		}catch(AssertException e){
			request.setAttribute("message",e.getMessage());
			return "failure";
		}	

	}
}
