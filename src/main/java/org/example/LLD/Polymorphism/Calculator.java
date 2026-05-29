package org.example.LLD.Polymorphism;

// Class demonstrating Compile-time Polymorphism (Method Overloading)
class Calculator {
    // Overloaded add methods - same name, different parameters
    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public String add(String a, String b) {
        return a + b;
    }
}
