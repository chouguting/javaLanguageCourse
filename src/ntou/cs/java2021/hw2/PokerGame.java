package ntou.cs.java2021.hw2;


public class PokerGame {
	private DeckOfCards myDeckOfCards;

	public PokerGame() {
		this.gameInit();
	}

	public void dealFiveCards() {
		Card[] handCard=new Card[5];
		for (int i = 0; i < 5; i++) {
			Card newCard = myDeckOfCards.dealCard();
			handCard[i]=newCard;
		}
		//把抽出的排放到手排中 並判斷牌型
		HandOfCards handOfCards=CardTypeHandler.produceHandOfCards(handCard);
		System.out.println(handOfCards);

	}

	public void dealTest() {
		Card[] handCard=new Card[5];
		handCard[0]=new Card(DeckOfCards.faces[6],DeckOfCards.suits[0] );
		handCard[1]=new Card(DeckOfCards.faces[6],DeckOfCards.suits[1] );
		handCard[2]=new Card(DeckOfCards.faces[2],DeckOfCards.suits[2] );
		handCard[3]=new Card(DeckOfCards.faces[2],DeckOfCards.suits[3] );
		handCard[4]=new Card(DeckOfCards.faces[2],DeckOfCards.suits[0] );

		HandOfCards handOfCards=CardTypeHandler.produceHandOfCards(handCard);
		System.out.println(handOfCards);
	}

	public void gameInit() {
		myDeckOfCards = new DeckOfCards();
		myDeckOfCards.shuffle();
	}

} // end class PokerGame
