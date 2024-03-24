public class Logic {

    public static void main(String[] args) {
        DeckOfCards myDeckOfCards = new DeckOfCards();
        myDeckOfCards.shuffle();
        DeckOfCards yourDeckOfCards = new DeckOfCards();
        yourDeckOfCards.shuffle();
        System.out.println("My deck of cards:");
        System.out.println(myDeckOfCards);
        System.out.println("Your deck of cards:");
        System.out.println(yourDeckOfCards);

    }
    private static String winning(Card myCard, Card yourCard) {
        if (myCard.getFace().equals(yourCard.getFace())) {
            return "It's a tie!";
        } else if (myCard.getFace().equals("Ace")) {
            return "I win!";
        } else if (yourCard.getFace().equals("Ace")) {
            return "You win!";
        } else {
            return "It's a tie!";
        }

    }
}
