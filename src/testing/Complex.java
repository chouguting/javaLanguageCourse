package testing; //should revise

import java.security.SecureRandom;

import static java.lang.Math.sqrt;


/*
 *  by 00857005 周固廷
 * */

public class Complex {

    private double real;
    private double imaginary;

    public double getReal() {
        return real;
    }



    public void setReal(double real) {
        this.real = real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    public Complex() {
        SecureRandom secureRandom = new SecureRandom();
        this.real = secureRandom.nextDouble();
        this.imaginary = secureRandom.nextDouble();
    }

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex(Complex newComplex) {
        this.real = newComplex.real;
        this.imaginary = newComplex.imaginary;
    }

    //虛數的共軛複數
    public Complex conjugates() {
        return new Complex(this.real, this.imaginary * -1.0); //should revise
    }

    //求虛數的絕對值
    public double absoluteValue() {
        double result = sqrt(Math.pow(this.real, 2) + Math.pow(this.imaginary, 2));
        return Math.round(result * 100.0) / 100.0;
    }

    //虛數加法
    public Complex add(Complex x) {
        Complex temp = new Complex(real, imaginary);
        temp.real += x.real;
        temp.imaginary += x.imaginary;
        return temp;
    }

    //虛數減法
    public Complex subtract(Complex x) {
        Complex temp = new Complex(real, imaginary);
        temp.real -= x.real;
        temp.imaginary -= x.imaginary;
        return temp; //should revise
    }

    //虛數乘法
    public Complex multiply(Complex x) {
        Complex temp = new Complex();
        temp.real = this.real * x.real - this.imaginary * x.imaginary;
        temp.imaginary = this.real * x.imaginary + this.imaginary * x.real;
        return temp; //should revise
    }

    //虛數除法
    public Complex divide(Complex x) {
        Complex temp = new Complex();
        temp.real = (this.real * x.real + this.imaginary * x.imaginary) / (Math.pow(x.real, 2) + Math.pow(x.imaginary, 2));
        temp.imaginary = (this.imaginary * x.real - this.real * x.imaginary) / (Math.pow(x.real, 2) + Math.pow(x.imaginary, 2));
        return temp;
    }

    public String toString() {
        if(this.imaginary<0){
            return String.format("%.2f - %.2fi", real, -1*imaginary); //should revise
        }else {
            return String.format("%.2f + %.2fi", real, imaginary); //should revise
        }
    }

}
