package org.example.LLD.Abstraction;

// Part-time employee implementation
class PartTimeEmployee extends Employee implements Payable {
    private double hourlyRate;
    private int hoursWorked;

    PartTimeEmployee(double hourlyRate, int hoursWorked) {
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public void processPayment() {
        System.out.println("Processing hourly payment: $" + calculateSalary());
    }
}
