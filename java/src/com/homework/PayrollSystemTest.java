package com.homework;

public class PayrollSystemTest {
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

        System.out.println("Employees processed individually:");
//        System.out.printf("%n%s%n%s: $%,.2f%n%n",
//                salariedEmployee, "earned", salariedEmployee.earnings());
//        System.out.printf("%s%n%s: $%,.2f%n%n",
//                hourlyEmployee, "earned", hourlyEmployee.earnings());
//        System.out.printf("%s%n%s: $%,.2f%n%n",
//                commissionEmployee, "earned", commissionEmployee.earnings());
//        System.out.printf("%s%n%s: $%,.2f%n%n",
//                basePlusCommissionEmployee,
//                "earned", basePlusCommissionEmployee.earnings());
        System.out.printf("%n%s%n%s: $%,.2f%n%n",
                salariedEmployee, "earned", salariedEmployee.getPaymentAmount());
        System.out.printf("%s%n%s: $%,.2f%n%n",
                hourlyEmployee, "earned", hourlyEmployee.getPaymentAmount());
        System.out.printf("%s%n%s: $%,.2f%n%n",
                commissionEmployee, "earned", commissionEmployee.getPaymentAmount());
        System.out.printf("%s%n%s: $%,.2f%n%n",
                basePlusCommissionEmployee,
                "earned", basePlusCommissionEmployee.getPaymentAmount());

        Employee employees[] = new Employee[4];
        employees[0] = basePlusCommissionEmployee;
        employees[1] = commissionEmployee;
        employees[2] = hourlyEmployee;
        employees[3] = salariedEmployee;

        System.out.printf("Employees processed polymorphically:%n%n");

        for (Employee currentEmployee: employees) {
            System.out.println(currentEmployee); // invokes toString

            if (currentEmployee instanceof BasePlusCommissionEmployee){
                BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee)currentEmployee;
                employee.setBaseSalary(1.10* employee.getBaseSalary());
                System.out.printf(
                        "new base salary with 10%% increase is: $%,.2f%n", employee.getBaseSalary());
            }
//            System.out.printf(
//                    "earned $%,.2f%n%n", currentEmployee.earnings());
            System.out.printf(
                    "earned $%,.2f%n%n", currentEmployee.getPaymentAmount());
            
        }

        for (int j = 0; j < employees.length; j++) System.out.printf("Employee %d is a %s%n", j,
                employees[j].getClass().getName());

    }
}
