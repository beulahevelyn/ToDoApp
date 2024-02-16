package com.example.AuthenService.service;

import com.example.AuthenService.domain.User;
import com.example.AuthenService.exception.UserNotFoundException;
import com.example.AuthenService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements iUserservice{
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user, String email) {
        Optional<User> optUser = userRepository.findById(email);
        if(optUser.isEmpty()) {
            return null;
        }
        User exisitingUser=optUser.get();
        if(user.getName()!=null){
            exisitingUser.setName(user.getName());
        }
        if(user.getPhoneNo()!=0){
            exisitingUser.setPhoneNo(user.getPhoneNo());
        }
        if(user.getRole()!=null){
            exisitingUser.setRole(user.getRole());
        }
        if(user.getPassword()!=null){
            exisitingUser.setPassword(user.getPassword());
        }

       return userRepository.save(exisitingUser);
    }

    @Override
    public boolean deleteUserByEmail(String email) {
        User user = userRepository.findById(email).get();

        if(user.getEmail().equals(email)){
            userRepository.deleteById(email);
            return true;
        }
        return false;
    }

    @Override
    public List<User> findByName(String name) {

        return userRepository.findByName(name);
    }

    @Override
    public User login(User user) throws UserNotFoundException {
        User user1 = userRepository.findByEmailAndPassword(user.getEmail(),user.getPassword());
        if(user1==null){
            throw new UserNotFoundException();
        }
        return user;
    }
}
