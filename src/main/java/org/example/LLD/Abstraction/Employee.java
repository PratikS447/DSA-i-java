package org.example.LLD.Abstraction;

// Abstract class - cannot be instantiated directly
abstract class Employee {
    // Abstract method - no body, must be implemented by subclasses
    abstract double calculateSalary();

    // Concrete method
    void displayRole() {
        System.out.println("Employee role");
    }
}
