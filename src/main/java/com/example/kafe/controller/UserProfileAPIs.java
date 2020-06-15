package com.example.kafe.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafe.message.request.UserProfile;
import com.example.kafe.model.User;
import com.example.kafe.repository.UserProfileRepository;
import com.example.kafe.repository.UserRepository;
import com.example.kafe.security.jwt.JwtProvider;


@CrossOrigin
@RestController
public class UserProfileAPIs {
	 @Autowired
	 UserProfileRepository userProfileRepository;
	 
	 @Autowired
	 UserRepository userRepository;
	 
	 @Autowired
	 private JwtProvider tokenProvider;
	 
	
	
	 
	 @GetMapping("/profile")
	 public @ResponseBody UserProfile getAll(@RequestHeader("Authorization") String bearerToken) {
	     System.out.println("bearerToken"+bearerToken);
		 bearerToken = bearerToken.replace("Bearer ","");
		 String username  = tokenProvider.getUserNameFromJwtToken(bearerToken);
		 User user = userRepository.findUserByUsername(username);
		 
		 
		 UserProfile userProfile = userProfileRepository.getProfile(username);
		 userProfile.setRoles(user.getRoles());
		 System.out.println("User Profile :"+userProfile.toString());
		 return userProfile;
	 }
	 
	
}
