package com.pro.sky.java.course2.homework271123.exception;

import com.pro.sky.java.course2.homework271123.model.Employee;
import com.pro.sky.java.course2.homework271123.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BANDWIDTH_LIMIT_EXCEEDED, reason = "EmployeeStorageIsFull")
public class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException(String s) {
        super();
    }
}
