/**  
 * Lucas Ghigli 
 * AIPlayer.java -> GoFish game
 * Ronak Sheth
 * 05/08/2022
*/

import java.util.ArrayList;

class AIPlayer extends Player {
    public ArrayList<Card> queries = new ArrayList<Card>();
    private int age = 0;

    public void haveTurn() {
        boolean playing;
        do {
            Card book = checkForBooks();
            if (book != null)
                System.out.println("The book your opponent got was " + book + "s...");
            if (hand.size() == 0) {
                System.out.print("There is nothing in your opponent's hand.");
                break;
            }
            Card req = aiMagic();
            System.out.println("In response to your opponent's request for cards, he asks for " + req);
            playing = askFor(req);
            age++;
        } while (playing);
        System.out.println("Your opponent went fishing.");
        fish();
    }

    private Card aiMagic() {
        if (age > 2) {
            queries.remove(queries.size() - 1);
            age = 0;
        }
        for (int i = queries.size() - 1; i > -1; i--)
            if (hand.contains(queries.get(i))) {
                return queries.remove(i);
            }
        return hand.get(GoFish.rng.nextInt(hand.size()));
    }
}