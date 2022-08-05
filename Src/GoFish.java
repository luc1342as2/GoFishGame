/**  
 * Lucas Ghigli 
 * GoFish.java -> GoFish game
 * Ronak Sheth
 * 05/08/2022
*/
import java.util.ArrayList;
import java.util.Random;

public class GoFish {
    static final Random rng = new Random();
    static public Player[] Players;
    static private ArrayList<Card> cards;

    public static Card draw() {
        return cards.remove(rng.nextInt(cards.size()));
    }

    public static int deckSize() {
        return cards.size();
    }

    public static void main(String[] args) {

        cards = new ArrayList<Card>();
        for (int i = 0; i < 4; i++)
            for (Card c : Card.values())
                cards.add(c);
        Player h = new HumanPlayer();
        Player ai = new AIPlayer();
        Players = new Player[]{h, ai};

        while (Players[0].getNumBooks() + Players[1].getNumBooks() < 13) {
            Players[0].haveTurn();
            System.out.println("__________");
            Players[1].haveTurn();
            System.out.println("__________");
        }

        int yScore = Players[0].getNumBooks();
        int aiScore = Players[1].getNumBooks();
        if (yScore > aiScore)
            System.out.println("Congratulations, you won " + yScore + " to " + aiScore + "!");
        else if (aiScore > yScore)
            System.out.println("The terrible AI beat you " + yScore + " to " + aiScore + "...");
        else
            System.out.println("It's a tie at " + yScore + " each!");
    }
}

