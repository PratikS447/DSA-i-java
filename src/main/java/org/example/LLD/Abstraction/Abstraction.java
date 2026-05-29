package org.example.LLD.Abstraction;

public class Abstraction {
    public static void main(String[] args) {
        // Cannot instantiate abstract class
        // Employee e = new Employee(); // ERROR

        Employee ft = new FullTimeEmployee(5000);
        ft.displayRole();
        System.out.println("Salary: " + ft.calculateSalary());

        Employee pt = new PartTimeEmployee(50, 80);
        pt.displayRole();
        System.out.println("Salary: " + pt.calculateSalary());

        // Use interface reference
        Payable p1 = new FullTimeEmployee(5000);
        Payable p2 = new PartTimeEmployee(50, 80);

        System.out.println("\nPayment processing:");
        p1.processPayment();
        p2.processPayment();
    }
}