import java.util.ArrayList;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;


public class DeckOfCards {
    private ArrayList<Card> deck;
    private int currectCard;
    private static final int DECK_SIZE = 52;
    private static final SecureRandom random = new SecureRandom();

    public DeckOfCards() {
        ArrayList<String> faces = new ArrayList<String>(Arrays.asList("Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"));
        ArrayList<String> suits = new ArrayList<String>(Arrays.asList("Hearts", "Diamonds", "Clubs", "Spades"));
        deck = new ArrayList<Card>();
        currectCard = 0;

        int value = 1;
        for (int count = 0; count < DECK_SIZE; count++) {
            deck.add(new Card(faces.get(count % 13), suits.get(count / 13), value));
            value++;
            if (value > 10) {
                value = 1;
            }
        }
    }

    public void shuffle() {
        currectCard = 0;
        for (int first = 0; first < deck.size(); first++) {
            int second = random.nextInt(DECK_SIZE);
            Card temp = deck.get(first);
            deck.set(first, deck.get(second));
            deck.set(second, temp);
        }
    }
    public Card dealCard() {
        if (currectCard <deck.size()){
            return deck.get(currectCard++);
        } else {
            return null;
        }
    }
    public void withdrawCard() {
        if (currectCard <deck.size()){
             deck.remove(currectCard);
        }
    }
    public void addCard(Card card) {
        deck.add(card);
    }


}



