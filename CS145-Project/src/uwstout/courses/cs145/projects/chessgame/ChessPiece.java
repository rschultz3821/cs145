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

	protected boolean mSide;
	protected Square mSquare;

	/**
	 * Constructor for ChessPiece
	 *
	 * Stores a boolean side and a location = null
	 *
	 * @param side takes in a boolean side
	 */
	public ChessPiece(boolean side) {
		this.mSide = side;
		this.mSquare = null;
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
		return this.mSide;
	}

	/**
	 * Gets IsBlack
	 *
	 * Returns true if the piece is black and false otherwise
	 *
	 * @return !this.side
	 */
	public boolean isBlack() {
		return !this.mSide;
	}

	/**
	 * Gets Square
	 *
	 * Gets the square
	 *
	 * @return this.location
	 */
	public Square getSquare() {
		return this.mSquare;
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
		if (this.mSquare != null) {
			// Remove the current square's reference to this piece
			this.mSquare.setPiece(null);
		}

		if (location != null) {
			if (location.getPiece() != null) {
				// Remove the piece that is already on the square
				location.getPiece().moveTo(null);
			}

			// Set the new square's reference to this piece
			location.setPiece(this);
		}

		// Update this piece's location
		this.mSquare = location;
	}

	/**
	 * toString method
	 *
	 * Creates a toString for ChessPiece
	 *
	 * @return empty String
	 */
	public String toString() {
		return "";
	}

	/**
	 * Method getType
	 *
	 * Takes no parameters and returns a PieceType
	 *
	 * @return PieceType which null
	 */
	public PieceType getType() {
		return null;
	}

	/**
	 * Method getPossibleMoves
	 *
	 * Takes no parameters and returns a MoveList
	 *
	 * @return MoveList which is null
	 */
	public MoveList getPossibleMoves() {
		return null;
	}

	/**
	 * Method canMoveTo
	 *
	 * Determine if the current piece can move to another square on the board.
	 *
	 * @param rank takes in a rank
	 * @param file takes in a file
	 * @return returns true or false
	 */
	protected boolean canMoveTo(int rank, char file) {
		if (this.mSquare != null) {

			Board board = mSquare.getBoard();
			if (board != null) {

				Square newSquare = board.getSquare(rank, file);
				if (this.mSquare.getBoard().getSquare(rank, file) != null) {

					ChessPiece potentialPiece = newSquare.getPiece();
					if (potentialPiece == null || potentialPiece.isBlack() != this.isBlack()) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Method addMove
	 *
	 * Checks if the piece can move to a square and, if so, will add it to the
	 * MoveList. It will also // return a value indicating if that square has a
	 * piece already on it.
	 *
	 * @param possibleMoves[]
	 * @param rank
	 * @param file
	 * @return
	 */
	protected boolean addMove(MoveList possibleMoves, int rank, char file) {
		if (this.canMoveTo(rank, file)) {
			Board board = this.getSquare().getBoard();
			Square square = board.getSquare(rank, file);

			possibleMoves.addMove(square);

			return true;
		}
		return false;
	}
}
