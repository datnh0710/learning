package com.homework;


import java.io.Serializable;

public class Account implements Serializable {
    private String name;
    private double amount;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Account() {
        this("",0.0);
    }

    public Account(String name, double amount) {
        this.name = name;
        if(amount> 0.0){
            this.amount = amount;
        }

    }

    public void deposit(double depositAmount){
        if (depositAmount>0.0){
            amount+=depositAmount;
        }
    }
    public boolean withDraw(double withDrawAmount){
        if (withDrawAmount> amount){
            return false;
        }
        amount-=withDrawAmount;
        return true;
    }


}
