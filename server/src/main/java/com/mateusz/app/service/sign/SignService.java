package com.mateusz.app.service.sign;

import com.mateusz.app.message.request.RegisterRequest;
import com.mateusz.app.message.request.SignInRequest;
import com.mateusz.app.message.response.JwtResponse;
import org.springframework.stereotype.Service;

@Service
public interface SignService {
    void signUp(RegisterRequest signUpRequest);

    JwtResponse signIn(SignInRequest signInRequest);
}
