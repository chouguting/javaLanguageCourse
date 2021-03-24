package ntou.cs.java2021.hw1; //should revise

import java.math.BigDecimal;
import java.security.SecureRandom;

import static java.lang.Math.sqrt;


/*
 *  by 00857005 周固廷
 * */

public class Complex {

    private double real;
    private double imaginary;

    public Complex() {
        //TODO
        SecureRandom secureRandom = new SecureRandom();
        this.real = secureRandom.nextDouble();
        this.imaginary = secureRandom.nextDouble();
    }

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex conjugates() {
        return new Complex(this.real, this.imaginary * -1.0); //should revise
    }

    public double absoluteValue() {
        double result = sqrt(Math.pow(this.real, 2) + Math.pow(this.imaginary, 2));
        return Math.round(result * 100.0) / 100.0; //should revise
    }

    public Complex add(Complex x) {
        Complex temp = new Complex(real, imaginary);
        temp.real += x.real;
        temp.imaginary += x.imaginary;
        return temp;
    }

    public Complex subtract(Complex x) {
        Complex temp = new Complex(real, imaginary);
        temp.real -= x.real;
        temp.imaginary -= x.imaginary;
        return temp; //should revise
    }

    public Complex multiply(Complex x) {
        Complex temp = new Complex();
        temp.real = this.real * x.real - this.imaginary * x.imaginary;
        temp.imaginary = this.real * x.imaginary + this.imaginary * x.real;
        return temp; //should revise
    }

    public Complex divide(Complex x) {
        Complex temp = new Complex();
        temp.real = (this.real * x.real + this.imaginary * x.imaginary) / (Math.pow(x.real, 2) + Math.pow(x.imaginary, 2));
        temp.imaginary = (this.imaginary * x.real - this.real * x.imaginary) / (Math.pow(x.real, 2) + Math.pow(x.imaginary, 2));
        return temp; //should revise
    }

    public String toString() {
        if(this.imaginary<0){
            return String.format("%.2f - %.2fi", real, -1*imaginary); //should revise
        }else {
            return String.format("%.2f + %.2fi", real, imaginary); //should revise
        }
    }

}
