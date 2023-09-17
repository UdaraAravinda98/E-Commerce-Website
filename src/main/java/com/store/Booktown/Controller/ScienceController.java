package com.store.Booktown.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ScienceController {
	

	@GetMapping("/science")
	public String science() {
		return "science";
	}

}
