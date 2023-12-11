package com.pro.sky.java.course2.homework271123.control;

import com.pro.sky.java.course2.homework271123.model.Employee;
import com.pro.sky.java.course2.homework271123.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    ;

    @GetMapping
    public String sayWelcome() {
        return "Добро пожаловать в книгу учёта сотрудников";
    }

    @GetMapping("/add")
    public String addEmployee(@RequestParam(name = "firstName", required = true) String firstName,
                                @RequestParam(name = "lastName", required = true) String lastName,
                                @RequestParam(name = "salary", required = true) double salary,
                                @RequestParam(name = "department", required = true) int department) {
        return employeeService.addEmployee(firstName, lastName, salary, department);
    }

    @GetMapping("/find")
    public String findEmployee(@RequestParam(name = "firstName", required = true) String firstName,
                                 @RequestParam(name = "lastName", required = true) String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam(name = "firstName", required = true) String firstName,
                                   @RequestParam(name = "lastName", required = true) String lastName) {

        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping("/print")
    public String printEmployeeList() {
        return employeeService.returnAllEmployeeListByString();
    }

    @GetMapping("/load")
    public String loadEmployeeList() {
        employeeService.loadEmployeeList();
        return employeeService.returnAllEmployeeListByString();
    }
}
