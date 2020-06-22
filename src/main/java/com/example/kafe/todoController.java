package com.example.kafe;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.kafe.model.User;
import com.example.kafe.repository.UserRepository;
import com.example.kafe.security.jwt.JwtProvider;

@CrossOrigin
@Controller
public class todoController {
	
	@Autowired
	private todoRepository todorepo; 
	 
	@Autowired
	private JwtProvider tokenProvider; 
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/todo")
	public @ResponseBody Iterable<todo> getAll() {
		return todorepo.findAll();
	}
	@RequestMapping("/todo/{id}")
	public @ResponseBody Iterable<todo> getOne(@PathVariable("id") int id) {
		return todorepo.getById(id);
	}
	@RequestMapping("/todo/delete/{id}")
	public void deleteOne(@PathVariable("id") int id) {
		todorepo.delete_todo(id);
	}
	@PostMapping(path="/todo/add")
	public @ResponseBody void addtodo(@RequestBody todo new_todo) {
		todorepo.add_todo(new_todo.getName(), new_todo.getStart_date(), new_todo.getDescribtion(),new_todo.getImage(),new_todo.getEnd_date(),new_todo.getList_details().getId());
	}
	@PostMapping(path="/todo/update")
	public @ResponseBody void updatetodo(@RequestBody todo new_todo) {
		todorepo.update_todo(new_todo.getName(), new_todo.getStart_date(), new_todo.getDescribtion(),new_todo.getImage(),new_todo.getId());
	}
	@RequestMapping("/todo/list")
	public @ResponseBody Iterable<todo> getbyList(@RequestHeader("Authorization") String token,@RequestHeader("list_id") int list_id) {
		 token = token.replace("Bearer ","");
		 String username  = tokenProvider.getUserNameFromJwtToken(token);
		 User user = userRepository.findUserByUsername(username);
		 return todorepo.getByList(user.getId(),list_id);		 
	}
	
	
}
