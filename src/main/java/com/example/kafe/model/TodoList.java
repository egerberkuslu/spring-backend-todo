package com.example.kafe.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.kafe.todo;

@Entity
@Table(name="todo_lists")
public class TodoList {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    
    private String name;
 
    private String date;
    
    private Long user_id;
    
    @OneToMany(mappedBy="list_details")
    private Set<todo> todos;
    
    public TodoList() {}

	public TodoList(Long id, String name, String date) {
		this.id = id;
		this.name = name;
		this.date = date;
	}

	public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
 
 
   
}
