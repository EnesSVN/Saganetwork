package com.example.saganetwork.service;

import com.example.saganetwork.Entity.Role;
import com.example.saganetwork.Entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User saveUser(User user);
    Role saveRole(Role role);

    void addRoleToUser(String name,String roleName);

    User getUser(String name);

    List<User> getUsers();

    Optional<User> getUserById(Long id);

    void deleteuser(Long id);

    User updateUser(User user);

}
