package testing;


public class Main {
    public static void main(String[] args){
        Complex complex1=new Complex(2,4);
        Complex complex2=complex1;
        System.out.println("1:"+complex1);
        complex2.setReal(4);
        System.out.println("2:"+complex1);

        Complex complex3=complex2;
        modify(new Complex(complex2));
        System.out.println("4:"+complex1);

        modify(complex3);
        System.out.println("5:"+complex1);
    }

    public static void modify(Complex aa){
        aa.setImaginary(100);
        System.out.println("3:"+aa);
    }
}
