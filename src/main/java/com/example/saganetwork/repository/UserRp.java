package com.example.saganetwork.repository;

import com.example.saganetwork.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRp extends JpaRepository<User,Long> {

    User findByName(String name);


}
