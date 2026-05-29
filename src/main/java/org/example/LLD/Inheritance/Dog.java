package org.example.LLD.Inheritance;

// Derived class (Child class) - Single Inheritance
class Dog extends Animal {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age); // Call parent class constructor
        this.breed = breed;
    }

    // Method overriding
    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof! Woof!");
    }

    // New method specific to Dog
    public void wagTail() {
        System.out.println(name + " is wagging its tail");
    }

    public String getBreed() {
        return breed;
    }
}
