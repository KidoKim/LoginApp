package com.testing.models.login;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring-security.xml", 
	"file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml"
})
@WebAppConfiguration
public class UserRoleTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
