package org.example.LLD.Inheritance;

// Main class to demonstrate inheritance
public class Inheritance {
    public static void main(String[] args) {
        System.out.println("=== Single Inheritance ===");
        Dog dog = new Dog("Buddy", 3, "Golden Retriever");
        System.out.println("Name: " + dog.getName());
        System.out.println("Breed: " + dog.getBreed());
        dog.makeSound();
        dog.sleep();
        dog.wagTail();

        System.out.println("\n=== Hierarchical Inheritance ===");
        Cat cat = new Cat("Whiskers", 2, "White");
        System.out.println("Name: " + cat.getName());
        cat.makeSound();
        cat.purr();

        System.out.println("\n=== Multi-level Inheritance ===");
        Puppy puppy = new Puppy("Max", 1, "Labrador");
        System.out.println("Name: " + puppy.getName());
        System.out.println("Breed: " + puppy.getBreed());
        puppy.makeSound();
        puppy.play();
        puppy.sleep(); // Inherited from Animal

        System.out.println("\n=== Polymorphism with Inheritance ===");
        Animal animal1 = new Dog("Rocky", 4, "German Shepherd");
        Animal animal2 = new Cat("Luna", 3, "Black");

        animal1.makeSound(); // Dynamic method binding
        animal2.makeSound();
    }
}
