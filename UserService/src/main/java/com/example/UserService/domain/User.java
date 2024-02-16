package com.example.UserService.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class User {
    @Id
    private String email;
    private String password;
    private String name;
    private long phoneNo;
    private String role;
    List<Address> address;
    List<StarredTasks> starredTasks;

    public User(){}

    public User(String email, String password, String name, long phoneNo, String role, List<Address> address, List<StarredTasks> starredTasks) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phoneNo = phoneNo;
        this.role = role;
        this.address = address;
        this.starredTasks = starredTasks;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public List<StarredTasks> getStarredTasks() {
        return starredTasks;
    }

    public void setStarredTasks(List<StarredTasks> starredTasks) {
        this.starredTasks = starredTasks;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phoneNo=" + phoneNo +
                ", role='" + role + '\'' +
                ", address=" + address +
                ", starredTasks=" + starredTasks +
                '}';
    }
}
