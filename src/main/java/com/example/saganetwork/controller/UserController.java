package com.example.saganetwork.controller;


import com.example.saganetwork.Entity.Role;
import com.example.saganetwork.Entity.User;
import com.example.saganetwork.exception.ResourceNotFoundException;
import com.example.saganetwork.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>>getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }
    @GetMapping("/teachers")
    public ResponseEntity<List<User>>getTeachers(){

        return null;
    }

    @PostMapping("/user/save")
    public ResponseEntity<User>saveUser(@RequestBody User user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role>saveUser(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping("/role/addtuuser")
    public ResponseEntity<Role>addRoleToUser(@RequestBody RoleToUserForm form){
        userService.addRoleToUser(form.getName(),form.getRolName());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get/user/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable(name = "id") Long id){
        User user = userService.getUserById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found User with id = " + id));

       return ResponseEntity.ok().body(Optional.ofNullable(user));
    }

    @DeleteMapping("/delete/user/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteUser(@PathVariable(name = "id") Long id){
        userService.deleteuser(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(name = "id") Long id, @RequestBody User user ){
        User user1 = userService.getUserById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found User with id = " + id));

        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        return ResponseEntity.ok().body(userService.updateUser(user1));
    }


}

@Data
class RoleToUserForm{
    private String name;
    private String rolName;
}
