package uwstout.courses.cs145.projects.chessgame;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test for Square class
 * 
 * Test for Square class
 * 
 * @author SchultzRachel
 * @version 2022.10.18
 */
public class SquareTest {

	/**
	 * Test for constructor Square(board, int, char)
	 * 
	 * Takes in a board, rank, and file and returns the correct rank, file, and null
	 * for piece
	 */
	@Test
	public void testSquareBoardIntChar() {
		Board b1 = new Board(2, 'a');
		Square s1 = new Square(b1, 1, 'a');
		assertEquals("1", 1, s1.getRank());
		assertEquals("a", 'a', s1.getFile());
		assertEquals("null", null, s1.getPiece());
	}

	/**
	 * Test for constructor Square(int, char)
	 * 
	 * Takes in rank and file and returns the correct rank and file
	 */
	@Test
	public void testSquareIntChar() {
		Square s1 = new Square(1, 'a');
		assertEquals("1", 1, s1.getRank());
		assertEquals("a", 'a', s1.getFile());

		Square s2 = new Square(0, 'a');
		assertEquals("0", 0, s2.getRank());
		assertEquals("a", 'a', s2.getFile());

		Square s3 = new Square(26, '.');
		assertEquals("26", 26, s3.getRank());
		assertEquals(".", '.', s3.getFile());
	}

	/**
	 * Test for getBoard
	 * 
	 * Returns null
	 */
	@Test
	public void testGetBoard() {
		Square s1 = new Square(1, 'a');
		assertEquals("null", null, s1.getBoard());
	}

	/**
	 * Test for getPiece
	 * 
	 * Returns null
	 */
	@Test
	public void testGetPiece() {
		Square s1 = new Square(1, 'a');
		assertEquals("null", null, s1.getPiece());
	}

	/**
	 * Test for setPiece
	 * 
	 * Sets the piece equal to piece
	 */
	@Test
	public void testSetPiece() {
		Square s1 = new Square(1, 'a');
		s1.setPiece(null);
		assertEquals(null, s1.getPiece());

		Square s2 = new Square(1, 'a');
		ChessPiece p1 = new ChessPiece(true);
		s2.setPiece(p1);
		assertEquals(true, s2.getPiece().isWhite());

		Square s3 = new Square(1, 'a');
		ChessPiece p2 = new ChessPiece(false);
		s3.setPiece(p2);
		assertEquals(true, s3.getPiece().isBlack());
	}

	/**
	 * Test for toString method
	 * 
	 * Takes in a square(rank, file) and returns the string <file><rank>
	 */
	@Test
	public void testToString() {
		Square s1 = new Square(1, 'a');
		assertEquals("a1", s1.toString());

		Square s2 = new Square(2, 'b');
		assertEquals("b2", s2.toString());
	}

}
