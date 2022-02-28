package com.srirup.microservices.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srirup.microservices.userservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
