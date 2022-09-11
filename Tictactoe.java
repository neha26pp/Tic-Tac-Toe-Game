import Views.Board;
import wheelsFX.users.Frame.Frame;

/**
 * Tictactoe.java
 * Main class
 *
 * @author NEHA
 * @version 1.0, October 31, 2021
 */
public class Tictactoe {

    /**
     * Function main begins with program execution
     * @param args for command line arguments, not needed here
     */
    public static void main(String[] args) {
        //instantiating a Views.Board object
        Board b = new Board();

        Frame.createFrame();
    }

}


/**
 * SAMPLE OUTPUT:
 *
 * It's player 1's turn
 * It's player 2's turn
 * It's player 1's turn
 * It's player 2's turn
 * It's player 1's turn
 * It's player 2's turn
 * Player 1 wins!
 *
 * NEW GAME
 * It's player 2's turn
 * It's player 1's turn
 * It's player 2's turn
 * It's player 1's turn
 * It's player 2's turn
 * It's player 1's turn
 * Player 2 wins!
 *
 *
 * Process finished with exit code 0
 */