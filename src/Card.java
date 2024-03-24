public class Card {
    private final String face;
    private final String suit;

    public static void main(String[] args) {
        DeckOfCards myDeckOfCards = new DeckOfCards();
        myDeckOfCards.shuffle();
        for (int i = 1; i <= 52; i++) {
            System.out.printf("%-19s", myDeckOfCards.dealCard());
            if (i % 4 == 0) {
                System.out.println();
            }
        }
    }

    public Card(String face, String suit) {
        this.face = face;
        this.suit = suit;
    }

    public String toString() {
        return face + " of " + suit;
    }
}
