package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

public interface UserRepo extends JpaRepository<User, Long>
{
	com.example.demo.User findByUsername(String username);
	
//	User findByUsername(String username);
}
