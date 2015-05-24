package com.testing.models.login;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.testing.controller.LoginAppControllerTest;
import com.testing.dao.login.LoginDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring-security.xml", 
	"file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml"
})
@WebAppConfiguration
public class UsersTest {
	
	private static final Logger logger = Logger
			.getLogger(LoginAppControllerTest.class);

	@Autowired
	LoginDao loginDao;
	
	@Autowired
	SessionFactory sessionFactory;
	
	Session session = null;
	Transaction tx = null;
	
	@Test
	public void SuccessUserstest() {
		session = sessionFactory.openSession();
		tx = session.getTransaction();
		Users user = new Users();
		String username = "admin1";
		String password = "admin1@123";
		user.setUsername(username);
		user.setPassword(password);
		session.beginTransaction();
		session.save(user);
		tx.commit();		
		
		session.beginTransaction();
		Users user1 = (Users) session.load(Users.class, "admin1");
		session.delete(user1);
		tx.commit();
	}
	
	/*
	@Test(expected=)
	public void FailUserstest() {
		session = sessionFactory.openSession();
		tx = session.getTransaction();
		Users user = new Users();
		String username = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		String password = "a@123";
		user.setUsername(username);
		user.setPassword(password);
		session.beginTransaction();
		session.save(user);
		tx.commit();
	}
	*/
	
	/*
	@Test()
	public void FailPasswordTest() {
		session = sessionFactory.openSession();
		tx = session.getTransaction();
		Users user = new Users();
		String username = "admin2";
		String password = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		user.setUsername(username);
		user.setPassword(password);
		session.beginTransaction();
		session.save(user);
		tx.commit();
	}
	*/
}

