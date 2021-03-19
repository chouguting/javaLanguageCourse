package ntou.cs.java2021.hw1;

public class PalindromeBonus {
    private int value;

    public PalindromeBonus() {
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

    public class NumberTooBigException extends Exception {
        public NumberTooBigException() {
            super("Number Over Size");
        }
    }

    public class OutOfRangeException extends Exception {
        public OutOfRangeException() {
            super("Number must be 5 digits");
        }
    }

    public class NotPalindromeException extends Exception {
        public NotPalindromeException() {
            super("NotPalindrome");
        }
    }
}
