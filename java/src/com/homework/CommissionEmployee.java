package com.homework;

public class CommissionEmployee extends Employee {
    private double grossSale;
    private double commissionRate;

    public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSale, double commissionRate) {

        super(firstName, lastName, socialSecurityNumber);
        if (commissionRate <= 0.0 || commissionRate >= 1.0) throw new IllegalArgumentException(
                "Commission rate must be > 0.0 and < 1.0");
        if (grossSale < 0.0)
            throw new IllegalArgumentException(
                    "Base salary must be >= 0.0");
        this.grossSale = grossSale;
        this.commissionRate = commissionRate;
    }

    public double getGrossSale() {
        return grossSale;
    }

    public void setGrossSale(double grossSale) {
        if (grossSale < 0.0)
            throw new IllegalArgumentException(
                    "Base salary must be >= 0.0");

        this.grossSale = grossSale;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        if (commissionRate <= 0.0 || commissionRate >= 1.0) throw new IllegalArgumentException(
                "Commission rate must be > 0.0 and < 1.0");
        this.commissionRate = commissionRate;
    }

    @Override
    public String toString() {
        return super.toString() + "CommissionEmployee{" +
                "grossSale=" + grossSale +
                ", commissionRate=" + commissionRate +
                '}';
    }
//
//    @Override
//    public double earnings() {
//        return getGrossSale() * getCommissionRate();
//    }

    @Override
    public double getPaymentAmount() {
        return getGrossSale() * getCommissionRate();
    }
}
