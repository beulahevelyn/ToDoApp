package com.example.AuthenService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "User with this 'emailID' already registered on the application")
public class UserAlreadyExsitsException {
}
