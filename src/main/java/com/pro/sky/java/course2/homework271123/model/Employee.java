package com.pro.sky.java.course2.homework271123.model;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;

    private double salary;
    private Integer department;


    public Employee(String firatName, String lastName, double salary, Integer department) {
        this.firstName = firatName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }
    public Integer getDepartment() {
        return department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return  "имя: " + firstName +
                ", фамилия: " + lastName +
                ", зарплата: " + salary +
                ", отдел: " + department + "<br />";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return Objects.equals(getFirstName(), employee.getFirstName()) && Objects.equals(getLastName(), employee.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName());
    }
}
