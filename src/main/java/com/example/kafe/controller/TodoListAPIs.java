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

@CrossOrigin
@RestController
public class TodoListAPIs {
	 @Autowired
	 ListRepository listRepository;
	
	 @GetMapping("/list")
	 public @ResponseBody TodoList getAll(@RequestHeader("list_id") int list_id) {
		 return listRepository.getTodoList(list_id);
	 }
}
