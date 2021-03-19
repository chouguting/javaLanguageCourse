package lecture02;

public class Main {
    private enum NumTest{A1,A2,A3};

    public static void main(String[] args){
        String a="";
        int b=5;
        a+=b;
        Math.abs(b);

        NumTest numTest;
        numTest=NumTest.A1;

        System.out.println(numTest);

        Test test=new Test("aaa");
        boolean a1=false;
        boolean b1=false;
        System.out.println(a);
    }
}
