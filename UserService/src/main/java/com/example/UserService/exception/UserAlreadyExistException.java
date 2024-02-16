package com.example.UserService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (code = HttpStatus.CONFLICT,reason = "User with this emailID already registered with the application")
public class UserAlreadyExistException extends Exception{
}
