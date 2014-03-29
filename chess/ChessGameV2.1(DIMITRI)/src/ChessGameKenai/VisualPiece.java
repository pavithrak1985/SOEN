/*
 * Description: Class VisualPiece.java
 * Author: Dimtri Pankov
 * Date: 2-Feb-2011
 * Version: 1.0
 */
package ChessGameKenai;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import javax.swing.JPanel;

/**
 * The VisualPiece class is the piece that is visual to the user
 * it is only displayed in our view class which is a ChessBoardView
 * The Visual Piece knows its color, position, imagePath type and etc....
 * This calls has two constructors so we can create visual pieces  into two different ways.
 * Each Visual Piece has reference to the board so it can call the board methods and each
 * Visual Piece also has the reference of the non visual piece it represents for easy communication
 * We have decided to use visual and non visual pieces so when we serialize the piece only non visual piece
 * will be serialized it foolproof method to save objects or transport objects over the network, because graphical
 * components are not saveable the will be out of date and no use to us after loading them back so the decision was made
 * to have both visual and non visual pieces for the chess game
 * @author Dimitri Pankov
 * @see JPanel
 * @version 1.5
 */
public class VisualPiece extends Piece {

    private String imagePath;
    private NonVisualPiece piece;
    private MouseListener listener;
    private Board board;

    /**
     * Overloaded constructor of our class receives the path to its image
     * @param imagePath as a String
     */
    public VisualPiece(String imagePath) {
        this.imagePath = imagePath;
        this.setOpaque(false);
        this.setPreferredSize(new Dimension(64, 64));
    }

    /**
     * Overloaded Constructor of our class receives all needed references for its creation
     * The created object will know all information specified during its creation during its life time
     * @param board as a Board
     * @param piece as a Piece
     * @param type as a String
     * @param color as Color
     * @param position as an integer
     * @param imagePath as a String
     */
    public VisualPiece(Board board, NonVisualPiece piece, String type, Color color, int position, String imagePath) {
        this.position = position;
        this.board = board;
        this.color = color;
        this.imagePath = imagePath;
        this.type = type;
        this.piece = piece;
        this.setOpaque(false);
        this.setPreferredSize(new Dimension(64, 64));
        listener = new MouseAdapter() {

            /**
             * The method mousePressed metho of the class
             * @param e MouseEvent object that is generated when visual piece is clicked
             */
            @Override
            public void mousePressed(MouseEvent e) {
                if (VisualPiece.this.piece.canMove()) {
                    VisualPiece.this.piece.setClickCount(++clickCount);
                    Square currentSquare = ((Square) VisualPiece.this.board.getSquares().get(VisualPiece.this.getPosition() - 1));
                    currentSquare.setBackground(Color.BLUE);
                    clickCount = 0;
                    if (VisualPiece.this.getColor() == Color.WHITE) {
                        VisualPiece.this.board.removeListeners(Color.WHITE);
                    } else {
                        VisualPiece.this.board.removeListeners(Color.BLACK);
                    }
                }
                VisualPiece.this.board.startLocalTimer();
            }
        };
        this.addMouseListener(listener);
    }

    /**
     * The method removeListener simply removes the listener
     * from this object
     */
    public void removeListener() {
        this.removeMouseListener(listener);
    }

    /**
     * The method addListener adds a listener to this object
     * as needed by programmer
     */
    public void addListener() {
        this.addMouseListener(listener);
    }

    /**
     * The method getPiece returns the non visual piece that represents this object
     * @return piece as Non_Visual_Piece
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * The method getTextColor return a color as a String
     * @return color as a String
     */
    public String getTextColor() {
        if (Color.WHITE == color) {
            return "White";
        } else {
            return "Black";
        }
    }

    /**
     * The method toString() is overridden by our class
     * which has implementation in the super class
     * @return s as String text representation of the object
     */
    @Override
    public String toString() {
        String s = "";
        s += this.getType() + ", " + this.getTextColor() + ", " + this.getPosition();
        return s;
    }

    /**
     * The method paintComponent of the Pawn_View class
     * @param g Graphics object used to paint this object
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w = this.getWidth();
        int h = this.getHeight();
        URL url = this.getClass().getResource(imagePath);
        Toolkit toolkit = this.getToolkit();
        Image image = toolkit.getImage(url);
        g.drawImage(image, 0, 0, w, h, this);
    }
}
