package com.mthree.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mthree.models.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

}
