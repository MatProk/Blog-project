package com.mateusz.app.controller;

import com.mateusz.app.message.request.RegisterRequest;
import com.mateusz.app.message.request.SignInRequest;
import com.mateusz.app.message.response.JwtResponse;
import com.mateusz.app.service.sign.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class SignController {

	@Autowired
	SignService signService;

	public SignController(SignService signService) {
		this.signService = signService;
	}


	@PostMapping("/signin")
	public JwtResponse authenticateUser(@RequestBody SignInRequest loginRequest) {
		return signService.signIn(loginRequest);
	}

	@PostMapping("/signup")
	public void signUp(@RequestBody RegisterRequest signUpRequest) {
		signService.signUp(signUpRequest);
	}
}