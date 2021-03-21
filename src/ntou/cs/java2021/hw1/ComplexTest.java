package ntou.cs.java2021.hw1;

public class ComplexTest {

    public static void main(String[] args) {
        Complex complexA = new Complex(1.1, 2.2);
        System.out.println("a = "+complexA);
        System.out.println("Conjugates of a = " + complexA.conjugates());
        System.out.printf("Absolute value of a = %.2f\n\n", complexA.absoluteValue());

        Complex complexB = new Complex(3.3, -4.4);
        System.out.println("b = "+complexB);
        System.out.println("Conjugates of b = " + complexB.conjugates());
        System.out.printf("Absolute value of b = %.2f\n\n", complexB.absoluteValue());

        System.out.println("a + b = " + complexA.add(complexB));
        System.out.println("a - b = " + complexA.subtract(complexB));
        System.out.println("a * b = " + complexA.multiply(complexB));
        System.out.println("a / b = " + complexA.divide(complexB) + "\n\n");


        Complex complexC = new Complex();
        System.out.println("c = "+complexC);
        System.out.println("Conjugates of c = " + complexC.conjugates());
        System.out.printf("Absolute value of c = %.2f\n\n", complexC.absoluteValue());

        Complex complexD = new Complex();
        System.out.println("d = "+complexD);
        System.out.println("Conjugates of d = " + complexD.conjugates());
        System.out.printf("Absolute value of d = %.2f\n\n", complexD.absoluteValue());

        System.out.println("c + d = " + complexC.add(complexD));
        System.out.println("c - d = " + complexC.subtract(complexD));
        System.out.println("c * d = " + complexC.multiply(complexD));
        System.out.println("c / d = " + complexC.divide(complexD));
    }

}
