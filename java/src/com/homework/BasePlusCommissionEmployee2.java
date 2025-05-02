package com.homework;

public class BasePlusCommissionEmployee2 extends CommissionEmployee1 {
    private double baseSalary;

    public BasePlusCommissionEmployee2(String firstname, String lastname, String socialSecurityNumber, double grossSale, double commissionRate, double baseSalary) {
        super(firstname, lastname, socialSecurityNumber, grossSale, commissionRate);
        if (baseSalary < 0.0)
            throw new IllegalArgumentException(
                    "Base salary must be >= 0.0");
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public double earnings() {
        return baseSalary + (commissionRate * grossSale);
    }

    @Override
    public String toString() {
        return "BasePlusCommissionEmployee2{" +
                "baseSalary=" + baseSalary +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", socialSecurityNumber='" + socialSecurityNumber + '\'' +
                ", grossSale=" + grossSale +
                ", commissionRate=" + commissionRate +
                '}';
    }
}
