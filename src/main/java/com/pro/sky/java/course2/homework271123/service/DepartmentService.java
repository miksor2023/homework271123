package com.pro.sky.java.course2.homework271123.service;

import com.pro.sky.java.course2.homework271123.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Comparator;

@Service

public class DepartmentService {
    private EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    ;


    //служебный метод, собирающий массив сотрудников по заданному отделу
    private List<Employee> makeDepartmentArray(int department) {
        List<Employee> deptEmployees = employeeService.employeeMap.values().stream()
                .filter(employee -> employee.getDepartment() == department)
                .collect(Collectors.toList());
        return deptEmployees;
    }

    //метод "вывести в консоль список сотрудников по заданному отделу"
    public String getDepartmentEmployeeList(Integer department) {
        if (department != null) {
            List<Employee> deptEmployees = makeDepartmentArray(department);
            if (deptEmployees.size() != 0) {
                String result = "Список сотрудников " +
                        department + " отдела<br />" +
                        employeeService.buidStringFromEmployeeList(deptEmployees);
                return result;
            } else {
                return "В отделе нет сотрудников";
            }
        } else {
            return employeeService.returnAllEmployeeListByString();
        }
    }

    //метод "ищем сотрудника с минимальной зарплатой по отделу"
    public String getNameOfMinSalaryEmployeeInDept(int department) {
        List<Employee> deptEmployees = makeDepartmentArray(department);
        Employee minSalaryEmployee = deptEmployees.stream().min((e1,e2) -> Double.compare(e1.getSalary(), e2.getSalary())).get();
        String nameOfMinSalaryEmployee = minSalaryEmployee.getFirstName() + " " + minSalaryEmployee.getLastName()
                + ", его зарплата: " + minSalaryEmployee.getSalary();
        return nameOfMinSalaryEmployee;
    }


    //метод "ищем сотрудника с максимальной зарплатой по отделу"
    public String getNameOfMaxSalaryEmployeeInDept(int department) {
        List<Employee> deptEmployees = makeDepartmentArray(department);
        Employee maxSalaryEmployee = deptEmployees.stream().max((e1,e2) -> Double.compare(e1.getSalary(), e2.getSalary())).get();
        String nameOfMaxSalaryEmployee = maxSalaryEmployee.getFirstName() + " " + maxSalaryEmployee.getLastName()
                + ", его зарплата: " + maxSalaryEmployee.getSalary();
        return nameOfMaxSalaryEmployee;
    }


}
