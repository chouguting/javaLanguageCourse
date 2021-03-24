package ntou.cs.java2021.ex3;

public class Card {
    private final String face; // face of card ("Ace", "Deuce", ...)
    private final String suit; // suit of card ("Hearts", "Diamonds", ...)

    // two-argument constructor initializes card's face and suit
    public Card(String face, String suit) {
        this.face = face;
        this.suit = suit;
    }

    // return String representation of Card
    public String toString() {
        return face + " of " + suit;
    }

    public int getPoint() {
        int index = 0;

        // TODO
        while (index < 13) {
            if (this.face.equals(DeckOfCards.faces[index])) {
                break;
            }
            index++;
        }

        if (index == 0) {
            return 20;
        } else {
            return index + 1;
        }
    }

} // end class Card

