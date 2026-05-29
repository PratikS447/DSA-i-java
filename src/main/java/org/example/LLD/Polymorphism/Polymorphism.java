package org.example.LLD.Polymorphism;

public class Polymorphism {
    public static void main(String[] args) {
        System.out.println("=== Runtime Polymorphism (Method Overriding) ===\n");

        // Upcasting - Parent class reference pointing to child class objects
        Shape[] shapes = {
            new Circle("Red", 5.0),
            new Rectangle("Blue", 4.0, 6.0),
            new Triangle("Green", 3.0, 8.0)
        };

        // Polymorphic behavior - same method call, different implementations
        for (Shape shape : shapes) {
            shape.display();  // Calls the overridden method of actual object type
            System.out.println("Area: " + shape.area());
            shape.displayType();  // Calls final method from parent
            System.out.println();
        }

        System.out.println("\n=== Compile-time Polymorphism (Method Overloading) ===\n");

        Calculator calc = new Calculator();
        System.out.println("add(5, 3) = " + calc.add(5, 3));
        System.out.println("add(5, 3, 2) = " + calc.add(5, 3, 2));
        System.out.println("add(5.5, 3.2) = " + calc.add(5.5, 3.2));
        System.out.println("add(\"Hello\", \" World\") = " + calc.add("Hello", " World"));

        System.out.println("\n=== Key Points ===");
        System.out.println("1. Runtime Polymorphism: Method overriding with inheritance");
        System.out.println("2. Compile-time Polymorphism: Method overloading");
        System.out.println("3. Upcasting: Parent reference -> Child object");
        System.out.println("4. Dynamic Method Dispatch: JVM decides which method to call at runtime");
    }
}