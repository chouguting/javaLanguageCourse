package ntou.cs.java2021.ex3;

public class PokerGame {
    private DeckOfCards myDeckOfCards;

    public PokerGame() {
        this.gameInit();
    }

    public void dealFiveCards() {
        int pointCounter = 0;
        for (int i = 0; i < 5; i++) {
            Card newCard = myDeckOfCards.dealCard();
            System.out.println("You got " + newCard + ", point is " + newCard.getPoint());
            pointCounter += newCard.getPoint();
        }
        System.out.println("Your total point is " + pointCounter);
    }

    public void gameInit() {
        myDeckOfCards = new DeckOfCards();
        myDeckOfCards.shuffle();
    }

} // end class PokerGame
