package com.textile083.serviceImpl;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.textile083.dao.ArticleDAO;
import com.textile083.dao.StudentDAO;
import com.textile083.entity.Article;
import com.textile083.entity.Permission;
import com.textile083.entity.Student;
import com.textile083.entity.User;
import com.textile083.exception.AssertException;
import com.textile083.service.LoginService;
import com.textile083.service.PermissionService;
import com.textile083.util.AssertUtil;
import com.textile083.util.EncryptUtil;

@Service("loginService")
public class LoginServiceImpl implements LoginService{
	@Autowired
	private StudentDAO studentDAO;
	@Autowired
	private ArticleDAO articleDAO;
	@Autowired
	private PermissionService permissionService;

	public void doLogin(HttpServletRequest request) throws Exception {
		Cookie[] cookies=request.getCookies();
		String[] str = new String[2];
		//获取Cookies中的姓名和学号缓存
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
		request.getSession().setAttribute("name", str[0]);
		request.getSession().setAttribute("number", str[1]);
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
	 * 验证students数据表中是否name和number
	 */
	public void checkStudent(HttpServletRequest request) throws Exception{
		String name = (String) request.getParameter("name");
		String number = (String) request.getParameter("number");
		//验证name和number不为空
		AssertUtil.assertNotBlank("学生名字不能为空", name);
		AssertUtil.assertNotBlank("学生学号不能为空", number);
		Student s=studentDAO.queryStudentByName(name);
		if(s==null){
			throw new AssertException("我们班没有叫"+name+"的人！");
		}
		number=EncryptUtil.md5(number);
		s.setNumber(AssertUtil.assertNotEquals("学生学号不对", number, s.getNumber()).toString());	
		List<Article> articleList1 = queryAllArticleList().subList(0, 10);
		List<Permission> permissionList=permissionService.findPermissionListByStudentId(s.getId());
		User user=new User();
		user.setName(s.getName());
		user.setNumber(s.getNumber());
		user.setPermissionList(permissionList);
		request.getSession().setAttribute("articleList1", articleList1);
		request.getSession().setAttribute("user", user);
		request.getSession().setAttribute("permissionList", permissionList);
	}

	/**
	 * 检查用户是否勾选记住学号和姓名，如果勾选在cookie中保存
	 */
	public boolean checkMsg(HttpServletRequest request, HttpServletResponse response) throws Exception {
		User u=(User) request.getSession().getAttribute("user");
		if(u!=null){
			return true;
		}		
		String[] msg = request.getParameterValues("msg");
		String name = (String) request.getParameter("name");
		String number = (String) request.getParameter("number");
		Cookie[] cookies1 = request.getCookies();
		Cookie[] cookies2 = new Cookie[2];
		if (msg != null && msg.length > 0) {
			cookies2[0] = new Cookie("name", URLEncoder.encode(name, "utf-8"));
			cookies2[1] = new Cookie("number", URLEncoder.encode(number, "utf-8"));
			cookies2[0].setMaxAge(10 * 24 * 60 * 60);// 设置cookie保存10天
			cookies2[1].setMaxAge(10 * 24 * 60 * 60);
		} else {
			if (cookies1 != null && cookies1.length > 0) {
				cookies2=cookies1;
				for (Cookie c : cookies1) {
					if (c.getName().equals("name") || c.getName().equals("number")) {
						c.setMaxAge(0);// 设置cookie失效
					}
				}
			}
		}
		// 如果两个cookies不相同，将缓存中的内容添加到response中，如果没有缓存，重新保存
		if (cookies2 != cookies1) {
			response.addCookie(cookies2[0]);
			response.addCookie(cookies2[1]);
		} else {
			if(cookies1!=null){
				for (Cookie c : cookies1) {
					response.addCookie(c);// 重新保存
				}
			}
		}
		
		return false;
	}
}
