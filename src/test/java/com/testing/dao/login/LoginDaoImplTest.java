package com.testing.dao.login;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.testing.controller.LoginAppControllerTest;
import com.testing.models.login.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring-security.xml", 
	"file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml"
})
@WebAppConfiguration
public class LoginDaoImplTest {
	private static final Logger logger = Logger
			.getLogger(LoginAppControllerTest.class);

	@Autowired
	LoginDao loginDao;
	
	@Test
	public void AdminFindByUserNameTest() {
		Users u = loginDao.findByUserName("admin");
		assertEquals(u.getUsername(), "admin");
		assertEquals(u.getPassword(), "23d42f5f3f66498b2c8ff4c20b8c5ac826e47146");
	}
	
	@Test
	public void UserFindByUserNameTest() {
		Users u = loginDao.findByUserName("user");
		assertEquals(u.getUsername(), "user");
		assertEquals(u.getPassword(), "68c9fc4c03dff5d734aab9787b5ea01d7d88aa85");
	}

}
