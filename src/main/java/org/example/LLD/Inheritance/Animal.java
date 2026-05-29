package org.example.LLD.Inheritance;

// Base class (Parent class)
class Animal {
    protected String name;
    protected int age;

    // Constructor
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to be overridden
    public void makeSound() {
        System.out.println("Some generic animal sound");
    }

    // Regular method
    public void sleep() {
        System.out.println(name + " is sleeping");
    }

    // Getter method
    public String getName() {
        return name;
    }
}
