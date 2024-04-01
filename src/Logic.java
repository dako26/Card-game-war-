/**
 * The Logic class implements a simple card game where two players draw cards from their respective decks.
 * The player with the higher-ranking cards wins the game (war card game).
 * written by: Daniel Koren
 */
import javax.swing.JOptionPane;
public class Logic {
    private final static int TIE = 0;
    private final static int I_WIN = 1;
    private final static int YOU_WIN = 2;
    private final static int END_GAME = -1;

    public static void main(String[] args) {
        String Cards;
        DeckOfCards myDeckOfCards = new DeckOfCards();
        myDeckOfCards.shuffle();
        DeckOfCards yourDeckOfCards = new DeckOfCards();
        yourDeckOfCards.shuffle();
        DeckOfCards drawDeck = new DeckOfCards();
        JOptionPane.showMessageDialog(null, "Welcome to \"War\" Card game\n\nWritten by Daniel Koren", "War Game", JOptionPane.INFORMATION_MESSAGE);

        while (!myDeckOfCards.getDeck().isEmpty() && !yourDeckOfCards.getDeck().isEmpty()) {
            Cards = getCardsString(myDeckOfCards, yourDeckOfCards);
            switch (winningStatus(myDeckOfCards, yourDeckOfCards, drawDeck, 1)) {
                case TIE:
                    JOptionPane.showMessageDialog(null, Cards+"Draw!", "War Game", JOptionPane.INFORMATION_MESSAGE);
                    winningStatus(myDeckOfCards, yourDeckOfCards, drawDeck, 2);
                    break;
                case I_WIN:
                    JOptionPane.showMessageDialog(null, Cards+"I win!", "War Game", JOptionPane.INFORMATION_MESSAGE);
                    addToWinningDeck(myDeckOfCards, drawDeck);
                    break;
                case YOU_WIN:
                    JOptionPane.showMessageDialog(null, Cards+"You win!", "War Game", JOptionPane.INFORMATION_MESSAGE);
                    addToWinningDeck(yourDeckOfCards, drawDeck);
                    break;
                case END_GAME:
                    break;
            }
            addToWinningDeck(myDeckOfCards, drawDeck);
        }

        if (myDeckOfCards.getDeck().isEmpty()) {
            JOptionPane.showMessageDialog(null, "I win the game!", "War Game", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "You win the game!", "War Game", JOptionPane.INFORMATION_MESSAGE);
        }

    }
    private static String getCardsString(DeckOfCards myDeckOfCards, DeckOfCards yourDeckOfCards) {
        return "My Card: " + myDeckOfCards.getDeck().get(0)+"\nYour Card: " + yourDeckOfCards.getDeck().get(0)+"\n\n";
    }

    private static int winning(Card myCard, Card yourCard) {
        if (myCard.getFace().equals(yourCard.getFace())) {
            return TIE;
        } else if (myCard.getFace().equals("Ace")) {
            return I_WIN;
        } else if (yourCard.getFace().equals("Ace")) {
            return YOU_WIN;
        } else if (myCard.getValue() > yourCard.getValue()) {
            return I_WIN;
        } else {
            return YOU_WIN;
        }

    }

    private static int winningStatus(DeckOfCards myDeckOfCards, DeckOfCards yourDeckOfCards, DeckOfCards drawDeck, int count) {
        Card myCard = null;
        Card yourCard = null;
        while (count != 0) {
            if (myDeckOfCards.getDeck().isEmpty() || yourDeckOfCards.getDeck().isEmpty()) {
                return -1;
            }
            myCard = myDeckOfCards.withdrawCard();
            yourCard = yourDeckOfCards.withdrawCard();
            drawDeck.addCard(myCard);
            drawDeck.addCard(yourCard);
            count--;
        }
        return winning(myCard, yourCard);
    }

    private static void addToWinningDeck(DeckOfCards deck, DeckOfCards drawDeck) {
        for (int i = 0; i < drawDeck.getDeck().size(); i++) {
            deck.addCard(drawDeck.getDeck().get(i));
        }
        drawDeck.getDeck().clear();
    }
}
