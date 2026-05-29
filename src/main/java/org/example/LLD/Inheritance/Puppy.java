package org.example.LLD.Inheritance;

// Multi-level Inheritance
class Puppy extends Dog {
    public Puppy(String name, int age, String breed) {
        super(name, age, breed);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Yip! Yip!");
    }

    public void play() {
        System.out.println(name + " is playing with a toy");
    }
}
