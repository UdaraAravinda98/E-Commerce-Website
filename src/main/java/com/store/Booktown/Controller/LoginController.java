package com.store.Booktown.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String art() {
		return "Login";
	}
	
	
	@GetMapping("/login/register")
	public String logToreg() {
		return "Register";
	}
	
	
}
