package com.pro.sky.java.course2.homework271123.service;

import com.pro.sky.java.course2.homework271123.model.Employee;
import org.springframework.stereotype.Service;
import com.pro.sky.java.course2.homework271123.exception.EmployeeStorageIsFullException;
import com.pro.sky.java.course2.homework271123.exception.EmployeeAlreadyAddedException;
import com.pro.sky.java.course2.homework271123.exception.EmployeeNotFoundException;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    public Map<String, Employee> employeeMap = new HashMap<>();
    private static int maxEmployeeQty = 10;
    //метод добавляет сотрудника

    public String addEmployee(String firstName, String lastName, double salary, int department) throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException {
        Employee employee = new Employee(firstName, lastName, salary, department);
        String key = firstName + lastName;
        if (employeeMap.size() < maxEmployeeQty && employeeMap.containsKey(key) == false) {
            employeeMap.put(key, employee);
            return "Запись о сотруднике  " + firstName + " " + lastName + " ДОБАВЛЕНА";
        } else if (employeeMap.containsKey(key) == true) {
            throw new EmployeeAlreadyAddedException("Сотрудник с таким именем уже существует");
        } else {
            throw new EmployeeStorageIsFullException("Хранилище заполнено");
        }
    }
    //метод удаляет сотрудника по имени/фамилии

    public String removeEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        String key = firstName + lastName;
        if (employeeMap.containsKey(key)) {
            Employee employee = employeeMap.get(key);
            employeeMap.remove(key);
            return "Запись о сотруднике  " + firstName + " " + lastName + " УДАЛЕНА";
        } else {
            throw new EmployeeNotFoundException("Сотрудник с таким именем не найден");
        }
    }
    //метод ищет сотрудника по имени/фамилии
    public String findEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        String key = firstName + lastName;
        if (employeeMap.containsKey(key)) {
            return employeeMap.get(key).toString();
        } else {
            throw new EmployeeNotFoundException("Сотрудник с таким именем не найден");
        }
    }

    //метод возвращает строку со списком всех сотрудников
    public String returnAllEmployeeListByString() {
        StringJoiner result = new StringJoiner("");
        result.add("Список всех сотрудников: <br />");
        Map<Integer, List<Employee>> grouppedByDept = employeeMap.values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        grouppedByDept.keySet().stream()
                .forEach(key -> result.add("Отдел " + key + "<br />"
                        + buidStringFromEmployeeList(grouppedByDept.get(key))));
        return result.toString();
    }

    //служебный метод, что-то вроде toString() для списка сотрудников отдельного отдела (выводится без номера отдела)
    public String buidStringFromEmployeeList(List<Employee> employees) {
        StringJoiner result = new StringJoiner("");
        employees.stream()
                .forEach(employee -> result.add("Имя: " + employee.getFirstName()
                        + " " + employee.getLastName()
                        + ", зарплата: " + employee.getSalary() + "<br />"));
        return result.toString();
    }


    //тестовый метод для заполнения списка записями
    public Map<String, Employee> loadEmployeeList() {
        addEmployee("Ivan", "Ivanov", 10000, 1);
        addEmployee("Ivan", "Sidorov", 11000, 1);
        addEmployee("Ivan", "Petrov", 12000, 1);
        addEmployee("Petr", "Vetrov", 20000, 2);
        addEmployee("Petr", "Shpetrov", 21000, 2);
        addEmployee("Petr", "Ivanov", 22000, 2);
        addEmployee("Vasiliy", "Sidorov", 30000, 3);
        addEmployee("Vasiliy", "Petrov", 31000, 3);
        addEmployee("Evgeniy", "Vetrov", 40000, 4);
        addEmployee("Evgeniy", "Shpetrov", 41000, 4);
        return employeeMap;
    }
}
