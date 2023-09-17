package com.store.Booktown.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArtController {
	

	@GetMapping("/art")
	public String art() {
		return "art";
	}
	
	

}
