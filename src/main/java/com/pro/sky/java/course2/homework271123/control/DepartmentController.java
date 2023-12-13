package com.pro.sky.java.course2.homework271123.control;

import com.pro.sky.java.course2.homework271123.model.Employee;
import com.pro.sky.java.course2.homework271123.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;


    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping
    public String sayWelcome() {
        return "Операции по отделам";
    }

    @GetMapping("/min-salary")
    public Employee getMinSalaryEmployeeInDept(@RequestParam(value = "departmentId", required = true) Integer department) {
        return departmentService.getMinSalaryEmployeeInDept(department);
    }
    @GetMapping("/max-salary")
    public Employee getMaxSalaryEmployeeInDept(@RequestParam(value = "departmentId", required = true) Integer department) {
        return departmentService.getMaxSalaryEmployeeInDept(department);
    }
    @GetMapping("/all")
    private Collection printDepartmentEmployeeList(@RequestParam(value = "departmentId", required = false) Integer department) {
            return departmentService.getDepartmentEmployeeList(department);
    }
}
