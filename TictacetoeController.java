package Controllers;

import Models.Token;
import Views.Board;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import wheelsFX.users.Shapes.Rectangle;

/**
 * TictactoeController.java
 * A controller class that contains the logic of the game
 *
 * @author NEHA
 * @version 1.0, October 31, 2021
 */
public class TictacetoeController {

    private Board tictactoeBoard; //a field of the Board (views) class.

    public Token[][] board; //a 2D array of Tokens

    Color player1 = Color.RED; //to represent first player's mark (X)
    Color player2 = Color.BLUE;//to represent second player's mark (O)
    Color currentPlayer = player1; //setting the current player to default player1


    /**
     * Constructor to instantiate a new token, store the rectangle objects into the token array
     * and set the locations of the rectangle objects on the board
     *
     * @param tictactoeBoard : field of Views.Board class
     */
    public TictacetoeController(Board tictactoeBoard){

        this.board = new Token[ 3 ][ 3 ]; //3D array to represent the board

        this.tictactoeBoard = tictactoeBoard;

        //storing the rectangle objects into the token array
        for(int i = 0; i <3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = new Token();

            }
        }

        //setting locations of the rectangle objects to match those on the board
        board[0][0].block.setLocation(0,100);
        board[1][0].block.setLocation(100,100);
        board[2][0].block.setLocation(200,100);
        board[0][1].block.setLocation(0,200);
        board[1][1].block.setLocation(100,200);
        board[2][1].block.setLocation(200,200);
        board[0][2].block.setLocation(0,300);
        board[1][2].block.setLocation(100,300);
        board[2][2].block.setLocation(200,300);


    }

    /**
     * Function to check if we have a winner.
     * Takes into consideration 9 winning combinations
     */
    public void checkWinner(){
        if(board[0][0].block.getFillColor() == Color.RED && board[1][0].block.getFillColor() == Color.RED && board[2][0].block.getFillColor() == Color.RED){
            player1Wins(board[0][0].block, board[1][0].block, board[2][0].block);

        }else if(board[0][1].block.getFillColor() == Color.RED && board[1][1].block.getFillColor() == Color.RED && board[2][1].block.getFillColor() == Color.RED){
            player1Wins(board[0][1].block, board[1][1].block, board[2][1].block);

        }else if(board[0][2].block.getFillColor() == Color.RED && board[1][2].block.getFillColor() == Color.RED && board[2][2].block.getFillColor() == Color.RED) {
            player1Wins(board[0][2].block, board[1][2].block, board[2][2].block);

        }else if(board[0][0].block.getFillColor() == Color.BLUE && board[1][0].block.getFillColor() == Color.BLUE && board[2][0].block.getFillColor() == Color.BLUE) {
            player2Wins(board[0][0].block, board[1][0].block, board[2][0].block);

        }else if(board[0][1].block.getFillColor() == Color.BLUE && board[1][1].block.getFillColor() == Color.BLUE && board[2][1].block.getFillColor() == Color.BLUE) {
            player2Wins(board[0][1].block, board[1][1].block, board[2][1].block);

        }else if(board[0][2].block.getFillColor() == Color.BLUE && board[1][2].block.getFillColor() == Color.BLUE && board[2][2].block.getFillColor() == Color.BLUE) {
            player2Wins(board[0][2].block, board[1][2].block, board[2][2].block);

        }//horizontal rows
        else if(board[0][0].block.getFillColor() == Color.RED && board[0][1].block.getFillColor() == Color.RED && board[0][2].block.getFillColor() == Color.RED){
            player1Wins(board[0][0].block, board[0][1].block, board[0][2].block);

        }else if(board[1][0].block.getFillColor() == Color.RED && board[1][1].block.getFillColor() == Color.RED && board[1][2].block.getFillColor() == Color.RED){
            player1Wins(board[1][0].block, board[1][1].block, board[1][2].block);

        }else if(board[2][0].block.getFillColor() == Color.RED && board[2][1].block.getFillColor() == Color.RED && board[2][2].block.getFillColor() == Color.RED){
            player1Wins(board[2][0].block, board[2][1].block, board[2][2].block);

        }else if(board[0][0].block.getFillColor() == Color.BLUE && board[0][1].block.getFillColor() == Color.BLUE && board[0][2].block.getFillColor() == Color.BLUE){
            player2Wins(board[0][0].block, board[0][1].block, board[0][2].block);

        }else if(board[1][0].block.getFillColor() == Color.BLUE && board[1][1].block.getFillColor() == Color.BLUE && board[1][2].block.getFillColor() == Color.BLUE){
            player2Wins(board[1][0].block, board[1][1].block, board[1][2].block);

        }else if(board[2][0].block.getFillColor() == Color.BLUE && board[2][1].block.getFillColor() == Color.BLUE && board[2][2].block.getFillColor() == Color.BLUE) {
            player2Wins(board[2][0].block, board[2][1].block, board[2][2].block);

        }//vertical columns
        else if(board[0][0].block.getFillColor() == Color.RED && board[1][1].block.getFillColor() == Color.RED &&  board[2][2].block.getFillColor() == Color.RED ){
            player1Wins(board[0][0].block, board[1][1].block, board[2][2].block);

        }else if(board[2][0].block.getFillColor() == Color.RED && board[1][1].block.getFillColor() == Color.RED &&  board[0][2].block.getFillColor() == Color.RED ){
            player1Wins(board[2][0].block, board[1][1].block, board[0][2].block);

        }else if(board[0][0].block.getFillColor() == Color.BLUE && board[1][1].block.getFillColor() == Color.BLUE &&  board[2][2].block.getFillColor() == Color.BLUE ){
            player2Wins(board[0][0].block, board[1][1].block, board[2][2].block);

        }else if(board[2][0].block.getFillColor() == Color.BLUE && board[1][1].block.getFillColor() == Color.BLUE && board[0][2].block.getFillColor() == Color.BLUE){
            player2Wins(board[2][0].block, board[1][1].block, board[0][2].block);

        }//diagonals
        else {
            tie();

        }

    }

    /**
     * Function to reset the board and start a new game once we have a winner or tie
     * Called in Views.Board class
     */
    public void reset(){

        //bringing back the original colors of the blocks
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j].block.setColor(Color.GRAY);
                }
            }
            currentPlayer = player1; //default turn set to player 1


    }

    /**
     * Function for player 1's win
     * @param block : first rectangle of winning combination
     * @param block1 : second rectangle of winning combination
     * @param block2 : third rectangle of winning combination
     */
    public void player1Wins(Rectangle block, Rectangle block1, Rectangle block2) {

        block.setColor(Color.GREEN);
        block1.setColor(Color.GREEN);
        block2.setColor(Color.GREEN);

        System.out.println("Player 1 wins!");
        System.out.println();


    }

    /**
     * Function for player 2's win
     * @param block : first rectangle of winning combination
     * @param block1 : second rectangle of winning combination
     * @param block2 : third rectangle of winning combination
     */
    public void player2Wins(Rectangle block, Rectangle block1, Rectangle block2){

        block.setColor(Color.GREEN);
        block1.setColor(Color.GREEN);
        block2.setColor(Color.GREEN);

        System.out.println("Player 2 wins!");
        System.out.println();



    }

    /**
     * Function to represent state of board
     * Called in tie() method
     * @return : a boolean value true/false depending on state of board
     */
    public  boolean boardFull(){
        for(int i = 0; i < 3 ; i++){
            for(int j = 0; j <3 ; j++){
                if(board[i][j].block.getFillColor() == Color.GRAY){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Function to decide if there's a tie
     * Calls the boardFull() method
     */
    public void tie(){

       if(boardFull()== true){
           System.out.println("It's a tie");

       }

    }


    /**
     * Function to control main logic of program
     * Lays out the rules for the game
     */
    public void play() {
        System.out.println("It's player 1's turn"); //default first

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                int finalI = i;
                int finalJ = j;

                //when a block on the board is clicked
                //allowing user to make their mark
                board[i][j].block.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {

                        //alternating turns
                        if(currentPlayer == player1){

                            System.out.println("It's player 2's turn");

                            //if user tries to access a rectangle that has already been filled
                            if(board[finalI][finalJ].block.getFillColor() == Color.GRAY){
                                board[finalI][finalJ].block.setColor(player1);
                                checkWinner();
                                currentPlayer = player2;
                            }else{
                                System.out.println("Invalid attempt");
                            }

                        }else{

                            System.out.println("It's player 1's turn");

                            //if user tries to access a rectangle that has already been filled
                            if(board[finalI][finalJ].block.getFillColor() == Color.GRAY){
                                board[finalI][finalJ].block.setColor(player2);
                                checkWinner();
                                currentPlayer = player1;
                            }else{
                                System.out.println("Invalid attempt");
                            }


                        }




                    }


                });





            }




        }




    }


}








