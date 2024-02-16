package com.example.AuthenService.repository;

import com.example.AuthenService.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,String> {


    User findByEmailAndPassword(String email, String Password);
    List<User> findByName(String name);
}
