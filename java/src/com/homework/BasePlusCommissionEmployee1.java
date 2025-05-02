package com.homework;

public class BasePlusCommissionEmployee1 extends CommissionEmployee {
    private double baseSalary;

    public BasePlusCommissionEmployee1(String firstname, String lastname, String socialSecurityNumber, double grossSale, double commissionRate, double baseSalary) {
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
    public String toString() {
        return super.toString()+"BasePlusCommissionEmployee1{" +
                "baseSalary=" + baseSalary +
                '}';
    }

//    @Override
//    public double earnings() {
//        return getBaseSalary() + super.earnings();
//    }


    @Override
    public double getPaymentAmount() {
        return super.getPaymentAmount() + getBaseSalary();
    }
}
