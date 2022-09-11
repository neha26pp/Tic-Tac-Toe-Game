package Views;


import Controllers.TictacetoeController;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import wheelsFX.users.Shapes.Line;
import wheelsFX.users.Shapes.Rectangle;

/**
 * Board.java
 * A class to represent the tic tac toe board
 * @author NEHA
 * @version 1.0, October 31,2021
 */
public class Board {
    private TictacetoeController tictacetoeController; //a Controllers.TictactoeController object

    /**
     * Constructor to instantiate a tictactoe controller and
     * build the board using lines
     *
     */
    public Board(){

        //controller and board can communicate withe each other
        this.tictacetoeController = new TictacetoeController(this);

        //building the board
        Line line1 = new Line();
        line1.setP1(100, 100);
        line1.setP2(100, 400);


        Line line2 = new Line();
        line2.setP1(200, 100);
        line2.setP2(200, 400);


        Line line3 = new Line();
        line3.setP1(300, 100);
        line3.setP2(300, 400);


        Line line4 = new Line();
        line4.setP1(0, 100);
        line4.setP2(300, 100);


        Line line5 = new Line();
        line5.setP1(0, 100);
        line5.setP2(0, 400);


        Line line6 = new Line();
        line6.setP1(0, 400);
        line6.setP2(300, 400);


        Line line7 = new Line();
        line7.setP1(0, 200);
        line7.setP2(300, 200);


        Line line8 = new Line();
        line8.setP1(0, 300);
        line8.setP2(300, 300);

        //a button to reset the board and start a new game
        Rectangle resetButton = new Rectangle(100,500);
        resetButton.setSize(70,30);
        resetButton.setColor(Color.GREEN);

        resetButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tictacetoeController.reset();
                System.out.println("NEW GAME");
            }
        });



        tictacetoeController.play();






    }
}
