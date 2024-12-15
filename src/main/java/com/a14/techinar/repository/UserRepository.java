package com.a14.techinar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.a14.techinar.entity.User;

@Repository()
public interface UserRepository extends JpaRepository<User, Integer> {

}
