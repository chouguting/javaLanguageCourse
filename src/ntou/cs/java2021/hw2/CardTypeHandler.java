package ntou.cs.java2021.hw2;

import java.util.Arrays;

/**
 * CardTypeHandler可以判斷一個卡片陣列裡面有什麼牌型
 *
 * @author 00857005周固廷
 */
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
        if (isStraight(cards) && isFlush(cards)) {
            cardType = CardType.STRAIGHT_FLUSH;
        } else if (howManyXOfAKind(cards, 4) == 1) {
            cardType = CardType.FOUR_OF_A_KIND;
        } else if (howManyXOfAKind(cards, 3) == 1 && howManyXOfAKind(cards, 2) == 1) {
            cardType = CardType.FULL_HOUSE;
        } else if (howManyXOfAKind(cards, 2) >= 1) {
            cardType = CardType.ONE_PAIR;
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

    //傳入一個卡片陣列 回傳一個由這些卡片牌面大小序號組成的數字陣列
    private static int[] createFaceIndexList(Card[] cards) {
        int[] indexList = new int[cards.length];
        int index = 0;
        for (Card card : cards) {
            indexList[index] = getCardFaceIndex(card);
            index++;
        }
        return indexList;
    }

    //判斷傳入的一堆卡片中有沒有順子
    private static boolean isStraight(Card[] cards) {
        int[] cardIndexList = createFaceIndexList(cards.clone());
        Arrays.sort(cardIndexList);
        boolean isStraight = true;
        int currentIndex = cardIndexList[0];
        int straightCount = 1;
        for (int i = 1; i < cardIndexList.length; i++) {
            if (cardIndexList[i] != currentIndex + 1) {
                isStraight = false;  //如果有一個不連續就不是順子了
                currentIndex = cardIndexList[i];
                straightCount = 1;
                continue;
            }
            currentIndex = cardIndexList[i];
            straightCount += 1;
        }
        //special case: 10,J,Q,K,A
        if (straightCount == cardIndexList.length - 1 && cardIndexList[0] == 0 && cardIndexList[cardIndexList.length - 1] == 12) {
            isStraight = true;
        }
        return isStraight;
    }

    //判斷傳入的一堆卡片中有沒有同花
    private static boolean isFlush(Card[] cards) {
        boolean isFlush = true;
        String firstSuit = cards[0].getSuit();
        for (Card card : cards) {
            if (!card.getSuit().equals(firstSuit)) {
                isFlush = false;
                break;
            }
        }
        return isFlush;
    }

    //回傳輸入的牌堆中有幾組 X張同花色 的牌組
    //example: 如果X=2,回傳值=2,代表傳入的牌堆中 有兩個pairs
    //         如果X=3,回傳值=1,代表傳入的牌堆中 有一個三條
    private static int howManyXOfAKind(Card[] cards, int x) {
        int[] cardIndexList = createFaceIndexList(cards.clone());
        Arrays.sort(cardIndexList);
        int xOfAKindCounter = 0;
        int indexer = 0;
        while (indexer < cardIndexList.length) {
            int currentFace = cardIndexList[indexer];
            int sameFaceCount = 1;
            for (int i = indexer + 1; i < cardIndexList.length; i++) {
                if (cardIndexList[i] == currentFace) {
                    sameFaceCount += 1;
                } else {
                    break;
                }
            }
            if (sameFaceCount == x) {
                xOfAKindCounter += 1;
            }
            indexer += sameFaceCount;
        }
        return xOfAKindCounter;
    }
}
