package com.store.Booktown.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {
	
	@GetMapping("/register")
	public String gotoRegister() {
		return "Register";
	}
	
	

}
