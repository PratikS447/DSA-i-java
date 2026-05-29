package org.example.LLD.Polymorphism;

// Base class - Shape
class Shape {
    protected String color;

    public Shape(String color) {
        this.color = color;
    }

    // Method to be overridden (Runtime Polymorphism)
    public double area() {
        return 0;
    }

    // Method to be overridden
    public void display() {
        System.out.println("Shape: " + color);
    }

    // Final method - cannot be overridden
    public final void displayType() {
        System.out.println("This is a Shape");
    }
}
