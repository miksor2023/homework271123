package com.pro.sky.java.course2.homework271123.exception;

import com.pro.sky.java.course2.homework271123.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "EmployeeNotFound")
public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String s) {
        super();
    }
}
