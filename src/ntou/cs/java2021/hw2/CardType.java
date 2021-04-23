package ntou.cs.java2021.hw2;

/**
 * @author 00857005周固廷(code由老師提供)
 */
public enum CardType {
    NONE("None"), ONE_PAIR("One Pair")
    , FULL_HOUSE("Full House"), FOUR_OF_A_KIND("Four of a Kind"), STRAIGHT_FLUSH(
            "Straight Flush");

    private final String name;

    private CardType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}