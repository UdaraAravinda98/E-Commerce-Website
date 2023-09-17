package com.store.Booktown.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutusController {
	
	@GetMapping("/aboutus")
	public String aboutus() {
		return "aboutus";
	}

}
