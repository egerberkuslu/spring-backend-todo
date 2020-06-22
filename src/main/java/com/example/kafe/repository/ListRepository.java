package com.example.kafe.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.example.kafe.model.TodoList;


public interface ListRepository extends JpaRepository<TodoList, Long> {
	   @Query(value="SELECT \r\n" + 
	   		"   	todo_lists.name,\r\n" + 
	   		"   	todo_lists.id,\r\n" + 
	   		"    todo_lists.date\r\n" + 
	   		"    \r\n" + 
	   		"FROM\r\n" + 
	   		"    todo_lists \r\n" + 
	   		"INNER JOIN user_and_lists  \r\n" + 
	   		"    ON todo_lists.id = user_and_lists.list_id\r\n" + 
	   		"INNER JOIN users\r\n" + 
	   		"	ON user_and_lists.user_id = users.id\r\n" + 
	   		"   \r\n" + 
	   		"WHERE users.id = :aydi ;",nativeQuery=true) Iterable <TodoList> getTodoList(@Param("aydi") Long aydi);    
}
