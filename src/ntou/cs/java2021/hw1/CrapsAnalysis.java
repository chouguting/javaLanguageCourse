// Fig. 6.8: Craps.java
// Craps class simulates the dice game craps.
package ntou.cs.java2021.hw1;

import java.security.SecureRandom;

/*
 *  by 00857005 周固廷
 * */

// enum type with constants that represent the game status
enum Status {CONTINUE, WON, LOST}

public class CrapsAnalysis {

    //分析1000場Craps
    public void analysis1000Games() {
        int[] diceRollingWonTimes = new int[22];
        int[] diceRollingLostTimes = new int[22];

        int winningCounter = 0;
        long lengthCounter = 0L;

        for (int i = 0; i < 1000; i++) {
            Craps craps = new Craps();
            craps.gameStart();
            int rollCount = craps.getRollCount();
            Status gameResult = craps.getGameResult();
            if (gameResult == Status.WON) {
                if (rollCount > 20) {
                    diceRollingWonTimes[21]++;
                } else {
                    diceRollingWonTimes[rollCount]++;
                }
                winningCounter++;
            } else {
                if (rollCount > 20) {
                    diceRollingLostTimes[21]++;
                } else {
                    diceRollingLostTimes[rollCount]++;
                }

            }
            lengthCounter += rollCount;
        }

        for (int i = 1; i <= 20; i++) {
            System.out.printf("%d games won and %d games lost on roll #%d\n", diceRollingWonTimes[i], diceRollingLostTimes[i], i);
        }
        System.out.printf("%d games won and %d games lost on rolls after the 20th roll\n", diceRollingWonTimes[21], diceRollingLostTimes[21]);
        System.out.printf("The chances of winning are %d / 1000 = %.2f%%\n", winningCounter, (double) winningCounter / 10);
        System.out.printf("The average game length is %.2f rolls.\n", (double) lengthCounter / 1000);
    }


}

class Craps {
    // create secure random number generator for use in method rollDice
    private static final SecureRandom randomNumbers = new SecureRandom();

    // constants that represent common rolls of the dice
    private static final int SNAKE_EYES = 2;
    private static final int TREY = 3;
    private static final int SEVEN = 7;
    private static final int YO_LEVEN = 11;
    private static final int BOX_CARS = 12;

    private int rollCount;
    private Status gameResult;

    public Craps() {
        this.rollCount = 0;
    }

    // plays one game of craps
    public void gameStart() {
        int myPoint = 0; // point if no win or loss on first roll
        Status gameStatus; // can contain CONTINUE, WON or LOST

        int sumOfDice = rollDice(); // first roll of the dice

        // determine game status and point based on first roll
        switch (sumOfDice) {
            case SEVEN: // win with 7 on first roll
            case YO_LEVEN: // win with 11 on first roll
                gameStatus = Status.WON;
                break;
            case SNAKE_EYES: // lose with 2 on first roll
            case TREY: // lose with 3 on first roll
            case BOX_CARS: // lose with 12 on first roll
                gameStatus = Status.LOST;
                break;
            default: // did not win or lose, so remember point
                gameStatus = Status.CONTINUE; // game is not over
                myPoint = sumOfDice; // remember the point
                break;
        }

        // while game is not complete
        while (gameStatus == Status.CONTINUE) // not WON or LOST
        {
            sumOfDice = rollDice(); // roll dice again

            // determine game status
            if (sumOfDice == myPoint) // win by making point
                gameStatus = Status.WON;
            else if (sumOfDice == SEVEN) // lose by rolling 7 before point
                gameStatus = Status.LOST;
        }

        // display won or lost message
        if (gameStatus == Status.WON)
            gameResult = Status.WON;
        else
            gameResult = Status.LOST;
    }

    public int getRollCount() {
        return rollCount;
    }

    public Status getGameResult() {
        return gameResult;
    }

    // roll dice, calculate sum and display results
    private int rollDice() {
        // pick random die values
        int die1 = 1 + randomNumbers.nextInt(6); // first die roll
        int die2 = 1 + randomNumbers.nextInt(6); // second die roll

        int sum = die1 + die2; // sum of die values

        this.rollCount++;


        return sum;
    }
} // end class Craps

