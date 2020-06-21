package com.example.kafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafe.model.Updates;
import com.example.kafe.repository.UpdatesRepository;


@CrossOrigin
@RestController
public class UpdateAPIs {
	
	 @Autowired
	 UpdatesRepository updatesRepository;
	 
	 @GetMapping("/updates")
	 public @ResponseBody Iterable<Updates> getAll() {
	   
		 return updatesRepository.getUpdates();
	 }
	 
}
