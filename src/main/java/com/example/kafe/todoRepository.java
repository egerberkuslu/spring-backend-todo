package com.example.kafe;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.kafe.todo;

public interface todoRepository extends CrudRepository<todo, Integer> {
	
	
	
	@Query(value="SELECT * FROM todo_elements WHERE id= :id",nativeQuery=true) Iterable<todo> getById(@Param("id") int id);
	
	@Modifying
	@Query(value="INSERT INTO todo_elements ("+"name,"+"date"+","+"describtion,"+"image"+") VALUES (:name,:date,:desc,:img)",nativeQuery=true) @Transactional void add_todo(@Param("name") String name, @Param("date") String date,@Param("desc") String desc,@Param("img") String img);
	
	@Modifying
	@Query(value="DELETE FROM todo_elements WHERE id= :id",nativeQuery=true) @Transactional void  delete_todo(@Param("id") int id);
	
	
	@Modifying
	@Query(value="UPDATE todo_elements SET name= :name, date= :date, describtion= :desc, image = :img WHERE id = :id ",nativeQuery=true) @Transactional void update_todo(@Param("name") String name, @Param("date") String date,@Param("desc") String desc,@Param("img") String img,@Param("id") int id);



}
