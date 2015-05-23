package com.testing.controller;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;

import com.testing.controller.LoginController;
import com.testing.models.login.Users;

public class LoginAppControllerTest {

	@Test
	public void getUserDefaulttest() {
		LoginController l = new LoginController();
		assertEquals(l.getUserDefault(), "home");
	}

	@Test
	public void getLoginFormTest() {
		LoginController l = new LoginController();
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
