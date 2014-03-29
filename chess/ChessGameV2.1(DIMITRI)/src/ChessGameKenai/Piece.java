package ChessGameKenai;

import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.JPanel;

public class Piece extends JPanel {

	protected int clickCount = 0;
	protected String type;
	protected int position;
	protected Color color;
	private int countClicks;
	private int previousPosition;

	public Piece() {
		super();
	}

	public Piece(LayoutManager layout) {
		super(layout);
	}

	public Piece(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	public Piece(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}

	/**
	 * The method getColor returns color of the object
	 * @return color
	 */
	public Color getColor() {
	    return color;
	}

	/**
	 * The method setColor sets Color
	 * @param color sets Color of the object
	 */
	public void setColor(Color color) {
	    this.color = color;
	}

	/**
	 * The method getPosition returns Position
	 * @return position of the object
	 */
	public int getPosition() {
	    return position;
	}

	/**
	 * The method setPosition sets object's position
	 * @param position position of the object
	 */
	public void setPosition(int position) {
	    this.position = position;
	}

	/**
	 * The method getType returns type as a String
	 * @return the type of object
	 */
	public String getType() {
	    return type;
	}

	/**
	 * The method setClickCount sets clickCount
	 * @param clickCount sets clicks for the object
	 */
	public void setClickCount(int clickCount) {
	    this.clickCount = clickCount;
	}

	/**
	 * The method getClickCount returns the click count on the current object
	 * This method is needed to check if the piece was clicked or not
	 * @return clickCount as an integer
	 */
	public int getClickCount() {
	    return clickCount;
	}



	/**
	 * The method getPreviousPosition simply returns the previous position
	 * of the piece object
	 * @return previousPosition as an integer
	 */
	public int getPreviousPosition() {
	    return previousPosition;
	}

	/**
	 * The method setPreviousPosition simply sets previous position of the piece
	 * @param previousPosition as an integer
	 */
	public void setPreviousPosition(int previousPosition) {
	    this.previousPosition = previousPosition;
	}

	/**
	 * The method setPosition simply sets position of the piece
	 * @param position as an integer
	 */


	/**
	 * The method setType simply sets the type of the piece
	 * @param type as a String
	 */
	public void setType(String type) {
	    this.type = type;
	}

	/**
	 * The method getType simply returns the type of the piece to the caller
	 * @return type as a String
	 */


	/**
	 * The method getPieceType returns the type the user user
	 * @return as a String
	 */
	public String getPieceType() {
	    return type.substring(1);
	}

}