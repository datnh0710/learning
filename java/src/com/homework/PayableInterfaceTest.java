package com.homework;

import Interface.Payable;

public class PayableInterfaceTest {
    public static void main(String[] args) {
        BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee(
                "Bob", "Lewis", "444-44-4444", 5000, .04, 300);
        CommissionEmployee commissionEmployee =
                new CommissionEmployee(
                        "Sue", "Jones", "333-33-3333", 10000, .06);
        HourlyEmployee hourlyEmployee =
                new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40);
        SalariedEmployee salariedEmployee =
                new SalariedEmployee("John", "Smith", "111-11-1111", 800.00);
        Payable[] payables = new Payable[6];

        // populate array with objects that implement Payable
        payables[0] = new Invoice("01234", "seat", 2, 375.00);
        payables[1] = new Invoice("56789", "tire", 4, 79.95);
        payables[2] = basePlusCommissionEmployee;
        payables[3] = commissionEmployee;
        payables[4] = hourlyEmployee;
        payables[5] = salariedEmployee;

        System.out.println(
                "Invoices and Employees processed polymorphically:");

        for (Payable currentPayable : payables) {
            System.out.printf("%n%s %n%s: $%,.2f%n",currentPayable.toString(), "payment due",currentPayable.getPaymentAmount());
        }


    }
}
