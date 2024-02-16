package com.example.UserService.controller;

import com.example.UserService.domain.Address;
import com.example.UserService.domain.StarredTasks;
import com.example.UserService.domain.User;
import com.example.UserService.exception.StarredTaskNotFoundException;
import com.example.UserService.exception.UserAlreadyExistException;
import com.example.UserService.exception.UserNotFoundException;
import com.example.UserService.service.SecurityTokenGenerator;
import com.example.UserService.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/api/v2")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private UserServiceImpl userService;
    private SecurityTokenGenerator securityTokenGenerator;

    @Autowired
    public UserController(UserServiceImpl userService,SecurityTokenGenerator securityTokenGenerator) {
        this.userService = userService;
        this.securityTokenGenerator = securityTokenGenerator;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) throws UserAlreadyExistException{
        try{
            return new ResponseEntity<>(userService.register(user), HttpStatus.CREATED);
        }catch (UserAlreadyExistException c){
            throw new UserAlreadyExistException();
        }
        catch (Exception e){
            return new ResponseEntity<>("Server Error server down", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/getallmapping")
    public ResponseEntity getallusers(){
        return new ResponseEntity<>(userService.getallUsers(),HttpStatus.OK);
    }

    @PutMapping("/updateuser/{email}")
    public  ResponseEntity updateUsers(@PathVariable String email, User user) throws UserNotFoundException {
       try {
           return new ResponseEntity(userService.updateUser(email, user), HttpStatus.OK);
       }
       catch (UserNotFoundException e){
           throw new UserNotFoundException();
       }
       catch (Exception e){
           return new ResponseEntity<>("Server Error server down", HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

    @DeleteMapping("/deletemapping/{email}")
    public ResponseEntity deleteUser(@PathVariable String email) throws UserNotFoundException{
        try {
            return new ResponseEntity(userService.deleteUser(email),HttpStatus.NO_CONTENT);
        }
        catch (UserNotFoundException e){
            throw new UserNotFoundException();
        }
        catch (Exception e){
            return new ResponseEntity<>("Server Error server down", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/addstarred/{email}")
    public ResponseEntity addstarred(@PathVariable String email, @RequestBody StarredTasks starredTask) throws UserNotFoundException {
        try{
            return new ResponseEntity(userService.addStarred(email,starredTask),HttpStatus.OK);
        }
        catch (UserNotFoundException e){
            throw new UserNotFoundException();
        }
        catch (Exception e){
            return new ResponseEntity<>("Server Error server down", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deletestarred")
    public ResponseEntity deletestarred (@PathVariable String email, @RequestBody StarredTasks starredTask) throws UserNotFoundException {
        try {
            return new ResponseEntity(userService.deleteStarred(email,starredTask),HttpStatus.NO_CONTENT);
        }
        catch (UserNotFoundException e){
            throw new UserNotFoundException();
        }
        catch (Exception e){
            return new ResponseEntity<>("Server Error server down", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getstarredtasksbystatus/{email}")
    public ResponseEntity getstarredtasksbystatus (@PathVariable String email) throws StarredTaskNotFoundException, UserNotFoundException {
        try {
            return new ResponseEntity(userService.getStarredTasksByStatus(email),HttpStatus.OK);
        }
        catch (UserNotFoundException e){
            throw new UserNotFoundException();
        }
        catch (StarredTaskNotFoundException e){
            throw new StarredTaskNotFoundException();
        }
        catch (Exception e){
            return new ResponseEntity<>("Server Error server down", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editaddress/{email}")
    public ResponseEntity editaddress(@PathVariable String email, @RequestBody Address address) throws UserNotFoundException {
        try{
            return new ResponseEntity(userService.editAddress(email,address),HttpStatus.OK);
        }
        catch (UserNotFoundException e){
            throw new UserNotFoundException();
        }
        catch (Exception e){
            return new ResponseEntity<>("Server Error server down", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteaddress/{email}")
    public ResponseEntity deleteaddress (@PathVariable String email) throws UserNotFoundException {
        try {
            return new ResponseEntity(userService.deleteAddress(email),HttpStatus.NO_CONTENT);
        }
        catch (UserNotFoundException e){
            throw new UserNotFoundException();
        }
        catch (Exception e){
            return new ResponseEntity<>("Server Error server down", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
