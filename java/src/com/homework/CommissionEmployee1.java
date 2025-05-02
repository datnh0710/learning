package com.homework;

public class CommissionEmployee1 {
    protected final String firstname;

    public double getGrossSale() {
        return grossSale;
    }

    protected final String lastname;

    public void setCommissionRate(double commissionRate) {
        if ((commissionRate <= 0.0 || commissionRate >= 1.0)) {
            throw new IllegalArgumentException("commissionRate  must be >0.0 or <1.0");
        }
        this.commissionRate = commissionRate;
    }

    public void setGrossSale(double grossSale) {
        if (grossSale < 0.0) {
            throw new IllegalArgumentException("gross sales must be >0.0");
        }
        this.grossSale = grossSale;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    protected final String socialSecurityNumber;
    protected double grossSale;
    protected double commissionRate;

    public CommissionEmployee1(String firstname, String lastname, String socialSecurityNumber, double grossSale, double commissionRate) {
        if (grossSale < 0.0) {
            throw new IllegalArgumentException("gross sales must be >0.0");
        }
        if ((commissionRate <= 0.0 || commissionRate >= 1.0)) {
            throw new IllegalArgumentException("commissionRate  must be >0.0 or <1.0");
        }

        this.firstname = firstname;
        this.lastname = lastname;
        this.socialSecurityNumber = socialSecurityNumber;
        this.grossSale = grossSale;
        this.commissionRate = commissionRate;
    }

    public double earnings(){
        return grossSale * commissionRate;
    }

    @Override
    public String toString() {
        return "CommissionEmployee{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", socialSecurityNumber='" + socialSecurityNumber + '\'' +
                ", grossSale=" + grossSale +
                ", commissionRate=" + commissionRate +
                '}';
    }
}
