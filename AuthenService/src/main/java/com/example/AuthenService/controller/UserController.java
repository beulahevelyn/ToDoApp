package com.example.AuthenService.controller;

import com.example.AuthenService.domain.User;
import com.example.AuthenService.exception.UserNotFoundException;
import com.example.AuthenService.service.SecurityTokenGenerator;
import com.example.AuthenService.service.UserServiceImpl;
import com.example.AuthenService.service.iUserservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
//@RequestMapping("/api/v1")
//@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    private UserServiceImpl userService;
    private SecurityTokenGenerator securityTokenGenerator;

    @Autowired
    public UserController(UserServiceImpl userService, SecurityTokenGenerator securityTokenGenerator) {
        this.userService = userService;
        this.securityTokenGenerator = securityTokenGenerator;
    }

    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody User user){
        return new ResponseEntity<>(userService.saveUser(user),HttpStatus.CREATED);
    }

    @GetMapping("/api/v1/getallusers")
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.FOUND);
    }

    @PutMapping("updateuser/{email}")
    public ResponseEntity<?> updateUser(@RequestBody User user,@PathVariable String email){
        return new ResponseEntity<>(userService.updateUser(user,email),HttpStatus.OK);
    }

    @DeleteMapping("deleteuser/{email}")
    public ResponseEntity<?> deleteUserByEmail(@PathVariable String email){
        return new ResponseEntity<>(userService.deleteUserByEmail(email),HttpStatus.OK);
    }

    @GetMapping("/api/v1/getusersbyname/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name){
        return new ResponseEntity<>(userService.findByName(name),HttpStatus.FOUND);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) throws UserNotFoundException {
        User retrievedUser = userService.login(user);
        if(retrievedUser!=null){
            return new ResponseEntity<>(securityTokenGenerator.generateToken(retrievedUser),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Authorization failed....",HttpStatus.NOT_FOUND);
        }
}

}
