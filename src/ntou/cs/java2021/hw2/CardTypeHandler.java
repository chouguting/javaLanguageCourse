package ntou.cs.java2021.hw2;

import java.util.Arrays;

public class CardTypeHandler {

    //生成手牌
    public static HandOfCards produceHandOfCards(Card[] cards) {
        HandOfCards handOfCards = new HandOfCards();
        handOfCards.setCards(cards);
        handOfCards.setType(getType(cards));
        return handOfCards;
    }

    //傳入一堆卡片 回傳這堆卡中有的最大牌型
    private static CardType getType(Card[] cards) {
        CardType cardType = CardType.NONE;
        if (isStraight(cards)&&isFlush(cards)) {
            cardType = CardType.STRAIGHT_FLUSH;
        }else if(howManyXOfAKind(cards,4)==1){
            cardType = CardType.FOUR_OF_A_KIND;
        }else if(howManyXOfAKind(cards,3)==1&&howManyXOfAKind(cards,2)==1){
            cardType=CardType.FULL_HOUSE;
        }else if(howManyXOfAKind(cards,2)>=1){
            cardType=CardType.ONE_PAIR;
        }
        return cardType;
    }

    //傳入一個卡片 回傳這個卡面的大小是排在是幾號
    private static int getCardFaceIndex(Card newCard) {
        int index = 0;
        for (String name : DeckOfCards.faces) {
            if (name.equals(newCard.getFace())) {
                break;
            }
            index++;
        }
        return index;
    }

    private static int[] createFaceIndexList(Card[] cards) {
        int[] indexList = new int[cards.length];
        int index = 0;
        for (Card card : cards) {
            indexList[index] = getCardFaceIndex(card);
            index++;
        }
        return indexList;
    }

    private static boolean isStraight(Card[] cards) {
        int[] cardIndexList = createFaceIndexList(cards.clone());
        Arrays.sort(cardIndexList);
        boolean isStraight = true;
        int currentIndex = cardIndexList[0];
        int straightCount = 1;
        for (int i = 1; i < cardIndexList.length; i++) {
            if (cardIndexList[i] != currentIndex + 1) {
                isStraight = false;
                currentIndex=cardIndexList[i];
                straightCount = 1;
                continue;
            }
            currentIndex = cardIndexList[i];
            straightCount += 1;
        }

        if (straightCount==cardIndexList.length-1&&cardIndexList[0]==0&&cardIndexList[cardIndexList.length-1]==12) {
            isStraight = true;
        }
        return isStraight;
    }


    private static boolean isFlush(Card[] cards){
        boolean isFlush=true;
        String firstSuit=cards[0].getSuit();
        for(Card card:cards){
            if(!card.getSuit().equals(firstSuit)){
                isFlush=false;
                break;
            }
        }
        return isFlush;
    }

    private static int howManyXOfAKind(Card[] cards, int x){
        int[] cardIndexList = createFaceIndexList(cards.clone());
        Arrays.sort(cardIndexList);
        int xOfAKindCounter=0;
        int indexer=0;
        while (indexer<cardIndexList.length){
            int currentFace=cardIndexList[indexer];
            int sameFaceCount=1;
            for(int i=indexer+1;i<cardIndexList.length;i++){
                if(cardIndexList[i]==currentFace){
                    sameFaceCount+=1;
                }else{
                    break;
                }
            }
            if(sameFaceCount==x){
                xOfAKindCounter+=1;
            }
            indexer+=sameFaceCount;
        }
        return xOfAKindCounter;
    }
}
