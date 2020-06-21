package com.example.kafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;


import com.example.kafe.model.Updates;

@Repository
public interface UpdatesRepository  extends JpaRepository<Updates, Long>  {
	@Query(value="SELECT * FROM updates",nativeQuery=true) Iterable<Updates> getUpdates();    
}
