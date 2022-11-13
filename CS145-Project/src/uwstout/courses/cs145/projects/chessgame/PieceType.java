package uwstout.courses.cs145.projects.chessgame;

/**
 * Class for PieceType
 * 
 * Represent all of the possible types of pieces that can be used. Currently,
 * there are two values, but more could be added later.
 * 
 * @author SchultzRachel
 * @version 22.11.15
 */

public enum PieceType {
	BISHOP, KNIGHT;

	/**
	 * toString Method
	 * 
	 * Override the toString method so that it returns "Bishop" for the BISHOP value
	 * and "Knight" for the KNIGHT value
	 */
	@Override
	public String toString() {
		String str = "";
		switch (this) {
		case BISHOP:
			str = "Bishop";
			break;
		case KNIGHT:
			str = "Knight";
			break;
		}
		return str;
	}
}
