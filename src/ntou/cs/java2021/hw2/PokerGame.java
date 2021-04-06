package ntou.cs.java2021.hw2;

/**
 * PokerGame是遊戲主體 提供(準備)開始遊戲及發五張牌功能
 *
 * @author 00857005周固廷
 */

public class PokerGame {
    private DeckOfCards myDeckOfCards;

    public PokerGame() {
        this.gameInit();
    }

    //發五張牌
    public void dealFiveCards() {
        Card[] handCard = new Card[5];
        for (int i = 0; i < 5; i++) {
            Card newCard = myDeckOfCards.dealCard();
            handCard[i] = newCard;
        }
        //把抽出的排放到手排中 並判斷牌型
        HandOfCards handOfCards = CardTypeHandler.produceHandOfCards(handCard);
        System.out.println(handOfCards);

    }

    //測試用的method,能調整,並發出想要的牌組
    public void dealTest() {
        Card[] handCard = new Card[5];
        handCard[0] = new Card(DeckOfCards.faces[9], DeckOfCards.suits[0]);
        handCard[1] = new Card(DeckOfCards.faces[10], DeckOfCards.suits[0]);
        handCard[2] = new Card(DeckOfCards.faces[11], DeckOfCards.suits[0]);
        handCard[3] = new Card(DeckOfCards.faces[12], DeckOfCards.suits[0]);
        handCard[4] = new Card(DeckOfCards.faces[0], DeckOfCards.suits[0]);

        HandOfCards handOfCards = CardTypeHandler.produceHandOfCards(handCard);
        System.out.println(handOfCards);
    }

    //準備開始新遊戲
    public void gameInit() {
        myDeckOfCards = new DeckOfCards();
        myDeckOfCards.shuffle();
    }

} // end class PokerGame
