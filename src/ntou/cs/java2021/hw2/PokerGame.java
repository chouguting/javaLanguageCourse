package ntou.cs.java2021.hw2;


public class PokerGame {
	private DeckOfCards myDeckOfCards;

	public PokerGame() {
		this.gameInit();
	}

	public void dealFiveCards() {
		//int pointCounter = 0;
		Card[] handCard=new Card[5];
		for (int i = 0; i < 5; i++) {
			Card newCard = myDeckOfCards.dealCard();
			handCard[i]=newCard;
			//System.out.println("You got " + newCard + ", point is " + newCard.getPoint());
			//pointCounter += newCard.getPoint();
		}
		HandOfCards handOfCards=CardTypeHandler.produceHandOfCards(handCard);
		System.out.println(handOfCards);
		//System.out.println("Your total point is " + pointCounter);
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
