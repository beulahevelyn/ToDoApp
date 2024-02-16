package com.example.AuthenService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND,reason = "Email ID not registered")
public class UserNotFoundException extends Exception{
}
