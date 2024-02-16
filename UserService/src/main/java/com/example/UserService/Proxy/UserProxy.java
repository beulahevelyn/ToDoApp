package com.example.UserService.Proxy;

import com.example.UserService.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="AuthenService", url="http://localhost:8080/")
public interface UserProxy {
      @PostMapping("register")
    public ResponseEntity<?> save(@RequestBody User user);
}
