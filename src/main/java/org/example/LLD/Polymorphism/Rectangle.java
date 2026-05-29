package org.example.LLD.Polymorphism;

// Derived class - Rectangle
class Rectangle extends Shape {
    private double width, height;

    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public void display() {
        System.out.println("Rectangle[" + color + ", " + width + "x" + height + "]");
    }
}
