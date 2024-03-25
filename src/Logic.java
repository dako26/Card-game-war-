public class Logic {
    private final static int TIE = 0;
    private final static int I_WIN = 1;
    private final static int YOU_WIN = 2;
    private final static int END_GAME = -1;

    public static void main(String[] args) {
        DeckOfCards myDeckOfCards = new DeckOfCards();
        myDeckOfCards.shuffle();
        DeckOfCards yourDeckOfCards = new DeckOfCards();
        yourDeckOfCards.shuffle();
        DeckOfCards drawDeck = new DeckOfCards();

        while (!myDeckOfCards.getDeck().isEmpty() && !yourDeckOfCards.getDeck().isEmpty()) {
            System.out.println("My Card: " + myDeckOfCards.getDeck().get(0));
            System.out.println("Your Card: " + yourDeckOfCards.getDeck().get(0));
            switch (winningStatus(myDeckOfCards, yourDeckOfCards, drawDeck, 1)) {
                case TIE:
                    System.out.println("Draw!");
                    winningStatus(myDeckOfCards, yourDeckOfCards, drawDeck, 2);
                    break;
                case I_WIN:
                    System.out.println("I win!");
                    addToWinningDeck(myDeckOfCards, drawDeck);
                    break;
                case YOU_WIN:
                    System.out.println("You win!");
                    addToWinningDeck(yourDeckOfCards, drawDeck);
                    break;
                case END_GAME:
                    break;
            }
            addToWinningDeck(myDeckOfCards, drawDeck);
        }

        if (myDeckOfCards.getDeck().isEmpty()) {
            System.out.println("I win the game!");
        } else {
            System.out.println("You win the game!");
        }

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
