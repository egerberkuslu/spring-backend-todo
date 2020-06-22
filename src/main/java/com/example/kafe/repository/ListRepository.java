package com.example.kafe.repository;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.example.kafe.model.TodoList;


public interface ListRepository extends JpaRepository<TodoList, Long> {
	   @Query(value="SELECT todo_lists.name, todo_lists.id,todo_lists.date,todo_lists.user_id FROM todo_lists INNER JOIN user_and_lists ON todo_lists.id = user_and_lists.list_id INNER JOIN users ON user_and_lists.user_id = users.id WHERE users.id = :aydi ;"
	   		,nativeQuery=true) Iterable <TodoList> getTodoList(@Param("aydi") Long aydi);    
	   
	   @Modifying
	   @Query(value="INSERT INTO todo_lists (name,date,user_id) values(:neym, :deyt, :user_aydi )",nativeQuery=true) @Transactional void addTodoList(@Param("neym") String neym,@Param("deyt") String deyt,@Param("user_aydi") Long user_aydi); 
}
