package com.store.Booktown.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BuyNowController {
	
	@GetMapping("/buynow")
	public String buynow() {
		return "BuyNow";
	}

}
