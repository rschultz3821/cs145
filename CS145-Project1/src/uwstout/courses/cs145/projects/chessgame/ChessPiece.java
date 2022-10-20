package uwstout.courses.cs145.projects.chessgame;

/**
 * Represents a chess piece on the board.
 * 
 * The board has a side (black or white) and a location (the square it is on)
 * 
 * @author SchultzRachel
 * @version 2022.10.18
 */
public class ChessPiece {

	private boolean side;
	private Square mLocation;

	/**
	 * Constructor for ChessPiece
	 * 
	 * Stores a boolean side and a location = null
	 * 
	 * @param side takes in a boolean side
	 */
	public ChessPiece(boolean side) {
		this.side = side;
		this.mLocation = null;
	}

	/**
	 * Gets IsWhite
	 * 
	 * Returns true if the piece is white and false otherwise
	 * 
	 * @return this.side
	 */
	public boolean isWhite() {
		/**
		 * isWhite should return true if the piece is white (i.e., the side variable is
		 * true) and false otherwise.
		 */
		return this.side;
	}

	/**
	 * Gets IsBlack
	 * 
	 * Returns true if the piece is black and false otherwise
	 * 
	 * @return !this.side
	 */
	public boolean isBlack() {
		return !this.side;
	}

	/**
	 * Gets Square
	 * 
	 * Gets the square
	 * 
	 * @return this.location
	 */
	public Square getSquare() {
		return this.mLocation;
	}

	/**
	 * Method for moveTo
	 * 
	 * Moves a piece onto a square If a piece is already on the square it replaces
	 * it and makes that piece null
	 * 
	 * @param location location of the square
	 */
	public void moveTo(Square location) {
		if (this.mLocation != null) {
			this.mLocation.setPiece(null);
		}
		this.mLocation = location;

		if (location != null) {
			if (location.getPiece() != null) {
				location.getPiece().moveTo(null);
			}
			location.setPiece(this);
		}
	}

	/**
	 * toString method
	 * 
	 * Creates a toString for ChessPiece
	 * 
	 * @return String for location and side
	 */
	public String toString() {
		return String.format("location:%s side:%s", this.mLocation, this.side);
	}
}
