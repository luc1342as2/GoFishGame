/**  
 * Lucas Ghigli 
 * HumanPlayer.java -> GoFish game
 * Ronak Sheth
 * 05/08/2022
*/
import java.util.Scanner;

class HumanPlayer extends Player {
    public void haveTurn() {
        Scanner scn = new Scanner(System.in);
        boolean playing = true;
        do {
            Card book = checkForBooks();
            if (book != null)
                System.out.println("The book you got is " + book + "s!"); //it prints this when you get 4 of a kind.

            if (hand.size() == 0) {
                System.out.print("There is nothing in your hand "); //it prints this when there are no cards left in your hand.
                break;
            } else {
                System.out.print("Your hand:"); //it prints the information of your hand.
                for (Card c : hand)
                    System.out.print(c + " ");
                System.out.println();
            }

            System.out.println("What card does the opponent have?"); //it asks you this question.

            Card req;
            try {
                req = Card.valueOf(scn.next().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("There is no card in this deck. Please try again.:"); //when you try to draw a card from the deck when there are no cards left in the deck.
                continue;
            }

            if (!hand.contains(req)) {
                System.out.println("If you don't have a card, you should not ask for one. Try again.:");
                continue;
            }

            System.out.println("You asked for a " + req); //this prints a card you asked to the other player.
            playing = askFor(req);
        } while (playing);
        System.out.println("Go fish!"); //this prints when you guess wrong.
        fish();
    }
}
