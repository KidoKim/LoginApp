package com.testing.controller;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import junit.framework.TestCase;

import com.testing.controller.LoginController;
import com.testing.dao.login.LoginDao;
import com.testing.models.login.Users;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.web.servlet.ModelAndView;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring-security.xml", 
	"file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml"
})
@WebAppConfiguration
public class LoginAppControllerTest {
	
	private static final Logger logger = Logger
			.getLogger(LoginAppControllerTest.class);

	@Autowired
	LoginDao loginDao;
	
	@Test
	public void getUserDefaulttest() {
		LoginController l = new LoginController();
		
		assertEquals(l.getUserDefault(), "home");
	}

	@Test
	public void SuccessGetLoginFormTest() {
		LoginController l = new LoginController();
		String message = "";
		Users u = loginDao.findByUserName("admin");
		ModelAndView mav = l.getLoginForm(u, null, null);
		Map<String, Object> movModel = mav.getModel();
		assertEquals(movModel.get("message"), message);
	}
	
	@Test
	public void LogoutGetLoginFormTest() {
		LoginController l = new LoginController();
		String message = "Logout successful !";
		Users u = loginDao.findByUserName("admin");
		ModelAndView mav = l.getLoginForm(u, null, "logout");
		Map<String, Object> movModel = mav.getModel();
		assertEquals(movModel.get("message"), message);
	}
	
	@Test
	public void ErrorGetLoginFormTest() {
		LoginController l = new LoginController();
		String message = "Incorrect username or password !";
		Users u = loginDao.findByUserName("admin");
		ModelAndView mav = l.getLoginForm(u, "error", null);
		Map<String, Object> movModel = mav.getModel();
		assertEquals(movModel.get("message"), message);
	}
	
	@Test
	public void getAdminProfileTest() {
		LoginController l = new LoginController();
		assertEquals(l.getAdminProfile(), "admin");
	}
	
	@Test
	public void getUserProfileTest() {
		LoginController l = new LoginController();
		assertEquals(l.getUserProfile(), "user");
	}

}
