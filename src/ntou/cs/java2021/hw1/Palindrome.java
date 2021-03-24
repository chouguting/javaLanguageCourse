package ntou.cs.java2021.hw1;

/*
 *  by 00857005 周固廷
 * */

public class Palindrome {
    private int value;

    public Palindrome() {
    }

    public int getValue() {
        return value;
    }

    public void setValue(long value) throws NumberTooBigException, OutOfRangeException, NotPalindromeException {
        if (value > Integer.MAX_VALUE) {
            throw new NumberTooBigException();
        }

        int tempNewNum = (int) value;

        if (lengthIsEven(tempNewNum)) {
            throw new OutOfRangeException();
        }

        if (!isPalindrome(tempNewNum)) {
            throw new NotPalindromeException();
        }
        this.value = tempNewNum;
    }

    private boolean lengthIsEven(int newNum) {
        int counter = 0;
        while (newNum > 0) {
            counter++;
            newNum /= 10;
        }
        return counter % 2 == 0;
    }

    private boolean isPalindrome(int newNum) {
        int tempNum = newNum;
        int reversedNum = 0;
        while (tempNum > 0) {
            reversedNum = reversedNum * 10 + tempNum % 10;
            tempNum /= 10;
        }
        return reversedNum == newNum;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    //當數字太大時會丟這個物件
    public class NumberTooBigException extends Exception {
        public NumberTooBigException() {
            super("Number Over Size");
        }
    }

    //當輸入數字的長度不是奇數時會丟這個
    public class OutOfRangeException extends Exception {
        public OutOfRangeException() {
            super("Number OutOfRange");
        }
    }

    //當輸入數字的不回文時會丟這個
    public class NotPalindromeException extends Exception {
        public NotPalindromeException() {
            super("NotPalindrome");
        }
    }
}
