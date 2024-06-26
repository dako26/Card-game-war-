/**
 * The Card class represents a playing card with a face value and a suit.
 * written by: Daniel Koren
 */

public class Card {
    private final String face;
    private final String suit;

    /**
     * Constructs a new Card object with the specified face value and suit.
     */
    public Card(String face, String suit) {
        this.face = face;
        this.suit = suit;
    }
/**
 * Retrieves the numerical value of the card based on its face value.
 */
    public int getValue() {
        return switch (this.face) {
            case "Ace" -> 1;
            case "Deuce" -> 2;
            case "Three" -> 3;
            case "Four" -> 4;
            case "Five" -> 5;
            case "Six" -> 6;
            case "Seven" -> 7;
            case "Eight" -> 8;
            case "Nine" -> 9;
            case "Ten" -> 10;
            case "Jack" -> 11;
            case "Queen" -> 12;
            case "King" -> 13;
            default -> 0;
        };
    }

    public String getFace() {
        return face;
    }



    public String toString() {
        return face + " of " + suit ;
    }

}
