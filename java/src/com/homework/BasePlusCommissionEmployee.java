package com.homework;

public class BasePlusCommissionEmployee extends CommissionEmployee {

    private double baseSalary;

    public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSale, double commissionRate, double baseSalary) {
        super(firstName, lastName, socialSecurityNumber, grossSale, commissionRate);
        if (baseSalary < 0.0) {
            throw new IllegalArgumentException("Base salary must be >= 0.0");
        }
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary < 0.0) {
            throw new IllegalArgumentException("Base salary must be >= 0.0");
        }
        this.baseSalary = baseSalary;
    }

    @Override
    public String toString() {
        return super.toString() + "BasePlusCommissionEmployee{" +
                "baseSalary=" + baseSalary +
                '}';
    }

//    @Override
//    public double earnings() {
//        return super.earnings() + getBaseSalary();
//    }

    @Override
    public double getPaymentAmount() {
        return super.getPaymentAmount() + getBaseSalary();
    }
}
