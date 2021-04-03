package ntou.cs.java2021.hw2;

/**
 * HandOfCards(手牌) 可以存五張牌和一個對應的牌型名稱
 *
 * @author 00857005周固廷
 */
public class HandOfCards {
    private Card[] cards;
    private CardType type;

    public Card[] getCards() {
        return cards;
    }

    public void setCards(Card[] cards) {
        this.cards = cards.clone();
    }

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        String str = "Your Cards: ";
        for (int i = 0; i < this.cards.length; i++) {
            str += this.cards[i];
            if (i != this.cards.length - 1) str += ",";
        }
        str += "\n";
        str += "Card type: ";
        str += this.type.getName();
        return str;
    }
}
