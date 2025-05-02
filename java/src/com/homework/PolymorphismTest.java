package com.homework;

public class PolymorphismTest {
    public static void main(String[] args) {
        CommissionEmployee cm = new BasePlusCommissionEmployee1("Bob", "Lewis", "333-33-3333", 5000, .04, 300);
        System.out.printf("%s %s:%n%n%s%n",
                "Call BasePlusCommissionEmployee's toString with superclass", "reference to subclass object", cm.toString());
    }
}
