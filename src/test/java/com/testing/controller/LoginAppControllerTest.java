package com.testing.controller;

import static org.junit.Assert.*;

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
	public void testcode() {
		Users u = loginDao.findByUserName("admin");
	}

	@Test
	public void getLoginFormTest() {
		LoginController l = new LoginController();
		Users u = loginDao.findByUserName("admin");
		System.out.println(l.getLoginForm(u, null, null));
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
	
	@Test
	public void getAccessDeniedTest() {
		LoginController l = new LoginController();
	}

}
