package com.microden.in;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microden.in.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
	UserEntity findByemailAdress(String emailAdress);
 
}
