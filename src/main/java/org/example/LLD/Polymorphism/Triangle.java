package org.example.LLD.Polymorphism;

// Derived class - Triangle
class Triangle extends Shape {
    private double base, height;

    public Triangle(String color, double base, double height) {
        super(color);
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return 0.5 * base * height;
    }

    @Override
    public void display() {
        System.out.println("Triangle[" + color + ", base=" + base + ", height=" + height + "]");
    }
}
