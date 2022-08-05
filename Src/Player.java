/**  
 * Lucas Ghigli 
 * Player.java -> GoFish game
 * Ronak Sheth
 * 05/08/2022
*/
import java.util.ArrayList;

abstract class Player {
    protected ArrayList<Card> hand = new ArrayList<Card>();
    private int numBooks;

    public Player() {
        for (int i = 0; i < 8; i++)
            fish();
    }

    public boolean hasGiven(Card cType) {
        return hand.contains(cType);
    }

    public ArrayList<Card> giveAll(Card cType) {
        ArrayList<Card> x = new ArrayList<Card>();
        for (int i = 0; i < hand.size(); i++)
            if (hand.get(i) == cType)
                x.add(hand.get(i));
        for (int c = 0; c < x.size(); c++)
            hand.remove(cType);
        return x;
    }

    protected boolean askFor(Card cType) {
        int tmp = 0;
        if (this instanceof HumanPlayer)
            tmp = 1;
        Player other = GoFish.Players[tmp]; 

        if (tmp == 1)
            ((AIPlayer) other).queries.add(cType);

        if (other.hasGiven(cType)) {
            for (Card c : other.giveAll(cType))
                hand.add(c);
            return true;
        } else {
            return false;
        }
    }

    protected void fish() {
        if (GoFish.deckSize() > 0)
            hand.add(GoFish.draw());
        else
            System.out.println("The deck is empty."); //it prints this message if there are no cards left in the deck.
    }

    public int getNumBooks() {
        return numBooks;
    }

    protected Card checkForBooks() { //this checks if there are 4 of a kind.
        for (Card c : hand) {
            int num = 0;
            for (Card d : hand)
                if (c == d)
                    num++;
            if (num == 4) {
                for (int i = 0; i < 4; i++)
                    hand.remove(c);
                numBooks++;
                return c;
            }
        }
        return null;


    }

    public abstract void haveTurn();

}
