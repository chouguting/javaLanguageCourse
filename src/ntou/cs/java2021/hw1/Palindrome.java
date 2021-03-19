package ntou.cs.java2021.hw1;

public class Palindrome {
    private int value;

    public Palindrome() {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) throws NotFiveDigitException,NotPalindromeException{
        if(value/10000<1||value/10000>9){
                throw new NotFiveDigitException();
        }
        if(!isPalindrome(value)){
                throw new NotPalindromeException();
        }
        this.value = value;
    }

    private boolean isPalindrome(int newNum){
        int tempNum=newNum;
        int reversedNum=0;
        while(tempNum>0){
            reversedNum=reversedNum*10+tempNum%10;
            tempNum/=10;
        }
        return reversedNum==newNum;
    }

    public class NotFiveDigitException extends Exception{
        public NotFiveDigitException() {
            super("Number must be 5 digits");
        }
    }

    public class NotPalindromeException extends Exception{
        public NotPalindromeException() {
            super("NotPalindrome");
        }
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
