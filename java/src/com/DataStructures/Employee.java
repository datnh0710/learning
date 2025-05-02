package com.DataStructures;

import java.util.Objects;

public class Employee {
    private String name;
    private double salary;
    private int seniority;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
