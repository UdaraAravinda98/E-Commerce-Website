package com.store.Booktown.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactusController {
	
	@GetMapping("/contactus")
	public String contactus() {
		return "contactus";
	}

}
