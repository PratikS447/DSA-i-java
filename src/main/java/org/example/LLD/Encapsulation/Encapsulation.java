package org.example.LLD.Encapsulation;

public class Encapsulation {

    // Private data members - hidden from outside access
    private int id;
    private String name;
    private double salary;

    // Constructor
    public Encapsulation(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Getter for id
    public int getId() {
        return id;
    }

    // Setter for id
    public void setId(int id) {
        this.id = id;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for salary
    public double getSalary() {
        return salary;
    }

    // Setter for salary
    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Main method to demonstrate encapsulation
    public static void main(String[] args) {
        Encapsulation emp = new Encapsulation(1, "John Doe", 50000.0);

        // Access via getters
        System.out.println("ID: " + emp.getId());
        System.out.println("Name: " + emp.getName());
        System.out.println("Salary: " + emp.getSalary());

        // Modify via setters
        emp.setName("Jane Doe");
        emp.setSalary(60000.0);

        System.out.println("\nAfter update:");
        System.out.println("Name: " + emp.getName());
        System.out.println("Salary: " + emp.getSalary());
    }
}