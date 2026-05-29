package org.example.LLD.Polymorphism;

// Derived class - Circle
class Circle extends Shape {
    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public void display() {
        System.out.println("Circle[" + color + ", radius=" + radius + "]");
    }
}
