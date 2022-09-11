package Models;

import javafx.scene.paint.Color;
import wheelsFX.users.Shapes.Rectangle;

/**
 * Token.java
 * A token class to represent the real world objects of the game i.e. the blue and red colored rectangles
 *
 * @author NEHA
 * @version 1.0 October 31, 2021
 */
public class Token {
    public Rectangle block;
    //red block = X
    //blue-block = O

    /**
     * Constructor to instantiate the rectangle object and set its particulars
     */
    public Token(){

        block = new Rectangle(0,100);
        block.setColor(Color.GRAY);
        block.setSize(100,100);



    }
}
