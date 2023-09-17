package com.store.Booktown.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommerceController {
	
	@GetMapping("/commerce")
	public String commerce() {
		return "commerce";
	}

}
