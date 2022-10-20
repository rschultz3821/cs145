package uwstout.courses.cs145.projects.chessgame;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test for ChessPiece Class
 * 
 * Test for ChessPiece Class
 * 
 * @author SchultzRachel
 * @version 2022.20.18
 */
public class ChessPieceTest {

	/**
	 * Test for getIsWhitw
	 * 
	 * Returns true if it's white and false if it's black
	 */
	@Test
	public void testGetIsWhite() {
		ChessPiece p1 = new ChessPiece(true);
		assertEquals("White = true", true, p1.isWhite());

		ChessPiece p2 = new ChessPiece(false);
		assertEquals("black = false", false, p2.isWhite());
	}

	/**
	 * Test for getIsBlack
	 * 
	 * Returns true if it's black and false if it's white
	 */
	@Test
	public void testGetIsBlack() {
		ChessPiece p1 = new ChessPiece(false);
		assertEquals("Black = true", true, p1.isBlack());

		ChessPiece p2 = new ChessPiece(true);
		assertEquals("white = false", false, p2.isBlack());
	}

	/**
	 * Test for getSquare
	 * 
	 * If the ChessPiece is true or false it returns null for getSquare
	 */
	@Test
	public void testGetSquare() {
		ChessPiece p1 = new ChessPiece(true);
		assertEquals("null", null, p1.getSquare());

		ChessPiece p2 = new ChessPiece(false);
		assertEquals("null", null, p2.getSquare());
	}

	/**
	 * Test for moveTo
	 * 
	 * Test for moving one piece onto an empty square Test for moving one piece onto
	 * another empty piece Test for moving one piece onto a square that is not empty
	 * Test for moving off of the square (null)
	 */
	@Test
	public void testMoveTo() {
		// move one piece onto an empty square
		Board board = new Board(8, 'h');

		Square previousSquare = null;

		ChessPiece p1 = new ChessPiece(true);
		ChessPiece p2 = new ChessPiece(false);

		// loop over to see if everything is null
		for (int rank = board.getMinRank(); rank <= board.getMaxRank(); rank++) {
			for (char file = board.getMinFile(); file < board.getMaxFile(); file++) {
				// move piece from null to the empty square
				p1.moveTo(board.getSquare(rank, file));
				assertEquals(p1, board.getSquare(rank, file).getPiece());
				assertEquals(board.getSquare(rank, file), p1.getSquare());
				if (previousSquare != null) {
					assertEquals(null, previousSquare.getPiece());
				}

				// move piece from null to the nonempty square
				p2.moveTo(board.getSquare(rank, file));
				assertEquals(p2, board.getSquare(rank, file).getPiece());
				assertEquals(board.getSquare(rank, file), p2.getSquare());
				assertEquals(null, p1.getSquare());

				// move piece off nonempty the square
				p2.moveTo(null);
				assertEquals(null, board.getSquare(rank, file).getPiece());
				assertEquals(null, p2.getSquare());

				// move piece from one nonempty square to another an empty square
				p1.moveTo(board.getSquare(rank, file));
				previousSquare = board.getSquare(rank, file);
			}
		}
	}

	/**
	 * Test for toString
	 * 
	 * Returns the string for location and side
	 */
	@Test
	public void testToString() {
		ChessPiece p1 = new ChessPiece(true);
		assertEquals("location:null side:true", p1.toString());
	}
}
