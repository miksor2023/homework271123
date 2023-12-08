package com.pro.sky.java.course2.homework271123.service;


import com.pro.sky.java.course2.homework271123.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class DepartmentService {
    private final Map<String, Employee> employees;

    public DepartmentService ((Map<String, Employee> employees) {this.employees = new HashMap<>();}


    //служебный метод, возврящает количество сотрудников" по заданному отделу, если dept=0, считается общее число
    private int getEmployeeQty(int dept) {
        int employeesQty = 0;
        for (Map.Entry<String, Employee> employeeValue : employees.entrySet()) {
            if ((employeeValue.getValue().getDepartment() == dept || dept == 0)) {
                employeesQty++;
            }
        }
        return employeesQty;
    }

    //метод - "вывести в консоль список сотрудников" (без null полей)
//    public void printEmployeeListWithoutNull() {
//        System.out.println("\nСписок данных всех сотрудников:");
//        for (Map.Entry<String, Employee> employeeEntry : employees.entrySet()) {
//            System.out.println(employeeEntry.getValue());
//        }
//    }

    //метод "добавить сотрудника"
//    public void addEmployee(String firstName, String lastName, int department, double salary) {
//        if (employees.size() <= maxEmployeeQty && !employees.containsKey(firstName + lastName)) {
//            employees.put(firstName + " " + lastName, new Employee(firstName, lastName, department, salary));
//            System.out.println("\nЗапись о сотруднике " + firstName + " " + lastName + " ДОБАВЛЕНА");
//        } else if (employees.size() == maxEmployeeQty) {
//            System.out.println("Запись добавить невозможно, хранилище заполнено");
//        } else {
//            System.out.println("Сотрудник с таким именем уже существует");
//        }
//
//    }

    //метод "удалить сотрудника"
//    public void deleteEmployee(int id) {
//        boolean idExist = false;
//        for (Map.Entry<String, Employee> employeeEntry : employees.entrySet()) {
//            if (employeeEntry.getValue().getId() == id) {
//                idExist = true;
//                employees.remove(employeeEntry.getKey());
//                System.out.println("\nЗапись о сотруднике " + employeeEntry.getKey() + " УДАЛЕНА");
//                break;
//            }
//        }
//        if (!idExist) {
//            System.out.println("\nЗапись о сотруднике c ID:" + id + " НЕ НАЙДЕНА");
//        }
//    }

    //метод "посчитать сумму затрат в месяц"
//    public double calculateSalarySum() {
//        double sum = 0;
//        for (Map.Entry<String, Employee> employeeEntry : employees.entrySet()) {
//            sum = sum + employeeEntry.getValue().getSalary();
//        }
//        return sum;
//    }

    //метод "найти сотрудника с минимальной зарплатой"
    public String getMinSalaryEmploee() {
        String nameOfMinSalaryEmployee = null;
        Double minSalary = Double.MAX_VALUE;
        for (Map.Entry<String, Employee> employeeEntry : employees.entrySet()) {
            if (employeeEntry.getValue().getSalary() < minSalary) {
                minSalary = employeeEntry.getValue().getSalary();
                nameOfMinSalaryEmployee = employeeEntry.getValue().getFirstName() + " "
                        + employeeEntry.getValue().getLastName();
            }
        }
        return nameOfMinSalaryEmployee;
    }

    //метод "найти сотрудника с максимальной зарплатой"
    public String getMaxSalaryEmploee() {
        String nameOfMaxSalaryEmployee = null;
        double maxSalary = Double.MIN_VALUE;
        for (Map.Entry<String, Employee> employeeEntry : employees.entrySet()) {
            if (employeeEntry.getValue().getSalary() > maxSalary) {
                maxSalary = employeeEntry.getValue().getSalary();
                nameOfMaxSalaryEmployee = employeeEntry.getValue().getFirstName() + " "
                        + employeeEntry.getValue().getLastName();
            }
        }
        return nameOfMaxSalaryEmployee;
    }

    //метод "расчитать среднее значение зарплаты"
//    public double calculateAverageSalary() {
//        int employeesQty = getEmployeeQty(0);
//        if (employeesQty != 0) {
//            return calculateSalarySum() / employeesQty;
//        } else {
//            return 0D;
//        }
//    }

    //метод "вывести в консоль ФИО всех сотрудников"
//    public void printNameList() {
//        System.out.println("\nСписок имён всех сотрудников:");
//        for (Map.Entry<String, Employee> employeeEntry : employees.entrySet()) {
//            System.out.println(employeeEntry.getKey());
//        }
//    }

    //метод "индексация зарплат на заданный процент
//    public void makeSalaryIndexation(int indexationPercentage) {
//        double increaseRate = 1 + indexationPercentage / 100D;
//        for (Map.Entry<String, Employee> employeeEntry : employees.entrySet()) {
//            Employee currentValue = employeeEntry.getValue();
//            currentValue.setSalary(currentValue.getSalary() * increaseRate);
//            employees.put(employeeEntry.getKey(), currentValue);
//        }
//        System.out.println("\nЗарплата проиндексирована на " + indexationPercentage + "%");
//    }

    //делаем служебный метод, собирающий массив сотрудников по заданному отделу
    private List<Employee> makeDepartmentArray(int department) {
        //собираем массив сотрудника отдела
        List<Employee> deptEmployees = new ArrayList<>();
        for (Map.Entry<String, Employee> employeeEntry : employees.entrySet()) {
            if (employeeEntry.getValue().getDepartment() == department) {
                deptEmployees.add(employeeEntry.getValue());
            }
        }
        return deptEmployees;
    }

    //метод "вывести в консоль список сотрудников по заданному отделу"
    public void printDepartmentEmployeeList(int department) {
        List<Employee> deptEmployees = makeDepartmentArray(department);
        if (deptEmployees.size() != 0) {
            System.out.println("\nСписок сотрудников " + department + " отдела");
            for (Employee employee : deptEmployees) {
                System.out.printf(Locale.US, "Ф.И.О.: " + employee.getFirstName() +
                        employee.getLastName() +
                        "; зарплата: %.2fр." + "\n", employee.getSalary());
            }
        } else {
            System.out.println("В отделе нет сотрудников");
        }
    }

    //метод "ищем сотрудника с минимальной зарплатой по отделу"
    public String getMinSalaryEmployeeInDept(int department) {
        List<Employee> deptEmployees = makeDepartmentArray(department);
        String nameOfMinSalaryEmployee = null;
        Double minSalary = Double.MAX_VALUE;
        for (Employee employee : deptEmployees) {
            if (employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                nameOfMinSalaryEmployee = employee.getFirstName() + employee.getLastName();
            }
        }
        return nameOfMinSalaryEmployee;
    }


    //метод "ищем сотрудника с максимальной зарплатой по отделу"
    public String getMaxSalaryEmployeeInDept(int department) {
        List<Employee> deptEmployees = makeDepartmentArray(department);
        String nameOfMaxSalaryEmployee = null;
        double maxSalary = Double.MIN_VALUE;
        for (Employee employee : deptEmployees) {
            if (employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                nameOfMaxSalaryEmployee = employee.getFirstName() + employee.getLastName();
            }
        }
        return nameOfMaxSalaryEmployee;
    }

    //метод "расчитать сумму затрат по отделу"
//    public double calculateDeptSalarySum(int department) {
//        List<Employee> deptEmployees = makeDepartmentArray(department);
//        double sum = 0;
//        for (Employee employee : deptEmployees) {
//            sum = sum + employee.getSalary();
//        }
//        return sum;
//    }


    //метод "расчтать среднюю зарплату по отделу"
//    public double calculateAverageDeptSalary(int department) {
//        List<Employee> deptEmployees = makeDepartmentArray(department);
//        if (deptEmployees.size() == getEmployeeQty(0)) {
//            throw new IllegalArgumentException("количество людей в отделе совпадает с общим числом сотрудников");
//        } else {
//            return calculateDeptSalarySum(department) / deptEmployees.size();
//        }
//    }

    //метод "индексировать зарплаты по отделу на заданный процент
//    public void makeDeptSalaryIndexation(int indexationPercentage, int department) {
//        List<Employee> deptEmployees = makeDepartmentArray(department);
//        double increaseRate = 1 + indexationPercentage / 100D;
//        for (Employee employee : deptEmployees) {
//            employee.setSalary(employee.getSalary() * increaseRate);
//            employees.put(employee.getFirsrName() + " " + employee.getLastName(), employee);
//        }
//        System.out.println("\nЗарплата по отделу " + department + " проиндексирована на " + indexationPercentage + "%");
//
//    }

    //метод для вывода списка сотрудников с ЗП меньше заданного значения
//    public void printEmployeesWithSalaryLessThan(double edgeSalary) {
//        System.out.println("\nСписок сотрудников с зарплатой меньше " + edgeSalary + "р.");
//        for (Map.Entry<String, Employee> employeeEntry : employees.entrySet()) {
//            if (employeeEntry.getValue().getSalary() < edgeSalary) {
//                System.out.printf(Locale.US, "id: " + employeeEntry.getValue().getId() + "; Ф.И.О.: " +
//                                employeeEntry.getValue().getName() + "; зарплата: %.2fр.\n",
//                        employeeEntry.getValue().getSalary());
//            }
//        }
//    }

    //метод для вывода списка сотрудников с ЗП больше заданного значения
//    public void printEmployeesWithSalaryMoreThan(double edgeSalary) {
//        System.out.println("\nСписок сотрудников с зарплатой больше или равно " + edgeSalary + "р.");
//        for (Map.Entry<String, Employee> employeeEntry : employees.entrySet()) {
//            if (employeeEntry.getValue().getSalary() >= edgeSalary) {
//                System.out.printf(Locale.US, "id: " + employeeEntry.getValue().getId() + "; Ф.И.О.: " +
//                        employeeEntry.getValue().getName() + "; зарплата: %.2fр.\n", employeeEntry.getValue().getSalary());
//            }
//        }
//    }

    //метод изменить сотрудника
//    public void modifyEmployee(String firstName, String lastName, int department, int salary) {
//        String key = firstName + " " + lastName;
//        if (employees.containsKey(key)) {
//            employees.put(key, new Employee(firstName,lastName,department,salary));
//        }
//    }

    //метод "напечатать список отделов и их сотрудников"
    public void printEployeeListByDepartments() {
        System.out.println("\nCписок сотрудников по отделам: ");
        for (int department = 1; department <= 5; department++) {
            List<Employee> deptEmployees = makeDepartmentArray(department);
            System.out.println("\nСписок сотрудников " + department + " отдела");
            for (Employee employee : deptEmployees) {
                System.out.println("Ф.И.О.: " + employee.getFirstName());
            }
            if (deptEmployees.size() == 0) {
                System.out.println("В отделе нет сотрудников");
            }
        }

}
