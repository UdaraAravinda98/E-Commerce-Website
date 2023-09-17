package com.store.Booktown.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.Booktown.DTO.ResponseDto;
import com.store.Booktown.DTO.Users.SignInResponseDto;
import com.store.Booktown.DTO.Users.SignUpDto;
import com.store.Booktown.DTO.Users.SigninDto;
import com.store.Booktown.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userservice;
	
	//sign up
	@PostMapping("/signup")
	public ResponseDto signUp(@RequestBody SignUpDto signupdto) {
		return userservice.signUp(signupdto);
	}
	
	
	//sign in
	@PostMapping("/signin")
	public SignInResponseDto signIn(@RequestBody SigninDto signindto) {
		return userservice.signIn(signindto);
	}

}
