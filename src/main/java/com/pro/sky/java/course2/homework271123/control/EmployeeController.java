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
    };
    @GetMapping
    public String sayWelcome() {
        return "Добро пожаловать в книгу учёта сотрудников";
    }
    @GetMapping("/add")
    public Employee addEmployee (@RequestParam(name = "firstName", required = true) String firstName,
                                 @RequestParam(name = "lastName", required = true) String lastName) {
        return employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee (@RequestParam(name = "firstName", required = true) String firstName,
                                  @RequestParam(name = "lastName", required = true) String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }
    @GetMapping("/remove")
    public Employee removeEmployee (@RequestParam(name = "firstName", required = true) String firstName,
                                    @RequestParam(name = "lastName", required = true) String lastName) {

        return employeeService.removeEmployee(firstName, lastName);
    }
    @GetMapping("/print")
    public Collection<Employee> printEmployeeList() {
        return employeeService.returnEmployeeList();
    }
    @GetMapping("/load")
    public Map<String,Employee> loadEmployeeList() {
        return employeeService.loadEmployeeList();
    }
}
