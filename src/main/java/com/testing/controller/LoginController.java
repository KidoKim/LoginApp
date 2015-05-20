package com.testing.controller;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.testing.models.login.Users;

@Controller
public class LoginController {
	private static final Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
     private ShaPasswordEncoder passwordEncoder;
	 
	@RequestMapping(value = { "/", "/home" })
	public String getUserDefault() {
		return "home";
	}
	
	@RequestMapping(value = { "/testencode" })
	public String testEncode() {
		String user_password = passwordEncoder.encodePassword("user@123", null);
	    String admin_password = passwordEncoder.encodePassword("admin@123", null);
	    logger.info(user_password + "//" + admin_password);
		return "home";
	}
	
	@RequestMapping("/login")
	public ModelAndView getLoginForm(@ModelAttribute Users users,
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		String message = "";
		if (error != null) {
			message = "Incorrect username or password !";
		} else if (logout != null) {
			message = "Logout successful !";
		}
		return new ModelAndView("login", "message", message);
	}

	@RequestMapping("/admin**")
	public String getAdminProfile() {
		return "admin";
	}

	@RequestMapping("/user**")
	public String getUserProfile() {
		return "user";
	}

	@RequestMapping("/403")
	public ModelAndView getAccessDenied() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String username = "";
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			username = userDetail.getUsername();
		}

		return new ModelAndView("403", "username", username);
	}

}
