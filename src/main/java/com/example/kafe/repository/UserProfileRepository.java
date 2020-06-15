package com.example.kafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.kafe.message.request.UserProfile;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, String>  {
   @Query(value="SELECT name,username,email FROM users WHERE username= :username",nativeQuery=true) UserProfile getProfile(@Param("username") String username);    
  
}
