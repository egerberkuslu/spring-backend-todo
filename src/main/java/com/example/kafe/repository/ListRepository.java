package com.example.kafe.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.example.kafe.model.TodoList;


public interface ListRepository extends JpaRepository<TodoList, Long> {
	   @Query(value="SELECT * FROM todo_lists WHERE id= :id",nativeQuery=true) TodoList getTodoList(@Param("id") int id);    
}
