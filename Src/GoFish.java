/**  
 * Lucas Ghigli 
 * GoFish.java -> GoFish game
 * 05/08/2022
*/
import java.util.ArrayList;
import java.util.Random;

public class GoFish {
    static final Random rng = new Random();
    static public Player[] Players;
    static private ArrayList<Card> cards; //total cards 52

    public static Card draw() {
        return cards.remove(rng.nextInt(cards.size()));
    }

    public static int deckSize() { //deck size 52 cards.
        return cards.size();
    }

    public static void main(String[] args) {

        cards = new ArrayList<Card>();
        for (int i = 0; i < 4; i++)
            for (Card c : Card.values())
                cards.add(c);
        Player h = new HumanPlayer(); //player information
        Player ai = new AIPlayer(); //AI information
        Players = new Player[]{h, ai}; //it creates the above players.

        while (Players[0].getNumBooks() + Players[1].getNumBooks() < 13) { //it keeps track of the turns for each player.
            Players[0].haveTurn();
            System.out.println("__________");
            Players[1].haveTurn();
            System.out.println("__________");
        }

        int yScore = Players[0].getNumBooks();
        int aiScore = Players[1].getNumBooks();
        if (yScore > aiScore)
            System.out.println("Congratulations, you won " + yScore + " to " + aiScore + "!"); //it prints this if you win.
        else if (aiScore > yScore)
            System.out.println("The terrible AI beat you " + yScore + " to " + aiScore + "..."); //it prints this if you lose to the AI.
        else
            System.out.println("It's a tie at " + yScore + " each!"); //it prints this if it's a draw.
    }
}
