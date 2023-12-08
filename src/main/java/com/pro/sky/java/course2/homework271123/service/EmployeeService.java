package com.pro.sky.java.course2.homework271123.service;

import com.pro.sky.java.course2.homework271123.model.Employee;
import org.springframework.stereotype.Service;
import com.pro.sky.java.course2.homework271123.exception.EmployeeStorageIsFullException;
import com.pro.sky.java.course2.homework271123.exception.EmployeeAlreadyAddedException;
import com.pro.sky.java.course2.homework271123.exception.EmployeeNotFoundException;

import java.util.*;

@Service
public class EmployeeService {
    private Map<String,Employee> employeeMap;

    public EmployeeService(Map<String, Employee> employeeMap) {
        this.employeeMap = new HashMap<>();
    }

    private static int maxEmployeeQty = 10;

    public Employee addEmployee(String firstName, String lastName, double salary, int department) throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException{
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employeeMap.size() =< maxEmployeeQty && employeeMap.containsValue(employee) == false) {
            employeeMap.put(employee.getFirstName() + employee.getLastName(), employee);
            return employee;
        } else if (employeeMap.containsValue(employee) == true){
            throw new EmployeeAlreadyAddedException("Сотрудник с таким именем уже существует");
        } else {
            throw new EmployeeStorageIsFullException("Хранилище заполнено");
        }
    }
    public Employee removeEmployee(String firstName, String lastName) throws EmployeeNotFoundException{
        String key = firstName + lastName;
        if (employeeMap.containsKey(key)) {
            Employee employee = employeeMap.get(key);
            employeeMap.remove(key);
            return employee;
        } else {
            throw new EmployeeNotFoundException("Сотрудник с таким именем не найден");
        }
    }

    public Employee findEmployee (String firstName, String lastName) throws EmployeeNotFoundException{
        String key = firstName + lastName;
        if (employeeMap.containsKey(key)) {
            return employeeMap.get(key);
        } else {
            throw new EmployeeNotFoundException("Сотрудник с таким именем не найден");
        }
    }
    public Collection<Employee> returnEmployeeList() {
        return employeeMap.values();
    }

    //тестовый метод для заполнения списка записями
    public Map<String,Employee> loadEmployeeList() {
        addEmployee("Ivan", "Ivanov", 10000, 1));
        addEmployee("Ivan", "Sidorov", 11000, 1));
        addEmployee("Ivan", "Petrov", 12000,1));
        addEmployee("Petr", "Vetrov", 20000,2));
        addEmployee("Petr", "Shpetrov", 21000, 2));
        addEmployee("Petr", "Ivanov", 22000, 2));
        addEmployee("Vasiliy", "Sidorov", 30000, 3));
        addEmployee("Vasiliy", "Petrov", 31000,3));
        addEmployee("Evgeniy", "Vetrov", 40000,4));
        addEmployee("Evgeniy", "Shpetrov", 41000, 4));
        return employeeMap;
    }
}
