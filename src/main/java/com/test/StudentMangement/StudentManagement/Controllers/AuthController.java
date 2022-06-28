package com.test.StudentMangement.StudentManagement.Controllers;

import com.test.StudentMangement.StudentManagement.Models.Student;
import com.test.StudentMangement.StudentManagement.Payload.Request.LoginRequest;
import com.test.StudentMangement.StudentManagement.Payload.Response.JwtResponse;
import com.test.StudentMangement.StudentManagement.Security.StudentDetailService;
import com.test.StudentMangement.StudentManagement.Security.jwt.JwtUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest){
        logger.error(loginRequest.getEmail()+"---->"+loginRequest.getPassword());
        Authentication authentication= authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt= jwtUtils.generateJwtToken(authentication);
        Student student= (Student) authentication.getPrincipal();

            return ResponseEntity.ok(new JwtResponse(jwt));
    }

}
