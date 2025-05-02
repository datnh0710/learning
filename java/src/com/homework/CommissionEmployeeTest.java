package com.homework;

public class CommissionEmployeeTest {
    public static void main(String[] args) {
        CommissionEmployee employee = new CommissionEmployee("dat","nguyen","123-45-6789",0.01,0.99);

        System.out.println("Employee information obtained by get method");
        System.out.println(
                "Employee information obtained by get methods:");
        System.out.printf("%n%s %s%n", "First name is", employee.getFirstName());
        System.out.printf("%s %s%n", "Last name is", employee.getLastName());
        System.out.printf("%s %s%n", "Social security number is", employee.getSocialSecurityNumber());
        System.out.printf("%s %.2f%n", "Gross sales is", employee.getGrossSale());
        System.out.printf("%s %.2f%n", "Commission rate is", employee.getCommissionRate());

        employee.setCommissionRate(0.99);
        employee.setGrossSale(9999999.99);

        System.out.printf("%n%s:%n%n%s%n","Update employee information obtained by toString", employee);
    }
}
