package uwstout.courses.cs145.projects.chessgame;

/**
 * Class for MoveTo
 * 
 * This class will store a list of Square objects that represent all of the
 * places that a piece can (legally) move to.
 * 
 * @author SchultzRachel
 * @version 22.11.15
 */

public class MoveList {
	private int mNumMoves;
	private Square[] mMoveList;
	private static final int INITIAL_MOVE_LIST_SIZE = 10;

	public MoveList() {
		this.reset();
	}

	public void addMove(Square square) {
		// takes in a Square parameter and returns nothing
		// adds the square to the array at the first open position
		boolean resize = true;
		
		for (int i = 0; i < this.mMoveList.length; i++) {
			Square iSquare = this.mMoveList[i];
			if (iSquare == null) {
				iSquare = square;
				resize = false;
				break;
			}
		}
		
		if (resize) {
			Square[] newMoveList = new Square[this.mMoveList.length * 2 + 1];
			for (int i = 0; i < this.mMoveList.length; i++) {
				newMoveList[i] = this.mMoveList[i];
			}
			
			newMoveList[this.mMoveList.length] = square;
			this.mMoveList = newMoveList;
		}
		
		this.mNumMoves++;
	}

	public int getNumMoves() {
		return this.mNumMoves;
	}

	public Square getMove(int pos) {
		try {
			return this.mMoveList[pos];
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
	}

	public Square findMove(int rank, char file) {
		// look through values in the array
		for (Square square : this.mMoveList) {
			// if one of the squares has that rank and file, return it
			if (square.getRank() == rank && square.getFile() == file) {
				return square;
			}
		}
		// otherwise return null;
		return null;
	}

	public void reset() {
		this.mNumMoves = 0;
		this.mMoveList = new Square[INITIAL_MOVE_LIST_SIZE];
	}
}
