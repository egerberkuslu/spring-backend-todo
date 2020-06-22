package com.example.kafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafe.model.TodoList;
import com.example.kafe.model.User;
import com.example.kafe.repository.ListRepository;
import com.example.kafe.repository.UserRepository;
import com.example.kafe.security.jwt.JwtProvider;

@CrossOrigin
@RestController
public class TodoListAPIs {
	 @Autowired
	 ListRepository listRepository;
	
	 
	 @Autowired
	 private JwtProvider tokenProvider;
	 
	 @Autowired
	 private UserRepository userRepository;
	 
	 @GetMapping("/list")
	 public @ResponseBody Iterable<TodoList> getAll(@RequestHeader("Authorization") String token) {
		 
		 token = token.replace("Bearer ","");
		 String username  = tokenProvider.getUserNameFromJwtToken(token);
		 User user = userRepository.findUserByUsername(username);
		 
		 return listRepository.getTodoList(user.getId());
	 }
	
}
