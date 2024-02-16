package com.example.UserService.service;

import com.example.UserService.Proxy.UserProxy;
import com.example.UserService.domain.Address;
import com.example.UserService.domain.StarredTasks;
import com.example.UserService.domain.User;
import com.example.UserService.exception.StarredTaskNotFoundException;
import com.example.UserService.exception.UserAlreadyExistException;
import com.example.UserService.exception.UserNotFoundException;
import com.example.UserService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements iUserService{

    private UserRepository userRepository;
    private UserProxy userproxy;

    @Autowired
    public UserServiceImpl(UserProxy userproxy, UserRepository userRepository) {
        this.userproxy=userproxy;
        this.userRepository = userRepository;
    }

    @Override
    public User register(User user) throws UserAlreadyExistException {
        if(userRepository.findById(user.getEmail()).isPresent()){
            throw new UserAlreadyExistException();
        }
        userproxy.save(user);
        return userRepository.save(user);
    }

    @Override
    public List<User> getallUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(String email, User user) throws UserNotFoundException {
        if(userRepository.findById(email).isEmpty()){
            throw new UserNotFoundException();
        }

        User existingUser = userRepository.findById(email).get();

        if(user.getName()!=null){
            existingUser.setName(user.getName());
        }
        if(user.getPhoneNo()!=0){
            existingUser.setPhoneNo(user.getPhoneNo());
        }
        if(user.getRole()!=null){
            existingUser.setRole(user.getRole());
        }
        if(user.getPassword()!=null){
            existingUser.setPassword(user.getPassword());
        }

        return userRepository.save(existingUser);
    }

    @Override
    public User deleteUser(String email) throws UserNotFoundException {
        if(userRepository.findById(email).isEmpty()){
            throw new UserNotFoundException();
        }
        User deleteUser = userRepository.findById(email).get();
        userRepository.delete(deleteUser);
        return deleteUser;
    }

    @Override
    public User addStarred(String email, StarredTasks starredTask) throws UserNotFoundException {
        if(userRepository.findById(email).isEmpty()){
            throw new UserNotFoundException();
        }
        User user =userRepository.findById(email).get();
        boolean starredItemAlreadyExists = false;

        if(user.getStarredTasks()!=null){
            for(StarredTasks list: user.getStarredTasks()){

                if(list.getStarred()==false) {
                    if (list.getTaskname().equals(starredTask.getTaskname())) {
                        starredItemAlreadyExists = true;
                        starredTask.setStarred(true);
                        break;
                    }
                }
            }
        }

        if(!starredItemAlreadyExists){
            if(user.getStarredTasks()==null){
                user.setStarredTasks(new ArrayList<>());
            }
            user.getStarredTasks().add(starredTask);
        }

        userRepository.save(user);
        return user;
    }

    @Override
    public User deleteStarred(String email, StarredTasks starredTask) throws UserNotFoundException {
      if(userRepository.findById(email).isEmpty()){
          throw new UserNotFoundException();
      }
      User user = userRepository.findById(email).get();
      boolean starredItemAlreadyExists = false;
      if(user.getStarredTasks()!=null){
          for(StarredTasks list : user.getStarredTasks()){
              if(list.getTaskid().equals(starredTask.getTaskid())){
                  starredItemAlreadyExists = true;
                  user.getStarredTasks().remove(starredTask);
                  break;
              }
          }
      }
      userRepository.save(user);
        return user;
    }

    @Override
    public List<StarredTasks> getStarredTasksByStatus(String email) throws StarredTaskNotFoundException, UserNotFoundException {
       if(userRepository.findById(email).isEmpty()){
           throw new UserNotFoundException();
       }

       List<StarredTasks> starred = userRepository.findById(email).get().getStarredTasks();
       if (starred.isEmpty()){
           throw new StarredTaskNotFoundException();
       }
        return starred;
    }

    @Override
    public User editAddress(String email, Address address) throws UserNotFoundException {
        if(userRepository.findById(email).isEmpty()){
            throw new UserNotFoundException();
        }

        User user = userRepository.findById(email).get();
        user.getAddress().add(address);

        userRepository.save(user);
        return user;
    }

    @Override
    public User deleteAddress(String email) throws UserNotFoundException {
        if(userRepository.findById(email).isEmpty()){
            throw new UserNotFoundException();
        }

        User user = userRepository.findById(email).get();
        boolean userAddressExists = false;
        if(user.getAddress()!=null){
            user.setAddress(null);
        }
        return user;
    }
}
