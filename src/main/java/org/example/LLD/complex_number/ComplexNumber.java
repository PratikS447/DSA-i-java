package org.example.LLD.complex_number;

public class ComplexNumber {
    double real;
    double imaginary;

    ComplexNumber(double real, double imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumber add(ComplexNumber c){
        double newReal = this.real + c.real;
        double newImaginary = this.imaginary + c.imaginary;
        return new ComplexNumber(newReal, newImaginary);
    }

    public ComplexNumber subtract(ComplexNumber c){
        double newReal = this.real - c.real;
        double newImaginary = this.imaginary + c.imaginary;
        return new ComplexNumber(newReal, newImaginary);
    }

    public ComplexNumber multiply(ComplexNumber c){
        double newReal = this.real * c.real - this.imaginary * c.imaginary;
        double newImaginary = this.real*c.imaginary + this.imaginary * c.real;
        return new ComplexNumber(newReal, newImaginary);
    }

    public double magnitude(){
        return Math.sqrt(this.real*this.real + this.imaginary*this.imaginary);
    }

    public String toString(){
        if(imaginary >= 0){
            return real + "+" + imaginary + "i";
        }else {
            return real + "-" + imaginary + "i";
        }
    }

    public static void main(String args[]){
        ComplexNumber c1 = new ComplexNumber(3, 2);
        ComplexNumber c2 = new ComplexNumber(1, 7);

        System.out.println("Addition: " + c1.add(c2));
        System.out.println("Subtraction: " + c1.subtract(c2));
        System.out.println("Multiplication: " + c1.multiply(c2));
        System.out.println("Magnitude of c1: " + c1.magnitude());
    }
}
