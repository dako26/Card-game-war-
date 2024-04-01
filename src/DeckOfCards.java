import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Represents a deck of 52 playing cards.
 * written by: Daniel Koren
*/
public class DeckOfCards {
    private final ArrayList<Card> deck;
    private int currentCard;
    private static final int DECK_SIZE = 52;
    private static final SecureRandom random = new SecureRandom();

    /**
     * Constructs a new DeckOfCards object representing a standard deck of 52 playing cards.
     * The deck is initialized with cards in the order: Ace of Hearts, Deuce of Hearts, ... King of Spades.
     */
    public DeckOfCards() {
        ArrayList<String> faces = new ArrayList<>(Arrays.asList("Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"));
        ArrayList<String> suits = new ArrayList<>(Arrays.asList("Hearts", "Diamonds", "Clubs", "Spades"));
        deck = new ArrayList<>(DECK_SIZE);
        currentCard = 0;

        for (int count = 0; count < DECK_SIZE; count++) {
            deck.add(count, new Card(faces.get(count % 13), suits.get(count / 13)));
        }
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }


    public void shuffle() {
        currentCard = 0;
        for (int first = 0; first < deck.size(); first++) {
            int second = random.nextInt(DECK_SIZE);
            Card temp = deck.get(first);
            deck.set(first, deck.get(second));
            deck.set(second, temp);
        }
    }

    public Card withdrawCard() {
        if (currentCard < deck.size()) {
            return deck.remove(currentCard);
        }
        return null;
    }

    public void addCard(Card card) {
        deck.add(card);
    }
    //endregion
/*

 */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Card card : deck) {
            s.append(card).append("\n");
        }
        return s.toString();
    }
}



