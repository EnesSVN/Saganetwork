package com.example.saganetwork.service.impl;

import com.example.saganetwork.Entity.Role;
import com.example.saganetwork.Entity.User;
import com.example.saganetwork.repository.RoleRp;
import com.example.saganetwork.repository.UserRp;
import com.example.saganetwork.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRp userRp;
    private final RoleRp roleRp;
    @Override
    public User saveUser(User user) {
        return userRp.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRp.save(role);
    }

    @Override
    public void addRoleToUser(String name, String roleName) {
        User user = userRp.findByName(name);
        Role role = roleRp.findByRoleName(roleName);
        user.getRoles().add(role);
    }


    @Override
    public User getUser(String name) {
        return userRp.findByName(name);
    }

    @Override
    public List<User> getUsers() {
        return userRp.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRp.findById(id);
    }

    @Override
    public void deleteuser(Long id) {
        userRp.deleteById(id);
    }

    @Override
    public User updateUser(User user) {
        return userRp.save(user);
    }


}
