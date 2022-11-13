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

	@Test
	public void testToString() {
		ChessPiece p1 = new ChessPiece(true);
		assertEquals("", p1.toString());
	}

	@Test
	public void testGetType() {
		ChessPiece p1 = new ChessPiece(true);
		assertEquals(null, p1.getType());
	}

	@Test
	public void testGetPossibleMoves() {
		ChessPiece p1 = new ChessPiece(true);
		assertEquals(null, p1.getPossibleMoves());
	}

	@Test
	public void testCanMoveTo() {

		ChessPiece p1 = new ChessPiece(true);
		assertEquals(false, p1.canMoveTo(1, 'a'));

		ChessPiece p2 = new ChessPiece(true);
		Square s2 = new Square(1, 'a');
		p2.moveTo(s2);
		assertEquals(false, p2.canMoveTo(2, 'a'));

		Board b3 = new Board(1, 'a');
		ChessPiece p3 = new ChessPiece(true);
		p3.moveTo(b3.getSquare(1,'a'));
		assertEquals(false, p3.canMoveTo(0, 'a'));

		Board b4 = new Board(8, 'h');
		ChessPiece p4 = new ChessPiece(true);
		p4.moveTo(b4.getSquare(1,'a'));
		assertEquals(true, p4.canMoveTo(1, 'b'));

		Board b41 = new Board(8, 'h');
		Square s41 = new Square(b41, 1, 'a');
		ChessPiece p41 = new ChessPiece(false);
		p41.moveTo(s41);
		assertEquals(true, p41.canMoveTo(1, 'b'));

		Board b5 = new Board(8, 'h');
		ChessPiece p51 = new ChessPiece(true);
		p51.moveTo(b5.getSquare(1,'a'));
		ChessPiece p52 = new ChessPiece(false);
		p52.moveTo(b5.getSquare(1,'b'));
		assertEquals(true, p51.canMoveTo(1, 'b'));

	}

	@Test
	public void testCanMoveTo2() {
		ChessPiece knightW2 = new Knight(true);
		ChessPiece knightW1 = new Knight(true);

		Board board = new Board(8, 'h');
		knightW2.moveTo(board.getSquare(3, 'b'));

		assertFalse(knightW1.canMoveTo(0, 'c'));
		assertFalse(knightW1.canMoveTo(3, (char) 96));

		Board b2 = new Board(6, 'g');
		ChessPiece p61 = new ChessPiece(true);

		p61.moveTo(b2.getSquare(1, 'a'));
		ChessPiece p62 = new ChessPiece(true);
		p62.moveTo(b2.getSquare(1, 'b'));
		assertEquals(false, p61.canMoveTo(1, 'b'));
	}

	@Test
	public void testAddMove() {
		Board b5 = new Board(8, 'h');
		Square s51 = new Square(b5, 1, 'a');
		ChessPiece p51 = new ChessPiece(true);
		p51.moveTo(s51);
		Square s52 = new Square(b5, 1, 'b');
		ChessPiece p52 = new ChessPiece(false);
		p52.moveTo(s52);
		MoveList m = new MoveList();
		assertEquals(true, p51.addMove(m, 1, 'b'));

		Board b1 = new Board(8, 'h');
		Square s1 = new Square(b1, 1, 'a');
		ChessPiece p1 = new ChessPiece(true);
		p1.moveTo(s1);
		Square s2 = new Square(b5, 1, 'b');
		ChessPiece p2 = new ChessPiece(false);
		p2.moveTo(s2);
		MoveList m2 = new MoveList();
		assertEquals(false, p1.addMove(m2, 9, 'c'));

	}

}
