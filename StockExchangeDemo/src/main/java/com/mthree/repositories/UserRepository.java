package com.mthree.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mthree.models.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

	
	@Query("SELECT new com.mthree.models.User(u.userId,u.fullname,u.email,u.password) from User u where email=:email ")
	User findByEmail(@Param("email") String email);

	
	//select u from User u where u.emailAddress = ?1 and u.lastname = ?
}
