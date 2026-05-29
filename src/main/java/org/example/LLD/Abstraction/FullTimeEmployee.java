package org.example.LLD.Abstraction;

// Full-time employee implementation
class FullTimeEmployee extends Employee implements Payable {
    private double monthlySalary;

    FullTimeEmployee(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    // Must implement abstract method
    @Override
    double calculateSalary() {
        return monthlySalary;
    }

    // Must implement interface method
    @Override
    public void processPayment() {
        System.out.println("Processing monthly salary: $" + calculateSalary());
    }
}
