package com.tts.Radiate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String landingPage() {
		return "pages/index";
	}
	
//	@RequestMapping("/login")
//	public String loginPage() {
//		return "pages/login";
//	}
	
	@RequestMapping("/signUp")
	public String registrationPage() {
		return "pages/registration";
	}
	
	
}
