package com.textile083.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.textile083.entity.User;

public class LoginInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
//		User user=(User) request.getSession().getAttribute("user");
//		if(user==null){
//			request.getRequestDispatcher("/WEB-INF/jsps/login.jsp").forward(request, response);
//			return false;
//		}else{
//			return true;
//		}
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		User user=(User) request.getSession().getAttribute("user");
		if(user==null){
			modelAndView.setViewName("login");
		}
		
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
