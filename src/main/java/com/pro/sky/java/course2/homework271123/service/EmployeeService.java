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

    private static int maxEmployeeQty = 5;

    public Employee addEmployee(String firstName, String lastName) throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException{
        Employee employee = new Employee(firstName, lastName);
        if (employeeMap.size() < maxEmployeeQty && employeeMap.containsValue(employee) == false) {
            employeeMap.put(employee.getFirstName() + employee.getLastName(), employee);
            return employee;
        } else if (employeeMap.containsValue(employee) == true){
            throw new EmployeeAlreadyAddedException("Сотрудник с таким именем уже существует");
        } else {
            throw new EmployeeStorageIsFullException("Хранилище заполнено");
        }
    }
    public Employee removeEmployee(String firstName, String lastName) throws EmployeeNotFoundException{
        Employee employee = new Employee(firstName, lastName);
        if (employeeMap.containsValue(employee)) {
            employeeMap.remove(employee.getFirstName() + employee.getLastName(), employee);
            return employee;
        } else {
            throw new EmployeeNotFoundException("Сотрудник с таким именем не найден");
        }
    }

    public Employee findEmployee (String firstName, String lastName) throws EmployeeNotFoundException{
        Employee employee = new Employee(firstName, lastName);
        if (employeeMap.containsValue(employee)) {
            return employee;
        } else {
            throw new EmployeeNotFoundException("Сотрудник с таким именем не найден");
        }
    }
    public Collection<Employee> returnEmployeeList() {
        return employeeMap.values();
    }

    //тестовый метод для заполнения списка записями
    public Map<String,Employee> loadEmployeeList() {
        employeeMap.put("IvanIvanov", new Employee("Ivan", "Ivanov"));
        employeeMap.put("IvanSidorov", new Employee("Ivan", "Sidorov"));
        employeeMap.put("IvanPetrov", new Employee("Ivan", "Petrov"));
        employeeMap.put("IvanVetrov", new Employee("Ivan", "Vetrov"));
        employeeMap.put("IvanShpetrov", new Employee("Ivan", "Shpetrov"));
        return employeeMap;
    }
}
