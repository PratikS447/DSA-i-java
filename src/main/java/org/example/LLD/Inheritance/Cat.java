package org.example.LLD.Inheritance;

// Another derived class - Hierarchical Inheritance
class Cat extends Animal {
    private String color;

    public Cat(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow! Meow!");
    }

    public void purr() {
        System.out.println(name + " is purring");
    }
}
