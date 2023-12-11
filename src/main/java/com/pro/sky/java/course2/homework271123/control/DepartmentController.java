package com.pro.sky.java.course2.homework271123.control;

import com.pro.sky.java.course2.homework271123.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public String getMinSalaryEmployeeInDept(@RequestParam(value = "departmentId", required = true) int department) {
        return "Сотрудник с минимальной зарплатой: " + departmentService.getNameOfMinSalaryEmployeeInDept(department);
    }
    @GetMapping("/max-salary")
    public String getMaxSalaryEmployeeInDept(@RequestParam(value = "departmentId", required = true) int department) {
        return "Сотрудник с максимальной зарплатой: " + departmentService.getNameOfMaxSalaryEmployeeInDept(department);
    }
    @GetMapping("/all")
    private String printDepartmentEmployeeList(@RequestParam(value = "departmentId", required = false) Integer department) {
            return departmentService.getDepartmentEmployeeList(department);
    }


}
